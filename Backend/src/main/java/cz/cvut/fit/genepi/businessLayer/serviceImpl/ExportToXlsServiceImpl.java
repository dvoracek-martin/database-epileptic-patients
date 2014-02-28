package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.service.ExportToXlsxService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.*;
import cz.cvut.fit.genepi.util.LoggingService;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static cz.cvut.fit.genepi.util.TimeConverter.getAgeAtTheBeginningOfEpilepsy;
import static cz.cvut.fit.genepi.util.TimeConverter.getCurrentAge;

// TODO: Auto-generated Javadoc

/**
 * The Class ExportToXlsServiceImpl.
 */

@Service
public class ExportToXlsServiceImpl implements ExportToXlsxService {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserService userService;

    private LoggingService logger = new LoggingService();

    /**
     * Create a library of cell styles
     */
    private static Map<String, CellStyle> createStyles(Workbook wb) {
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
        CellStyle style;
        Font titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short) 18);
        titleFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(titleFont);
        styles.put("title", style);

        Font monthFont = wb.createFont();
        monthFont.setFontHeightInPoints((short) 11);
        monthFont.setColor(IndexedColors.WHITE.getIndex());
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_50_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFont(monthFont);
        style.setWrapText(true);
        styles.put("header", style);

        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setWrapText(true);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        styles.put("cell", style);

        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
        styles.put("empty", style);

        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setWrapText(true);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
        styles.put("table", style);

        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setDataFormat(wb.createDataFormat().getFormat("0.00"));
        styles.put("emptyTable", style);

        return styles;
    }

    private String translateValue(String value, Locale locale) {
        if (value.equals("true"))
            return messageSource.getMessage("label.yes", null, locale);
        else if (value.equals("false"))
            return messageSource.getMessage("label.no", null, locale);
        else if (value.equals("null") || value.equals(null) || value.equals("") || value.equals("NA")) {
            return messageSource.getMessage("label.NA", null, locale);
        }

        return value;
    }

    private String translateComment(String value, Locale locale) {
        if (value.equals("null") || value.equals(null) || value.equals("") || value.equals("NA")) {
            return messageSource.getMessage("label.noComments", null, locale);
        }
        return value;
    }

    private static String getDate() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);
        reportDate = reportDate.replace(' ', '_');
        reportDate = reportDate.replace('/', '_');
        return reportDate;
    }


    public String export(java.util.List<PatientEntity> patientList,
                         UserEntity user, Locale locale, ExportParamsEntity exportParams, boolean anonymize) {

        Position p = new Position();

        logger.setLogger(ExportToTxtServiceImpl.class);
        String date = getDate();
        String name = date + ".xls";

        String downloadFolder = System.getProperty("user.home")
                + System.getProperty("file.separator") + "Download_Links"
                + System.getProperty("file.separator");
        File f = null;
        String os = System.getProperty("os.name").toLowerCase();
        if (os.indexOf("win") >= 0) {
            downloadFolder.replace("\\", "/");
            name = name.replace(":", "_");
            f = new File(downloadFolder + name);
            if (!f.getParentFile().exists())
                f.getParentFile().mkdirs();
            if (f.exists())
                f.delete();
            try {
                f.createNewFile();
            } catch (IOException e) {
                logger.logError(
                        "Couldn't create new file when trying to save xls file.",
                        e);
            }

        } else {
            downloadFolder = "/usr/local/tomcat/webapps/GENEPI/resources/downloads/";

            f = new File(downloadFolder + name);
            if (!f.getParentFile().exists())
                f.getParentFile().mkdirs();
            if (f.exists())
                f.delete();
            try {
                f.createNewFile();
            } catch (IOException e) {
                logger.logError(
                        "Couldn't create new file when trying to save xls file.",
                        e);
            }
        }

        // Blank workbook
        Workbook wb = new HSSFWorkbook();

        for (PatientEntity patient : patientList) {
            if (!anonymize) {
                Sheet sheet = wb.createSheet(patient.getContact().getLastName()
                        + " " + patient.getContact().getFirstName() + " "
                        + patient.getNin());
                this.addContent(patient, locale, exportParams, sheet, p, anonymize);
            } else {
                Sheet sheet = wb.createSheet(messageSource.getMessage("label.patient",
                        null, locale) + " ID " + Integer.toString(patient.getId()));
                this.addContent(patient, locale, exportParams, sheet, p, anonymize);
            }
        }
        // Write the output to a file
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(downloadFolder + name);
        } catch (FileNotFoundException e) {
            logger.logError("File wasn't found when trying to save xls file.",
                    e);
            e.printStackTrace();
        }
        try {
            wb.write(fileOut);
        } catch (IOException e) {
            logger.logError("IO Exception when trying to write to xls file.",
                    e);
            e.printStackTrace();
        }
        try {
            fileOut.close();
        } catch (IOException e) {
            logger.logError(
                    "File wasn't found when trying to close xls file.", e);
            e.printStackTrace();
        }

        return name;
    }

    private void addContent(PatientEntity patient, Locale locale,
                            ExportParamsEntity exportParams, Sheet sheet, Position p, boolean anonymize) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);

        Row headerRow = sheet.createRow(0);
        headerRow.setHeightInPoints(40);
        Cell headerCell;
        int i = 0;
        if (exportParams.isPatient()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.patient",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    0, //first row (0-based)
                    0, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(1);
            p.setCellcount(p.getCellcount() + 2);

            this.printOutPatientDetails(patient, locale,
                    exportParams, sheet, p, anonymize);
        }

        if (exportParams.isAnamnesis()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.anamnesis",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    0, //first row (0-based)
                    0, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++ //last column  (0-based)
            ));

            p.setRowcount(1);
            p.setCellcount(p.getCellcount() + 2);

            for (AnamnesisEntity anamnesis : patient.getAnamnesisList()) {
                //TODO: anamnesis has changed - ishistory???
                if (!anamnesis.isHistory())
                    this.printOutAnamnesis(patient, anamnesis, locale,
                            exportParams, sheet, p);
            }
        }

        if (exportParams.isSeizure()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.seizures",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    0, //first row (0-based)
                    0, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++ //last column  (0-based)
            ));


            p.setRowcount(1);
            p.setCellcount(p.getCellcount() + 2);

            for (SeizureEntity seizure : patient.getSeizureList()) {
                if (!seizure.isHidden())
                    this.printOutSeizure(patient, seizure, locale,
                            exportParams, sheet, p);
            }
        }
        if (exportParams.isPharmacotherapy()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.pharmacotherapy",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    0, //first row (0-based)
                    0, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(1);
            p.setCellcount(p.getCellcount() + 2);
            for (PharmacotherapyEntity pharmacotherapy : patient
                    .getPharmacotherapyList()) {
                if (!pharmacotherapy.isHidden())
                    this.printOutPharmacotherapy(patient,
                            pharmacotherapy, locale, exportParams, sheet, p);
            }
        }
        if (exportParams.isNeurologicalFinding()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.neurologicalFinding",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    0, //first row (0-based)
                    0, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(1);
            p.setCellcount(p.getCellcount() + 2);
            for (NeurologicalFindingEntity neurologicalFinding : patient
                    .getNeurologicalFindingList()) {
                if (!neurologicalFinding.isHidden())
                    this.printOutNeurologicalFinding(patient,
                            neurologicalFinding, locale, exportParams, sheet, p);
            }
        }
        if (exportParams.isNeuropsychology()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.neuropsychology",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    0, //first row (0-based)
                    0, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(1);
            p.setCellcount(p.getCellcount() + 2);
            for (NeuropsychologyEntity neuropsychology : patient
                    .getNeuropsychologyList()) {
                if (!neuropsychology.isHidden())
                    this.printOutNeuropsychology(patient,
                            neuropsychology, locale, exportParams, sheet, p);
            }
        }

        if (exportParams.isNeuropsychologyOld()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.neuropsychology",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    0, //first row (0-based)
                    0, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(1);
            p.setCellcount(p.getCellcount() + 2);
            for (NeuropsychologyOldEntity neuropsychologyOld : patient
                    .getNeuropsychologyOldList()) {
                if (!neuropsychologyOld.isHidden())
                    this.printOutNeuropsychologyOld(patient,
                            neuropsychologyOld, locale, exportParams, sheet, p);
            }
        }

        if (exportParams.isDiagnosticTestEEG()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.diagnosticTestScalpEeg",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    0, //first row (0-based)
                    0, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(1);
            p.setCellcount(p.getCellcount() + 2);
            for (DiagnosticTestScalpEegEntity diagnosticTestEEG : patient
                    .getDiagnosticTestScalpEegList()) {
                if (!diagnosticTestEEG.isHidden())
                    this.printOutDiagnosticTestEEG(patient,
                            diagnosticTestEEG, locale, exportParams, sheet, p);
            }
        }

        if (exportParams.isDiagnosticTestMRI()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.diagnosticTestScalpEeg",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    0, //first row (0-based)
                    0, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(1);
            p.setCellcount(p.getCellcount() + 2);
            for (DiagnosticTestMriEntity diagnosticTestMRI : patient
                    .getDiagnosticTestMRIList()) {
                if (!diagnosticTestMRI.isHidden())
                    this.printOutDiagnosticTestMRI(patient,
                            diagnosticTestMRI, locale, exportParams, sheet, p);
            }
        }

        if (exportParams.isInvasiveTestECOG()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.invasiveTestECoG",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    0, //first row (0-based)
                    0, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(1);
            p.setCellcount(p.getCellcount() + 2);
            for (InvasiveTestEcogEntity invasiveTestECOG : patient
                    .getInvasiveTestECOGList()) {
                if (!invasiveTestECOG.isHidden())
                    this.printOutInvasiveTestECOG(patient,
                            invasiveTestECOG, locale, exportParams, sheet, p);
            }
        }

        if (exportParams.isInvasiveTestEEG()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.invasiveTestIeeg",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    0, //first row (0-based)
                    0, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(1);
            p.setCellcount(p.getCellcount() + 2);
            for (InvasiveTestEegEntity invasiveTestEEG : patient
                    .getInvasiveTestEEGList()) {
                if (!invasiveTestEEG.isHidden())
                    this.printOutInvasiveTestEEG(patient,
                            invasiveTestEEG, locale, exportParams, sheet, p);
            }
        }

        if (exportParams.isInvasiveTestCorticalMapping()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.invasiveTestCorticalMapping",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    0, //first row (0-based)
                    0, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(1);
            p.setCellcount(p.getCellcount() + 2);
            for (InvasiveTestCorticalMappingEntity invasiveTestCorticalMappingEntity : patient
                    .getInvasiveTestCorticalMappingList()) {
                if (!invasiveTestCorticalMappingEntity.isHidden())
                    this.printOutInvasiveTestCorticalMapping(patient,
                            invasiveTestCorticalMappingEntity, locale,
                            exportParams, sheet, p);
            }
        }

        if (exportParams.isOperation()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.operation",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    0, //first row (0-based)
                    0, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(1);
            p.setCellcount(p.getCellcount() + 2);
            for (OperationEntity operation : patient.getOperationList()) {
                if (!operation.isHidden())
                    this.printOutOperation(patient, operation, locale,
                            exportParams, sheet, p);
            }
        }
        if (exportParams.isHistology()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.histology",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    0, //first row (0-based)
                    0, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(1);
            p.setCellcount(p.getCellcount() + 2);
            for (HistologyEntity histology : patient.getHistologyList()) {
                if (!histology.isHidden())
                    this.printOutHistology(patient, histology, locale,
                            exportParams, sheet, p);
            }
        }
        if (exportParams.isComplication()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.complication",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    0, //first row (0-based)
                    0, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(1);
            p.setCellcount(p.getCellcount() + 2);
            for (ComplicationEntity complication : patient
                    .getComplicationList()) {
                if (!complication.isHidden())
                    this.printOutComplication(patient, complication,
                            locale, exportParams, sheet, p);
            }
        }
        if (exportParams.isOutcome()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.outcome",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    0, //first row (0-based)
                    0, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(1);
            p.setCellcount(p.getCellcount() + 2);
            for (OutcomeEntity outcome : patient.getOutcomeList()) {
                //TODO: outcome cannot be hidden
              /*  if (!outcome.isHidden())
                  this.printOutOutcome(patient, outcome, locale,
                            exportParams, sheet, p);*/
            }
        }

        // makes cells a bit wider
        for (int k = 0; k != p.getCellcount() + 2; k++)
            sheet.setColumnWidth(k, 5000);
    }

    private void addCells(String firstValue, String secondValue, Sheet sheet, Locale locale, Map<String, CellStyle> styles, String style, Position p) {
        Row cellRow = sheet.getRow(p.getRowcount());
        if (cellRow == null)
            cellRow = sheet.createRow(p.getRowcount());
        p.setRowcount(p.getRowcount() + 1);

        Cell cellCell = cellRow.createCell(p.getCellcount());
        cellCell.setCellValue(messageSource.getMessage(firstValue, null,
                locale));
        cellCell.setCellStyle(styles.get(style));

        Cell cellCellTwo = cellRow.createCell(p.getCellcount() + 1);
        cellCellTwo.setCellValue(translateValue(
                String.valueOf(secondValue), locale));
        cellCellTwo.setCellStyle(styles.get(style));
    }


    private void printOutPatientDetails(PatientEntity patient, Locale locale,
                                        ExportParamsEntity exportParams, Sheet sheet, Position p, boolean anonymize) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());

        addCells("label.id", translateValue(String.valueOf(patient.getId()), locale), sheet, locale, styles, "cell", p);

        if (!anonymize) {
            if (exportParams.isContactFirstName()) {
                addCells("label.firstname", translateValue(String.valueOf(patient.getContact().getFirstName()), locale), sheet, locale, styles, "cell", p);
            }
        }
        if (!anonymize) {
            if (exportParams.isContactLastName()) {
                addCells("label.lastname", translateValue(String.valueOf(patient.getContact().getLastName()), locale), sheet, locale, styles, "cell", p);
            }
        }
        if (!anonymize) {
            if (exportParams.isPatientNin()) {
                addCells("label.nin", translateValue(String.valueOf(patient.getNin()), locale), sheet, locale, styles, "cell", p);
            }
        }
        if (exportParams.isPatientBirthday()) {
            addCells("label.birthdate", translateValue(String.valueOf(patient.getBirthday()), locale), sheet, locale, styles, "cell", p);
            addCells("label.age", translateValue(String.valueOf(getCurrentAge(patient)), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isPatientGender()) {
            addCells("label.gender", messageSource.getMessage("label.gender." + translateValue(String.valueOf(patient.getGender()), locale), null, locale), sheet, locale, styles, "cell", p);
        }
        if (!anonymize) {
            if (exportParams.isContactCountry()) {
                addCells("label.addressCountry", translateValue(String.valueOf(patient.getContact().getAddressCountry()), locale), sheet, locale, styles, "cell", p);
            }
        }
        if (!anonymize) {
            if (exportParams.isContactAddressCity()) {
                addCells("label.addressCity", translateValue(String.valueOf(patient.getContact().getAddressCity()), locale), sheet, locale, styles, "cell", p);
            }
        }
        if (!anonymize) {
            if (exportParams.isContactAddressStreet()) {
                addCells("label.street", translateValue(String.valueOf(patient.getContact().getAddressStreet()), locale), sheet, locale, styles, "cell", p);
            }
        }
        if (!anonymize) {
            if (exportParams.isContactAddressHn()) {
                addCells("label.addressHn", translateValue(String.valueOf(patient.getContact().getAddressHn()), locale), sheet, locale, styles, "cell", p);
            }
        }
        if (!anonymize) {
            if (exportParams.isContactPhoneNumber()) {
                addCells("label.telephone", translateValue(String.valueOf(patient.getContact().getPhoneNumber()), locale), sheet, locale, styles, "cell", p);
            }
        }
        if (!anonymize) {
            if (exportParams.isContactEmail()) {
                addCells("label.email", translateValue(String.valueOf(patient.getContact().getEmail()), locale), sheet, locale, styles, "cell", p);
            }
        }
        if (exportParams.isPatientAgeAtTheBeginningOfEpilepsy()) {
            addCells("label.ageAtTheBeginningOfEpilepsy", translateValue(String.valueOf(getAgeAtTheBeginningOfEpilepsy(patient)), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isPatientDoctorId()) {
            addCells("label.assignedDoctor", (translateValue(String.valueOf(userService.findByID(UserEntity.class, patient.getDoctorId()).getContact().getFirstName() + " " + userService.findByID(UserEntity.class, patient.getDoctorId()).getContact().getLastName()), locale)), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isPatientDoctorId()) {
            addCells("label.dateOfExport", (translateValue(String.valueOf(TimeConverter.getDate(Calendar.getInstance().getTime())), locale)), sheet, locale, styles, "cell", p);
        }
    }

    private void printOutAnamnesis(PatientEntity patient,
                                   AnamnesisEntity anamnesis, Locale locale,
                                   ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());

        if (p.getRowcount() > 1) {
            Row dateRow = sheet.getRow(p.getRowcount());
            if (dateRow == null)
                dateRow = sheet.createRow(p.getRowcount());

            Cell dateCell = dateRow.createCell(p.getCellcount());
            dateCell.setCellStyle(styles.get("empty"));
            sheet.addMergedRegion(new CellRangeAddress(
                    p.getRowcount(), //first row (0-based)
                    p.getRowcount(), //last row  (0-based)
                    p.getCellcount(), //first column (0-based)
                    p.getCellcount() + 1 //last column  (0-based)
            ));
            p.setRowcount(p.getRowcount() + 1);
        }

        Row dateRow = sheet.getRow(p.getRowcount());
        if (dateRow == null) {
            dateRow = sheet.createRow(p.getRowcount());
        }
        p.setRowcount(p.getRowcount() + 1);
        Cell dateCell = dateRow.createCell(p.getCellcount());
        dateCell.setCellValue(messageSource.getMessage("label.anamnesisFromDate", null,
                locale));
        dateCell.setCellStyle(styles.get("cell"));
        Cell dateCellTwo = dateRow.createCell(p.getCellcount() + 1);
        dateCellTwo.setCellValue(TimeConverter.getDate(anamnesis.getDate()));
        dateCellTwo.setCellStyle(styles.get("cell"));

        if (exportParams.isAnamnesisEpilepsyInFamily()) {
            addCells("label.epilepsyInFamily", translateValue(String.valueOf(anamnesis.isEpilepsyInFamily()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isAnamnesisParentalRisk()) {
            addCells("label.prenatalRisk", translateValue(
                    String.valueOf(anamnesis.isPrenatalRisk()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isAnamnesisFibrilConvulsions()) {

            addCells("label.fibrilConvulsions", translateValue(
                    String.valueOf(anamnesis.isFibrilConvulsions()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isAnamnesisInflammationCns()) {
            addCells("label.inflammationCns", translateValue(
                    String.valueOf(anamnesis.isInflammationCns()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isAnamnesisInjuryCns()) {

            addCells("label.injuryCns", translateValue(
                    String.valueOf(anamnesis.isInjuryCns()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isAnamnesisOperationCns()) {
            addCells("label.operationCns", translateValue(
                    String.valueOf(anamnesis.isOperationCns()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isAnamnesisEarlyPmdRetardation()) {
            addCells("label.earlyPmdRetardation", translateValue(
                    String.valueOf(anamnesis.isEarlyPmdRetardation()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isAnamnesisBeginningEpilepsy()) {
            addCells("label.beginningEpilepsy", translateValue(
                    TimeConverter.getDate(anamnesis.getBeginningEpilepsy()),
                    locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isAnamnesisFirstFever()) {
            addCells("label.firstFever", translateValue(
                    String.valueOf(anamnesis.isFirstFever()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isAnamnesisInfantileSpasm()) {
            addCells("label.infantileSpasm", translateValue(
                    String.valueOf(anamnesis.isInfantileSpasm()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isAnamnesisSpecificSyndrome()) {
            addCells("label.epilepticSyndrome", messageSource.getMessage("label.specificSyndrome." +
                    String.valueOf(anamnesis.getSpecificSyndrome()), null, locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isAnamnesisNonCnsComorbidity() && !anamnesis.getNonCnsComorbidity().equals("0")) {
            addCells("label.nonCnsComorbidity", translateValue(
                    String.valueOf(anamnesis.getNonCnsComorbidity()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isAnamnesisComment()) {
            addCells("label.comment", translateComment(
                    String.valueOf(anamnesis.getComment()), locale), sheet, locale, styles, "cell", p);
        }
    }


    private void printOutSeizure(PatientEntity patient,
                                 SeizureEntity seizure, Locale locale,
                                 ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());

        if (p.getRowcount() > 1) {
            Row dateRow = sheet.getRow(p.getRowcount());
            if (dateRow == null)
                dateRow = sheet.createRow(p.getRowcount());

            Cell dateCell = dateRow.createCell(p.getCellcount());
            dateCell.setCellStyle(styles.get("empty"));
            sheet.addMergedRegion(new CellRangeAddress(
                    p.getRowcount(),
                    p.getRowcount(),
                    p.getCellcount(),
                    p.getCellcount() + 1
            ));

            p.setRowcount(p.getRowcount() + 1);
        }

        Row dateRow = sheet.getRow(p.getRowcount());
        if (dateRow == null)
            sheet.createRow(p.getRowcount());

        p.setRowcount(p.getRowcount() + 1);
        Cell dateCell = dateRow.createCell(p.getCellcount());
        dateCell.setCellValue(messageSource.getMessage("label.seizures", null,
                locale) + " " + messageSource.getMessage("label.fromDate", null,
                locale));
        dateCell.setCellStyle(styles.get("cell"));

        Cell dateCellTwo = dateRow.createCell(p.getCellcount() + 1);
        dateCellTwo.setCellValue(TimeConverter.getDate(seizure.getDate()));
        dateCellTwo.setCellStyle(styles.get("cell"));

        if (exportParams.isSeizureFrequency()) {
            addCells("label.seizureFrequency", translateValue(messageSource.getMessage("label.seizureFrequency." +
                    String.valueOf(seizure.getSeizureFrequency()), null, locale), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isSeizureSecondarilyGeneralizedSeizure()) {
            addCells("label.secondarilyGeneralizedSeizure", translateValue(String.valueOf(seizure.isSecondarilyGeneralizedSeizure()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isSeizureStatusEpilepticus()) {
            addCells("label.stausEpilepticus", translateValue(String.valueOf(seizure.isStatusEpilepticus()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isSeizureComment()) {
            addCells("label.comment", translateComment(String.valueOf(seizure.getComment()), locale), sheet, locale, styles, "cell", p);
        }
        for (SeizureDetailEntity seizureDetail : seizure.getSeizureDetailList()) {
            //add empty line
            if ((seizureDetail != seizure.getSeizureDetailList().get(0)) && p.getRowcount() > 2 && seizure.getSeizureDetailList().size() > 0 && (exportParams.isSeizureSSCClassification() || exportParams.isSeizureILAEClassification() || exportParams.isSeizureDetailComment())) {
                Row tableRow = sheet.getRow(p.getRowcount());
                if (tableRow == null)
                    tableRow = sheet.createRow(p.getRowcount());

                Cell tableCell = tableRow.createCell(p.getCellcount());
                tableCell.setCellStyle(styles.get("emptyTable"));
                sheet.addMergedRegion(new CellRangeAddress(
                        p.getRowcount(),
                        p.getRowcount(),
                        p.getCellcount(),
                        p.getCellcount() + 1
                ));

                p.setRowcount(p.getRowcount() + 1);
            }
            if (exportParams.isSeizureSSCClassification()) {
                addCells("label.sscClassification", translateValue(messageSource.getMessage("label.sscClassification." +
                        String.valueOf(seizureDetail.getSscClassification()), null, locale), locale), sheet, locale, styles, "table", p);
            }
            if (exportParams.isSeizureILAEClassification()) {
                addCells("label.ilaeClassification", translateValue(messageSource.getMessage("label.ilaeClassification." +
                        String.valueOf(seizureDetail.getIlaeClassification()), null, locale), locale), sheet, locale, styles, "table", p);
            }
            if (exportParams.isSeizureDetailComment()) {
                addCells("label.comment", translateComment(String.valueOf(seizureDetail.getComment()), locale), sheet, locale, styles, "table", p);
            }
        }
    }

    private void printOutPharmacotherapy(PatientEntity patient,
                                         PharmacotherapyEntity pharmacotherapy, Locale locale,
                                         ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 1) {
            Row dateRow = sheet.getRow(p.getRowcount());
            if (dateRow == null) dateRow = sheet.createRow(p.getRowcount());
            Cell dateCell = dateRow.createCell(p.getCellcount());
            dateCell.setCellStyle(styles.get("empty"));
            sheet.addMergedRegion(new CellRangeAddress(p.getRowcount(), p.getRowcount(), p.getCellcount(), p.getCellcount() + 1));
            p.setRowcount(p.getRowcount() + 1);
        }
        Row dateRow = sheet.getRow(p.getRowcount());
        if (dateRow == null) sheet.createRow(p.getRowcount());
        p.setRowcount(p.getRowcount() + 1);
        Cell dateCell = dateRow.createCell(p.getCellcount());
        dateCell.setCellValue(messageSource.getMessage("label.pharmacotherapy", null, locale) + " " + messageSource.getMessage("label.fromDate", null, locale));
        dateCell.setCellStyle(styles.get("cell"));
        Cell dateCellTwo = dateRow.createCell(p.getCellcount() + 1);
        dateCellTwo.setCellValue(TimeConverter.getDate(pharmacotherapy.getDate()));
        dateCellTwo.setCellStyle(styles.get("cell"));
        if (exportParams.isPharmacotherapyAED()) {
            addCells("label.aed", translateValue(messageSource.getMessage("label.aed." +
                    String.valueOf(pharmacotherapy.getAed()), null, locale), locale), sheet, locale, styles, "table", p);
        }
        if (exportParams.isPharmacotherapyEffective()) {
            addCells("label.efficiency", translateValue(messageSource.getMessage("label.efficiency." +
                    String.valueOf(pharmacotherapy.getEfficiency()), null, locale), locale), sheet, locale, styles, "table", p);
        }
        if (exportParams.isPharmacotherapyDuringSurgery()) {
            addCells("label.duringSurgery", translateValue(String.valueOf(pharmacotherapy.isDuringSurgery()), locale), sheet, locale, styles, "table", p);
        }
        if (exportParams.isPharmacotherapyComment()) {
            addCells("label.comment", translateComment(String.valueOf(pharmacotherapy.getComment()), locale), sheet, locale, styles, "table", p);
        }
    }

    private void printOutNeurologicalFinding(PatientEntity patient,
                                             NeurologicalFindingEntity neurologicalFinding, Locale locale,
                                             ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 1) {
            Row dateRow = sheet.getRow(p.getRowcount());
            if (dateRow == null) dateRow = sheet.createRow(p.getRowcount());
            Cell dateCell = dateRow.createCell(p.getCellcount());
            dateCell.setCellStyle(styles.get("empty"));
            sheet.addMergedRegion(new CellRangeAddress(p.getRowcount(), p.getRowcount(), p.getCellcount(), p.getCellcount() + 1));
            p.setRowcount(p.getRowcount() + 1);
        }
        Row dateRow = sheet.getRow(p.getRowcount());
        if (dateRow == null) sheet.createRow(p.getRowcount());
        p.setRowcount(p.getRowcount() + 1);
        Cell dateCell = dateRow.createCell(p.getCellcount());
        dateCell.setCellValue(messageSource.getMessage("label.neurologicalFinding", null, locale) + " " + messageSource.getMessage("label.fromDate", null, locale));
        dateCell.setCellStyle(styles.get("cell"));
        Cell dateCellTwo = dateRow.createCell(p.getCellcount() + 1);
        dateCellTwo.setCellValue(TimeConverter.getDate(neurologicalFinding.getDate()));
        dateCellTwo.setCellStyle(styles.get("cell"));
        if (exportParams.isNeurologicalFindingHemisphereDominance()) {
            addCells("label.hemisphereDominance", translateValue(messageSource.getMessage("label.hemisphereDominance." +
                    String.valueOf(neurologicalFinding.getHemisphereDominance()), null, locale), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isNeurologicalFindingAbnormalNeurologicalFinding()) {
            addCells("label.abnormalNeurologicalFinding", translateValue(String.valueOf(neurologicalFinding.isAbnormalNeurologicalFinding()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isNeurologicalFindingHemiparesis()) {
            addCells("label.hemiparesis", translateValue(String.valueOf(neurologicalFinding.isHemiparesis()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isNeurologicalFindingVisualFieldDefects()) {
            addCells("label.visualFieldDefect", translateValue(String.valueOf(neurologicalFinding.isVisualFieldDefects()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isNeurologicalFindingComment()) {
            addCells("label.comment", translateComment(String.valueOf(neurologicalFinding.getComment()), locale), sheet, locale, styles, "cell", p);
        }
    }

    private void printOutNeuropsychology(PatientEntity patient,
                                         NeuropsychologyEntity neuropsychology, Locale locale,
                                         ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 1) {
            Row dateRow = sheet.getRow(p.getRowcount());
            if (dateRow == null) dateRow = sheet.createRow(p.getRowcount());
            Cell dateCell = dateRow.createCell(p.getCellcount());
            dateCell.setCellStyle(styles.get("empty"));
            sheet.addMergedRegion(new CellRangeAddress(p.getRowcount(), p.getRowcount(), p.getCellcount(), p.getCellcount() + 1));
            p.setRowcount(p.getRowcount() + 1);
        }
        Row dateRow = sheet.getRow(p.getRowcount());
        if (dateRow == null) sheet.createRow(p.getRowcount());
        p.setRowcount(p.getRowcount() + 1);
        Cell dateCell = dateRow.createCell(p.getCellcount());
        dateCell.setCellValue(messageSource.getMessage("label.neuropsychology", null, locale) + " " + messageSource.getMessage("label.fromDate", null, locale));
        dateCell.setCellStyle(styles.get("cell"));
        Cell dateCellTwo = dateRow.createCell(p.getCellcount() + 1);
        dateCellTwo.setCellValue(TimeConverter.getDate(neuropsychology.getDate()));
        dateCellTwo.setCellStyle(styles.get("cell"));
        if (exportParams.isNeuropsychologyIntellect()) {
            addCells("label.intellect", translateValue(messageSource.getMessage("label.intellect." +
                    String.valueOf(neuropsychology.getIntellect()), null, locale), locale), sheet, locale, styles, "cell", p);
        }

        if (neuropsychology.getIntellect() == 1) {
            if (exportParams.isNeuropsychologyNeurodevelopmentalExamination()) {
                addCells("label.neurodevelopmentalExamination", translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExamination()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationAdaptability()) {
                addCells("label.adaptability", translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationAdaptability()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationSpeechExpressively()) {
                addCells("label.speechExpressively", translateValue(messageSource.getMessage("label.speechExpressively." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSpeechExpressively()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationSpeechReceptively()) {
                addCells("label.speechReceptively", translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSpeechReceptively()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationFineMotorSkills()) {
                addCells("label.fineMotorSkills", translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationFineMotorSkills()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationGrossMotorSkills()) {
                addCells("label.grossMotorSkills", translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationGrossMotorSkills()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationSocialBehavior()) {
                addCells("label.socialBehavior", translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSocialBehavior()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
        }

        if (neuropsychology.getIntellect() == 2) {
            if (exportParams.isNeuropsychologyIntellectualPerformance()) {
                addCells("label.intellectualPerformance", translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getIntellectualPerformance()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isNeuropsychologyIntellectualPerformanceVerbally()) {
                addCells("label.intellectualPerformanceVerbally", translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getIntellectualPerformanceVerbally()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams
                    .isNeuropsychologyIntellectualPerformanceNonverbalAbstraction()) {
                addCells("label.intellectualPerformanceNonverbalAbstraction", translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getIntellectualPerformanceNonverbalAbstraction()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams
                    .isNeuropsychologyIntellectualPerformanceNonverbalDesignCap()) {
                addCells("label.intellectualPerformanceNonverbalDesignCapabilities", translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getIntellectualPerformanceNonverbalDesignCapabilities()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isNeuropsychologyNeuropsychologicalProfile()) {
                addCells("label.neuropsychologicalProfile", translateValue(messageSource.getMessage("label.neuropsychologicalProfile." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfile()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (neuropsychology.getNeuropsychologicalProfile() == 1) {
                if (exportParams.isNeuropsychologyNeuropsychologicalProfileAttention()) {
                    addCells("label.attention", translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileAttention()), null, locale), locale), sheet, locale, styles, "cell", p);
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfileCognitiveSpeed()) {
                    addCells("label.cognitiveSpeed", translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileCognitiveSpeed()), null, locale), locale), sheet, locale, styles, "cell", p);
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfileExecutiveFunction()) {
                    addCells("label.executiveFunction", translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileExecutiveFunction()), null, locale), locale), sheet, locale, styles, "cell", p);
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfileSpeechExpressively()) {
                    addCells("label.speechExpressively", translateValue(messageSource.getMessage("label.speechExpressively." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileSpeechExpressively()), null, locale), locale), sheet, locale, styles, "cell", p);
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfileSpeechUnderstanding()) {
                    addCells("label.speechUnderstanding", translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileSpeechUnderstanding()), null, locale), locale), sheet, locale, styles, "cell", p);
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfileMemoryOperating()) {
                    addCells("label.memoryOperating", translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryOperating()), null, locale), locale), sheet, locale, styles, "cell", p);
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfileMemoryVerbal()) {
                    addCells("label.memoryVerbal", translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryVerbal()), null, locale), locale), sheet, locale, styles, "cell", p);
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfileMemoryNonverbal()) {
                    addCells("label.memoryNonverbal", translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryNonverbal()), null, locale), locale), sheet, locale, styles, "cell", p);
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfileMemoryLearning()) {
                    addCells("label.memoryLearning", translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryLearning()), null, locale), locale), sheet, locale, styles, "cell", p);
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfilePerceptionSpeech()) {
                    addCells("label.perceptionSpeech", translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionSpeech()), null, locale), locale), sheet, locale, styles, "cell", p);
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfilePerceptionVisual()) {
                    addCells("label.perceptionVisual", translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionVisual()), null, locale), locale), sheet, locale, styles, "cell", p);
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfilePerceptionSpatial()) {
                    addCells("label.perceptionSpatial", translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionSpatial()), null, locale), locale), sheet, locale, styles, "cell", p);
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfileMotorSkillsDexterity()) {
                    addCells("label.motorSkillsDexterity", translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileMotorSkillsDexterity()), null, locale), locale), sheet, locale, styles, "cell", p);
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfileMotorCoordination()) {
                    addCells("label.motorCoordination", translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileMotorCoordination()), null, locale), locale), sheet, locale, styles, "cell", p);
                }
            }
            if (exportParams.isNeuropsychologyPresenceOfChanges()) {
                addCells("label.presenceOfChanges", translateValue(messageSource.getMessage("label.presenceOfChanges." +
                        String.valueOf(neuropsychology.getPresenceOfChanges()), null, locale), locale), sheet, locale, styles, "cell", p);
            }

            if (neuropsychology.getPresenceOfChanges() == 0) {
                if (exportParams.isNeuropsychologyPresenceOfChangesDetail()) {
                    addCells("label.presenceOfChangesDetail", translateValue(messageSource.getMessage("label.presenceOfChanges." +
                            String.valueOf(neuropsychology.getPresenceOfChanges()), null, locale), locale), sheet, locale, styles, "cell", p);
                }
            }

            if (exportParams.isNeuropsychologyEmotionalStatus()) {
                addCells("label.emotionalState", translateValue(messageSource.getMessage("label.emotionalState." +
                        String.valueOf(neuropsychology.getEmotionalStatus()), null, locale), locale), sheet, locale, styles, "cell", p);
            }

            if (exportParams.isNeuropsychologyComment()) {
                addCells("label.comment", translateComment(String.valueOf(neuropsychology.getComment()), locale), sheet, locale, styles, "cell", p);
            }
        }
    }

    private void printOutNeuropsychologyOld(PatientEntity patient,
                                            NeuropsychologyOldEntity neuropsychologyOld, Locale locale,
                                            ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 1) {
            Row dateRow = sheet.getRow(p.getRowcount());
            if (dateRow == null) dateRow = sheet.createRow(p.getRowcount());
            Cell dateCell = dateRow.createCell(p.getCellcount());
            dateCell.setCellStyle(styles.get("empty"));
            sheet.addMergedRegion(new CellRangeAddress(p.getRowcount(), p.getRowcount(), p.getCellcount(), p.getCellcount() + 1));
            p.setRowcount(p.getRowcount() + 1);
        }
        Row dateRow = sheet.getRow(p.getRowcount());
        if (dateRow == null) sheet.createRow(p.getRowcount());
        p.setRowcount(p.getRowcount() + 1);
        Cell dateCell = dateRow.createCell(p.getCellcount());
        dateCell.setCellValue(messageSource.getMessage("label.neuropsychologyOld", null, locale) + " " + messageSource.getMessage("label.fromDate", null, locale));
        dateCell.setCellStyle(styles.get("cell"));
        Cell dateCellTwo = dateRow.createCell(p.getCellcount() + 1);
        dateCellTwo.setCellValue(TimeConverter.getDate(neuropsychologyOld.getDate()));
        dateCellTwo.setCellStyle(styles.get("cell"));
        if (exportParams.isNeuropsychologyOldNeuropsychologicalExamination()) {
            addCells("label.neuropsychologicalExamination", translateValue(String.valueOf(neuropsychologyOld.isNeuropsychologicalExamination()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isNeuropsychologyOldIntelligenceLevel()) {
            addCells("label.intelligenceLevel", translateValue(String.valueOf(neuropsychologyOld.getIntelligenceLevel()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isNeuropsychologyOldSpecificLearning()) {
            addCells("label.specificLearning", translateValue(String.valueOf(neuropsychologyOld.isSpecificLearning()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isNeuropsychologyOldDevelopmentalLanguageDisorders()) {
            addCells("label.developmentalLanguageDisorders", translateValue(String.valueOf(neuropsychologyOld.isDevelopmentalLanguageDisorders()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isNeuropsychologyOldAdhdSyndrome()) {
            addCells("label.adhdSyndrome", translateValue(String.valueOf(neuropsychologyOld.isAdhdSyndrome()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isNeuropsychologyOldComment()) {
            addCells("label.comment", translateComment(String.valueOf(neuropsychologyOld.getComment()), locale), sheet, locale, styles, "cell", p);
        }
    }

    private void printOutDiagnosticTestEEG(PatientEntity patient,
                                           DiagnosticTestScalpEegEntity diagnosticTestScalpEEG, Locale locale,
                                           ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 1) {
            Row dateRow = sheet.getRow(p.getRowcount());
            if (dateRow == null) dateRow = sheet.createRow(p.getRowcount());
            Cell dateCell = dateRow.createCell(p.getCellcount());
            dateCell.setCellStyle(styles.get("empty"));
            sheet.addMergedRegion(new CellRangeAddress(p.getRowcount(), p.getRowcount(), p.getCellcount(), p.getCellcount() + 1));
            p.setRowcount(p.getRowcount() + 1);
        }
        Row dateRow = sheet.getRow(p.getRowcount());
        if (dateRow == null) sheet.createRow(p.getRowcount());
        p.setRowcount(p.getRowcount() + 1);
        Cell dateCell = dateRow.createCell(p.getCellcount());
        dateCell.setCellValue(messageSource.getMessage("label.diagnosticTestScalpEeg", null, locale) + " " + messageSource.getMessage("label.fromDate", null, locale));
        dateCell.setCellStyle(styles.get("cell"));
        Cell dateCellTwo = dateRow.createCell(p.getCellcount() + 1);
        dateCellTwo.setCellValue(TimeConverter.getDate(diagnosticTestScalpEEG.getDate()));
        dateCellTwo.setCellStyle(styles.get("cell"));

        if (exportParams.isDiagnosticTestEEGDone()) {
            addCells("label.ieegDone", translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(diagnosticTestScalpEEG.getDone()), null, locale), locale), sheet, locale, styles, "cell", p);
        }
        if (diagnosticTestScalpEEG.getDone() == 2) {
            if (exportParams.isDiagnosticTestEEGBasicActivity()) {
                addCells("label.basicEegActivity", translateValue(messageSource.getMessage("label.basicEegActivity." +
                        String.valueOf(diagnosticTestScalpEEG.getBasicEegActivity()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestEEGSlow()) {
                addCells("label.eegSlow", translateValue(messageSource.getMessage("label.eegSlow." +
                        String.valueOf(diagnosticTestScalpEEG.getEegSlow()), null, locale), locale), sheet, locale, styles, "cell", p);
            }

            if (exportParams.isDiagnosticTestEEGInterictalEEGSpikes()) {
                addCells("label.interictalEegSpikes", translateValue(messageSource.getMessage("label.interictalEegSpikes." +
                        String.valueOf(diagnosticTestScalpEEG.getInterictalEegSpikes()), null, locale), locale), sheet, locale, styles, "cell", p);
            }

            if (exportParams.isDiagnosticTestEEGLocalizationInerictalEEGSpikes()) {
                addCells("label.localizationInvasiveEegInterictalSpikes", translateValue(String.valueOf(diagnosticTestScalpEEG.getLocalizationInterictalEegSpikes()), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestEEGStatusEpilepticus()) {
                addCells("label.EegStatusEpilepticus", translateValue(String.valueOf(diagnosticTestScalpEEG.isEegStatusEpilepticus()), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestEEGSecondarySidedSynchrony()) {
                addCells("label.secondarySidedSynchrony", translateValue(String.valueOf(diagnosticTestScalpEEG.isSecondarySidedSynchrony()), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestEEGIctalEEGPatterns()) {
                addCells("label.invasiveIctalEegPatterns", translateValue(messageSource.getMessage("label.ecogPatterns." +
                        String.valueOf(diagnosticTestScalpEEG.getIctalEegPatterns()), null, locale), locale), sheet, locale, styles, "cell", p);
            }

            if (exportParams.isDiagnosticTestEEGDescriptionVideoEEG()) {
                addCells("label.descriptionVideoEeg", translateValue(String.valueOf(diagnosticTestScalpEEG.getDescriptionVideoEeg()), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestEEGComment()) {
                addCells("label.comment", translateComment(String.valueOf(diagnosticTestScalpEEG.getComment()), locale), sheet, locale, styles, "cell", p);
            }
        }
    }

    private void printOutDiagnosticTestMRI(PatientEntity patient,
                                           DiagnosticTestMriEntity diagnosticTestScalpMRI, Locale locale,
                                           ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 1) {
            Row dateRow = sheet.getRow(p.getRowcount());
            if (dateRow == null) dateRow = sheet.createRow(p.getRowcount());
            Cell dateCell = dateRow.createCell(p.getCellcount());
            dateCell.setCellStyle(styles.get("empty"));
            sheet.addMergedRegion(new CellRangeAddress(p.getRowcount(), p.getRowcount(), p.getCellcount(), p.getCellcount() + 1));
            p.setRowcount(p.getRowcount() + 1);
        }
        Row dateRow = sheet.getRow(p.getRowcount());
        if (dateRow == null) sheet.createRow(p.getRowcount());
        p.setRowcount(p.getRowcount() + 1);
        Cell dateCell = dateRow.createCell(p.getCellcount());
        dateCell.setCellValue(messageSource.getMessage("label.diagnosticTestsMri", null, locale) + " " + messageSource.getMessage("label.fromDate", null, locale));
        dateCell.setCellStyle(styles.get("cell"));
        Cell dateCellTwo = dateRow.createCell(p.getCellcount() + 1);
        dateCellTwo.setCellValue(TimeConverter.getDate(diagnosticTestScalpMRI.getDate()));
        dateCellTwo.setCellStyle(styles.get("cell"));

        if (exportParams.isDiagnosticTestMRIDone()) {
            addCells("label.mri_done", translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(diagnosticTestScalpMRI.getDone()), null, locale), locale), sheet, locale, styles, "cell", p);
        }
        if (diagnosticTestScalpMRI.getDone() == 2) {
            if (exportParams.isDiagnosticTestMRIFinding()) {
                addCells("label.MRIFindingf", translateValue(messageSource.getMessage("label.resultType." +
                        String.valueOf(diagnosticTestScalpMRI.getMriFinding()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestMRIDescription()) {
                addCells("label.descriptionMri", translateValue(String.valueOf(diagnosticTestScalpMRI.getMriDescription()), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestMRIFdgPet()) {
                addCells("label.fdgPet", translateValue(messageSource.getMessage("label.resultType." +
                        String.valueOf(diagnosticTestScalpMRI.getFdgPet()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestMRIDescriptionPetHypometabolism()) {
                addCells("label.descriptionPetHypometabolism", translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionPetHypometabolism()), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestMRIInterictalSpect()) {
                addCells("label.ictalSpect", translateValue(messageSource.getMessage("label.resultType." +
                        String.valueOf(diagnosticTestScalpMRI.getInterictalSpect()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestMRIDescriptionSpectHypoperfuse()) {
                addCells("label.descriptionSpectHypoperfuse", translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionSpectHypoperfuse()), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestMRIIctalSpect()) {
                addCells("label.ictalSpect", translateValue(messageSource.getMessage("label.resultType." +
                        String.valueOf(diagnosticTestScalpMRI.getIctalSpect()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestMRIDescriptionSpectHyperperfuse()) {
                addCells("label.descriptionSpectHyperperfuse", translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionSpectHyperperfuse()), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestMRISiscom()) {
                addCells("label.siscom", translateValue(String.valueOf(diagnosticTestScalpMRI.isSiscom()), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestMRIMrsProtocol()) {
                addCells("label.mrsProtocol", translateValue(messageSource.getMessage("label.mrsProtocol." +
                        String.valueOf(diagnosticTestScalpMRI.getMrsProtocol()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestMRIMrsFinding()) {
                addCells("label.mrsFinding", translateValue(messageSource.getMessage("label.resultType." +
                        String.valueOf(diagnosticTestScalpMRI.getMrsFinding()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestMRIDescriptionMrsAbnormality()) {
                addCells("label.descriptionMrsAbnormality", translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionMrsAbnormality()), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestMRIFmri()) {
                addCells("label.fmri", translateValue(String.valueOf(diagnosticTestScalpMRI.isFmri()), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestMRIDetailsFmri()) {
                addCells("label.fmriDetails", translateValue(String.valueOf(diagnosticTestScalpMRI.getDetailsFmri()), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestMRIDti()) {
                addCells("label.dti", translateValue(String.valueOf(diagnosticTestScalpMRI.isDti()), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestMRIDetailsDtiStudy()) {
                addCells("label.dtiStudyDetails", translateValue(String.valueOf(diagnosticTestScalpMRI.getDetailsDtiStudy()), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestMRIWada()) {
                addCells("label.wada", translateValue(String.valueOf(diagnosticTestScalpMRI.isWada()), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isDiagnosticTestMRIDetailsWada()) {
                addCells("label.wadaDetails", translateValue(String.valueOf(diagnosticTestScalpMRI.getDetailsWada()), locale), sheet, locale, styles, "cell", p);
            }
        }
        if (exportParams.isDiagnosticTestMRIComment()) {
            addCells("label.comment", translateComment(String.valueOf(diagnosticTestScalpMRI.getComment()), locale), sheet, locale, styles, "cell", p);
        }

    }

    private void printOutInvasiveTestECOG(PatientEntity patient,
                                          InvasiveTestEcogEntity invasiveTestECOG, Locale locale,
                                          ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 1) {
            Row dateRow = sheet.getRow(p.getRowcount());
            if (dateRow == null) dateRow = sheet.createRow(p.getRowcount());
            Cell dateCell = dateRow.createCell(p.getCellcount());
            dateCell.setCellStyle(styles.get("empty"));
            sheet.addMergedRegion(new CellRangeAddress(p.getRowcount(), p.getRowcount(), p.getCellcount(), p.getCellcount() + 1));
            p.setRowcount(p.getRowcount() + 1);
        }
        Row dateRow = sheet.getRow(p.getRowcount());
        if (dateRow == null) sheet.createRow(p.getRowcount());
        p.setRowcount(p.getRowcount() + 1);
        Cell dateCell = dateRow.createCell(p.getCellcount());
        dateCell.setCellValue(messageSource.getMessage("label.invasiveTestECOG", null, locale) + " " + messageSource.getMessage("label.fromDate", null, locale));
        dateCell.setCellStyle(styles.get("cell"));
        Cell dateCellTwo = dateRow.createCell(p.getCellcount() + 1);
        dateCellTwo.setCellValue(TimeConverter.getDate(invasiveTestECOG.getDate()));
        dateCellTwo.setCellStyle(styles.get("cell"));

        if (exportParams.isInvasiveTestECOGDone()) {
            addCells("label.ecogDone", translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(invasiveTestECOG.getDone()), null, locale), locale), sheet, locale, styles, "cell", p);
        }
        if (invasiveTestECOG.getDone() == 2) {
            if (exportParams.isInvasiveTestECOGEcogCover()) {
                addCells("label.ecogCover", translateValue(String.valueOf(invasiveTestECOG.getEcogCover()), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isInvasiveTestECOGEcogPatterns()) {
                addCells("label.ecogPatterns", translateValue(messageSource.getMessage("label.ecogPatterns." +
                        String.valueOf(invasiveTestECOG.getEcogPatterns()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isInvasiveTestECOGAfterResectionEcog()) {
                addCells("label.ecogAfterResection", translateValue(messageSource.getMessage("label.ecogPatterns." +
                        String.valueOf(invasiveTestECOG.getAfterResectionEcog()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isInvasiveTestECOGComment()) {
                addCells("label.comment", translateComment(String.valueOf(invasiveTestECOG.getComment()), locale), sheet, locale, styles, "cell", p);
            }
        }
    }

    private void printOutInvasiveTestEEG(PatientEntity patient,
                                         InvasiveTestEegEntity invasiveTestEEG, Locale locale,
                                         ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 1) {
            Row dateRow = sheet.getRow(p.getRowcount());
            if (dateRow == null) dateRow = sheet.createRow(p.getRowcount());
            Cell dateCell = dateRow.createCell(p.getCellcount());
            dateCell.setCellStyle(styles.get("empty"));
            sheet.addMergedRegion(new CellRangeAddress(p.getRowcount(), p.getRowcount(), p.getCellcount(), p.getCellcount() + 1));
            p.setRowcount(p.getRowcount() + 1);
        }
        Row dateRow = sheet.getRow(p.getRowcount());
        if (dateRow == null) sheet.createRow(p.getRowcount());
        p.setRowcount(p.getRowcount() + 1);
        Cell dateCell = dateRow.createCell(p.getCellcount());
        dateCell.setCellValue(messageSource.getMessage("label.invasiveTestIeeg", null, locale) + " " + messageSource.getMessage("label.fromDate", null, locale));
        dateCell.setCellStyle(styles.get("cell"));
        Cell dateCellTwo = dateRow.createCell(p.getCellcount() + 1);
        dateCellTwo.setCellValue(TimeConverter.getDate(invasiveTestEEG.getDate()));
        dateCellTwo.setCellStyle(styles.get("cell"));

        if (exportParams.isInvasiveTestEEGDone()) {
            addCells("label.ieegDone", translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(invasiveTestEEG.getDone()), null, locale), locale), sheet, locale, styles, "cell", p);
        }
        if (invasiveTestEEG.getDone() == 1) {
            if (exportParams.isInvasiveTestEEGIntracranialElectrodes()) {
                addCells("label.intracranialElectrodes", translateValue(messageSource.getMessage("label.intracranialElectrodes." +
                        String.valueOf(invasiveTestEEG.getIntracranialElectrodes()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isInvasiveTestEEGLocalizationIntracranialElectrodes()) {
                addCells("label.localizationIntracranialElectrodes", translateValue(String.valueOf(invasiveTestEEG.getLocalizationIntracranialElectrodes()), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isInvasiveTestEEGInvasiveEEGSlow()) {
                addCells("label.invasiveEegSlowing", translateValue(messageSource.getMessage("label.eegSlow." +
                        String.valueOf(invasiveTestEEG.getDone()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isInvasiveTestEEGInvasiveEEGInterictalSpikes()) {
                addCells("label.invasiveEegInterictalSpikes", translateValue(messageSource.getMessage("label.interictalEegSpikes." +
                        String.valueOf(invasiveTestEEG.getInvasiveEegInterictalSpikes()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams
                    .isInvasiveTestEEGLocalizationInvasiveEEGInterictalSpikes()) {
                addCells("label.localizationInvasiveEegInterictalSpikes", translateValue(String.valueOf(invasiveTestEEG.getLocalizationInvasiveEegInterictalSpikes()), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isInvasiveTestEEGStatusEpilepticus()) {
                addCells("label.EegStatusEpilepticus", translateValue(String.valueOf(invasiveTestEEG.isInvasiveEegStatusEpilepticus()), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isInvasiveTestEEGInvasiveIctalEEGPatterns()) {
                addCells("label.ictalEegPatterns", translateValue(messageSource.getMessage("label.ictalEegPatterns." +
                        String.valueOf(invasiveTestEEG.getInvasiveIctalEegPatterns()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isInvasiveTestEEGLocalizationIctalEEGPatterns()) {
                addCells("label.localizationIctalEegPattern", translateValue(String.valueOf(invasiveTestEEG.getLocalizationInvasiveIctalEegPatterns()), locale), sheet, locale, styles, "cell", p);
            }
            if (exportParams.isInvasiveTestEEGComment()) {
                addCells("label.comment", translateComment(String.valueOf(invasiveTestEEG.getComment()), locale), sheet, locale, styles, "cell", p);
            }
        }
    }

    private void printOutInvasiveTestCorticalMapping(PatientEntity patient,
                                                     InvasiveTestCorticalMappingEntity invasiveTestCorticalMapping,
                                                     Locale locale, ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 1) {
            Row dateRow = sheet.getRow(p.getRowcount());
            if (dateRow == null) dateRow = sheet.createRow(p.getRowcount());
            Cell dateCell = dateRow.createCell(p.getCellcount());
            dateCell.setCellStyle(styles.get("empty"));
            sheet.addMergedRegion(new CellRangeAddress(p.getRowcount(), p.getRowcount(), p.getCellcount(), p.getCellcount() + 1));
            p.setRowcount(p.getRowcount() + 1);
        }
        Row dateRow = sheet.getRow(p.getRowcount());
        if (dateRow == null) sheet.createRow(p.getRowcount());
        p.setRowcount(p.getRowcount() + 1);
        Cell dateCell = dateRow.createCell(p.getCellcount());
        dateCell.setCellValue(messageSource.getMessage("label.invasiveTestCorticalMapping", null, locale) + " " + messageSource.getMessage("label.fromDate", null, locale));
        dateCell.setCellStyle(styles.get("cell"));
        Cell dateCellTwo = dateRow.createCell(p.getCellcount() + 1);
        dateCellTwo.setCellValue(TimeConverter.getDate(invasiveTestCorticalMapping.getDate()));
        dateCellTwo.setCellStyle(styles.get("cell"));
        if (exportParams.isInvasiveTestCorticalMappingDone()) {
            addCells("label.corticalMappingDone", translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(invasiveTestCorticalMapping.getDone()), null, locale), locale), sheet, locale, styles, "cell", p);
        }
        if (invasiveTestCorticalMapping.getDone() == 1) {
            if (exportParams.isInvasiveTestCorticalMappingCorticalMapping()) {
                addCells("label.corticalMapping", translateValue(messageSource.getMessage("label.corticalMapping." +
                        String.valueOf(invasiveTestCorticalMapping.getCorticalMapping()), null, locale), locale), sheet, locale, styles, "cell", p);
                if (exportParams.isInvasiveTestCorticalMappingComment()) {
                    addCells("label.comment", translateComment(String.valueOf(invasiveTestCorticalMapping.getComment()), locale), sheet, locale, styles, "cell", p);
                }
            }
        }
    }

    private void printOutOperation(PatientEntity patient,
                                   OperationEntity operation, Locale locale,
                                   ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 1) {
            Row dateRow = sheet.getRow(p.getRowcount());
            if (dateRow == null) dateRow = sheet.createRow(p.getRowcount());
            Cell dateCell = dateRow.createCell(p.getCellcount());
            dateCell.setCellStyle(styles.get("empty"));
            sheet.addMergedRegion(new CellRangeAddress(p.getRowcount(), p.getRowcount(), p.getCellcount(), p.getCellcount() + 1));
            p.setRowcount(p.getRowcount() + 1);
        }
        Row dateRow = sheet.getRow(p.getRowcount());
        if (dateRow == null) sheet.createRow(p.getRowcount());
        p.setRowcount(p.getRowcount() + 1);
        Cell dateCell = dateRow.createCell(p.getCellcount());
        dateCell.setCellValue(messageSource.getMessage("label.operation", null, locale) + " " + messageSource.getMessage("label.fromDate", null, locale));
        dateCell.setCellStyle(styles.get("cell"));
        Cell dateCellTwo = dateRow.createCell(p.getCellcount() + 1);
        dateCellTwo.setCellValue(TimeConverter.getDate(operation.getDate()));
        dateCellTwo.setCellStyle(styles.get("cell"));

        if (exportParams.isOperationDateOperation()) {
            addCells("label.dateOfOperation", translateValue(String.valueOf(operation.getDateOperation()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOperationRangeOperation()) {
            addCells("label.rangeOfOperation", translateValue(messageSource.getMessage("label.rangeOfOperation." +
                    String.valueOf(operation.getRangeOperation()), null, locale), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOperationTypeOperation()) {
            addCells("label.typeOfOperation", translateValue(messageSource.getMessage("label.operationType." +
                    String.valueOf(operation.getTypeOperation()), null, locale), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOperationLocalizationOperation()) {
            addCells("label.localizationOfOperation", translateValue(String.valueOf(operation.getLocalizationOperation()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOperationMst()) {
            addCells("label.mst", translateValue(String.valueOf(operation.isMst()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOperationColostomy()) {
            addCells("label.calosotomy", translateValue(String.valueOf(operation.isColostomy()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOperationVNS()) {
            addCells("label.vns", translateValue(String.valueOf(operation.isVns()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOperationVNsImplantationDate()) {
            addCells("label.vnsImplantationDate", translateValue(String.valueOf(operation.getVnsImplantationDate()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOperationOperationDetails()) {
            addCells("label.operationDetails", translateValue(String.valueOf(operation.getOperationDetails()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOperationCompleteResection()) {
            addCells("label.completeResection", translateValue(String.valueOf(operation.isCompleteResection()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOperationComment()) {
            addCells("label.comment", translateComment(String.valueOf(operation.getComment()), locale), sheet, locale, styles, "cell", p);
        }
    }

    private void printOutHistology(PatientEntity patient,
                                   HistologyEntity histology, Locale locale,
                                   ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 1) {
            Row dateRow = sheet.getRow(p.getRowcount());
            if (dateRow == null) dateRow = sheet.createRow(p.getRowcount());
            Cell dateCell = dateRow.createCell(p.getCellcount());
            dateCell.setCellStyle(styles.get("empty"));
            sheet.addMergedRegion(new CellRangeAddress(p.getRowcount(), p.getRowcount(), p.getCellcount(), p.getCellcount() + 1));
            p.setRowcount(p.getRowcount() + 1);
        }
        Row dateRow = sheet.getRow(p.getRowcount());
        if (dateRow == null) sheet.createRow(p.getRowcount());
        p.setRowcount(p.getRowcount() + 1);
        Cell dateCell = dateRow.createCell(p.getCellcount());
        dateCell.setCellValue(messageSource.getMessage("label.histology", null, locale) + " " + messageSource.getMessage("label.fromDate", null, locale));
        dateCell.setCellStyle(styles.get("cell"));
        Cell dateCellTwo = dateRow.createCell(p.getCellcount() + 1);
        dateCellTwo.setCellValue(TimeConverter.getDate(histology.getDate()));
        dateCellTwo.setCellStyle(styles.get("cell"));

        if (exportParams.isHistologyHistopathology()) {
            addCells("label.histopathology", translateValue(messageSource.getMessage("label.histopathology." +
                    String.valueOf(histology.getHistopathology()), null, locale), locale), sheet, locale, styles, "cell", p);
        }
        if (histology.getHistopathology() == 2)
            if (exportParams.isHistologyFcdClassification()) {
                addCells("label.fcdClassification", translateValue(messageSource.getMessage("label.fcdClassification." +
                        String.valueOf(histology.getFcdClassification()), null, locale), locale), sheet, locale, styles, "cell", p);
            }
        if (exportParams.isHistologyComment()) {
            addCells("label.comment", translateComment(String.valueOf(histology.getComment()), locale), sheet, locale, styles, "cell", p);
        }
    }

    private void printOutComplication(PatientEntity patient,
                                      ComplicationEntity complication, Locale locale,
                                      ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 1) {
            Row dateRow = sheet.getRow(p.getRowcount());
            if (dateRow == null) dateRow = sheet.createRow(p.getRowcount());
            Cell dateCell = dateRow.createCell(p.getCellcount());
            dateCell.setCellStyle(styles.get("empty"));
            sheet.addMergedRegion(new CellRangeAddress(p.getRowcount(), p.getRowcount(), p.getCellcount(), p.getCellcount() + 1));
            p.setRowcount(p.getRowcount() + 1);
        }
        Row dateRow = sheet.getRow(p.getRowcount());
        if (dateRow == null) sheet.createRow(p.getRowcount());
        p.setRowcount(p.getRowcount() + 1);
        Cell dateCell = dateRow.createCell(p.getCellcount());
        dateCell.setCellValue(messageSource.getMessage("label.complication", null, locale) + " " + messageSource.getMessage("label.fromDate", null, locale));
        dateCell.setCellStyle(styles.get("cell"));
        Cell dateCellTwo = dateRow.createCell(p.getCellcount() + 1);
        dateCellTwo.setCellValue(TimeConverter.getDate(complication.getDate()));
        dateCellTwo.setCellStyle(styles.get("cell"));

        if (exportParams.isComplicationWithCompication()) {
            addCells("label.withComplications", translateValue(messageSource.getMessage("label.process." +
                    String.valueOf(complication.getWithComplication()), null, locale), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isComplicationComplicationType()) {
            addCells("label.typeComplication", translateValue(messageSource.getMessage("label.operationType." +
                    String.valueOf(complication.getComplicationType()), null, locale), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isComplicationComplication()) {
            addCells("label.complication", translateValue(messageSource.getMessage("label.complication." +
                    String.valueOf(complication.getComplication()), null, locale), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isComplicationComment()) {
            addCells("label.comment", translateComment(String.valueOf(complication.getComment()), locale), sheet, locale, styles, "cell", p);
        }
    }

    private void printOutOutcome(PatientEntity patient,
                                 OutcomeEntity outcome, Locale locale,
                                 ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 1) {
            Row dateRow = sheet.getRow(p.getRowcount());
            if (dateRow == null) dateRow = sheet.createRow(p.getRowcount());
            Cell dateCell = dateRow.createCell(p.getCellcount());
            dateCell.setCellStyle(styles.get("empty"));
            sheet.addMergedRegion(new CellRangeAddress(p.getRowcount(), p.getRowcount(), p.getCellcount(), p.getCellcount() + 1));
            p.setRowcount(p.getRowcount() + 1);
        }
        Row dateRow = sheet.getRow(p.getRowcount());
        if (dateRow == null) sheet.createRow(p.getRowcount());
        p.setRowcount(p.getRowcount() + 1);
        Cell dateCell = dateRow.createCell(p.getCellcount());
        dateCell.setCellValue(messageSource.getMessage("label.outcome", null, locale) + " " + messageSource.getMessage("label.fromDate", null, locale));
        dateCell.setCellStyle(styles.get("cell"));
        Cell dateCellTwo = dateRow.createCell(p.getCellcount() + 1);
        dateCellTwo.setCellValue(TimeConverter.getDate(outcome.getDate()));
        dateCellTwo.setCellStyle(styles.get("cell"));

        if (exportParams.isOutcomeSeizureOutcome()) {
            addCells("label.seizures", translateValue(messageSource.getMessage("label.seizureOutcome." +
                    String.valueOf(outcome.getSeizureOutcome()), null, locale), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOutcomeEEG()) {
            addCells("label.eeg", translateValue(messageSource.getMessage("label.outcomeEeg." +
                    String.valueOf(outcome.getEeg()), null, locale), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOutcomeAED()) {
            addCells("label.aed", translateValue(messageSource.getMessage("label.outcomeAed." +
                    String.valueOf(outcome.getAed()), null, locale), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOutcomeMRI()) {
            addCells("label.mri", translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(outcome.getMri()), null, locale), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOutcomeNeuropsychology()) {
            addCells("label.neuropsychology", translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(outcome.getNeuropsychology()), null, locale), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOutcomeOperationId()) {
            addCells("label.operationId", translateValue(String.valueOf(outcome.getOperation()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOutcomeComment()) {
            addCells("label.comment", translateComment(String.valueOf(outcome.getComment()), locale), sheet, locale, styles, "cell", p);
        }
    }
}

/**
 * class for better work with position within a table
 */
class Position {
    private int rowcount;
    private int cellcount;

    Position() {
        this.setRowcount(1);
        this.setCellcount(-2);
    }

    public int getRowcount() {
        return rowcount;
    }

    public void setRowcount(int rowcount) {
        this.rowcount = rowcount;
    }

    public int getCellcount() {
        return cellcount;
    }

    public void setCellcount(int cellcount) {
        this.cellcount = cellcount;
    }
} 

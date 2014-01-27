package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.service.ExportToXlsxService;
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

// TODO: Auto-generated Javadoc

/**
 * The Class ExportToXlsServiceImpl.
 */

@Service
public class ExportToXlsServiceImpl implements ExportToXlsxService {

    @Autowired
    private MessageSource messageSource;

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
        else if (value.equals("null")) {
            return messageSource.getMessage("label.null", null, locale);
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
                         UserEntity user, Locale locale, ExportParamsEntity exportParams,boolean anonymize ) {

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
                        "Couldn't create new file when trying to save xlsx file.",
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
                        "Couldn't create new file when trying to save xlsx file.",
                        e);
            }
        }

        // Blank workbook
        Workbook wb = new HSSFWorkbook();

        for (PatientEntity patient : patientList) {

            Sheet sheet = wb.createSheet(patient.getContact().getLastName()
                    + " " + patient.getContact().getFirstName() + " "
                    + patient.getNin());
            this.addContent(patient, locale, exportParams, sheet, p);
        }
        // Write the output to a file
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream(downloadFolder + name);
        } catch (FileNotFoundException e) {
            logger.logError("File wasn't found when trying to save xlsx file.",
                    e);
            e.printStackTrace();
        }
        try {
            wb.write(fileOut);
        } catch (IOException e) {
            logger.logError("IO Exception when trying to write to xlsx file.",
                    e);
            e.printStackTrace();
        }
        try {
            fileOut.close();
        } catch (IOException e) {
            logger.logError(
                    "File wasn't found when trying to close xlsx file.", e);
            e.printStackTrace();
        }

        return name;
    }

    private void addTitlePage(Locale locale, PatientEntity patient, String date) {
        String content = "Export of the patient "
                + patient.getContact().getFirstName() + " "
                + patient.getContact().getLastName() + " :" + patient.getId()
                + " " + date;

        content += ("Report generated by: " + System.getProperty("user.name")
                + ", " + new Date() + "\n");

    }

    private void addContent(PatientEntity patient, Locale locale,
                            ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        PrintSetup printSetup = sheet.getPrintSetup();
        printSetup.setLandscape(true);
        sheet.setFitToPage(true);
        sheet.setHorizontallyCenter(true);

        Row titleRow = sheet.createRow(0);
        titleRow.setHeightInPoints(45);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue(patient.getContact().getLastName() + " " + patient.getContact().getFirstName());
        titleCell.setCellStyle(styles.get("title"));
        sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$L$1"));

        Row headerRow = sheet.createRow(1);
        headerRow.setHeightInPoints(40);
        Cell headerCell;
        int i = 0;
        if (exportParams.isAnamnesis()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.anamnesis",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    1, //first row (0-based)
                    1, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));
/*
            Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());

            Row row = sheet.createRow((short) 0);
            Cell cell = row.createCell((short) 0);
            cell.setCellValue(messageSource.getMessage("label.anamnesis",
                    null, locale));
            cell.setCellStyle(styles.get("title"));
            sheet.addMergedRegion(new CellRangeAddress(
                    0, //first row (0-based)
                    1, //last row  (0-based)
                    0, //first column (0-based)
                    3  //last column  (0-based)
            ));
            */


            for (AnamnesisEntity anamnesis : patient.getAnamnesisList()) {
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
                    1, //first row (0-based)
                    1, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(3);
            p.setCellcount(p.getCellcount() + 2);

            for (SeizureEntity seizure : patient.getSeizureList()) {
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
                    1, //first row (0-based)
                    1, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(3);
            p.setCellcount(p.getCellcount() + 2);
            for (PharmacotherapyEntity pharmacotherapy : patient
                    .getPharmacotherapyList()) {
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
                    1, //first row (0-based)
                    1, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(3);
            p.setCellcount(p.getCellcount() + 2);
            for (NeurologicalFindingEntity neurologicalFinding : patient
                    .getNeurologicalFindingList()) {
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
                    1, //first row (0-based)
                    1, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(3);
            p.setCellcount(p.getCellcount() + 2);
            for (NeuropsychologyEntity neuropsychology : patient
                    .getNeuropsychologyList()) {
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
                    1, //first row (0-based)
                    1, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(3);
            p.setCellcount(p.getCellcount() + 2);
            for (NeuropsychologyOldEntity neuropsychologyOld : patient
                    .getNeuropsychologyOldList()) {
                this.printOutNeuropsychologyOld(patient,
                        neuropsychologyOld, locale, exportParams, sheet, p);
            }
        }

        if (exportParams.isDiagnosticTestEEG()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.diagnosticTestScalpEEG",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    1, //first row (0-based)
                    1, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(3);
            p.setCellcount(p.getCellcount() + 2);
            for (DiagnosticTestScalpEegEntity diagnosticTestEEG : patient
                    .getDiagnosticTestEEGList()) {
                this.printOutDiagnosticTestEEG(patient,
                        diagnosticTestEEG, locale, exportParams, sheet, p);
            }
        }

        if (exportParams.isDiagnosticTestMRI()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.diagnosticTestScalpEEG",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    1, //first row (0-based)
                    1, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(3);
            p.setCellcount(p.getCellcount() + 2);
            for (DiagnosticTestMriEntity diagnosticTestMRI : patient
                    .getDiagnosticTestMRIList()) {
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
                    1, //first row (0-based)
                    1, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(3);
            p.setCellcount(p.getCellcount() + 2);
            for (InvasiveTestEcogEntity invasiveTestECOG : patient
                    .getInvasiveTestECOGList()) {
                this.printOutInvasiveTestECOG(patient,
                        invasiveTestECOG, locale, exportParams, sheet, p);
            }
        }

        if (exportParams.isInvasiveTestEEG()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.invasiveTestEEG",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    1, //first row (0-based)
                    1, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(3);
            p.setCellcount(p.getCellcount() + 2);
            for (InvasiveTestEegEntity invasiveTestEEG : patient
                    .getInvasiveTestEEGList()) {
                this.printOutInvasiveTestEEG(patient,
                        invasiveTestEEG, locale, exportParams, sheet, p);
            }
        }

        if (exportParams.isInvasiveTestCorticalMapping()) {
            headerCell = headerRow.createCell(i++);
            headerCell.setCellValue(messageSource.getMessage("label.invasiveCorticalMappingTest",
                    null, locale));
            headerCell.setCellStyle(styles.get("header"));
            sheet.addMergedRegion(new CellRangeAddress(
                    1, //first row (0-based)
                    1, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(3);
            p.setCellcount(p.getCellcount() + 2);
            for (InvasiveTestCorticalMappingEntity invasiveTestCorticalMappingEntity : patient
                    .getInvasiveTestCorticalMappingList()) {
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
                    1, //first row (0-based)
                    1, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(3);
            p.setCellcount(p.getCellcount() + 2);
            for (OperationEntity operation : patient.getOperationList()) {
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
                    1, //first row (0-based)
                    1, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(3);
            p.setCellcount(p.getCellcount() + 2);
            for (HistologyEntity histology : patient.getHistologyList()) {
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
                    1, //first row (0-based)
                    1, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(3);
            p.setCellcount(p.getCellcount() + 2);
            for (ComplicationEntity complication : patient
                    .getComplicationList()) {
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
                    1, //first row (0-based)
                    1, //last row  (0-based)
                    i - 1, //first column (0-based)
                    i++  //last column  (0-based)
            ));

            p.setRowcount(3);
            p.setCellcount(p.getCellcount() + 2);
            for (OutcomeEntity outcome : patient.getOutcomeList()) {
                this.printOutOutcome(patient, outcome, locale,
                        exportParams, sheet, p);
            }
        }

        // makes cells a bit wider
        for (int j = 0; j != p.getCellcount()+2; j++)
            sheet.setColumnWidth(j, 5000);
    }

    private void addCells(String firstValue, String secondValue, Sheet sheet, Locale locale, Map<String, CellStyle> styles, String style, Position p) {
        Row cellRow = sheet.getRow(p.getRowcount());
        if (cellRow == null || sheet.getRow(p.getRowcount()).getCell(0) == null)
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

    private void printOutAnamnesis(PatientEntity patient,
                                   AnamnesisEntity anamnesis, Locale locale,
                                   ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());

        if (p.getRowcount() > 3) {
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

        Row dateRow = sheet.createRow(p.getRowcount());
        p.setRowcount(p.getRowcount() + 1);
        Cell dateCell = dateRow.createCell(p.getCellcount());
        dateCell.setCellValue(messageSource.getMessage("label.anamnesis_from_date", null,
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
            addCells("label.inflammationCNS", translateValue(
                    String.valueOf(anamnesis.isInflammationCns()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isAnamnesisInjuryCns()) {

            addCells("label.injuryCNS", translateValue(
                    String.valueOf(anamnesis.isInjuryCns()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isAnamnesisOperationCns()) {
            addCells("label.operationCNS", translateValue(
                    String.valueOf(anamnesis.isOperationCns()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isAnamnesisEarlyPmdRetardation()) {
            addCells("label.earlyPMDRetardation", translateValue(
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
            addCells("label.epilepticSyndrome", translateValue(
                    String.valueOf(anamnesis.getSpecificSyndrome()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isAnamnesisNonCnsComorbidity()) {
            addCells("label.nonCNSComorbidity", translateValue(
                    String.valueOf(anamnesis.getNonCnsComorbidity()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isAnamnesisComment()) {
            addCells("label.comment", translateValue(
                    String.valueOf(anamnesis.getComment()), locale), sheet, locale, styles, "cell", p);
        }
    }


    private void printOutSeizure(PatientEntity patient,
                                 SeizureEntity seizure, Locale locale,
                                 ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());

        if (p.getRowcount() > 3) {
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
            addCells("label.seizureFrequency", translateValue(String.valueOf(seizure.getSeizureFrequency()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isSeizureSecondarilyGeneralizedSeizure()) {
            addCells("label.secondarilyGeneralizedSeizure", translateValue(String.valueOf(seizure.isSecondarilyGeneralizedSeizure()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isSeizureStatusEpilepticus()) {
            addCells("label.stausEpilepticus", translateValue(String.valueOf(seizure.isStatusEpilepticus()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isSeizureComment()) {
            addCells("label.comment", translateValue(String.valueOf(seizure.getComment()), locale), sheet, locale, styles, "cell", p);
        }
        for (SeizureDetailEntity seizureDetail : seizure.getSeizureDetailList()) {
            if (exportParams.isSeizureDetailSSCClassification()) {
                addCells("label.seizureDetailSSCClassification", translateValue(String.valueOf(seizureDetail.getSscClassification()), locale), sheet, locale, styles, "table", p);
            }
            if (exportParams.isSeizureDetailILAEClassification()) {
                addCells("label.seizureDetailILAEClassification", translateValue(String.valueOf(seizureDetail.getIlaeClassification()), locale), sheet, locale, styles, "table", p);
            }
            if (exportParams.isSeizureDetailComment()) {
                addCells("label.comment", translateValue(String.valueOf(seizureDetail.getComment()), locale), sheet, locale, styles, "table", p);
            }

            //add empty line
            if (p.getRowcount() > 3) {
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
        }
    }

    private void printOutPharmacotherapy(PatientEntity patient,
                                         PharmacotherapyEntity pharmacotherapy, Locale locale,
                                         ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 3) {
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
            addCells("label.aed", translateValue(String.valueOf(pharmacotherapy.getAed()), locale), sheet, locale, styles, "table", p);
        }
        if (exportParams.isPharmacotherapyEffective()) {
            addCells("label.efficiency", translateValue(String.valueOf(pharmacotherapy.getEfficiency()), locale), sheet, locale, styles, "table", p);
        }
        if (exportParams.isPharmacotherapyDuringSurgery()) {
            addCells("label.duringSurgery", translateValue(String.valueOf(pharmacotherapy.isDuringSurgery()), locale), sheet, locale, styles, "table", p);
        }
        if (exportParams.isPharmacotherapyComment()) {
            addCells("label.comment", translateValue(String.valueOf(pharmacotherapy.getComment()), locale), sheet, locale, styles, "table", p);
        }
    }

    private void printOutNeurologicalFinding(PatientEntity patient,
                                             NeurologicalFindingEntity neurologicalFinding, Locale locale,
                                             ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 3) {
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
            addCells("label.hemisphereDominance", translateValue(String.valueOf(neurologicalFinding.getHemisphereDominance()), locale), sheet, locale, styles, "cell", p);
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
            addCells("label.comment", translateValue(String.valueOf(neurologicalFinding.getComment()), locale), sheet, locale, styles, "cell", p);
        }
    }

    private void printOutNeuropsychology(PatientEntity patient,
                                         NeuropsychologyEntity neuropsychology, Locale locale,
                                         ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 3) {
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
            addCells("label.intellect", translateValue(String.valueOf(neuropsychology.getIntellect()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isNeuropsychologyNeurodevelopmentalExamination()) {
            addCells("label.neurodevelopmentalExamination", translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExamination()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isNeuropsychologyNeurodevelopmentalExaminationAdaptability()) {
            addCells("label.adaptability", translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationAdaptability()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isNeuropsychologyNeurodevelopmentalExaminationSpeechExpressively()) {
            addCells("label.speech_expressively", translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSpeechExpressively()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isNeuropsychologyNeurodevelopmentalExaminationSpeechReceptively()) {
            addCells("label.speechReceptively", translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSpeechReceptively()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isNeuropsychologyNeurodevelopmentalExaminationFineMotorSkills()) {
            addCells("label.fineMotorSkills", translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationFineMotorSkills()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isNeuropsychologyNeurodevelopmentalExaminationGrossMotorSkills()) {
            addCells("label.grossMotorSkills", translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationGrossMotorSkills()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isNeuropsychologyNeurodevelopmentalExaminationSocialBehavior()) {
            addCells("label.socialBehavior", translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSocialBehavior()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isNeuropsychologyIntellectualPerformance()) {
            addCells("label.intellectualPerformance", translateValue(String.valueOf(neuropsychology.getIntellectualPerformance()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isNeuropsychologyIntellectualPerformanceVerbally()) {
            addCells("label.intellectualPerformanceVerbally", translateValue(String.valueOf(neuropsychology.getIntellectualPerformanceVerbally()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isNeuropsychologyIntellectualPerformanceNonverbalAbstraction()) {
            addCells("label.comment", translateValue(String.valueOf(neuropsychology.getComment()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isneuropsychologyIntellectualPerformanceNonverbalDesignCap()) {
            addCells("label.intellectualPerformanceNonverbalDesignCapabilities", translateValue(String.valueOf(neuropsychology.getIntellectualPerformanceNonverbalDesignCapabilities()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isNeuropsychologyNeuropsychologicalProfile()) {
            addCells("label.neuropsychologicalProfile", translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfile()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isNeuropsychologyNeuropsychologicalProfileAttention()) {
            addCells("label.attention", translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileAttention()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileCognitiveSpeed()) {
            addCells("label.cognitive_speed", translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileCognitiveSpeed()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileExecutiveFunction()) {
            addCells("label.executiveFunction", translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileExecutiveFunction()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileSpeechExpressively()) {
            addCells("label.speech_expressively", translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSpeechExpressively()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileSpeechUnderstanding()) {
            addCells("label.speech_understanding", translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileSpeechUnderstanding()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileMemoryOperating()) {
            addCells("label.memory_operating", translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryOperating()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileMemoryVerbal()) {
            addCells("label.memory_verbal", translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryVerbal()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileMemoryNonverbal()) {
            addCells("label.memoryNonverbal", translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryNonverbal()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileMemoryLearning()) {
            addCells("label.memoryLearning", translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryLearning()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfilePerceptionSpeech()) {
            addCells("label.perceptionSpeech", translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionSpeech()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfilePerceptionVisual()) {
            addCells("label.perceptionVisual", translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionVisual()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfilePerceptionSpatial()) {
            addCells("label.perceptionSpatial", translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionSpatial()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileMotorSkillsDexterity()) {
            addCells("label.motorSkillsDexterity", translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileMotorSkillsDexterity()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileMotorCoordination()) {
            addCells("label.motorCoordination", translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileMotorCoordination()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isNeuropsychologyPresenceOfChanges()) {
            addCells("label.presenceOfChanges", translateValue(String.valueOf(neuropsychology.getPresenceOfChanges()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isNeuropsychologyPresenceOfChangesDetail()) {
            addCells("label.comment", translateValue(String.valueOf(neuropsychology.getComment()), locale), sheet, locale, styles, "cell", p);
        }
    }

    private void printOutNeuropsychologyOld(PatientEntity patient,
                                            NeuropsychologyOldEntity neuropsychologyOld, Locale locale,
                                            ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 3) {
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
            addCells("label.ADHDSyndrome", translateValue(String.valueOf(neuropsychologyOld.isAdhdSyndrome()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isNeuropsychologyOldComment()) {
            addCells("label.comment", translateValue(String.valueOf(neuropsychologyOld.getComment()), locale), sheet, locale, styles, "cell", p);
        }
    }

    private void printOutDiagnosticTestEEG(PatientEntity patient,
                                           DiagnosticTestScalpEegEntity diagnosticTestScalpEEG, Locale locale,
                                           ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 3) {
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
        dateCell.setCellValue(messageSource.getMessage("label.diagnosticTestScalpEEG", null, locale) + " " + messageSource.getMessage("label.fromDate", null, locale));
        dateCell.setCellStyle(styles.get("cell"));
        Cell dateCellTwo = dateRow.createCell(p.getCellcount() + 1);
        dateCellTwo.setCellValue(TimeConverter.getDate(diagnosticTestScalpEEG.getDate()));
        dateCellTwo.setCellStyle(styles.get("cell"));

        if (exportParams.isDiagnosticTestEEGDone()) {
            addCells("label.eeg_done", translateValue(String.valueOf(diagnosticTestScalpEEG.isDone()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestEEGBasicActivity()) {
            addCells("label.basicEEGActivity", translateValue(String.valueOf(diagnosticTestScalpEEG.getBasicEegActivity()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestEEGSlow()) {
            addCells("label.EEGSlow", translateValue(String.valueOf(diagnosticTestScalpEEG.getEegSlow()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestEEGInterictalEEGSpikes()) {
            addCells("label.interictalEEGSpikes", translateValue(String.valueOf(diagnosticTestScalpEEG.getInterictalEegSpikes()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestEEGLocalizationInerictalEEGSpikes()) {
            addCells("label.localizationInterictalEEGSpikes", translateValue(String.valueOf(diagnosticTestScalpEEG.getLocalizationInterictalEEGSpikes()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestEEGStatusEpilepticus()) {
            addCells("label.EEGStatusEpilepticus", translateValue(String.valueOf(diagnosticTestScalpEEG.isEegStatusEpilepticus()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestEEGSecondarySidedSynchrony()) {
            addCells("label.secondarySidedSynchrony", translateValue(String.valueOf(diagnosticTestScalpEEG.isSecondarySidedSynchrony()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestEEGIctalEEGPatterns()) {
            addCells("label.invasiveIctalEEGPatterns", translateValue(String.valueOf(diagnosticTestScalpEEG.getIctalEegPatterns()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestEEGDescriptionVideoEEG()) {
            addCells("label.eEGDescriptionVideoEEG", translateValue(String.valueOf(diagnosticTestScalpEEG.getDescriptionVideoEeg()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestEEGComment()) {
            addCells("label.comment", translateValue(String.valueOf(diagnosticTestScalpEEG.getComment()), locale), sheet, locale, styles, "cell", p);
        }
    }

    private void printOutDiagnosticTestMRI(PatientEntity patient,
                                           DiagnosticTestMriEntity diagnosticTestScalpMRI, Locale locale,
                                           ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 3) {
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
        dateCell.setCellValue(messageSource.getMessage("label.diagnosticTestMriMulti", null, locale) + " " + messageSource.getMessage("label.fromDate", null, locale));
        dateCell.setCellStyle(styles.get("cell"));
        Cell dateCellTwo = dateRow.createCell(p.getCellcount() + 1);
        dateCellTwo.setCellValue(TimeConverter.getDate(diagnosticTestScalpMRI.getDate()));
        dateCellTwo.setCellStyle(styles.get("cell"));

        if (exportParams.isDiagnosticTestMRIDone()) {
            addCells("label.mri_done", translateValue(String.valueOf(diagnosticTestScalpMRI.isDone()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestMRIFinding()) {
            addCells("label.MRIFindingf", translateValue(String.valueOf(diagnosticTestScalpMRI.getMriFinding()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestMRIDescription()) {
            addCells("label.descriptionMRI", translateValue(String.valueOf(diagnosticTestScalpMRI.getMriDescription()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestMRIFdgPet()) {
            addCells("label.mRIFdgPet", translateValue(String.valueOf(diagnosticTestScalpMRI.getFdgPet()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestMRIDescriptionPetHypometabolism()) {
            addCells("label.descriptionPetHypometabolism", translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionPetHypometabolism()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestMRIInterictalSpect()) {
            addCells("label.ictalSpect", translateValue(String.valueOf(diagnosticTestScalpMRI.getIctalSpect()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestMRIDescriptionSpectHypoperfuse()) {
            addCells("label.descriptionSPECTHypoperfuse", translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionSpectHypoperfuse()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestMRIIctalSpect()) {
            addCells("label.ictalSpect", translateValue(String.valueOf(diagnosticTestScalpMRI.getIctalSpect()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestMRIDescriptionSpectHyperperfuse()) {
            addCells("label.descriptionSPECTHyperperfuse", translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionSpectHyperperfuse()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestMRISiscom()) {
            addCells("label.mriSiscom", translateValue(String.valueOf(diagnosticTestScalpMRI.isSiscom()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestMRIMrsProtocol()) {
            addCells("label.MrsProtocol", translateValue(String.valueOf(diagnosticTestScalpMRI.getMrsProtocol()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestMRIMrsFinding()) {
            addCells("label.MrsFinding", translateValue(String.valueOf(diagnosticTestScalpMRI.getMrsFinding()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestMRIDescriptionMrsAbnormality()) {
            addCells("label.descriptionMrsAbnormality", translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionMrsAbnormality()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestMRIFmri()) {
            addCells("label.fmri", translateValue(String.valueOf(diagnosticTestScalpMRI.isFmri()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestMRIDetailsFmri()) {
            addCells("label.FMRIDetails", translateValue(String.valueOf(diagnosticTestScalpMRI.getDetailsFmri()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestMRIDti()) {
            addCells("label.dti", translateValue(String.valueOf(diagnosticTestScalpMRI.isDti()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestMRIDetailsDtiStudy()) {
            addCells("label.DTIStudyDetails", translateValue(String.valueOf(diagnosticTestScalpMRI.getDetailsDtiStudy()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestMRIWada()) {
            addCells("label.WADA", translateValue(String.valueOf(diagnosticTestScalpMRI.isWada()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestMRIDetailsWada()) {
            addCells("label.WADADetails", translateValue(String.valueOf(diagnosticTestScalpMRI.getDetailsWada()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isDiagnosticTestMRIComment()) {
            addCells("label.comment", translateValue(String.valueOf(diagnosticTestScalpMRI.getComment()), locale), sheet, locale, styles, "cell", p);
        }
    }

    private void printOutInvasiveTestECOG(PatientEntity patient,
                                          InvasiveTestEcogEntity invasiveTestECOG, Locale locale,
                                          ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 3) {
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
            addCells("label.ECoG_done", translateValue(String.valueOf(invasiveTestECOG.isDone()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isInvasiveTestECOGEcogCover()) {
            addCells("label.ECoG_cover", translateValue(String.valueOf(invasiveTestECOG.getEcogCover()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isInvasiveTestECOGEcogPatterns()) {
            addCells("label.ECoG_patterns", translateValue(String.valueOf(invasiveTestECOG.getEcogPatterns()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isInvasiveTestECOGAfterResectionEcog()) {
            addCells("label.afterResectionECoG", translateValue(String.valueOf(invasiveTestECOG.getAfterResectionEcog()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isInvasiveTestECOGComment()) {
            addCells("label.comment", translateValue(String.valueOf(invasiveTestECOG.getComment()), locale), sheet, locale, styles, "cell", p);
        }
    }

    private void printOutInvasiveTestEEG(PatientEntity patient,
                                         InvasiveTestEegEntity invasiveTestEEG, Locale locale,
                                         ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 3) {
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
        dateCell.setCellValue(messageSource.getMessage("label.invasiveTestEEG", null, locale) + " " + messageSource.getMessage("label.fromDate", null, locale));
        dateCell.setCellStyle(styles.get("cell"));
        Cell dateCellTwo = dateRow.createCell(p.getCellcount() + 1);
        dateCellTwo.setCellValue(TimeConverter.getDate(invasiveTestEEG.getDate()));
        dateCellTwo.setCellStyle(styles.get("cell"));

        if (exportParams.isInvasiveTestEEGDone()) {
            addCells("label.eeg_done", translateValue(String.valueOf(invasiveTestEEG.isDone()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isInvasiveTestEEGIntracranialElectrodes()) {
            addCells("label.intracranialElectrodes", translateValue(String.valueOf(invasiveTestEEG.getIntracranialElectrodes()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isInvasiveTestEEGLocalizationIntracranialElectrodes()) {
            addCells("label.localizationIntracranialElectrodes", translateValue(String.valueOf(invasiveTestEEG.getLocalizationIntracranialElectrodes()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isInvasiveTestEEGInvasiveEEGSlow()) {
            addCells("label.invasiveEEGSlowing", translateValue(String.valueOf(invasiveTestEEG.getInvasiveEegSlow()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isInvasiveTestEEGInvasiveEEGInterictalSpikes()) {
            addCells("label.invasiveEEGInterictalSpikes", translateValue(String.valueOf(invasiveTestEEG.getInvasiveEegInterictalSpikes()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams
                .isInvasiveTestEEGLocalizationInvasiveEEGInterictalSpikes()) {
            addCells("label.localizationInvasiveEEGInterictalSpikes", translateValue(String.valueOf(invasiveTestEEG.getLocalizationInvasiveEegInterictalSpikes()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isInvasiveTestEEGStatusEpilepticus()) {
            addCells("label.EEGStatusEpilepticus", translateValue(String.valueOf(invasiveTestEEG.isInvasiveEegStatusEpilepticus()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isInvasiveTestEEGInvasiveIctalEEGPatterns()) {
            addCells("label.ictalEEGPatterns", translateValue(String.valueOf(invasiveTestEEG.getInvasiveIctalEegPatterns()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isInvasiveTestEEGLocalizationIctalEEGPatterns()) {
            addCells("label.localizationIctalEEGPattern", translateValue(String.valueOf(invasiveTestEEG.getLocalizationInvasiveIctalEegPatterns()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isInvasiveTestEEGComment()) {
            addCells("label.comment", translateValue(String.valueOf(invasiveTestEEG.getComment()), locale), sheet, locale, styles, "cell", p);
        }
    }

    private void printOutInvasiveTestCorticalMapping(PatientEntity patient,
                                                     InvasiveTestCorticalMappingEntity invasiveTestCorticalMapping,
                                                     Locale locale, ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 3) {
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
            addCells("label.corticalMapping_done", translateValue(String.valueOf(invasiveTestCorticalMapping.isDone()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isInvasiveTestCorticalMappingCorticalMapping()) {
            addCells("label.corticalMapping", translateValue(String.valueOf(invasiveTestCorticalMapping.getCorticalMapping()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isInvasiveTestCorticalMappingComment()) {
            addCells("label.comment", translateValue(String.valueOf(invasiveTestCorticalMapping.getComment()), locale), sheet, locale, styles, "cell", p);
        }
    }

    private void printOutOperation(PatientEntity patient,
                                   OperationEntity operation, Locale locale,
                                   ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 3) {
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
            addCells("label.rangeOperations", translateValue(String.valueOf(operation.getRangeOperation()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOperationTypeOperation()) {
            addCells("label.typeOperations", translateValue(String.valueOf(operation.getTypeOperation()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOperationLocalizationOperation()) {
            addCells("label.localizationOperations", translateValue(String.valueOf(operation.getLocalizationOperation()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOperationMst()) {
            addCells("label.mst", translateValue(String.valueOf(operation.isMst()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOperationColostomy()) {
            addCells("label.colostomy", translateValue(String.valueOf(operation.isColostomy()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOperationVNS()) {
            addCells("label.VNS", translateValue(String.valueOf(operation.isVns()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOperationVNsImplantationDate()) {
            addCells("label.VNSImplantationDate", translateValue(String.valueOf(operation.getVnsImplantationDate()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOperationOperationDetails()) {
            addCells("label.operationDetails", translateValue(String.valueOf(operation.getOperationDetails()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOperationCompleteResection()) {
            addCells("label.completeResection", translateValue(String.valueOf(operation.isCompleteResection()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOperationComment()) {
            addCells("label.comment", translateValue(String.valueOf(operation.getComment()), locale), sheet, locale, styles, "cell", p);
        }
    }

    private void printOutHistology(PatientEntity patient,
                                   HistologyEntity histology, Locale locale,
                                   ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 3) {
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
            addCells("label.histopathology", translateValue(String.valueOf(histology.getHistopathology()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isHistologyFcdClassification()) {
            addCells("label.FCDClasification", translateValue(String.valueOf(histology.getFcdClasification()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isHistologyComment()) {
            addCells("label.comment", translateValue(String.valueOf(histology.getComment()), locale), sheet, locale, styles, "cell", p);
        }
    }

    private void printOutComplication(PatientEntity patient,
                                      ComplicationEntity complication, Locale locale,
                                      ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 3) {
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
            addCells("label.withComplications", translateValue(String.valueOf(complication.isWithComplication()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isComplicationComplicationType()) {
            addCells("label.typeComplication", translateValue(String.valueOf(complication.getComplicationType()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isComplicationComplication()) {
            addCells("label.complication", translateValue(String.valueOf(complication.getComplication()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isComplicationComment()) {
            addCells("label.comment", translateValue(String.valueOf(complication.getComment()), locale), sheet, locale, styles, "cell", p);
        }
    }

    private void printOutOutcome(PatientEntity fpatient,
                                 OutcomeEntity outcome, Locale locale,
                                 ExportParamsEntity exportParams, Sheet sheet, Position p) {
        Map<String, CellStyle> styles = createStyles(sheet.getWorkbook());
        if (p.getRowcount() > 3) {
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
            addCells("label.seizures", translateValue(String.valueOf(outcome.getSeizureOutcome()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOutcomeEEG()) {
            addCells("label.eeg", translateValue(String.valueOf(outcome.getEeg()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOutcomeAED()) {
            addCells("label.aed", translateValue(String.valueOf(outcome.getAed()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOutcomeMRI()) {
            addCells("label.mri", translateValue(String.valueOf(outcome.getMri()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOutcomeNeuropsychology()) {
            addCells("label.neuropsychology", translateValue(String.valueOf(outcome.getNeuropsychology()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOutcomeOperationId()) {
            addCells("label.operationId", translateValue(String.valueOf(outcome.getOperation()), locale), sheet, locale, styles, "cell", p);
        }
        if (exportParams.isOutcomeComment()) {
            addCells("label.comment", translateValue(String.valueOf(outcome.getComment()), locale), sheet, locale, styles, "cell", p);
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
        this.setRowcount(3);
        this.setCellcount(0);
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

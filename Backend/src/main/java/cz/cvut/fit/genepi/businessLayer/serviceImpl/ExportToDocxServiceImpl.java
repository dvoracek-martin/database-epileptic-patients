package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.service.ExportToDocxService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.*;
import cz.cvut.fit.genepi.util.LoggingService;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.docx4j.model.table.TblFactory;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Tc;
import org.docx4j.wml.Tr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static cz.cvut.fit.genepi.util.TimeConverter.getAgeAtTheBeginningOfEpilepsy;
import static cz.cvut.fit.genepi.util.TimeConverter.getCurrentAge;

@Service
public class ExportToDocxServiceImpl implements ExportToDocxService {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserService userService;

    private LoggingService logger = new LoggingService();

    private String translateValue(String value, Locale locale) {
        if (value.equals("true"))
            return messageSource.getMessage("label.yes", null, locale);
        else if (value.equals("false"))
            return messageSource.getMessage("label.no", null, locale);
        else if (value.equals("null") || value.equals(null)) {
            return messageSource.getMessage("label.null", null, locale);
        } else {
            if (value.equals("NA")) {
                return messageSource.getMessage("label.NA", null, locale);
            }
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
        String date = getDate();
        String name = date + ".docx";

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
                        "Couldn't create new file when trying to save pdf file.",
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
        logger.setLogger(ExportToDocxService.class);
        for (PatientEntity patient : patientList) {
            WordprocessingMLPackage document = null;
            try {
                document = WordprocessingMLPackage.createPackage();
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }

            this.addTitlePage(document, patient, locale, exportParams, anonymize);

            try {
                document.save(new java.io.File(downloadFolder + name));

            } catch (Docx4JException e) {
                e.printStackTrace();
            }
        }
        return name;
    }

    private void addTitlePage(WordprocessingMLPackage wordMLPackage, PatientEntity patient,
                              Locale locale, ExportParamsEntity exportParams, boolean anonymize) {
        if (!anonymize)
            wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Title", patient.getContact().getLastName() + " " + patient.getContact().getFirstName());
        else
            wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Title", messageSource.getMessage("label.patient", null,
                    locale) + " ID " + patient.getId());
        addContent(wordMLPackage, patient, locale, exportParams, anonymize);
    }

    private void addContent(WordprocessingMLPackage document, PatientEntity patient,
                            Locale locale, ExportParamsEntity exportParams, boolean anonymize) {

        if (exportParams.isPatient()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.patient", null,
                    locale));
            this.printOutPatient(document, patient, locale,
                    exportParams, anonymize);
        }

        if (exportParams.isAnamnesis()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.anamnesis", null,
                    locale));
            for (AnamnesisEntity anamnesis : patient.getAnamnesisList()) {
                if (anamnesis.getStatus() == 0)
                    this.printOutAnamnesis(document, patient, anamnesis, locale,
                            exportParams);
            }
        }

        if (exportParams.isSeizure()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.seizures", null,
                    locale));

            for (SeizureEntity seizure : patient.getSeizureList()) {
                if (seizure.getStatus() == 0)
                    this.printOutSeizure(document, patient, seizure, locale,
                            exportParams);
            }
        }
        if (exportParams.isPharmacotherapy()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.pharmacotherapy", null,
                    locale));

            for (PharmacotherapyEntity pharmacotherapy : patient
                    .getPharmacotherapyList()) {
                if (pharmacotherapy.getStatus() == 0)
                    this.printOutPharmacotherapy(document, patient,
                            pharmacotherapy, locale, exportParams);
            }
        }
        if (exportParams.isNeurologicalFinding()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.neurologicalFinding", null,
                    locale));

            for (NeurologicalFindingEntity neurologicalFinding : patient
                    .getNeurologicalFindingList()) {
                if (neurologicalFinding.getStatus() == 0)
                    this.printOutNeurologicalFinding(document, patient,
                            neurologicalFinding, locale, exportParams);
            }
        }
        if (exportParams.isNeuropsychology()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.neuropsychology", null,
                    locale));

            for (NeuropsychologyEntity neuropsychology : patient
                    .getNeuropsychologyList()) {
                if (neuropsychology.getStatus() == 0)
                    this.printOutNeuropsychology(document, patient,
                            neuropsychology, locale, exportParams);
            }
        }

        if (exportParams.isNeuropsychologyOld()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.neuropsychology", null,
                    locale));

            for (NeuropsychologyOldEntity neuropsychologyOld : patient
                    .getNeuropsychologyOldList()) {
                if (neuropsychologyOld.getStatus() == 0)
                    this.printOutNeuropsychologyOld(document, patient,
                            neuropsychologyOld, locale, exportParams);
            }
        }

        if (exportParams.isDiagnosticTestEEG()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.diagnosticTestScalpEEG", null,
                    locale));
            for (DiagnosticTestScalpEegEntity diagnosticTestEEG : patient
                    .getDiagnosticTestScalpEegList()) {
                if (diagnosticTestEEG.getStatus() == 0)
                    this.printOutDiagnosticTestEEG(document, patient,
                            diagnosticTestEEG, locale, exportParams);
            }
        }

        if (exportParams.isDiagnosticTestMRI()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.diagnosticTestMriMulti", null,
                    locale));
            for (DiagnosticTestMriEntity diagnosticTestMRI : patient
                    .getDiagnosticTestMRIList()) {
                if (diagnosticTestMRI.getStatus() == 0)
                    this.printOutDiagnosticTestMRI(document, patient,
                            diagnosticTestMRI, locale, exportParams);
            }
        }

        if (exportParams.isInvasiveTestECOG()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.invasiveTestECoG", null,
                    locale));

            for (InvasiveTestEcogEntity invasiveTestECOG : patient
                    .getInvasiveTestECOGList()) {
                if (invasiveTestECOG.getStatus() == 0)
                    this.printOutInvasiveTestECOG(document, patient,
                            invasiveTestECOG, locale, exportParams);
            }
        }

        if (exportParams.isInvasiveTestEEG()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.invasiveTestEEG", null,
                    locale));

            for (InvasiveTestEegEntity invasiveTestEEG : patient
                    .getInvasiveTestEEGList()) {
                if (invasiveTestEEG.getStatus() == 0)
                    this.printOutInvasiveTestEEG(document, patient,
                            invasiveTestEEG, locale, exportParams);
            }
        }

        if (exportParams.isInvasiveTestCorticalMapping()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.corticalMapping", null,
                    locale));

            for (InvasiveTestCorticalMappingEntity invasiveTestCorticalMappingEntity : patient
                    .getInvasiveTestCorticalMappingList()) {
                if (invasiveTestCorticalMappingEntity.getStatus() == 0)
                    printOutInvasiveTestCorticalMapping(document, patient,
                            invasiveTestCorticalMappingEntity, locale,
                            exportParams);
            }
        }

        if (exportParams.isOperation()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.operation", null,
                    locale));
            for (OperationEntity operation : patient.getOperationList()) {
                if (operation.getStatus() == 0)
                    this.printOutOperation(document, patient, operation, locale,
                            exportParams);
            }
        }
        if (exportParams.isHistology()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.histology", null,
                    locale));

            for (HistologyEntity histology : patient.getHistologyList()) {
                if (histology.getStatus() == 0)
                    this.printOutHistology(document, patient, histology, locale,
                            exportParams);
            }
        }
        if (exportParams.isComplication()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.complication", null,
                    locale));

            for (ComplicationEntity complication : patient
                    .getComplicationList()) {
                if (complication.getStatus() == 0)
                    this.printOutComplication(document, patient, complication,
                            locale, exportParams);
            }
        }
        if (exportParams.isOutcome()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.outcome", null,
                    locale));

            for (OutcomeEntity outcome : patient.getOutcomeList()) {
                if (outcome.getStatus() == 0)
                    this.printOutOutcome(document, patient, outcome, locale,
                            exportParams);
            }
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of anamnesis should be printed out
     */
    private void printOutAnamnesis(WordprocessingMLPackage document, PatientEntity patient,
                                   AnamnesisEntity anamnesis, Locale locale,
                                   ExportParamsEntity exportParams) {

        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.anamnesis", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(anamnesis.getDate()));

        List<String> content = new ArrayList<String>();

        if (exportParams.isAnamnesisEpilepsyInFamily()) {

            content.add(messageSource.getMessage("label.epilepsyInFamily", null,
                    locale));

            content.add(translateValue(
                    String.valueOf(anamnesis.isEpilepsyInFamily()), locale));

        }
        if (exportParams.isAnamnesisParentalRisk()) {
            content.add(messageSource.getMessage("label.prenatalRisk", null,
                    locale));

            content.add(translateValue(
                    String.valueOf(anamnesis.isPrenatalRisk()), locale));

        }
        if (exportParams.isAnamnesisFibrilConvulsions()) {
            content.add(messageSource.getMessage("label.fibrilConvulsions",
                    null, locale));


            content.add(translateValue(
                    String.valueOf(anamnesis.isFibrilConvulsions()), locale));

        }
        if (exportParams.isAnamnesisInflammationCns()) {
            content.add(messageSource.getMessage("label.inflammationCNS", null,
                    locale));

            content.add(translateValue(
                    String.valueOf(anamnesis.isInflammationCns()), locale));

        }
        if (exportParams.isAnamnesisInjuryCns()) {
            content.add(messageSource
                    .getMessage("label.injuryCNS", null, locale));

            content.add(translateValue(String.valueOf(anamnesis.isInjuryCns()),
                    locale));

        }
        if (exportParams.isAnamnesisOperationCns()) {
            content.add(messageSource.getMessage("label.operationCNS", null,
                    locale));

            content.add(translateValue(
                    String.valueOf(anamnesis.isOperationCns()), locale));

        }
        if (exportParams.isAnamnesisEarlyPmdRetardation()) {
            content.add(messageSource.getMessage("label.earlyPMDRetardation",
                    null, locale));


            content.add(translateValue(
                    String.valueOf(anamnesis.isEarlyPmdRetardation()), locale));

        }
        if (exportParams.isAnamnesisBeginningEpilepsy()) {
            content.add(messageSource.getMessage("label.beginningEpilepsy",
                    null, locale));


            content.add(translateValue(
                    TimeConverter.getDate(anamnesis.getBeginningEpilepsy()),
                    locale));

        }
        if (exportParams.isAnamnesisFirstFever()) {
            content.add(messageSource.getMessage("label.firstFever", null,
                    locale));

            content.add(translateValue(String.valueOf(anamnesis.isFirstFever()),
                    locale));

        }
        if (exportParams.isAnamnesisInfantileSpasm()) {
            content.add(messageSource.getMessage("label.infantileSpasm", null,
                    locale));

            content.add(translateValue(
                    String.valueOf(anamnesis.isInfantileSpasm()), locale));

        }
        if (exportParams.isAnamnesisSpecificSyndrome()) {
            content.add(messageSource.getMessage("label.epilepticSyndrome",
                    null, locale));


            content.add(translateValue(
                    String.valueOf(anamnesis.getSpecificSyndrome()), locale));

        }
        if (exportParams.isAnamnesisNonCnsComorbidity()) {
            content.add(messageSource.getMessage("label.nonCNSComorbidity",
                    null, locale));


            content.add(translateValue(
                    String.valueOf(anamnesis.getNonCnsComorbidity()), locale));

        }
        if (exportParams.isAnamnesisComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));

            content.add(translateValue(String.valueOf(anamnesis.getComment()),
                    locale));

        }
        int writableWidthTwips = document.getDocumentModel().getSections().get(0).getPageDimensions().getWritableWidthTwips();
        Tbl tbl = TblFactory.createTable(content.size() / 2, 2, writableWidthTwips / 2);
        document.getMainDocumentPart().addObject(tbl);
        int i = 0, j = 0;
        for (String item : content) {
            List rows = tbl.getEGContentRowContent();
            Tr row = (Tr) rows.get(i);
            List cells = row.getEGContentCellContent();

            Tc tc = (Tc) cells.get(j++);

            if ((j % 2) == 0) {
                i++;
                j = 0;
            }
            tc.getEGBlockLevelElts().add(document.getMainDocumentPart().createParagraphOfText(item));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of seizure should be printed out
     */
    private void printOutSeizure(WordprocessingMLPackage document, PatientEntity patient,
                                 SeizureEntity seizure, Locale locale,
                                 ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();


        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.seizures", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(seizure.getDate()));

        if (exportParams.isSeizureFrequency()) {
            content.add(messageSource.getMessage("label.seizureFrequency", null, locale));
            content.add(translateValue(String.valueOf(seizure.getSeizureFrequency()),
                    locale));
        }
        if (exportParams.isSeizureSecondarilyGeneralizedSeizure()) {
            content.add(messageSource.getMessage("label.secondarilyGeneralizedSeizure", null, locale));
            content.add(translateValue(String.valueOf(seizure.isSecondarilyGeneralizedSeizure()),
                    locale));
        }
        if (exportParams.isSeizureStatusEpilepticus()) {
            content.add(messageSource.getMessage("label.stausEpilepticus", null, locale));
            content.add(translateValue(String.valueOf(seizure.isStatusEpilepticus()),
                    locale));
        }
        if (exportParams.isSeizureComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));
            content.add(translateValue(String.valueOf(seizure.getComment()),
                    locale));
        }

        int writableWidthTwips = document.getDocumentModel().getSections().get(0).getPageDimensions().getWritableWidthTwips();
        Tbl tbl = TblFactory.createTable(content.size() / 2, 2, writableWidthTwips / 2);
        document.getMainDocumentPart().addObject(tbl);
        int i = 0, j = 0;
        for (String item : content) {
            List rows = tbl.getEGContentRowContent();
            Tr row = (Tr) rows.get(i);
            List cells = row.getEGContentCellContent();

            Tc tc = (Tc) cells.get(j++);

            if ((j % 2) == 0) {
                i++;
                j = 0;
            }
            tc.getEGBlockLevelElts().add(document.getMainDocumentPart().createParagraphOfText(item));
        }

        /*
        This loop goes through seizure details
         */
        for (SeizureDetailEntity seizureDetail : seizure.getSeizureDetailList()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading3", messageSource.getMessage("label.seizure_detail", null,
                    locale));


            List<String> detailContent = new ArrayList<String>();


            if (exportParams.isSeizureDetailSSCClassification()) {
                detailContent.add(messageSource.getMessage("label.seizureDetailSSCClassification", null, locale));
                detailContent.add(translateValue(String.valueOf(seizureDetail.getSscClassification()),
                        locale));
            }
            if (exportParams.isSeizureDetailILAEClassification()) {
                detailContent.add(messageSource.getMessage("label.seizureDetailILAEClassification", null, locale));
                detailContent.add(translateValue(String.valueOf(seizureDetail.getIlaeClassification()),
                        locale));
            }
            if (exportParams.isSeizureDetailComment()) {
                detailContent.add(messageSource.getMessage("label.comment", null, locale));
                detailContent.add(translateValue(String.valueOf(seizureDetail.getComment()),
                        locale));
            }
            Tbl tblDetail = TblFactory.createTable(detailContent.size() / 2, 2, writableWidthTwips / 2);
            document.getMainDocumentPart().addObject(tblDetail);
            i = 0;
            j = 0;
            for (String item : detailContent) {
                List rows = tblDetail.getEGContentRowContent();
                Tr row = (Tr) rows.get(i);
                List cells = row.getEGContentCellContent();

                Tc tc = (Tc) cells.get(j++);

                if ((j % 2) == 0) {
                    i++;
                    j = 0;
                }
                tc.getEGBlockLevelElts().add(document.getMainDocumentPart().createParagraphOfText(item));
            }
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of pharmacotherapy should be printed out
     */

    private void printOutPharmacotherapy(WordprocessingMLPackage document, PatientEntity patient,
                                         PharmacotherapyEntity pharmacotherapy, Locale locale,
                                         ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();
        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.pharmacotherapy", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(pharmacotherapy.getDate()));

        if (exportParams.isPharmacotherapyAED()) {
            content.add(messageSource.getMessage("label.", null,
                    locale));

            content.add(translateValue(
                    String.valueOf(pharmacotherapy.getAed()), locale));

        }
        if (exportParams.isPharmacotherapyEffective()) {
            content.add(messageSource.getMessage("label.aed", null,
                    locale));

            content.add(translateValue(
                    String.valueOf(pharmacotherapy.getEfficiency()), locale));

        }
        if (exportParams.isPharmacotherapyDuringSurgery()) {
            content.add(messageSource.getMessage("label.duringSurgery", null,
                    locale));

            content.add(translateValue(
                    String.valueOf(pharmacotherapy.isDuringSurgery()), locale));

        }
        if (exportParams.isPharmacotherapyComment()) {
            content.add(messageSource.getMessage("label.comment", null,
                    locale));

            content.add(translateValue(
                    String.valueOf(pharmacotherapy.getComment()), locale));

        }
        int writableWidthTwips = document.getDocumentModel().getSections().get(0).getPageDimensions().getWritableWidthTwips();
        Tbl tbl = TblFactory.createTable(content.size() / 2, 2, writableWidthTwips / 2);
        document.getMainDocumentPart().addObject(tbl);
        int i = 0, j = 0;
        for (String item : content) {
            List rows = tbl.getEGContentRowContent();
            Tr row = (Tr) rows.get(i);
            List cells = row.getEGContentCellContent();

            Tc tc = (Tc) cells.get(j++);

            if ((j % 2) == 0) {
                i++;
                j = 0;
            }
            tc.getEGBlockLevelElts().add(document.getMainDocumentPart().createParagraphOfText(item));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of neurological finding should be printed out
     */
    private void printOutNeurologicalFinding(WordprocessingMLPackage document, PatientEntity patient,
                                             NeurologicalFindingEntity neurologicalFinding, Locale locale,
                                             ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();
        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.neurologicalFinding", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(neurologicalFinding.getDate()));

        if (exportParams.isNeurologicalFindingHemisphereDominance()) {
            content.add(messageSource.getMessage("label.hemisphereDominance", null, locale));

            content.add(translateValue(String.valueOf(neurologicalFinding.getHemisphereDominance()),
                    locale));

        }
        if (exportParams.isNeurologicalFindingAbnormalNeurologicalFinding()) {
            content.add(messageSource.getMessage("label.abnormalNeurologicalFinding", null, locale));

            content.add(translateValue(String.valueOf(neurologicalFinding.isAbnormalNeurologicalFinding()),
                    locale));

        }
        if (exportParams.isNeurologicalFindingHemiparesis()) {
            content.add(messageSource.getMessage("label.hemiparesis", null, locale));

            content.add(translateValue(String.valueOf(neurologicalFinding.isHemiparesis()),
                    locale));

        }
        if (exportParams.isNeurologicalFindingVisualFieldDefects()) {
            content.add(messageSource.getMessage("label.visualFieldDefect", null, locale));

            content.add(translateValue(String.valueOf(neurologicalFinding.isVisualFieldDefects()),
                    locale));

        }
        if (exportParams.isNeurologicalFindingComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));

            content.add(translateValue(String.valueOf(neurologicalFinding.getComment()),
                    locale));

        }
        int writableWidthTwips = document.getDocumentModel().getSections().get(0).getPageDimensions().getWritableWidthTwips();
        Tbl tbl = TblFactory.createTable(content.size() / 2, 2, writableWidthTwips / 2);
        document.getMainDocumentPart().addObject(tbl);
        int i = 0, j = 0;
        for (String item : content) {
            List rows = tbl.getEGContentRowContent();
            Tr row = (Tr) rows.get(i);
            List cells = row.getEGContentCellContent();

            Tc tc = (Tc) cells.get(j++);

            if ((j % 2) == 0) {
                i++;
                j = 0;
            }
            tc.getEGBlockLevelElts().add(document.getMainDocumentPart().createParagraphOfText(item));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of neuropsychology should be printed out
     */
    private void printOutNeuropsychology(WordprocessingMLPackage document, PatientEntity patient,
                                         NeuropsychologyEntity neuropsychology, Locale locale,
                                         ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();
        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.neuropsychology", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(neuropsychology.getDate()));

        if (exportParams.isNeuropsychologyIntellect()) {
            content.add(messageSource.getMessage("label.intellect", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getIntellect()),
                    locale));

        }
        if (exportParams.isNeuropsychologyNeurodevelopmentalExamination()) {
            content.add(messageSource.getMessage("label.neurodevelopmentalExamination", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExamination()),
                    locale));

        }
        if (exportParams
                .isNeuropsychologyNeurodevelopmentalExaminationAdaptability()) {
            content.add(messageSource.getMessage("label.adaptability", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationAdaptability()),
                    locale));

        }
        if (exportParams
                .isNeuropsychologyNeurodevelopmentalExaminationSpeechExpressively()) {
            content.add(messageSource.getMessage("label.speechExpressively", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSpeechExpressively()),
                    locale));

        }
        if (exportParams
                .isNeuropsychologyNeurodevelopmentalExaminationSpeechReceptively()) {
            content.add(messageSource.getMessage("label.speechReceptively", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSpeechReceptively()),
                    locale));

        }
        if (exportParams
                .isNeuropsychologyNeurodevelopmentalExaminationFineMotorSkills()) {
            content.add(messageSource.getMessage("label.fineMotorSkills", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationFineMotorSkills()),
                    locale));

        }
        if (exportParams
                .isNeuropsychologyNeurodevelopmentalExaminationGrossMotorSkills()) {
            content.add(messageSource.getMessage("label.grossMotorSkills", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationGrossMotorSkills()),
                    locale));

        }
        if (exportParams
                .isNeuropsychologyNeurodevelopmentalExaminationSocialBehavior()) {
            content.add(messageSource.getMessage("label.socialBehavior", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSocialBehavior()),
                    locale));

        }
        if (exportParams.isNeuropsychologyIntellectualPerformance()) {
            content.add(messageSource.getMessage("label.intellectualPerformance", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getIntellectualPerformance()),
                    locale));

        }
        if (exportParams.isNeuropsychologyIntellectualPerformanceVerbally()) {
            content.add(messageSource.getMessage("label.intellectualPerformanceVerbally", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getIntellectualPerformanceVerbally()),
                    locale));

        }
        if (exportParams
                .isNeuropsychologyIntellectualPerformanceNonverbalAbstraction()) {
            content.add(messageSource.getMessage("label.intellectualPerformanceNonverbalAbstraction", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getIntellectualPerformanceNonverbalAbstraction()),
                    locale));

        }
        if (exportParams
                .isneuropsychologyIntellectualPerformanceNonverbalDesignCap()) {
            content.add(messageSource.getMessage("label.intellectualPerformanceNonverbalDesignCapabilities", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getIntellectualPerformanceNonverbalDesignCapabilities()),
                    locale));

        }
        if (exportParams.isNeuropsychologyNeuropsychologicalProfile()) {
            content.add(messageSource.getMessage("label.neuropsychologicalProfile", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfile()),
                    locale));

        }
        if (exportParams.isNeuropsychologyNeuropsychologicalProfileAttention()) {
            content.add(messageSource.getMessage("label.attention", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileAttention()),
                    locale));

        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileCognitiveSpeed()) {
            content.add(messageSource.getMessage("label.cognitiveSpeed", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileCognitiveSpeed()),
                    locale));

        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileExecutiveFunction()) {
            content.add(messageSource.getMessage("label.executiveFunction", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileExecutiveFunction()),
                    locale));

        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileSpeechExpressively()) {
            content.add(messageSource.getMessage("label.speechExpressively", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSpeechExpressively()),
                    locale));

        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileSpeechUnderstanding()) {
            content.add(messageSource.getMessage("label.speechUnderstanding", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileSpeechUnderstanding()),
                    locale));

        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileMemoryOperating()) {
            content.add(messageSource.getMessage("label.memoryOperating", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryOperating()),
                    locale));

        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileMemoryVerbal()) {
            content.add(messageSource.getMessage("label.memoryVerbal", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryVerbal()),
                    locale));

        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileMemoryNonverbal()) {
            content.add(messageSource.getMessage("label.memoryNonverbal", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryNonverbal()),
                    locale));

        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileMemoryLearning()) {
            content.add(messageSource.getMessage("label.memoryLearning", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryLearning()),
                    locale));

        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfilePerceptionSpeech()) {
            content.add(messageSource.getMessage("label.perceptionSpeech", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionSpeech()),
                    locale));

        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfilePerceptionVisual()) {
            content.add(messageSource.getMessage("label.perceptionVisual", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionVisual()),
                    locale));

        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfilePerceptionSpatial()) {
            content.add(messageSource.getMessage("label.perceptionSpatial", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionSpatial()),
                    locale));

        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileMotorSkillsDexterity()) {
            content.add(messageSource.getMessage("label.motorSkillsDexterity", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileMotorSkillsDexterity()),
                    locale));

        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileMotorCoordination()) {
            content.add(messageSource.getMessage("label.motorCoordination", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileMotorCoordination()),
                    locale));

        }
        if (exportParams.isNeuropsychologyPresenceOfChanges()) {
            content.add(messageSource.getMessage("label.presenceOfChanges", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getPresenceOfChanges()),
                    locale));

        }
        if (exportParams.isNeuropsychologyPresenceOfChangesDetail()) {
            content.add(messageSource.getMessage("label.presenceOfChangesDetail", null, locale));

            content.add(translateValue(String.valueOf(neuropsychology.getPresenceOfChangesDetail()),
                    locale));

        }
        int writableWidthTwips = document.getDocumentModel().getSections().get(0).getPageDimensions().getWritableWidthTwips();
        Tbl tbl = TblFactory.createTable(content.size() / 2, 2, writableWidthTwips / 2);
        document.getMainDocumentPart().addObject(tbl);
        int i = 0, j = 0;
        for (String item : content) {
            List rows = tbl.getEGContentRowContent();
            Tr row = (Tr) rows.get(i);
            List cells = row.getEGContentCellContent();

            Tc tc = (Tc) cells.get(j++);

            if ((j % 2) == 0) {
                i++;
                j = 0;
            }
            tc.getEGBlockLevelElts().add(document.getMainDocumentPart().createParagraphOfText(item));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of older version of neuropsychology should be printed out
     */
    private void printOutNeuropsychologyOld(WordprocessingMLPackage document, PatientEntity patient,
                                            NeuropsychologyOldEntity neuropsychologyOld, Locale locale,
                                            ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();
        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.neuropsychologyOld", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(neuropsychologyOld.getDate()));

        if (exportParams.isNeuropsychologyOldNeuropsychologicalExamination()) {
            content.add(messageSource.getMessage("label.neuropsychologicalExamination", null, locale));

            content.add(translateValue(String.valueOf(neuropsychologyOld.isNeuropsychologicalExamination()),
                    locale));

        }
        if (exportParams.isNeuropsychologyOldIntelligenceLevel()) {
            content.add(messageSource.getMessage("label.intellect", null, locale));

            content.add(translateValue(String.valueOf(neuropsychologyOld.getIntelligenceLevel()),
                    locale));

        }
        if (exportParams.isNeuropsychologyOldSpecificLearning()) {
            content.add(messageSource.getMessage("label.specificLearning", null, locale));

            content.add(translateValue(String.valueOf(neuropsychologyOld.isSpecificLearning()),
                    locale));

        }
        if (exportParams.isNeuropsychologyOldDevelopmentalLanguageDisorders()) {
            content.add(messageSource.getMessage("label.developmentalLanguageDisorders", null, locale));

            content.add(translateValue(String.valueOf(neuropsychologyOld.isDevelopmentalLanguageDisorders()),
                    locale));

        }
        if (exportParams.isNeuropsychologyOldAdhdSyndrome()) {
            content.add(messageSource.getMessage("label.ADHDSyndrome", null, locale));

            content.add(translateValue(String.valueOf(neuropsychologyOld.isAdhdSyndrome()),
                    locale));

        }
        if (exportParams.isNeuropsychologyOldComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));

            content.add(translateValue(String.valueOf(neuropsychologyOld.getComment()),
                    locale));

        }
        int writableWidthTwips = document.getDocumentModel().getSections().get(0).getPageDimensions().getWritableWidthTwips();
        Tbl tbl = TblFactory.createTable(content.size() / 2, 2, writableWidthTwips / 2);
        document.getMainDocumentPart().addObject(tbl);
        int i = 0, j = 0;
        for (String item : content) {
            List rows = tbl.getEGContentRowContent();
            Tr row = (Tr) rows.get(i);
            List cells = row.getEGContentCellContent();

            Tc tc = (Tc) cells.get(j++);

            if ((j % 2) == 0) {
                i++;
                j = 0;
            }
            tc.getEGBlockLevelElts().add(document.getMainDocumentPart().createParagraphOfText(item));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of diagnostic test EEG should be printed out
     */
    private void printOutDiagnosticTestEEG(WordprocessingMLPackage document, PatientEntity patient,
                                           DiagnosticTestScalpEegEntity diagnosticTestScalpEEG, Locale locale,
                                           ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();
        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.diagnosticTestScalpEEG", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(diagnosticTestScalpEEG.getDate()));

        if (exportParams.isDiagnosticTestEEGDone()) {
            content.add(messageSource.getMessage("label.EEGDone", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpEEG.getDone()),
                    locale));

        }
        if (exportParams.isDiagnosticTestEEGBasicActivity()) {
            content.add(messageSource.getMessage("label.basicEEGActivity", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpEEG.getBasicEegActivity()),
                    locale));

        }
        if (exportParams.isDiagnosticTestEEGSlow()) {
            content.add(messageSource.getMessage("label.EEGSlow", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpEEG.getEegSlow()),
                    locale));

        }
        if (exportParams.isDiagnosticTestEEGInterictalEEGSpikes()) {
            content.add(messageSource.getMessage("label.invasiveEEGInterictalSpikes", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpEEG.getInterictalEegSpikes()),
                    locale));

        }
        if (exportParams.isDiagnosticTestEEGLocalizationInerictalEEGSpikes()) {
            content.add(messageSource.getMessage("label.localizationInterictalEEGSpikes", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpEEG.getLocalizationInterictalEegSpikes()),
                    locale));

        }
        if (exportParams.isDiagnosticTestEEGStatusEpilepticus()) {
            content.add(messageSource.getMessage("label.EEGStatusEpilepticus", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpEEG.isEegStatusEpilepticus()),
                    locale));

        }
        if (exportParams.isDiagnosticTestEEGSecondarySidedSynchrony()) {
            content.add(messageSource.getMessage("label.secondarySidedSynchrony", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpEEG.isSecondarySidedSynchrony()),
                    locale));

        }
        if (exportParams.isDiagnosticTestEEGIctalEEGPatterns()) {
            content.add(messageSource.getMessage("label.ictalEEGPatterns", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpEEG.getIctalEegPatterns()),
                    locale));

        }
        if (exportParams.isDiagnosticTestEEGDescriptionVideoEEG()) {
            content.add(messageSource.getMessage("label.eEGDescriptionVideoEEG", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpEEG.getDescriptionVideoEeg()),
                    locale));

        }
        if (exportParams.isDiagnosticTestEEGComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpEEG.getComment()),
                    locale));

        }
        int writableWidthTwips = document.getDocumentModel().getSections().get(0).getPageDimensions().getWritableWidthTwips();
        Tbl tbl = TblFactory.createTable(content.size() / 2, 2, writableWidthTwips / 2);
        document.getMainDocumentPart().addObject(tbl);
        int i = 0, j = 0;
        for (String item : content) {
            List rows = tbl.getEGContentRowContent();
            Tr row = (Tr) rows.get(i);
            List cells = row.getEGContentCellContent();

            Tc tc = (Tc) cells.get(j++);

            if ((j % 2) == 0) {
                i++;
                j = 0;
            }
            tc.getEGBlockLevelElts().add(document.getMainDocumentPart().createParagraphOfText(item));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of diagnostic test MRI should be printed out
     */
    private void printOutDiagnosticTestMRI(WordprocessingMLPackage document, PatientEntity patient,
                                           DiagnosticTestMriEntity diagnosticTestScalpMRI, Locale locale,
                                           ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();

        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.diagnosticTestScalpMRI", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(diagnosticTestScalpMRI.getDate()));

        if (exportParams.isDiagnosticTestMRIDone()) {
            content.add(messageSource.getMessage("label.mri_done", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getDone()),
                    locale));

        }
        if (exportParams.isDiagnosticTestMRIFinding()) {
            content.add(messageSource.getMessage("label.MRIFinding", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getMriFinding()),
                    locale));

        }
        if (exportParams.isDiagnosticTestMRIDescription()) {
            content.add(messageSource.getMessage("label.descriptionMRI", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getMriDescription()),
                    locale));

        }
        if (exportParams.isDiagnosticTestMRIFdgPet()) {
            content.add(messageSource.getMessage("label.mRIFdgPet", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getFdgPet()),
                    locale));

        }
        if (exportParams.isDiagnosticTestMRIDescriptionPetHypometabolism()) {
            content.add(messageSource.getMessage("label.descriptionPetHypometabolism", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionPetHypometabolism()),
                    locale));

        }
        if (exportParams.isDiagnosticTestMRIInterictalSpect()) {
            content.add(messageSource.getMessage("label.interictalSPECT", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getInterictalSpect()),
                    locale));

        }
        if (exportParams.isDiagnosticTestMRIDescriptionSpectHypoperfuse()) {
            content.add(messageSource.getMessage("label.descriptionSPECTHypoperfuse", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionSpectHypoperfuse()),
                    locale));

        }
        if (exportParams.isDiagnosticTestMRIIctalSpect()) {
            content.add(messageSource.getMessage("label.ictalSPECT", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getIctalSpect()),
                    locale));

        }
        if (exportParams.isDiagnosticTestMRIDescriptionSpectHyperperfuse()) {
            content.add(messageSource.getMessage("label.descriptionSPECTHyperperfuse", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionSpectHyperperfuse()),
                    locale));

        }
        if (exportParams.isDiagnosticTestMRISiscom()) {
            content.add(messageSource.getMessage("label.mriSiscom", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.isSiscom()),
                    locale));

        }
        if (exportParams.isDiagnosticTestMRIMrsProtocol()) {
            content.add(messageSource.getMessage("label.MrsProtocol", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getMrsProtocol()),
                    locale));

        }
        if (exportParams.isDiagnosticTestMRIMrsFinding()) {
            content.add(messageSource.getMessage("label.MrsFinding", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getMrsFinding()),
                    locale));

        }
        if (exportParams.isDiagnosticTestMRIDescriptionMrsAbnormality()) {
            content.add(messageSource.getMessage("label.descriptionMrsAbnormality", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionMrsAbnormality()),
                    locale));

        }
        if (exportParams.isDiagnosticTestMRIFmri()) {
            content.add(messageSource.getMessage("label.FMRI", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.isFmri()),
                    locale));

        }
        if (exportParams.isDiagnosticTestMRIDetailsFmri()) {
            content.add(messageSource.getMessage("label.FMRIDetails", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getDetailsFmri()),
                    locale));

        }
        if (exportParams.isDiagnosticTestMRIDti()) {
            content.add(messageSource.getMessage("label.dti", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.isDti()),
                    locale));

        }
        if (exportParams.isDiagnosticTestMRIDetailsDtiStudy()) {
            content.add(messageSource.getMessage("label.DTIStudyDetails", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getDetailsDtiStudy()),
                    locale));

        }
        if (exportParams.isDiagnosticTestMRIWada()) {
            content.add(messageSource.getMessage("label.WADA", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.isWada()),
                    locale));

        }
        if (exportParams.isDiagnosticTestMRIDetailsWada()) {
            content.add(messageSource.getMessage("label.WADADetails", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getDetailsWada()),
                    locale));

        }
        if (exportParams.isDiagnosticTestMRIComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));

            content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getComment()),
                    locale));

        }
        int writableWidthTwips = document.getDocumentModel().getSections().get(0).getPageDimensions().getWritableWidthTwips();
        Tbl tbl = TblFactory.createTable(content.size() / 2, 2, writableWidthTwips / 2);
        document.getMainDocumentPart().addObject(tbl);
        int i = 0, j = 0;
        for (String item : content) {
            List rows = tbl.getEGContentRowContent();
            Tr row = (Tr) rows.get(i);
            List cells = row.getEGContentCellContent();

            Tc tc = (Tc) cells.get(j++);

            if ((j % 2) == 0) {
                i++;
                j = 0;
            }
            tc.getEGBlockLevelElts().add(document.getMainDocumentPart().createParagraphOfText(item));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of invasive test ECOG should be printed out
     */
    private void printOutInvasiveTestECOG(WordprocessingMLPackage document, PatientEntity patient,
                                          InvasiveTestEcogEntity invasiveTestECOG, Locale locale,
                                          ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();

        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.invasiveTestECOG", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(invasiveTestECOG.getDate()));

        if (exportParams.isInvasiveTestECOGDone()) {
            content.add(messageSource.getMessage("label.ecog_done", null, locale));

            content.add(translateValue(String.valueOf(invasiveTestECOG.getDone()),
                    locale));

        }
        if (exportParams.isInvasiveTestECOGEcogCover()) {
            content.add(messageSource.getMessage("label.ecogCover", null, locale));

            content.add(translateValue(String.valueOf(invasiveTestECOG.getEcogCover()),
                    locale));

        }
        if (exportParams.isInvasiveTestECOGEcogPatterns()) {
            content.add(messageSource.getMessage("label.ecogPatterns", null, locale));

            content.add(translateValue(String.valueOf(invasiveTestECOG.getEcogPatterns()),
                    locale));

        }
        if (exportParams.isInvasiveTestECOGAfterResectionEcog()) {
            content.add(messageSource.getMessage("label.afterResectionECoG", null, locale));

            content.add(translateValue(String.valueOf(invasiveTestECOG.getAfterResectionEcog()),
                    locale));

        }
        if (exportParams.isInvasiveTestECOGComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));

            content.add(translateValue(String.valueOf(invasiveTestECOG.getComment()),
                    locale));

        }
        int writableWidthTwips = document.getDocumentModel().getSections().get(0).getPageDimensions().getWritableWidthTwips();
        Tbl tbl = TblFactory.createTable(content.size() / 2, 2, writableWidthTwips / 2);
        document.getMainDocumentPart().addObject(tbl);
        int i = 0, j = 0;
        for (String item : content) {
            List rows = tbl.getEGContentRowContent();
            Tr row = (Tr) rows.get(i);
            List cells = row.getEGContentCellContent();

            Tc tc = (Tc) cells.get(j++);

            if ((j % 2) == 0) {
                i++;
                j = 0;
            }
            tc.getEGBlockLevelElts().add(document.getMainDocumentPart().createParagraphOfText(item));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of invasive test EEG should be printed out
     */
    private void printOutInvasiveTestEEG(WordprocessingMLPackage document, PatientEntity patient,
                                         InvasiveTestEegEntity invasiveTestEEG, Locale locale,
                                         ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();

        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.invasiveTestEEG", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(invasiveTestEEG.getDate()));

        if (exportParams.isInvasiveTestEEGDone()) {
            content.add(messageSource.getMessage("label.eeg_done", null, locale));

            content.add(translateValue(String.valueOf(invasiveTestEEG.getDone()),
                    locale));

        }
        if (exportParams.isInvasiveTestEEGIntracranialElectrodes()) {
            content.add(messageSource.getMessage("label.intracranialElectrodes", null, locale));

            content.add(translateValue(String.valueOf(invasiveTestEEG.getIntracranialElectrodes()),
                    locale));

        }
        if (exportParams.isInvasiveTestEEGLocalizationIntracranialElectrodes()) {
            content.add(messageSource.getMessage("label.localizationIntracranialElectrodes", null, locale));

            content.add(translateValue(String.valueOf(invasiveTestEEG.getLocalizationIntracranialElectrodes()),
                    locale));

        }
        if (exportParams.isInvasiveTestEEGInvasiveEEGSlow()) {
            content.add(messageSource.getMessage("label.EEGSlow", null, locale));

            content.add(translateValue(String.valueOf(invasiveTestEEG.getInvasiveEegSlow()),
                    locale));

        }
        if (exportParams.isInvasiveTestEEGInvasiveEEGInterictalSpikes()) {
            content.add(messageSource.getMessage("label.interictalEEGSpikes", null, locale));

            content.add(translateValue(String.valueOf(invasiveTestEEG.getInvasiveEegInterictalSpikes()),
                    locale));

        }
        if (exportParams
                .isInvasiveTestEEGLocalizationInvasiveEEGInterictalSpikes()) {
            content.add(messageSource.getMessage("label.localizationInterictalEEGSpikes", null, locale));

            content.add(translateValue(String.valueOf(invasiveTestEEG.getLocalizationInvasiveEegInterictalSpikes()),
                    locale));

        }
        if (exportParams.isInvasiveTestEEGStatusEpilepticus()) {
            content.add(messageSource.getMessage("label.EEGStatusEpilepticus", null, locale));

            content.add(translateValue(String.valueOf(invasiveTestEEG.isInvasiveEegStatusEpilepticus()),
                    locale));

        }
        if (exportParams.isInvasiveTestEEGInvasiveIctalEEGPatterns()) {
            content.add(messageSource.getMessage("label.ictalEEGPatterns", null, locale));

            content.add(translateValue(String.valueOf(invasiveTestEEG.getInvasiveIctalEegPatterns()),
                    locale));

        }
        if (exportParams.isInvasiveTestEEGLocalizationIctalEEGPatterns()) {
            content.add(messageSource.getMessage("label.localizationIctalEEGPattern", null, locale));

            content.add(translateValue(String.valueOf(invasiveTestEEG.getLocalizationInvasiveIctalEegPatterns()),
                    locale));

        }
        if (exportParams.isInvasiveTestEEGComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));

            content.add(translateValue(String.valueOf(invasiveTestEEG.getComment()),
                    locale));

        }
        int writableWidthTwips = document.getDocumentModel().getSections().get(0).getPageDimensions().getWritableWidthTwips();
        Tbl tbl = TblFactory.createTable(content.size() / 2, 2, writableWidthTwips / 2);
        document.getMainDocumentPart().addObject(tbl);
        int i = 0, j = 0;
        for (String item : content) {
            List rows = tbl.getEGContentRowContent();
            Tr row = (Tr) rows.get(i);
            List cells = row.getEGContentCellContent();

            Tc tc = (Tc) cells.get(j++);

            if ((j % 2) == 0) {
                i++;
                j = 0;
            }
            tc.getEGBlockLevelElts().add(document.getMainDocumentPart().createParagraphOfText(item));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of invasive test cortical mapping should be printed out
     */
    private void printOutInvasiveTestCorticalMapping(WordprocessingMLPackage document, PatientEntity patient,
                                                     InvasiveTestCorticalMappingEntity invasiveTestCorticalMapping,
                                                     Locale locale, ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();

        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.invasiveTestCorticalMapping", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(invasiveTestCorticalMapping.getDate()));

        if (exportParams.isInvasiveTestCorticalMappingDone()) {
            content.add(messageSource.getMessage("label.corticalMapping_done", null, locale));

            content.add(translateValue(String.valueOf(invasiveTestCorticalMapping.getDone()),
                    locale));

        }
        if (exportParams.isInvasiveTestCorticalMappingCorticalMapping()) {
            content.add(messageSource.getMessage("label.corticalMapping", null, locale));

            content.add(translateValue(String.valueOf(invasiveTestCorticalMapping.getCorticalMapping()),
                    locale));

        }
        if (exportParams.isInvasiveTestCorticalMappingComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));

            content.add(translateValue(String.valueOf(invasiveTestCorticalMapping.getComment()),
                    locale));

        }
        int writableWidthTwips = document.getDocumentModel().getSections().get(0).getPageDimensions().getWritableWidthTwips();
        Tbl tbl = TblFactory.createTable(content.size() / 2, 2, writableWidthTwips / 2);
        document.getMainDocumentPart().addObject(tbl);
        int i = 0, j = 0;
        for (String item : content) {
            List rows = tbl.getEGContentRowContent();
            Tr row = (Tr) rows.get(i);
            List cells = row.getEGContentCellContent();

            Tc tc = (Tc) cells.get(j++);

            if ((j % 2) == 0) {
                i++;
                j = 0;
            }
            tc.getEGBlockLevelElts().add(document.getMainDocumentPart().createParagraphOfText(item));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of operation should be printed out
     */
    private void printOutOperation(WordprocessingMLPackage document, PatientEntity patient,
                                   OperationEntity operation, Locale locale,
                                   ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();

        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.operation", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(operation.getDate()));

        if (exportParams.isOperationDateOperation()) {
            content.add(messageSource.getMessage("label.dateOfOperation", null, locale));

            content.add(translateValue(String.valueOf(operation.getDateOperation()),
                    locale));

        }
        if (exportParams.isOperationRangeOperation()) {
            content.add(messageSource.getMessage("label.dateOfOperation", null, locale));

            content.add(translateValue(String.valueOf(operation.getDateOperation()),
                    locale));

        }
        if (exportParams.isOperationTypeOperation()) {
            content.add(messageSource.getMessage("label.typeOperations", null, locale));

            content.add(translateValue(String.valueOf(operation.getTypeOperation()),
                    locale));

        }
        if (exportParams.isOperationLocalizationOperation()) {
            content.add(messageSource.getMessage("label.localizationOperations", null, locale));

            content.add(translateValue(String.valueOf(operation.getLocalizationOperation()),
                    locale));

        }
        if (exportParams.isOperationMst()) {
            content.add(messageSource.getMessage("label.mst", null, locale));

            content.add(translateValue(String.valueOf(operation.isMst()),
                    locale));

        }
        if (exportParams.isOperationColostomy()) {
            content.add(messageSource.getMessage("label.colostomy", null, locale));

            content.add(translateValue(String.valueOf(operation.isColostomy()),
                    locale));

        }
        if (exportParams.isOperationVNS()) {
            content.add(messageSource.getMessage("label.VNS", null, locale));

            content.add(translateValue(String.valueOf(operation.isVns()),
                    locale));

        }
        if (exportParams.isOperationVNsImplantationDate()) {
            content.add(messageSource.getMessage("label.VNSImplantationDate", null, locale));

            content.add(translateValue(String.valueOf(operation.getVnsImplantationDate()),
                    locale));

        }
        if (exportParams.isOperationOperationDetails()) {
            content.add(messageSource.getMessage("label.dateOfOperation", null, locale));

            content.add(translateValue(String.valueOf(operation.getDateOperation()),
                    locale));

        }
        if (exportParams.isOperationCompleteResection()) {
            content.add(messageSource.getMessage("label.completeResection", null, locale));

            content.add(translateValue(String.valueOf(operation.isCompleteResection()),
                    locale));

        }
        if (exportParams.isOperationComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));

            content.add(translateValue(String.valueOf(operation.getComment()),
                    locale));

        }
        int writableWidthTwips = document.getDocumentModel().getSections().get(0).getPageDimensions().getWritableWidthTwips();
        Tbl tbl = TblFactory.createTable(content.size() / 2, 2, writableWidthTwips / 2);
        document.getMainDocumentPart().addObject(tbl);
        int i = 0, j = 0;
        for (String item : content) {
            List rows = tbl.getEGContentRowContent();
            Tr row = (Tr) rows.get(i);
            List cells = row.getEGContentCellContent();

            Tc tc = (Tc) cells.get(j++);

            if ((j % 2) == 0) {
                i++;
                j = 0;
            }
            tc.getEGBlockLevelElts().add(document.getMainDocumentPart().createParagraphOfText(item));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of histology should be printed out
     */
    private void printOutHistology(WordprocessingMLPackage document, PatientEntity patient,
                                   HistologyEntity histology, Locale locale,
                                   ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();
        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.histology", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(histology.getDate()));

        if (exportParams.isHistologyHistopathology()) {
            content.add(messageSource.getMessage("label.histopathology", null, locale));

            content.add(translateValue(String.valueOf(histology.getHistopathology()),
                    locale));

        }
        if (exportParams.isHistologyFcdClassification()) {
            content.add(messageSource.getMessage("label.FCDClassification", null, locale));

            content.add(translateValue(String.valueOf(histology.getFcdClassification()),
                    locale));

        }
        if (exportParams.isHistologyComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));

            content.add(translateValue(String.valueOf(histology.getComment()),
                    locale));

        }
        int writableWidthTwips = document.getDocumentModel().getSections().get(0).getPageDimensions().getWritableWidthTwips();
        Tbl tbl = TblFactory.createTable(content.size() / 2, 2, writableWidthTwips / 2);
        document.getMainDocumentPart().addObject(tbl);
        int i = 0, j = 0;
        for (String item : content) {
            List rows = tbl.getEGContentRowContent();
            Tr row = (Tr) rows.get(i);
            List cells = row.getEGContentCellContent();

            Tc tc = (Tc) cells.get(j++);

            if ((j % 2) == 0) {
                i++;
                j = 0;
            }
            tc.getEGBlockLevelElts().add(document.getMainDocumentPart().createParagraphOfText(item));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of complication should be printed out
     */
    private void printOutComplication(WordprocessingMLPackage document, PatientEntity patient,
                                      ComplicationEntity complication, Locale locale,
                                      ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();
        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.complication", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(complication.getDate()));


        if (exportParams.isComplicationWithCompication()) {
            content.add(messageSource.getMessage("label.withComplications", null, locale));

            content.add(translateValue(String.valueOf(complication.getWithComplication()),
                    locale));

        }
        if (exportParams.isComplicationComplicationType()) {
            content.add(messageSource.getMessage("label.typeComplication", null, locale));

            content.add(translateValue(String.valueOf(complication.getComplicationType()),
                    locale));

        }
        if (exportParams.isComplicationComplication()) {
            content.add(messageSource.getMessage("label.complication", null, locale));

            content.add(translateValue(String.valueOf(complication.getComplication()),
                    locale));

        }
        if (exportParams.isComplicationComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));

            content.add(translateValue(String.valueOf(complication.getComment()),
                    locale));
        }
        int writableWidthTwips = document.getDocumentModel().getSections().get(0).getPageDimensions().getWritableWidthTwips();
        Tbl tbl = TblFactory.createTable(content.size() / 2, 2, writableWidthTwips / 2);
        document.getMainDocumentPart().addObject(tbl);
        int i = 0, j = 0;
        for (String item : content) {
            List rows = tbl.getEGContentRowContent();
            Tr row = (Tr) rows.get(i);
            List cells = row.getEGContentCellContent();

            Tc tc = (Tc) cells.get(j++);

            if ((j % 2) == 0) {
                i++;
                j = 0;
            }
            tc.getEGBlockLevelElts().add(document.getMainDocumentPart().createParagraphOfText(item));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of outcome should be printed out
     */
    private void printOutOutcome(WordprocessingMLPackage document, PatientEntity patient,
                                 OutcomeEntity outcome, Locale locale,
                                 ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();
        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.outcome", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(outcome.getDate()));

        if (exportParams.isOutcomeSeizureOutcome()) {
            content.add(messageSource.getMessage("label.seizures", null, locale));

            content.add(translateValue(String.valueOf(outcome.getSeizureOutcome()),
                    locale));

        }
        if (exportParams.isOutcomeEEG()) {
            content.add(messageSource.getMessage("label.eeg", null, locale));

            content.add(translateValue(String.valueOf(outcome.getEeg()),
                    locale));

        }
        if (exportParams.isOutcomeAED()) {
            content.add(messageSource.getMessage("label.aed", null, locale));

            content.add(translateValue(String.valueOf(outcome.getAed()),
                    locale));

        }
        if (exportParams.isOutcomeMRI()) {
            content.add(messageSource.getMessage("label.mri", null, locale));

            content.add(translateValue(String.valueOf(outcome.getMri()),
                    locale));

        }
        if (exportParams.isOutcomeNeuropsychology()) {
            content.add(messageSource.getMessage("label.neuropsychology", null, locale));

            content.add(translateValue(String.valueOf(outcome.getNeuropsychology()),
                    locale));

        }
        if (exportParams.isOutcomeOperationId()) {
            content.add(messageSource.getMessage("label.operationId", null, locale));

            content.add(translateValue(String.valueOf(outcome.getOperation()),
                    locale));

        }
        if (exportParams.isOutcomeComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));

            content.add(translateValue(String.valueOf(outcome.getComment()),
                    locale));

        }
        int writableWidthTwips = document.getDocumentModel().getSections().get(0).getPageDimensions().getWritableWidthTwips();
        Tbl tbl = TblFactory.createTable(content.size() / 2, 2, writableWidthTwips / 2);
        document.getMainDocumentPart().addObject(tbl);
        int i = 0, j = 0;
        for (String item : content) {
            List rows = tbl.getEGContentRowContent();
            Tr row = (Tr) rows.get(i);
            List cells = row.getEGContentCellContent();

            Tc tc = (Tc) cells.get(j++);

            if ((j % 2) == 0) {
                i++;
                j = 0;
            }
            tc.getEGBlockLevelElts().add(document.getMainDocumentPart().createParagraphOfText(item));
        }
    }

    private void printOutPatient(WordprocessingMLPackage document, PatientEntity patient, Locale locale,
                                 ExportParamsEntity exportParams, boolean anonymize) {

        List<String> content = new ArrayList<String>();

        if (exportParams.isPatientId()) {
            content.add(messageSource.getMessage("label.patient", null, locale));
            content.add(translateValue(String.valueOf(patient.getId()), locale));
        }

        if (!anonymize) {
            if (exportParams.isContactFirstName()) {
                content.add(messageSource.getMessage("label.firstname", null, locale));
                content.add(translateValue(String.valueOf(patient.getContact().getFirstName()), locale));
            }
        }
        if (!anonymize) {
            if (exportParams.isContactLastName()) {
                content.add(messageSource.getMessage("label.lastname", null, locale));
                content.add(translateValue(String.valueOf(patient.getContact().getLastName()), locale));
            }
        }
        if (!anonymize) {
            if (exportParams.isPatientNin()) {
                content.add(messageSource.getMessage("label.birthIdentificationNumber", null, locale));
                content.add(translateValue(String.valueOf(patient.getNin()), locale));
            }
        }
        if (exportParams.isPatientBirthday()) {
            content.add(messageSource.getMessage("label.birthdate", null, locale));
            content.add(translateValue(String.valueOf(patient.getBirthday()), locale));
            content.add(messageSource.getMessage("label.age", null, locale));
            content.add(translateValue(String.valueOf(getCurrentAge(patient)), locale));
        }
        if (exportParams.isPatientGender()) {
            content.add(messageSource.getMessage("label.gender", null, locale));
            content.add(messageSource.getMessage("label.gender." + translateValue(String.valueOf(patient.getGender()), locale), null, locale));
        }
        if (!anonymize) {
            if (exportParams.isContactCountry()) {
                content.add(messageSource.getMessage("label.addressCountry", null, locale));
                content.add(translateValue(String.valueOf(patient.getContact().getAddressCountry()), locale));
            }
        }
        if (!anonymize) {
            if (exportParams.isContactAddressCity()) {
                content.add(messageSource.getMessage("label.addressCity", null, locale));
                content.add(translateValue(String.valueOf(patient.getContact().getAddressCity()), locale));
            }
        }
        if (!anonymize) {
            if (exportParams.isContactAddressStreet()) {
                content.add(messageSource.getMessage("label.address", null, locale));
                content.add(translateValue(String.valueOf(patient.getContact().getAddressStreet()), locale));
            }
        }
        if (!anonymize) {
            if (exportParams.isContactAddressHn()) {
                content.add(messageSource.getMessage("label.addressHn", null, locale));
                content.add(translateValue(String.valueOf(patient.getContact().getAddressHn()), locale));
            }
        }
        if (!anonymize) {
            if (exportParams.isContactPhoneNumber()) {
                content.add(messageSource.getMessage("label.telephone", null, locale));
                content.add(translateValue(String.valueOf(patient.getContact().getPhoneNumber()), locale));
            }
        }
        if (!anonymize) {
            if (exportParams.isContactEmail()) {
                content.add(messageSource.getMessage("label.email", null, locale));
                content.add(translateValue(String.valueOf(patient.getContact().getEmail()), locale));
            }
        }
        if (exportParams.isPatientAgeAtTheBeginningOfEpilepsy()) {
            content.add(messageSource.getMessage("label.ageAtTheBeginningOfEpilepsy", null, locale));
            content.add(translateValue(String.valueOf(getAgeAtTheBeginningOfEpilepsy(patient)), locale));
        }
        if (exportParams.isPatientDoctorId()) {
            content.add(messageSource.getMessage("label.assignedDoctor", null, locale));
            content.add(translateValue(String.valueOf(userService.findByID(UserEntity.class, patient.getDoctorId()).getContact().getFirstName() + " " + userService.findByID(UserEntity.class, patient.getDoctorId()).getContact().getLastName()), locale));
        }

        int writableWidthTwips = document.getDocumentModel().getSections().get(0).getPageDimensions().getWritableWidthTwips();
        Tbl tbl = TblFactory.createTable(content.size() / 2, 2, writableWidthTwips / 2);
        document.getMainDocumentPart().addObject(tbl);
        int i = 0, j = 0;
        for (String item : content) {
            List rows = tbl.getEGContentRowContent();
            Tr row = (Tr) rows.get(i);
            List cells = row.getEGContentCellContent();

            Tc tc = (Tc) cells.get(j++);

            if ((j % 2) == 0) {
                i++;
                j = 0;
            }
            tc.getEGBlockLevelElts().add(document.getMainDocumentPart().createParagraphOfText(item));
        }
    }
}
package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import com.lowagie.text.Paragraph;
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

    private final String delimiter = ": ";

    private LoggingService logger = new LoggingService();

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
                         UserEntity user, Locale locale, ExportParamsEntity exportParams, boolean anonymize, boolean toTable) {
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

            this.addTitlePage(document, patient, locale, exportParams, anonymize, toTable);

            try {
                document.save(new java.io.File(downloadFolder + name));

            } catch (Docx4JException e) {
                e.printStackTrace();
            }
        }
        return name;
    }

    private void addTitlePage(WordprocessingMLPackage wordMLPackage, PatientEntity patient,
                              Locale locale, ExportParamsEntity exportParams, boolean anonymize, boolean toTable) {
        if (!anonymize)
            wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Title", patient.getContact().getLastName() + " " + patient.getContact().getFirstName());
        else
            wordMLPackage.getMainDocumentPart().addStyledParagraphOfText("Title", messageSource.getMessage("label.patient", null,
                    locale) + " ID " + patient.getId());
        if (toTable)
            addContentToTable(wordMLPackage, patient, locale, exportParams, anonymize);
        else
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
                //TODO: anamnesis has changed - ishistory???
                if (!anamnesis.isHistory())

                    this.printOutAnamnesis(document, patient, anamnesis, locale,
                            exportParams);
            }
        }

        if (exportParams.isSeizure()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.seizures", null,
                    locale));

            for (SeizureEntity seizure : patient.getSeizureList()) {
                if (!seizure.isHidden())
                    this.printOutSeizure(document, patient, seizure, locale,
                            exportParams);
            }
        }
        if (exportParams.isPharmacotherapy()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.pharmacotherapy", null,
                    locale));

            for (PharmacotherapyEntity pharmacotherapy : patient
                    .getPharmacotherapyList()) {
                if (!pharmacotherapy.isHidden())
                    this.printOutPharmacotherapy(document, patient,
                            pharmacotherapy, locale, exportParams);
            }
        }
        if (exportParams.isNeurologicalFinding()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.neurologicalFinding", null,
                    locale));

            for (NeurologicalFindingEntity neurologicalFinding : patient
                    .getNeurologicalFindingList()) {
                if (!neurologicalFinding.isHidden())
                    this.printOutNeurologicalFinding(document, patient,
                            neurologicalFinding, locale, exportParams);
            }
        }
        if (exportParams.isNeuropsychology()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.neuropsychology", null,
                    locale));

            for (NeuropsychologyEntity neuropsychology : patient
                    .getNeuropsychologyList()) {
                if (!neuropsychology.isHidden())
                    this.printOutNeuropsychology(document, patient,
                            neuropsychology, locale, exportParams);
            }
        }

        if (exportParams.isNeuropsychologyOld()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.neuropsychology", null,
                    locale));

            for (NeuropsychologyOldEntity neuropsychologyOld : patient
                    .getNeuropsychologyOldList()) {
                if (!neuropsychologyOld.isHidden())
                    this.printOutNeuropsychologyOld(document, patient,
                            neuropsychologyOld, locale, exportParams);
            }
        }

        if (exportParams.isDiagnosticTestEEG()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.diagnosticTestScalpEeg", null,
                    locale));
            for (DiagnosticTestScalpEegEntity diagnosticTestEEG : patient
                    .getDiagnosticTestScalpEegList()) {
                if (!diagnosticTestEEG.isHidden())
                    this.printOutDiagnosticTestEEG(document, patient,
                            diagnosticTestEEG, locale, exportParams);
            }
        }

        if (exportParams.isDiagnosticTestMRI()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.diagnosticTestsMri", null,
                    locale));
            for (DiagnosticTestMriEntity diagnosticTestMRI : patient
                    .getDiagnosticTestMRIList()) {
                if (!diagnosticTestMRI.isHidden())
                    this.printOutDiagnosticTestMRI(document, patient,
                            diagnosticTestMRI, locale, exportParams);
            }
        }

        if (exportParams.isInvasiveTestECOG()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.invasiveTestECoG", null,
                    locale));

            for (InvasiveTestEcogEntity invasiveTestECOG : patient
                    .getInvasiveTestECOGList()) {
                if (!invasiveTestECOG.isHidden())
                    this.printOutInvasiveTestECOG(document, patient,
                            invasiveTestECOG, locale, exportParams);
            }
        }

        if (exportParams.isInvasiveTestEEG()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.invasiveTestIeeg", null,
                    locale));

            for (InvasiveTestEegEntity invasiveTestEEG : patient
                    .getInvasiveTestEEGList()) {
                if (!invasiveTestEEG.isHidden())
                    this.printOutInvasiveTestEEG(document, patient,
                            invasiveTestEEG, locale, exportParams);
            }
        }

        if (exportParams.isInvasiveTestCorticalMapping()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.corticalMapping", null,
                    locale));

            for (InvasiveTestCorticalMappingEntity invasiveTestCorticalMappingEntity : patient
                    .getInvasiveTestCorticalMappingList()) {
                if (!invasiveTestCorticalMappingEntity.isHidden())
                    printOutInvasiveTestCorticalMapping(document, patient,
                            invasiveTestCorticalMappingEntity, locale,
                            exportParams);
            }
        }

        if (exportParams.isOperation()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.operation", null,
                    locale));
            for (OperationEntity operation : patient.getOperationList()) {
                if (!operation.isHidden())
                    this.printOutOperation(document, patient, operation, locale,
                            exportParams);
            }
        }
        if (exportParams.isHistology()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.histology", null,
                    locale));

            for (HistologyEntity histology : patient.getHistologyList()) {
                if (!histology.isHidden())
                    this.printOutHistology(document, patient, histology, locale,
                            exportParams);
            }
        }
        if (exportParams.isComplication()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.complication", null,
                    locale));

            for (ComplicationEntity complication : patient
                    .getComplicationList()) {
                if (!complication.isHidden())
                    this.printOutComplication(document, patient, complication,
                            locale, exportParams);
            }
        }
        if (exportParams.isOutcome()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.outcome", null,
                    locale));

            for (OutcomeEntity outcome : patient.getOutcomeList()) {
                //TODO: outcome cannot be hidden
                /*if (!outcome.isHidden())
                    this.printOutOutcome(document, patient, outcome, locale,
                            exportParams);*/
            }
        }
    }


    private void addContentToTable(WordprocessingMLPackage document, PatientEntity patient,
                                   Locale locale, ExportParamsEntity exportParams, boolean anonymize) {

        if (exportParams.isPatient()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.patient", null,
                    locale));
            this.printOutPatientToTable(document, patient, locale,
                    exportParams, anonymize);
        }

        if (exportParams.isAnamnesis()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.anamnesis", null,
                    locale));
            for (AnamnesisEntity anamnesis : patient.getAnamnesisList()) {
                //TODO: anamnesis has changed - ishistory???
                if (!anamnesis.isHistory())
                    this.printOutAnamnesisToTable(document, patient, anamnesis, locale,
                            exportParams);
            }
        }

        if (exportParams.isSeizure()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.seizures", null,
                    locale));

            for (SeizureEntity seizure : patient.getSeizureList()) {
                if (!seizure.isHidden())
                    this.printOutSeizureToTable(document, patient, seizure, locale,
                            exportParams);
            }
        }
        if (exportParams.isPharmacotherapy()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.pharmacotherapy", null,
                    locale));

            for (PharmacotherapyEntity pharmacotherapy : patient
                    .getPharmacotherapyList()) {
                if (!pharmacotherapy.isHidden())
                    this.printOutPharmacotherapyToTable(document, patient,
                            pharmacotherapy, locale, exportParams);
            }
        }
        if (exportParams.isNeurologicalFinding()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.neurologicalFinding", null,
                    locale));

            for (NeurologicalFindingEntity neurologicalFinding : patient
                    .getNeurologicalFindingList()) {
                if (!neurologicalFinding.isHidden())
                    this.printOutNeurologicalFindingToTable(document, patient,
                            neurologicalFinding, locale, exportParams);
            }
        }
        if (exportParams.isNeuropsychology()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.neuropsychology", null,
                    locale));

            for (NeuropsychologyEntity neuropsychology : patient
                    .getNeuropsychologyList()) {
                if (!neuropsychology.isHidden())
                    this.printOutNeuropsychologyToTable(document, patient,
                            neuropsychology, locale, exportParams);
            }
        }

        if (exportParams.isNeuropsychologyOld()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.neuropsychology", null,
                    locale));

            for (NeuropsychologyOldEntity neuropsychologyOld : patient
                    .getNeuropsychologyOldList()) {
                if (!neuropsychologyOld.isHidden())
                    this.printOutNeuropsychologyOldToTable(document, patient,
                            neuropsychologyOld, locale, exportParams);
            }
        }

        if (exportParams.isDiagnosticTestEEG()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.diagnosticTestScalpEeg", null,
                    locale));
            for (DiagnosticTestScalpEegEntity diagnosticTestEEG : patient
                    .getDiagnosticTestScalpEegList()) {
                if (!diagnosticTestEEG.isHidden())
                    this.printOutDiagnosticTestEEGToTable(document, patient,
                            diagnosticTestEEG, locale, exportParams);
            }
        }

        if (exportParams.isDiagnosticTestMRI()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.diagnosticTestsMri", null,
                    locale));
            for (DiagnosticTestMriEntity diagnosticTestMRI : patient
                    .getDiagnosticTestMRIList()) {
                if (!diagnosticTestMRI.isHidden())
                    this.printOutDiagnosticTestMRIToTable(document, patient,
                            diagnosticTestMRI, locale, exportParams);
            }
        }

        if (exportParams.isInvasiveTestECOG()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.invasiveTestECoG", null,
                    locale));

            for (InvasiveTestEcogEntity invasiveTestECOG : patient
                    .getInvasiveTestECOGList()) {
                if (!invasiveTestECOG.isHidden())
                    this.printOutInvasiveTestECOGToTable(document, patient,
                            invasiveTestECOG, locale, exportParams);
            }
        }

        if (exportParams.isInvasiveTestEEG()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.invasiveTestIeeg", null,
                    locale));

            for (InvasiveTestEegEntity invasiveTestEEG : patient
                    .getInvasiveTestEEGList()) {
                if (!invasiveTestEEG.isHidden())
                    this.printOutInvasiveTestEEGToTable(document, patient,
                            invasiveTestEEG, locale, exportParams);
            }
        }

        if (exportParams.isInvasiveTestCorticalMapping()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.corticalMapping", null,
                    locale));

            for (InvasiveTestCorticalMappingEntity invasiveTestCorticalMappingEntity : patient
                    .getInvasiveTestCorticalMappingList()) {
                if (!invasiveTestCorticalMappingEntity.isHidden())
                    printOutInvasiveTestCorticalMappingToTable(document, patient,
                            invasiveTestCorticalMappingEntity, locale,
                            exportParams);
            }
        }

        if (exportParams.isOperation()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.operation", null,
                    locale));
            for (OperationEntity operation : patient.getOperationList()) {
                if (!operation.isHidden())
                    this.printOutOperationToTable(document, patient, operation, locale,
                            exportParams);
            }
        }
        if (exportParams.isHistology()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.histology", null,
                    locale));

            for (HistologyEntity histology : patient.getHistologyList()) {
                if (!histology.isHidden())
                    this.printOutHistologyToTable(document, patient, histology, locale,
                            exportParams);
            }
        }
        if (exportParams.isComplication()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.complication", null,
                    locale));

            for (ComplicationEntity complication : patient
                    .getComplicationList()) {
                if (!complication.isHidden())
                    this.printOutComplicationToTable(document, patient, complication,
                            locale, exportParams);
            }
        }
        if (exportParams.isOutcome()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading1", messageSource.getMessage("label.outcome", null,
                    locale));

            for (OutcomeEntity outcome : patient.getOutcomeList()) {
                //TODO: outcome cannot be hidden
               /* if (!outcome.isHidden())
                    this.printOutOutcomeToTable(document, patient, outcome, locale,
                            exportParams);*/
            }
        }
    }


    /**
     * @param document
     * @param content  This method is used for printing out the values to the paragraph
     */

    private void printOutValues(WordprocessingMLPackage document, List<String> content) {
        boolean firstValue = true;
        Paragraph paragraph = new Paragraph();

        for (String value : content) {
            if (firstValue) {
                paragraph.add(value);
            } else {
                paragraph.add(", " + value);
            }
            firstValue = false;
        }
        document.getMainDocumentPart().addStyledParagraphOfText("Normal", paragraph.getContent());
        //document.getMainDocumentPart().addStyledParagraphOfText("Normal", patient.getContact().getLastName() + " " + patient.getContact().getFirstName());
    }

    private void printOutAnamnesis(WordprocessingMLPackage document, PatientEntity patient,
                                   AnamnesisEntity anamnesis, Locale locale,
                                   ExportParamsEntity exportParams) {

        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.anamnesis", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(anamnesis.getDate()));

        List<String> content = new ArrayList<String>();

        if (exportParams.isAnamnesisEpilepsyInFamily() && anamnesis.isEpilepsyInFamily()) {
            content.add(messageSource.getMessage("label.epilepsyInFamily", null,
                    locale));
        }
        if (exportParams.isAnamnesisParentalRisk() && anamnesis.isPrenatalRisk()) {
            content.add(messageSource.getMessage("label.prenatalRisk", null,
                    locale));
        }
        if (exportParams.isAnamnesisFibrilConvulsions() && anamnesis.isFibrilConvulsions()) {
            content.add(messageSource.getMessage("label.fibrilConvulsions",
                    null, locale));
        }
        if (exportParams.isAnamnesisInflammationCns() && anamnesis.isInflammationCns()) {
            content.add(messageSource.getMessage("label.inflammationCns", null,
                    locale));
        }
        if (exportParams.isAnamnesisInjuryCns() && anamnesis.isInjuryCns()) {
            content.add(messageSource
                    .getMessage("label.injuryCns", null, locale));
        }
        if (exportParams.isAnamnesisOperationCns() && anamnesis.isOperationCns()) {
            content.add(messageSource.getMessage("label.operationCns", null,
                    locale));
        }
        if (exportParams.isAnamnesisEarlyPmdRetardation() && anamnesis.isEarlyPmdRetardation()) {
            content.add(messageSource.getMessage("label.earlyPmdRetardation",
                    null, locale));
        }
        if (exportParams.isAnamnesisBeginningEpilepsy()) {
            content.add(messageSource.getMessage("label.beginningEpilepsy",
                    null, locale) + delimiter + translateValue(
                    TimeConverter.getDate(anamnesis.getBeginningEpilepsy()),
                    locale));
        }
        if (exportParams.isAnamnesisFirstFever() && anamnesis.isFirstFever()) {
            content.add(messageSource.getMessage("label.firstFever", null,
                    locale));
        }
        if (exportParams.isAnamnesisInfantileSpasm() && anamnesis.isInfantileSpasm()) {
            content.add(messageSource.getMessage("label.infantileSpasm", null,
                    locale));
        }
        if (exportParams.isAnamnesisSpecificSyndrome()) {
            content.add(messageSource.getMessage("label.epilepticSyndrome",
                    null, locale) + delimiter + messageSource.getMessage("label.specificSyndrome." +
                    String.valueOf(anamnesis.getSpecificSyndrome()), null, locale));
        }
        if (exportParams.isAnamnesisNonCnsComorbidity() && !anamnesis.getNonCnsComorbidity().equals("0")) {
            content.add(messageSource.getMessage("label.nonCnsComorbidity",
                    null, locale) + delimiter + translateValue(
                    String.valueOf(anamnesis.getNonCnsComorbidity()), locale));
        }


        printOutValues(document, content);

        if (exportParams.isAnamnesisComment()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Normal", messageSource.getMessage("label.comment", null, locale) + delimiter + translateComment(String.valueOf(anamnesis.getComment()),
                    locale));
        }
    }


    /**
     * Adds content according to exportParams
     * Checks what properties of anamnesis should be printed out
     */

    private void printOutAnamnesisToTable(WordprocessingMLPackage document, PatientEntity patient,
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
            content.add(messageSource.getMessage("label.inflammationCns", null,
                    locale));

            content.add(translateValue(
                    String.valueOf(anamnesis.isInflammationCns()), locale));

        }
        if (exportParams.isAnamnesisInjuryCns()) {
            content.add(messageSource
                    .getMessage("label.injuryCns", null, locale));

            content.add(translateValue(String.valueOf(anamnesis.isInjuryCns()),
                    locale));

        }
        if (exportParams.isAnamnesisOperationCns()) {
            content.add(messageSource.getMessage("label.operationCns", null,
                    locale));

            content.add(translateValue(
                    String.valueOf(anamnesis.isOperationCns()), locale));

        }
        if (exportParams.isAnamnesisEarlyPmdRetardation()) {
            content.add(messageSource.getMessage("label.earlyPmdRetardation",
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


            content.add(messageSource.getMessage("label.specificSyndrome." +
                    String.valueOf(anamnesis.getSpecificSyndrome()), null, locale));

        }
        if (exportParams.isAnamnesisNonCnsComorbidity()) {
            content.add(messageSource.getMessage("label.nonCnsComorbidity",
                    null, locale));


            content.add(translateValue(
                    String.valueOf(anamnesis.getNonCnsComorbidity()), locale));

        }
        if (exportParams.isAnamnesisComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));

            content.add(translateComment(String.valueOf(anamnesis.getComment()),
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
        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.seizures", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(seizure.getDate()));

        List<String> content = new ArrayList<String>();

        if (exportParams.isSeizureFrequency()) {
            content.add(messageSource.getMessage("label.seizureFrequency",
                    null, locale) + delimiter + messageSource.getMessage("label.seizureFrequency." +
                    String.valueOf(seizure.getSeizureFrequency()), null, locale));
        }
        if (exportParams.isSeizureSecondarilyGeneralizedSeizure() && seizure.isSecondarilyGeneralizedSeizure()) {
            content.add(messageSource.getMessage("label.secondarilyGeneralizedSeizure", null,
                    locale));
        }
        if (exportParams.isSeizureStatusEpilepticus() && seizure.isStatusEpilepticus()) {
            content.add(messageSource.getMessage("label.stausEpilepticus", null, locale));
        }

        printOutValues(document, content);

        if (exportParams.isSeizureComment()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Normal", messageSource.getMessage("label.comment", null, locale) + delimiter + translateComment(String.valueOf(seizure.getComment()),
                    locale));
        }

       /*
        This loop goes through seizure details
         */
        for (SeizureDetailEntity seizureDetail : seizure.getSeizureDetailList()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Heading3", messageSource.getMessage("label.seizureDetail", null,
                    locale));


            List<String> detailContent = new ArrayList<String>();


            if (exportParams.isSeizureSSCClassification()) {
                detailContent.add(messageSource.getMessage("label.sscClassification",
                        null, locale) + delimiter + messageSource.getMessage("label.sscClassification." +
                        String.valueOf(seizureDetail.getSscClassification()), null, locale));
            }
            if (exportParams.isSeizureILAEClassification()) {
                detailContent.add(messageSource.getMessage("label.ilaeClassification",
                        null, locale) + delimiter + messageSource.getMessage("label.ilaeClassification." +
                        String.valueOf(seizureDetail.getIlaeClassification()), null, locale));
            }

            printOutValues(document, detailContent);


            if (exportParams.isSeizureDetailComment()) {
                document.getMainDocumentPart().addStyledParagraphOfText("Normal", messageSource.getMessage("label.comment", null, locale) + delimiter + translateComment(String.valueOf(seizureDetail.getComment()),
                        locale));
            }
        }
    }

    private void printOutSeizureToTable(WordprocessingMLPackage document, PatientEntity patient,
                                        SeizureEntity seizure, Locale locale,
                                        ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();


        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.seizures", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(seizure.getDate()));

        if (exportParams.isSeizureFrequency()) {
            content.add(messageSource.getMessage("label.seizureFrequency", null, locale));
            content.add(translateValue(messageSource.getMessage("label.seizureFrequency." +
                    String.valueOf(seizure.getSeizureFrequency()), null, locale),
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
            document.getMainDocumentPart().addStyledParagraphOfText("Heading3", messageSource.getMessage("label.seizureDetail", null,
                    locale));


            List<String> detailContent = new ArrayList<String>();


            if (exportParams.isSeizureSSCClassification()) {
                detailContent.add(messageSource.getMessage("label.sscClassification", null, locale));
                detailContent.add(translateValue(messageSource.getMessage("label.sscClassification." +
                        String.valueOf(seizureDetail.getSscClassification()), null, locale),
                        locale));
            }
            if (exportParams.isSeizureILAEClassification()) {
                detailContent.add(messageSource.getMessage("label.ilaeClassification", null, locale));
                detailContent.add(translateValue(messageSource.getMessage("label.ilaeClassification." +
                        String.valueOf(seizureDetail.getIlaeClassification()), null, locale),
                        locale));
            }
            if (exportParams.isSeizureDetailComment()) {
                detailContent.add(messageSource.getMessage("label.comment", null, locale));
                detailContent.add(translateComment(String.valueOf(seizureDetail.getComment()),
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
            content.add(messageSource.getMessage("label.aed",
                    null, locale) + delimiter + messageSource.getMessage("label.aed." +
                    String.valueOf(pharmacotherapy.getAed()), null, locale));
        }
        if (exportParams.isPharmacotherapyEffective()) {
            content.add(messageSource.getMessage("label.efficiency",
                    null, locale) + delimiter + translateValue(messageSource.getMessage("label.efficiency." +
                    String.valueOf(pharmacotherapy.getEfficiency()), null, locale), locale));
        }
        if (exportParams.isPharmacotherapyDuringSurgery() && pharmacotherapy.isDuringSurgery()) {
            content.add(messageSource.getMessage("label.duringSurgery", null,
                    locale));
        }

        printOutValues(document, content);

        if (exportParams.isPharmacotherapyComment()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Normal", messageSource.getMessage("label.comment", null, locale) + delimiter + translateComment(String.valueOf(pharmacotherapy.getComment()),
                    locale));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of pharmacotherapy should be printed out
     */

    private void printOutPharmacotherapyToTable(WordprocessingMLPackage document, PatientEntity patient,
                                                PharmacotherapyEntity pharmacotherapy, Locale locale,
                                                ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();
        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.pharmacotherapy", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(pharmacotherapy.getDate()));

        if (exportParams.isPharmacotherapyAED()) {
            content.add(translateValue(messageSource.getMessage("label.aed",
                    null, locale), locale));
            content.add(messageSource.getMessage("label.aed." +
                    String.valueOf(pharmacotherapy.getAed()), null, locale));

        }
        if (exportParams.isPharmacotherapyEffective()) {
            content.add(messageSource.getMessage("label.efficiency", null,
                    locale));

            content.add(translateValue(messageSource.getMessage("label.efficiency." +
                    String.valueOf(pharmacotherapy.getEfficiency()), null, locale), locale));

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

            content.add(translateComment(
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
            content.add(messageSource.getMessage("label.hemisphereDominance",
                    null, locale) + delimiter + translateValue(messageSource.getMessage("label.hemisphereDominance." +
                    String.valueOf(neurologicalFinding.getHemisphereDominance()), null, locale), locale));
        }
        if (exportParams.isNeurologicalFindingAbnormalNeurologicalFinding() && neurologicalFinding.isAbnormalNeurologicalFinding()) {
            content.add(messageSource.getMessage("label.abnormalNeurologicalFinding", null, locale));
        }
        if (exportParams.isNeurologicalFindingHemiparesis() && neurologicalFinding.isHemiparesis()) {
            content.add(messageSource.getMessage("label.hemiparesis", null, locale));
        }
        if (exportParams.isNeurologicalFindingVisualFieldDefects() && neurologicalFinding.isVisualFieldDefects()) {
            content.add(messageSource.getMessage("label.visualFieldDefect", null, locale));
        }

        printOutValues(document, content);

        if (exportParams.isNeurologicalFindingComment()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Normal", messageSource.getMessage("label.comment", null, locale) + delimiter + translateComment(String.valueOf(neurologicalFinding.getComment()),
                    locale));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of neurological finding should be printed out
     */
    private void printOutNeurologicalFindingToTable(WordprocessingMLPackage document, PatientEntity patient,
                                                    NeurologicalFindingEntity neurologicalFinding, Locale locale,
                                                    ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();
        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.neurologicalFinding", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(neurologicalFinding.getDate()));

        if (exportParams.isNeurologicalFindingHemisphereDominance()) {
            content.add(messageSource.getMessage("label.hemisphereDominance", null, locale));

            content.add(translateValue(messageSource.getMessage("label.hemisphereDominance." +
                    String.valueOf(neurologicalFinding.getHemisphereDominance()), null, locale), locale));
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

            content.add(translateComment(String.valueOf(neurologicalFinding.getComment()),
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
            content.add(messageSource.getMessage("label.intellect",
                    null, locale) + delimiter + translateValue(messageSource.getMessage("label.intellect." +
                    String.valueOf(neuropsychology.getIntellect()), null, locale), locale));
        }

        if (neuropsychology.getIntellect() == 1) {
            if (exportParams.isNeuropsychologyNeurodevelopmentalExamination()) {
                content.add(messageSource.getMessage("label.neurodevelopmentalExamination",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExamination()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationAdaptability()) {
                content.add(messageSource.getMessage("label.adaptability",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExamination()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationSpeechExpressively()) {
                content.add(messageSource.getMessage("label.speechExpressively",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.speechExpressively." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSpeechExpressively()), null, locale), locale));
            }
            if (exportParams.isNeuropsychologyNeurodevelopmentalExaminationSpeechReceptively()) {
                content.add(messageSource.getMessage("label.speechReceptively",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSpeechReceptively()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationFineMotorSkills()) {
                content.add(messageSource.getMessage("label.fineMotorSkills",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationFineMotorSkills()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationGrossMotorSkills()) {
                content.add(messageSource.getMessage("label.grossMotorSkills",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationGrossMotorSkills()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationSocialBehavior()) {
                content.add(messageSource.getMessage("label.socialBehavior",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSocialBehavior()), null, locale), locale));
            }
        }

        if (neuropsychology.getIntellect() == 2) {
            if (exportParams.isNeuropsychologyIntellectualPerformance()) {
                content.add(messageSource.getMessage("label.intellectualPerformance",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getIntellectualPerformance()), null, locale), locale));
            }
            if (exportParams.isNeuropsychologyIntellectualPerformanceVerbally()) {
                content.add(messageSource.getMessage("label.intellectualPerformanceVerbally",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getIntellectualPerformanceVerbally()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyIntellectualPerformanceNonverbalAbstraction()) {
                content.add(messageSource.getMessage("label.intellectualPerformanceNonverbalAbstraction",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getIntellectualPerformanceNonverbalAbstraction()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyIntellectualPerformanceNonverbalDesignCap()) {
                content.add(messageSource.getMessage("label.intellectualPerformanceNonverbalDesignCapabilities",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getIntellectualPerformanceNonverbalDesignCapabilities()), null, locale), locale));
            }
        }

        if (exportParams.isNeuropsychologyNeuropsychologicalProfile()) {
            content.add(messageSource.getMessage("label.neuropsychologicalProfile",
                    null, locale) + delimiter + translateValue(messageSource.getMessage("label.neuropsychologicalProfile." +
                    String.valueOf(neuropsychology.getNeuropsychologicalProfile()), null, locale), locale));
        }

        if (neuropsychology.getNeuropsychologicalProfile() == 1) {
            if (exportParams.isNeuropsychologyNeuropsychologicalProfileAttention()) {
                content.add(messageSource.getMessage("label.attention",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileAttention()), null, locale), locale));
            }
            if (exportParams.isNeuropsychologyNeuropsychologicalProfileCognitiveSpeed()) {
                content.add(messageSource.getMessage("label.cognitiveSpeed",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileCognitiveSpeed()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfileExecutiveFunction()) {
                content.add(messageSource.getMessage("label.executiveFunction",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileExecutiveFunction()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfileSpeechExpressively()) {
                content.add(messageSource.getMessage("label.speechExpressively",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.speechExpressively." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSpeechExpressively()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfileSpeechUnderstanding()) {
                content.add(messageSource.getMessage("label.speechUnderstanding",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileSpeechUnderstanding()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfileMemoryOperating()) {
                content.add(messageSource.getMessage("label.memoryOperating",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryOperating()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfileMemoryVerbal()) {
                content.add(messageSource.getMessage("label.memoryVerbal",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryVerbal()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfileMemoryNonverbal()) {
                content.add(messageSource.getMessage("label.memoryNonverbal",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryNonverbal()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfileMemoryLearning()) {
                content.add(messageSource.getMessage("label.memoryLearning",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryLearning()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfilePerceptionSpeech()) {
                content.add(messageSource.getMessage("label.perceptionSpeech",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.perceptionOfSpeech." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionSpeech()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfilePerceptionVisual()) {
                content.add(messageSource.getMessage("label.perceptionVisual",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionVisual()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfilePerceptionSpatial()) {
                content.add(messageSource.getMessage("label.perceptionSpatial",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionSpatial()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfileMotorSkillsDexterity()) {
                content.add(messageSource.getMessage("label.motorSkillsDexterity",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileMotorSkillsDexterity()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfileMotorCoordination()) {
                content.add(messageSource.getMessage("label.motorCoordination",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileMotorCoordination()), null, locale), locale));
            }
            if (exportParams.isNeuropsychologyPresenceOfChanges()) {
                content.add(messageSource.getMessage("label.presenceOfChanges",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.presenceOfChanges." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExamination()), null, locale), locale));
            }
        }
        if (neuropsychology.getPresenceOfChanges() == 0) {
            if (exportParams.isNeuropsychologyPresenceOfChangesDetail()) {
                content.add(messageSource.getMessage("label.presenceOfChangesDetail",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getPresenceOfChangesDetail()), null, locale), locale));
            }
        }
        if (exportParams.isNeuropsychologyEmotionalStatus()) {
            content.add(messageSource.getMessage("label.emotionalState",
                    null, locale) + delimiter + translateValue(messageSource.getMessage("label.emotionalState." +
                    String.valueOf(neuropsychology.getEmotionalStatus()), null, locale), locale));
        }

        printOutValues(document, content);

        if (exportParams.isNeuropsychologyComment()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Normal", messageSource.getMessage("label.comment", null, locale) + delimiter + translateComment(String.valueOf(neuropsychology.getComment()),
                    locale));
        }
    }


    private void printOutNeuropsychologyToTable(WordprocessingMLPackage document, PatientEntity patient,
                                                NeuropsychologyEntity neuropsychology, Locale locale,
                                                ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();
        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.neuropsychology", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(neuropsychology.getDate()));

        if (exportParams.isNeuropsychologyIntellect()) {
            content.add(messageSource.getMessage("label.intellect", null, locale));

            content.add(translateValue(messageSource.getMessage("label.intellect." +
                    String.valueOf(neuropsychology.getIntellect()), null, locale), locale));
        }

        if (neuropsychology.getIntellect() == 1) {
            if (exportParams.isNeuropsychologyNeurodevelopmentalExamination()) {
                content.add(messageSource.getMessage("label.neurodevelopmentalExamination", null, locale));

                content.add(translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExamination()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationAdaptability()) {
                content.add(messageSource.getMessage("label.adaptability", null, locale));
                content.add(translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationAdaptability()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationSpeechExpressively()) {
                content.add(messageSource.getMessage("label.speechExpressively", null, locale));

                content.add(translateValue(messageSource.getMessage("label.speechExpressively." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSpeechExpressively()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationSpeechReceptively()) {
                content.add(messageSource.getMessage("label.speechReceptively", null, locale));
                content.add(translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationAdaptability()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationFineMotorSkills()) {
                content.add(messageSource.getMessage("label.fineMotorSkills", null, locale));
                content.add(translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationFineMotorSkills()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationGrossMotorSkills()) {
                content.add(messageSource.getMessage("label.grossMotorSkills", null, locale));
                content.add(translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationGrossMotorSkills()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationSocialBehavior()) {
                content.add(messageSource.getMessage("label.socialBehavior", null, locale));
                content.add(translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSocialBehavior()), null, locale), locale));
            }
        }
        if (neuropsychology.getIntellect() == 2) {
            if (exportParams.isNeuropsychologyIntellectualPerformance()) {
                content.add(messageSource.getMessage("label.intellectualPerformance", null, locale));
                content.add(translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getIntellectualPerformance()), null, locale), locale));
            }
            if (exportParams.isNeuropsychologyIntellectualPerformanceVerbally()) {
                content.add(messageSource.getMessage("label.intellectualPerformanceVerbally", null, locale));
                content.add(translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationAdaptability()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyIntellectualPerformanceNonverbalAbstraction()) {
                content.add(messageSource.getMessage("label.intellectualPerformanceNonverbalAbstraction", null, locale));
                content.add(translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getIntellectualPerformanceNonverbalAbstraction()), null, locale), locale));
            }
            if (exportParams
                    .isNeuropsychologyIntellectualPerformanceNonverbalDesignCap()) {
                content.add(messageSource.getMessage("label.intellectualPerformanceNonverbalDesignCapabilities", null, locale));
                content.add(translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getIntellectualPerformanceNonverbalDesignCapabilities()), null, locale), locale));
            }
            if (exportParams.isNeuropsychologyNeuropsychologicalProfile()) {
                content.add(messageSource.getMessage("label.neuropsychologicalProfile", null, locale));
                content.add(translateValue(messageSource.getMessage("label.neuropsychologicalProfile." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfile()), null, locale), locale));
            }
            if (neuropsychology.getNeuropsychologicalProfile() == 1) {

                if (exportParams.isNeuropsychologyNeuropsychologicalProfileAttention()) {
                    content.add(messageSource.getMessage("label.attention", null, locale));
                    content.add(translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileAttention()), null, locale), locale));
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfileCognitiveSpeed()) {
                    content.add(messageSource.getMessage("label.cognitiveSpeed", null, locale));
                    content.add(translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileCognitiveSpeed()), null, locale), locale));
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfileExecutiveFunction()) {
                    content.add(messageSource.getMessage("label.executiveFunction", null, locale));
                    content.add(translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileExecutiveFunction()), null, locale), locale));
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfileSpeechExpressively()) {
                    content.add(messageSource.getMessage("label.speechExpressively", null, locale));
                    content.add(translateValue(messageSource.getMessage("label.speechExpressively." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileSpeechExpressively()), null, locale), locale));
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfileSpeechUnderstanding()) {
                    content.add(messageSource.getMessage("label.speechUnderstanding", null, locale));
                    content.add(translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileSpeechUnderstanding()), null, locale), locale));
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfileMemoryOperating()) {
                    content.add(messageSource.getMessage("label.memoryOperating", null, locale));
                    content.add(translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryOperating()), null, locale), locale));
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
                    content.add(translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryNonverbal()), null, locale), locale));

                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfileMemoryLearning()) {
                    content.add(messageSource.getMessage("label.memoryLearning", null, locale));
                    content.add(translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryLearning()), null, locale), locale));
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfilePerceptionSpeech()) {
                    content.add(messageSource.getMessage("label.perceptionSpeech", null, locale));
                    content.add(translateValue(messageSource.getMessage("label.perceptionOfSpeech." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionSpeech()), null, locale), locale));
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfilePerceptionVisual()) {
                    content.add(messageSource.getMessage("label.perceptionVisual", null, locale));
                    content.add(translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionVisual()), null, locale), locale));
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfilePerceptionSpatial()) {
                    content.add(messageSource.getMessage("label.perceptionSpatial", null, locale));
                    content.add(translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionSpatial()), null, locale), locale));
                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfileMotorSkillsDexterity()) {
                    content.add(messageSource.getMessage("label.motorSkillsDexterity", null, locale));
                    content.add(translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileMotorSkillsDexterity()), null, locale), locale));

                }
                if (exportParams
                        .isNeuropsychologyNeuropsychologicalProfileMotorCoordination()) {
                    content.add(messageSource.getMessage("label.motorCoordination", null, locale));
                    content.add(translateValue(messageSource.getMessage("label.deficit." +
                            String.valueOf(neuropsychology.getNeuropsychologicalProfileMotorCoordination()), null, locale), locale));
                }
            }
            if (exportParams.isNeuropsychologyPresenceOfChanges()) {
                content.add(messageSource.getMessage("label.presenceOfChanges", null, locale));
                content.add(translateValue(messageSource.getMessage("label.presenceOfChanges." +
                        String.valueOf(neuropsychology.getPresenceOfChanges()), null, locale), locale));
            }
        }
        if (neuropsychology.getPresenceOfChanges() == 0) {
            if (exportParams.isNeuropsychologyPresenceOfChangesDetail()) {
                content.add(messageSource.getMessage("label.presenceOfChangesDetail", null, locale));
                content.add(translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getPresenceOfChangesDetail()), null, locale), locale));
            }
        }

        if (exportParams.isNeuropsychologyEmotionalStatus()) {
            content.add(messageSource.getMessage("label.emotionalState", null, locale));
            content.add(translateValue(messageSource.getMessage("label.emotionalState." +
                    String.valueOf(neuropsychology.getEmotionalStatus()), null, locale), locale));
        }

        if (exportParams.isNeuropsychologyComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));

            content.add(translateComment(String.valueOf(neuropsychology.getComment()),
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

        if (exportParams.isNeuropsychologyOldNeuropsychologicalExamination() && neuropsychologyOld.isNeuropsychologicalExamination()) {
            content.add(messageSource.getMessage("label.neuropsychologicalExamination", null, locale));
        }
        if (exportParams.isNeuropsychologyOldIntelligenceLevel()) {
            content.add(messageSource.getMessage("label.intellect",
                    null, locale) + delimiter + translateValue(
                    String.valueOf(neuropsychologyOld.getIntelligenceLevel()), locale));
        }
        if (exportParams.isNeuropsychologyOldSpecificLearning() && neuropsychologyOld.isSpecificLearning()) {
            content.add(messageSource.getMessage("label.specificLearning", null, locale));
        }
        if (exportParams.isNeuropsychologyOldDevelopmentalLanguageDisorders() && neuropsychologyOld.isDevelopmentalLanguageDisorders()) {
            content.add(messageSource.getMessage("label.developmentalLanguageDisorders", null, locale));
        }
        if (exportParams.isNeuropsychologyOldAdhdSyndrome() && neuropsychologyOld.isAdhdSyndrome()) {
            content.add(messageSource.getMessage("label.adhdSyndrome", null, locale));
        }

        printOutValues(document, content);

        if (exportParams.isNeuropsychologyOldComment()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Normal", messageSource.getMessage("label.comment", null, locale) + delimiter + translateComment(String.valueOf(neuropsychologyOld.getComment()),
                    locale));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of older version of neuropsychology should be printed out
     */
    private void printOutNeuropsychologyOldToTable(WordprocessingMLPackage document, PatientEntity patient,
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
            content.add(messageSource.getMessage("label.adhdSyndrome", null, locale));

            content.add(translateValue(String.valueOf(neuropsychologyOld.isAdhdSyndrome()),
                    locale));

        }
        if (exportParams.isNeuropsychologyOldComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));

            content.add(translateComment(String.valueOf(neuropsychologyOld.getComment()),
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
        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.diagnosticTestScalpEeg", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(diagnosticTestScalpEEG.getDate()));

        if (exportParams.isDiagnosticTestEEGDone()) {
            content.add(messageSource.getMessage("label.eegDone",
                    null, locale) + delimiter + translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(diagnosticTestScalpEEG.getDone()), null, locale), locale));
        }
        if (diagnosticTestScalpEEG.getDone() == 2) {
            if (exportParams.isDiagnosticTestEEGBasicActivity()) {
                content.add(messageSource.getMessage("label.basicEegActivity",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.basicEegActivity." +
                        String.valueOf(diagnosticTestScalpEEG.getBasicEegActivity()), null, locale), locale));
            }
            if (exportParams.isDiagnosticTestEEGSlow()) {
                content.add(messageSource.getMessage("label.eegSlow",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.eegSlow." +
                        String.valueOf(diagnosticTestScalpEEG.getEegSlow()), null, locale), locale));
            }
            if (exportParams.isDiagnosticTestEEGInterictalEEGSpikes()) {
                content.add(messageSource.getMessage("label.invasiveEegInterictalSpikes",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.interictalEegSpikes." +
                        String.valueOf(diagnosticTestScalpEEG.getDone()), null, locale), locale));
            }
            if (exportParams.isDiagnosticTestEEGLocalizationInerictalEEGSpikes()) {
                content.add(messageSource.getMessage("label.interictalEegSpikes",
                        null, locale) + delimiter + translateValue(String.valueOf(diagnosticTestScalpEEG.getInterictalEegSpikes()), locale));
            }
            if (exportParams.isDiagnosticTestEEGStatusEpilepticus() && diagnosticTestScalpEEG.isEegStatusEpilepticus()) {
                content.add(messageSource.getMessage("label.EegStatusEpilepticus", null, locale));
            }
            if (exportParams.isDiagnosticTestEEGSecondarySidedSynchrony() && diagnosticTestScalpEEG.isSecondarySidedSynchrony()) {
                content.add(messageSource.getMessage("label.secondarySidedSynchrony", null, locale));
            }
            if (exportParams.isDiagnosticTestEEGIctalEEGPatterns()) {
                content.add(messageSource.getMessage("label.ictalEegPatterns",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.ictalEegPatterns." +
                        String.valueOf(diagnosticTestScalpEEG.getIctalEegPatterns()), null, locale), locale));
            }
            if (exportParams.isDiagnosticTestEEGDescriptionVideoEEG()) {
                content.add(messageSource.getMessage("label.descriptionVideoEeg",
                        null, locale) + delimiter + translateValue(String.valueOf(diagnosticTestScalpEEG.getDone()), locale));
            }
        }
        printOutValues(document, content);

        if (exportParams.isDiagnosticTestEEGComment()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Normal", messageSource.getMessage("label.comment", null, locale) + delimiter + translateComment(String.valueOf(diagnosticTestScalpEEG.getComment()),
                    locale));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of diagnostic test EEG should be printed out
     */
    private void printOutDiagnosticTestEEGToTable(WordprocessingMLPackage document, PatientEntity patient,
                                                  DiagnosticTestScalpEegEntity diagnosticTestScalpEEG, Locale locale,
                                                  ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();
        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.diagnosticTestScalpEeg", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(diagnosticTestScalpEEG.getDate()));

        if (exportParams.isDiagnosticTestEEGDone()) {
            content.add(messageSource.getMessage("label.eegDone", null, locale));

            content.add(translateValue(messageSource.getMessage("label.eegDone." +
                    String.valueOf(diagnosticTestScalpEEG.getDone()), null, locale), locale));

        }
        if (diagnosticTestScalpEEG.getDone() == 2) {
            if (exportParams.isDiagnosticTestEEGBasicActivity()) {
                content.add(messageSource.getMessage("label.basicEegActivity", null, locale));
                content.add(translateValue(messageSource.getMessage("label.basicEegActivity." +
                        String.valueOf(diagnosticTestScalpEEG.getBasicEegActivity()), null, locale), locale));
            }
            if (exportParams.isDiagnosticTestEEGSlow()) {
                content.add(messageSource.getMessage("label.eegSlow", null, locale));

                content.add(translateValue(messageSource.getMessage("label.eegSlow." +
                        String.valueOf(diagnosticTestScalpEEG.getEegSlow()), null, locale), locale));

            }
            if (exportParams.isDiagnosticTestEEGInterictalEEGSpikes()) {
                content.add(messageSource.getMessage("label.invasiveEegInterictalSpikes", null, locale));
                content.add(translateValue(messageSource.getMessage("label.interictalEegSpikes." +
                        String.valueOf(diagnosticTestScalpEEG.getInterictalEegSpikes()), null, locale), locale));
            }
            if (exportParams.isDiagnosticTestEEGLocalizationInerictalEEGSpikes()) {
                content.add(messageSource.getMessage("label.localizationInvasiveEegInterictalSpikes", null, locale));

                content.add(translateValue(String.valueOf(diagnosticTestScalpEEG.getLocalizationInterictalEegSpikes()),
                        locale));

            }
            if (exportParams.isDiagnosticTestEEGStatusEpilepticus()) {
                content.add(messageSource.getMessage("label.EegStatusEpilepticus", null, locale));

                content.add(translateValue(String.valueOf(diagnosticTestScalpEEG.isEegStatusEpilepticus()),
                        locale));

            }
            if (exportParams.isDiagnosticTestEEGSecondarySidedSynchrony()) {
                content.add(messageSource.getMessage("label.secondarySidedSynchrony", null, locale));

                content.add(translateValue(String.valueOf(diagnosticTestScalpEEG.isSecondarySidedSynchrony()),
                        locale));

            }
            if (exportParams.isDiagnosticTestEEGIctalEEGPatterns()) {
                content.add(messageSource.getMessage("label.ictalEegPatterns", null, locale));
                content.add(translateValue(messageSource.getMessage("label.ecogPatterns." +
                        String.valueOf(diagnosticTestScalpEEG.getIctalEegPatterns()), null, locale), locale));

            }
            if (exportParams.isDiagnosticTestEEGDescriptionVideoEEG()) {
                content.add(messageSource.getMessage("label.descriptionVideoEeg", null, locale));

                content.add(translateValue(String.valueOf(diagnosticTestScalpEEG.getDescriptionVideoEeg()),
                        locale));

            }

            if (exportParams.isDiagnosticTestEEGComment()) {
                content.add(messageSource.getMessage("label.comment", null, locale));

                content.add(translateComment(String.valueOf(diagnosticTestScalpEEG.getComment()),
                        locale));

            }
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

        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.diagnosticTestsMri", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(diagnosticTestScalpMRI.getDate()));

        if (exportParams.isDiagnosticTestMRIDone()) {
            content.add(messageSource.getMessage("label.mri_done",
                    null, locale) + delimiter + translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(diagnosticTestScalpMRI.getDone()), null, locale), locale));
        }

        if (diagnosticTestScalpMRI.getDone() == 2) {

            if (exportParams.isDiagnosticTestMRIFinding()) {
                content.add(messageSource.getMessage("label.mriFinding",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.resultType." +
                        String.valueOf(diagnosticTestScalpMRI.getMriFinding()), null, locale), locale));
            }
            if (exportParams.isDiagnosticTestMRIDescription()) {
                content.add(messageSource.getMessage("label.descriptionMri",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(diagnosticTestScalpMRI.getMriDescription()), locale));
            }
            if (exportParams.isDiagnosticTestMRIFdgPet()) {
                content.add(messageSource.getMessage("label.fdgPet",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.resultType." +
                        String.valueOf(diagnosticTestScalpMRI.getFdgPet()), null, locale), locale));
            }
            if (exportParams.isDiagnosticTestMRIDescriptionPetHypometabolism()) {
                content.add(messageSource.getMessage("label.descriptionPetHypometabolism",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(diagnosticTestScalpMRI.getDescriptionPetHypometabolism()), locale));
            }
            if (exportParams.isDiagnosticTestMRIInterictalSpect()) {
                content.add(messageSource.getMessage("label.interictalSpect",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.resultType." +
                        String.valueOf(diagnosticTestScalpMRI.getInterictalSpect()), null, locale), locale));
            }
            if (exportParams.isDiagnosticTestMRIDescriptionSpectHypoperfuse()) {
                content.add(messageSource.getMessage("label.descriptionSpectHypoperfuse",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(diagnosticTestScalpMRI.getDescriptionSpectHypoperfuse()), locale));
            }
            if (exportParams.isDiagnosticTestMRIIctalSpect()) {
                content.add(messageSource.getMessage("label.ictalSPECT",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.resultType." +
                        String.valueOf(diagnosticTestScalpMRI.getIctalSpect()), null, locale), locale));
            }
            if (exportParams.isDiagnosticTestMRIDescriptionSpectHyperperfuse()) {
                content.add(messageSource.getMessage("label.descriptionSpectHyperperfuse",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(diagnosticTestScalpMRI.getDescriptionSpectHyperperfuse()), locale));
            }
            if (exportParams.isDiagnosticTestMRISiscom() && diagnosticTestScalpMRI.isSiscom()) {
                content.add(messageSource.getMessage("label.siscom",
                        null, locale));
            }
            if (exportParams.isDiagnosticTestMRIMrsProtocol()) {
                content.add(messageSource.getMessage("label.mrsProtocol",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.mrsProtocol." +
                        String.valueOf(diagnosticTestScalpMRI.getMriFinding()), null, locale), locale));
            }
            if (exportParams.isDiagnosticTestMRIMrsFinding()) {
                content.add(messageSource.getMessage("label.mrsFinding",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.resultType." +
                        String.valueOf(diagnosticTestScalpMRI.getMriFinding()), null, locale), locale));
            }
            if (exportParams.isDiagnosticTestMRIDescriptionMrsAbnormality()) {
                content.add(messageSource.getMessage("label.descriptionMrsAbnormality",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(diagnosticTestScalpMRI.getDescriptionMrsAbnormality()), locale));
            }
            if (exportParams.isDiagnosticTestMRIFmri() && diagnosticTestScalpMRI.isFmri()) {
                content.add(messageSource.getMessage("label.FMRI",
                        null, locale));
            }
            if (exportParams.isDiagnosticTestMRIDetailsFmri()) {
                content.add(messageSource.getMessage("label.fmriDetails",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(diagnosticTestScalpMRI.getDetailsFmri()), locale));
            }
            if (exportParams.isDiagnosticTestMRIDti() && diagnosticTestScalpMRI.isDti()) {
                content.add(messageSource.getMessage("label.dti",
                        null, locale));
            }
            if (exportParams.isDiagnosticTestMRIDetailsDtiStudy()) {
                content.add(messageSource.getMessage("label.dtiStudyDetails",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(diagnosticTestScalpMRI.getDetailsDtiStudy()), locale));
            }
            if (exportParams.isDiagnosticTestMRIWada() && diagnosticTestScalpMRI.isWada()) {
                content.add(messageSource.getMessage("label.wada", null, locale));
            }
            if (exportParams.isDiagnosticTestMRIDetailsWada()) {
                content.add(messageSource.getMessage("label.wadaDetails",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(diagnosticTestScalpMRI.getDetailsWada()), locale));
            }

            printOutValues(document, content);
        }
        if (exportParams.isDiagnosticTestMRIComment()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Normal", messageSource.getMessage("label.comment", null, locale) + delimiter + translateComment(String.valueOf(diagnosticTestScalpMRI.getComment()),
                    locale));
        }

    }

    /**
     * Adds content according to exportParams
     * Checks what properties of diagnostic test MRI should be printed out
     */
    private void printOutDiagnosticTestMRIToTable(WordprocessingMLPackage document, PatientEntity patient,
                                                  DiagnosticTestMriEntity diagnosticTestScalpMRI, Locale locale,
                                                  ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();

        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.diagnosticTestsMri", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(diagnosticTestScalpMRI.getDate()));

        if (exportParams.isDiagnosticTestMRIDone()) {
            content.add(messageSource.getMessage("label.mri_done", null, locale));

            content.add(translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(diagnosticTestScalpMRI.getDone()), null, locale), locale));

        }
        if (diagnosticTestScalpMRI.getDone() == 2) {
            if (exportParams.isDiagnosticTestMRIFinding()) {
                content.add(messageSource.getMessage("label.mriFinding", null, locale));

                content.add(translateValue(messageSource.getMessage("label.resultType." +
                        String.valueOf(diagnosticTestScalpMRI.getMriFinding()), null, locale), locale));

            }
            if (exportParams.isDiagnosticTestMRIDescription()) {
                content.add(messageSource.getMessage("label.descriptionMri", null, locale));

                content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getMriDescription()),
                        locale));

            }
            if (exportParams.isDiagnosticTestMRIFdgPet()) {
                content.add(messageSource.getMessage("label.fdgPet", null, locale));

                content.add(translateValue(messageSource.getMessage("label.resultType." +
                        String.valueOf(diagnosticTestScalpMRI.getFdgPet()), null, locale), locale));
            }
            if (exportParams.isDiagnosticTestMRIDescriptionPetHypometabolism()) {
                content.add(messageSource.getMessage("label.descriptionPetHypometabolism", null, locale));

                content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionPetHypometabolism()),
                        locale));

            }
            if (exportParams.isDiagnosticTestMRIInterictalSpect()) {
                content.add(messageSource.getMessage("label.interictalSpect", null, locale));
                content.add(translateValue(messageSource.getMessage("label.resultType." +
                        String.valueOf(diagnosticTestScalpMRI.getInterictalSpect()), null, locale), locale));
            }
            if (exportParams.isDiagnosticTestMRIDescriptionSpectHypoperfuse()) {
                content.add(messageSource.getMessage("label.descriptionSpectHypoperfuse", null, locale));

                content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionSpectHypoperfuse()),
                        locale));

            }
            if (exportParams.isDiagnosticTestMRIIctalSpect()) {
                content.add(messageSource.getMessage("label.ictalSPECT", null, locale));
                content.add(translateValue(messageSource.getMessage("label.resultType." +
                        String.valueOf(diagnosticTestScalpMRI.getIctalSpect()), null, locale), locale));
            }
            if (exportParams.isDiagnosticTestMRIDescriptionSpectHyperperfuse()) {
                content.add(messageSource.getMessage("label.descriptionSpectHyperperfuse", null, locale));

                content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionSpectHyperperfuse()),
                        locale));

            }
            if (exportParams.isDiagnosticTestMRISiscom()) {
                content.add(messageSource.getMessage("label.siscom", null, locale));

                content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.isSiscom()),
                        locale));

            }
            if (exportParams.isDiagnosticTestMRIMrsProtocol()) {
                content.add(messageSource.getMessage("label.mrsProtocol", null, locale));
                content.add(translateValue(messageSource.getMessage("label.mrsProtocol." +
                        String.valueOf(diagnosticTestScalpMRI.getMrsProtocol()), null, locale), locale));
            }
            if (exportParams.isDiagnosticTestMRIMrsFinding()) {
                content.add(messageSource.getMessage("label.mrsFinding", null, locale));
                content.add(translateValue(messageSource.getMessage("label.resultType." +
                        String.valueOf(diagnosticTestScalpMRI.getMrsFinding()), null, locale), locale));
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
                content.add(messageSource.getMessage("label.fmriDetails", null, locale));

                content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getDetailsFmri()),
                        locale));

            }
            if (exportParams.isDiagnosticTestMRIDti()) {
                content.add(messageSource.getMessage("label.dti", null, locale));

                content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.isDti()),
                        locale));

            }
            if (exportParams.isDiagnosticTestMRIDetailsDtiStudy()) {
                content.add(messageSource.getMessage("label.dtiStudyDetails", null, locale));

                content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getDetailsDtiStudy()),
                        locale));

            }
            if (exportParams.isDiagnosticTestMRIWada()) {
                content.add(messageSource.getMessage("label.wada", null, locale));

                content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.isWada()),
                        locale));

            }
            if (exportParams.isDiagnosticTestMRIDetailsWada()) {
                content.add(messageSource.getMessage("label.wadaDetails", null, locale));

                content.add(translateValue(String.valueOf(diagnosticTestScalpMRI.getDetailsWada()),
                        locale));

            }
        }
        if (exportParams.isDiagnosticTestMRIComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));

            content.add(translateComment(String.valueOf(diagnosticTestScalpMRI.getComment()),
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
            content.add(messageSource.getMessage("label.ecog_done",
                    null, locale) + delimiter + translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(invasiveTestECOG.getDone()), null, locale), locale));
        }
        if (invasiveTestECOG.getDone() == 2) {
            if (exportParams.isInvasiveTestECOGEcogCover()) {
                content.add(messageSource.getMessage("label.ecogCover",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(invasiveTestECOG.getEcogCover()), locale));
            }
            if (exportParams.isInvasiveTestECOGEcogPatterns()) {
                content.add(messageSource.getMessage("label.ecogPatterns",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.ecogPatterns." +
                        String.valueOf(invasiveTestECOG.getEcogPatterns()), null, locale), locale));
            }
            if (exportParams.isInvasiveTestECOGAfterResectionEcog()) {
                content.add(messageSource.getMessage("label.ecogAfterResection",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.afterResectionEcog." +
                        String.valueOf(invasiveTestECOG.getAfterResectionEcog()), null, locale), locale));
            }

            printOutValues(document, content);

            if (exportParams.isDiagnosticTestMRIComment()) {
                document.getMainDocumentPart().addStyledParagraphOfText("Normal", messageSource.getMessage("label.comment", null, locale) + delimiter + translateComment(String.valueOf(invasiveTestECOG.getComment()),
                        locale));
            }
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of invasive test ECOG should be printed out
     */
    private void printOutInvasiveTestECOGToTable(WordprocessingMLPackage document, PatientEntity patient,
                                                 InvasiveTestEcogEntity invasiveTestECOG, Locale locale,
                                                 ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();

        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.invasiveTestECOG", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(invasiveTestECOG.getDate()));

        if (exportParams.isInvasiveTestECOGDone()) {
            content.add(messageSource.getMessage("label.ecog_done", null, locale));

            content.add(translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(invasiveTestECOG.getDone()), null, locale), locale));
        }
        if (invasiveTestECOG.getDone() == 2) {
            if (exportParams.isInvasiveTestECOGEcogCover()) {
                content.add(messageSource.getMessage("label.ecogCover", null, locale));

                content.add(translateValue(String.valueOf(invasiveTestECOG.getEcogCover()),
                        locale));

            }
            if (exportParams.isInvasiveTestECOGEcogPatterns()) {
                content.add(messageSource.getMessage("label.ecogPatterns", null, locale));

                content.add(translateValue(messageSource.getMessage("label.ecogPatterns." +
                        String.valueOf(invasiveTestECOG.getEcogPatterns()), null, locale), locale));

            }
            if (exportParams.isInvasiveTestECOGAfterResectionEcog()) {
                content.add(messageSource.getMessage("label.ecogAfterResection", null, locale));

                content.add(translateValue(messageSource.getMessage("label.afterResectionEcog." +
                        String.valueOf(invasiveTestECOG.getAfterResectionEcog()), null, locale), locale));

            }
            if (exportParams.isInvasiveTestECOGComment()) {
                content.add(messageSource.getMessage("label.comment", null, locale));

                content.add(translateComment(String.valueOf(invasiveTestECOG.getComment()),
                        locale));
            }
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

        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.invasiveTestIeeg", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(invasiveTestEEG.getDate()));

        if (exportParams.isInvasiveTestEEGDone()) {
            content.add(messageSource.getMessage("label.ieegDone",
                    null, locale) + delimiter + translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(invasiveTestEEG.getDone()), null, locale), locale));
        }
        if (invasiveTestEEG.getDone() == 1) {

            if (exportParams.isInvasiveTestEEGIntracranialElectrodes()) {
                content.add(messageSource.getMessage("label.intracranialElectrodes",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.intracranialElectrodes." +
                        String.valueOf(invasiveTestEEG.getIntracranialElectrodes()), null, locale), locale));
            }
            if (exportParams.isInvasiveTestEEGLocalizationIntracranialElectrodes()) {
                content.add(messageSource.getMessage("label.localizationIntracranialElectrodes",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(invasiveTestEEG.getLocalizationIntracranialElectrodes()), locale));
            }
            if (exportParams.isInvasiveTestEEGInvasiveEEGSlow()) {
                content.add(messageSource.getMessage("label.eegSlow",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.eegSlow." +
                        String.valueOf(invasiveTestEEG.getInvasiveEegSlow()), null, locale), locale));
            }
            if (exportParams.isInvasiveTestEEGInvasiveEEGInterictalSpikes()) {
                content.add(messageSource.getMessage("label.interictalEegSpikes",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.interictalEegSpikes." +
                        String.valueOf(invasiveTestEEG.getInvasiveEegInterictalSpikes()), null, locale), locale));
            }
            if (exportParams
                    .isInvasiveTestEEGLocalizationInvasiveEEGInterictalSpikes()) {
                content.add(messageSource.getMessage("label.localizationInterictalEEGSpikes",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(invasiveTestEEG.getLocalizationInvasiveEegInterictalSpikes()), locale));
            }
            if (exportParams.isInvasiveTestEEGStatusEpilepticus() && invasiveTestEEG.isInvasiveEegStatusEpilepticus()) {
                content.add(messageSource.getMessage("label.EegStatusEpilepticus", null, locale));
            }
            if (exportParams.isInvasiveTestEEGInvasiveIctalEEGPatterns()) {
                content.add(messageSource.getMessage("label.ictalEegPatterns",
                        null, locale) + delimiter + translateValue(messageSource.getMessage("label.ictalEegPatterns." +
                        String.valueOf(invasiveTestEEG.getInvasiveIctalEegPatterns()), null, locale), locale));
            }
            if (exportParams.isInvasiveTestEEGLocalizationIctalEEGPatterns()) {
                content.add(messageSource.getMessage("label.localizationIctalEegPattern",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(invasiveTestEEG.getLocalizationInvasiveIctalEegPatterns()), locale));
            }

            printOutValues(document, content);

            if (exportParams.isInvasiveTestEEGComment()) {
                document.getMainDocumentPart().addStyledParagraphOfText("Normal", messageSource.getMessage("label.comment", null, locale) + delimiter + translateComment(String.valueOf(invasiveTestEEG.getComment()),
                        locale));
            }
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of invasive test EEG should be printed out
     */
    private void printOutInvasiveTestEEGToTable(WordprocessingMLPackage document, PatientEntity patient,
                                                InvasiveTestEegEntity invasiveTestEEG, Locale locale,
                                                ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();

        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.invasiveTestIeeg", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(invasiveTestEEG.getDate()));

        if (exportParams.isInvasiveTestEEGDone()) {
            content.add(messageSource.getMessage("label.ieegDone", null, locale));

            content.add(translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(invasiveTestEEG.getDone()), null, locale), locale));

        }
        if (invasiveTestEEG.getDone() == 1) {
            if (exportParams.isInvasiveTestEEGIntracranialElectrodes()) {
                content.add(messageSource.getMessage("label.intracranialElectrodes", null, locale));

                content.add(translateValue(messageSource.getMessage("label.intracranialElectrodes." +
                        String.valueOf(invasiveTestEEG.getIntracranialElectrodes()), null, locale), locale));

            }
            if (exportParams.isInvasiveTestEEGLocalizationIntracranialElectrodes()) {
                content.add(messageSource.getMessage("label.localizationIntracranialElectrodes", null, locale));

                content.add(translateValue(String.valueOf(invasiveTestEEG.getLocalizationIntracranialElectrodes()),
                        locale));

            }
            if (exportParams.isInvasiveTestEEGInvasiveEEGSlow()) {
                content.add(messageSource.getMessage("label.eegSlow", null, locale));


                content.add(translateValue(messageSource.getMessage("label.eegSlow." +
                        String.valueOf(invasiveTestEEG.getInvasiveEegSlow()), null, locale), locale));
            }
            if (exportParams.isInvasiveTestEEGInvasiveEEGInterictalSpikes()) {
                content.add(messageSource.getMessage("label.interictalEegSpikes", null, locale));

                content.add(translateValue(messageSource.getMessage("label.interictalEegSpikes." +
                        String.valueOf(invasiveTestEEG.getInvasiveEegInterictalSpikes()), null, locale), locale));
            }
            if (exportParams
                    .isInvasiveTestEEGLocalizationInvasiveEEGInterictalSpikes()) {
                content.add(messageSource.getMessage("label.localizationInterictalEEGSpikes", null, locale));

                content.add(translateValue(String.valueOf(invasiveTestEEG.getLocalizationInvasiveEegInterictalSpikes()),
                        locale));

            }
            if (exportParams.isInvasiveTestEEGStatusEpilepticus()) {
                content.add(messageSource.getMessage("label.EegStatusEpilepticus", null, locale));

                content.add(translateValue(String.valueOf(invasiveTestEEG.isInvasiveEegStatusEpilepticus()),
                        locale));

            }
            if (exportParams.isInvasiveTestEEGInvasiveIctalEEGPatterns()) {
                content.add(messageSource.getMessage("label.ictalEegPatterns", null, locale));

                content.add(translateValue(messageSource.getMessage("label.ictalEegPatterns." +
                        String.valueOf(invasiveTestEEG.getInvasiveIctalEegPatterns()), null, locale), locale));
            }
            if (exportParams.isInvasiveTestEEGLocalizationIctalEEGPatterns()) {
                content.add(messageSource.getMessage("label.localizationIctalEegPattern", null, locale));

                content.add(translateValue(String.valueOf(invasiveTestEEG.getLocalizationInvasiveIctalEegPatterns()),
                        locale));

            }
            if (exportParams.isInvasiveTestEEGComment()) {
                content.add(messageSource.getMessage("label.comment", null, locale));

                content.add(translateComment(String.valueOf(invasiveTestEEG.getComment()),
                        locale));

            }
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
            content.add(messageSource.getMessage("label.corticalMappingDone",
                    null, locale) + delimiter +
                    translateValue(messageSource.getMessage("label.done." +
                            String.valueOf(invasiveTestCorticalMapping.getDone()), null, locale), locale));
        }
        if (invasiveTestCorticalMapping.getDone() == 1) {
            if (exportParams.isInvasiveTestCorticalMappingCorticalMapping()) {
                content.add(messageSource.getMessage("label.corticalMapping",
                        null, locale) + delimiter +
                        translateValue(messageSource.getMessage("label.corticalMapping." +
                                String.valueOf(invasiveTestCorticalMapping.getCorticalMapping()), null, locale), locale));
            }

            printOutValues(document, content);

            if (exportParams.isInvasiveTestCorticalMappingComment()) {
                document.getMainDocumentPart().addStyledParagraphOfText("Normal", messageSource.getMessage("label.comment", null, locale) + delimiter + translateComment(String.valueOf(invasiveTestCorticalMapping.getComment()),
                        locale));
            }
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of invasive test cortical mapping should be printed out
     */
    private void printOutInvasiveTestCorticalMappingToTable(WordprocessingMLPackage document, PatientEntity patient,
                                                            InvasiveTestCorticalMappingEntity invasiveTestCorticalMapping,
                                                            Locale locale, ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();

        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.invasiveTestCorticalMapping", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(invasiveTestCorticalMapping.getDate()));

        if (exportParams.isInvasiveTestCorticalMappingDone()) {
            content.add(messageSource.getMessage("label.corticalMappingDone", null, locale));

            content.add(translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(invasiveTestCorticalMapping.getDone()), null, locale), locale));

        }
        if (exportParams.isInvasiveTestCorticalMappingCorticalMapping()) {
            content.add(messageSource.getMessage("label.corticalMapping", null, locale));

            content.add(translateValue(messageSource.getMessage("label.corticalMapping." +
                    String.valueOf(invasiveTestCorticalMapping.getCorticalMapping()), null, locale), locale));

        }
        if (exportParams.isInvasiveTestCorticalMappingComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));

            content.add(translateComment(String.valueOf(invasiveTestCorticalMapping.getComment()),
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
            content.add(messageSource.getMessage("label.rangeOfOperation",
                    null, locale) + delimiter + translateValue(messageSource.getMessage("label.operationRange." +
                    String.valueOf(operation.getRangeOperation()), null, locale), locale));
        }
        if (exportParams.isOperationTypeOperation()) {
            content.add(messageSource.getMessage("label.typeOfOperation",
                    null, locale) + delimiter + translateValue(messageSource.getMessage("label.operationType." +
                    String.valueOf(operation.getTypeOperation()), null, locale), locale));
        }
        if (exportParams.isOperationLocalizationOperation()) {
            content.add(messageSource.getMessage("label.localizationOfOperation",
                    null, locale) + delimiter + translateValue(
                    String.valueOf(operation.getLocalizationOperation()), locale));
        }
        if (exportParams.isOperationMst() && operation.isMst()) {
            content.add(messageSource.getMessage("label.mst", null, locale));

        }
        if (exportParams.isOperationColostomy() && operation.isColostomy()) {
            content.add(messageSource.getMessage("label.calosotomy", null, locale));
        }
        if (exportParams.isOperationVNS() && operation.isVns()) {
            content.add(messageSource.getMessage("label.vns", null, locale));
        }
        if (exportParams.isOperationVNsImplantationDate()) {
            content.add(messageSource.getMessage("label.vnsImplantationDate",
                    null, locale) + delimiter + translateValue(
                    String.valueOf(operation.getVnsImplantationDate()), locale));
        }
        if (exportParams.isOperationOperationDetails()) {
            content.add(messageSource.getMessage("label.operationDetails",
                    null, locale) + delimiter + translateValue(
                    String.valueOf(operation.getOperationDetails()), locale));
        }
        if (exportParams.isOperationCompleteResection()) {
            content.add(messageSource.getMessage("label.completeResection", null, locale));
        }

        printOutValues(document, content);

        if (exportParams.isOperationComment()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Normal", messageSource.getMessage("label.comment", null, locale) + delimiter + translateComment(String.valueOf(operation.getComment()),
                    locale));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of operation should be printed out
     */
    private void printOutOperationToTable(WordprocessingMLPackage document, PatientEntity patient,
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

            content.add(translateValue(messageSource.getMessage("label.operationRange." +
                    String.valueOf(operation.getRangeOperation()), null, locale), locale));

        }
        if (exportParams.isOperationTypeOperation()) {
            content.add(messageSource.getMessage("label.typeOfOperation", null, locale));

            content.add(translateValue(messageSource.getMessage("label.operationType." +
                    String.valueOf(operation.getTypeOperation()), null, locale), locale));

        }
        if (exportParams.isOperationLocalizationOperation()) {
            content.add(messageSource.getMessage("label.localizationOfOperation", null, locale));

            content.add(translateValue(String.valueOf(operation.getLocalizationOperation()),
                    locale));

        }
        if (exportParams.isOperationMst()) {
            content.add(messageSource.getMessage("label.mst", null, locale));

            content.add(translateValue(String.valueOf(operation.isMst()),
                    locale));

        }
        if (exportParams.isOperationColostomy()) {
            content.add(messageSource.getMessage("label.calosotomy", null, locale));

            content.add(translateValue(String.valueOf(operation.isColostomy()),
                    locale));

        }
        if (exportParams.isOperationVNS()) {
            content.add(messageSource.getMessage("label.vns", null, locale));

            content.add(translateValue(String.valueOf(operation.isVns()),
                    locale));

        }
        if (exportParams.isOperationVNsImplantationDate()) {
            content.add(messageSource.getMessage("label.vnsImplantationDate", null, locale));

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

            content.add(translateComment(String.valueOf(operation.getComment()),
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
            content.add(messageSource.getMessage("label.histopathology",
                    null, locale) + delimiter + translateValue(messageSource.getMessage("label.histopathology." +
                    String.valueOf(histology.getHistopathology()), null, locale), locale));
        }
        if (histology.getHistopathology() == 2)
            if (exportParams.isHistologyFcdClassification()) {
                content.add(messageSource.getMessage("label.fcdClassification",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(histology.getFcdClassification()), locale));
            }

        printOutValues(document, content);

        if (exportParams.isHistologyComment()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Normal", messageSource.getMessage("label.comment", null, locale) + delimiter + translateComment(String.valueOf(histology.getComment()),
                    locale));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of histology should be printed out
     */
    private void printOutHistologyToTable(WordprocessingMLPackage document, PatientEntity patient,
                                          HistologyEntity histology, Locale locale,
                                          ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();
        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.histology", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(histology.getDate()));

        if (exportParams.isHistologyHistopathology()) {
            content.add(messageSource.getMessage("label.histopathology", null, locale));

            content.add(translateValue(messageSource.getMessage("label.histopathology." +
                    String.valueOf(histology.getHistopathology()), null, locale), locale));

        }
        if (exportParams.isHistologyFcdClassification()) {
            content.add(messageSource.getMessage("label.fcdClassification", null, locale));

            content.add(translateValue(String.valueOf(histology.getFcdClassification()),
                    locale));

        }
        if (exportParams.isHistologyComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));

            content.add(translateComment(String.valueOf(histology.getComment()),
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
            content.add(messageSource.getMessage("label.withComplications",
                    null, locale) + delimiter + translateValue(messageSource.getMessage("label.process." +
                    String.valueOf(complication.getWithComplication()), null, locale), locale));
        }
        if (exportParams.isComplicationComplicationType()) {
            content.add(messageSource.getMessage("label.typeComplication",
                    null, locale) + delimiter + translateValue(messageSource.getMessage("label.complicationType." +
                    String.valueOf(complication.getComplicationType()), null, locale), locale));
        }
        if (exportParams.isComplicationComplication()) {
            content.add(messageSource.getMessage("label.complication",
                    null, locale) + delimiter + translateValue(messageSource.getMessage("label.complication." +
                    String.valueOf(complication.getComplication()), null, locale), locale));
        }

        printOutValues(document, content);
        if (exportParams.isComplicationComment()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Normal", messageSource.getMessage("label.comment", null, locale) + delimiter + translateComment(String.valueOf(complication.getComment()),
                    locale));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of complication should be printed out
     */
    private void printOutComplicationToTable(WordprocessingMLPackage document, PatientEntity patient,
                                             ComplicationEntity complication, Locale locale,
                                             ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();
        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.complication", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(complication.getDate()));


        if (exportParams.isComplicationWithCompication()) {
            content.add(messageSource.getMessage("label.withComplications", null, locale));

            content.add(translateValue(messageSource.getMessage("label.process." +
                    String.valueOf(complication.getWithComplication()), null, locale), locale));

        }
        if (exportParams.isComplicationComplicationType()) {
            content.add(messageSource.getMessage("label.typeComplication", null, locale));

            content.add(translateValue(messageSource.getMessage("label.complicationType." +
                    String.valueOf(complication.getComplicationType()), null, locale), locale));

        }
        if (exportParams.isComplicationComplication()) {
            content.add(messageSource.getMessage("label.complication", null, locale));

            content.add(translateValue(messageSource.getMessage("label.complication." +
                    String.valueOf(complication.getComplication()), null, locale), locale));

        }
        if (exportParams.isComplicationComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));

            content.add(translateComment(String.valueOf(complication.getComment()),
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
            content.add(messageSource.getMessage("label.seizures",
                    null, locale) + delimiter + translateValue(messageSource.getMessage("label.seizureOutcome." +
                    String.valueOf(outcome.getSeizureOutcome()), null, locale), locale));

        }
        if (exportParams.isOutcomeEEG()) {
            content.add(messageSource.getMessage("label.eeg",
                    null, locale) + delimiter + translateValue(messageSource.getMessage("label.outcomeEeg." +
                    String.valueOf(outcome.getEeg()), null, locale), locale));
        }
        if (exportParams.isOutcomeAED()) {
            content.add(messageSource.getMessage("label.aed",
                    null, locale) + delimiter + translateValue(messageSource.getMessage("label.outcomeAed" +
                    String.valueOf(outcome.getAed()), null, locale), locale));
        }
        if (exportParams.isOutcomeMRI()) {
            content.add(messageSource.getMessage("label.mri",
                    null, locale) + delimiter + translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(outcome.getMri()), null, locale), locale));
        }
        if (exportParams.isOutcomeNeuropsychology()) {
            content.add(messageSource.getMessage("label.neuropsychology",
                    null, locale) + delimiter + translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(outcome.getNeuropsychology()), null, locale), locale));
        }

        printOutValues(document, content);

        if (exportParams.isOutcomeComment()) {
            document.getMainDocumentPart().addStyledParagraphOfText("Normal", messageSource.getMessage("label.comment", null, locale) + delimiter + translateComment(String.valueOf(outcome.getComment()),
                    locale));
        }
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of outcome should be printed out
     */
    private void printOutOutcomeToTable(WordprocessingMLPackage document, PatientEntity patient,
                                        OutcomeEntity outcome, Locale locale,
                                        ExportParamsEntity exportParams) {
        List<String> content = new ArrayList<String>();
        document.getMainDocumentPart().addStyledParagraphOfText("Heading2", messageSource.getMessage("label.outcome", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": " + TimeConverter.getDate(outcome.getDate()));

        if (exportParams.isOutcomeSeizureOutcome()) {
            content.add(messageSource.getMessage("label.seizures", null, locale));

            content.add(translateValue(messageSource.getMessage("label.seizureOutcome." +
                    String.valueOf(outcome.getSeizureOutcome()), null, locale), locale));

        }
        if (exportParams.isOutcomeEEG()) {
            content.add(messageSource.getMessage("label.eeg", null, locale));

            content.add(translateValue(messageSource.getMessage("label.outcomeEeg." +
                    String.valueOf(outcome.getEeg()), null, locale), locale));

        }
        if (exportParams.isOutcomeAED()) {
            content.add(messageSource.getMessage("label.aed", null, locale));

            content.add(translateValue(messageSource.getMessage("label.outcomeAed" +
                    String.valueOf(outcome.getAed()), null, locale), locale));

        }
        if (exportParams.isOutcomeMRI()) {
            content.add(messageSource.getMessage("label.mri", null, locale));

            content.add(translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(outcome.getMri()), null, locale), locale));

        }
        if (exportParams.isOutcomeNeuropsychology()) {
            content.add(messageSource.getMessage("label.neuropsychology", null, locale));

            content.add(translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(outcome.getNeuropsychology()), null, locale), locale));
        }
        if (exportParams.isOutcomeComment()) {
            content.add(messageSource.getMessage("label.comment", null, locale));

            content.add(translateComment(String.valueOf(outcome.getComment()),
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
            content.add(messageSource.getMessage("label.patient",
                    null, locale) + delimiter + translateValue(
                    String.valueOf(patient.getId()), locale));
        }

        if (!anonymize) {
            if (exportParams.isContactFirstName()) {
                content.add(messageSource.getMessage("label.firstname",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(patient.getContact().getFirstName()), locale));
            }
        }
        if (!anonymize) {
            if (exportParams.isContactLastName()) {
                content.add(messageSource.getMessage("label.lastname",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(patient.getContact().getLastName()), locale));
            }
        }
        if (!anonymize) {
            if (exportParams.isPatientNin()) {
                content.add(messageSource.getMessage("label.birthIdentificationNumber",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(patient.getNin()), locale));
            }
        }
        if (exportParams.isPatientBirthday()) {
            content.add(messageSource.getMessage("label.birthdate",
                    null, locale) + delimiter + translateValue(
                    String.valueOf(patient.getBirthday()), locale));
            content.add(messageSource.getMessage("label.age",
                    null, locale) + delimiter + translateValue(
                    String.valueOf(getCurrentAge(patient)), locale));
        }
        if (exportParams.isPatientGender()) {
            content.add(messageSource.getMessage("label.gender",
                    null, locale) + delimiter + messageSource.getMessage("label.gender." + translateValue(String.valueOf(patient.getGender()), locale), null, locale));
        }
        if (!anonymize) {
            if (exportParams.isContactCountry()) {
                content.add(messageSource.getMessage("label.addressCountry",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(patient.getContact().getAddressCountry()), locale));
            }
        }
        if (!anonymize) {
            if (exportParams.isContactAddressCity()) {
                content.add(messageSource.getMessage("label.addressCity",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(patient.getContact().getAddressCity()), locale));
            }
        }
        if (!anonymize) {
            if (exportParams.isContactAddressStreet()) {
                content.add(messageSource.getMessage("label.address",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(patient.getContact().getAddressStreet()), locale));
            }
        }
        if (!anonymize) {
            if (exportParams.isContactAddressHn()) {
                content.add(messageSource.getMessage("label.addressHn",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(patient.getContact().getAddressHn()), locale));
            }
        }
        if (!anonymize) {
            if (exportParams.isContactPhoneNumber()) {
                content.add(messageSource.getMessage("label.telephone",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(patient.getContact().getPhoneNumber()), locale));
            }
        }
        if (!anonymize) {
            if (exportParams.isContactEmail()) {
                content.add(messageSource.getMessage("label.email",
                        null, locale) + delimiter + translateValue(
                        String.valueOf(patient.getContact().getEmail()), locale));
            }
        }
        if (exportParams.isPatientAgeAtTheBeginningOfEpilepsy()) {
            content.add(messageSource.getMessage("label.ageAtTheBeginningOfEpilepsy",
                    null, locale) + delimiter + translateValue(
                    String.valueOf(getAgeAtTheBeginningOfEpilepsy(patient)), locale));
        }
        if (exportParams.isPatientDoctorId()) {
            content.add(messageSource.getMessage("label.assignedDoctor",
                    null, locale) + delimiter + translateValue(String.valueOf(userService.findByID(UserEntity.class, patient.getDoctorId()).getContact().getFirstName() + " " + userService.findByID(UserEntity.class, patient.getDoctorId()).getContact().getLastName()), locale));
        }

        content.add(messageSource.getMessage("label.dateOfExport",
                null, locale) + delimiter + translateValue(
                String.valueOf(TimeConverter.getDate(Calendar.getInstance().getTime())), locale));

        printOutValues(document, content);
    }


    private void printOutPatientToTable(WordprocessingMLPackage document, PatientEntity patient, Locale locale,
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

        content.add(messageSource.getMessage("label.dateOfExport", null, locale));
        content.add(translateValue(String.valueOf(TimeConverter.getDate(Calendar.getInstance().getTime())), locale));


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
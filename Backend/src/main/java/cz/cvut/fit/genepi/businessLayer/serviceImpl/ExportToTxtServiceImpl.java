package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.service.ExportToTxtService;
import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.*;
import cz.cvut.fit.genepi.util.LoggingService;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Service
public class ExportToTxtServiceImpl implements ExportToTxtService {

    @Autowired
    private MessageSource messageSource;

    /**
     * The Constant logger.
     */
    private LoggingService logger = new LoggingService();

    private String translateValue(String value, Locale locale) {
        if (value.equals("true")) {
            return messageSource.getMessage("label.yes", null, locale);
        } else if (value.equals("false")) {
            return messageSource.getMessage("label.no", null, locale);
        } else {
            if (value.equals("null") || value.equals(null)) {
                return messageSource.getMessage("label.null", null, locale);
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

    /**
     * Creates new file and calls methods to fill this file with relevant content according to the exportParams.
     * Location for Windows OS is here set only for testing
     */
    public String export(java.util.List<PatientEntity> patientList,
                         UserEntity user, Locale locale, ExportParamsEntity exportParams) {
        logger.setLogger(ExportToTxtServiceImpl.class);
        String date = getDate();
        String name = date + ".txt";

        String downloadFolder = System.getProperty("user.home")
                + System.getProperty("file.separator") + "Download_Links"
                + System.getProperty("file.separator");
        File f;
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
                        "Couldn't create new file when trying to save txt file.",
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
                        "Couldn't create new file when trying to save txt file.",
                        e);
            }
        }

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(f.getAbsoluteFile()), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            logger.logError(
                    "UnsupportedEncodingException when trying to init writer for txt file.",
                    e);
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            logger.logError(
                    "FileNotFoundException when trying to init writer for txt file.",
                    e);
            e.printStackTrace();
        }
        String content = "";
        for (PatientEntity patient : patientList) {
            content += addTitlePage(locale, patient, date);
            content += addContent(patient, locale, exportParams);
        }
        try {
            bw.write(content);
        } catch (IOException e) {
            logger.logError("Exception when trying to write to txt file.", e);
            e.printStackTrace();
        }
        try {
            bw.close();
        } catch (IOException e) {
            logger.logError("Exception when trying to close txt file.", e);
            e.printStackTrace();
        }
        return name;
    }

    /**
     * Creates empty line
     */
    private String addEmptyLine() {
        String emptyLine = "";
        for (int i = 0; i != 50; i++) {
            emptyLine += " ";
        }
        return ("\n" + emptyLine + "\n");
    }

    /**
     * Creates dash line
     */
    private String addDashLine() {
        String emptyLine = "";
        for (int i = 0; i != 50; i++) {
            emptyLine += "-";
        }
        return ("\n" + emptyLine + "\n" + "\n");
    }

    /**
     * Creates star line
     */
    private String addStarLine() {
        String emptyLine = "";
        for (int i = 0; i != 50; i++) {
            emptyLine += "*";
        }
        return ("\n" + emptyLine + "\n" + "\n");
    }

    /**
     * Creates title page for certain patient
     */
    private String addTitlePage(Locale locale, PatientEntity patient,
                                String date) {
        String content = "Export of the patient "
                + patient.getContact().getFirstName() + " "
                + patient.getContact().getLastName() + " :" + patient.getId()
                + " " + date + "\n";

        content += addEmptyLine();
        content += ("Report generated by: " + System.getProperty("user.name")
                + ", " + new Date() + "\n");
        content += addEmptyLine();
        return content;
    }

    /**
     * Adds content according to exportParams
     * If card should printed out, then suitable method is called
     */
    private String addContent(PatientEntity patient, Locale locale,
                              ExportParamsEntity exportParams) {
        String content = "";

        if (exportParams.isAnamnesis()) {
            content += addStarLine();
            for (AnamnesisEntity anamnesis : patient.getAnamnesisList()) {
                content += this.printOutAnamnesis(patient, anamnesis, locale,
                        exportParams);
                content += addDashLine();
            }
        }
        if (exportParams.isSeizure()) {
            content += addStarLine();
            for (SeizureEntity seizure : patient.getSeizureList()) {
                content += this.printOutSeizure(patient, seizure, locale,
                        exportParams);
            }
        }
        if (exportParams.isPharmacotherapy()) {
            content += addStarLine();
            for (PharmacotherapyEntity pharmacotherapy : patient
                    .getPharmacotherapyList()) {
                content += this.printOutPharmacotherapy(patient,
                        pharmacotherapy, locale, exportParams);
            }
        }
        if (exportParams.isNeurologicalFinding()) {
            content += addStarLine();
            for (NeurologicalFindingEntity neurologicalFinding : patient
                    .getNeurologicalFindingList()) {
                content += this.printOutNeurologicalFinding(patient,
                        neurologicalFinding, locale, exportParams);
            }
        }
        if (exportParams.isNeuropsychology()) {
            content += addStarLine();
            for (NeuropsychologyEntity neuropsychology : patient
                    .getNeuropsychologyList()) {
                content += this.printOutNeuropsychology(patient,
                        neuropsychology, locale, exportParams);
            }
        }

        if (exportParams.isNeuropsychologyOld()) {
            content += addStarLine();
            for (NeuropsychologyOldEntity neuropsychologyOld : patient
                    .getNeuropsychologyOldList()) {
                content += this.printOutNeuropsychologyOld(patient,
                        neuropsychologyOld, locale, exportParams);
            }
        }

        if (exportParams.isDiagnosticTestEEG()) {
            content += addStarLine();
            for (DiagnosticTestScalpEEGEntity diagnosticTestEEG : patient
                    .getDiagnosticTestEEGList()) {
                content += this.printOutDiagnosticTestEEG(patient,
                        diagnosticTestEEG, locale, exportParams);
            }
        }

        if (exportParams.isDiagnosticTestMRI()) {
            content += addStarLine();
            for (DiagnosticTestMRIEntity diagnosticTestMRI : patient
                    .getDiagnosticTestMRIList()) {
                content += this.printOutDiagnosticTestMRI(patient,
                        diagnosticTestMRI, locale, exportParams);
            }
        }

        if (exportParams.isInvasiveTestECOG()) {
            content += addStarLine();
            for (InvasiveTestECOGEntity invasiveTestECOG : patient
                    .getInvasiveTestECOGList()) {
                content += this.printOutInvasiveTestECOG(patient,
                        invasiveTestECOG, locale, exportParams);
            }
        }

        if (exportParams.isInvasiveTestEEG()) {
            content += addStarLine();
            for (InvasiveTestEEGEntity invasiveTestEEG : patient
                    .getInvasiveTestEEGList()) {
                content += this.printOutInvasiveTestEEG(patient,
                        invasiveTestEEG, locale, exportParams);
            }
        }

        if (exportParams.isInvasiveTestCorticalMapping()) {
            content += addStarLine();
            for (InvasiveTestCorticalMappingEntity invasiveTestCorticalMappingEntity : patient
                    .getInvasiveTestCorticalMappingList()) {
                content += this
                        .printOutInvasiveTestCorticalMapping(patient,
                                invasiveTestCorticalMappingEntity, locale,
                                exportParams);
            }
        }

        if (exportParams.isOperation()) {
            for (OperationEntity operation : patient.getOperationList()) {
                content += this.printOutOperation(patient, operation, locale,
                        exportParams);
            }
        }
        if (exportParams.isHistology()) {
            for (HistologyEntity histology : patient.getHistologyList()) {
                content += this.printOutHistology(patient, histology, locale,
                        exportParams);
            }
        }
        if (exportParams.isComplication()) {
            for (ComplicationEntity complication : patient
                    .getComplicationList()) {
                content += this.printOutComplication(patient, complication,
                        locale, exportParams);
            }
        }
        if (exportParams.isOutcome()) {
            for (OutcomeEntity outcome : patient.getOutcomeList()) {
                content += this.printOutOutcome(patient, outcome, locale,
                        exportParams);
            }
        }

        return content;
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of anamnesis should be printed out
     */
    private String printOutAnamnesis(PatientEntity patient,
                                     AnamnesisEntity anamnesis, Locale locale,
                                     ExportParamsEntity exportParams) {
        String content = "";
        content += messageSource.getMessage("label.anamnesis", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(anamnesis.getDate());
        content += "\n";

        if (exportParams.isAnamnesisEpilepsyInFamily()) {

            content += messageSource.getMessage("label.epilepsyInFamily", null,
                    locale);
            content += " - ";
            content += translateValue(
                    String.valueOf(anamnesis.isEpilepsyInFamily()), locale);
            content += "\n";
        }
        if (exportParams.isAnamnesisParentalRisk()) {
            content += messageSource.getMessage("label.prenatalRisk", null,
                    locale);
            content += " - ";
            content += translateValue(
                    String.valueOf(anamnesis.isPrenatalRisk()), locale);
            content += "\n";
        }
        if (exportParams.isAnamnesisFibrilConvulsions()) {
            content += messageSource.getMessage("label.fibrilConvulsions",
                    null, locale);

            content += " - ";
            content += translateValue(
                    String.valueOf(anamnesis.isFibrilConvulsions()), locale);
            content += "\n";
        }
        if (exportParams.isAnamnesisInflammationCns()) {
            content += messageSource.getMessage("label.inflammationCNS", null,
                    locale);
            content += " - ";
            content += translateValue(
                    String.valueOf(anamnesis.isInflammationCns()), locale);
            content += "\n";
        }
        if (exportParams.isAnamnesisInjuryCns()) {
            content += messageSource
                    .getMessage("label.injuryCNS", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(anamnesis.isInjuryCns()),
                    locale);
            content += "\n";
        }
        if (exportParams.isAnamnesisOperationCns()) {
            content += messageSource.getMessage("label.operationCNS", null,
                    locale);
            content += " - ";
            content += translateValue(
                    String.valueOf(anamnesis.isOperationCns()), locale);
            content += "\n";
        }
        if (exportParams.isAnamnesisEarlyPmdRetardation()) {
            content += messageSource.getMessage("label.earlyPMDRetardation",
                    null, locale);

            content += " - ";
            content += translateValue(
                    String.valueOf(anamnesis.isEarlyPmdRetardation()), locale);
            content += "\n";
        }
        if (exportParams.isAnamnesisBeginningEpilepsy()) {
            content += messageSource.getMessage("label.beginningEpilepsy",
                    null, locale);

            content += " - ";
            content += translateValue(
                    TimeConverter.getDate(anamnesis.getBeginningEpilepsy()),
                    locale);
            content += "\n";
        }
        if (exportParams.isAnamnesisFirstFever()) {
            content += messageSource.getMessage("label.firstFever", null,
                    locale);
            content += " - ";
            content += translateValue(String.valueOf(anamnesis.isFirstFever()),
                    locale);
            content += "\n";
        }
        if (exportParams.isAnamnesisInfantileSpasm()) {
            content += messageSource.getMessage("label.infantileSpasm", null,
                    locale);
            content += " - ";
            content += translateValue(
                    String.valueOf(anamnesis.isInfantileSpasm()), locale);
            content += "\n";
        }
        if (exportParams.isAnamnesisSpecificSyndrome()) {
            content += messageSource.getMessage("label.epilepticSyndrome",
                    null, locale);

            content += " - ";
            content += translateValue(
                    String.valueOf(anamnesis.getSpecificSyndrome()), locale);
            content += "\n";
        }
        if (exportParams.isAnamnesisNonCnsComorbidity()) {
            content += messageSource.getMessage("label.nonCNSComorbidity",
                    null, locale);

            content += " - ";
            content += translateValue(
                    String.valueOf(anamnesis.getNonCnsComorbidity()), locale);
            content += "\n";
        }
        if (exportParams.isAnamnesisComment()) {
            content += messageSource.getMessage("label.comment", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(anamnesis.getComment()),
                    locale);
            content += "\n";
        }

        return content;
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of seizure should be printed out
     */
    private String printOutSeizure(PatientEntity patient,
                                   SeizureEntity seizure, Locale locale,
                                   ExportParamsEntity exportParams) {
        String content = "";
        content += messageSource.getMessage("label.seizure", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(seizure.getDate());
        content += "\n";
        if (exportParams.isSeizureFrequency()) {
            content += messageSource.getMessage("label.seizureFrequency", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(seizure.getSeizureFrequency()),
                    locale);
            content += "\n";
        }
        if (exportParams.isSeizureSecondarilyGeneralizedSeizure()) {
            content += messageSource.getMessage("label.secondarilyGeneralizedSeizure", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(seizure.isSecondarilyGeneralizedSeizure()),
                    locale);
            content += "\n";
        }
        if (exportParams.isSeizureStatusEpilepticus()) {
            content += messageSource.getMessage("label.stausEpilepticus", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(seizure.isStatusEpilepticus()),
                    locale);
            content += "\n";
        }
        if (exportParams.isSeizureComment()) {
            content += messageSource.getMessage("label.comment", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(seizure.getComment()),
                    locale);
            content += "\n";
        }

        /*
        This loop goes through seizure details
         */
        for (SeizureDetailEntity seizureDetail : seizure.getSeizureDetailList()) {
            if (exportParams.isSeizureDetailSSCClassification()) {
                content += messageSource.getMessage("label.seizureDetailSSCClassification", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(seizureDetail.getSscClassification()),
                        locale);
                content += "\n";
            }
            if (exportParams.isSeizureDetailILAEClassification()) {
                content += messageSource.getMessage("label.seizureDetailILAEClassification", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(seizureDetail.getIlaeClassification()),
                        locale);
                content += "\n";
            }
            if (exportParams.isSeizureDetailComment()) {
                content += messageSource.getMessage("label.comment", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(seizure.getComment()),
                        locale);
                content += "\n";
            }
        }
        return content;
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of pharmacotherapy should be printed out
     */
    private String printOutPharmacotherapy(PatientEntity patient,
                                           PharmacotherapyEntity pharmacotherapy, Locale locale,
                                           ExportParamsEntity exportParams) {
        String content = "";

        content += messageSource.getMessage("label.pharmacotherapy", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(pharmacotherapy.getDate());
        content += "\n";

        if (exportParams.isPharmacotherapyAED()) {
            content += messageSource.getMessage("label.", null,
                    locale);
            content += " - ";
            content += translateValue(
                    String.valueOf(pharmacotherapy.getAed()), locale);
            content += "\n";
        }
        if (exportParams.isPharmacotherapyEffective()) {
            content += messageSource.getMessage("label.aed", null,
                    locale);
            content += " - ";
            content += translateValue(
                    String.valueOf(pharmacotherapy.getEfficiency()), locale);
            content += "\n";
        }
        if (exportParams.isPharmacotherapyDuringSurgery()) {
            content += messageSource.getMessage("label.duringSurgery", null,
                    locale);
            content += " - ";
            content += translateValue(
                    String.valueOf(pharmacotherapy.isDuringSurgery()), locale);
            content += "\n";
        }
        if (exportParams.isPharmacotherapyComment()) {
            content += messageSource.getMessage("label.comment", null,
                    locale);
            content += " - ";
            content += translateValue(
                    String.valueOf(pharmacotherapy.getComment()), locale);
            content += "\n";
        }
        return content;
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of neurological finding should be printed out
     */
    private String printOutNeurologicalFinding(PatientEntity patient,
                                               NeurologicalFindingEntity neurologicalFinding, Locale locale,
                                               ExportParamsEntity exportParams) {
        String content = "";

        content += messageSource.getMessage("label.neurologicalFinding", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(neurologicalFinding.getDate());
        content += "\n";

        if (exportParams.isNeurologicalFindingHemisphereDominance()) {
            content += messageSource.getMessage("label.hemisphereDominance", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neurologicalFinding.getHemisphereDominance()),
                    locale);
            content += "\n";
        }
        if (exportParams.isNeurologicalFindingAbnormalNeurologicalFinding()) {
            content += messageSource.getMessage("label.abnormalNeurologicalFinding", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neurologicalFinding.isAbnormalNeurologicalFinding()),
                    locale);
            content += "\n";
        }
        if (exportParams.isNeurologicalFindingHemiparesis()) {
            content += messageSource.getMessage("label.hemiparesis", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neurologicalFinding.isHemiparesis()),
                    locale);
            content += "\n";
        }
        if (exportParams.isNeurologicalFindingVisualFieldDefects()) {
            content += messageSource.getMessage("label.visualFieldDefects", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neurologicalFinding.isVisualFieldDefects()),
                    locale);
            content += "\n";
        }
        if (exportParams.isNeurologicalFindingComment()) {
            content += messageSource.getMessage("label.comment", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neurologicalFinding.getComment()),
                    locale);
            content += "\n";
        }
        return content;
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of neuropsychology should be printed out
     */
    private String printOutNeuropsychology(PatientEntity patient,
                                           NeuropsychologyEntity neuropsychology, Locale locale,
                                           ExportParamsEntity exportParams) {
        String content = "";

        content += messageSource.getMessage("label.neuropsychology", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(neuropsychology.getDate());
        content += "\n";
        if (exportParams.isNeuropsychologyIntellect()) {
            content += messageSource.getMessage("label.intellect", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getIntellect()),
                    locale);
            content += "\n";
        }
        if (exportParams.isNeuropsychologyNeurodevelopmentalExamination()) {
            content += messageSource.getMessage("label.neurodevelopmentalExamination", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExamination()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isNeuropsychologyNeurodevelopmentalExaminationAdaptability()) {
            content += messageSource.getMessage("label.adaptability", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationAdaptability()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isNeuropsychologyNeurodevelopmentalExaminationSpeechExpressively()) {
            content += messageSource.getMessage("label.speech_expressively", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSpeechExpressively()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isNeuropsychologyNeurodevelopmentalExaminationSpeechReceptively()) {
            content += messageSource.getMessage("label.speechReceptively", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSpeechReceptively()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isNeuropsychologyNeurodevelopmentalExaminationFineMotorSkills()) {
            content += messageSource.getMessage("label.fineMotorSkills", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationFineMotorSkills()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isNeuropsychologyNeurodevelopmentalExaminationGrossMotorSkills()) {
            content += messageSource.getMessage("label.grossMotorSkills", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationGrossMotorSkills()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isNeuropsychologyNeurodevelopmentalExaminationSocialBehavior()) {
            content += messageSource.getMessage("label.socialBehavior", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSocialBehavior()),
                    locale);
            content += "\n";
        }
        if (exportParams.isNeuropsychologyIntellectualPerformance()) {
            content += messageSource.getMessage("label.intellectualPerformance", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getIntellectualPerformance()),
                    locale);
            content += "\n";
        }
        if (exportParams.isNeuropsychologyIntellectualPerformanceVerbally()) {
            content += messageSource.getMessage("label.intellectualPerformanceVerbally", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getIntellectualPerformanceVerbally()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isNeuropsychologyIntellectualPerformanceNonverbalAbstraction()) {
            content += messageSource.getMessage("label.intellectualPerformanceNonverbalAbstraction", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getIntellectualPerformanceNonverbalAbstraction()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isneuropsychologyIntellectualPerformanceNonverbalDesignCap()) {
            content += messageSource.getMessage("label.intellectualPerformanceNonverbalDesignCapabilities", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getIntellectualPerformanceNonverbalDesignCapabilities()),
                    locale);
            content += "\n";
        }
        if (exportParams.isNeuropsychologyNeuropsychologicalProfile()) {
            content += messageSource.getMessage("label.neuropsychologicalProfile", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfile()),
                    locale);
            content += "\n";
        }
        if (exportParams.isNeuropsychologyNeuropsychologicalProfileAttention()) {
            content += messageSource.getMessage("label.attention", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileAttention()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileCognitiveSpeed()) {
            content += messageSource.getMessage("label.cognitive_speed", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileCognitiveSpeed()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileExecutiveFunction()) {
            content += messageSource.getMessage("label.executiveFunctionc", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileExecutiveFunction()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileSpeechExpressively()) {
            content += messageSource.getMessage("label.speech_expressively", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSpeechExpressively()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileSpeechUnderstanding()) {
            content += messageSource.getMessage("label.speech_understanding", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileSpeechUnderstanding()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileMemoryOperating()) {
            content += messageSource.getMessage("label.memory_operating", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryOperating()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileMemoryVerbal()) {
            content += messageSource.getMessage("label.memory_verbal", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryVerbal()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileMemoryNonverbal()) {
            content += messageSource.getMessage("label.memoryNonverbal", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryNonverbal()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileMemoryLearning()) {
            content += messageSource.getMessage("label.memoryLearning", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryLearning()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfilePerceptionSpeech()) {
            content += messageSource.getMessage("label.perceptionSpeech", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionSpeech()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfilePerceptionVisual()) {
            content += messageSource.getMessage("label.perceptionVisual", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionVisual()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfilePerceptionSpatial()) {
            content += messageSource.getMessage("label.perceptionSpatial", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionSpatial()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileMotorSkillsDexterity()) {
            content += messageSource.getMessage("label.motorSkillsDexterity", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileMotorSkillsDexterity()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isNeuropsychologyNeuropsychologicalProfileMotorCoordination()) {
            content += messageSource.getMessage("label.motorCoordination", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getNeuropsychologicalProfileMotorCoordination()),
                    locale);
            content += "\n";
        }
        if (exportParams.isNeuropsychologyPresenceOfChanges()) {
            content += messageSource.getMessage("label.presenceOfChanges", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getPresenceOfChanges()),
                    locale);
            content += "\n";
        }
        if (exportParams.isNeuropsychologyPresenceOfChangesDetail()) {
            content += messageSource.getMessage("label.presenceOfChangesDetail", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychology.getPresenceOfChangesDetail()),
                    locale);
            content += "\n";
        }
        return content;
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of older version of neuropsychology should be printed out
     */
    private String printOutNeuropsychologyOld(PatientEntity patient,
                                              NeuropsychologyOldEntity neuropsychologyOld, Locale locale,
                                              ExportParamsEntity exportParams) {
        String content = "";

        content += messageSource.getMessage("label.neuropsychology", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(neuropsychologyOld.getDate());
        content += "\n";
        if (exportParams.isNeuropsychologyOldNeuropsychologicalExamination()) {
            content += messageSource.getMessage("label.neurodevelopmentalExamination", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychologyOld.isNeuropsychologicalExamination()),
                    locale);
            content += "\n";
        }
        if (exportParams.isNeuropsychologyOldIntelligenceLevel()) {
            content += messageSource.getMessage("label.intellect", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychologyOld.getIntelligenceLevel()),
                    locale);
            content += "\n";
        }
        if (exportParams.isNeuropsychologyOldSpecificLearning()) {
            content += messageSource.getMessage("label.specificLearning", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychologyOld.isSpecificLearning()),
                    locale);
            content += "\n";
        }
        if (exportParams.isNeuropsychologyOldDevelopmentalLanguageDisorders()) {
            content += messageSource.getMessage("label.developmentalLanguageDisorders", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychologyOld.isDevelopmentalLanguageDisorders()),
                    locale);
            content += "\n";
        }
        if (exportParams.isNeuropsychologyOldAdhdSyndrome()) {
            content += messageSource.getMessage("label.ADHDSyndrome", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychologyOld.isAdhdSyndrome()),
                    locale);
            content += "\n";
        }
        if (exportParams.isNeuropsychologyOldComment()) {
            content += messageSource.getMessage("label.comment", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychologyOld.getComment()),
                    locale);
            content += "\n";
        }

        return content;
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of diagnostic test EEG should be printed out
     */
    private String printOutDiagnosticTestEEG(PatientEntity patient,
                                             DiagnosticTestScalpEEGEntity diagnosticTestScalpEEG, Locale locale,
                                             ExportParamsEntity exportParams) {
        String content = "";

        content += messageSource.getMessage("label.diagnosticTestScalpEEG", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(diagnosticTestScalpEEG.getDate());
        content += "\n";

        if (exportParams.isDiagnosticTestEEGDone()) {
            content += messageSource.getMessage("label.EEGDone", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpEEG.isDone()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestEEGBasicActivity()) {
            content += messageSource.getMessage("label.basicEEGActivity", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpEEG.getBasicEegActivity()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestEEGSlow()) {
            content += messageSource.getMessage("label.EEGSlow", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpEEG.getEegSlow()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestEEGInterictalEEGSpikes()) {
            content += messageSource.getMessage("label.invasiveEEGInterictalSpikes", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpEEG.getInterictalEegSpikes()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestEEGLocalizationInerictalEEGSpikes()) {
            content += messageSource.getMessage("label.localizationInterictalEEGSpikes", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpEEG.getLocalizationInterictalEEGSpikes()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestEEGStatusEpilepticus()) {
            content += messageSource.getMessage("label.EEGStatusEpilepticus", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpEEG.isEegStatusEpilepticus()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestEEGSecondarySidedSynchrony()) {
            content += messageSource.getMessage("label.secondarySidedSynchrony", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpEEG.isSecondarySidedSynchrony()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestEEGIctalEEGPatterns()) {
            content += messageSource.getMessage("label.ictalEEGPatterns", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpEEG.getIctalEegPatterns()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestEEGDescriptionVideoEEG()) {
            content += messageSource.getMessage("label.eEGDescriptionVideoEEG", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpEEG.getDescriptionVideoEeg()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestEEGComment()) {
            content += messageSource.getMessage("label.comment", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpEEG.getComment()),
                    locale);
            content += "\n";
        }
        return content;
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of diagnostic test MRI should be printed out
     */
    private String printOutDiagnosticTestMRI(PatientEntity patient,
                                             DiagnosticTestMRIEntity diagnosticTestScalpMRI, Locale locale,
                                             ExportParamsEntity exportParams) {
        String content = "";

        content += messageSource.getMessage("label.diagnosticTestScalpMRI", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(diagnosticTestScalpMRI.getDate());
        content += "\n";
        if (exportParams.isDiagnosticTestMRIDone()) {
            content += messageSource.getMessage("label.mri_done", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpMRI.isDone()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestMRIFinding()) {
            content += messageSource.getMessage("label.MRIFinding", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpMRI.getMriFinding()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestMRIDescription()) {
            content += messageSource.getMessage("label.descriptionMRI", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpMRI.getMriDescription()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestMRIFdgPet()) {
            content += messageSource.getMessage("label.mRIFdgPet", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpMRI.getFdgPet()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestMRIDescriptionPetHypometabolism()) {
            content += messageSource.getMessage("label.descriptionPetHypometabolism", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionPetHypometabolism()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestMRIInterictalSpect()) {
            content += messageSource.getMessage("label.interictalSPECT", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpMRI.getInterictalSpect()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestMRIDescriptionSpectHypoperfuse()) {
            content += messageSource.getMessage("label.descriptionSPECTHypoperfuse", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionSpectHypoperfuse()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestMRIIctalSpect()) {
            content += messageSource.getMessage("label.ictalSPECT", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpMRI.getIctalSpect()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestMRIDescriptionSpectHyperperfuse()) {
            content += messageSource.getMessage("label.descriptionSPECTHyperperfuse", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionSpectHyperperfuse()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestMRISiscom()) {
            content += messageSource.getMessage("label.mriSiscom", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpMRI.isSiscom()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestMRIMrsProtocol()) {
            content += messageSource.getMessage("label.MrsProtocol", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpMRI.getMrsProtocol()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestMRIMrsFinding()) {
            content += messageSource.getMessage("label.MrsFinding", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpMRI.getMrsFinding()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestMRIDescriptionMrsAbnormality()) {
            content += messageSource.getMessage("label.descriptionMrsAbnormality", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionMrsAbnormality()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestMRIFmri()) {
            content += messageSource.getMessage("label.FMRI", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpMRI.isFmri()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestMRIDetailsFmri()) {
            content += messageSource.getMessage("label.FMRIDetails", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpMRI.getDetailsFmri()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestMRIDti()) {
            content += messageSource.getMessage("label.dti", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpMRI.isDti()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestMRIDetailsDtiStudy()) {
            content += messageSource.getMessage("label.DTIStudyDetails", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpMRI.getDetailsDtiStudy()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestMRIWada()) {
            content += messageSource.getMessage("label.WADA", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpMRI.isWada()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestMRIDetailsWada()) {
            content += messageSource.getMessage("label.WADADetails", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpMRI.getDetailsWada()),
                    locale);
            content += "\n";
        }
        if (exportParams.isDiagnosticTestMRIComment()) {
            content += messageSource.getMessage("label.comment", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(diagnosticTestScalpMRI.getComment()),
                    locale);
            content += "\n";
        }
        return content;
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of invasive test ECOG should be printed out
     */
    private String printOutInvasiveTestECOG(PatientEntity patient,
                                            InvasiveTestECOGEntity invasiveTestECOG, Locale locale,
                                            ExportParamsEntity exportParams) {
        String content = "";

        content += messageSource.getMessage("label.invasiveTestECoG", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(invasiveTestECOG.getDate());
        content += "\n";
        if (exportParams.isInvasiveTestECOGDone()) {
            content += messageSource.getMessage("label.ecog_done", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(invasiveTestECOG.isDone()),
                    locale);
            content += "\n";
        }
        if (exportParams.isInvasiveTestECOGEcogCover()) {
            content += messageSource.getMessage("label.ECoG_cover", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(invasiveTestECOG.getEcogCover()),
                    locale);
            content += "\n";
        }
        if (exportParams.isInvasiveTestECOGEcogPatterns()) {
            content += messageSource.getMessage("label.ECoG_patterns", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(invasiveTestECOG.getEcogPatterns()),
                    locale);
            content += "\n";
        }
        if (exportParams.isInvasiveTestECOGAfterResectionEcog()) {
            content += messageSource.getMessage("label.afterResectionECoG", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(invasiveTestECOG.getAfterResectionEcog()),
                    locale);
            content += "\n";
        }
        if (exportParams.isInvasiveTestECOGComment()) {
            content += messageSource.getMessage("label.comment", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(invasiveTestECOG.getComment()),
                    locale);
            content += "\n";
        }
        return content;
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of invasive test EEG should be printed out
     */
    private String printOutInvasiveTestEEG(PatientEntity patient,
                                           InvasiveTestEEGEntity invasiveTestEEG, Locale locale,
                                           ExportParamsEntity exportParams) {
        String content = "";

        content += messageSource.getMessage("label.invasiveTestEEG", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(invasiveTestEEG.getDate());
        content += "\n";
        if (exportParams.isInvasiveTestEEGDone()) {
            content += messageSource.getMessage("label.eeg_done", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(invasiveTestEEG.isDone()),
                    locale);
            content += "\n";
        }
        if (exportParams.isInvasiveTestEEGIntracranialElectrodes()) {
            content += messageSource.getMessage("label.intracranialElectrodes", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(invasiveTestEEG.getIntracranialElectrodes()),
                    locale);
            content += "\n";
        }
        if (exportParams.isInvasiveTestEEGLocalizationIntracranialElectrodes()) {
            content += messageSource.getMessage("label.localizationIntracranialElectrodes", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(invasiveTestEEG.getLocalizationIntracranialElectrodes()),
                    locale);
            content += "\n";
        }
        if (exportParams.isInvasiveTestEEGInvasiveEEGSlow()) {
            content += messageSource.getMessage("label.EEGSlow", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(invasiveTestEEG.getInvasiveEegSlow()),
                    locale);
            content += "\n";
        }
        if (exportParams.isInvasiveTestEEGInvasiveEEGInterictalSpikes()) {
            content += messageSource.getMessage("label.interictalEEGSpikes", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(invasiveTestEEG.getInvasiveEegInterictalSpikes()),
                    locale);
            content += "\n";
        }
        if (exportParams
                .isInvasiveTestEEGLocalizationInvasiveEEGInterictalSpikes()) {
            content += messageSource.getMessage("label.localizationInterictalEEGSpikes", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(invasiveTestEEG.getLocalizationInvasiveEegInterictalSpikes()),
                    locale);
            content += "\n";
        }
        if (exportParams.isInvasiveTestEEGStatusEpilepticus()) {
            content += messageSource.getMessage("label.EEGStatusEpilepticus", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(invasiveTestEEG.isInvasiveEegStatusEpilepticus()),
                    locale);
            content += "\n";
        }
        if (exportParams.isInvasiveTestEEGInvasiveIctalEEGPatterns()) {
            content += messageSource.getMessage("label.ictalEEGPatterns", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(invasiveTestEEG.getInvasiveIctalEegPatterns()),
                    locale);
            content += "\n";
        }
        if (exportParams.isInvasiveTestEEGLocalizationIctalEEGPatterns()) {
            content += messageSource.getMessage("label.localizationIctalEEGPattern", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(invasiveTestEEG.getLocalizationInvasiveIctalEegPatterns()),
                    locale);
            content += "\n";
        }
        if (exportParams.isInvasiveTestEEGComment()) {
            content += messageSource.getMessage("label.comment", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(invasiveTestEEG.getComment()),
                    locale);
            content += "\n";
        }
        return content;
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of invasive test cortical mapping should be printed out
     */
    private String printOutInvasiveTestCorticalMapping(PatientEntity patient,
                                                       InvasiveTestCorticalMappingEntity invasiveTestCorticalMapping,
                                                       Locale locale, ExportParamsEntity exportParams) {
        String content = "";

        content += messageSource.getMessage("label.invasiveTestCorticalMapping", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(invasiveTestCorticalMapping.getDate());
        content += "\n";
        if (exportParams.isInvasiveTestCorticalMappingDone()) {
            content += messageSource.getMessage("label.corticalMapping_done", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(invasiveTestCorticalMapping.isDone()),
                    locale);
            content += "\n";
        }
        if (exportParams.isInvasiveTestCorticalMappingCorticalMapping()) {
            content += messageSource.getMessage("label.corticalMapping", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(invasiveTestCorticalMapping.getCorticalMapping()),
                    locale);
            content += "\n";
        }
        if (exportParams.isInvasiveTestCorticalMappingComment()) {
            content += messageSource.getMessage("label.comment", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(invasiveTestCorticalMapping.getComment()),
                    locale);
            content += "\n";
        }

        return content;
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of operation should be printed out
     */
    private String printOutOperation(PatientEntity patient,
                                     OperationEntity operation, Locale locale,
                                     ExportParamsEntity exportParams) {
        String content = "";

        content += messageSource.getMessage("label.operation", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(operation.getDate());
        content += "\n";
        if (exportParams.isOperationDateOperation()) {
            content += messageSource.getMessage("label.dateOfOperation", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(operation.getDateOperation()),
                    locale);
            content += "\n";
        }
        if (exportParams.isOperationRangeOperation()) {
            content += messageSource.getMessage("label.dateOfOperation", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(operation.getDateOperation()),
                    locale);
            content += "\n";
        }
        if (exportParams.isOperationTypeOperation()) {
            content += messageSource.getMessage("label.typeOperations", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(operation.getTypeOperation()),
                    locale);
            content += "\n";
        }
        if (exportParams.isOperationLocalizationOperation()) {
            content += messageSource.getMessage("label.localizationOperations", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(operation.getLocalizationOperation()),
                    locale);
            content += "\n";
        }
        if (exportParams.isOperationMst()) {
            content += messageSource.getMessage("label.mst", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(operation.isMst()),
                    locale);
            content += "\n";
        }
        if (exportParams.setOperationColostomy()) {
            content += messageSource.getMessage("label.colostomy", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(operation.isColostomy()),
                    locale);
            content += "\n";
        }
        if (exportParams.isOperationVNS()) {
            content += messageSource.getMessage("label.VNS", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(operation.isVns()),
                    locale);
            content += "\n";
        }
        if (exportParams.isOperationVNsImplantationDate()) {
            content += messageSource.getMessage("label.VNSImplantationDate", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(operation.getVNSImplantationDate()),
                    locale);
            content += "\n";
        }
        if (exportParams.isOperationOperationDetails()) {
            content += messageSource.getMessage("label.dateOfOperation", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(operation.getDateOperation()),
                    locale);
            content += "\n";
        }
        if (exportParams.isOperationCompleteResection()) {
            content += messageSource.getMessage("label.completeResection", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(operation.isCompleteResection()),
                    locale);
            content += "\n";
        }
        if (exportParams.isOperationComment()) {
            content += messageSource.getMessage("label.comment", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(operation.getComment()),
                    locale);
            content += "\n";
        }

        return content;
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of histology should be printed out
     */
    private String printOutHistology(PatientEntity patient,
                                     HistologyEntity histology, Locale locale,
                                     ExportParamsEntity exportParams) {
        String content = "";

        content += messageSource.getMessage("label.histology", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(histology.getDate());
        content += "\n";
        if (exportParams.isHistologyHistopathology()) {
            content += messageSource.getMessage("label.histopathology", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(histology.getHistopathology()),
                    locale);
            content += "\n";
        }
        if (exportParams.isHistologyFcdClassification()) {
            content += messageSource.getMessage("label.FCDClasification", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(histology.getfcdClasification()),
                    locale);
            content += "\n";
        }
        if (exportParams.isHistologyComment()) {
            content += messageSource.getMessage("label.comment", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(histology.getComment()),
                    locale);
            content += "\n";
        }
        return content;
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of complication should be printed out
     */
    private String printOutComplication(PatientEntity patient,
                                        ComplicationEntity complication, Locale locale,
                                        ExportParamsEntity exportParams) {
        String content = "";

        content += messageSource.getMessage("label.complication", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(complication.getDate());
        content += "\n";
        if (exportParams.isComplicationWithCompication()) {
            content += messageSource.getMessage("label.withComplications", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(complication.isWithComplication()),
                    locale);
            content += "\n";
        }
        if (exportParams.isComplicationComplicationType()) {
            content += messageSource.getMessage("label.typeComplication", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(complication.getComplicationType()),
                    locale);
            content += "\n";
        }
        if (exportParams.isComplicationComplication()) {
            content += messageSource.getMessage("label.complication", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(complication.getComplication()),
                    locale);
            content += "\n";
        }
        if (exportParams.isComplicationComment()) {
            content += messageSource.getMessage("label.comment", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(complication.getComment()),
                    locale);
            content += "\n";
        }

        return content;
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of outcome should be printed out
     */
    private String printOutOutcome(PatientEntity patient,
                                   OutcomeEntity outcome, Locale locale,
                                   ExportParamsEntity exportParams) {
        String content = "";

        content += messageSource.getMessage("label.outcome", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(outcome.getDate());
        content += "\n";
        if (exportParams.isOutcomeSeizureOutcome()) {
            content += messageSource.getMessage("label.seizures", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(outcome.getSeizureOutcome()),
                    locale);
            content += "\n";
        }
        if (exportParams.isOutcomeEEG()) {
            content += messageSource.getMessage("label.eeg", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(outcome.getEeg()),
                    locale);
            content += "\n";
        }
        if (exportParams.isOutcomeAED()) {
            content += messageSource.getMessage("label.aed", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(outcome.getAed()),
                    locale);
            content += "\n";
        }
        if (exportParams.isOutcomeMRI()) {
            content += messageSource.getMessage("label.mri", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(outcome.getMri()),
                    locale);
            content += "\n";
        }
        if (exportParams.isOutcomeNeuropsychology()) {
            content += messageSource.getMessage("label.neuropsychology", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(outcome.getNeuropsychology()),
                    locale);
            content += "\n";
        }
        if (exportParams.isOutcomeDistance()) {
            content += messageSource.getMessage("label.distance", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(outcome.getDistance()),
                    locale);
            content += "\n";
        }
        if (exportParams.isOutcomeOperationId()) {
            content += messageSource.getMessage("label.operationId", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(outcome.getOperation()),
                    locale);
            content += "\n";
        }
        if (exportParams.isOutcomeComment()) {
            content += messageSource.getMessage("label.comment", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(outcome.getComment()),
                    locale);
            content += "\n";
        }

        return content;
    }
}
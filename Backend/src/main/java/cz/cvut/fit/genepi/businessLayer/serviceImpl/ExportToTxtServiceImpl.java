package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.BO.form.UserFormBO;
import cz.cvut.fit.genepi.businessLayer.service.ExportToTxtService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
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

import static cz.cvut.fit.genepi.util.TimeConverter.getAgeAtTheBeginningOfEpilepsy;
import static cz.cvut.fit.genepi.util.TimeConverter.getCurrentAge;

@Service
public class ExportToTxtServiceImpl implements ExportToTxtService {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserService userService;

    /**
     * The Constant logger.
     */
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

    /**
     * Creates new file and calls methods to fill this file with relevant content according to the exportParams.
     * Location for Windows OS is here set only for testing
     */
    public String export(java.util.List<PatientEntity> patientList,
                         UserEntity user, Locale locale, ExportParamsEntity exportParams, boolean anonymize) {
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
            content += addTitlePage(locale, patient, date, exportParams, anonymize);
            content += addContent(patient, locale, exportParams);
            content += addEmptyLine();
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
     * Creates offset
     */
    private String addOffset() {
        String offset = "";
        for (int i = 0; i != 5; i++) {
            offset += " ";
        }
        return (offset);
    }

    /**
     * Creates subcategory delimiter
     */
    private String addSubcatDelimiter() {
        String offset = "";
        for (int i = 0; i != 5; i++) {
            offset += " ";
        }
        for (int i = 0; i != 20; i++) {
            offset += "-";
        }
        offset += "\n";

        return (offset);
    }


    /**
     * Creates title page for certain patient
     */
    private String addTitlePage(Locale locale, PatientEntity patient,
                                String date, ExportParamsEntity exportParams, boolean anonymize) {
        String content = "";
        if (exportParams.isPatient()) {
            content = printOutPatient(patient, locale, exportParams, anonymize);
            content += addEmptyLine();
        }
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
                //TODO: anamnesis has changed - ishistory???
                if (!anamnesis.isHistory())
                    content += this.printOutAnamnesis(patient, anamnesis, locale,
                            exportParams);
                content += addDashLine();
            }
        }
        if (exportParams.isSeizure()) {
            content += addStarLine();
            for (SeizureEntity seizure : patient.getSeizureList()) {
                if (!seizure.isHidden())
                    content += this.printOutSeizure(patient, seizure, locale,
                            exportParams);
                content += addDashLine();
            }
        }
        if (exportParams.isPharmacotherapy()) {
            content += addStarLine();
            for (PharmacotherapyEntity pharmacotherapy : patient
                    .getPharmacotherapyList()) {
                if (!pharmacotherapy.isHidden())
                    content += this.printOutPharmacotherapy(patient,
                            pharmacotherapy, locale, exportParams);
                content += addDashLine();
            }
        }
        if (exportParams.isNeurologicalFinding()) {
            content += addStarLine();
            for (NeurologicalFindingEntity neurologicalFinding : patient
                    .getNeurologicalFindingList()) {
                if (!neurologicalFinding.isHidden())
                    content += this.printOutNeurologicalFinding(patient,
                            neurologicalFinding, locale, exportParams);
                content += addDashLine();
            }
        }
        if (exportParams.isNeuropsychology()) {
            content += addStarLine();
            for (NeuropsychologyEntity neuropsychology : patient
                    .getNeuropsychologyList()) {
                if (!neuropsychology.isHidden())
                    content += this.printOutNeuropsychology(patient,
                            neuropsychology, locale, exportParams);
                content += addDashLine();
            }
        }

        if (exportParams.isNeuropsychologyOld()) {
            content += addStarLine();
            for (NeuropsychologyOldEntity neuropsychologyOld : patient
                    .getNeuropsychologyOldList()) {
                if (!neuropsychologyOld.isHidden())
                    content += this.printOutNeuropsychologyOld(patient,
                            neuropsychologyOld, locale, exportParams);
                content += addDashLine();
            }
        }

        if (exportParams.isDiagnosticTestEEG()) {
            content += addStarLine();
            for (DiagnosticTestScalpEegEntity diagnosticTestEEG : patient
                    .getDiagnosticTestScalpEegList()) {
                if (!diagnosticTestEEG.isHidden())
                    content += this.printOutDiagnosticTestEEG(patient,
                            diagnosticTestEEG, locale, exportParams);
                content += addDashLine();
            }
        }

        if (exportParams.isDiagnosticTestMRI()) {
            content += addStarLine();
            for (DiagnosticTestMriEntity diagnosticTestMRI : patient
                    .getDiagnosticTestMRIList()) {
                if (!diagnosticTestMRI.isHidden())
                    content += this.printOutDiagnosticTestMRI(patient,
                            diagnosticTestMRI, locale, exportParams);
                content += addDashLine();
            }
        }

        if (exportParams.isInvasiveTestECOG()) {
            content += addStarLine();
            for (InvasiveTestEcogEntity invasiveTestECOG : patient
                    .getInvasiveTestECOGList()) {
                if (!invasiveTestECOG.isHidden())
                    content += this.printOutInvasiveTestECOG(patient,
                            invasiveTestECOG, locale, exportParams);
                content += addDashLine();
            }
        }

        if (exportParams.isInvasiveTestEEG()) {
            content += addStarLine();
            for (InvasiveTestEegEntity invasiveTestEEG : patient
                    .getInvasiveTestEEGList()) {
                if (!invasiveTestEEG.isHidden())
                    content += this.printOutInvasiveTestEEG(patient,
                            invasiveTestEEG, locale, exportParams);
                content += addDashLine();
            }
        }

        if (exportParams.isInvasiveTestCorticalMapping()) {
            content += addStarLine();
            for (InvasiveTestCorticalMappingEntity invasiveTestCorticalMappingEntity : patient
                    .getInvasiveTestCorticalMappingList()) {
                if (!invasiveTestCorticalMappingEntity.isHidden())
                    content += this
                            .printOutInvasiveTestCorticalMapping(patient,
                                    invasiveTestCorticalMappingEntity, locale,
                                    exportParams);
                content += addDashLine();
            }
        }

        if (exportParams.isOperation()) {
            for (OperationEntity operation : patient.getOperationList()) {
                if (!operation.isHidden())
                    content += this.printOutOperation(patient, operation, locale,
                            exportParams);
                content += addDashLine();
            }
        }
        if (exportParams.isHistology()) {
            for (HistologyEntity histology : patient.getHistologyList()) {
                if (!histology.isHidden())
                    content += this.printOutHistology(patient, histology, locale,
                            exportParams);
                content += addDashLine();
            }
        }
        if (exportParams.isComplication()) {
            for (ComplicationEntity complication : patient
                    .getComplicationList()) {
                if (!complication.isHidden())
                    content += this.printOutComplication(patient, complication,
                            locale, exportParams);
                content += addDashLine();
            }
        }
        if (exportParams.isOutcome()) {
            for (OutcomeEntity outcome : patient.getOutcomeList()) {
                content += this.printOutOutcome(patient, outcome, locale,
                        exportParams);
                content += addDashLine();
            }
        }


        /**
         * Following code is used when you want to add some custom message
         *
         * add following code whenever you would like to print your custom message
         *
         * @param String text of your custom message
         **/
        // content += this.printCustom("my message");

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
            content += messageSource.getMessage("label.inflammationCns", null,
                    locale);
            content += " - ";
            content += translateValue(
                    String.valueOf(anamnesis.isInflammationCns()), locale);
            content += "\n";
        }
        if (exportParams.isAnamnesisInjuryCns()) {
            content += messageSource
                    .getMessage("label.injuryCns", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(anamnesis.isInjuryCns()),
                    locale);
            content += "\n";
        }
        if (exportParams.isAnamnesisOperationCns()) {
            content += messageSource.getMessage("label.operationCns", null,
                    locale);
            content += " - ";
            content += translateValue(
                    String.valueOf(anamnesis.isOperationCns()), locale);
            content += "\n";
        }
        if (exportParams.isAnamnesisEarlyPmdRetardation()) {
            content += messageSource.getMessage("label.earlyPmdRetardation",
                    null, locale);

            content += " - ";
            content += translateValue(
                    String.valueOf(anamnesis.isEarlyPmdRetardation()), locale);
            content += "\n";
        }
       /* TODO martin revision
        if (exportParams.isAnamnesisBeginningEpilepsy()) {
            content += messageSource.getMessage("label.beginningEpilepsy",
                    null, locale);

            content += " - ";
            content += translateValue(
                    TimeConverter.getDate(anamnesis.getBeginningEpilepsy()),
                    locale);
            content += "\n";
        }*/
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
            content += messageSource.getMessage("label.specificSyndrome." +
                    String.valueOf(anamnesis.getSpecificSyndrome()), null, locale);
            content += "\n";
        }
        if (exportParams.isAnamnesisNonCnsComorbidity() && !anamnesis.getNonCnsComorbidity().equals("")) {
            content += messageSource.getMessage("label.nonCnsComorbidity",
                    null, locale);

            content += " - ";
            content += translateValue(
                    String.valueOf(anamnesis.getNonCnsComorbidity()), locale);
            content += "\n";
        }
        if (exportParams.isAnamnesisComment()) {
            content += messageSource.getMessage("label.comment", null, locale);
            content += " - ";
            content += translateComment(String.valueOf(anamnesis.getComment()),
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
        content += messageSource.getMessage("label.seizures", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(seizure.getDate());
        content += "\n";
        if (exportParams.isSeizureFrequency()) {
            content += messageSource.getMessage("label.seizureFrequency", null, locale);
            content += " - ";
            content += translateValue(messageSource.getMessage("label.seizureFrequency." +
                    String.valueOf(seizure.getSeizureFrequency()), null, locale), locale);
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
            content += messageSource.getMessage("label.statusEpilepticus", null, locale);
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
        int counter = 0;
        for (SeizureDetailEntity seizureDetail : seizure.getSeizureDetailList()) {
            if (counter++ > 0)
                content += addSubcatDelimiter();

            if (exportParams.isSeizureSSCClassification()) {
                content += addOffset();
                content += messageSource.getMessage("label.sscClassification", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.sscClassification." +
                                String.valueOf(seizureDetail.getSscClassification()), null, locale),
                        locale
                );
                content += "\n";
            }
            if (exportParams.isSeizureILAEClassification()) {
                content += addOffset();
                content += messageSource.getMessage("label.ilaeClassification", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.ilaeClassification." +
                                String.valueOf(seizureDetail.getIlaeClassification()), null, locale),
                        locale
                );
                content += "\n";
            }
            if (exportParams.isSeizureDetailComment()) {
                content += addOffset();
                content += messageSource.getMessage("label.comment", null, locale);
                content += " - ";
                content += translateComment(String.valueOf(seizureDetail.getComment()),
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
            content += messageSource.getMessage("label.aed", null,
                    locale);
            content += " - ";
            content += translateValue(messageSource.getMessage("label.aed." +
                    String.valueOf(pharmacotherapy.getAed()), null, locale), locale);
            content += "\n";
        }
        if (exportParams.isPharmacotherapyEffective()) {
            content += messageSource.getMessage("label.efficiency", null,
                    locale);
            content += " - ";
            content += translateValue(messageSource.getMessage("label.efficiency." +
                    String.valueOf(pharmacotherapy.getEfficiency()), null, locale), locale);
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
            content += translateComment(
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
            content += translateValue(messageSource.getMessage("label.hemisphereDominance." +
                    String.valueOf(neurologicalFinding.getHemisphereDominance()), null, locale), locale);
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
            content += messageSource.getMessage("label.visualFieldDefect", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neurologicalFinding.isVisualFieldDefects()),
                    locale);
            content += "\n";
        }
        if (exportParams.isNeurologicalFindingComment()) {
            content += messageSource.getMessage("label.comment", null, locale);
            content += " - ";
            content += translateComment(String.valueOf(neurologicalFinding.getComment()),
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
            content += translateValue(messageSource.getMessage("label.intellect." +
                    String.valueOf(neuropsychology.getIntellect()), null, locale), locale);
            content += "\n";
        }
        if (neuropsychology.getIntellect() == 1) {
            if (exportParams.isNeuropsychologyNeurodevelopmentalExamination()) {
                content += messageSource.getMessage("label.neurodevelopmentalExamination", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExamination()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationAdaptability()) {
                content += messageSource.getMessage("label.adaptability", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationAdaptability()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationSpeechExpressively()) {
                content += messageSource.getMessage("label.speechExpressively", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSpeechExpressively()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationSpeechReceptively()) {
                content += messageSource.getMessage("label.speechReceptively", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSpeechReceptively()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationFineMotorSkills()) {
                content += messageSource.getMessage("label.fineMotorSkills", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationFineMotorSkills()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationGrossMotorSkills()) {
                content += messageSource.getMessage("label.grossMotorSkills", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationGrossMotorSkills()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isNeuropsychologyNeurodevelopmentalExaminationSocialBehavior()) {
                content += messageSource.getMessage("label.socialBehavior", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExaminationSocialBehavior()), null, locale), locale);
                content += "\n";
            }
        }
        if (neuropsychology.getIntellect() == 2) {
            if (exportParams.isNeuropsychologyIntellectualPerformance()) {
                content += messageSource.getMessage("label.intellectualPerformance", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getIntellectualPerformance()), null, locale), locale);
                content += "\n";
            }
            if (exportParams.isNeuropsychologyIntellectualPerformanceVerbally()) {
                content += messageSource.getMessage("label.intellectualPerformanceVerbally", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getIntellectualPerformanceVerbally()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isNeuropsychologyIntellectualPerformanceNonverbalAbstraction()) {
                content += messageSource.getMessage("label.intellectualPerformanceNonverbalAbstraction", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getIntellectualPerformanceNonverbalAbstraction()), null, locale), locale);
                content += "\n";
            }
            if (exportParams.isNeuropsychologyIntellectualPerformanceNonverbalDesignCap()) {
                content += messageSource.getMessage("label.intellectualPerformanceNonverbalDesignCapabilities", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeurodevelopmentalExamination()), null, locale), locale);
                content += "\n";
            }
        }
        if (exportParams.isNeuropsychologyNeuropsychologicalProfile()) {
            content += messageSource.getMessage("label.neuropsychologicalProfile", null, locale);
            content += " - ";
            content += translateValue(messageSource.getMessage("label.neuropsychologicalProfile." +
                    String.valueOf(neuropsychology.getNeuropsychologicalProfile()), null, locale), locale);
            content += "\n";
        }
        if (neuropsychology.getNeuropsychologicalProfile() == 1) {
            if (exportParams.isNeuropsychologyNeuropsychologicalProfileAttention()) {
                content += messageSource.getMessage("label.attention", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileAttention()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfileCognitiveSpeed()) {
                content += messageSource.getMessage("label.cognitiveSpeed", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileCognitiveSpeed()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfileExecutiveFunction()) {
                content += messageSource.getMessage("label.executiveFunction" +
                        "", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileExecutiveFunction()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfileSpeechExpressively()) {
                content += messageSource.getMessage("label.speechExpressively", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.speechExpressively." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileSpeechExpressively()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfileSpeechUnderstanding()) {
                content += messageSource.getMessage("label.speechUnderstanding", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileSpeechUnderstanding()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfileMemoryOperating()) {
                content += messageSource.getMessage("label.memoryOperating", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryOperating()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfileMemoryVerbal()) {
                content += messageSource.getMessage("label.memoryVerbal", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryVerbal()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfileMemoryNonverbal()) {
                content += messageSource.getMessage("label.memoryNonverbal", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryNonverbal()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfileMemoryLearning()) {
                content += messageSource.getMessage("label.memoryLearning", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileMemoryLearning()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfilePerceptionSpeech()) {
                content += messageSource.getMessage("label.perceptionSpeech", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionSpeech()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfilePerceptionVisual()) {
                content += messageSource.getMessage("label.perceptionVisual", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionVisual()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfilePerceptionSpatial()) {
                content += messageSource.getMessage("label.perceptionSpatial", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfilePerceptionSpatial()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfileMotorSkillsDexterity()) {
                content += messageSource.getMessage("label.motorSkillsDexterity", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileMotorSkillsDexterity()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isNeuropsychologyNeuropsychologicalProfileMotorCoordination()) {
                content += messageSource.getMessage("label.motorCoordination", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.deficit." +
                        String.valueOf(neuropsychology.getNeuropsychologicalProfileMotorCoordination()), null, locale), locale);
                content += "\n";
            }
        }
        if (exportParams.isNeuropsychologyPresenceOfChanges()) {
            content += messageSource.getMessage("label.presenceOfChanges", null, locale);
            content += " - ";
            content += translateValue(messageSource.getMessage("label.presenceOfChanges." +
                    String.valueOf(neuropsychology.getPresenceOfChanges()), null, locale), locale);
            content += "\n";
        }
        if (neuropsychology.getPresenceOfChanges() == 0) {
            if (exportParams.isNeuropsychologyPresenceOfChangesDetail()) {
                content += messageSource.getMessage("label.presenceOfChangesDetail", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.presenceOfChanges." +
                        String.valueOf(neuropsychology.getPresenceOfChanges()), null, locale), locale);
                content += "\n";
            }
        }
        if (exportParams.isNeuropsychologyEmotionalStatus()) {
            content += messageSource.getMessage("label.emotionalState", null, locale);
            content += " - ";
            content += translateValue(messageSource.getMessage("label.emotionalState." +
                    String.valueOf(neuropsychology.getEmotionalStatus()), null, locale), locale);
            content += "\n";
        }

        if (exportParams.isNeuropsychologyComment()) {
            content += (messageSource.getMessage("label.comment", null, locale));
            content += " - ";
            content += (translateComment(String.valueOf(neuropsychology.getComment()),
                    locale));
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

        content += messageSource.getMessage("label.neuropsychologyOld", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(neuropsychologyOld.getDate());
        content += "\n";
        if (exportParams.isNeuropsychologyOldNeuropsychologicalExamination()) {
            content += messageSource.getMessage("label.neuropsychologicalExamination", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychologyOld.isNeuropsychologicalExamination()),
                    locale);
            content += "\n";
        }
        if (exportParams.isNeuropsychologyOldIntelligenceLevel()) {
            content += messageSource.getMessage("label.intelligenceLevel", null, locale);
            content += " - ";
            content += messageSource.getMessage(translateValue("label.intelligenceLevel." + String.valueOf(neuropsychologyOld.getIntelligenceLevel()),
                    locale),null,locale);
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
            content += messageSource.getMessage("label.adhdSyndrome", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(neuropsychologyOld.isAdhdSyndrome()),
                    locale);
            content += "\n";
        }
        if (exportParams.isNeuropsychologyOldComment()) {
            content += messageSource.getMessage("label.comment", null, locale);
            content += " - ";
            content += translateComment(String.valueOf(neuropsychologyOld.getComment()),
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
                                             DiagnosticTestScalpEegEntity diagnosticTestScalpEEG, Locale locale,
                                             ExportParamsEntity exportParams) {
        String content = "";

        content += messageSource.getMessage("label.diagnosticTestScalpEeg", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(diagnosticTestScalpEEG.getDate());
        content += "\n";

        if (exportParams.isDiagnosticTestEEGDone()) {
            content += messageSource.getMessage("label.eegDone", null, locale);
            content += " - ";
            content += translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(diagnosticTestScalpEEG.getDone()), null, locale), locale);
            content += "\n";
        }
        if (diagnosticTestScalpEEG.getDone() == 2) {
            if (exportParams.isDiagnosticTestEEGBasicActivity()) {
                content += messageSource.getMessage("label.basicEegActivity", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.basicEegActivity." +
                        String.valueOf(diagnosticTestScalpEEG.getBasicEegActivity()), null, locale), locale);
                content += "\n";
            }
            if (exportParams.isDiagnosticTestEEGSlow()) {
                content += messageSource.getMessage("label.eegSlow", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.eegSlow." +
                        String.valueOf(diagnosticTestScalpEEG.getEegSlow()), null, locale), locale);
                content += "\n";
            }
            if (exportParams.isDiagnosticTestEEGInterictalEEGSpikes()) {
                content += messageSource.getMessage("label.invasiveEegInterictalSpikes", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.interictalEegSpikes." +
                        String.valueOf(diagnosticTestScalpEEG.getInterictalEegSpikes()), null, locale), locale);
                content += "\n";
            }
            if (exportParams.isDiagnosticTestEEGLocalizationInerictalEEGSpikes()) {
                content += messageSource.getMessage("label.localizationInvasiveEegInterictalSpikes", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(diagnosticTestScalpEEG.getLocalizationInterictalEegSpikes()),
                        locale);
                content += "\n";
            }
            if (exportParams.isDiagnosticTestEEGStatusEpilepticus()) {
                content += messageSource.getMessage("label.eegStatusEpilepticus", null, locale);
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
                content += messageSource.getMessage("label.ictalEegPatterns", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.ictalEegPatterns." +
                        String.valueOf(diagnosticTestScalpEEG.getIctalEegPatterns()), null, locale), locale);
                content += "\n";
            }
            if (exportParams.isDiagnosticTestEEGDescriptionVideoEEG()) {
                content += messageSource.getMessage("label.descriptionVideoEeg", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(diagnosticTestScalpEEG.getDescriptionVideoEeg()),
                        locale);
                content += "\n";
            }
            if (exportParams.isDiagnosticTestEEGComment()) {
                content += messageSource.getMessage("label.comment", null, locale);
                content += " - ";
                content += translateComment(String.valueOf(diagnosticTestScalpEEG.getComment()),
                        locale);
                content += "\n";
            }
        }
        return content;
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of diagnostic test MRI should be printed out
     */
    private String printOutDiagnosticTestMRI(PatientEntity patient,
                                             DiagnosticTestMriEntity diagnosticTestScalpMRI, Locale locale,
                                             ExportParamsEntity exportParams) {
        String content = "";

        content += messageSource.getMessage("label.diagnosticTestsMri", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(diagnosticTestScalpMRI.getDate());
        content += "\n";
        if (exportParams.isDiagnosticTestMRIDone()) {
            content += messageSource.getMessage("label.mri_done", null, locale);
            content += " - ";
            content += translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(diagnosticTestScalpMRI.getDone()), null, locale), locale);
            content += "\n";
        }
        if (diagnosticTestScalpMRI.getDone() == 2) {
            if (exportParams.isDiagnosticTestMRIFinding()) {
                content += messageSource.getMessage("label.mriFinding", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.resultType." +
                        String.valueOf(diagnosticTestScalpMRI.getMriFinding()), null, locale), locale);
                content += "\n";
            }
            if (exportParams.isDiagnosticTestMRIDescription()) {
                content += messageSource.getMessage("label.descriptionMri", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(diagnosticTestScalpMRI.getMriDescription()),
                        locale);
                content += "\n";
            }
            if (exportParams.isDiagnosticTestMRIFdgPet()) {
                content += messageSource.getMessage("label.fdgPet", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.resultType." +
                        String.valueOf(diagnosticTestScalpMRI.getFdgPet()), null, locale), locale);
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
                content += messageSource.getMessage("label.interictalSpect", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.resultType." +
                        String.valueOf(diagnosticTestScalpMRI.getInterictalSpect()), null, locale), locale);
                content += "\n";
            }
            if (exportParams.isDiagnosticTestMRIDescriptionSpectHypoperfuse()) {
                content += messageSource.getMessage("label.descriptionSpectHypoperfuse", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionSpectHypoperfuse()),
                        locale);
                content += "\n";
            }
            if (exportParams.isDiagnosticTestMRIIctalSpect()) {
                content += messageSource.getMessage("label.ictalSPECT", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.resultType." +
                        String.valueOf(diagnosticTestScalpMRI.getIctalSpect()), null, locale), locale);
                content += "\n";
            }
            if (exportParams.isDiagnosticTestMRIDescriptionSpectHyperperfuse()) {
                content += messageSource.getMessage("label.descriptionSpectHyperperfuse", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(diagnosticTestScalpMRI.getDescriptionSpectHyperperfuse()),
                        locale);
                content += "\n";
            }
            if (exportParams.isDiagnosticTestMRISiscom()) {
                content += messageSource.getMessage("label.siscom", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(diagnosticTestScalpMRI.isSiscom()),
                        locale);
                content += "\n";
            }
            if (exportParams.isDiagnosticTestMRIMrsProtocol()) {
                content += messageSource.getMessage("label.mrsProtocol", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.mrsProtocol." +
                        String.valueOf(diagnosticTestScalpMRI.getMrsProtocol()), null, locale), locale);
                content += "\n";
            }
            if (exportParams.isDiagnosticTestMRIMrsFinding()) {
                content += messageSource.getMessage("label.mrsFinding", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.resultType." +
                        String.valueOf(diagnosticTestScalpMRI.getMrsFinding()), null, locale), locale);
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
                content += messageSource.getMessage("label.fmri", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(diagnosticTestScalpMRI.isFmri()),
                        locale);
                content += "\n";
            }
            if (exportParams.isDiagnosticTestMRIDetailsFmri()) {
                content += messageSource.getMessage("label.fmriDetails", null, locale);
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
                content += messageSource.getMessage("label.dtiStudyDetails", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(diagnosticTestScalpMRI.getDetailsDtiStudy()),
                        locale);
                content += "\n";
            }
            if (exportParams.isDiagnosticTestMRIWada()) {
                content += messageSource.getMessage("label.wada", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(diagnosticTestScalpMRI.isWada()),
                        locale);
                content += "\n";
            }
            if (exportParams.isDiagnosticTestMRIDetailsWada()) {
                content += messageSource.getMessage("label.wadaDetails", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(diagnosticTestScalpMRI.getDetailsWada()),
                        locale);
                content += "\n";
            }
        }
        if (exportParams.isDiagnosticTestMRIComment()) {
            content += messageSource.getMessage("label.comment", null, locale);
            content += " - ";
            content += translateComment(String.valueOf(diagnosticTestScalpMRI.getComment()),
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
                                            InvasiveTestEcogEntity invasiveTestECOG, Locale locale,
                                            ExportParamsEntity exportParams) {
        String content = "";

        content += messageSource.getMessage("label.invasiveTestECoG", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(invasiveTestECOG.getDate());
        content += "\n";
        if (exportParams.isInvasiveTestECOGDone()) {
            content += messageSource.getMessage("label.ecogDone", null, locale);
            content += " - ";
            content += translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(invasiveTestECOG.getDone()), null, locale), locale);
            content += "\n";
        }
        if (invasiveTestECOG.getDone() == 2) {
            if (exportParams.isInvasiveTestECOGEcogCover()) {
                content += messageSource.getMessage("label.ecogCover", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(invasiveTestECOG.getEcogCover()),
                        locale);
                content += "\n";
            }
            if (exportParams.isInvasiveTestECOGEcogPatterns()) {
                content += messageSource.getMessage("label.ecogPatterns", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.ecogPatterns." +
                        String.valueOf(invasiveTestECOG.getEcogPatterns()), null, locale), locale);
                content += "\n";
            }
            if (exportParams.isInvasiveTestECOGAfterResectionEcog()) {
                content += messageSource.getMessage("label.ecogAfterResection", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.afterResectionEcog." +
                        String.valueOf(invasiveTestECOG.getAfterResectionEcog()), null, locale), locale);
                content += "\n";
            }
            if (exportParams.isInvasiveTestECOGComment()) {
                content += messageSource.getMessage("label.comment", null, locale);
                content += " - ";
                content += translateComment(String.valueOf(invasiveTestECOG.getComment()),
                        locale);
                content += "\n";
            }
        }
        return content;
    }

    /**
     * Adds content according to exportParams
     * Checks what properties of invasive test EEG should be printed out
     */
    private String printOutInvasiveTestEEG(PatientEntity patient,
                                           InvasiveTestEegEntity invasiveTestEEG, Locale locale,
                                           ExportParamsEntity exportParams) {
        String content = "";

        content += messageSource.getMessage("label.invasiveTestIeeg", null, locale)
                + " "
                + messageSource.getMessage("label.fromDate", null, locale)
                + ": ";
        content += TimeConverter.getDate(invasiveTestEEG.getDate());
        content += "\n";
        if (exportParams.isInvasiveTestEEGDone()) {
            content += messageSource.getMessage("label.ieegDone", null, locale);
            content += " - ";
            content += translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(invasiveTestEEG.getDone()), null, locale), locale);
            content += "\n";
        }
        if (invasiveTestEEG.getDone() == 1) {
            if (exportParams.isInvasiveTestEEGIntracranialElectrodes()) {
                content += messageSource.getMessage("label.intracranialElectrodes", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.intracranialElectrodes." +
                        String.valueOf(invasiveTestEEG.getIntracranialElectrodes()), null, locale), locale);
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
                content += messageSource.getMessage("label.eegSlow", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.eegSlow." +
                        String.valueOf(invasiveTestEEG.getInvasiveEegSlow()), null, locale), locale);
                content += "\n";
            }
            if (exportParams.isInvasiveTestEEGInvasiveEEGInterictalSpikes()) {
                content += messageSource.getMessage("label.interictalEegSpikes", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.interictalEegSpikes." +
                        String.valueOf(invasiveTestEEG.getInvasiveEegInterictalSpikes()), null, locale), locale);
                content += "\n";
            }
            if (exportParams
                    .isInvasiveTestEEGLocalizationInvasiveEEGInterictalSpikes()) {
                content += messageSource.getMessage("label.localizationInterictalEegSpikes", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(invasiveTestEEG.getLocalizationInvasiveEegInterictalSpikes()),
                        locale);
                content += "\n";
            }
            if (exportParams.isInvasiveTestEEGStatusEpilepticus()) {
                content += messageSource.getMessage("label.eegStatusEpilepticus", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(invasiveTestEEG.isInvasiveEegStatusEpilepticus()),
                        locale);
                content += "\n";
            }
            if (exportParams.isInvasiveTestEEGInvasiveIctalEEGPatterns()) {
                content += messageSource.getMessage("label.ictalEegPatterns", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.ictalEegPatterns." +
                        String.valueOf(invasiveTestEEG.getInvasiveIctalEegPatterns()), null, locale), locale);
                content += "\n";
            }
            if (exportParams.isInvasiveTestEEGLocalizationIctalEEGPatterns()) {
                content += messageSource.getMessage("label.localizationIctalEegPattern", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(invasiveTestEEG.getLocalizationInvasiveIctalEegPatterns()),
                        locale);
                content += "\n";
            }
            if (exportParams.isInvasiveTestEEGComment()) {
                content += messageSource.getMessage("label.comment", null, locale);
                content += " - ";
                content += translateComment(String.valueOf(invasiveTestEEG.getComment()),
                        locale);
                content += "\n";
            }
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
            content += messageSource.getMessage("label.corticalMappingDone", null, locale);
            content += " - ";
            content += translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(invasiveTestCorticalMapping.getDone()), null, locale), locale);
            content += "\n";
        }
        if (invasiveTestCorticalMapping.getDone() == 1) {
            if (exportParams.isInvasiveTestCorticalMappingCorticalMapping()) {
                content += messageSource.getMessage("label.corticalMapping", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.corticalMapping." +
                        String.valueOf(invasiveTestCorticalMapping.getCorticalMapping()), null, locale), locale);
                content += "\n";
            }
            if (exportParams.isInvasiveTestCorticalMappingComment()) {
                content += messageSource.getMessage("label.comment", null, locale);
                content += " - ";
                content += translateComment(String.valueOf(invasiveTestCorticalMapping.getComment()),
                        locale);
                content += "\n";
            }
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


        if (exportParams.isOperationRangeOperation()) {
            content += messageSource.getMessage("label.rangeOfOperation", null, locale);
            content += " - ";
            content += translateValue(messageSource.getMessage("label.operationType." +
                    String.valueOf(operation.getRangeOperation()), null, locale), locale);
            content += "\n";
        }
        if (exportParams.isOperationTypeOperation()) {
            content += messageSource.getMessage("label.typeOfOperation", null, locale);
            content += " - ";
            content += translateValue(messageSource.getMessage("label.operationType." +
                    String.valueOf(operation.getTypeOperation()), null, locale), locale);
            content += "\n";
        }
        if (exportParams.isOperationLocalizationOperation()) {
            content += messageSource.getMessage("label.localizationOfOperation", null, locale);
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
        if (exportParams.isOperationColostomy()) {
            content += messageSource.getMessage("label.calosotomy", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(operation.isColostomy()),
                    locale);
            content += "\n";
        }
        if (exportParams.isOperationVNS()) {
            content += messageSource.getMessage("label.vns", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(operation.isVns()),
                    locale);
            content += "\n";
        }
        if (exportParams.isOperationVNsImplantationDate()) {
            content += messageSource.getMessage("label.vnsImplantationDate", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(operation.getVnsImplantationDate()),
                    locale);
            content += "\n";
        }
        if (exportParams.isOperationOperationDetails()) {
            content += messageSource.getMessage("label.operationDetails", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(operation.getOperationDetails()),
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
            content += translateComment(String.valueOf(operation.getComment()),
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
            content += translateValue(messageSource.getMessage("label.histopathology." +
                    String.valueOf(histology.getHistopathology()), null, locale), locale);
            content += "\n";
        }
        if (histology.getHistopathology() == 2)
            if (exportParams.isHistologyFcdClassification()) {
                content += messageSource.getMessage("label.fcdClassification", null, locale);
                content += " - ";
                content += translateValue(messageSource.getMessage("label.fcdClassification." +
                        String.valueOf(histology.getFcdClassification()), null, locale), locale);
                content += "\n";
            }
        if (exportParams.isHistologyComment()) {
            content += messageSource.getMessage("label.comment", null, locale);
            content += " - ";
            content += translateComment(String.valueOf(histology.getComment()),
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
            content += messageSource.getMessage("label.process", null, locale);
            content += " - ";
            content += translateValue(messageSource.getMessage("label.process." +
                    String.valueOf(complication.getWithComplication()), null, locale), locale);
            content += "\n";
        }
        if (exportParams.isComplicationComplicationType()) {
            content += messageSource.getMessage("label.typeComplication", null, locale);
            content += " - ";
            content += translateValue(messageSource.getMessage("label.operationType." +
                    String.valueOf(complication.getComplicationType()), null, locale), locale);
            content += "\n";
        }
        if (exportParams.isComplicationComplication()) {
            content += messageSource.getMessage("label.complication", null, locale);
            content += " - ";
            content += translateValue(messageSource.getMessage("label.complication." +
                    String.valueOf(complication.getComplication()), null, locale), locale);
            content += "\n";
        }
        if (exportParams.isComplicationComment()) {
            content += messageSource.getMessage("label.comment", null, locale);
            content += " - ";
            content += translateComment(String.valueOf(complication.getComment()),
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
            content += translateValue(messageSource.getMessage("label.seizureOutcome." +
                    String.valueOf(outcome.getSeizureOutcome()), null, locale), locale);
            content += "\n";
        }
        if (exportParams.isOutcomeEEG()) {
            content += messageSource.getMessage("label.eeg", null, locale);
            content += " - ";
            content += translateValue(messageSource.getMessage("label.outcomeEeg." +
                    String.valueOf(outcome.getEeg()), null, locale), locale);
            content += "\n";
        }
        if (exportParams.isOutcomeAED()) {
            content += messageSource.getMessage("label.aed", null, locale);
            content += " - ";
            content += translateValue(messageSource.getMessage("label.outcomeAed." +
                    String.valueOf(outcome.getAed()), null, locale), locale);
            content += "\n";
        }
        if (exportParams.isOutcomeMRI()) {
            content += messageSource.getMessage("label.mri", null, locale);
            content += " - ";
            content += translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(outcome.getMri()), null, locale), locale);
            content += "\n";
        }
        if (exportParams.isOutcomeNeuropsychology()) {
            content += messageSource.getMessage("label.neuropsychology", null, locale);
            content += " - ";
            content += translateValue(messageSource.getMessage("label.done." +
                    String.valueOf(outcome.getNeuropsychology()), null, locale), locale);
            content += "\n";
        }
        if (exportParams.isOutcomeComment()) {
            content += messageSource.getMessage("label.comment", null, locale);
            content += " - ";
            content += translateComment(String.valueOf(outcome.getComment()),
                    locale);
            content += "\n";
        }

        return content;
    }

    private String printOutPatient(PatientEntity patient, Locale locale,
                                   ExportParamsEntity exportParams, boolean anonymize) {

        String content = "";

        if (exportParams.isPatientId()) {
            content += messageSource.getMessage("label.patient", null, locale);
            content += " ID ";
            content += " - ";
            content += translateValue(String.valueOf(patient.getId()), locale);
            content += "\n";
        }

        if (!anonymize)
            if (exportParams.isContactFirstName()) {
                content += messageSource.getMessage("label.firstname", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(patient.getContact().getFirstName()), locale);
                content += "\n";

            }
        if (!anonymize) {
            if (exportParams.isContactLastName()) {
                content += messageSource.getMessage("label.lastname", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(patient.getContact().getLastName()), locale);
                content += "\n";
            }
        }
        if (!anonymize) {
            if (exportParams.isPatientNin()) {
                content += messageSource.getMessage("label.birthIdentificationNumber", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(patient.getNin()), locale);
                content += "\n";
            }

        }
        if (exportParams.isPatientBirthday()) {
            content += messageSource.getMessage("label.birthdate", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(TimeConverter.getDate(patient.getBirthday())), locale);
            content += "\n";
            content += messageSource.getMessage("label.age", null, locale);
            content += " - ";
            content += translateValue(String.valueOf(getCurrentAge(patient)), locale);
            content += "\n";
        }

        if (exportParams.isPatientGender()) {
            content += messageSource.getMessage("label.gender", null, locale);
            content += " - ";
            content += messageSource.getMessage("label.gender." + translateValue(String.valueOf(patient.getGender()), locale), null, locale);
            content += "\n";
        }
        if (!anonymize)
            if (exportParams.isContactCountry()) {
                content += messageSource.getMessage("label.addressCountry", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(patient.getContact().getAddressCountry()), locale);
                content += "\n";
            }
        if (!anonymize)
            if (exportParams.isContactAddressCity()) {
                content += messageSource.getMessage("label.addressCity", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(patient.getContact().getAddressCity()), locale);
                content += "\n";
            }
        if (!anonymize)
            if (exportParams.isContactAddressStreet()) {
                content += messageSource.getMessage("label.address", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(patient.getContact().getAddressStreet()), locale);
                content += "\n";
            }
        if (!anonymize)
            if (exportParams.isContactAddressHn()) {
                content += messageSource.getMessage("label.addressHn", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(patient.getContact().getAddressHn()), locale);
                content += "\n";
            }
        if (!anonymize)
            if (exportParams.isContactPhoneNumber()) {
                content += messageSource.getMessage("label.telephone", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(patient.getContact().getPhoneNumber()), locale);
                content += "\n";
            }
        if (exportParams.isPatientDoctorId()) {
            if (!anonymize)
                if (exportParams.isContactEmail()) {
                    content += messageSource.getMessage("label.email", null, locale);
                    content += " - ";
                    content += translateValue(String.valueOf(patient.getContact().getEmail()), locale);
                    content += "\n";
                }

            if (exportParams.isPatientAgeAtTheBeginningOfEpilepsy()) {
                content += messageSource.getMessage("label.ageAtTheBeginningOfEpilepsy", null, locale);
                content += " - ";
                content += translateValue(String.valueOf(getAgeAtTheBeginningOfEpilepsy(patient)), locale);
                content += "\n";
            }
            content += messageSource.getMessage("label.assignedDoctor", null, locale);
            content += " - ";
            content += translateComment(String.valueOf(userService.getById(patient.getDoctorId(), UserFormBO.class, UserEntity.class).getContact().getFirstName() + " " + userService.getById(patient.getDoctorId(), UserFormBO.class, UserEntity.class).getContact().getLastName()), locale);
            content += "\n";

            content += messageSource.getMessage("label.dateOfExport", null, locale);
            content += " - ";
            content += translateComment(String.valueOf(TimeConverter.getDate(Calendar.getInstance().getTime())), locale);
            content += "\n";
        }

        return content;
    }


    /**
     * This function is used when it's needed to customize the export and print there some custom message
     * during every export
     */
    private String printCustom(String message) {
        String content = message;
        content += "\n";
        return content;
    }

}

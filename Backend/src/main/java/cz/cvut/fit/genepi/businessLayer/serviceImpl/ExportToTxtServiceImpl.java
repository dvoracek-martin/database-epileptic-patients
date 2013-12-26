package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.businessLayer.service.ExportToTxtService;
import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.AnamnesisEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.ComplicationEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestMRIEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestScalpEEGEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.HistologyEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestCorticalMappingEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestECOGEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestEEGEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeurologicalFindingEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyOldEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.OperationEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.OutcomeEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.PharmacotherapyEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureDetailEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureEntity;
import cz.cvut.fit.genepi.util.LoggingService;
import cz.cvut.fit.genepi.util.TimeConverter;

@Service
public class ExportToTxtServiceImpl implements ExportToTxtService {

	@Autowired
	private MessageSource messageSource;

	/** The Constant logger. */
	private LoggingService logger = new LoggingService();

	private String translateValue(String value, Locale locale) {
		if (value.equals("true"))
			return messageSource.getMessage("label.yes", null, locale);
		else if (value.equals("false"))
			return messageSource.getMessage("label.no", null, locale);
		else if (value.equals("null") || value.equals(null)) {
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
			UserEntity user, Locale locale, ExportParamsEntity exportParams) {
		logger.setLogger(ExportToTxtServiceImpl.class);
		String date = getDate();
		String name = date + ".txt";

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

	private String addEmptyLine() {
		String emptyLine = "";
		for (int i = 0; i != 50; i++) {
			emptyLine += " ";
		}
		return ("\n" + emptyLine + "\n");
	}

	private String addDashLine() {
		String emptyLine = "";
		for (int i = 0; i != 50; i++) {
			emptyLine += "-";
		}
		return ("\n" + emptyLine + "\n" + "\n");
	}

	private String addStarLine() {
		String emptyLine = "";
		for (int i = 0; i != 50; i++) {
			emptyLine += "*";
		}
		return ("\n" + emptyLine + "\n" + "\n");
	}

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

	private String printOutPharmacotherapy(PatientEntity patient,
			PharmacotherapyEntity pharmacotherapy, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";
		if (exportParams.isPharmacotherapyAED()) {

		}
		if (exportParams.isPharmacotherapyEffective()) {

		}
		if (exportParams.isPharmacotherapyDuringSurgery()) {

		}
		if (exportParams.isPharmacotherapyComment()) {

		}
		return content;
	}

	private String printOutNeurologicalFinding(PatientEntity patient,
			NeurologicalFindingEntity neurologicalFinding, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";
		if (exportParams.isNeurologicalFindingHemisphereDominance()) {

		}
		if (exportParams.isNeurologicalFindingAbnormalNeurologicalFinding()) {

		}
		if (exportParams.isNeurologicalFindingHemiparesis()) {

		}
		if (exportParams.isNeurologicalFindingVisualFieldDefects()) {

		}
		if (exportParams.isNeurologicalFindingComment()) {

		}
		return content;
	}

	private String printOutNeuropsychology(PatientEntity patient,
			NeuropsychologyEntity neuropsychology, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";
		if (exportParams.isNeuropsychologyIntellect()) {

		}
		if (exportParams.isNeuropsychologyNeurodevelopmentalExamination()) {

		}
		if (exportParams
				.isNeuropsychologyNeurodevelopmentalExaminationAdaptability()) {

		}
		if (exportParams
				.isNeuropsychologyNeurodevelopmentalExaminationSpeechExpressively()) {

		}
		if (exportParams
				.isNeuropsychologyNeurodevelopmentalExaminationSpeechReceptively()) {

		}
		if (exportParams
				.isNeuropsychologyNeurodevelopmentalExaminationFineMotorSkills()) {

		}
		if (exportParams
				.isNeuropsychologyNeurodevelopmentalExaminationGrossMotorSkills()) {

		}
		if (exportParams
				.isNeuropsychologyNeurodevelopmentalExaminationSocialBehavior()) {

		}
		if (exportParams.isNeuropsychologyIntellectualPerformance()) {

		}
		if (exportParams.isNeuropsychologyIntellectualPerformanceVerbally()) {

		}
		if (exportParams
				.isNeuropsychologyIntellectualPerformanceNonverbalAbstraction()) {

		}
		if (exportParams
				.isneuropsychologyIntellectualPerformanceNonverbalDesignCap()) {

		}
		if (exportParams.isNeuropsychologyNeuropsychologicalProfile()) {

		}
		if (exportParams.isNeuropsychologyNeuropsychologicalProfileAttention()) {

		}
		if (exportParams
				.isNeuropsychologyNeuropsychologicalProfileCognitiveSpeed()) {

		}
		if (exportParams
				.isNeuropsychologyNeuropsychologicalProfileExecutiveFunction()) {

		}
		if (exportParams
				.isNeuropsychologyNeuropsychologicalProfileSpeechExpressively()) {

		}
		if (exportParams
				.isNeuropsychologyNeuropsychologicalProfileSpeechUnderstanding()) {

		}
		if (exportParams
				.isNeuropsychologyNeuropsychologicalProfileMemoryOperating()) {

		}
		if (exportParams
				.isNeuropsychologyNeuropsychologicalProfileMemoryVerbal()) {

		}
		if (exportParams
				.isNeuropsychologyNeuropsychologicalProfileMemoryNonverbal()) {

		}
		if (exportParams
				.isNeuropsychologyNeuropsychologicalProfileMemoryLearning()) {

		}
		if (exportParams
				.isNeuropsychologyNeuropsychologicalProfilePerceptionSpeech()) {

		}
		if (exportParams
				.isNeuropsychologyNeuropsychologicalProfilePerceptionVisual()) {

		}
		if (exportParams
				.isNeuropsychologyNeuropsychologicalProfilePerceptionSpatial()) {

		}
		if (exportParams
				.isNeuropsychologyNeuropsychologicalProfileMotorSkillsDexterity()) {

		}
		if (exportParams
				.isNeuropsychologyNeuropsychologicalProfileMotorCoordination()) {

		}
		if (exportParams.isNeuropsychologyPresenceOfChanges()) {

		}
		if (exportParams.isNeuropsychologyPresenceOfChangesDetail()) {

		}
		return content;
	}

	private String printOutNeuropsychologyOld(PatientEntity patient,
			NeuropsychologyOldEntity neuropsychologyOld, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";
		if (exportParams.isNeuropsychologyOldNeuropsychologicalExamination()) {

		}
		if (exportParams.isNeuropsychologyOldIntelligenceLevel()) {

		}
		if (exportParams.isNeuropsychologyOldSpecificLearning()) {

		}
		if (exportParams.isNeuropsychologyOldDevelopmentalLanguageDisorders()) {

		}
		if (exportParams.isNeuropsychologyOldAdhdSyndrome()) {

		}
		if (exportParams.isNeuropsychologyOldComment()) {

		}

		return content;
	}

	private String printOutDiagnosticTestEEG(PatientEntity patient,
			DiagnosticTestScalpEEGEntity diagnosticTestScalpEEG, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";

		if (exportParams.isDiagnosticTestEEGDone()) {

		}
		if (exportParams.isDiagnosticTestEEGBasicActivity()) {

		}
		if (exportParams.isDiagnosticTestEEGSlow()) {

		}
		if (exportParams.isDiagnosticTestEEGInterictalEEGSpikes()) {

		}
		if (exportParams.isDiagnosticTestEEGLocalizationInerictalEEGSpikes()) {

		}
		if (exportParams.isDiagnosticTestEEGStatusEpilepticus()) {

		}
		if (exportParams.isDiagnosticTestEEGSecondarySidedSynchrony()) {

		}
		if (exportParams.isDiagnosticTestEEGIctalEEGPatterns()) {

		}
		if (exportParams.isDiagnosticTestEEGDescriptionVideoEEG()) {

		}
		if (exportParams.isDiagnosticTestEEGComment()) {

		}
		return content;
	}

	private String printOutDiagnosticTestMRI(PatientEntity patient,
			DiagnosticTestMRIEntity diagnosticTestScalpMRI, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";

		if (exportParams.isDiagnosticTestMRIDone()) {

		}
		if (exportParams.isDiagnosticTestMRIFinding()) {

		}
		if (exportParams.isDiagnosticTestMRIDescription()) {

		}
		if (exportParams.isDiagnosticTestMRIFdgPet()) {

		}
		if (exportParams.isDiagnosticTestMRIDescriptionPetHypometabolism()) {

		}
		if (exportParams.isDiagnosticTestMRIInterictalSpect()) {

		}
		if (exportParams.isDiagnosticTestMRIDescriptionSpectHypoperfuse()) {

		}
		if (exportParams.isDiagnosticTestMRIIctalSpect()) {

		}
		if (exportParams.isDiagnosticTestMRIDescriptionSpectHyperperfuse()) {

		}
		if (exportParams.isDiagnosticTestMRISiscom()) {

		}
		if (exportParams.isDiagnosticTestMRIMrsProtocol()) {

		}
		if (exportParams.isDiagnosticTestMRIMrsFinding()) {

		}
		if (exportParams.isDiagnosticTestMRIDescriptionMrsAbnormality()) {

		}
		if (exportParams.isDiagnosticTestMRIFmri()) {

		}
		if (exportParams.isDiagnosticTestMRIDetailsFmri()) {

		}
		if (exportParams.isDiagnosticTestMRIDti()) {

		}
		if (exportParams.isDiagnosticTestMRIDetailsDtiStudy()) {

		}
		if (exportParams.isDiagnosticTestMRIWada()) {

		}
		if (exportParams.isDiagnosticTestMRIDetailsWada()) {

		}
		if (exportParams.isDiagnosticTestMRIComment()) {

		}
		return content;
	}

	private String printOutInvasiveTestECOG(PatientEntity patient,
			InvasiveTestECOGEntity invasiveTestECOG, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";

		if (exportParams.isInvasiveTestECOGDone()) {

		}
		if (exportParams.isInvasiveTestECOGEcogCover()) {

		}
		if (exportParams.isInvasiveTestECOGEcogPatterns()) {

		}
		if (exportParams.isInvasiveTestECOGAfterResectiomEcog()) {

		}
		if (exportParams.isInvasiveTestECOGComment()) {

		}
		return content;
	}

	private String printOutInvasiveTestEEG(PatientEntity patient,
			InvasiveTestEEGEntity operation, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";

		if (exportParams.isInvasiveTestEEGDone()) {

		}
		if (exportParams.isInvasiveTestEEGIntracranialElectrodes()) {

		}
		if (exportParams.isInvasiveTestEEGLocalizationIntracranialElectrodes()) {

		}
		if (exportParams.isInvasiveTestEEGInvasiveEEGSlow()) {

		}
		if (exportParams.isInvasiveTestEEGInvasiveEEGInterictalSpikes()) {

		}
		if (exportParams
				.isInvasiveTestEEGLocalizationInvasiveEEGInterictalSpikes()) {

		}
		if (exportParams.isInvasiveTestEEGStatusEpilepticus()) {

		}
		if (exportParams.isInvasiveTestEEGInvasiveIctalEEGPatterns()) {

		}
		if (exportParams.isInvasiveTestEEGLocalizationIctalEEGPatterns()) {

		}
		if (exportParams.isInvasiveTestEEGComment()) {

		}
		return content;
	}

	private String printOutInvasiveTestCorticalMapping(PatientEntity patient,
			InvasiveTestCorticalMappingEntity invasiveTestCorticalMapping,
			Locale locale, ExportParamsEntity exportParams) {
		String content = "";
		if (exportParams.isInvasiveTestCorticalMappingDone()) {

		}
		if (exportParams.isInvasiveTestCorticalMappingCorticalMapping()) {

		}
		if (exportParams.isInvasiveTestCorticalMappingComment()) {

		}

		return content;
	}

	private String printOutOperation(PatientEntity patient,
			OperationEntity operation, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";

		if (exportParams.isOperationDateOperation()) {

		}
		if (exportParams.isOperationRangeOperation()) {

		}
		if (exportParams.isOperationTypeOperation()) {

		}
		if (exportParams.isOperationLocalizationOperation()) {

		}
		if (exportParams.isOperationMst()) {

		}
		if (exportParams.isOperationColostomy()) {

		}
		if (exportParams.isOperationVNS()) {

		}
		if (exportParams.isOperationVNsImplantationDate()) {

		}
		if (exportParams.isOperationOperationDetails()) {

		}
		if (exportParams.isOperationCompleteResection()) {

		}
		if (exportParams.isOperationComment()) {

		}

		return content;
	}

	private String printOutHistology(PatientEntity patient,
			HistologyEntity histology, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";

		if (exportParams.isHistologyHistopathology()) {

		}
		if (exportParams.isHistologyFcdClassification()) {

		}
		if (exportParams.isHistologyComment()) {

		}
		return content;
	}

	private String printOutComplication(PatientEntity patient,
			ComplicationEntity complication, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";

		if (exportParams.isComplicationWithCompication()) {

		}
		if (exportParams.isComplicationComplicationType()) {

		}
		if (exportParams.isComplicationComplication()) {

		}
		if (exportParams.isComplicationComment()) {
		}

		return content;
	}

	private String printOutOutcome(PatientEntity patient,
			OutcomeEntity outcome, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";

		if (exportParams.isOutcomeSeizureOutcome()) {

		}
		if (exportParams.isOutcomeEEG()) {

		}
		if (exportParams.isOutcomeAED()) {

		}
		if (exportParams.isOutcomeMRI()) {

		}
		if (exportParams.isOutcomeNeuropsychology()) {

		}
		if (exportParams.isOutcomeDistance()) {

		}
		if (exportParams.isOutcomeOperationId()) {

		}
		if (exportParams.isOutcomeComment()) {

		}

		return content;
	}

}
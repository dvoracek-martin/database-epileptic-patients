package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.businessLayer.service.ExportToDocxService;
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
public class ExportToDocxServiceImpl implements ExportToDocxService {

	@Autowired
	private MessageSource messageSource;

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
			XWPFDocument document = new XWPFDocument();
			this.addTitlePage(document, patient, locale, exportParams);

			try {
				document.write(new FileOutputStream(downloadFolder + name));
			} catch (FileNotFoundException e) {
				logger.logError(
						"File wasn't found when trying to save docx file.", e);
			} catch (IOException e) {
				logger.logError("IO exception when trying to save docx file.",
						e);
			}
		}

		return name;
	}

	private void addTitlePage(XWPFDocument document, PatientEntity patient,
			Locale locale, ExportParamsEntity exportParams) {
		XWPFParagraph tmpParagraph = document.createParagraph();
		XWPFRun tmpRun = tmpParagraph.createRun();
		tmpRun.setText(("Export of the patient "
				+ patient.getContact().getFirstName() + " "
				+ patient.getContact().getLastName() + " :" + patient.getId()
				+ ", " + getDate()));
		tmpRun.setFontSize(18);

		addContent(document, patient, locale, exportParams);

	}

	private void addContent(XWPFDocument document, PatientEntity patient,
			Locale locale, ExportParamsEntity exportParams) {

		if (exportParams.isAnamnesis()) {
			XWPFParagraph tmpParagraph = document.createParagraph();
			XWPFRun tmpRun = tmpParagraph.createRun();
			tmpRun.setText(messageSource.getMessage("label.anamnesis", null,
					locale));
			for (AnamnesisEntity anamnesis : patient.getAnamnesisList()) {
				this.printOutAnamnesis(document, patient, anamnesis, locale,
						exportParams);
			}
		}

		if (exportParams.isSeizure()) {
		}
		if (exportParams.isPharmacotherapy()) {
		}
		if (exportParams.isNeurologicalFinding()) {
		}
		if (exportParams.isNeuropsychology()) {
		}
		if (exportParams.isDiagnosticTestEEG()) {
		}
		if (exportParams.isDiagnosticTestMRI()) {
		}
		if (exportParams.isNeurologicalFinding()) {
		}
		if (exportParams.isNeurologicalFinding()) {
		}
		if (exportParams.isNeurologicalFinding()) {
		}
		if (exportParams.isNeurologicalFinding()) {
		}
		if (exportParams.isNeurologicalFinding()) {
		}
		if (exportParams.isNeurologicalFinding()) {
		}
	}

	private void printOutAnamnesis(XWPFDocument document,
			PatientEntity patient, AnamnesisEntity anamnesis, Locale locale,
			ExportParamsEntity exportParams) {
		XWPFTable anamnesisTable = document.createTable();
		XWPFTableRow anamnesisTableDateRow = anamnesisTable.getRow(0);
		anamnesisTableDateRow.getCell(0).setText(
				"Anamnesis from date:          ");
		anamnesisTableDateRow.addNewTableCell().setText(
				TimeConverter.getDate(anamnesis.getDate()) + "          ");

		if (exportParams.isAnamnesisEpilepsyInFamily()) {
			XWPFTableRow tableTwoRowTwo = anamnesisTable.createRow();
			tableTwoRowTwo.getCell(0).setText(
					messageSource.getMessage("label.epilepsyInFamily", null,
							locale));
			tableTwoRowTwo.getCell(1).setText(
					translateValue(
							String.valueOf(anamnesis.isEpilepsyInFamily()),
							locale));
		}
		if (exportParams.isAnamnesisParentalRisk()) {
			XWPFTableRow tableTwoRowTwo = anamnesisTable.createRow();
			tableTwoRowTwo.getCell(0).setText(
					messageSource
							.getMessage("label.prenatalRisk", null, locale));
			tableTwoRowTwo.getCell(1).setText(
					translateValue(String.valueOf(anamnesis.isPrenatalRisk()),
							locale));
		}
		if (exportParams.isAnamnesisFibrilConvulsions()) {
			XWPFTableRow tableTwoRowThree = anamnesisTable.createRow();
			tableTwoRowThree.getCell(0).setText(
					messageSource.getMessage("label.fibrilConvulsions", null,
							locale));
			tableTwoRowThree.getCell(1).setText(
					translateValue(
							String.valueOf(anamnesis.isFibrilConvulsions()),
							locale));
		}
		if (exportParams.isAnamnesisInflammationCns()) {
			XWPFTableRow tableTwoRowTwo = anamnesisTable.createRow();
			tableTwoRowTwo.getCell(0).setText(
					messageSource.getMessage("label.inflammationCNS", null,
							locale));
			tableTwoRowTwo.getCell(1).setText(
					translateValue(
							String.valueOf(anamnesis.isInflammationCns()),
							locale));
		}
		if (exportParams.isAnamnesisInjuryCns()) {
			XWPFTableRow tableTwoRowTwo = anamnesisTable.createRow();
			tableTwoRowTwo.getCell(0).setText(
					messageSource.getMessage("label.injuryCNS", null, locale));
			tableTwoRowTwo.getCell(1).setText(
					translateValue(String.valueOf(anamnesis.isInjuryCns()),
							locale));
		}
		if (exportParams.isAnamnesisOperationCns()) {
			XWPFTableRow tableTwoRowTwo = anamnesisTable.createRow();
			tableTwoRowTwo.getCell(0).setText(
					messageSource
							.getMessage("label.operationCNS", null, locale));
			tableTwoRowTwo.getCell(1).setText(
					translateValue(String.valueOf(anamnesis.isOperationCns()),
							locale));
		}
		if (exportParams.isAnamnesisEarlyPmdRetardation()) {
			XWPFTableRow tableTwoRowTwo = anamnesisTable.createRow();
			tableTwoRowTwo.getCell(0).setText(
					messageSource.getMessage("label.earlyPMDRetardation", null,
							locale));
			tableTwoRowTwo.getCell(1).setText(
					translateValue(
							String.valueOf(anamnesis.isEarlyPmdRetardation()),
							locale));
		}
		if (exportParams.isAnamnesisBeginningEpilepsy()) {
			XWPFTableRow tableTwoRowTwo = anamnesisTable.createRow();
			tableTwoRowTwo.getCell(0).setText(
					messageSource.getMessage("label.beginningEpilepsy", null,
							locale));
			tableTwoRowTwo.getCell(1).setText(
					translateValue(TimeConverter.getDate(anamnesis
							.getBeginningEpilepsy()), locale));
		}
		if (exportParams.isAnamnesisFirstFever()) {
			XWPFTableRow tableTwoRowTwo = anamnesisTable.createRow();
			tableTwoRowTwo.getCell(0).setText(
					messageSource.getMessage("label.firstFever", null, locale));
			tableTwoRowTwo.getCell(1).setText(
					translateValue(String.valueOf(anamnesis.isFirstFever()),
							locale));
		}
		if (exportParams.isAnamnesisInfantileSpasm()) {
			XWPFTableRow tableTwoRowTwo = anamnesisTable.createRow();
			tableTwoRowTwo.getCell(0).setText(
					messageSource.getMessage("label.infantileSpasm", null,
							locale));
			tableTwoRowTwo.getCell(1).setText(
					translateValue(
							String.valueOf(anamnesis.isInfantileSpasm()),
							locale));
		}
		if (exportParams.isAnamnesisSpecificSyndrome()) {
			XWPFTableRow tableTwoRowTwo = anamnesisTable.createRow();
			tableTwoRowTwo.getCell(0).setText(
					messageSource.getMessage("label.epilepticSyndrome", null,
							locale));
			tableTwoRowTwo.getCell(1).setText(
					translateValue(
							String.valueOf(anamnesis.getSpecificSyndrome()),
							locale));
		}
		if (exportParams.isAnamnesisNonCnsComorbidity()) {
			XWPFTableRow tableTwoRowTwo = anamnesisTable.createRow();
			tableTwoRowTwo.getCell(0).setText(
					messageSource.getMessage("label.nonCNSComorbidity", null,
							locale));
			tableTwoRowTwo.getCell(1).setText(
					translateValue(
							String.valueOf(anamnesis.getNonCnsComorbidity()),
							locale));
		}
		if (exportParams.isAnamnesisComment()) {
			XWPFTableRow tableTwoRowTwo = anamnesisTable.createRow();
			tableTwoRowTwo.getCell(0).setText(
					messageSource.getMessage("label.comment", null, locale));
			tableTwoRowTwo.getCell(1).setText(
					translateValue(String.valueOf(anamnesis.getComment()),
							locale));
		}
	}

	private String printOutSeizure(PatientEntity patient,
			SeizureEntity seizure, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";

		if (exportParams.isSeizureFrequency()) {

		}
		if (exportParams.isSeizureSecondarilyGeneralizedSeizure()) {

		}
		if (exportParams.isSeizureStatusEpilepticus()) {

		}
		if (exportParams.isSeizureComment()) {

		}
		for (SeizureDetailEntity seizureDetail : seizure.getSeizureDetailList()) {
			if (exportParams.isSeizureDetailSSCClassification()) {

			}
			if (exportParams.isSeizureDetailILAEClassification()) {

			}
			if (exportParams.isSeizureDetailComment()) {

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
		if (exportParams.setInvasiveTestECOGAfterResectionEcog()) {

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
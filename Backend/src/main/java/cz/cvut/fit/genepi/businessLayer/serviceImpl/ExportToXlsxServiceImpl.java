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

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;

import cz.cvut.fit.genepi.businessLayer.service.ExportToXlsxService;
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

// TODO: Auto-generated Javadoc
/**
 * The Class ExportToXlsxServiceImpl.
 */

@Service
public class ExportToXlsxServiceImpl implements ExportToXlsxService {

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

	/**
	 * Export.
	 * 
	 * @param pateintID
	 *            the pateint id
	 * @throws DocumentException
	 *             the document exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public String export(java.util.List<PatientEntity> patientList,
			UserEntity user, Locale locale, ExportParamsEntity exportParams) {

		logger.setLogger(ExportToTxtServiceImpl.class);
		String date = getDate();
		String name = date + ".xlsx";

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
		Workbook wb = new XSSFWorkbook();

		for (PatientEntity patient : patientList) {

			Sheet sheet = wb.createSheet(patient.getContact().getLastName()
					+ " " + patient.getContact().getFirstName() + " "
					+ patient.getNin());
			this.addContent(patient, locale, exportParams, sheet);
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
			ExportParamsEntity exportParams, Sheet sheet) {
		String content = "";
		if (exportParams.isAnamnesis()) {
			for (AnamnesisEntity anamnesis : patient.getAnamnesisList()) {
				this.printOutAnamnesis(patient, anamnesis, locale,
						exportParams,sheet);
			}
		}

		if (exportParams.isSeizure()) {
			for (SeizureEntity seizure : patient.getSeizureList()) {
				this.printOutSeizure(patient, seizure, locale,
						exportParams,sheet);
			}
		}
		if (exportParams.isPharmacotherapy()) {
			for (PharmacotherapyEntity pharmacotherapy : patient
					.getPharmacotherapyList()) {
				this.printOutPharmacotherapy(patient,
						pharmacotherapy, locale, exportParams,sheet);
			}
		}
		if (exportParams.isNeurologicalFinding()) {
			for (NeurologicalFindingEntity neurologicalFinding : patient
					.getNeurologicalFindingList()) {
				this.printOutNeurologicalFinding(patient,
						neurologicalFinding, locale, exportParams,sheet);
			}
		}
		if (exportParams.isNeuropsychology()) {
			for (NeuropsychologyEntity neuropsychology : patient
					.getNeuropsychologyList()) {
				this.printOutNeuropsychology(patient,
						neuropsychology, locale, exportParams,sheet);
			}
		}

		if (exportParams.isNeuropsychologyOld()) {
			for (NeuropsychologyOldEntity neuropsychologyOld : patient
					.getNeuropsychologyOldList()) {
				this.printOutNeuropsychologyOld(patient,
						neuropsychologyOld, locale, exportParams,sheet);
			}
		}

		if (exportParams.isDiagnosticTestEEG()) {
			for (DiagnosticTestScalpEEGEntity diagnosticTestEEG : patient
					.getDiagnosticTestEEGList()) {
				this.printOutDiagnosticTestEEG(patient,
						diagnosticTestEEG, locale, exportParams,sheet);
			}
		}

		if (exportParams.isDiagnosticTestMRI()) {
			for (DiagnosticTestMRIEntity diagnosticTestMRI : patient
					.getDiagnosticTestMRIList()) {
				this.printOutDiagnosticTestMRI(patient,
						diagnosticTestMRI, locale, exportParams,sheet);
			}
		}

		if (exportParams.isInvasiveTestECOG()) {
			for (InvasiveTestECOGEntity invasiveTestECOG : patient
					.getInvasiveTestECOGList()) {
				this.printOutInvasiveTestECOG(patient,
						invasiveTestECOG, locale, exportParams,sheet);
			}
		}

		if (exportParams.isInvasiveTestEEG()) {
			for (InvasiveTestEEGEntity invasiveTestEEG : patient
					.getInvasiveTestEEGList()) {
				this.printOutInvasiveTestEEG(patient,
						invasiveTestEEG, locale, exportParams,sheet);
			}
		}

		if (exportParams.isInvasiveTestCorticalMapping()) {
			for (InvasiveTestCorticalMappingEntity invasiveTestCorticalMappingEntity : patient
					.getInvasiveTestCorticalMappingList()) {
				this.printOutInvasiveTestCorticalMapping(patient,
								invasiveTestCorticalMappingEntity, locale,
								exportParams,sheet);
			}
		}

		if (exportParams.isOperation()) {
			for (OperationEntity operation : patient.getOperationList()) {
				this.printOutOperation(patient, operation, locale,
						exportParams,sheet);
			}
		}
		if (exportParams.isHistology()) {
			for (HistologyEntity histology : patient.getHistologyList()) {
				this.printOutHistology(patient, histology, locale,
						exportParams,sheet);
			}
		}
		if (exportParams.isComplication()) {
			for (ComplicationEntity complication : patient
					.getComplicationList()) {
				this.printOutComplication(patient, complication,
						locale, exportParams,sheet);
			}
		}
		if (exportParams.isOutcome()) {
			for (OutcomeEntity outcome : patient.getOutcomeList()) {
				this.printOutOutcome(patient, outcome, locale,
						exportParams,sheet);
			}
		}
	}

	private void printOutAnamnesis(PatientEntity patient,
			AnamnesisEntity anamnesis, Locale locale,
			ExportParamsEntity exportParams,Sheet sheet) {
		String content = "";
		content += "Anamnesis from date:";
		content += TimeConverter.getDate(anamnesis.getDate());
		
		CreationHelper createHelper = sheet.getWorkbook().getCreationHelper();
		// Create a row and put some cells in it. Rows are 0 based.
		Row row = sheet.createRow((int) 0);
		// Create a cell and put a value in it.
		Cell cell = row.createCell(0);
		cell.setCellValue(1);

		// Or do it on one line.
		row.createCell(1).setCellValue(1.2);
		row.createCell(2).setCellValue(
				createHelper.createRichTextString("This is a string"));
		row.createCell(3).setCellValue(true);

		if (exportParams.isAnamnesisEpilepsyInFamily()) {

			content += messageSource.getMessage("label.epilepsyInFamily", null,
					locale);
			content += translateValue(
					String.valueOf(anamnesis.isEpilepsyInFamily()), locale);
		}
		if (exportParams.isAnamnesisParentalRisk()) {
			content += messageSource.getMessage("label.prenatalRisk", null,
					locale);
			content += translateValue(
					String.valueOf(anamnesis.isPrenatalRisk()), locale);
		}
		if (exportParams.isAnamnesisFibrilConvulsions()) {
			content += messageSource.getMessage("label.fibrilConvulsions",
					null, locale);
			content += " - ";
			content += translateValue(
					String.valueOf(anamnesis.isFibrilConvulsions()), locale);
		}
		if (exportParams.isAnamnesisInflammationCns()) {
			content += messageSource.getMessage("label.inflammationCNS", null,
					locale);
			content += translateValue(
					String.valueOf(anamnesis.isInflammationCns()), locale);
		}
		if (exportParams.isAnamnesisInjuryCns()) {
			content += messageSource
					.getMessage("label.injuryCNS", null, locale);
			content += translateValue(String.valueOf(anamnesis.isInjuryCns()),
					locale);
		}
		if (exportParams.isAnamnesisOperationCns()) {
			content += messageSource.getMessage("label.operationCNS", null,
					locale);
			content += translateValue(
					String.valueOf(anamnesis.isOperationCns()), locale);
		}
		if (exportParams.isAnamnesisEarlyPmdRetardation()) {
			content += messageSource.getMessage("label.earlyPMDRetardation",
					null, locale);
			content += " - ";
			content += translateValue(
					String.valueOf(anamnesis.isEarlyPmdRetardation()), locale);
		}
		if (exportParams.isAnamnesisBeginningEpilepsy()) {
			content += messageSource.getMessage("label.beginningEpilepsy",
					null, locale);
			content += " - ";
			content += translateValue(
					TimeConverter.getDate(anamnesis.getBeginningEpilepsy()),
					locale);
		}
		if (exportParams.isAnamnesisFirstFever()) {
			content += messageSource.getMessage("label.firstFever", null,
					locale);
			content += translateValue(String.valueOf(anamnesis.isFirstFever()),
					locale);
		}
		if (exportParams.isAnamnesisInfantileSpasm()) {
			content += messageSource.getMessage("label.infantileSpasm", null,
					locale);
			content += translateValue(
					String.valueOf(anamnesis.isInfantileSpasm()), locale);
		}
		if (exportParams.isAnamnesisSpecificSyndrome()) {
			content += messageSource.getMessage("label.epilepticSyndrome",
					null, locale);
			content += " - ";
			content += translateValue(
					String.valueOf(anamnesis.getSpecificSyndrome()), locale);
		}
		if (exportParams.isAnamnesisNonCnsComorbidity()) {
			content += messageSource.getMessage("label.nonCNSComorbidity",
					null, locale);
			content += " - ";
			content += translateValue(
					String.valueOf(anamnesis.getNonCnsComorbidity()), locale);
		}
		if (exportParams.isAnamnesisComment()) {
			content += messageSource.getMessage("label.comment", null, locale);
			content += translateValue(String.valueOf(anamnesis.getComment()),
					locale);
		}

	}

	private void printOutSeizure(PatientEntity patient,
			SeizureEntity seizure, Locale locale,
			ExportParamsEntity exportParams,Sheet sheet) {
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
	}

	private void printOutPharmacotherapy(PatientEntity patient,
			PharmacotherapyEntity pharmacotherapy, Locale locale,
			ExportParamsEntity exportParams,Sheet sheet) {
		String content = "";
		if (exportParams.isPharmacotherapyAED()) {

		}
		if (exportParams.isPharmacotherapyEffective()) {

		}
		if (exportParams.isPharmacotherapyDuringSurgery()) {

		}
		if (exportParams.isPharmacotherapyComment()) {

		}
	}

	private void printOutNeurologicalFinding(PatientEntity patient,
			NeurologicalFindingEntity neurologicalFinding, Locale locale,
			ExportParamsEntity exportParams,Sheet sheet) {
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
	}

	private void printOutNeuropsychology(PatientEntity patient,
			NeuropsychologyEntity neuropsychology, Locale locale,
			ExportParamsEntity exportParams,Sheet sheet) {
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
	}

	private void printOutNeuropsychologyOld(PatientEntity patient,
			NeuropsychologyOldEntity neuropsychologyOld, Locale locale,
			ExportParamsEntity exportParams,Sheet sheet) {
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
	}

	private void printOutDiagnosticTestEEG(PatientEntity patient,
			DiagnosticTestScalpEEGEntity diagnosticTestScalpEEG, Locale locale,
			ExportParamsEntity exportParams,Sheet sheet) {
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
	}

	private void printOutDiagnosticTestMRI(PatientEntity patient,
			DiagnosticTestMRIEntity diagnosticTestScalpMRI, Locale locale,
			ExportParamsEntity exportParams,Sheet sheet) {
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
	}

	private void printOutInvasiveTestECOG(PatientEntity patient,
			InvasiveTestECOGEntity invasiveTestECOG, Locale locale,
			ExportParamsEntity exportParams,Sheet sheet) {
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
	}

	private void printOutInvasiveTestEEG(PatientEntity patient,
			InvasiveTestEEGEntity operation, Locale locale,
			ExportParamsEntity exportParams,Sheet sheet) {
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
	}

	private void printOutInvasiveTestCorticalMapping(PatientEntity patient,
			InvasiveTestCorticalMappingEntity invasiveTestCorticalMapping,
			Locale locale, ExportParamsEntity exportParams,Sheet sheet) {
		String content = "";
		if (exportParams.isInvasiveTestCorticalMappingDone()) {

		}
		if (exportParams.isInvasiveTestCorticalMappingCorticalMapping()) {

		}
		if (exportParams.isInvasiveTestCorticalMappingComment()) {

		}
	}

	private void printOutOperation(PatientEntity patient,
			OperationEntity operation, Locale locale,
			ExportParamsEntity exportParams,Sheet sheet) {
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
	}

	private void printOutHistology(PatientEntity patient,
			HistologyEntity histology, Locale locale,
			ExportParamsEntity exportParams,Sheet sheet) {
		String content = "";

		if (exportParams.isHistologyHistopathology()) {

		}
		if (exportParams.isHistologyFcdClassification()) {

		}
		if (exportParams.isHistologyComment()) {

		}
	}

	private void printOutComplication(PatientEntity patient,
			ComplicationEntity complication, Locale locale,
			ExportParamsEntity exportParams,Sheet sheet) {
		String content = "";

		if (exportParams.isComplicationWithCompication()) {

		}
		if (exportParams.isComplicationComplicationType()) {

		}
		if (exportParams.isComplicationComplication()) {

		}
		if (exportParams.isComplicationComment()) {
		}
	}

	private void printOutOutcome(PatientEntity patient,
			OutcomeEntity outcome, Locale locale,
			ExportParamsEntity exportParams,Sheet sheet) {
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
	}

}

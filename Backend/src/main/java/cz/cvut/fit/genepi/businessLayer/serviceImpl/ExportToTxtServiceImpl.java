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
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestScalpEEGEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.HistologyEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestECOGEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestEEGEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeurologicalFindingEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.OperationEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.OutcomeEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.PharmacotherapyEntity;
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
		return ("\n" + emptyLine + "\n");
	}

	/*
	 * private String addStarLine() { String emptyLine = ""; for (int i = 0; i
	 * != 50; i++) { emptyLine += "*"; } return ("\n" + emptyLine + "\n"); }
	 */
	private String addTitlePage(Locale locale, PatientEntity patient,
			String date) {
		String content = "Export of the patient "
				+ patient.getContact().getFirstName() + " "
				+ patient.getContact().getLastName() + " :" + patient.getId()
				+ " " + date;

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
			for (AnamnesisEntity anamnesis : patient.getAnamnesisList()) {
				content += this.printOutAnamnesis(patient, anamnesis, locale,
						exportParams);
			}
		}

		if (exportParams.isSeizure()) {
			for (SeizureEntity seizure : patient.getSeizureList()) {
				content += this.printOutSeizure(patient, seizure, locale,
						exportParams);
			}
		}
		if (exportParams.isPharmacotherapy()) {
			for (PharmacotherapyEntity pharmacotherapy : patient
					.getPharmacotherapyList()) {
				content += this.printOutPharmacotherapy(patient,
						pharmacotherapy, locale, exportParams);
			}
		}
		if (exportParams.isNeurologicalFinding()) {
			for (NeurologicalFindingEntity neurologicalFinding : patient
					.getNeurologicalFindingList()) {
				content += this.printOutNeurologicalFinding(patient,
						neurologicalFinding, locale, exportParams);
			}
		}
		if (exportParams.isNeuropsychology()) {
			for (NeuropsychologyEntity neuropsychology : patient
					.getNeuropsychologyList()) {
				content += this.printOutNeuropsychology(patient,
						neuropsychology, locale, exportParams);
			}
		}
		// TODO: NEUROPSYCHOLOGY OLD
		
		if (exportParams.isDiagnosticTestEEG()) {
			for (DiagnosticTestScalpEEGEntity diagnosticTestEEG : patient
					.getDiagnosticTestEEGList()) {
				content += this.printOutDiagnosticTestEEG(patient,
						diagnosticTestEEG, locale, exportParams);
			}
		}
		// TODO: Neurozobraz. testy

		if (exportParams.isInvasiveTestECOG()) {
			for (InvasiveTestECOGEntity ivasiveTestECOG : patient
					.getInvasiveTestECOGList()) {
				content += this.printOutInvasiveTestECOG(patient,
						ivasiveTestECOG, locale, exportParams);
			}
		}
		if (exportParams.isInvasiveTestEEG()) {
			for (InvasiveTestEEGEntity invasiveTestEEG : patient
					.getInvasiveTestEEGList()) {
				content += this.printOutInvasiveTestEEG(patient,
						invasiveTestEEG, locale, exportParams);
			}
		}

		// TODO : Kortikální mapování
		
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
		content += "Anamnesis from date:";
		content += TimeConverter.getDate(anamnesis.getDate());

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

		return content;
	}

	private String printOutSeizure(PatientEntity patient,
			SeizureEntity seizure, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";
		return content;
	}

	private String printOutPharmacotherapy(PatientEntity patient,
			PharmacotherapyEntity pharmacotherapy, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";
		return content;
	}

	private String printOutNeurologicalFinding(PatientEntity patient,
			NeurologicalFindingEntity neurologicalFinding, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";
		return content;
	}

	private String printOutNeuropsychology(PatientEntity patient,
			NeuropsychologyEntity neuropsychology, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";
		return content;
	}

	// TODO: NEUROPSYCHOLOGY OLD

	private String printOutDiagnosticTestEEG(PatientEntity patient,
			DiagnosticTestScalpEEGEntity diagnosticTestScalpEEG, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";
		return content;
	}

	// TODO: Neurozobraz. testy

	private String printOutInvasiveTestECOG(PatientEntity patient,
			InvasiveTestECOGEntity invasiveTestECOG, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";
		return content;
	}

	private String printOutInvasiveTestEEG(PatientEntity patient,
			InvasiveTestEEGEntity operation, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";
		return content;
	}

	// TODO : Kortikální mapování
	
	private String printOutOperation(PatientEntity patient,
			OperationEntity operation, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";
		return content;
	}

	private String printOutHistology(PatientEntity patient,
			HistologyEntity histology, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";
		return content;
	}

	private String printOutComplication(PatientEntity patient,
			ComplicationEntity complication, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";
		return content;
	}

	private String printOutOutcome(PatientEntity patient,
			OutcomeEntity outcome, Locale locale,
			ExportParamsEntity exportParams) {
		String content = "";
		return content;
	}

}
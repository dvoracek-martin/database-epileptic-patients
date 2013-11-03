package cz.cvut.fit.genepi.serviceImpl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.entity.card.AnamnesisEntity;
import cz.cvut.fit.genepi.service.ExportToCsvService;
import cz.cvut.fit.genepi.service.LoggingService;

@Service
public class ExportToCsvServiceImpl implements ExportToCsvService {

	@Autowired
	private MessageSource messageSource;

	// private static UserEntity user;
	/** The Constant logger. */
	private LoggingService logger = new LoggingService();

	private static String getDate() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		reportDate = reportDate.replace(' ', '_');
		reportDate = reportDate.replace('/', '_');
		return reportDate;
	}

	public String export(List<PatientEntity> patientList, UserEntity user,
			Locale locale, ExportParamsEntity exports) {

		// TODO: fill in the list with localized names of the cards
		List<String> listOfPossibleCards = new ArrayList<String>();
		// !!!

		logger.setLogger(ExportToCsvServiceImpl.class);

		String date = getDate();
		String name = date + ".csv";

		String downloadFolder = System.getProperty("user.home")
				+ System.getProperty("file.separator") + "Download_Links"
				+ System.getProperty("file.separator");
		File f = null;
		String os = System.getProperty("os.name").toLowerCase();
		if (os.indexOf("win") >= 0) {
			downloadFolder.replace("\\", "/");
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
						"Couldn't create new file when trying to save csv file.",
						e);
			}
		}

		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(f.getAbsoluteFile()), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			logger.logError(
					"UnsupportedEncodingException when trying to init writer for csv file.",
					e);
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			logger.logError(
					"FileNotFoundException when trying to init writer for csv file.",
					e);
			e.printStackTrace();
		}
		String content = "";
		for (PatientEntity patient : patientList) {
			content += addTitlePage(f, bw, locale, patient, date);
			content += addContent(f, exports, listOfPossibleCards, locale,
					patient);
		}
		try {
			bw.write(content);
		} catch (IOException e) {
			logger.logError("Exception when trying to write to csv file.", e);
			e.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e) {
			logger.logError("Exception when trying to close csv file.", e);
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

	private String addStarLine() {
		String emptyLine = "";
		for (int i = 0; i != 50; i++) {
			emptyLine += "*";
		}
		return ("\n" + emptyLine + "\n");
	}

	private String addTitlePage(File f, BufferedWriter bw, Locale locale,
			PatientEntity patient, String date) {
		String content = "Export of the patient "
				+ patient.getContact().getFirstName() + " "
				+ patient.getContact().getLastName() + " ,ID:"
				+ patient.getId() + " " + date;

		content += addEmptyLine();
		content += ("Report generated by: " + System.getProperty("user.name")
				+ ", " + new Date() + "\n");
		content += addEmptyLine();
		return content;
	}

	private String addContent(File f, ExportParamsEntity exportParams,
			java.util.List<String> listOfPossibleCards, Locale locale,
			PatientEntity patient) {
		String content = "";
		content += addDashLine();
		content += addEmptyLine();
		/*
		 * for (String s : exports) { if (s.equals(listOfPossibleCards.get(0)))
		 * { content += (messageSource.getMessage("label.anamnesis", null,
		 * locale) + "-" + (messageSource.getMessage( "label.dateExamination",
		 * null, locale))); for (AnamnesisEntity a : patient.getAnamnesisList())
		 * { content += messageSource.getMessage( "label.dateExamination", null,
		 * locale); content += (": " + a.getAdded() + "\n"); content +=
		 * messageSource.getMessage( "label.epilepsyInFamily", null, locale);
		 * content += (": " + a.getEpilepsyInFamily() + "\n"); content +=
		 * messageSource.getMessage("label.prenatalRisk", null, locale); content
		 * += (": " + a.getPrenatalRisk() + "\n"); content +=
		 * messageSource.getMessage( "label.inflammationCNS", null, locale);
		 * content += (": " + a.getInflammationCns() + "\n"); content +=
		 * messageSource.getMessage( "label.fibrilConvulsions", null, locale);
		 * content += (": " + a.getFibrilConvulsions() + "\n"); content +=
		 * messageSource.getMessage("label.injuryCNS", null, locale); content +=
		 * (": " + a.getInjuryCns() + "\n"); content +=
		 * messageSource.getMessage("label.operationCNS", null, locale); content
		 * += (": " + a.getOperationCns() + "\n"); content +=
		 * messageSource.getMessage( "label.earlyPMDRetardation", null, locale);
		 * content += (": " + a.getEarlyPmdRetardation() + "\n"); content +=
		 * messageSource.getMessage( "label.beginningEpilepsy", null, locale);
		 * content += (": " + a.getBeginningEpilepsy() + "\n"); content +=
		 * messageSource.getMessage("label.firstFever", null, locale); content
		 * += (": " + a.getFirstFever() + "\n"); content +=
		 * messageSource.getMessage("label.infantileSpasm", null, locale);
		 * content += (": " + a.getInfantileSpasm() + "\n"); content +=
		 * messageSource.getMessage( "label.epilepticSyndrome", null, locale);
		 * content += (": " + a.getSpecificSyndromeIdcom() + "\n"); content +=
		 * messageSource.getMessage( "label.nonCNSComorbidity", null, locale);
		 * content += (": " + a.getNonCnsComorbidity() + "\n"); content +=
		 * messageSource.getMessage("label.comment", null, locale); content +=
		 * (": " + a.getComment() + "\n");
		 * 
		 * content += addStarLine(); } } content += addDashLine(); content +=
		 * addEmptyLine();
		 * 
		 * if (s.equals(listOfPossibleCards.get(1))) { content +=
		 * ("Anamnesis\n\n"); for (AnamnesisEntity a :
		 * patient.getAnamnesisList()) { content += (a.getAdded()); content +=
		 * addStarLine(); } } if (s.equals(listOfPossibleCards.get(2))) {
		 * content += ("Anamnesis\n\n"); for (AnamnesisEntity a :
		 * patient.getAnamnesisList()) { content += (a.getAdded()); content +=
		 * addStarLine(); } } if (s.equals(listOfPossibleCards.get(3))) {
		 * content += ("Anamnesis\n\n"); for (AnamnesisEntity a :
		 * patient.getAnamnesisList()) { content += (a.getAdded()); content +=
		 * addStarLine(); } } if (s.equals(listOfPossibleCards.get(4))) {
		 * content += ("Anamnesis\n\n"); for (AnamnesisEntity a :
		 * patient.getAnamnesisList()) { content += (a.getAdded()); content +=
		 * addStarLine(); } } if (s.equals(listOfPossibleCards.get(5))) {
		 * content += ("Anamnesis\n\n"); for (AnamnesisEntity a :
		 * patient.getAnamnesisList()) { content += (a.getAdded()); content +=
		 * addStarLine(); } } if (s.equals(listOfPossibleCards.get(6))) {
		 * content += ("Anamnesis\n\n"); for (AnamnesisEntity a :
		 * patient.getAnamnesisList()) { content += (a.getAdded()); content +=
		 * addStarLine(); } } if (s.equals(listOfPossibleCards.get(7))) {
		 * content += ("Anamnesis\n\n"); for (AnamnesisEntity a :
		 * patient.getAnamnesisList()) { content += (a.getAdded()); content +=
		 * addStarLine(); }
		 * 
		 * } }
		 */
		return content;
	}
}
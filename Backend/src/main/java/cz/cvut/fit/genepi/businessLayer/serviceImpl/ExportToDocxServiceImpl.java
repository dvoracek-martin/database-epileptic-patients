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
import cz.cvut.fit.genepi.util.LoggingService;
import cz.cvut.fit.genepi.util.TimeConverter;

@Service
public class ExportToDocxServiceImpl implements ExportToDocxService {


	@Autowired
	private MessageSource messageSource;
	
	private LoggingService logger = new LoggingService();

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
			this.addText(document, patient, locale);
			XWPFParagraph tmpParagraph = document.createParagraph();
			XWPFRun tmpRun = tmpParagraph.createRun();
			tmpRun.setText(("Export of the patient "
					+ patient.getContact().getFirstName() + " "
					+ patient.getContact().getLastName() + " :" + patient.getId()
					+ ", " + getDate()));
			tmpRun.setFontSize(18);

			
			
			try {
				document.write(new FileOutputStream(new File(downloadFolder
						+ getDate() + ".docx")));
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

	private void addText(XWPFDocument document, PatientEntity patient, Locale locale) {
		XWPFParagraph tmpParagraph = document.createParagraph();
		XWPFRun tmpRun = tmpParagraph.createRun();
		tmpRun.setText(("Export of the patient "
				+ patient.getContact().getFirstName() + " "
				+ patient.getContact().getLastName() + " :" + patient.getId()
				+ ", " + getDate()));
		tmpRun.setFontSize(18);

		addContent(document, patient, locale);

	}

	private void addContent(XWPFDocument document, PatientEntity patient, Locale locale) {
		for (AnamnesisEntity anamnesis : patient.getAnamnesisList()){
			XWPFParagraph tmpParagraph = document.createParagraph();				
			XWPFRun tmpRun = tmpParagraph.createRun();			
			tmpRun.setText(messageSource.getMessage("label.anamnesis", null, locale));
			this.addAnamnesis(document, patient, anamnesis, locale);
		}
	}

 	private void addAnamnesis(XWPFDocument document, PatientEntity patient, AnamnesisEntity anamnesis, Locale locale) {
		XWPFTable anamnesisTable = document.createTable();
		XWPFTableRow anamnesisTableDateRow = anamnesisTable.getRow(0);
		anamnesisTableDateRow.getCell(0).setText("Anamnesis from date:");
		anamnesisTableDateRow.addNewTableCell().setText(TimeConverter.getDate(anamnesis.getDate()));

		XWPFTableRow tableTwoRowTwo = anamnesisTable.createRow();
		tableTwoRowTwo.getCell(0).setText("col one, row two");
		tableTwoRowTwo.getCell(1).setText("col two, row two");
		
		XWPFTableRow tableTwoRowThree = anamnesisTable.createRow();
		tableTwoRowThree.getCell(0).setText("col one, row three");
		tableTwoRowThree.getCell(1).setText("col two, row three");		
	}
}

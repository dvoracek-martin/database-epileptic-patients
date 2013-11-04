package cz.cvut.fit.genepi.serviceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import cz.cvut.fit.genepi.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.entity.card.AnamnesisEntity;
import cz.cvut.fit.genepi.service.ExportToPdfService;
import cz.cvut.fit.genepi.service.LoggingService;
import cz.cvut.fit.genepi.util.TimeConverter;

// TODO: Auto-generated Javadoc
/**
 * The Class ExportToPdfServiceImpl.
 */
@Service
public class ExportToPdfServiceImpl implements ExportToPdfService {

	@Autowired
	private MessageSource messageSource;

	private static UserEntity user;

	/** The cat font. */
	private static Font catFont;

	/** The red font. */
	private static Font redFont;

	/** The larger font. */
	private static Font largerFont;

	/** The regular font. */
	private static Font normalFont;

	/** The sub font. */
	private static Font subFont;

	/** The small bold. */
	private static Font smallBold;

	/** The Constant logger. */
	private LoggingService logger = new LoggingService();

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.cvut.fit.genepi.service.ExportToPdfService#export(int)
	 */

	private static String getDate() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		reportDate = reportDate.replace(' ', '_');
		reportDate = reportDate.replace('/', '_');
		return reportDate;
	}

	private void initFonts() {
		BaseFont bf = null;
		String os = System.getProperty("os.name").toLowerCase();

		try {
			if (os.indexOf("win") < 0) {
				bf = BaseFont.createFont(
						"/usr/share/fonts/truetype/msttcorefonts/Arial.ttf",
						BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catFont = new Font(bf, 18, Font.BOLD);
		redFont = new Font(bf, 12, Font.NORMAL, BaseColor.RED);
		largerFont = new Font(bf, 16, Font.NORMAL);
		normalFont = new Font(bf, 12, Font.NORMAL);
		subFont = new Font(bf, 16, Font.BOLD);
		smallBold = new Font(bf, 12, Font.BOLD);

	}

	/*
	 * TODO:
	 * 
	 * Make it able to accept List<PatientEntity> and iterate through it
	 */

	public String export(java.util.List<PatientEntity> patientList,
			UserEntity user, Locale locale, ExportParamsEntity exportParams) {
		logger.setLogger(ExportToPdfServiceImpl.class);
		initFonts();
		Document document = new Document();

		ExportToPdfServiceImpl.user = user;
		String date = getDate();
		String name = date + ".pdf";

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
						"Couldn't create new file when trying to save pdf file.",
						e);
			}
		}

		try {
			PdfWriter.getInstance(document, new FileOutputStream(downloadFolder
					+ getDate() + ".pdf"));
		} catch (FileNotFoundException e) {
			logger.logError("File wasn't found when trying to save pdf file.",
					e);
		} catch (DocumentException e) {
			logger.logError("Document exception when trying to save pdf file.",
					e);
			e.printStackTrace();
		}

		java.util.List<String> listOfPossibleCards = new ArrayList<String>();

		document.open();
		addMetaData(document);
		for (PatientEntity patient : patientList) {
			try {
				addTitlePage(document, patient);
			} catch (DocumentException e) {
				logger.logError(
						"Document exception when trying to save pdf file.", e);
				e.printStackTrace();
			}
			try {
				addContent(document, listOfPossibleCards, patient, locale,
						exportParams);
			} catch (DocumentException e) {
				logger.logError(
						"Document exception when trying to save pdf file.", e);
				e.printStackTrace();
			}
		}
		document.close();
		return name;
	}

	// iText allows to add metadata to the PDF which can be viewed in your Adobe
	// Reader
	// under File -> Properties
	/**
	 * Adds the meta data.
	 * 
	 * @param document
	 *            the document
	 */
	private static void addMetaData(Document document) {
		document.addTitle("Export from GENEPI software");
		document.addSubject("Genepi Export");
		document.addKeywords("GENEPI, MOTOL, Epilepsy, Research");
		document.addAuthor(user.getUsername() + " " + user.getId() + " "
				+ user.getContact().getFirstName() + " "
				+ user.getContact().getLastName());
		document.addCreator(user.getUsername() + " " + user.getId() + " "
				+ user.getContact().getFirstName() + " "
				+ user.getContact().getLastName());
	}

	/**
	 * Adds the title page.
	 * 
	 * @param document
	 *            the document
	 * @throws DocumentException
	 *             the document exception
	 */
	private static void addTitlePage(Document document, PatientEntity patient)
			throws DocumentException {
		Paragraph preface = new Paragraph();
		// We add one empty line
		addEmptyLine(preface, 1);
		// Lets write a big header
		preface.add(new Paragraph("Export of the patient "
				+ patient.getContact().getFirstName() + " "
				+ patient.getContact().getLastName() + " ,ID:"
				+ patient.getId() + ", " + getDate(), catFont));

		addEmptyLine(preface, 1);
		// Will create: Report generated by: _name, _date
		preface.add(new Paragraph(
				"Report generated by: " + System.getProperty("user.name") + ", " + new Date(), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
				smallBold));
		addEmptyLine(preface, 3);
		preface.add(new Paragraph(
				"This document describes something which is very important ",
				smallBold));

		addEmptyLine(preface, 8);

		preface.add(new Paragraph(
				"This document is a preliminary version and not subject to your license agreement or any other agreement with vogella.com ;-).",
				redFont));

		document.add(preface);
		// Start a new page
		document.newPage();
	}

	/**
	 * Adds the content.
	 * 
	 * @param document
	 *            the document
	 * @throws DocumentException
	 *             the document exception
	 */
	private void addContent(Document document,
			java.util.List<String> listOfPossibleCards, PatientEntity patient,
			Locale locale, ExportParamsEntity exportParams)
			throws DocumentException {

		Anchor anchor = new Anchor("First Chapter", catFont);
		anchor.setName("First Chapter");

		// Second parameter is the number of the chapter
		Chapter catPart = new Chapter(new Paragraph(anchor), 1);

		Paragraph subPara = new Paragraph("Subcategory 1", subFont);
		Section subCatPart = catPart.addSection(subPara);
		subCatPart.add(new Paragraph("Hello"));

		subPara = new Paragraph("Subcategory 2", subFont);
		subCatPart = catPart.addSection(subPara);
		subCatPart.add(new Paragraph("Paragraph 1"));
		subCatPart.add(new Paragraph("Paragraph 2"));
		subCatPart.add(new Paragraph("Paragraph 3"));

		// Add a list
		createList(subCatPart);
		Paragraph paragraph = new Paragraph();
		addEmptyLine(paragraph, 5);
		subCatPart.add(paragraph);

		Paragraph patientParagraph = new Paragraph(patient.getContact()
				.getFirstName() + " " + patient.getContact().getLastName(),
				largerFont);
		patientParagraph.setAlignment(Element.ALIGN_CENTER);

		addEmptyLine(patientParagraph, 2);
		subCatPart.add(patientParagraph);
		// Add a table
		createTable(subCatPart, patient, exportParams, locale);

		if (exportParams.isAnamnesis()) {
			Paragraph anamnesisParahraph = new Paragraph(
					messageSource.getMessage("label.anamnesis", null, locale)
							+ "\n\n", catFont);
			anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
			subCatPart.add(anamnesisParahraph);
			for (AnamnesisEntity a : patient.getAnamnesisList()) {
				printOutAnamnesis(subCatPart, a, locale, exportParams);
			}
		}
		if (exportParams.isAnamnesis()) {
			Paragraph anamnesisParahraph = new Paragraph("Anamnesis\n\n",
					catFont);
			anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
			subCatPart.add(anamnesisParahraph);
			for (AnamnesisEntity a : patient.getAnamnesisList()) {
				printOutAnamnesis(subCatPart, a, locale, exportParams);
			}
		}
		if (exportParams.isAnamnesis()) {
			Paragraph anamnesisParahraph = new Paragraph("Anamnesis\n\n",
					catFont);
			anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
			subCatPart.add(anamnesisParahraph);
			for (AnamnesisEntity a : patient.getAnamnesisList()) {
				printOutAnamnesis(subCatPart, a, locale, exportParams);
			}
		}
		if (exportParams.isAnamnesis()) {
			Paragraph anamnesisParahraph = new Paragraph("Anamnesis\n\n",
					catFont);
			anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
			subCatPart.add(anamnesisParahraph);
			for (AnamnesisEntity a : patient.getAnamnesisList()) {
				printOutAnamnesis(subCatPart, a, locale, exportParams);
			}
		}
		if (exportParams.isAnamnesis()) {
			Paragraph anamnesisParahraph = new Paragraph("Anamnesis\n\n",
					catFont);
			anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
			subCatPart.add(anamnesisParahraph);
			for (AnamnesisEntity a : patient.getAnamnesisList()) {
				printOutAnamnesis(subCatPart, a, locale, exportParams);
			}
		}
		if (exportParams.isAnamnesis()) {
			Paragraph anamnesisParahraph = new Paragraph("Anamnesis\n\n",
					catFont);
			anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
			subCatPart.add(anamnesisParahraph);
			for (AnamnesisEntity a : patient.getAnamnesisList()) {
				printOutAnamnesis(subCatPart, a, locale, exportParams);
			}
		}
		if (exportParams.isAnamnesis()) {
			Paragraph anamnesisParahraph = new Paragraph("Anamnesis\n\n",
					catFont);
			anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
			subCatPart.add(anamnesisParahraph);
			for (AnamnesisEntity a : patient.getAnamnesisList()) {
				printOutAnamnesis(subCatPart, a, locale, exportParams);
			}
		}
		if (exportParams.isAnamnesis()) {
			Paragraph anamnesisParahraph = new Paragraph("Anamnesis\n\n",
					catFont);
			anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
			subCatPart.add(anamnesisParahraph);
			for (AnamnesisEntity a : patient.getAnamnesisList()) {
				printOutAnamnesis(subCatPart, a, locale, exportParams);

			}
		}

		// Now add all this to the document
		document.add(catPart);

		// Next section
		anchor = new Anchor("Second Chapter", catFont);
		anchor.setName("Second Chapter");

		// Second parameter is the number of the chapter
		catPart = new Chapter(new Paragraph(anchor), 1);

		subPara = new Paragraph("Subcategory", subFont);
		subCatPart = catPart.addSection(subPara);
		subCatPart.add(new Paragraph("This is a very important message"));

		// Now add all this to the document
		document.add(catPart);

	}

	/**
	 * Creates the table.
	 * 
	 * @param subCatPart
	 *            the sub cat part
	 * @throws BadElementException
	 *             the bad element exception
	 */
	private void createTable(Section subCatPart, PatientEntity patient,
			ExportParamsEntity exportParams, Locale locale)
			throws BadElementException {
		PdfPTable table = new PdfPTable(2);

		// t.setBorderColor(BaseColor.GRAY);
		// t.setPadding(4);
		// t.setSpacing(4);
		// t.setBorderWidth(1);

		if (exportParams.isPatientId()) {
			table.addCell(new Phrase("Číslo pacienta:", normalFont));
			table.addCell(String.valueOf(patient.getId()));
		}
		if (exportParams.isPatientNin()) {
			table.addCell(new Phrase("Rodné číslo:", normalFont));
			table.addCell(String.valueOf(patient.getNin()));
		}
		if (exportParams.isContactAddressCity()) {
			table.addCell(new Phrase("Adresa:", normalFont));
			table.addCell(String.valueOf(patient.getContact()
					.getAddressStreet()));
		}
		if (exportParams.isContactAddressStreet()) {
			table.addCell(new Phrase("Adresa:", normalFont));
			table.addCell(String.valueOf(patient.getContact()
					.getAddressStreet()));
		}
		if (exportParams.isContactAddressHn()) {
			table.addCell(new Phrase("Adresa:", normalFont));
			table.addCell(String.valueOf(patient.getContact()
					.getAddressStreet()));
		}
		if (exportParams.isContactPhoneNumber()) {
			table.addCell(new Phrase("Telefon:", normalFont));
			table.addCell(String.valueOf(patient.getContact().getPhoneNumber()));
		}
		if (exportParams.isPatientBirthday()) {
			table.addCell(new Phrase("Věk:", normalFont));
			table.addCell(String.valueOf(patient.getBirthday()));
		}
		if (exportParams.isPatientGender()) {
			table.addCell(new Phrase("Pohaví:", normalFont));
			table.addCell(String.valueOf(patient.getGender()));
		}
		if (exportParams.isContactEmail()) {
			table.addCell(new Phrase("Email:", normalFont));
			table.addCell(String.valueOf(patient.getContact().getEmail()));
		}

		// TODO:
		// add special parameter for patient?
		if (exportParams.isAnamnesisBeginningEpilepsy()) {
			table.addCell(new Phrase("Věk při začátku epilepsie:", normalFont));
			table.addCell(TimeConverter.getAge(patient.getAnamnesisList().get(0).getBeginningEpilepsy()));
		}

		if (exportParams.isPatientDoctorId()) {
			table.addCell(new Phrase("Ošetřující lékař:", normalFont));
			table.addCell(String.valueOf(patient.getDoctor().getContact()
					.getLastName()
					+ " " + patient.getDoctor().getContact().getFirstName()));
		}

		subCatPart.add(table);

	}

	private void printOutAnamnesis(Section subCatPart,
			AnamnesisEntity anamnesis, Locale locale,
			ExportParamsEntity exportParams) throws BadElementException {
		PdfPTable table = new PdfPTable(2);

		// t.setBorderColor(BaseColor.GRAY);
		// t.setPadding(4);
		// t.setSpacing(4);
		// t.setBorderWidth(1);
		table.addCell(new Phrase("Anamnesis from date:", largerFont));
		
		table.addCell(new Phrase(TimeConverter.getDate(anamnesis.getDate())));
		if (exportParams.isAnamnesisEpilepsyInFamily()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.epilepsyInFamily", null, locale), normalFont));
			table.addCell(String.valueOf(anamnesis.getEpilepsyInFamily()));
		}
		if (exportParams.isAnamnesisParentalRisk()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.prenatalRisk", null, locale), normalFont));
			table.addCell(String.valueOf(anamnesis.getPrenatalRisk()));
		}
		if (exportParams.isAnamnesisFibrilConvulsions()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.fibrilConvulsions", null, locale), normalFont));
			table.addCell(String.valueOf(anamnesis.getFibrilConvulsions()));
		}
		if (exportParams.isAnamnesisInflammationCns()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.inflammationCNS", null, locale), normalFont));
			table.addCell(String.valueOf(anamnesis.getInflammationCns()));
		}
		if (exportParams.isAnamnesisInjuryCns()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.injuryCNS", null, locale), normalFont));
			table.addCell(String.valueOf(anamnesis.getInjuryCns()));
		}
		if (exportParams.isAnamnesisOperationCns()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.operationCNS", null, locale), normalFont));
			table.addCell(String.valueOf(anamnesis.getOperationCns()));
		}
		if (exportParams.isAnamnesisEarlyPmdRetardation()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.earlyPMDRetardation", null, locale), normalFont));
			table.addCell(String.valueOf(anamnesis.getEarlyPmdRetardation()));
		}
		if (exportParams.isAnamnesisBeginningEpilepsy()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.beginningEpilepsy", null, locale), normalFont));
			table.addCell(TimeConverter.getDate(anamnesis.getBeginningEpilepsy()));
		}

		if (exportParams.isAnamnesisFirstFever()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.firstFever", null, locale), normalFont));
			table.addCell(String.valueOf(anamnesis.getFirstFever()));
		}
		if (exportParams.isAnamnesisInfantileSpasm()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.infantileSpasm", null, locale), normalFont));
			table.addCell(String.valueOf(anamnesis.getInfantileSpasm()));
		}
		if (exportParams.isAnamnesisSpecificSyndrome()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.epilepticSyndrome", null, locale), normalFont));
			table.addCell(String.valueOf(anamnesis.getSpecificSyndromeIdcom()));
		}
		if (exportParams.isAnamnesisNonCnsComorbidity()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.nonCNSComorbidity", null, locale), normalFont));
			table.addCell(String.valueOf(anamnesis.getNonCnsComorbidity()));
		}
		subCatPart.add(table);

	}

	/**
	 * Creates the list.
	 * 
	 * @param subCatPart
	 *            the sub cat part
	 */
	private static void createList(Section subCatPart) {
		List list = new List(true, false, 10);
		list.add(new ListItem("First point"));
		list.add(new ListItem("Second point"));
		list.add(new ListItem("Third point"));
		subCatPart.add(list);
	}

	/**
	 * Adds the empty line.
	 * 
	 * @param paragraph
	 *            the paragraph
	 * @param number
	 *            the number
	 */
	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}

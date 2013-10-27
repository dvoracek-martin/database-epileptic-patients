package cz.cvut.fit.genepi.serviceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.entity.card.AnamnesisEntity;
import cz.cvut.fit.genepi.service.ExportToPdfService;
import cz.cvut.fit.genepi.service.LoggingService;

// TODO: Auto-generated Javadoc
/**
 * The Class ExportToPdfServiceImpl.
 */
@Service
public class ExportToPdfServiceImpl implements ExportToPdfService {

	@Autowired
	private static MessageSource messageSource;

	private static PatientEntity patient;

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
		reportDate=reportDate.replace(' ','_');
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
	/* TODO:
	 * 
	 * Make it able to accept List<PatientEntity> and iterate through it 
	 * 
	 */

	public void export(java.util.List<PatientEntity> patient, UserEntity user,
			java.util.List<String> exports,
			java.util.List<String> listOfPossibleCards) {
		logger.setLogger(ExportToPdfServiceImpl.class);
		initFonts();
		Document document = new Document();
		
		ExportToPdfServiceImpl.user = user;
		String downloadFolder = System.getProperty("user.home")
				+ System.getProperty("file.separator") + "Download_Links"
				+ System.getProperty("file.separator");

		String os = System.getProperty("os.name").toLowerCase();
		if (os.indexOf("win") >= 0) {
			downloadFolder.replace("\\", "/");
		} else {
			downloadFolder = "/usr/local/tomcat/webapps/GENEPI/resources/downloads/";
			File f = new File(downloadFolder + getDate()
					+ ".pdf");
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
					+ "patient" +getDate() + ".pdf"));
		} catch (FileNotFoundException e) {
			logger.logError("File wasn't found when trying to save pdf file.",
					e);
		} catch (DocumentException e) {
			logger.logError("Document exception when trying to save pdf file.",
					e);
			e.printStackTrace();
		}

		document.open();
		addMetaData(document);
		try {
			addTitlePage(document);
		} catch (DocumentException e) {
			logger.logError("Document exception when trying to save pdf file.",
					e);
			e.printStackTrace();
		}
		try {
			addContent(document, exports, listOfPossibleCards);
		} catch (DocumentException e) {
			logger.logError("Document exception when trying to save pdf file.",
					e);
			e.printStackTrace();
		}
		document.close();
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
		document.addTitle(patient.getContact().getFirstName() + " "
				+ patient.getContact().getLastName() + " ,ID:"
				+ patient.getId() + " " + getDate());
		document.addSubject("Using iText");
		document.addKeywords("Java, PDF, iText");
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
	private static void addTitlePage(Document document)
			throws DocumentException {
		Paragraph preface = new Paragraph();
		// We add one empty line
		addEmptyLine(preface, 1);
		// Lets write a big header
		preface.add(new Paragraph("Export of the patient "
				+ patient.getContact().getFirstName() + " "
				+ patient.getContact().getLastName() + " ,ID:"
				+ patient.getId() + " " + getDate(), catFont));

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
	private static void addContent(Document document,
			java.util.List<String> exports,
			java.util.List<String> listOfPossibleCards)
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
		createTable(subCatPart);
		;
		for (String s : exports) {
			if (s.equals(listOfPossibleCards.get(0))) {
				Paragraph anamnesisParahraph = new Paragraph("Anamnesis\n\n",
						catFont);
				anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
				subCatPart.add(anamnesisParahraph);
				for (AnamnesisEntity a : patient.getAnamnesisList()) {
					printOutAnamnesis(subCatPart, a);
				}
			}
			if (s.equals(listOfPossibleCards.get(1))) {
				Paragraph anamnesisParahraph = new Paragraph("Anamnesis\n\n",
						catFont);
				anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
				subCatPart.add(anamnesisParahraph);
				for (AnamnesisEntity a : patient.getAnamnesisList()) {
					printOutAnamnesis(subCatPart, a);
				}
			}
			if (s.equals(listOfPossibleCards.get(2))) {
				Paragraph anamnesisParahraph = new Paragraph("Anamnesis\n\n",
						catFont);
				anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
				subCatPart.add(anamnesisParahraph);
				for (AnamnesisEntity a : patient.getAnamnesisList()) {
					printOutAnamnesis(subCatPart, a);
				}
			}
			if (s.equals(listOfPossibleCards.get(3))) {
				Paragraph anamnesisParahraph = new Paragraph("Anamnesis\n\n",
						catFont);
				anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
				subCatPart.add(anamnesisParahraph);
				for (AnamnesisEntity a : patient.getAnamnesisList()) {
					printOutAnamnesis(subCatPart, a);
				}
			}
			if (s.equals(listOfPossibleCards.get(4))) {
				Paragraph anamnesisParahraph = new Paragraph("Anamnesis\n\n",
						catFont);
				anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
				subCatPart.add(anamnesisParahraph);
				for (AnamnesisEntity a : patient.getAnamnesisList()) {
					printOutAnamnesis(subCatPart, a);
				}
			}
			if (s.equals(listOfPossibleCards.get(5))) {
				Paragraph anamnesisParahraph = new Paragraph("Anamnesis\n\n",
						catFont);
				anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
				subCatPart.add(anamnesisParahraph);
				for (AnamnesisEntity a : patient.getAnamnesisList()) {
					printOutAnamnesis(subCatPart, a);
				}
			}
			if (s.equals(listOfPossibleCards.get(6))) {
				Paragraph anamnesisParahraph = new Paragraph("Anamnesis\n\n",
						catFont);
				anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
				subCatPart.add(anamnesisParahraph);
				for (AnamnesisEntity a : patient.getAnamnesisList()) {
					printOutAnamnesis(subCatPart, a);
				}
			}
			if (s.equals(listOfPossibleCards.get(7))) {
				Paragraph anamnesisParahraph = new Paragraph("Anamnesis\n\n",
						catFont);
				anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
				subCatPart.add(anamnesisParahraph);
				for (AnamnesisEntity a : patient.getAnamnesisList()) {
					printOutAnamnesis(subCatPart, a);
				}
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
	private static void createTable(Section subCatPart)
			throws BadElementException {
		PdfPTable table = new PdfPTable(2);

		// t.setBorderColor(BaseColor.GRAY);
		// t.setPadding(4);
		// t.setSpacing(4);
		// t.setBorderWidth(1);

		table.addCell(new Phrase("Číslo pacienta:", normalFont));
		table.addCell(String.valueOf(patient.getId()));
		table.addCell(new Phrase("Rodné číslo:", normalFont));
		table.addCell(String.valueOf(patient.getNin()));
		table.addCell(new Phrase("Adresa:", normalFont));
		table.addCell(String.valueOf(patient.getContact().getAddressStreet()));
		table.addCell(new Phrase("Telefon:", normalFont));
		table.addCell(String.valueOf(patient.getContact().getPhoneNumber()));
		table.addCell(new Phrase("Věk:", normalFont));
		table.addCell(String.valueOf(patient.getBirthday()));
		table.addCell(new Phrase("Pohaví:", normalFont));
		table.addCell(String.valueOf(patient.getGender()));
		table.addCell(new Phrase("Email:", normalFont));
		table.addCell(String.valueOf(patient.getContact().getEmail()));
		table.addCell(new Phrase("Věk při začátku epilepsie:", normalFont));
		table.addCell(" ");
		table.addCell(new Phrase("Ošetřující lékař:", normalFont));
		table.addCell(" ");

		subCatPart.add(table);

	}

	private static void printOutAnamnesis(Section subCatPart,
			AnamnesisEntity anamnesis) throws BadElementException {
		PdfPTable table = new PdfPTable(2);

		// t.setBorderColor(BaseColor.GRAY);
		// t.setPadding(4);
		// t.setSpacing(4);
		// t.setBorderWidth(1);
		table.addCell(new Phrase("Anamnesis from date:", largerFont));
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date dateOfAnamnesis = anamnesis.getDate();
		String dateOfAnamnesisString = df.format(dateOfAnamnesis);
		table.addCell(new Phrase(dateOfAnamnesisString));
		table.addCell(new Phrase("Epilepsie v rodině:", normalFont));
		table.addCell(String.valueOf(anamnesis.getEpilepsyInFamily()));
		table.addCell(new Phrase("Prenatální rizika:", normalFont));
		table.addCell(String.valueOf(anamnesis.getPrenatalRisk()));
		table.addCell(new Phrase("Fibrilní křeče:", normalFont));
		table.addCell(String.valueOf(anamnesis.getFibrilConvulsions()));
		table.addCell(new Phrase("Zánět CNS:", normalFont));
		table.addCell(String.valueOf(anamnesis.getInflammationCns()));
		table.addCell(new Phrase("Úraz CNS:", normalFont));
		table.addCell(String.valueOf(anamnesis.getInjuryCns()));
		table.addCell(new Phrase("Operace CNS:", normalFont));
		table.addCell(String.valueOf(anamnesis.getOperationCns()));
		table.addCell(new Phrase("Časná PMD retardace:", normalFont));
		table.addCell(String.valueOf(anamnesis.getEarlyPmdRetardation()));
		table.addCell(new Phrase("Začátek epilepsie:", normalFont));
		table.addCell(String.valueOf(anamnesis.getBeginningEpilepsy()));
		table.addCell(new Phrase("První záchvat s horečkou:", normalFont));
		table.addCell(String.valueOf(anamnesis.getFirstFever()));
		table.addCell(new Phrase("Infantilní spasmy:", normalFont));
		table.addCell(String.valueOf(anamnesis.getInfantileSpasm()));
		table.addCell(new Phrase("Epileptický syndrom:", normalFont));
		table.addCell(String.valueOf(anamnesis.getSpecificSyndromeIdcom()));
		table.addCell(new Phrase("Non CNS komorbidita:", normalFont));
		table.addCell(String.valueOf(anamnesis.getNonCnsComorbidity()));

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

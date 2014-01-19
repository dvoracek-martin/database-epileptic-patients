package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import cz.cvut.fit.genepi.businessLayer.service.ExportToPdfService;
import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.*;
import cz.cvut.fit.genepi.util.LoggingService;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

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
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.cvut.fit.genepi.service.ExportToPdfService#export(int)
	 */

	private String translateValue(String value, Locale locale) {
		if (value.equals("true"))
			return messageSource.getMessage("label.yes", null, locale);
		else if (value.equals("false"))
			return messageSource.getMessage("label.no", null, locale);
		else if (value.equals("null")||value.equals(null)){
			return messageSource.getMessage("label.null",null,locale);
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

	private void initFonts() {
		BaseFont bf = null;
		String os = System.getProperty("os.name").toLowerCase();

		try {
			if (os.indexOf("win") < 0) {
				bf = BaseFont.createFont(
						"/usr/share/fonts/truetype/msttcorefonts/Arial.ttf",
						BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			} else
				bf = BaseFont.createFont("C:\\Windows\\Fonts\\Arial.ttf",
						BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
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
			downloadFolder = downloadFolder.replace("\\", "/");
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
						"Couldn't create new file when trying to save pdf file.",
						e);
			}
		}

		try {
			PdfWriter.getInstance(document, new FileOutputStream(downloadFolder
					+ name));
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
				+ patient.getContact().getLastName() + " :"
				+ patient.getId() + ", " + getDate(), catFont));

		addEmptyLine(preface, 1);
		// Will create: Report generated by: _name, _date
		preface.add(new Paragraph("Report generated by: "
				+ System.getProperty("user.name") + ", " + new Date(),
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
				subCatPart.add(new Paragraph("\n"));
			}
		}
		if (exportParams.isSeizure()) {
			Paragraph anamnesisParahraph = new Paragraph(
					messageSource.getMessage("label.seizures", null, locale)
							+ "\n\n", catFont);
			anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
			subCatPart.add(anamnesisParahraph);
			for (AnamnesisEntity a : patient.getAnamnesisList()) {
				printOutAnamnesis(subCatPart, a, locale, exportParams);
			}
		}
		if (exportParams.isPharmacotherapy()) {
			Paragraph anamnesisParahraph = new Paragraph(
					messageSource.getMessage("label.pharmacotherapy", null,
							locale) + "\n\n", catFont);
			anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
			subCatPart.add(anamnesisParahraph);
			for (AnamnesisEntity a : patient.getAnamnesisList()) {
				printOutAnamnesis(subCatPart, a, locale, exportParams);
			}
		}
		if (exportParams.isNeurologicalFinding()) {
			Paragraph anamnesisParahraph = new Paragraph(
					messageSource.getMessage("label.neurologicalFinding", null,
							locale) + "\n\n", catFont);
			anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
			subCatPart.add(anamnesisParahraph);
			for (AnamnesisEntity a : patient.getAnamnesisList()) {
				printOutAnamnesis(subCatPart, a, locale, exportParams);
			}
		}
		if (exportParams.isNeuropsychology()) {
			Paragraph anamnesisParahraph = new Paragraph(
					messageSource.getMessage("label.neuropsychology", null,
							locale) + "\n\n", catFont);
			anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
			subCatPart.add(anamnesisParahraph);
			for (AnamnesisEntity a : patient.getAnamnesisList()) {
				printOutAnamnesis(subCatPart, a, locale, exportParams);
			}
		}
		if (exportParams.isDiagnosticTestEEG()) {
			Paragraph anamnesisParahraph = new Paragraph(
					messageSource.getMessage("label.diagnosticTestEEG", null,
							locale) + "\n\n", catFont);
			anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
			subCatPart.add(anamnesisParahraph);
			for (AnamnesisEntity a : patient.getAnamnesisList()) {
				printOutAnamnesis(subCatPart, a, locale, exportParams);
			}
		}
		if (exportParams.isDiagnosticTestMRI()) {
			Paragraph anamnesisParahraph = new Paragraph(
					messageSource.getMessage("label.diagnosticTestMRI", null,
							locale) + "\n\n", catFont);
			anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
			subCatPart.add(anamnesisParahraph);
			for (AnamnesisEntity a : patient.getAnamnesisList()) {
				printOutAnamnesis(subCatPart, a, locale, exportParams);
			}
		}
		if (exportParams.isNeurologicalFinding()) {
			Paragraph anamnesisParahraph = new Paragraph(
					messageSource.getMessage("label.neurologicalFinding", null,
							locale) + "\n\n", catFont);
			anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
			subCatPart.add(anamnesisParahraph);
			for (AnamnesisEntity a : patient.getAnamnesisList()) {
				printOutAnamnesis(subCatPart, a, locale, exportParams);
			}
		}
		if (exportParams.isNeurologicalFinding()) {
			Paragraph anamnesisParahraph = new Paragraph(
					messageSource.getMessage("label.neurologicalFinding", null,
							locale) + "\n\n", catFont);
			anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
			subCatPart.add(anamnesisParahraph);
			for (AnamnesisEntity a : patient.getAnamnesisList()) {
				printOutAnamnesis(subCatPart, a, locale, exportParams);
			}
		}
		if (exportParams.isNeurologicalFinding()) {
			Paragraph anamnesisParahraph = new Paragraph(
					messageSource.getMessage("label.neurologicalFinding", null,
							locale) + "\n\n", catFont);
			anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
			subCatPart.add(anamnesisParahraph);
			for (AnamnesisEntity a : patient.getAnamnesisList()) {
				printOutAnamnesis(subCatPart, a, locale, exportParams);
			}
		}
		if (exportParams.isNeurologicalFinding()) {
			Paragraph anamnesisParahraph = new Paragraph(
					messageSource.getMessage("label.neurologicalFinding", null,
							locale) + "\n\n", catFont);
			anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
			subCatPart.add(anamnesisParahraph);
			for (AnamnesisEntity a : patient.getAnamnesisList()) {
				printOutAnamnesis(subCatPart, a, locale, exportParams);
			}
		}
		if (exportParams.isNeurologicalFinding()) {
			Paragraph anamnesisParahraph = new Paragraph(
					messageSource.getMessage("label.neurologicalFinding", null,
							locale) + "\n\n", catFont);
			anamnesisParahraph.setAlignment(Element.ALIGN_CENTER);
			subCatPart.add(anamnesisParahraph);
			for (AnamnesisEntity a : patient.getAnamnesisList()) {
				printOutAnamnesis(subCatPart, a, locale, exportParams);
			}
		}
		if (exportParams.isNeurologicalFinding()) {
			Paragraph anamnesisParahraph = new Paragraph(
					messageSource.getMessage("label.neurologicalFinding", null,
							locale) + "\n\n", catFont);
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
			table.addCell(TimeConverter.getAge(patient.getAnamnesisList()
					.get(0).getBeginningEpilepsy()));
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
			table.addCell(translateValue(
					String.valueOf(anamnesis.isEpilepsyInFamily()), locale));
		}
		if (exportParams.isAnamnesisParentalRisk()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.prenatalRisk", null, locale), normalFont));
			table.addCell(translateValue(
					String.valueOf(anamnesis.isPrenatalRisk()), locale));
		}
		if (exportParams.isAnamnesisFibrilConvulsions()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.fibrilConvulsions", null, locale), normalFont));
			table.addCell(translateValue(
					String.valueOf(anamnesis.isFibrilConvulsions()), locale));
		}
		if (exportParams.isAnamnesisInflammationCns()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.inflammationCNS", null, locale), normalFont));
			table.addCell(translateValue(
					String.valueOf(anamnesis.isInflammationCns()), locale));
		}
		if (exportParams.isAnamnesisInjuryCns()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.injuryCNS", null, locale), normalFont));
			table.addCell(translateValue(
					String.valueOf(anamnesis.isInjuryCns()), locale));
		}
		if (exportParams.isAnamnesisOperationCns()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.operationCNS", null, locale), normalFont));
			table.addCell(translateValue(
					String.valueOf(anamnesis.isOperationCns()), locale));
		}
		if (exportParams.isAnamnesisEarlyPmdRetardation()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.earlyPMDRetardation", null, locale), normalFont));
			table.addCell(translateValue(
					String.valueOf(anamnesis.isEarlyPmdRetardation()), locale));
		}
		if (exportParams.isAnamnesisBeginningEpilepsy()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.beginningEpilepsy", null, locale), normalFont));
			table.addCell(translateValue(
					TimeConverter.getDate(anamnesis.getBeginningEpilepsy()),
					locale));
		}

		if (exportParams.isAnamnesisFirstFever()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.firstFever", null, locale), normalFont));
			table.addCell(translateValue(
					String.valueOf(anamnesis.isFirstFever()), locale));
		}
		if (exportParams.isAnamnesisInfantileSpasm()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.infantileSpasm", null, locale), normalFont));
			table.addCell(translateValue(
					String.valueOf(anamnesis.isInfantileSpasm()), locale));
		}
		if (exportParams.isAnamnesisSpecificSyndrome()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.epilepticSyndrome", null, locale), normalFont));
			table.addCell(translateValue(
					String.valueOf(anamnesis.getSpecificSyndrome()),
					locale));
		}
		if (exportParams.isAnamnesisNonCnsComorbidity()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.nonCNSComorbidity", null, locale), normalFont));
			table.addCell(translateValue(
					String.valueOf(anamnesis.getNonCnsComorbidity()), locale));
		}
		if (exportParams.isAnamnesisComment()) {
			table.addCell(new Phrase(messageSource.getMessage(
					"label.comment", null, locale), normalFont));
			table.addCell(translateValue(
					String.valueOf(anamnesis.getComment()), locale));
		}
		subCatPart.add(table);

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
        if (exportParams.setOperationColostomy()) {

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

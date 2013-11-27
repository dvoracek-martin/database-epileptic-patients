package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;

import cz.cvut.fit.genepi.businessLayer.service.ExportToXlsxService;
import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import cz.cvut.fit.genepi.util.LoggingService;

// TODO: Auto-generated Javadoc
/**
 * The Class ExportToXlsxServiceImpl.
 */

@Service
public class ExportToXlsxServiceImpl implements ExportToXlsxService {

	private LoggingService logger = new LoggingService();

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
	public String  export(java.util.List<PatientEntity> patientList,
			UserEntity user, Locale locale, ExportParamsEntity exportParams) {

		logger.setLogger(ExportToXlsxServiceImpl.class);
		return writeData(patientList);
	}

	private String writeData(List<PatientEntity> patientList) {
		String date = getDate();
		String name = date + ".xlsx";

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
						"Couldn't create new file when trying to save xlsx file.",
						e);
			}
		}

		// Blank workbook
		Workbook wb = new XSSFWorkbook();

		for (PatientEntity patient : patientList) {
			CreationHelper createHelper = wb.getCreationHelper();
			Sheet sheet = wb.createSheet(patient.getContact().getLastName()
					+ " " + patient.getContact().getFirstName() + " "
					+ patient.getNin());
			for (int i = 0; i != 10; i++)
				wb.createSheet("Test" + i);

			// Create a row and put some cells in it. Rows are 0 based.
			Row row = sheet.createRow((short) 0);
			// Create a cell and put a value in it.
			Cell cell = row.createCell(0);
			cell.setCellValue(1);

			// Or do it on one line.
			row.createCell(1).setCellValue(1.2);
			row.createCell(2).setCellValue(
					createHelper.createRichTextString("This is a string"));
			row.createCell(3).setCellValue(true);
		}
		// Write the output to a file
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(downloadFolder + date + ".xlsx");
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
}
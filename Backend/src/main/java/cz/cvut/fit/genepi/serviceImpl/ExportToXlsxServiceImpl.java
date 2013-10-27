package cz.cvut.fit.genepi.serviceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.itextpdf.text.DocumentException;

import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.service.ExportToXlsxService;
import cz.cvut.fit.genepi.service.LoggingService;

// TODO: Auto-generated Javadoc
/**
 * The Class ExportToXlsxServiceImpl.
 */

@Service
public class ExportToXlsxServiceImpl implements ExportToXlsxService {

	private static PatientEntity patient;

	private static UserEntity user;

	private LoggingService logger = new LoggingService();

	private static String getDate() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
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
	public void export(PatientEntity patient, UserEntity user,
			List<String> exports) {

		ExportToXlsxServiceImpl.patient = patient;
		ExportToXlsxServiceImpl.user = user;

		logger.setLogger(ExportToXlsxServiceImpl.class);
		writeData();
	}

	private void writeData() {
		String downloadFolder = System.getProperty("user.home")
				+ System.getProperty("file.separator") + "Download_Links"
				+ System.getProperty("file.separator");

		String os = System.getProperty("os.name").toLowerCase();
		if (os.indexOf("win") >= 0) {
			downloadFolder.replace("\\", "/");
		} else {
			downloadFolder = "/usr/local/tomcat/webapps/GENEPI/resources/downloads/";
			File f = new File(downloadFolder + "patient" + patient.getId()
					+ ".xlsx");
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
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet = wb.createSheet(patient.getContact().getLastName() + " "
				+ patient.getContact().getFirstName() + " " + patient.getNin());
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

		// Write the output to a file
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream(downloadFolder + "patient"
					+ patient.getId() + ".xlsx");
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
	}
}

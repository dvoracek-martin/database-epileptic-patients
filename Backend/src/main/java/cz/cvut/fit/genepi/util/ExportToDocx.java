package cz.cvut.fit.genepi.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Service;

import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.service.ExportToDocxService;
import cz.cvut.fit.genepi.service.LoggingService;

@Service
public class ExportToDocx implements ExportToDocxService {

	private static PatientEntity patient;

	private static UserEntity user;

	private LoggingService logger = new LoggingService();

	private static String getDate() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		return reportDate;
	}

	public void export(PatientEntity patient, UserEntity user,
			List<String> exports) {
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

		logger.setLogger(ExportToDocxService.class);

		XWPFDocument document = new XWPFDocument();
		XWPFParagraph tmpParagraph = document.createParagraph();
		XWPFRun tmpRun = tmpParagraph.createRun();
		tmpRun.setText("LALALALAALALAAAA");
		tmpRun.setFontSize(18);
		try {
			document.write(new FileOutputStream(new File(downloadFolder
					+ "patient" + patient.getId() + ".docx")));
		} catch (FileNotFoundException e) {
			logger.logError("File wasn't found when trying to save docx file.",
					e);
		} catch (IOException e) {
			logger.logError("IO exception when trying to save docx file.", e);
		}
	}
}

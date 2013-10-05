package cz.cvut.fit.genepi.serviceImpl;

import java.io.FileOutputStream;
import java.io.IOException;
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

// TODO: Auto-generated Javadoc
/**
 * The Class ExportToXlsxServiceImpl.
 */

@Service
public class ExportToXlsxServiceImpl implements ExportToXlsxService {
	
	/**
	 * Export.
	 *
	 * @param pateintID the pateint id
	 * @throws DocumentException the document exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void export(PatientEntity patient, UserEntity user, List<String> exports) throws DocumentException, IOException {
		// Blank workbook
		Workbook wb = new XSSFWorkbook();
		CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet = wb.createSheet("new sheet");

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
		FileOutputStream fileOut = new FileOutputStream("c:/temp/patient"
				+ Integer.toString(patient.getId()) + ".xlsx");
		wb.write(fileOut);
		fileOut.close();
	}
}

package cz.cvut.fit.genepi.serviceImpl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.itextpdf.text.DocumentException;

import cz.cvut.fit.genepi.service.ExportService;

public class ExportServiceImpl implements ExportService {
	public ExportServiceImpl(String format,int pateintID) {
		if (format.equals("pdf")) {
			try {
				new ExportToPdfServiceImpl().export(pateintID);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (format.equals("xlsx")) {
			try {
				new ExportToXlsxServiceImpl().export(pateintID);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

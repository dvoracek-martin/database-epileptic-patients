package cz.cvut.fit.genepi.serviceImpl;

import java.io.FileNotFoundException;

import com.itextpdf.text.DocumentException;

import cz.cvut.fit.genepi.service.ExportService;

public class ExportServiceImpl implements ExportService {
	public ExportServiceImpl(String format) {
		if (format.equals("pdf")) {
			try {
				new ExportToPdfServiceImpl().export();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

		}
	};
}

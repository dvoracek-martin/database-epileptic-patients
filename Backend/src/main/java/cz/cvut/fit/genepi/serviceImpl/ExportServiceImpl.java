package cz.cvut.fit.genepi.serviceImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.DocumentException;

import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.UserEntity;
import cz.cvut.fit.genepi.service.ExportService;

// TODO: Auto-generated Javadoc
/**
 * The Class ExportServiceImpl.
 */
public class ExportServiceImpl implements ExportService {
	
	/**
	 * Instantiates a new export service impl.
	 *
	 * @param format the format
	 * @param pateintID the pateint id
	 */
	public ExportServiceImpl(String format,PatientEntity patient,UserEntity user) {
		if (format.equals("pdf")) {
			new ExportToPdfServiceImpl().export(patient,user,new ArrayList<String>());
		} else if (format.equals("xlsx")) {
			try {
				new ExportToXlsxServiceImpl().export(patient,user);
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

package cz.cvut.fit.genepi.service;

import java.io.FileNotFoundException;

import com.itextpdf.text.DocumentException;

import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.UserEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface ExportToPdfService.
 */
public interface  ExportToPdfService {
	
	/**
	 * Export.
	 *
	 * @param pateintID the pateint id
	 * @throws FileNotFoundException the file not found exception
	 * @throws DocumentException the document exception
	 */
	public void export(PatientEntity patient, UserEntity user) throws FileNotFoundException, DocumentException;
}

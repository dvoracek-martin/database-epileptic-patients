package cz.cvut.fit.genepi.service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;

import com.itextpdf.text.DocumentException;

import cz.cvut.fit.genepi.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.UserEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface ExportToPdfService.
 */
public interface ExportToPdfService {

	/**
	 * Export.
	 * 
	 * @param pateintID
	 *            the pateint id
	 * @throws FileNotFoundException
	 *             the file not found exception
	 * @throws DocumentException
	 *             the document exception
	 */
	public String export(List<PatientEntity> patientList, UserEntity user,
			Locale locale, ExportParamsEntity exportParams)
			throws FileNotFoundException, DocumentException;
}

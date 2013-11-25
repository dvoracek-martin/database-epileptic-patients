package cz.cvut.fit.genepi.businessLayer.service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;

import com.itextpdf.text.DocumentException;

import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;

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

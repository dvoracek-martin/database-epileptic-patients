package cz.cvut.fit.genepi.businessLayer.service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;

import com.itextpdf.text.DocumentException;

import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;

/**
 * The Interface ExportToPdfService extends GenericService
 */
public interface ExportToPdfService {

	/**
	 * Export required data to pdf
	 * 
	 * @param patientList as List of PatientEntity
	 * @param user as UserEntity
	 * @param locale as Locale
	 * @param exportParams as ExportParamsEntity
	 * @throws FileNotFoundException the file not found exception
	 * @throws DocumentException the document exception
	 */
	public String export(List<PatientEntity> patientList, UserEntity user,
			Locale locale, ExportParamsEntity exportParams)
			throws FileNotFoundException, DocumentException;
}

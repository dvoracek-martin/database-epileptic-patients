package cz.cvut.fit.genepi.businessLayer.service;

import java.util.List;
import java.util.Locale;

import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;

/**
 * The Interface ExportToTxtService extends GenericService
 */
public interface ExportToTxtService {

	/**
	 * Export required data to txt
	 * 
	 * @param patientList as List of PatientEntity
	 * @param user as UserEntity
	 * @param locale as Locale
	 * @param exportParams as ExportParamsEntity
	 */
	public String export(List<PatientEntity> patientList, UserEntity user,
			Locale locale, ExportParamsEntity exportParams);
}
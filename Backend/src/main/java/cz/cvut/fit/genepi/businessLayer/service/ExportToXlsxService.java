package cz.cvut.fit.genepi.businessLayer.service;

import java.util.List;
import java.util.Locale;

import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;

/**
 * The Interface ExportToXlsxService.
 */
public interface ExportToXlsxService {

	public String export(List<PatientEntity> patientList, UserEntity user,
			Locale locale, ExportParamsEntity exportParams, boolean anonymize);
}

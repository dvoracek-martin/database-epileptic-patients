package cz.cvut.fit.genepi.service;

import java.util.List;
import java.util.Locale;

import cz.cvut.fit.genepi.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.UserEntity;

/**
 * The Interface ExportToXlsxService.
 */
public interface ExportToXlsxService {
	public String export(List<PatientEntity> patientList, UserEntity user,
			List<String> exports, Locale locale, ExportParamsEntity exportParams);
}

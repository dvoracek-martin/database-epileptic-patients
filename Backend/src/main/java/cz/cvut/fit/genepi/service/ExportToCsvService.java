package cz.cvut.fit.genepi.service;

import java.util.List;
import java.util.Locale;

import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.UserEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface ContactService.
 */
public interface ExportToCsvService {
	
	public String export(List<PatientEntity> patientList, UserEntity user, Locale locale,
			List<String> exports,List<String> listOfPossibleCards );
}

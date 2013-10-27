package cz.cvut.fit.genepi.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.itextpdf.text.DocumentException;

import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.UserEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface ContactService.
 */
public interface ExportToTxtService {
	
	public void export(PatientEntity patient, UserEntity user,
			List<String> exports,List<String> listOfPossibleCards ) throws FileNotFoundException,
			DocumentException;
}

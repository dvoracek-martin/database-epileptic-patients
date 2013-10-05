package cz.cvut.fit.genepi.service;

import java.io.IOException;
import java.util.List;

import com.itextpdf.text.DocumentException;

import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.entity.UserEntity;

/**
 * The Interface ExportToXlsxService.
 */
public interface  ExportToXlsxService {
	public void export(PatientEntity patient, UserEntity user, List<String> exports) throws DocumentException, IOException ;
}

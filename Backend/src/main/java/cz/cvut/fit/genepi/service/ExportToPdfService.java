package cz.cvut.fit.genepi.service;

import java.io.FileNotFoundException;

import com.itextpdf.text.DocumentException;

public interface  ExportToPdfService {
	public void export() throws FileNotFoundException, DocumentException;
}

package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.businessLayer.BO.form.ExportParamsFormBO;

import java.util.List;
import java.util.Locale;

public interface ExportService {

    public String performExport(ExportParamsFormBO exportParams, Locale locale,
                                String exportType, boolean anonymize, List<Integer> patientIds, boolean toTable);

}

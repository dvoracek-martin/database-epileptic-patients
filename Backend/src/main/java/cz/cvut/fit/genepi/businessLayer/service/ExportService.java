package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.businessLayer.VO.form.ExportParamsVO;

import java.util.Locale;

public interface ExportService {

    public String performExport(ExportParamsVO exportParams, Locale locale, String exportType, boolean anonymize,int[] patientIds,boolean toTable);
}

package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;

import java.util.List;
import java.util.Locale;

/**
 * The Interface ExportToXlsxService.
 */
public interface ExportToXlsxService {

    public String export(List<PatientEntity> patientList, UserEntity user,
                         Locale locale, ExportParamsEntity exportParams, boolean anonymize);
}

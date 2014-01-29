package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Locale;

/**
 * The Interface ExportToPdfService extends GenericService
 */
public interface ExportToPdfService {

    /**
     * Export required data to pdf
     *
     * @param patientList  as List of PatientEntity
     * @param user         as UserEntity
     * @param locale       as Locale
     * @param exportParams as ExportParamsEntity
     * @throws FileNotFoundException the file not found
     */
    public String export(List<PatientEntity> patientList, UserEntity user,
                         Locale locale, ExportParamsEntity exportParams, boolean anonymize)
            throws FileNotFoundException;
}

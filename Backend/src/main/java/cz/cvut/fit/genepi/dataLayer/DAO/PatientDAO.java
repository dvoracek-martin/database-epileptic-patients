package cz.cvut.fit.genepi.dataLayer.DAO;

import cz.cvut.fit.genepi.dataLayer.entity.AdvancedSearchEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

import java.util.List;

/**
 * PatientDAO interface
 */
public interface PatientDAO extends GenericDAO<PatientEntity> {

    /**
     * Finds Pateint and all his lists for chosen patient
     *
     * @param patientId the ID of the pateint
     * @return Pateint as the PateintEntity
     */
    public PatientEntity getPatientByIdWithAllLists(int patientId);

    /**
     * Does the searching
     *
     * @param advancedSearch as AdvancedSearchEntity
     * @return List of PatientEntity
     */
    public List<PatientEntity> performSearch(AdvancedSearchEntity advancedSearch);

    /**
     * Finds Patient with his doctor
     *
     * @param patientId the ID of the pateint
     * @return Pateint as the PateintEntity
     */
    public PatientEntity getPatientByIdWithDoctor(int patientId);

    public List<PatientEntity> findAllHidden();

    public List<PatientEntity> findAllWithHiddenRecords();

    public int getCountOfUnhidden(boolean onlyResearcher, String searchString);

    public List<PatientEntity> getBySearchStringWithPagination(int maxResults, int pageNumber, boolean onlyResearcher, String searchString);
}

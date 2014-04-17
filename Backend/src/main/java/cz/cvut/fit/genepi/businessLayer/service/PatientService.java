package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.PatientVO;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

import java.util.Date;
import java.util.List;

/**
 * The Interface PatientService extends GenericService
 */
public interface PatientService extends GenericService<PatientVO, PatientEntity> {

    /**
     * Finds patient and all his cards according to his ID
     *
     * @param patientId as int
     * @return PateintEntity
     */
    public PatientEntity getPatientByIdWithAllLists(int patientId);

    public List<PatientEntity> findAllHidden();

    public PatientDisplayVO getPatientDisplayByIdWithDoctor(int patientId);

    public void verifyPatient(int patientId);

    public void voidVerifyPatient(int patientId);

    public void hide(int patientId);

    public void unhide(int patientId);

    public List<PatientDisplayVO> findAllWithHiddenRecords();

    public int getCountOfUnhidden(boolean onlyResearcher, String searchString);

    public List<PatientDisplayVO> getBySearchStringWithPagination(int maxResults, int pageNumber, boolean onlyResearcher, String searchString);

    public boolean verifyBeginningEpilepsy(int patientId, Date beginningEpilepsy);

    public PatientEntity getPatientDisplayByIdWithAllLists(int patientId);
}

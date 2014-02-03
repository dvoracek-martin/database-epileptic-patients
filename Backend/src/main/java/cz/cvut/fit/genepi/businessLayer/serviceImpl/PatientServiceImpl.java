package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// TODO: Auto-generated Javadoc

/**
 * The Class PatientServiceImpl.
 */
@Service
public class PatientServiceImpl
        extends GenericServiceImpl<PatientEntity>
        implements PatientService {

    /**
     * The patient dao.
     */
    @Autowired
    private PatientDAO patientDAO;

    @Autowired
    private Mapper dozer;

    @Override
    @Transactional
    public PatientEntity getPatientByIdWithAllLists(int patientId) {
        return patientDAO.getPatientByIdWithAllLists(patientId);
    }

    @Override
    @Transactional
    public PatientEntity getPatientByIdWithAnamnesisList(int patientId) {
        return patientDAO.getPatientByIdWithAnamnesisList(patientId);
    }

    @Override
    @Transactional
    public PatientEntity getPatientByIdWithComplicationList(int patientId) {
        return patientDAO.getPatientByIdWithComplicationList(patientId);

    }

    @Override
    @Transactional
    public PatientEntity getPatientByIdWithDiagnosticTestScalpEEGList(int patientId) {
        return patientDAO.getPatientByIdWithDiagnosticTestScalpEegList(patientId);

    }

    @Override
    @Transactional
    public PatientEntity getPatientByIdWithDiagnosticTestMRIList(int patientId) {
        return patientDAO.getPatientByIdWithDiagnosticTestMriList(patientId);

    }

    @Override
    @Transactional
    public PatientEntity getPatientByIdWithHistologyList(int patientId) {
        return patientDAO.getPatientByIdWithHistologyList(patientId);

    }

    @Override
    @Transactional
    public PatientEntity getPatientByIdWithInvasiveTestCorticalMappingList(
            int patientId) {
        return patientDAO
                .getPatientByIdWithInvasiveTestCorticalMappingList(patientId);

    }

    @Override
    @Transactional
    public PatientEntity getPatientByIdWithInvasiveTestECOGList(int patientId) {
        return patientDAO.getPatientByIdWithInvasiveTestEcogList(patientId);

    }

    @Override
    @Transactional
    public PatientEntity getPatientByIdWithInvasiveTestEEGList(int patientId) {
        return patientDAO.getPatientByIdWithInvasiveTestEegList(patientId);

    }

    @Override
    @Transactional
    public PatientEntity getPatientByIdWithNeurologicalFindingList(int patientId) {
        return patientDAO.getPatientByIdWithNeurologicalFindingList(patientId);
    }

    @Override
    @Transactional
    public PatientEntity getPatientByIdWithNeuropsychologyList(int patientId) {
        return patientDAO.getPatientByIdWithNeuropsychologyList(patientId);

    }

    @Override
    @Transactional
    public PatientEntity getPatientByIdWithNeuropsychologyOldList(int patientId) {
        return patientDAO.getPatientByIdWithNeuropsychologyOldList(patientId);

    }

    @Override
    @Transactional
    public PatientEntity getPatientByIdWithOperationList(int patientId) {
        return patientDAO.getPatientByIdWithOperationList(patientId);

    }

    @Override
    @Transactional
    public PatientEntity getPatientByIdWithOutcomeList(int patientId) {
        return patientDAO.getPatientByIdWithOutcomeList(patientId);

    }

    @Override
    @Transactional
    public PatientEntity getPatientByIdWithPharmacotherapyList(int patientId) {
        return patientDAO.getPatientByIdWithPharmacotherapyList(patientId);

    }

    @Override
    @Transactional
    public PatientEntity getPatientByIdWithSeizureList(int patientId) {
        return patientDAO.getPatientByIdWithSeizureList(patientId);

    }

    @Override
    @Transactional
    public PatientEntity getPatientByIdWithDoctor(int patientId) {
        return patientDAO.getPatientByIdWithDoctor(patientId);
    }

    @Override
    @Transactional
    public List<PatientEntity> findAllHidden() {
        return patientDAO.findAllHidden();
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithAnamnesisList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithAnamnesisList(patientId);
        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithComplicationList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithComplicationList(patientId);
        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithDiagnosticTestMriList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithDiagnosticTestMriList(patientId);
        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithDiagnosticTestScalpEegList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithDiagnosticTestScalpEegList(patientId);
        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithHistologyList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithHistologyList(patientId);
        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithInvasiveTestCorticalMappingList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithInvasiveTestCorticalMappingList(patientId);
        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithInvasiveTestEcogList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithInvasiveTestEcogList(patientId);
        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithInvasiveTestEegList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithInvasiveTestEegList(patientId);
        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithNeuropsychologyList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithNeuropsychologyList(patientId);
        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithNeuropsychologyOldList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithNeuropsychologyOldList(patientId);
        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithNeurologicalFindingList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithNeurologicalFindingList(patientId);
        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithOperationList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithOperationList(patientId);
        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithSeizureList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithSeizureList(patientId);
        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithPharmacotherapyList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithPharmacotherapyList(patientId);
        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithAllLists(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithAllLists(patientId);
        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithDoctor(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithDoctor(patientId);
        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }
}

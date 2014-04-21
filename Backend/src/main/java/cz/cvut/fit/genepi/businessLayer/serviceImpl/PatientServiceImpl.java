package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.PatientVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO;
import cz.cvut.fit.genepi.dataLayer.DAO.card.GenericCardDAO;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.*;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.dozer.Mapper;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The Class PatientServiceImpl.
 */
@Service
public class PatientServiceImpl
        extends GenericServiceImpl<PatientVO, PatientEntity>
        implements PatientService {

    /**
     * The patient dao.
     */
    @Autowired
    private PatientDAO patientDAO;

    @Autowired
    private Mapper dozer;

    @Autowired
    private GenericCardDAO<SeizureEntity> genericCardSeizureDAO;

    @Override
    @Transactional
    public PatientEntity getPatientByIdWithAllLists(int patientId) {
        return patientDAO.getPatientByIdWithAllLists(patientId);
    }

    @Override
    @Transactional
    public List<PatientEntity> findAllHidden() {
        return patientDAO.findAllHidden();
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithDoctor(int patientId) {
        PatientEntity patientEntity = patientDAO.getPatientByIdWithDoctor(patientId);
        PatientDisplayVO patientDisplayVO = dozer.map(patientEntity, PatientDisplayVO.class);
        String ageAtTheBeginningOfEpilepsy = TimeConverter.getAgeAtTheBeginningOfEpilepsy(patientEntity);
        patientDisplayVO.setAgeAtTheBeginningOfEpilepsy(ageAtTheBeginningOfEpilepsy);
        return patientDisplayVO;
    }

    @Override
    @Transactional
    public void verifyPatient(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithDoctor(patientId);
        patient.setVerified(true);
        patientDAO.save(patient);
    }

    @Override
    @Transactional
    public void voidVerifyPatient(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithDoctor(patientId);
        patient.setVerified(false);
        patientDAO.save(patient);
    }

    @Override
    @Transactional
    public void hide(int patientId) {
        PatientEntity patient = genericDAO.getById(patientId, PatientEntity.class);
        patient.setStatus(1);
        genericDAO.save(patient);
    }

    @Override
    @Transactional
    public void unhide(int patientId) {
        PatientEntity patient = genericDAO.getById(patientId, PatientEntity.class);
        patient.setStatus(0);
        genericDAO.save(patient);
    }

    @Override
    @Transactional
    public List<PatientDisplayVO> findAllWithHiddenRecords() {
        List<PatientEntity> patientsWithHiddenRecordsList = patientDAO.findAllWithHiddenRecords();
        List<PatientDisplayVO> patientVOsWithHiddenRecordsList = new ArrayList<>();

        for (PatientEntity patient : patientsWithHiddenRecordsList) {
            patientVOsWithHiddenRecordsList.add(dozer.map(patient, PatientDisplayVO.class));
        }

        return patientVOsWithHiddenRecordsList;
    }

    @Override
    @Transactional
    public int getCountOfUnhidden(boolean onlyResearcher, String searchString) {
        return patientDAO.getCountOfUnhidden(onlyResearcher, searchString);
    }

    @Override
    @Transactional
    public List<PatientDisplayVO> getBySearchStringWithPagination(int maxResults, int pageNumber, boolean onlyResearcher, String searchString) {
        List<PatientEntity> patientList = patientDAO.getBySearchStringWithPagination(maxResults, pageNumber, onlyResearcher, searchString);
        List<PatientDisplayVO> paientDisplaVoList = new ArrayList<>();
        for (PatientEntity patient : patientList) {
            PatientDisplayVO patientDisplayVO = dozer.map(patient, PatientDisplayVO.class);
            paientDisplaVoList.add(patientDisplayVO);
        }
        return paientDisplaVoList;
    }

    @Override
    @Transactional
    public boolean verifyBeginningEpilepsy(int patientId, Date beginningEpilepsy) {
        Date oldest = genericCardSeizureDAO.getOldestRecordDate(patientId, SeizureEntity.class);
        if (oldest == null) {
            return true;
        }
        DateTime beginningEpi = new DateTime(beginningEpilepsy);
        DateTime oldestSeizureDate = new DateTime(oldest);
        Days countOfTheDays = Days.daysBetween(oldestSeizureDate.withTimeAtStartOfDay(), beginningEpi.withTimeAtStartOfDay());
        return countOfTheDays.getDays() < 0; // TODO consider =<
    }

    @Override
    @Transactional
    public PatientEntity getPatientDisplayByIdWithAllLists(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithAllLists(patientId);

        //TODO we can use iterator on all of therse foreaches
        List<ComplicationEntity> recordComplicationEntityList = new ArrayList<>();
        for (ComplicationEntity item : patient.getComplicationList()) {
            if (!item.isHidden() && !item.isHistory()) {
                recordComplicationEntityList.add(item);
            }
        }
        patient.setComplicationList(recordComplicationEntityList);

        List<DiagnosticTestMriEntity> recordDiagnosticTestMriEntityList = new ArrayList<>();
        for (DiagnosticTestMriEntity item : patient.getDiagnosticTestMRIList()) {
            if (!item.isHidden() && !item.isHistory()) {
                recordDiagnosticTestMriEntityList.add(item);
            }
        }
        patient.setDiagnosticTestMRIList(recordDiagnosticTestMriEntityList);

        List<DiagnosticTestScalpEegEntity> recordDiagnosticTestScalpEegEntityList = new ArrayList<>();
        for (DiagnosticTestScalpEegEntity item : patient.getDiagnosticTestScalpEegList()) {
            if (!item.isHidden() && !item.isHistory()) {
                recordDiagnosticTestScalpEegEntityList.add(item);
            }
        }
        patient.setDiagnosticTestScalpEegList(recordDiagnosticTestScalpEegEntityList);

        List<HistologyEntity> recordHistologyEntityList = new ArrayList<>();
        for (HistologyEntity item : patient.getHistologyList()) {
            if (!item.isHidden() && !item.isHistory()) {
                recordHistologyEntityList.add(item);
            }
        }
        patient.setHistologyList(recordHistologyEntityList);

        List<InvasiveTestCorticalMappingEntity> recordInvasiveTestCorticalMappingEntityList = new ArrayList<>();
        for (InvasiveTestCorticalMappingEntity item : patient.getInvasiveTestCorticalMappingList()) {
            if (!item.isHidden() && !item.isHistory()) {
                recordInvasiveTestCorticalMappingEntityList.add(item);
            }
        }
        patient.setInvasiveTestCorticalMappingList(recordInvasiveTestCorticalMappingEntityList);

        List<InvasiveTestEcogEntity> recordInvasiveTestEcogEntityList = new ArrayList<>();
        for (InvasiveTestEcogEntity item : patient.getInvasiveTestECOGList()) {
            if (!item.isHidden() && !item.isHistory()) {
                recordInvasiveTestEcogEntityList.add(item);
            }
        }
        patient.setInvasiveTestECOGList(recordInvasiveTestEcogEntityList);

        List<InvasiveTestEegEntity> recordInvasiveTestEegEntityList = new ArrayList<>();
        for (InvasiveTestEegEntity item : patient.getInvasiveTestEEGList()) {
            if (!item.isHidden() && !item.isHistory()) {
                recordInvasiveTestEegEntityList.add(item);
            }
        }
        patient.setInvasiveTestEEGList(recordInvasiveTestEegEntityList);

        List<NeuropsychologyEntity> recordNeuropsychologyEntityList = new ArrayList<>();
        for (NeuropsychologyEntity item : patient.getNeuropsychologyList()) {
            if (!item.isHidden() && !item.isHistory()) {
                recordNeuropsychologyEntityList.add(item);
            }
        }
        patient.setNeuropsychologyList(recordNeuropsychologyEntityList);

        List<NeuropsychologyOldEntity> recordNeuropsychologyOldEntityList = new ArrayList<>();
        for (NeuropsychologyOldEntity item : patient.getNeuropsychologyOldList()) {
            if (!item.isHidden() && !item.isHistory()) {
                recordNeuropsychologyOldEntityList.add(item);
            }
        }
        patient.setNeuropsychologyOldList(recordNeuropsychologyOldEntityList);

        List<NeurologicalFindingEntity> recordNeurologicalFindingEntityList = new ArrayList<>();
        for (NeurologicalFindingEntity item : patient.getNeurologicalFindingList()) {
            if (!item.isHidden() && !item.isHistory()) {
                recordNeurologicalFindingEntityList.add(item);
            }
        }
        patient.setNeurologicalFindingList(recordNeurologicalFindingEntityList);

        List<OperationEntity> recordOperationEntityList = new ArrayList<>();
        for (OperationEntity item : patient.getOperationList()) {
            if (!item.isHidden() && !item.isHistory()) {
                recordOperationEntityList.add(item);
            }
        }
        patient.setOperationList(recordOperationEntityList);

        List<SeizureEntity> recordSeizureEntityList = new ArrayList<>();
        for (SeizureEntity item : patient.getSeizureList()) {

            //process seizure detail
            List<SeizureDetailEntity> recordSeizureDetailEntityList = new ArrayList<>();
            for (SeizureDetailEntity item2 : item.getSeizureDetailList()) {
                if (!item2.isHidden() && !item2.isHistory()) {
                    recordSeizureDetailEntityList.add(item2);
                }
            }
            item.setSeizureDetailList(recordSeizureDetailEntityList);

            if (!item.isHidden() && !item.isHistory()) {
                recordSeizureEntityList.add(item);
            }
        }
        patient.setSeizureList(recordSeizureEntityList);

        List<PharmacotherapyEntity> recordPharmacotherapyEntityList = new ArrayList<>();
        for (PharmacotherapyEntity item : patient.getPharmacotherapyList()) {
            if (!item.isHidden() && !item.isHistory()) {
                recordPharmacotherapyEntityList.add(item);
            }
        }
        patient.setPharmacotherapyList(recordPharmacotherapyEntityList);

        return patient;
    }

}

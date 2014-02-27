package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.PatientVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.*;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

        List<ComplicationEntity> recordList = new ArrayList<>();
        for (ComplicationEntity item : patient.getComplicationList()) {
            if (item.isHidden() == false && item.isHistory() == false) {
                recordList.add(item);
            }
        }
        patient.setComplicationList(recordList);

        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithDiagnosticTestMriList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithDiagnosticTestMriList(patientId);

        List<DiagnosticTestMriEntity> recordList = new ArrayList<>();
        for (DiagnosticTestMriEntity item : patient.getDiagnosticTestMRIList()) {
            if (item.isHidden() == false && item.isHistory() == false) {
                recordList.add(item);
            }
        }
        patient.setDiagnosticTestMRIList(recordList);

        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithDiagnosticTestScalpEegList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithDiagnosticTestScalpEegList(patientId);

        List<DiagnosticTestScalpEegEntity> recordList = new ArrayList<>();
        for (DiagnosticTestScalpEegEntity item : patient.getDiagnosticTestScalpEegList()) {
            if (item.isHidden() == false && item.isHistory() == false) {
                recordList.add(item);
            }
        }
        patient.setDiagnosticTestScalpEegList(recordList);

        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithHistologyList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithHistologyList(patientId);

        List<HistologyEntity> recordList = new ArrayList<>();
        for (HistologyEntity item : patient.getHistologyList()) {
            if (item.isHidden() == false && item.isHistory() == false) {
                recordList.add(item);
            }
        }
        patient.setHistologyList(recordList);

        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithInvasiveTestCorticalMappingList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithInvasiveTestCorticalMappingList(patientId);

        List<InvasiveTestCorticalMappingEntity> recordList = new ArrayList<>();
        for (InvasiveTestCorticalMappingEntity item : patient.getInvasiveTestCorticalMappingList()) {
            if (item.isHidden() == false && item.isHistory() == false) {
                recordList.add(item);
            }
        }
        patient.setInvasiveTestCorticalMappingList(recordList);

        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithInvasiveTestEcogList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithInvasiveTestEcogList(patientId);

        List<InvasiveTestEcogEntity> recordList = new ArrayList<>();
        for (InvasiveTestEcogEntity item : patient.getInvasiveTestECOGList()) {
            if (item.isHidden() == false && item.isHistory() == false) {
                recordList.add(item);
            }
        }
        patient.setInvasiveTestECOGList(recordList);

        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithInvasiveTestEegList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithInvasiveTestEegList(patientId);

        List<InvasiveTestEegEntity> recordList = new ArrayList<>();
        for (InvasiveTestEegEntity item : patient.getInvasiveTestEEGList()) {
            if (item.isHidden() == false && item.isHistory() == false) {
                recordList.add(item);
            }
        }
        patient.setInvasiveTestEEGList(recordList);

        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithNeuropsychologyList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithNeuropsychologyList(patientId);

        List<NeuropsychologyEntity> recordList = new ArrayList<>();
        for (NeuropsychologyEntity item : patient.getNeuropsychologyList()) {
            if (item.isHidden() == false && item.isHistory() == false) {
                recordList.add(item);
            }
        }
        patient.setNeuropsychologyList(recordList);

        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithNeuropsychologyOldList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithNeuropsychologyOldList(patientId);

        List<NeuropsychologyOldEntity> recordList = new ArrayList<>();
        for (NeuropsychologyOldEntity item : patient.getNeuropsychologyOldList()) {
            if (item.isHidden() == false && item.isHistory() == false) {
                recordList.add(item);
            }
        }
        patient.setNeuropsychologyOldList(recordList);

        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithNeurologicalFindingList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithNeurologicalFindingList(patientId);

        List<NeurologicalFindingEntity> recordList = new ArrayList<>();
        for (NeurologicalFindingEntity item : patient.getNeurologicalFindingList()) {
            if (item.isHidden() == false && item.isHistory() == false) {
                recordList.add(item);
            }
        }
        patient.setNeurologicalFindingList(recordList);

        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithOperationList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithOperationList(patientId);

        List<OperationEntity> recordList = new ArrayList<>();
        for (OperationEntity item : patient.getOperationList()) {
            if (item.isHidden() == false && item.isHistory() == false) {
                recordList.add(item);
            }
        }
        patient.setOperationList(recordList);

        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithOperationWithOutcomeList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithOperationWithOutcomeList(patientId);
/*
        List<OperationEntity> recordList = new ArrayList<>();
        for (OperationEntity item : patient.getOperationList()) {
            if (item.isHidden() == false && item.isHistory() == false) {
                recordList.add(item);
            }
        }
        patient.setOperationList(recordList);
        */
        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithSeizureList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithSeizureList(patientId);

        List<SeizureEntity> recordList = new ArrayList<>();
        for (SeizureEntity item : patient.getSeizureList()) {

            //process seizure detail
            List<SeizureDetailEntity> record2List = new ArrayList<>();
            for (SeizureDetailEntity item2 : item.getSeizureDetailList()) {
                if (item2.isHidden() == false && item2.isHistory() == false) {
                    record2List.add(item2);
                }
            }
            item.setSeizureDetailList(record2List);

            if (item.isHidden() == false && item.isHistory() == false) {
                recordList.add(item);
            }
        }
        patient.setSeizureList(recordList);

        PatientDisplayVO patientVO = dozer.map(patient, PatientDisplayVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public PatientDisplayVO getPatientDisplayByIdWithPharmacotherapyList(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithPharmacotherapyList(patientId);

        List<PharmacotherapyEntity> recordList = new ArrayList<>();
        for (PharmacotherapyEntity item : patient.getPharmacotherapyList()) {
            if (item.isHidden() == false && item.isHistory() == false) {
                recordList.add(item);
            }
        }
        patient.setPharmacotherapyList(recordList);

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
    public PatientVO getById(int patientId) {
        PatientEntity patient = patientDAO.getPatientByIdWithDoctor(patientId);
        PatientVO patientVO = dozer.map(patient, PatientVO.class);
        return patientVO;
    }

    @Override
    @Transactional
    public void save(PatientVO patient) {
        genericDAO.save(dozer.map(patient, PatientEntity.class));
    }

    @Override
    @Transactional
    public void hide(int patientId) {
        PatientEntity patient = genericDAO.findByID(PatientEntity.class, patientId);
        patient.setStatus(1);
        genericDAO.save(patient);
    }

    @Override
    @Transactional
    public void unhide(int patientId) {
        PatientEntity patient = genericDAO.findByID(PatientEntity.class, patientId);
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

        /*PatientDisplayVO pat = dozer.map(patientsWithHiddenRecordsList.get(0),PatientDisplayVO.class);

        dozer.map(patientsWithHiddenRecordsList, patientVOsWithHiddenRecordsList);
*/
        return patientVOsWithHiddenRecordsList;
    }
}

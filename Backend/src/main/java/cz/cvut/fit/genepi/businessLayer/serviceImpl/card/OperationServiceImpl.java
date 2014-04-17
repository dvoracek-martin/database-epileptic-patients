package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.OperationDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.card.OperationWithOutcomesDisplayVO;
import cz.cvut.fit.genepi.businessLayer.service.card.OperationService;
import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;
import cz.cvut.fit.genepi.dataLayer.DAO.card.GenericCardDAO;
import cz.cvut.fit.genepi.dataLayer.DAO.card.OperationDAO;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.OperationEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.OutcomeEntity;
import org.dozer.Mapper;
import org.joda.time.DateTime;
import org.joda.time.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationDAO operationDAO;

    @Autowired
    private Mapper dozer;

    @Autowired
    @Qualifier("genericCardDAOImpl")
    private GenericCardDAO<OperationEntity> genericCardDAO;

    @Autowired
    @Qualifier("genericDAOImpl")
    private GenericDAO<PatientEntity> genericDAO;

    @Override
    @Transactional
    public OperationDisplayVO getLatestOperationByPatientId(int patientId) {
        List<OperationEntity> operationEntityList = genericCardDAO.getRecordsByPatientId(patientId, OperationEntity.class);
        if (operationEntityList.isEmpty()) {
            return null;
        } else {
            OperationEntity operationEntity = operationEntityList.get(0);
            PatientEntity patient = genericDAO.getById(patientId, PatientEntity.class);

            DateTime patientBirthDate = new DateTime(patient.getBirthday());

            DateTime operationDate = new DateTime(operationEntity.getDateOperation());
            Years ageAtOperation = Years.yearsBetween(patientBirthDate.withTimeAtStartOfDay(), operationDate.withTimeAtStartOfDay());
            OperationDisplayVO operationDisplayVo = dozer.map(operationEntity, OperationDisplayVO.class);
            operationDisplayVo.setAgeAtOperation(ageAtOperation.getYears());

            return operationDisplayVo;
        }
    }

    @Override
    @Transactional
    public List<OperationDisplayVO> getOperationList(int patientId) {
        List<OperationEntity> operationEntityList = genericCardDAO.getRecordsByPatientId(patientId, OperationEntity.class);
        if (operationEntityList.isEmpty()) {
            return null;
        } else {
            PatientEntity patient = genericDAO.getById(patientId, PatientEntity.class);

            DateTime patientBirthDate = new DateTime(patient.getBirthday());
            DateTime patientBeginningEpilepsy = new DateTime(patient.getBeginningEpilepsy());
            List<OperationDisplayVO> operationDisplayVoList = new ArrayList<>();

            for (OperationEntity operationEntity : operationEntityList) {
                DateTime operationDate = new DateTime(operationEntity.getDateOperation());
                Years ageAtOperation = Years.yearsBetween(patientBirthDate.withTimeAtStartOfDay(), operationDate.withTimeAtStartOfDay());
                Years epilepsyLastAtOperation = Years.yearsBetween(patientBeginningEpilepsy.withTimeAtStartOfDay(), operationDate.withTimeAtStartOfDay());
                OperationDisplayVO operationDisplayVo = dozer.map(operationEntity, OperationDisplayVO.class);
                operationDisplayVo.setAgeAtOperation(ageAtOperation.getYears());
                operationDisplayVo.setEpilepsyLastAtOperation(epilepsyLastAtOperation.getYears());
                operationDisplayVoList.add(operationDisplayVo);
            }

            return operationDisplayVoList;
        }
    }

    @Override
    @Transactional
    public OperationWithOutcomesDisplayVO getLatestOperationWithOutcomesByPatientId(int patientId) {
        List<OperationEntity> operationEntityList = operationDAO.getOperationWithOutcomeList(patientId);
        if (operationEntityList.isEmpty()) {
            return null;
        } else {
            OperationEntity operationEntity = operationEntityList.get(0);


            //remove all hidden outcomes from collection TODO find more effective way to return operation without them
            Iterator<OutcomeEntity> i = operationEntity.getOutcomeList().iterator();
            while (i.hasNext()) {
                OutcomeEntity outcomeEntity = i.next();
                if (outcomeEntity.isHistory()) {
                    i.remove();
                }
            }

            return dozer.map(operationEntity, OperationWithOutcomesDisplayVO.class);
        }
    }

    @Override
    @Transactional
    public List<OperationWithOutcomesDisplayVO> getOperationWithOutcomeList(int patientId) {
        List<OperationEntity> operationEntityList = operationDAO.getOperationWithOutcomeList(patientId);
        if (operationEntityList.isEmpty()) {
            return null;
        } else {
            List<OperationWithOutcomesDisplayVO> operationWithOutcomesDisplayVoList = new ArrayList<>();

            for (OperationEntity operationEntity : operationEntityList) {

                //remove all hidden outcomes from collection TODO find more effective way to return operation without them
                Iterator<OutcomeEntity> i = operationEntity.getOutcomeList().iterator();
                while (i.hasNext()) {
                    OutcomeEntity outcomeEntity = i.next();
                    if (outcomeEntity.isHistory()) {
                        i.remove();
                    }
                }

                OperationWithOutcomesDisplayVO operationWithOutcomesDisplayVo = dozer.map(operationEntity, OperationWithOutcomesDisplayVO.class);
                operationWithOutcomesDisplayVoList.add(operationWithOutcomesDisplayVo);
            }
            return operationWithOutcomesDisplayVoList;
        }
    }
}

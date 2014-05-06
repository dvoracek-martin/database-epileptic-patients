package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.card.OperationDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.display.card.OperationWithOutcomesDisplayBO;
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
    public OperationDisplayBO getLatestOperationByPatientId(int patientId) {
        List<OperationEntity> operationEntityList = genericCardDAO.getRecordsByPatientId(patientId, OperationEntity.class);
        if (operationEntityList.isEmpty()) {
            return null;
        } else {
            OperationEntity operationEntity = operationEntityList.get(0);
            PatientEntity patient = genericDAO.getById(patientId, PatientEntity.class);

            DateTime patientBirthDate = new DateTime(patient.getBirthday());

            DateTime operationDate = new DateTime(operationEntity.getDateOperation());
            Years ageAtOperation = Years.yearsBetween(patientBirthDate.withTimeAtStartOfDay(), operationDate.withTimeAtStartOfDay());
            OperationDisplayBO operationDisplayBO = dozer.map(operationEntity, OperationDisplayBO.class);
            operationDisplayBO.setAgeAtOperation(ageAtOperation.getYears());

            return operationDisplayBO;
        }
    }

    @Override
    @Transactional
    public List<OperationDisplayBO> getOperationList(int patientId) {
        List<OperationEntity> operationEntityList = genericCardDAO.getRecordsByPatientId(patientId, OperationEntity.class);
        if (operationEntityList.isEmpty()) {
            return null;
        } else {
            PatientEntity patient = genericDAO.getById(patientId, PatientEntity.class);

            DateTime patientBirthDate = new DateTime(patient.getBirthday());
            DateTime patientBeginningEpilepsy = new DateTime(patient.getBeginningEpilepsy());
            List<OperationDisplayBO> operationDisplayBOList = new ArrayList<>();

            for (OperationEntity operationEntity : operationEntityList) {
                DateTime operationDate = new DateTime(operationEntity.getDateOperation());
                Years ageAtOperation = Years.yearsBetween(patientBirthDate.withTimeAtStartOfDay(), operationDate.withTimeAtStartOfDay());
                Years epilepsyLastAtOperation = Years.yearsBetween(patientBeginningEpilepsy.withTimeAtStartOfDay(), operationDate.withTimeAtStartOfDay());
                OperationDisplayBO operationDisplayBO = dozer.map(operationEntity, OperationDisplayBO.class);
                operationDisplayBO.setAgeAtOperation(ageAtOperation.getYears());
                operationDisplayBO.setEpilepsyLastAtOperation(epilepsyLastAtOperation.getYears());
                operationDisplayBOList.add(operationDisplayBO);
            }

            return operationDisplayBOList;
        }
    }

    @Override
    @Transactional
    public OperationWithOutcomesDisplayBO getLatestOperationWithOutcomesByPatientId(int patientId) {
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

            return dozer.map(operationEntity, OperationWithOutcomesDisplayBO.class);
        }
    }

    @Override
    @Transactional
    public List<OperationWithOutcomesDisplayBO> getOperationWithOutcomeList(int patientId) {
        List<OperationEntity> operationEntityList = operationDAO.getOperationWithOutcomeList(patientId);
        if (operationEntityList.isEmpty()) {
            return null;
        } else {
            List<OperationWithOutcomesDisplayBO> operationWithOutcomesDisplayBOList = new ArrayList<>();

            for (OperationEntity operationEntity : operationEntityList) {

                //remove all hidden outcomes from collection TODO find more effective way to return operation without them
                Iterator<OutcomeEntity> i = operationEntity.getOutcomeList().iterator();
                while (i.hasNext()) {
                    OutcomeEntity outcomeEntity = i.next();
                    if (outcomeEntity.isHistory()) {
                        i.remove();
                    }
                }

                OperationWithOutcomesDisplayBO operationWithOutcomesDisplayBO = dozer.map(operationEntity, OperationWithOutcomesDisplayBO.class);
                operationWithOutcomesDisplayBOList.add(operationWithOutcomesDisplayBO);
            }
            return operationWithOutcomesDisplayBOList;
        }
    }
}

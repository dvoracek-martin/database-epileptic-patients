package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.OperationWithOutcomesDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.RoleVO;
import cz.cvut.fit.genepi.businessLayer.service.card.OperationService;
import cz.cvut.fit.genepi.dataLayer.DAO.card.OperationDAO;
import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.OperationEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.OutcomeEntity;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    @Transactional
    public List<OperationWithOutcomesDisplayVO> getOperationWithOutcomeList(int patientId) {
        List<OperationEntity> operationEntityList = operationDAO.getOperationWithOutcomeList(patientId);
        List<OperationWithOutcomesDisplayVO> operationWithOutcomesDisplayVoList = new ArrayList<>();

        for (OperationEntity operationEntity : operationEntityList) {

            //remove all hidden outcomes from collection TODO find more effective way to return operation without them
            Iterator<OutcomeEntity> i = operationEntity.getOutcomeList().iterator();
            while (i.hasNext()) {
                OutcomeEntity outcomeEntity = i.next();
               if(outcomeEntity.isHistory()){
                   i.remove();
               }
            }

            OperationWithOutcomesDisplayVO operationWithOutcomesDisplayVo = dozer.map(operationEntity, OperationWithOutcomesDisplayVO.class);
            operationWithOutcomesDisplayVoList.add(operationWithOutcomesDisplayVo);
        }
        return operationWithOutcomesDisplayVoList;
    }
}
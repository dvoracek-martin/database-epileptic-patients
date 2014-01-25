package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.OperationVO;
import cz.cvut.fit.genepi.businessLayer.service.card.OperationService;
import cz.cvut.fit.genepi.dataLayer.entity.card.OperationEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperationServiceImpl
        extends GenericCardServiceImpl<OperationVO, OperationEntity>
        implements OperationService {

    @Override
    @Transactional
    public void hide(int operationId) {
        OperationEntity entity = genericDAO.findByID(OperationEntity.class, operationId);
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Transactional
    public void unhide(int operationId) {
        OperationEntity entity = genericDAO.findByID(OperationEntity.class, operationId);
        entity.setStatus(0);
        genericDAO.save(entity);
    }
}

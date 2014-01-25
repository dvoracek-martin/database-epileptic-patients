package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.service.card.InvasiveTestECOGService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestEcogEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvasiveTestECOGServiceImpl extends
        GenericServiceImpl<InvasiveTestEcogEntity> implements
        InvasiveTestECOGService {

    @Override
    @Transactional
    public void hide(InvasiveTestEcogEntity entity) {
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Override
    @Transactional
    public void unhide(InvasiveTestEcogEntity entity) {
        entity.setStatus(0);
        genericDAO.save(entity);
    }
}

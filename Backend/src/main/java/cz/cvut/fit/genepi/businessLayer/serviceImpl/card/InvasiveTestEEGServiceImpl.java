package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.service.card.InvasiveTestEEGService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestEegEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvasiveTestEEGServiceImpl extends
        GenericServiceImpl<InvasiveTestEegEntity> implements
        InvasiveTestEEGService {

    @Override
    @Transactional
    public void hide(InvasiveTestEegEntity entity) {
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Override
    @Transactional
    public void unhide(InvasiveTestEegEntity entity) {
        entity.setStatus(0);
        genericDAO.save(entity);
    }
}

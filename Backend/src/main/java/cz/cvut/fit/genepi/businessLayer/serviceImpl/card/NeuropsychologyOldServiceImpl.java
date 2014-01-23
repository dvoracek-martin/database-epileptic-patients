package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.service.card.NeuropsychologyOldService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyOldEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NeuropsychologyOldServiceImpl extends
        GenericServiceImpl<NeuropsychologyOldEntity> implements
        NeuropsychologyOldService {

    @Override
    @Transactional
    public void hide(NeuropsychologyOldEntity entity) {
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Override
    @Transactional
    public void unhide(NeuropsychologyOldEntity entity) {
        entity.setStatus(0);
        genericDAO.save(entity);
    }
}

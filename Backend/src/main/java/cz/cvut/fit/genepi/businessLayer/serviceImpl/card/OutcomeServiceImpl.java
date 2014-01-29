package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.service.card.OutcomeService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.OutcomeEntity;
import org.springframework.stereotype.Service;

@Service
public class OutcomeServiceImpl extends
        GenericServiceImpl<OutcomeEntity> implements
        OutcomeService {

   /* @Override
    @Transactional
    public void hide(OutcomeEntity entity) {
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Override
    @Transactional
    public void unhide(OutcomeEntity entity) {
        entity.setStatus(0);
        genericDAO.save(entity);
    }*/
}

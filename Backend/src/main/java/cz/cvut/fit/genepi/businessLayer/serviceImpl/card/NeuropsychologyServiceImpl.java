package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.service.card.NeuropsychologyService;
import cz.cvut.fit.genepi.businessLayer.serviceImpl.GenericServiceImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NeuropsychologyServiceImpl extends GenericServiceImpl<NeuropsychologyEntity>
        implements NeuropsychologyService {

    @Override
    @Transactional
    public void hide(NeuropsychologyEntity entity) {
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Override
    @Transactional
    public void unhide(NeuropsychologyEntity entity) {
        entity.setStatus(0);
        genericDAO.save(entity);
    }
}

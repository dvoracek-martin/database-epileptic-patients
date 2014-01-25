package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.HistologyVO;
import cz.cvut.fit.genepi.businessLayer.service.card.HistologyService;
import cz.cvut.fit.genepi.dataLayer.entity.card.HistologyEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HistologyServiceImpl
        extends GenericCardServiceImpl<HistologyVO, HistologyEntity>
        implements HistologyService {

    @Override
    @Transactional
    public void hide(int histologyId) {
        HistologyEntity entity = genericDAO.findByID(HistologyEntity.class, histologyId);
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Transactional
    public void unhide(int histologyId) {
        HistologyEntity entity = genericDAO.findByID(HistologyEntity.class, histologyId);
        entity.setStatus(0);
        genericDAO.save(entity);
    }
}

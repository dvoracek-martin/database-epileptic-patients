package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.card.InvasiveTestEegVO;
import cz.cvut.fit.genepi.businessLayer.service.card.InvasiveTestEegService;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestEegEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvasiveTestEegServiceImpl
        extends GenericCardServiceImpl<InvasiveTestEegVO, InvasiveTestEegEntity>
        implements InvasiveTestEegService {

    @Override
    @Transactional
    public void hide(int invasiveTestEegId) {
        InvasiveTestEegEntity entity = genericDAO.findByID(InvasiveTestEegEntity.class, invasiveTestEegId);
        entity.setHidden(true);
        genericDAO.save(entity);
    }

    @Transactional
    public void unhide(int invasiveTestEegId) {
        InvasiveTestEegEntity entity = genericDAO.findByID(InvasiveTestEegEntity.class, invasiveTestEegId);
        entity.setHidden(false);
        genericDAO.save(entity);
    }
}

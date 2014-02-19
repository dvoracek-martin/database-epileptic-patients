package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.ComplicationVO;
import cz.cvut.fit.genepi.businessLayer.service.card.ComplicationService;
import cz.cvut.fit.genepi.dataLayer.entity.card.ComplicationEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComplicationServiceImpl
        extends GenericCardServiceImpl<ComplicationVO, ComplicationEntity>
        implements ComplicationService {

    @Override
    @Transactional
    public void hide(int complicationId) {
        ComplicationEntity entity = genericDAO.findByID(ComplicationEntity.class, complicationId);
        entity.setHidden(true);
        genericDAO.save(entity);
    }

    @Transactional
    public void unhide(int complicationId) {
        ComplicationEntity entity = genericDAO.findByID(ComplicationEntity.class, complicationId);
        entity.setHidden(false);
        genericDAO.save(entity);
    }
}

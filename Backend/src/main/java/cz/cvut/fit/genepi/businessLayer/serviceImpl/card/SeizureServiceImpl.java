package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.SeizureVO;
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureService;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SeizureServiceImpl
        extends GenServiceImpl<SeizureVO, SeizureEntity>
        implements SeizureService {

    @Override
    @Transactional
    public void hide(int seizureId) {
        SeizureEntity entity = genericDAO.findByID(SeizureEntity.class, seizureId);
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Override
    @Transactional
    public void unhide(int seizureId) {
        SeizureEntity entity = genericDAO.findByID(SeizureEntity.class, seizureId);
        entity.setStatus(0);
        genericDAO.save(entity);
    }
}

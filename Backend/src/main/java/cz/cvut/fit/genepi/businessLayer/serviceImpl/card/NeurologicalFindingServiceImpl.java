package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.NeurologicalFindingVO;
import cz.cvut.fit.genepi.businessLayer.service.card.NeurologicalFindingService;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeurologicalFindingEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NeurologicalFindingServiceImpl
        extends GenericCardServiceImpl<NeurologicalFindingVO, NeurologicalFindingEntity>
        implements NeurologicalFindingService {

    @Override
    @Transactional
    public void hide(int neurologicalFindingId) {
        NeurologicalFindingEntity entity = genericDAO.findByID(NeurologicalFindingEntity.class, neurologicalFindingId);
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Transactional
    public void unhide(int neurologicalFindingId) {
        NeurologicalFindingEntity entity = genericDAO.findByID(NeurologicalFindingEntity.class, neurologicalFindingId);
        entity.setStatus(0);
        genericDAO.save(entity);
    }
}

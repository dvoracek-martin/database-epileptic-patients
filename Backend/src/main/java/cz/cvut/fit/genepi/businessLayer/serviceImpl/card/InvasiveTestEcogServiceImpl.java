package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.card.InvasiveTestEcogVO;
import cz.cvut.fit.genepi.businessLayer.service.card.InvasiveTestEcogService;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestEcogEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvasiveTestEcogServiceImpl
        extends GenericCardServiceImpl<InvasiveTestEcogVO, InvasiveTestEcogEntity>
        implements InvasiveTestEcogService {

    @Override
    @Transactional
    public void hide(int invasiveTestEcogId) {
        InvasiveTestEcogEntity entity = genericDAO.findByID(InvasiveTestEcogEntity.class, invasiveTestEcogId);
        entity.setHidden(true);
        genericDAO.save(entity);
    }

    @Transactional
    public void unhide(int invasiveTestEcogId) {
        InvasiveTestEcogEntity entity = genericDAO.findByID(InvasiveTestEcogEntity.class, invasiveTestEcogId);
        entity.setHidden(false);
        genericDAO.save(entity);
    }
}

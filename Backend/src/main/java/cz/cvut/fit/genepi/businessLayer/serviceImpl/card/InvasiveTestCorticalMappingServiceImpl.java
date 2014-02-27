package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.card.InvasiveTestCorticalMappingVO;
import cz.cvut.fit.genepi.businessLayer.service.card.InvasiveTestCorticalMappingService;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestCorticalMappingEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvasiveTestCorticalMappingServiceImpl
        extends GenericCardServiceImpl<InvasiveTestCorticalMappingVO, InvasiveTestCorticalMappingEntity>
        implements InvasiveTestCorticalMappingService {

    @Override
    @Transactional
    public void hide(int invasiveTestCorticalMappingId) {
        InvasiveTestCorticalMappingEntity entity = genericDAO.findByID(InvasiveTestCorticalMappingEntity.class, invasiveTestCorticalMappingId);
        entity.setHidden(true);
        genericDAO.save(entity);
    }

    @Transactional
    public void unhide(int invasiveTestCorticalMappingId) {
        InvasiveTestCorticalMappingEntity entity = genericDAO.findByID(InvasiveTestCorticalMappingEntity.class, invasiveTestCorticalMappingId);
        entity.setHidden(false);
        genericDAO.save(entity);
    }

}

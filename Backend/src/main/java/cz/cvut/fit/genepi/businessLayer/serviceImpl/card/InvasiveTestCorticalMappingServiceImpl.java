package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.InvasiveTestCorticalMappingVO;
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
        entity.setStatus(1);
        genericDAO.save(entity);
    }

    @Transactional
    public void unhide(int invasiveTestCorticalMappingId) {
        InvasiveTestCorticalMappingEntity entity = genericDAO.findByID(InvasiveTestCorticalMappingEntity.class, invasiveTestCorticalMappingId);
        entity.setStatus(0);
        genericDAO.save(entity);
    }

}

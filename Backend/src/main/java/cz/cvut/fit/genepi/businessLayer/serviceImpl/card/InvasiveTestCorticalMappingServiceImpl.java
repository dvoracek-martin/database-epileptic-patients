package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.InvasiveTestCorticalMappingDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.InvasiveTestCorticalMappingVO;
import cz.cvut.fit.genepi.businessLayer.service.card.InvasiveTestCorticalMappingService;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestCorticalMappingEntity;
import org.springframework.stereotype.Service;

@Service
public class InvasiveTestCorticalMappingServiceImpl
        extends GenericCardServiceImpl<InvasiveTestCorticalMappingDisplayVO, InvasiveTestCorticalMappingVO, InvasiveTestCorticalMappingEntity>
        implements InvasiveTestCorticalMappingService {

}

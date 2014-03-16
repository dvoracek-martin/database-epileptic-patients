package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.NeurologicalFindingDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.NeurologicalFindingVO;
import cz.cvut.fit.genepi.businessLayer.service.card.NeurologicalFindingService;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeurologicalFindingEntity;
import org.springframework.stereotype.Service;

@Service
public class NeurologicalFindingServiceImpl
        extends GenericCardServiceImpl<NeurologicalFindingDisplayVO,NeurologicalFindingVO, NeurologicalFindingEntity>
        implements NeurologicalFindingService {

}

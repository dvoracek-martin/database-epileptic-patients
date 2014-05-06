package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.card.NeurologicalFindingDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.NeurologicalFindingFormBO;
import cz.cvut.fit.genepi.businessLayer.service.card.NeurologicalFindingService;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeurologicalFindingEntity;
import org.springframework.stereotype.Service;

@Service
public class NeurologicalFindingServiceImpl
        extends GenericCardServiceImpl<NeurologicalFindingDisplayBO, NeurologicalFindingFormBO, NeurologicalFindingEntity>
        implements NeurologicalFindingService {

}

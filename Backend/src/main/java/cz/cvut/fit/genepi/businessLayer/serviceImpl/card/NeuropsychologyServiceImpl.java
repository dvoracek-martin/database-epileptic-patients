package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.card.NeuropsychologyDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.NeuropsychologyFormBO;
import cz.cvut.fit.genepi.businessLayer.service.card.NeuropsychologyService;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyEntity;
import org.springframework.stereotype.Service;

@Service
public class NeuropsychologyServiceImpl
        extends GenericCardServiceImpl<NeuropsychologyDisplayBO, NeuropsychologyFormBO, NeuropsychologyEntity>
        implements NeuropsychologyService {

}

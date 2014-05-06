package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.card.HistologyDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.HistologyFormBO;
import cz.cvut.fit.genepi.businessLayer.service.card.HistologyService;
import cz.cvut.fit.genepi.dataLayer.entity.card.HistologyEntity;
import org.springframework.stereotype.Service;

@Service
public class HistologyServiceImpl
        extends GenericCardServiceImpl<HistologyDisplayBO, HistologyFormBO, HistologyEntity>
        implements HistologyService {

}

package cz.cvut.fit.genepi.businessLayer.serviceImpl.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.card.ComplicationDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.ComplicationFormBO;
import cz.cvut.fit.genepi.businessLayer.service.card.ComplicationService;
import cz.cvut.fit.genepi.dataLayer.entity.card.ComplicationEntity;
import org.springframework.stereotype.Service;

@Service
public class ComplicationServiceImpl
        extends GenericCardServiceImpl<ComplicationDisplayBO, ComplicationFormBO, ComplicationEntity>
        implements ComplicationService {

}

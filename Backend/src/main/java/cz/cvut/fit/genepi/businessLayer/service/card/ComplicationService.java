package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.card.ComplicationDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.card.ComplicationFormBO;
import cz.cvut.fit.genepi.dataLayer.entity.card.ComplicationEntity;

public interface ComplicationService
        extends GenericCardService<ComplicationDisplayBO, ComplicationFormBO, ComplicationEntity> {

}

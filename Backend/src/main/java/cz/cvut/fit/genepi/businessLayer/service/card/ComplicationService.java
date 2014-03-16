package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.ComplicationDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.ComplicationVO;
import cz.cvut.fit.genepi.dataLayer.DAO.card.ComplicationDAO;
import cz.cvut.fit.genepi.dataLayer.entity.card.ComplicationEntity;

public interface ComplicationService extends GenericCardService<ComplicationDisplayVO,ComplicationVO, ComplicationEntity> {

}

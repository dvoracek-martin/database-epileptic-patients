package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.card.ComplicationVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.ComplicationEntity;

public interface ComplicationService extends GenericCardService<ComplicationVO, ComplicationEntity> {

    public void hide(int complicationId);

    public void unhide(int complicationId);
}

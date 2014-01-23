package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.SeizureVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureEntity;

/**
 * The Interface GenericCardService extends GenericCardService
 */
public interface SeizureService extends GenService<SeizureVO, SeizureEntity> {

    public void hide(int seizureId);

    public void unhide(int seizureId);
}

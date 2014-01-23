package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.SeizureDetailVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureDetailEntity;

/**
 * The Interface SeizureDetailService extends GenericCardService
 */
public interface SeizureDetailService extends GenService<SeizureDetailVO, SeizureDetailEntity> {

    public void hide(int seizureDetailId);

    public void unhide(int seizureDetailId);

}

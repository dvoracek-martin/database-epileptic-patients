package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.card.SeizureDetailVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureDetailEntity;

public interface SeizureDetailService extends GenericCardService<SeizureDetailVO, SeizureDetailEntity> {

    public void hide(int seizureDetailId);

    public void unhide(int seizureDetailId);

}

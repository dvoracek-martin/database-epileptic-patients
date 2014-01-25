package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.SeizureVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureEntity;

public interface SeizureService extends GenericCardService<SeizureVO, SeizureEntity> {

    public void hide(int seizureId);

    public void unhide(int seizureId);
}

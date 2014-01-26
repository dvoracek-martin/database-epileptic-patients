package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.InvasiveTestEegVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestEegEntity;

public interface InvasiveTestEegService extends GenericCardService<InvasiveTestEegVO, InvasiveTestEegEntity> {

    public void hide(int invasiveTestEegId);

    public void unhide(int invasiveTestEegId);
}

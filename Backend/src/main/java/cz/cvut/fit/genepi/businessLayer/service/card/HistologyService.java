package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.card.HistologyVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.HistologyEntity;

public interface HistologyService extends GenericCardService<HistologyVO, HistologyEntity> {

    public void hide(int histologyId);

    public void unhide(int histologyId);
}

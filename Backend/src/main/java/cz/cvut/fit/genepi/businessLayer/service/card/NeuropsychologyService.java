package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.card.NeuropsychologyVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyEntity;

public interface NeuropsychologyService extends GenericCardService<NeuropsychologyVO, NeuropsychologyEntity> {

    public void hide(int neuropsychologyId);

    public void unhide(int neuropsychologyId);
}

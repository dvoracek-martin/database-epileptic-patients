package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.card.NeurologicalFindingVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeurologicalFindingEntity;

public interface NeurologicalFindingService extends GenericCardService<NeurologicalFindingVO, NeurologicalFindingEntity> {

    public void saveAsHistory(int neurologicalFindingId);

    public void hide(int neurologicalFindingId);

    public void unhide(int neurologicalFindingId);
}

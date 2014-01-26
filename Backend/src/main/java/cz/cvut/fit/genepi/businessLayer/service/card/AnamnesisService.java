package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.AnamnesisVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.AnamnesisEntity;


public interface AnamnesisService extends GenericCardService<AnamnesisVO, AnamnesisEntity> {

    // public List<AnamnesisEntity> findAllHidden();

    public void hide(int anamnesisId);

    public void unhide(int anamnesisId);
}

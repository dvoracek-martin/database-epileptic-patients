package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.card.PharmacotherapyVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.PharmacotherapyEntity;

public interface PharmacotherapyService extends GenericCardService<PharmacotherapyVO, PharmacotherapyEntity> {

    public void hide(int pharmacotherapyId);

    public void unhide(int pharmacotherapyId);
}

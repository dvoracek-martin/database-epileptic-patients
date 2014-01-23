package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.PharmacotherapyVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.PharmacotherapyEntity;

/**
 * The Interface PharmacotherapyService extends GenericCardService
 */
public interface PharmacotherapyService extends GenService<PharmacotherapyVO, PharmacotherapyEntity> {

    public void hide(int pharmacotherapyId);

    public void unhide(int pharmacotherapyId);
}

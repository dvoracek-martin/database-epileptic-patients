package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.NeurologicalFindingVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.PharmacotherapyVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.PharmacotherapyEntity;

/**
 * The Interface PharmacotherapyService extends GenericCardService
 */
public interface PharmacotherapyService /*extends GenericCardService<PharmacotherapyEntity>*/ {

    public PharmacotherapyVO getById(int nfId);

    public void save(PharmacotherapyVO pharmacotherapyVO);

    public void hide(int pharmacotherapyId);

    public void unhide(int pharmacotherapyId);
}

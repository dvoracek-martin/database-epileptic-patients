package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.NeurologicalFindingVO;

/**
 * The Interface NeurologicalFindingService extends GenericCardService
 */
public interface NeurologicalFindingService /*extends GenericCardService<NeurologicalFindingVO> */ {

    public NeurologicalFindingVO getById(int nfId);

    public void save(NeurologicalFindingVO neurologicalFindingVO);

    public void hide(int neurologicalFindingId);

    public void unhide(int neurologicalFindingId);
}

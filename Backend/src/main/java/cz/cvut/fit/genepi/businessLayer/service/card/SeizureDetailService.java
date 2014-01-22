package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.SeizureDetailVO;

/**
 * The Interface SeizureDetailService extends GenericCardService
 */
public interface SeizureDetailService /*extends GenericCardService<SeizureDetailEntity>*/ {

    public SeizureDetailVO getById(int sdId);

    public void save(SeizureDetailVO seizureDetailVO);

    public void hide(int seizureDetailId);

    public void unhide(int seizureDetailId);

}

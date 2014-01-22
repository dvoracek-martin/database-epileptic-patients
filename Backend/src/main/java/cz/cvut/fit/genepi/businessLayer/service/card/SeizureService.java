package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.SeizureVO;

/**
 * The Interface GenericCardService extends GenericCardService
 */
public interface SeizureService /* extends GenericCardService<SeizureEntity> */ {

    public SeizureVO getById(int sId);

    public void save(SeizureVO seizureVO);

    public void hide(int seizureId);

    public void unhide(int seizureId);
}

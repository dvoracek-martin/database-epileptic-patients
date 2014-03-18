package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.SeizureDetailDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.SeizureVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureEntity;

public interface SeizureService extends GenericCardService<SeizureDetailDisplayVO,SeizureVO, SeizureEntity> {

    public int save(SeizureVO seizure);
}

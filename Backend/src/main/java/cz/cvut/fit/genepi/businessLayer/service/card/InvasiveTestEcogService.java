package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.card.InvasiveTestEcogVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestEcogEntity;

public interface InvasiveTestEcogService extends GenericCardService<InvasiveTestEcogVO, InvasiveTestEcogEntity> {

    public void hide(int invasiveTestEcogId);

    public void unhide(int invasiveTestEcogId);
}

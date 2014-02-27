package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.card.OperationVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.OperationEntity;

public interface OperationService extends GenericCardService<OperationVO, OperationEntity> {

    public void hide(int operationId);

    public void unhide(int operationId);
}

package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.OperationDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.card.OperationWithOutcomesDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.OperationVO;
import cz.cvut.fit.genepi.dataLayer.entity.card.OperationEntity;

import java.util.List;

public interface OperationService {

    public List<OperationWithOutcomesDisplayVO> getOperationWithOutcomeList(int patientId);
}

package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.OperationDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.card.OperationWithOutcomesDisplayVO;

import java.util.List;

public interface OperationService {

    public List<OperationDisplayVO> getOperationList(int patientId);

    public List<OperationWithOutcomesDisplayVO> getOperationWithOutcomeList(int patientId);
}

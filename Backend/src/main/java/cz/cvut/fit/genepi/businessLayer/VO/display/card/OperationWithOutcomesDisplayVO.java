package cz.cvut.fit.genepi.businessLayer.VO.display.card;

import java.util.List;

public class OperationWithOutcomesDisplayVO extends OperationDisplayVO {

    private List<OutcomeDisplayVO> outcomeList;

    public List<OutcomeDisplayVO> getOutcomeList() {
        return outcomeList;
    }

    public void setOutcomeList(List<OutcomeDisplayVO> outcomeList) {
        this.outcomeList = outcomeList;
    }
}
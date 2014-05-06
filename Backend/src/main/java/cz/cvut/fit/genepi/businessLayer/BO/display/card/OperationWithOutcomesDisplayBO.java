package cz.cvut.fit.genepi.businessLayer.BO.display.card;

import java.util.List;

public class OperationWithOutcomesDisplayBO extends OperationDisplayBO {

    private List<OutcomeDisplayBO> outcomeList;

    public List<OutcomeDisplayBO> getOutcomeList() {
        return outcomeList;
    }

    public void setOutcomeList(List<OutcomeDisplayBO> outcomeList) {
        this.outcomeList = outcomeList;
    }

    public String getSeizureOutcome() {
        return null;
    }
}
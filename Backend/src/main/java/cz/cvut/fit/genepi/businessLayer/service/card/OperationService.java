package cz.cvut.fit.genepi.businessLayer.service.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.card.OperationDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.display.card.OperationWithOutcomesDisplayBO;

import java.util.List;

public interface OperationService {

    public OperationDisplayBO getLatestOperationByPatientId(int patientId);

    public List<OperationDisplayBO> getOperationList(int patientId);

    public OperationWithOutcomesDisplayBO getLatestOperationWithOutcomesByPatientId(int patientId);

    public List<OperationWithOutcomesDisplayBO> getOperationWithOutcomeList(int patientId);
}

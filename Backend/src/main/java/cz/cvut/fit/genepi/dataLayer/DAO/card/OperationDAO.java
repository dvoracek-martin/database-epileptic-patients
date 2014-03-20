package cz.cvut.fit.genepi.dataLayer.DAO.card;

import cz.cvut.fit.genepi.dataLayer.entity.card.OperationEntity;

import java.util.List;

/**
 * OperationDAO interface
 */
public interface OperationDAO {
    public List<OperationEntity> getOperationWithOutcomeList(int patientId);

}

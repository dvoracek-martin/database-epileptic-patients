package cz.cvut.fit.genepi.dataLayer.DAO.card;

import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;
import cz.cvut.fit.genepi.dataLayer.entity.card.AnamnesisEntity;

/**
 * AnamnesisDAO interface
 */
public interface AnamnesisDAO extends GenericDAO<AnamnesisEntity> {

    public AnamnesisEntity getRecordsByPatientId(int patientId);
}

package cz.cvut.fit.genepi.DAO;

import java.io.Serializable;
import java.util.List;

import cz.cvut.fit.genepi.entity.AnamnesisEntity;


/**
 * The Interface AnamnesisDAO.
 */
public interface AnamnesisDAO extends GenericDAO<AnamnesisEntity, Serializable> {
 
	public List<AnamnesisEntity> findAnamnesisByPatientID(int patientId);

	public AnamnesisEntity findLatestAnamnesisByPatientID(int patientID);
}
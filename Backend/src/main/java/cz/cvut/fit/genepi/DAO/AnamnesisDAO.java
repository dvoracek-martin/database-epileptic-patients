package cz.cvut.fit.genepi.DAO;

import java.io.Serializable;
import java.util.List;

import cz.cvut.fit.genepi.entities.AnamnesisEntity;


/**
 * The Interface AnamnesisDAO.
 */
public interface AnamnesisDAO extends GenericDAO<AnamnesisEntity, Serializable> {
	/**
	 * Find anamnesis by patient id.
	 *
	 * @param patient_id the patient_id
	 * @return the anamnesis entity
	 */
	public List<AnamnesisEntity> findAnamnesisByPatientID(int patient_id);
}
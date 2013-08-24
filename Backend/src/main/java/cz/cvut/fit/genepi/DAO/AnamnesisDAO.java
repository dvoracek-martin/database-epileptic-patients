package cz.cvut.fit.genepi.DAO;

import java.io.Serializable;
import java.util.List;

import cz.cvut.fit.genepi.entity.AnamnesisEntity;


// TODO: Auto-generated Javadoc
/**
 * The Interface AnamnesisDAO.
 */
public interface AnamnesisDAO extends GenericDAO<AnamnesisEntity, Serializable> {
 
	/**
	 * Find anamnesis by patient id.
	 *
	 * @param patientId the patient id
	 * @return the list
	 */
	public List<AnamnesisEntity> findAnamnesisByPatientID(int patientId);

	/**
	 * Find latest anamnesis by patient id.
	 *
	 * @param patientID the patient id
	 * @return the anamnesis entity
	 */
	public AnamnesisEntity findLatestAnamnesisByPatientID(int patientID);
}
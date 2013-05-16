package cz.cvut.fit.genepi.models;

import cz.cvut.fit.genepi.entities.AnamnesisEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface PatientDAO.
 */
public interface PatientDAO {
	
	/**
	 * Find anamnesis by patient id.
	 *
	 * @param patient_id the patient_id
	 * @return the anamnesis entity
	 */
	public AnamnesisEntity findAnamnesisByPatientID(int patient_id);
}
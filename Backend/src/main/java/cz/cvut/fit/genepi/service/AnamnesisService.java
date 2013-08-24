package cz.cvut.fit.genepi.service;

import java.util.List;

import cz.cvut.fit.genepi.entity.AnamnesisEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface AnamnesisService.
 */
public interface AnamnesisService {
	
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

	/**
	 * Save.
	 *
	 * @param anamnesis the anamnesis
	 */
	public void save(AnamnesisEntity anamnesis);
}

package cz.cvut.fit.genepi.service;

import java.util.List;

import cz.cvut.fit.genepi.entity.SeizureEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface SeizureService.
 */
public interface SeizureService {
	
	/**
	 * Find seizure by patient id.
	 *
	 * @param patientId the patient id
	 * @return the list
	 */
	public List<SeizureEntity> findSeizureByPatientID(int patientId);
}

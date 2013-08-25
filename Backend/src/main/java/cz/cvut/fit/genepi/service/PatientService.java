package cz.cvut.fit.genepi.service;

import java.util.List;

import cz.cvut.fit.genepi.entity.PatientEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface PatientService.
 */
public interface PatientService {

	/**
	 * Save.
	 *
	 * @param patient the patient
	 */
	public void save(PatientEntity patient);

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the patient entity
	 */
	public PatientEntity findByID(int id);

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<PatientEntity> findAll();

	/**
	 * Find patient by id.
	 *
	 * @param patientID the patient id
	 * @return the patient entity
	 */
}

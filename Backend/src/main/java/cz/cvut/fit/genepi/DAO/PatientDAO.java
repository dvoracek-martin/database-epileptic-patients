package cz.cvut.fit.genepi.DAO;

import java.io.Serializable;

import cz.cvut.fit.genepi.entity.PatientEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface PatientDAO.
 */
public interface PatientDAO extends GenericDAO<PatientEntity, Serializable> {

	/**
	 * Find patient by id.
	 *
	 * @param patientID the patient id
	 * @return the patient entity
	 */
}
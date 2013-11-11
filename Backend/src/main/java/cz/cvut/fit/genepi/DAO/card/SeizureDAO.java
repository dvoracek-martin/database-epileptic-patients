package cz.cvut.fit.genepi.DAO.card;

import java.util.List;

import cz.cvut.fit.genepi.DAO.GenericDAO;
import cz.cvut.fit.genepi.entity.card.SeizureEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface SeizureDAO.
 */
public interface SeizureDAO extends GenericDAO<SeizureEntity> {

	/**
	 * Find anamnesis by patient id.
	 *
	 * @param patientId the patient id
	 * @return the list
	 */
	List<SeizureEntity> findAnamnesisByPatientID(int patientId);

}

package cz.cvut.fit.genepi.dataLayer.DAO.card;

import java.util.List;

import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureEntity;

/**
 * SeizureDAO interface
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

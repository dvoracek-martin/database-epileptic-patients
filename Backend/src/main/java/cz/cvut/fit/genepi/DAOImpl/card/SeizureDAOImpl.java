package cz.cvut.fit.genepi.DAOImpl.card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.card.SeizureDAO;
import cz.cvut.fit.genepi.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.entity.card.SeizureEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class SeizureDAOImpl.
 */
@Repository
public class SeizureDAOImpl extends GenericDAOImpl<SeizureEntity, Serializable>
		implements SeizureDAO {

	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.DAO.SeizureDAO#findAnamnesisByPatientID(int)
	 */
	@Override
	public List<SeizureEntity> findAnamnesisByPatientID(int patientId) {
		List<SeizureEntity> seizureEntities = new ArrayList<SeizureEntity>();
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from SeizureEntity where patientId = :patient_id");
		query.setParameter("patient_id", patientId);		
		seizureEntities = findMany(query);
		
		return seizureEntities;
	}

}

package cz.cvut.fit.genepi.DAOImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.SeizureDAO;
import cz.cvut.fit.genepi.entity.SeizureEntity;

@Repository
public class SeizureDAOImpl extends GenericDAOImpl<SeizureEntity, Serializable>
		implements SeizureDAO {

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
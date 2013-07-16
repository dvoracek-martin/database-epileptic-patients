package cz.cvut.fit.genepi.DAOImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.AnamnesisDAO;
import cz.cvut.fit.genepi.entity.AnamnesisEntity;

@Repository
public class AnamnesisDAOImpl extends
		GenericDAOImpl<AnamnesisEntity, Serializable> implements AnamnesisDAO {

	
	public List<AnamnesisEntity> findAnamnesisByPatientID(int patientId) {
		List<AnamnesisEntity> anamnesisEntities = new ArrayList<AnamnesisEntity>();
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from AnamnesisEntity where patientId = :patient_id");
		query.setParameter("patient_id", patientId);		
		anamnesisEntities = findMany(query);
		
		return anamnesisEntities;
	}
}
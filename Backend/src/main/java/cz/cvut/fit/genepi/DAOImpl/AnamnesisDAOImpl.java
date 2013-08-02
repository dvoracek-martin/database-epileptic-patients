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

	@Override
	public List<AnamnesisEntity> findAnamnesisByPatientID(int patientId) {
		List<AnamnesisEntity> anamnesisEntities = new ArrayList<AnamnesisEntity>();
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from AnamnesisEntity where patientId = :patient_id");
		query.setParameter("patient_id", patientId);		
		anamnesisEntities = findMany(query);
		
		return anamnesisEntities;
	}

	@Override
	public AnamnesisEntity findLatestAnamnesisByPatientID(int patientID) {
		AnamnesisEntity anamnesisEntity;
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from AnamnesisEntity where patientId = :patient_id"); //correct to return latest
		query.setParameter("patient_id", patientID);		
		anamnesisEntity = findOne(query);
		return anamnesisEntity;
	}
}
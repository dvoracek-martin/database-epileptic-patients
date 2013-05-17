package cz.cvut.fit.genepi.modelsImpl;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fit.genepi.entities.AnamnesisEntity;
import cz.cvut.fit.genepi.models.AnamnesisDAO;
import cz.cvut.fit.genepi.utils.HibernateUtil;

/**
 * The Class AnamnesisDAOImpl.
 */
public class AnamnesisDAOImpl extends
		GenericDAOImpl<AnamnesisEntity, Serializable> implements AnamnesisDAO {
	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.models.PatientDAO#findAnamnesisByPatientID(int)
	 */
	public List<AnamnesisEntity> findAnamnesisByPatientID(int patient_id) {
		List<AnamnesisEntity> anamnesisEntity = new ArrayList<AnamnesisEntity>();
		Session hibernateSession = (Session) HibernateUtil.getSessionFactory()
				.openSession();
		Query query = hibernateSession
				.createQuery("from AnamnesisEntity where patientId = :patient_id");
		query.setParameter("patient_id", /*Integer.toString(*/patient_id/*)*/);		
		anamnesisEntity = findMany(query);
		
		return anamnesisEntity;
	}
}
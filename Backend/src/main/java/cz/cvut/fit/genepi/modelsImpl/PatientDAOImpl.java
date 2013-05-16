package cz.cvut.fit.genepi.modelsImpl;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;

import cz.cvut.fit.genepi.entities.AnamnesisEntity;
import cz.cvut.fit.genepi.entities.PatientEntity;
import cz.cvut.fit.genepi.models.PatientDAO;
import cz.cvut.fit.genepi.utils.HibernateUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientDAOImpl.
 */
public class PatientDAOImpl extends GenericDAOImpl<PatientEntity, Serializable>
		implements PatientDAO {
	
	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.models.PatientDAO#findAnamnesisByPatientID(int)
	 */
	public AnamnesisEntity findAnamnesisByPatientID(int patient_id) {
		AnamnesisEntity anamnesisEntity = new AnamnesisEntity();
		Session hibernateSession = (Session) HibernateUtil.getSessionFactory()
				.openSession();
		Query query = hibernateSession
				.createQuery("from Stock where stockCode = :patient_id ");
		query.setParameter("patient_id", Integer.toString(patient_id));		
		findOne(query);
		
		return anamnesisEntity;
	}
}
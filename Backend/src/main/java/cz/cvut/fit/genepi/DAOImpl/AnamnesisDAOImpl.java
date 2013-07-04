package cz.cvut.fit.genepi.DAOImpl;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import cz.cvut.fit.genepi.DAO.AnamnesisDAO;
import cz.cvut.fit.genepi.entity.AnamnesisEntity;
import cz.cvut.fit.genepi.utils.HibernateUtil;

@Repository
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
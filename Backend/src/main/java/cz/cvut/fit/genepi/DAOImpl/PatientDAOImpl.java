package cz.cvut.fit.genepi.DAOImpl;

import java.io.Serializable;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.PatientDAO;
import cz.cvut.fit.genepi.entity.PatientEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientDAOImpl.
 */
@Repository
public class PatientDAOImpl extends GenericDAOImpl<PatientEntity, Serializable>
		implements PatientDAO {

	@Override
	public PatientEntity findPatientByID(Integer patientID) {
		PatientEntity patientEntity;
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from PatientEntity where id = :patient_id");
		query.setParameter("patient_id", patientID);		
		patientEntity = findOne(query);
		return patientEntity;
	}
}
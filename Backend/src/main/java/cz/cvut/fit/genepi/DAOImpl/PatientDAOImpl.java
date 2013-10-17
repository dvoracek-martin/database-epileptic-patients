package cz.cvut.fit.genepi.DAOImpl;

import java.io.Serializable;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	public PatientEntity getPatientByIdWithAnamnesis(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p join fetch p.anamnesisList where p.id = :patientId");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}
}
package cz.cvut.fit.genepi.DAOImpl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.PatientDAO;
import cz.cvut.fit.genepi.entity.PatientEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientDAOImpl.
 */
@Repository
public class PatientDAOImpl extends GenericDAOImpl<PatientEntity> implements
		PatientDAO {

	@Override
	public PatientEntity getPatientByIdWithAllLists(int patientId) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select p from PatientEntity p"
						+ " left join fetch p.doctor"
						+ " left join fetch p.anamnesisList"
						+ " left join fetch p.complicationList"
						+ " left join fetch p.diagnosticTestScalpEEGList"
						+ " left join fetch p.diagnosticTestMRIList"
						+ " left join fetch p.histologyList"
						+ " left join fetch p.invasiveTestCorticalMappingList"
						+ " left join fetch p.invasiveTestECOGList"
						+ " left join fetch p.invasiveTestEEGList"
						+ " left join fetch p.neurologicalFindingList"
						// + " left join fetch p.neuropsychologyList"
						+ " left join fetch p.operationList "
						+ " left join fetch p.outcomeList"
						+ " left join fetch p.pharmacotherapyList"
						+ " left join fetch p.seizureList"
						+ " where p.id = :patientId");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	@Override
	public PatientEntity getPatientByIdWithAnamnesisList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.anamnesisList a"
								+ " where p.id = :patientId AND a.status=0");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	@Override
	public PatientEntity getPatientByIdWithComplicationList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.complicationList c"
								+ " where p.id = :patientId AND c.status=0");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	@Override
	public PatientEntity getPatientByIdWithDiagnosticTestEEGList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.diagnosticTestEEGList d"
								+ " where p.id = :patientId AND d.status=0");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	@Override
	public PatientEntity getPatientByIdWithDiagnosticTestMRIList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.diagnosticTestMRIList d"
								+ " where p.id = :patientId AND d.status=0");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	@Override
	public PatientEntity getPatientByIdWithHistologyList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.histologyList h"
								+ " where p.id = :patientId AND h.status=0");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	@Override
	public PatientEntity getPatientByIdWithInvasiveTestCorticalMappingList(
			int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.invasiveTestCorticalMappingList i"
								+ " where p.id = :patientId AND i.status=0");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	@Override
	public PatientEntity getPatientByIdWithInvasiveTestECOGList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.invasiveTestECOGList i"
								+ " where p.id = :patientId AND i.status=0");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	@Override
	public PatientEntity getPatientByIdWithInvasiveTestEEGList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.invasiveTestEEGList i"
								+ " where p.id = :patientId AND i.status=0");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	@Override
	public PatientEntity getPatientByIdWithNeurologicalFindingList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.neurologicalFindingList n"
								+ " where p.id = :patientId  AND n.status=0");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	@Override
	public PatientEntity getPatientByIdWithNeuropsychologyList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.neuropsychologyList n"
								+ " where p.id = :patientId AND n.status=0");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	@Override
	public PatientEntity getPatientByIdWithOperationList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.operationList o"
								+ " where p.id = :patientId AND o.status=0");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	@Override
	public PatientEntity getPatientByIdWithOutcomeList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.outcomeList o"
								+ " where p.id = :patientId AND o.status=0");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	@Override
	public PatientEntity getPatientByIdWithPharmacotherapyList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.pharmacotherapyList p"
								+ " where p.id = :patientId AND p.status=0");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	@Override
	public PatientEntity getPatientByIdWithSeizureList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.seizureList s"
								+ " where p.id = :patientId AND s.status=0");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

}
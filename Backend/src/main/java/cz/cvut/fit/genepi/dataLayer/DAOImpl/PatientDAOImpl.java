package cz.cvut.fit.genepi.dataLayer.DAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO;
import cz.cvut.fit.genepi.dataLayer.entity.AdvancedSearchEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

/**
 * Implementation of PatientDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class PatientDAOImpl extends GenericDAOImpl<PatientEntity> implements
		PatientDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO#getPatientByIdWithAllLists
	 * (int)
	 */
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
						+ " left join fetch p.neuropsychologyList"
						+ " left join fetch p.neuropsychologyOldList"
						+ " left join fetch p.operationList "
						+ " left join fetch p.outcomeList"
						+ " left join fetch p.pharmacotherapyList"
						+ " left join fetch p.seizureList"
						+ " where p.id = :patientId");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO#getPatientByIdWithAnamnesisList
	 * (int)
	 */
	@Override
	public PatientEntity getPatientByIdWithAnamnesisList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.anamnesisList"
								+ " where p.id = :patientId");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO#
	 * getPatientByIdWithComplicationList(int)
	 */
	@Override
	public PatientEntity getPatientByIdWithComplicationList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.complicationList"
								+ " where p.id = :patientId");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO#
	 * getPatientByIdWithDiagnosticTestScalpEEGList(int)
	 */
	@Override
	public PatientEntity getPatientByIdWithDiagnosticTestScalpEEGList(
			int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.diagnosticTestScalpEEGList"
								+ " where p.id = :patientId");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO#
	 * getPatientByIdWithDiagnosticTestMRIList(int)
	 */
	@Override
	public PatientEntity getPatientByIdWithDiagnosticTestMRIList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.diagnosticTestMRIList"
								+ " where p.id = :patientId");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	@Override
	public PatientEntity getPatientByIdWithHistologyList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.histologyList"
								+ " where p.id = :patientId");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO#
	 * getPatientByIdWithInvasiveTestCorticalMappingList(int)
	 */
	@Override
	public PatientEntity getPatientByIdWithInvasiveTestCorticalMappingList(
			int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.invasiveTestCorticalMappingList"
								+ " where p.id = :patientId");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	@Override
	public PatientEntity getPatientByIdWithInvasiveTestECOGList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.invasiveTestECOGList"
								+ " where p.id = :patientId");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO#
	 * getPatientByIdWithInvasiveTestEEGList(int)
	 */
	@Override
	public PatientEntity getPatientByIdWithInvasiveTestEEGList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.invasiveTestEEGList"
								+ " where p.id = :patientId");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO#
	 * getPatientByIdWithNeurologicalFindingList(int)
	 */
	@Override
	public PatientEntity getPatientByIdWithNeurologicalFindingList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.neurologicalFindingList"
								+ " where p.id = :patientId ");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO#
	 * getPatientByIdWithNeuropsychologyList(int)
	 */
	@Override
	public PatientEntity getPatientByIdWithNeuropsychologyList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.neuropsychologyList"
								+ " where p.id = :patientId");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO#
	 * getPatientByIdWithNeuropsychologyOldList(int)
	 */
	@Override
	public PatientEntity getPatientByIdWithNeuropsychologyOldList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.neuropsychologyOldList"
								+ " where p.id = :patientId");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO#getPatientByIdWithOperationList
	 * (int)
	 */
	@Override
	public PatientEntity getPatientByIdWithOperationList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.operationList"
								+ " where p.id = :patientId");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO#getPatientByIdWithOutcomeList
	 * (int)
	 */
	@Override
	public PatientEntity getPatientByIdWithOutcomeList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.outcomeList"
								+ " where p.id = :patientId");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO#
	 * getPatientByIdWithPharmacotherapyList(int)
	 */
	@Override
	public PatientEntity getPatientByIdWithPharmacotherapyList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.pharmacotherapyList"
								+ " where p.id = :patientId");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO#getPatientByIdWithSeizureList
	 * (int)
	 */
	@Override
	public PatientEntity getPatientByIdWithSeizureList(int patientId) {
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(
						"select p from PatientEntity p left join fetch p.doctor left join fetch p.seizureList"
								+ " where p.id = :patientId");
		query.setParameter("patientId", patientId);
		return this.findOne(query);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO#performSearch(cz.cvut.fit
	 * .genepi.dataLayer.entity.AdvancedSearchEntity)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PatientEntity> performSearch(AdvancedSearchEntity advancedSearch) {
		Criteria criteria = sessionFactory.getCurrentSession()
				.createCriteria(PatientEntity.class, "patient")
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		;

		/* fetching and creating aliases for sub collections */

		/* Setting criterias from search */

		/* General parameters - specific person section */

		/* Fetching and creating alias for sub collection contact */
		criteria.setFetchMode("patient.contact", FetchMode.JOIN);
		criteria.createAlias("patient.contact", "contact");

		/* Firstname */
		if (!advancedSearch.getPatientFirstname().equals("")) {
			criteria.add(Restrictions.like("contact.firstName", "%"
					+ advancedSearch.getPatientFirstname() + "%"));
		}

		/* Lastname */
		if (!advancedSearch.getPatientLastname().equals("")) {
			criteria.add(Restrictions.like("contact.lastName", "%"
					+ advancedSearch.getPatientLastname() + "%"));
		}

		/* Birth number */
		if (!advancedSearch.getPatientNin().equals("")) {
			criteria.add(Restrictions.like("contact.nin",
					advancedSearch.getPatientNin() + "%"));
		}

		/* Town */
		if (!advancedSearch.getPatientTown().equals("")) {
			criteria.add(Restrictions.like("contact.addressTown",
					advancedSearch.getPatientTown() + "%"));
		}

		/* Country */
		if (!advancedSearch.getPatientCountry().equals("")) {
			criteria.add(Restrictions.like("contact.addressCountry",
					advancedSearch.getPatientCountry() + "%"));
		}

		/* General parameters section */

		/* Gender */
		if (advancedSearch.getPatientGender().equals("F")) {
			criteria.add(Restrictions.eq("gender", "female"));
		} else if (advancedSearch.getPatientGender().equals("M")) {
			criteria.add(Restrictions.eq("gender", "male"));
		}

		/* Age of patient */
		if (!advancedSearch.getPatientAge().equals("")) {
			/* calculating years */
			LocalDate now = new LocalDate();
			LocalDate dateBeforeInput = now.minusYears(Integer
					.parseInt(advancedSearch.getPatientAge()));
			LocalDate dateBeforeInputPlusOneYear = now.minusYears(Integer
					.parseInt(advancedSearch.getPatientAge()) + 1);

			if (advancedSearch.getPatientAgeFilter().equals("=")) {
				criteria.add(Restrictions.gt("birthday",
						dateBeforeInputPlusOneYear.toDate()));
				criteria.add(Restrictions.le("birthday",
						dateBeforeInput.toDate()));
			} else if (advancedSearch.getPatientAgeFilter().equals(">")) {
				criteria.add(Restrictions.le("birthday",
						dateBeforeInputPlusOneYear.toDate()));
			} else if (advancedSearch.getPatientAgeFilter().equals("<")) {
				criteria.add(Restrictions.gt("birthday",
						dateBeforeInput.toDate()));
			} else if (advancedSearch.getPatientAgeFilter().equals(">=")) {
				criteria.add(Restrictions.le("birthday",
						dateBeforeInput.toDate()));
			} else if (advancedSearch.getPatientAgeFilter().equals("<=")) {
				criteria.add(Restrictions.ge("birthday",
						dateBeforeInput.toDate()));
			}
		}

		/* Age when epilepsy began */
		if (!advancedSearch.getPatientAgeEpilepsy().equals("")) {
			/* calculating years */
			LocalDate now = new LocalDate();
			LocalDate dateBeforeInput = now.minusYears(Integer
					.parseInt(advancedSearch.getPatientAgeEpilepsy()));
			LocalDate dateBeforeInputPlusOneYear = now.minusYears(Integer
					.parseInt(advancedSearch.getPatientAgeEpilepsy()) + 1);

			if (advancedSearch.getPatientAgeEpilepsyFilter().equals("=")) {
				criteria.add(Restrictions.gt("birthday",
						dateBeforeInputPlusOneYear.toDate()));
				criteria.add(Restrictions.le("birthday",
						dateBeforeInput.toDate()));
			} else if (advancedSearch.getPatientAgeEpilepsyFilter().equals(">")) {
				criteria.add(Restrictions.le("birthday",
						dateBeforeInputPlusOneYear.toDate()));
			} else if (advancedSearch.getPatientAgeEpilepsyFilter().equals("<")) {
				criteria.add(Restrictions.gt("birthday",
						dateBeforeInput.toDate()));
			} else if (advancedSearch.getPatientAgeEpilepsyFilter()
					.equals(">=")) {
				criteria.add(Restrictions.le("birthday",
						dateBeforeInput.toDate()));
			} else if (advancedSearch.getPatientAgeEpilepsyFilter()
					.equals("<=")) {
				criteria.add(Restrictions.ge("birthday",
						dateBeforeInput.toDate()));
			}
		}

		/* Fetching and creating alias for sub collection doctor */
		criteria.setFetchMode("patient.doctor", FetchMode.JOIN);
		criteria.createAlias("patient.doctor", "doctor");

		if (advancedSearch.getPatientDoctor() != 0) {
			criteria.add(Restrictions.eq("doctor.id",
					advancedSearch.getPatientDoctor()));
		}
		/* Include parameters from section */
		// ...

		/* anamnesis specific section */

		/* Fetching and creating alias for sub collection contact anamnesisList */
		criteria.createAlias("patient.anamnesisList", "anamnesisList",
				JoinType.LEFT_OUTER_JOIN);

		if (advancedSearch.getAnamnesisEpilepsyInFamily() != 0) {
			if (advancedSearch.getAnamnesisEpilepsyInFamily() == 1) {
				criteria.add(Restrictions.eq("anamnesisList.epilepsyInFamily",
						true));
			} else {
				criteria.add(Restrictions.eq("anamnesisList.epilepsyInFamily",
						false));
			}
		}

		return (List<PatientEntity>) criteria.list();
	}
}
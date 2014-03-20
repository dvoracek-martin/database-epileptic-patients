package cz.cvut.fit.genepi.dataLayer.DAOImpl;

import cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO;
import cz.cvut.fit.genepi.dataLayer.entity.AdvancedSearchEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        Criteria criteria = sessionFactory
                .getCurrentSession()
                .createCriteria(PatientEntity.class)
                .setFetchMode("doctor", FetchMode.JOIN)
                .setFetchMode("anamnesisList", FetchMode.JOIN)
                .setFetchMode("complicationList", FetchMode.JOIN)
                .setFetchMode("diagnosticTestScalpEegList", FetchMode.JOIN)
                .setFetchMode("diagnosticTestMRIList", FetchMode.JOIN)
                .setFetchMode("histologyList", FetchMode.JOIN)
                .setFetchMode("invasiveTestCorticalMappingList", FetchMode.JOIN)
                .setFetchMode("invasiveTestECOGList", FetchMode.JOIN)
                .setFetchMode("invasiveTestEEGList", FetchMode.JOIN)
                .setFetchMode("neurologicalFindingList", FetchMode.JOIN)
                .setFetchMode("neuropsychologyList", FetchMode.JOIN)
                .setFetchMode("neuropsychologyOldList", FetchMode.JOIN)
                .setFetchMode("operationList", FetchMode.JOIN)
                .setFetchMode("pharmacotherapyList", FetchMode.JOIN)
                .setFetchMode("seizureList", FetchMode.JOIN);

        return (PatientEntity) criteria.uniqueResult();
/*
        Query query = sessionFactory
                .getCurrentSession()
                .createQuery(
                        "select p from PatientEntity p"
                                + " left join fetch p.doctor"
                                + " left join fetch p.anamnesisList anList"
                                + " left join fetch p.complicationList coList"
                                + " left join fetch p.diagnosticTestScalpEegList dtseList"
                                + " left join fetch p.diagnosticTestMRIList dtmList"
                                + " left join fetch p.histologyList hiList"
                                + " left join fetch p.invasiveTestCorticalMappingList itcmList"
                                + " left join fetch p.invasiveTestECOGList itecList"
                                + " left join fetch p.invasiveTestEEGList iteeList"
                                + " left join fetch p.neurologicalFindingList nfList"
                                + " left join fetch p.neuropsychologyList neList"
                                + " left join fetch p.neuropsychologyOldList noList"
                                + " left join fetch p.operationList opList"
                                + " left join fetch p.outcomeList ouList"
                                + " left join fetch p.pharmacotherapyList phList"
                                + " left join fetch p.seizureList seList"
                                + " left join fetch seList.seizureDetailList sdList"
                                + " where p.id = :patientId");*/
                        /*+ " AND ((anList.history = false) OR anList = NULL)"
                        + " AND ((coList.hidden = false AND coList.history = false) OR coList = NULL)"
                        + " AND ((dtseList.hidden = false AND dtseList.history = false) OR dtseList = NULL)"
                        + " AND ((dtmList.hidden = false AND dtmList.history = false) OR dtmList = NULL)"
                        + " AND ((hiList.hidden = false AND hiList.history = false) OR hiList = NULL)"
                        + " AND ((itcmList.hidden = false AND itcmList.history = false) OR itcmList = NULL)"
                        + " AND ((itecList.hidden = false AND itecList.history = false) OR itecList = NULL)"
                        + " AND ((iteeList.hidden = false AND iteeList.history = false) OR iteeList = NULL)"
                        + " AND ((nfList.hidden = false AND nfList.history = false) OR nfList = NULL)"
                        + " AND ((neList.hidden = false AND neList.history = false) OR neList = NULL)"
                        + " AND ((noList.hidden = false AND noList.history = false) OR noList = NULL)"
                        + " AND ((opList.hidden = false AND opList.history = false) OR opList = NULL)"
                        + " AND ((ouList.history = false) OR ouList = NULL)"
                        + " AND ((phList.hidden = false AND phList.history = false) OR phList = NULL)"
                        + " AND ((seList.hidden = false AND seList.history = false) OR seList = NULL)"
                        + " AND ((sdList.hidden = false AND sdList.history = false) OR sdList = NULL)");*/
      /*  query.setParameter("patientId", patientId);
        return (PatientEntity) query.uniqueResult();*/
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
        Session session = sessionFactory
                .getCurrentSession();
        //session.enableFilter("nonHidden");
        Query query = session
                .createQuery(
                        "FROM PatientEntity p LEFT JOIN FETCH p.doctor LEFT JOIN FETCH p.anamnesisList aList"
                                + " WHERE p.id = :patientId"
                );// AND ((aList.history = false) OR aList = NULL)");
        query.setParameter("patientId", patientId);
        return (PatientEntity) query.uniqueResult();
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
                        "from PatientEntity p left join fetch p.doctor left join fetch p.complicationList cList"
                                + " where p.id = :patientId"
                );//" AND ((cList.hidden = false AND cList.history = false) OR cList = NULL)");
        query.setParameter("patientId", patientId);
        return (PatientEntity) query.uniqueResult();
    }

    /*
     * (non-Javadoc)
     *
     * @see cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO#
     * getPatientByIdWithDiagnosticTestScalpEegList(int)
     */
    @Override
    public PatientEntity getPatientByIdWithDiagnosticTestScalpEegList(
            int patientId) {
        Query query = sessionFactory
                .getCurrentSession()
                .createQuery(
                        "select p from PatientEntity p left join fetch p.doctor left join fetch p.diagnosticTestScalpEegList dtseList"
                                + " where p.id = :patientId"
                );// AND ((dtseList.hidden = false AND dtseList.history = false) OR dtseList = NULL)");
        query.setParameter("patientId", patientId);
        return (PatientEntity) query.uniqueResult();
    }

    /*
     * (non-Javadoc)
     *
     * @see cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO#
     * getPatientByIdWithDiagnosticTestMriList(int)
     */
    @Override
    public PatientEntity getPatientByIdWithDiagnosticTestMriList(int patientId) {
        Query query = sessionFactory
                .getCurrentSession()
                .createQuery(
                        "select p from PatientEntity p left join fetch p.doctor left join fetch p.diagnosticTestMRIList dtmList"
                                + " where p.id = :patientId"
                );// AND ((dtmList.hidden = false AND dtmList.history = false) OR dtmList = NULL)");
        query.setParameter("patientId", patientId);
        return (PatientEntity) query.uniqueResult();
    }

    @Override
    public PatientEntity getPatientByIdWithHistologyList(int patientId) {
        Query query = sessionFactory
                .getCurrentSession()
                .createQuery(
                        "select p from PatientEntity p left join fetch p.doctor left join fetch p.histologyList hList"
                                + " where p.id = :patientId"
                );//AND ((hList.hidden = false AND hList.history = false) OR hList = NULL)");
        query.setParameter("patientId", patientId);
        return (PatientEntity) query.uniqueResult();
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
                        "select p from PatientEntity p left join fetch p.doctor left join fetch p.invasiveTestCorticalMappingList itcmList"
                                + " where p.id = :patientId"
                );//AND ((itcmList.hidden = false AND itcmList.history = false) OR itcmList = NULL)");
        query.setParameter("patientId", patientId);
        return (PatientEntity) query.uniqueResult();
    }

    @Override
    public PatientEntity getPatientByIdWithInvasiveTestEcogList(int patientId) {
        Query query = sessionFactory
                .getCurrentSession()
                .createQuery(
                        "select p from PatientEntity p left join fetch p.doctor left join fetch p.invasiveTestECOGList iteList"
                                + " where p.id = :patientId"
                );//AND ((iteList.hidden = false AND iteList.history = false) OR iteList = NULL)");
        query.setParameter("patientId", patientId);
        return (PatientEntity) query.uniqueResult();
    }

    /*
     * (non-Javadoc)
     *
     * @see cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO#
     * getPatientByIdWithInvasiveTestEegList(int)
     */
    @Override
    public PatientEntity getPatientByIdWithInvasiveTestEegList(int patientId) {
        Query query = sessionFactory
                .getCurrentSession()
                .createQuery(
                        "select p from PatientEntity p left join fetch p.doctor left join fetch p.invasiveTestEEGList iteList"
                                + " where p.id = :patientId"
                );//AND ((iteList.hidden = false AND iteList.history = false) OR iteList = NULL)");
        query.setParameter("patientId", patientId);
        return (PatientEntity) query.uniqueResult();
    }

    /*
     * (non-Javadoc)
     *
     * @see cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO#
     * getPatientByIdWithNeurologicalFindingList(int)
     */
    @Override
    @Transactional
    public PatientEntity getPatientByIdWithNeurologicalFindingList(int patientId) {
      /*  Query query = sessionFactory
                .getCurrentSession()
                .createQuery(
                        "FROM PatientEntity patient LEFT JOIN FETCH patient.doctor LEFT JOIN FETCH patient.neurologicalFindingList nfList"
                                + " WHERE patient.id = :patientId");//AND ((nfList.hidden = false AND nfList.history = false) OR nfList = NULL)");
        query.setParameter("patientId", patientId);
        PatientEntity patient = (PatientEntity) query.uniqueResult();*/


        Criteria criteria = sessionFactory.getCurrentSession()
                .createCriteria(PatientEntity.class);

        criteria.setFetchMode("doctor", FetchMode.JOIN);
        // criteria.setFetchMode("contact", FetchMode.JOIN);
        criteria.setFetchMode("neurologicalFindingList", FetchMode.JOIN);
        criteria.add(Restrictions.eq("id", patientId));

        PatientEntity patient = (PatientEntity) criteria.uniqueResult();

        return patient;
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
                        "select p from PatientEntity p left join fetch p.doctor left join fetch p.neuropsychologyList nList"
                                + " where p.id = :patientId"
                );//AND ((nList.hidden = false AND nList.history = false) OR nList = NULL)");
        query.setParameter("patientId", patientId);
        return (PatientEntity) query.uniqueResult();
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
                        "select p from PatientEntity p left join fetch p.doctor left join fetch p.neuropsychologyOldList noList"
                                + " where p.id = :patientId"
                );//AND ((noList.hidden = false AND noList.history = false) OR noList = NULL)");
        query.setParameter("patientId", patientId);
        return (PatientEntity) query.uniqueResult();
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
                        "select p from PatientEntity p left join fetch p.doctor left join fetch p.operationList oList"
                                + " where p.id = :patientId"
                );//AND ((oList.hidden = false AND oList.history = false) OR oList = NULL)");
        query.setParameter("patientId", patientId);
        return (PatientEntity) query.uniqueResult();
    }

    @Override
    public PatientEntity getPatientByIdWithOperationWithOutcomeList(int patientId) {
        Query query = sessionFactory
                .getCurrentSession()
                .createQuery(
                        "select p from PatientEntity p left join fetch p.doctor left join fetch p.operationList left join fetch p.operationList"//TODO:join outcomes
                                + " where p.id = :patientId"
                );
        query.setParameter("patientId", patientId);
        return (PatientEntity) query.uniqueResult();
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
                                + " where p.id = :patientId"
                );
        query.setParameter("patientId", patientId);
        return (PatientEntity) query.uniqueResult();
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
                        "select p from PatientEntity p left join fetch p.doctor left join fetch p.pharmacotherapyList pList"
                                + " where p.id = :patientId"
                );//AND ((pList.hidden = false AND pList.history = false) OR pList = NULL)");
        query.setParameter("patientId", patientId);
        return (PatientEntity) query.uniqueResult();
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
                        "select p from PatientEntity p left join fetch p.doctor left join fetch p.seizureList sList" +
                                " left join fetch sList.seizureDetailList sdList"
                                + " where p.id = :patientId" /*+
                                " AND ((sList.hidden = false AND sList.history = false) OR sList = NULL)" +
                                "AND ((sdList.hidden = false AND sdList.history = false) OR sdList = NULL)"*/
                );
        query.setParameter("patientId", patientId);
        return (PatientEntity) query.uniqueResult();
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

    @Override
    public PatientEntity getPatientByIdWithDoctor(int patientId) {
        Query query = sessionFactory
                .getCurrentSession()
                .createQuery(
                        "select p from PatientEntity p left join fetch p.doctor"
                                + " where p.id = :patientId"
                );
        query.setParameter("patientId", patientId);
        return (PatientEntity) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PatientEntity> findAllHidden() {
        Query query = sessionFactory
                .getCurrentSession()
                .createQuery("from PatientEntity p left join fetch p.doctor where p.status = 1");

        return query.list();
    }

    @Override
    public List<PatientEntity> findAllWithHiddenRecords() {
        Query query = sessionFactory
                .getCurrentSession()
                .createQuery(
                        "select p from PatientEntity p"
                                + " left join fetch p.complicationList coList"
                                + " left join fetch p.diagnosticTestScalpEegList dtseList"
                                + " left join fetch p.diagnosticTestMRIList dtmList"
                                + " left join fetch p.histologyList hiList"
                                + " left join fetch p.invasiveTestCorticalMappingList itcmList"
                                + " left join fetch p.invasiveTestECOGList itecList"
                                + " left join fetch p.invasiveTestEEGList iteeList"
                                + " left join fetch p.neurologicalFindingList nfList"
                                + " left join fetch p.neuropsychologyList neList"
                                + " left join fetch p.neuropsychologyOldList noList"
                                + " left join fetch p.operationList opList"
                                + " left join fetch p.pharmacotherapyList phList"
                                + " left join fetch p.seizureList seList"
                                + " left join fetch seList.seizureDetailList sdList"
                                + " where p.status = 0"
                                + " AND ((coList.hidden = true AND coList.history = false) OR coList = NULL)"
                                + " AND ((dtseList.hidden = true AND dtseList.history = false) OR dtseList = NULL)"
                                + " AND ((dtmList.hidden = true AND dtmList.history = false) OR dtmList = NULL)"
                                + " AND ((hiList.hidden = true AND hiList.history = false) OR hiList = NULL)"
                                + " AND ((itcmList.hidden = true AND itcmList.history = false) OR itcmList = NULL)"
                                + " AND ((itecList.hidden = true AND itecList.history = false) OR itecList = NULL)"
                                + " AND ((iteeList.hidden = true AND iteeList.history = false) OR iteeList = NULL)"
                                + " AND ((nfList.hidden = true AND nfList.history = false) OR nfList = NULL)"
                                + " AND ((neList.hidden = true AND neList.history = false) OR neList = NULL)"
                                + " AND ((noList.hidden = true AND noList.history = false) OR noList = NULL)"
                                + " AND ((opList.hidden = true AND opList.history = false) OR opList = NULL)"
                                + " AND ((phList.hidden = true AND phList.history = false) OR phList = NULL)"
                                + " AND ((seList.hidden = true AND seList.history = false) OR seList = NULL)"
                                + " AND ((sdList.hidden = true AND sdList.history = false) OR sdList = NULL)"
                );
        return query.list();
    }

    public int getCountOfUnhidden(String searchString) {
        Long count = ((Long) sessionFactory
                .getCurrentSession()
                .createQuery("select count(id) " +
                        "from PatientEntity" +
                        " where status=0 AND (contact.firstName like '" + searchString + "%'" +
                        " OR contact.lastName like '" + searchString + "%'" +
                        " OR nin like '" + searchString + "%')")
                .uniqueResult());

        return count.intValue();
    }

    @SuppressWarnings("unchecked")
    public List<PatientEntity> findByNameWithPagination(int maxResults, int pageNumber, List<String> parameters, String name) {

        String q = "from PatientEntity where status=0 AND (";
        for (int i = 0; i != parameters.size(); i++) {
            q += parameters.get(i) + " like '" + name + "%'";
            if (i != parameters.size() - 1) {
                q += " or ";
            }
        }
        q += ") ORDER BY contact.lastName, contact.firstName";

        Query query = sessionFactory
                .getCurrentSession()
                .createQuery(q)
                .setFirstResult(maxResults * (pageNumber - 1))
                .setMaxResults(maxResults);

        return (List<PatientEntity>) query.list();
    }
}
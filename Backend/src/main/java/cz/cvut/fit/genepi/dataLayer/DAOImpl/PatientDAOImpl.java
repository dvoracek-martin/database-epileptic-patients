package cz.cvut.fit.genepi.dataLayer.DAOImpl;

import cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO;
import cz.cvut.fit.genepi.dataLayer.entity.AdvancedSearchEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of PatientDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class PatientDAOImpl
        extends GenericDAOImpl<PatientEntity>
        implements PatientDAO {

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
                .setFetchMode("seizureList", FetchMode.JOIN)
                .add(Restrictions.eq("id", patientId));

        return (PatientEntity) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PatientEntity> performSearch(AdvancedSearchEntity advancedSearch) {

        Criteria criteria = sessionFactory.getCurrentSession()
                .createCriteria(PatientEntity.class, "patient")
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

        /* search in non hidden only */
        criteria.add(Restrictions.eq("status", 0));

        /* alias for contact */
        criteria.createAlias("patient.contact", "contact", JoinType.LEFT_OUTER_JOIN);

        /* General parameters - Specific person section */

        /* first name */
        if (!advancedSearch.getPatientFirstname().equals("")) {
            criteria.add(Restrictions.like("contact.firstName", "%" + advancedSearch.getPatientFirstname() + "%"));
        }

        /* last name */
        if (!advancedSearch.getPatientLastname().equals("")) {
            criteria.add(Restrictions.like("contact.lastName", "%" + advancedSearch.getPatientLastname() + "%"));
        }

		/* birth number */
        if (!advancedSearch.getPatientNin().equals("")) {
            criteria.add(Restrictions.like("nin", advancedSearch.getPatientNin() + "%"));
        }

		/* city */
        if (!advancedSearch.getPatientCity().equals("")) {
            criteria.add(Restrictions.like("contact.addressCity", advancedSearch.getPatientCity() + "%"));
        }

		/* Country */
        if (!advancedSearch.getPatientCountry().equals("")) {
            criteria.add(Restrictions.like("contact.addressCountry",
                    advancedSearch.getPatientCountry() + "%"));
        }

		/* General parameters section */

		/* gender */
        if (advancedSearch.getPatientGender() == 1) {
            criteria.add(Restrictions.eq("gender", 1));
        } else if (advancedSearch.getPatientGender() == 2) {
            criteria.add(Restrictions.eq("gender", 2));
        }

		/* age of patient */
        if (!advancedSearch.getPatientAge().equals("")) {
            /* calculating years */
            LocalDate now = new LocalDate();
            LocalDate dateBeforeInput = now.minusYears(Integer.parseInt(advancedSearch.getPatientAge()));
            LocalDate dateBeforeInputPlusOneYear = now.minusYears(Integer.parseInt(advancedSearch.getPatientAge()) + 1);

            if (advancedSearch.getPatientAgeFilter().equals("=")) {
                criteria.add(Restrictions.gt("birthday", dateBeforeInputPlusOneYear.toDate()));
                criteria.add(Restrictions.le("birthday", dateBeforeInput.toDate()));
            } else if (advancedSearch.getPatientAgeFilter().equals(">")) {
                criteria.add(Restrictions.le("birthday", dateBeforeInputPlusOneYear.toDate()));
            } else if (advancedSearch.getPatientAgeFilter().equals("<")) {
                criteria.add(Restrictions.gt("birthday", dateBeforeInput.toDate()));
            } else if (advancedSearch.getPatientAgeFilter().equals(">=")) {
                criteria.add(Restrictions.le("birthday", dateBeforeInput.toDate()));
            } else if (advancedSearch.getPatientAgeFilter().equals("<=")) {
                criteria.add(Restrictions.ge("birthday", dateBeforeInput.toDate()));
            }
        }

        /* Age when epilepsy began */
        if (!advancedSearch.getPatientAgeEpilepsy().equals("")) {
            /* calculating years */
            LocalDate now = new LocalDate();
            LocalDate dateBeforeInput = now.minusYears(Integer.parseInt(advancedSearch.getPatientAgeEpilepsy()));
            LocalDate dateBeforeInputPlusOneYear = now.minusYears(Integer.parseInt(advancedSearch.getPatientAgeEpilepsy()) + 1);

            if (advancedSearch.getPatientAgeEpilepsyFilter().equals("=")) {
                criteria.add(Restrictions.gt("birthday", dateBeforeInputPlusOneYear.toDate()));
                criteria.add(Restrictions.le("birthday", dateBeforeInput.toDate()));
            } else if (advancedSearch.getPatientAgeEpilepsyFilter().equals(">")) {
                criteria.add(Restrictions.le("birthday", dateBeforeInputPlusOneYear.toDate()));
            } else if (advancedSearch.getPatientAgeEpilepsyFilter().equals("<")) {
                criteria.add(Restrictions.gt("birthday", dateBeforeInput.toDate()));
            } else if (advancedSearch.getPatientAgeEpilepsyFilter().equals(">=")) {
                criteria.add(Restrictions.le("birthday", dateBeforeInput.toDate()));
            } else if (advancedSearch.getPatientAgeEpilepsyFilter().equals("<=")) {
                criteria.add(Restrictions.ge("birthday", dateBeforeInput.toDate()));
            }
        }

		/* Fetching and creating alias for sub collection doctor */
        criteria.createAlias("patient.doctor", "doctor", JoinType.LEFT_OUTER_JOIN);

        if (advancedSearch.getPatientDoctor() != 0) {
            criteria.add(Restrictions.eq("doctor.id", advancedSearch.getPatientDoctor()));
        }

        /* verified */
        if (advancedSearch.isVerified()) {
            criteria.add(Restrictions.eq("verified", true));
        }

		/* anamnesis specific section */

        if (advancedSearch.isAnamnesis()) {
        /* Fetching and creating alias for sub collection anamnesisList */
            criteria.createAlias("patient.anamnesisList", "anamnesisList", JoinType.LEFT_OUTER_JOIN);

            if (advancedSearch.getAnamnesisEpilepsyInFamily() != 3) {
                if (advancedSearch.getAnamnesisEpilepsyInFamily() == 1) {
                    criteria.add(Restrictions.eq("anamnesisList.epilepsyInFamily", true));
                } else {
                    criteria.add(Restrictions.eq("anamnesisList.epilepsyInFamily", false));
                }
            }

            if (advancedSearch.getAnamnesisPrenatalRisk() != 3) {
                if (advancedSearch.getAnamnesisPrenatalRisk() == 1) {
                    criteria.add(Restrictions.eq("anamnesisList.prenatalRisk", true));
                } else {
                    criteria.add(Restrictions.eq("anamnesisList.prenatalRisk", false));
                }
            }

            if (advancedSearch.getAnamnesisFibrilConvulsions() != 3) {
                if (advancedSearch.getAnamnesisFibrilConvulsions() == 1) {
                    criteria.add(Restrictions.eq("anamnesisList.fibrilConvulsions", true));
                } else {
                    criteria.add(Restrictions.eq("anamnesisList.fibrilConvulsions", false));
                }
            }

            if (advancedSearch.getAnamnesisInflammationCns() != 3) {
                if (advancedSearch.getAnamnesisInflammationCns() == 1) {
                    criteria.add(Restrictions.eq("anamnesisList.inflammationCns", true));
                } else {
                    criteria.add(Restrictions.eq("anamnesisList.inflammationCns", false));
                }
            }

            if (advancedSearch.getAnamnesisInjuryCns() != 3) {
                if (advancedSearch.getAnamnesisInjuryCns() == 1) {
                    criteria.add(Restrictions.eq("anamnesisList.injuryCns", true));
                } else {
                    criteria.add(Restrictions.eq("anamnesisList.injuryCns", false));
                }
            }

            if (advancedSearch.getAnamnesisOperationCns() != 3) {
                if (advancedSearch.getAnamnesisOperationCns() == 1) {
                    criteria.add(Restrictions.eq("anamnesisList.operationCns", true));
                } else {
                    criteria.add(Restrictions.eq("anamnesisList.operationCns", false));
                }
            }

            if (advancedSearch.getAnamnesisEarlyPmdRetardation() != 3) {
                if (advancedSearch.getAnamnesisEarlyPmdRetardation() == 1) {
                    criteria.add(Restrictions.eq("anamnesisList.earlyPmdRetardation", true));
                } else {
                    criteria.add(Restrictions.eq("anamnesisList.earlyPmdRetardation", false));
                }
            }

            if (advancedSearch.getAnamnesisFirstFever() != 3) {
                if (advancedSearch.getAnamnesisFirstFever() == 1) {
                    criteria.add(Restrictions.eq("anamnesisList.firstFever", true));
                } else {
                    criteria.add(Restrictions.eq("anamnesisList.firstFever", false));
                }
            }

            if (advancedSearch.getAnamnesisInfantileSpasm() != 3) {
                if (advancedSearch.getAnamnesisInfantileSpasm() == 1) {
                    criteria.add(Restrictions.eq("anamnesisList.infantileSpasm", true));
                } else {
                    criteria.add(Restrictions.eq("anamnesisList.infantileSpasm", false));
                }
            }

            if (advancedSearch.getAnamnesisSpecificSyndrome() != 0) {
                criteria.add(Restrictions.eq("anamnesisList.specificSyndrome", advancedSearch.getAnamnesisSpecificSyndrome()));
            }

        }

        		/* seizure specific section */

        if (advancedSearch.isSeizure()) {
        /* Fetching and creating alias for sub collection seizureList */
            criteria.createAlias("patient.seizureList", "seizureList", JoinType.LEFT_OUTER_JOIN);

            if (advancedSearch.getSeizureSeizureFrequency() != 0) {
                criteria.add(Restrictions.eq("seizureList.seizureFrequency", advancedSearch.getSeizureSeizureFrequency()));
            }

            if (advancedSearch.getSeizureSecondarilyGeneralizedSeizure() != 3) {
                if (advancedSearch.getSeizureSecondarilyGeneralizedSeizure() == 1) {
                    criteria.add(Restrictions.eq("seizureList.secondarilyGeneralizedSeizure", true));
                } else {
                    criteria.add(Restrictions.eq("seizureList.secondarilyGeneralizedSeizure", false));
                }
            }

            if (advancedSearch.getSeizureStatusEpilepticus() != 3) {
                if (advancedSearch.getSeizureStatusEpilepticus() == 1) {
                    criteria.add(Restrictions.eq("seizureList.statusEpilepticus", true));
                } else {
                    criteria.add(Restrictions.eq("seizureList.statusEpilepticus", false));
                }
            }

            if (advancedSearch.getSeizureSeizureOccurence() != 4) {
                criteria.add(Restrictions.eq("seizureList.seizureOccurrence", advancedSearch.getSeizureSeizureOccurence()));
            }

            /* seizure detail specific section */

            if (advancedSearch.getSeizureSscClassification() != 0 ||
                    advancedSearch.getSeizureIlaeClassification() != 0) {

                criteria.createAlias("seizureList.seizureDetailList", "seizureDetailList", JoinType.LEFT_OUTER_JOIN);

                if (advancedSearch.getSeizureSscClassification() != 0) {
                    criteria.add(Restrictions.eq("seizureDetailList.sscClassification", advancedSearch.getSeizureSscClassification()));
                }

                if (advancedSearch.getSeizureIlaeClassification() != 0) {
                    criteria.add(Restrictions.eq("seizureDetailList.ilaeClassification", advancedSearch.getSeizureIlaeClassification()));
                }
            }

        }

        /* pharmacotherapy specific section */
        if (advancedSearch.isPharmacotherapy()) {
               /* Fetching and creating alias for sub collection pharmacotherapyList */
            criteria.createAlias("patient.pharmacotherapyList", "pharmacotherapyList", JoinType.LEFT_OUTER_JOIN);

            if (!advancedSearch.getPharmacotherapyAed().equals("[]")) {

                String str = advancedSearch.getPharmacotherapyAed().replaceAll("[^\\d,]", "");
                String[] numbers = str.split(",");
                List<Integer> ints = new ArrayList<>();
                for (String number : numbers) {
                    ints.add(Integer.parseInt(number));
                }

                criteria.add(Restrictions.in("pharmacotherapyList.aed", ints));
            }
        }

             /* neurological finding specific section */
        if (advancedSearch.isNeurologicalFinding()) {
               /* Fetching and creating alias for sub collection neurologicalFindingList */
            criteria.createAlias("patient.neurologicalFindingList", "neurologicalFindingList", JoinType.LEFT_OUTER_JOIN);


            if (advancedSearch.getNeurologicalFindingHemisphereDominance() != 0) {
                criteria.add(Restrictions.eq("neurologicalFindingList.hemisphereDominance", advancedSearch.getNeurologicalFindingHemisphereDominance()));
            }

            if (advancedSearch.getNeurologicalFindingAbnormalNeurologicalFinding() != 3) {
                if (advancedSearch.getNeurologicalFindingAbnormalNeurologicalFinding() == 1) {
                    criteria.add(Restrictions.eq("neurologicalFindingList.abnormalNeurologicalFinding", true));
                } else {
                    criteria.add(Restrictions.eq("neurologicalFindingList.abnormalNeurologicalFinding", false));
                }
            }

            if (advancedSearch.getNeurologicalFindingHemiparesis() != 3) {
                if (advancedSearch.getNeurologicalFindingHemiparesis() == 1) {
                    criteria.add(Restrictions.eq("neurologicalFindingList.hemiparesis", true));
                } else {
                    criteria.add(Restrictions.eq("neurologicalFindingList.hemiparesis", false));
                }
            }

            if (advancedSearch.getNeurologicalFindingVisualFieldDefects() != 3) {
                if (advancedSearch.getNeurologicalFindingVisualFieldDefects() == 1) {
                    criteria.add(Restrictions.eq("neurologicalFindingList.visualFieldDefects", true));
                } else {
                    criteria.add(Restrictions.eq("neurologicalFindingList.visualFieldDefects", false));
                }
            }
        }

          /* neuropsychology specific section */
        if (advancedSearch.isNeuropsychology()) {

        }

             /* diagnostic test scalp eeg specific section */
        if (advancedSearch.isDiagnosticTestScalpEeg()) {
     /* Fetching and creating alias for sub collection diagnosticTestScalpEegList */
            criteria.createAlias("patient.diagnosticTestScalpEegList", "diagnosticTestScalpEegList", JoinType.LEFT_OUTER_JOIN);


            if (advancedSearch.getDiagnosticTestScalpEegBasicEegActivity() != 0) {
                criteria.add(Restrictions.eq("diagnosticTestScalpEegList.basicEegActivity", advancedSearch.getDiagnosticTestScalpEegBasicEegActivity()));
            }

            if (advancedSearch.getDiagnosticTestScalpEegEegSlow() != 0) {
                criteria.add(Restrictions.eq("diagnosticTestScalpEegList.eegSlow", advancedSearch.getDiagnosticTestScalpEegEegSlow()));
            }

            if (advancedSearch.getDiagnosticTestScalpEegInterictalEegSpikes() != 0) {
                criteria.add(Restrictions.eq("diagnosticTestScalpEegList.interictalEegSpikes", advancedSearch.getDiagnosticTestScalpEegInterictalEegSpikes()));
            }

            if (advancedSearch.getDiagnosticTestScalpEegEegStatusEpilepticus() != 3) {
                if (advancedSearch.getDiagnosticTestScalpEegEegStatusEpilepticus() == 1) {
                    criteria.add(Restrictions.eq("diagnosticTestScalpEegList.eegStatusEpilepticus", true));
                } else {
                    criteria.add(Restrictions.eq("diagnosticTestScalpEegList.eegStatusEpilepticus", false));
                }
            }

            if (advancedSearch.getDiagnosticTestScalpEegSecondarySidedSynchrony() != 3) {
                if (advancedSearch.getDiagnosticTestScalpEegSecondarySidedSynchrony() == 1) {
                    criteria.add(Restrictions.eq("diagnosticTestScalpEegList.secondarySidedSynchrony", true));
                } else {
                    criteria.add(Restrictions.eq("diagnosticTestScalpEegList.secondarySidedSynchrony", false));
                }
            }

            if (advancedSearch.getDiagnosticTestScalpEegIctalEegPatterns() != 0) {
                criteria.add(Restrictions.eq("diagnosticTestScalpEegList.ictalEegPatterns", advancedSearch.getDiagnosticTestScalpEegIctalEegPatterns()));
            }
        }

               /* diagnostic test mri specific section */
        if (advancedSearch.isDiagnosticTestMri()) {
     /* Fetching and creating alias for sub collection diagnosticTestMriList */
            criteria.createAlias("patient.diagnosticTestMRIList", "diagnosticTestMriList", JoinType.LEFT_OUTER_JOIN);

            if (advancedSearch.getDiagnosticTestMriMriFinding() != 0) {
                criteria.add(Restrictions.eq("diagnosticTestMriList.mriFinding", advancedSearch.getDiagnosticTestMriMriFinding()));
            }

            if (advancedSearch.getDiagnosticTestMriFdgPet() != 0) {
                criteria.add(Restrictions.eq("diagnosticTestMriList.fdgPet", advancedSearch.getDiagnosticTestMriFdgPet()));
            }

            if (advancedSearch.getDiagnosticTestMriInterictalSpect() != 0) {
                criteria.add(Restrictions.eq("diagnosticTestMriList.interictalSpect", advancedSearch.getDiagnosticTestMriInterictalSpect()));
            }

            if (advancedSearch.getDiagnosticTestMriSiscom() != 3) {
                if (advancedSearch.getDiagnosticTestMriSiscom() == 1) {
                    criteria.add(Restrictions.eq("diagnosticTestMriList.siscom", true));
                } else {
                    criteria.add(Restrictions.eq("diagnosticTestMriList.siscom", false));
                }
            }

            if (advancedSearch.getDiagnosticTestMriMrsProtocol() != 0) {
                criteria.add(Restrictions.eq("diagnosticTestMriList.mrsProtocol", advancedSearch.getDiagnosticTestMriMrsProtocol()));
            }

            if (advancedSearch.getDiagnosticTestMriMrsFinding() != 0) {
                criteria.add(Restrictions.eq("diagnosticTestMriList.mrsFinding", advancedSearch.getDiagnosticTestMriMrsFinding()));
            }

            if (advancedSearch.getDiagnosticTestMriDti() != 3) {
                if (advancedSearch.getDiagnosticTestMriDti() == 1) {
                    criteria.add(Restrictions.eq("diagnosticTestMriList.dti", true));
                } else {
                    criteria.add(Restrictions.eq("diagnosticTestMriList.dti", false));
                }
            }

            if (advancedSearch.getDiagnosticTestMriFmri() != 3) {
                if (advancedSearch.getDiagnosticTestMriFmri() == 1) {
                    criteria.add(Restrictions.eq("diagnosticTestMriList.fmri", true));
                } else {
                    criteria.add(Restrictions.eq("diagnosticTestMriList.fmri", false));
                }
            }

            if (advancedSearch.getDiagnosticTestMriWada() != 3) {
                if (advancedSearch.getDiagnosticTestMriWada() == 1) {
                    criteria.add(Restrictions.eq("diagnosticTestMriList.wada", true));
                } else {
                    criteria.add(Restrictions.eq("diagnosticTestMriList.wada", false));
                }
            }
        }

                       /* invasive test eeg specific section */
        if (advancedSearch.isInvasiveTestEeg()) {
     /* Fetching and creating alias for sub collection invasiveTestEegList */
            criteria.createAlias("patient.invasiveTestEEGList", "invasiveTestEegList", JoinType.LEFT_OUTER_JOIN);

            if (advancedSearch.getInvasiveTestEegIntracranialElectrodes() != 0) {
                criteria.add(Restrictions.eq("invasiveTestEegList.intracranialElectrodes", advancedSearch.getInvasiveTestEegIntracranialElectrodes()));
            }

            if (advancedSearch.getInvasiveTestEegInvasiveEegSlow() != 0) {
                criteria.add(Restrictions.eq("invasiveTestEegList.invasiveEegSlow", advancedSearch.getInvasiveTestEegInvasiveEegSlow()));
            }

            if (advancedSearch.getInvasiveTestEegInvasiveEegInterictalSpikes() != 0) {
                criteria.add(Restrictions.eq("invasiveTestEegList.invasiveEegInterictalSpikes", advancedSearch.getInvasiveTestEegInvasiveEegInterictalSpikes()));
            }

            if (advancedSearch.getInvasiveTestEegInvasiveEegStatusEpilepticus() != 3) {
                if (advancedSearch.getInvasiveTestEegInvasiveEegStatusEpilepticus() == 1) {
                    criteria.add(Restrictions.eq("invasiveTestEegList.invasiveEegStatusEpilepticus", true));
                } else {
                    criteria.add(Restrictions.eq("invasiveTestEegList.invasiveEegStatusEpilepticus", false));
                }
            }

            if (advancedSearch.getInvasiveTestEegInvasiveIctalEegPatterns() != 0) {
                criteria.add(Restrictions.eq("invasiveTestEegList.invasiveIctalEegPatterns", advancedSearch.getInvasiveTestEegInvasiveIctalEegPatterns()));
            }
        }

                              /* invasive test ecog specific section */
        if (advancedSearch.isInvasiveTestEcog()) {
     /* Fetching and creating alias for sub collection invasiveTestEcogList */
            criteria.createAlias("patient.invasiveTestECOGList", "invasiveTestEcogList", JoinType.LEFT_OUTER_JOIN);

            if (advancedSearch.getInvasiveTestEcogEcogPatterns() != 0) {
                criteria.add(Restrictions.eq("invasiveTestEcogList.ecogPatterns", advancedSearch.getInvasiveTestEcogEcogPatterns()));
            }

            if (advancedSearch.getInvasiveTestEcogAfterResectionEcog() != 0) {
                criteria.add(Restrictions.eq("invasiveTestEcogList.afterResectionEcog", advancedSearch.getInvasiveTestEcogAfterResectionEcog()));
            }
        }

                              /* invasive test corticalMapping specific section */
        if (advancedSearch.isInvasiveTestCorticalMapping()) {
     /* Fetching and creating alias for sub collection invasiveTestCorticalMappingList */
            criteria.createAlias("patient.invasiveTestCorticalMappingList", "invasiveTestCorticalMappingList", JoinType.LEFT_OUTER_JOIN);
        }

                            /* operation specific section */
        if (advancedSearch.isOperation()) {
     /* Fetching and creating alias for sub collection operationList */
            criteria.createAlias("patient.operationList", "operationList", JoinType.LEFT_OUTER_JOIN);

            if (advancedSearch.getOperationTypeOperation() != 0) {
                criteria.add(Restrictions.eq("operationList.typeOperation", advancedSearch.getOperationTypeOperation()));
            }

            if (advancedSearch.getOperationRangeOperation() != 0) {
                criteria.add(Restrictions.eq("operationList.rangeOperation", advancedSearch.getOperationRangeOperation()));
            }

            if (advancedSearch.getOperationMst() != 3) {
                if (advancedSearch.getOperationMst() == 1) {
                    criteria.add(Restrictions.eq("operationList.mst", true));
                } else {
                    criteria.add(Restrictions.eq("operationList.mst", false));
                }
            }

            if (advancedSearch.getOperationColostomy() != 3) {
                if (advancedSearch.getOperationColostomy() == 1) {
                    criteria.add(Restrictions.eq("operationList.colostomy", true));
                } else {
                    criteria.add(Restrictions.eq("operationList.colostomy", false));
                }
            }

            if (advancedSearch.getOperationVns() != 3) {
                if (advancedSearch.getOperationVns() == 1) {
                    criteria.add(Restrictions.eq("operationList.vns", true));
                } else {
                    criteria.add(Restrictions.eq("operationList.vns", false));
                }
            }

            if (advancedSearch.getOperationCompleteResection() != 3) {
                if (advancedSearch.getOperationCompleteResection() == 1) {
                    criteria.add(Restrictions.eq("operationList.completeResection", true));
                } else {
                    criteria.add(Restrictions.eq("operationList.completeResection", false));
                }
            }

        }

                                /* histology specific section */
        if (advancedSearch.isHistology()) {
     /* Fetching and creating alias for sub collection histologyList */
            criteria.createAlias("patient.histologyList", "histologyList", JoinType.LEFT_OUTER_JOIN);

            if (advancedSearch.getHistologyHistopathology() != 0) {
                criteria.add(Restrictions.eq("histologyList.histopathology", advancedSearch.getHistologyHistopathology()));
            }

            if (advancedSearch.getHistologyFcdClassification() != 0) {
                criteria.add(Restrictions.eq("histologyList.fcdClassification", advancedSearch.getHistologyFcdClassification()));
            }
        }

                                    /* complication specific section */
        if (advancedSearch.isComplication()) {
     /* Fetching and creating alias for sub collection complicationList */
            criteria.createAlias("patient.complicationList", "complicationList", JoinType.LEFT_OUTER_JOIN);

            if (advancedSearch.getComplicationComplicationType() != 0) {
                criteria.add(Restrictions.eq("complicationList.complicationType", advancedSearch.getComplicationComplicationType()));
            }

            if (advancedSearch.getComplicationComplication() != 0) {
                criteria.add(Restrictions.eq("complicationList.complication", advancedSearch.getComplicationComplication()));
            }
        }

        if (advancedSearch.isOutcome()) {
     /* Fetching and creating alias for sub collection outcomeList */
            criteria.createAlias("patient.outcomeList", "outcomeList", JoinType.LEFT_OUTER_JOIN);

            if (advancedSearch.getOutcomeSeizureOutcome() != 0) {
                criteria.add(Restrictions.eq("outcomeList.seizureOutcome", advancedSearch.getOutcomeSeizureOutcome()));
            }

            if (advancedSearch.getOutcomeEeg() != 0) {
                criteria.add(Restrictions.eq("outcomeList.eeg", advancedSearch.getOutcomeEeg()));
            }

            if (advancedSearch.getOutcomeAed() != 0) {
                criteria.add(Restrictions.eq("outcomeList.aed", advancedSearch.getOutcomeAed()));
            }

            if (advancedSearch.getOutcomeMri() != 0) {
                criteria.add(Restrictions.eq("outcomeList.mri", advancedSearch.getOutcomeMri()));
            }

            if (advancedSearch.getOutcomeNeuropsychology() != 0) {
                criteria.add(Restrictions.eq("outcomeList.neuropsychology", advancedSearch.getOutcomeNeuropsychology()));
            }

            if (advancedSearch.getOutcomeDistance() != 0) {
                if (advancedSearch.getOutcomeDistanceFilter().equals("=")) {
                    criteria.add(Restrictions.eq("outcomeList.distance", advancedSearch.getOutcomeDistance()));
                } else if (advancedSearch.getOutcomeDistanceFilter().equals(">")) {
                    criteria.add(Restrictions.gt("outcomeList.distance", advancedSearch.getOutcomeDistance()));
                } else if (advancedSearch.getOutcomeDistanceFilter().equals("<")) {
                    criteria.add(Restrictions.lt("outcomeList.distance", advancedSearch.getOutcomeDistance()));
                } else if (advancedSearch.getOutcomeDistanceFilter().equals(">=")) {
                    criteria.add(Restrictions.ge("outcomeList.distance", advancedSearch.getOutcomeDistance()));
                } else if (advancedSearch.getOutcomeDistanceFilter().equals("<=")) {
                    criteria.add(Restrictions.le("outcomeList.distance", advancedSearch.getOutcomeDistance()));
                }
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

    @SuppressWarnings("unchecked")
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

    @SuppressWarnings("unchecked")
    @Override
    public int getCountOfUnhidden(boolean onlyResearcher, String searchString) {
        Long count;
        if (onlyResearcher) {
            if (searchString.isEmpty()) {
                count = ((Long) sessionFactory
                        .getCurrentSession()
                        .createQuery("select count(id) " +
                                "from PatientEntity" +
                                " where status = 0")
                        .uniqueResult());
            } else {
                try {
                    Integer.parseInt(searchString);
                } catch (NumberFormatException e) {
                    return 0;
                }
                count = ((Long) sessionFactory
                        .getCurrentSession()
                        .createQuery("select count(id) " +
                                "from PatientEntity" +
                                " where status = 0 AND id= " + searchString)
                        .uniqueResult());
            }

        } else {
            count = ((Long) sessionFactory
                    .getCurrentSession()
                    .createQuery("select count(id) " +
                            "from PatientEntity" +
                            " where status=0 AND (contact.firstName like '" + searchString + "%'" +
                            " OR contact.lastName like '" + searchString + "%'" +
                            " OR nin like '" + searchString + "%')")
                    .uniqueResult());
        }

        return count.intValue();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<PatientEntity> getBySearchStringWithPagination(int maxResults, int pageNumber, boolean onlyResearcher, String searchString) {
        Query query;
        if (onlyResearcher) {

            if (searchString.isEmpty()) {
                query = sessionFactory
                        .getCurrentSession()
                        .createQuery("from PatientEntity where status=0")
                        .setFirstResult(maxResults * (pageNumber - 1))
                        .setMaxResults(maxResults);
            } else {
                try {
                    Integer.parseInt(searchString);
                } catch (NumberFormatException e) {
                    return new ArrayList<>();
                }
                query = sessionFactory
                        .getCurrentSession()
                        .createQuery("from PatientEntity where status=0 AND id=" + searchString)
                        .setFirstResult(maxResults * (pageNumber - 1))
                        .setMaxResults(maxResults);
            }

        } else {
            query = sessionFactory
                    .getCurrentSession()
                    .createQuery("from PatientEntity" +
                            " where status=0 AND (contact.firstName like '" + searchString + "%'" +
                            " OR contact.lastName like '" + searchString + "%'" +
                            " OR nin like '" + searchString + "%') ORDER BY contact.lastName, contact.firstName")
                    .setFirstResult(maxResults * (pageNumber - 1))
                    .setMaxResults(maxResults);
        }

        return (List<PatientEntity>) query.list();
    }
}
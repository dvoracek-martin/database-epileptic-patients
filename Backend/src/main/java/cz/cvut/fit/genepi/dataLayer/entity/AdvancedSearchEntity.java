package cz.cvut.fit.genepi.dataLayer.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "advanced_search")
public class AdvancedSearchEntity {

    @Id
    @Column(name = "id", precision = 6, scale = 0, nullable = false)
    @GeneratedValue
    private int id;

    @Column(name = "added")
    private Date added;

    @Column(name = "name")
    private String name;

    @Column(name = "hidden")
    private boolean hidden;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private UserEntity user;

    @Column(name = "user_id")
    private int userId;

    /* General parameters - specific person */
    @Column(name = "patient_firstname")
    private String patientFirstname;

    @Column(name = "patient_lastname")
    private String patientLastname;

    @Column(name = "patient_nin")
    private String patientNin;

    @Column(name = "patient_city")
    private String patientCity;

    @Column(name = "patient_country")
    private String patientCountry;

    /* General parameters */
    @Column(name = "patient_gender")
    private int patientGender;

    @Column(name = "patient_age")
    private String patientAge;

    @Column(name = "patient_age_filter")
    private String patientAgeFilter;

    @Column(name = "patient_age_epilepsy")
    private String patientAgeEpilepsy;

    @Column(name = "patient_age_epilepsy_filter")
    private String patientAgeEpilepsyFilter;

    @Column(name = "patient_doctor")
    private int patientDoctor;

    /* Include params from */
    @Column(name = "anamnesis")
    private boolean anamnesis;

    @Column(name = "seizure")
    private boolean seizure;

    @Column(name = "pharmacotherapy")
    private boolean pharmacotherapy;

    @Column(name = "neurological_finding")
    private boolean neurologicalFinding;

    @Column(name = "neuropsychology")
    private boolean neuropsychology;

    @Column(name = "diagnostic_test_scalp_eeg")
    private boolean diagnosticTestScalpEeg;

    @Column(name = "diagnostic_test_mri")
    private boolean diagnosticTestMri;

    @Column(name = "invasive_test_eeg")
    private boolean invasiveTestEeg;

    @Column(name = "invasive_test_ecog")
    private boolean invasiveTestEcog;

    @Column(name = "invasive_test_cortical_mapping")
    private boolean invasiveTestCorticalMapping;

    @Column(name = "operation")
    private boolean operation;

    @Column(name = "histology")
    private boolean histology;

    @Column(name = "complication")
    private boolean complication;

    @Column(name = "outcome")
    private boolean outcome;

	/* anamnesis specific */

    @Column(name = "anamnesis_epilepsy_in_family")
    private int anamnesisEpilepsyInFamily;

    @Column(name = "anamnesis_prenatal_risk")
    private int anamnesisPrenatalRisk;

    @Column(name = "anamnesis_fibril_convulsions")
    private int anamnesisFibrilConvulsions;

    @Column(name = "anamnesis_inflammation_cns")
    private int anamnesisInflammationCns;

    @Column(name = "anamnesis_operation_cns")
    private int anamnesisOperationCns;

    @Column(name = "anamnesis_injury_cns")
    private int anamnesisInjuryCns;

    @Column(name = "anamnesis_early_pmd_retardation")
    private int anamnesisEarlyPmdRetardation;

    @Column(name = "anamnesis_first_fever")
    private int anamnesisFirstFever;

    @Column(name = "anamnesis_infantile_spasm")
    private int anamnesisInfantileSpasm;

    @Column(name = "anamnesis_specific_syndrome")
    private int anamnesisSpecificSyndrome;

    /* seizure specific section*/

    @Column(name = "seizure_seizure_frequency")
    private int seizureSeizureFrequency;

    @Column(name = "seizure_secondarily_generalized_seizure")
    private int seizureSecondarilyGeneralizedSeizure;

    @Column(name = "seizure_status_epilepticus")
    private int seizureStatusEpilepticus;

    @Column(name = "seizure_ssc_classification")
    private int seizureSscClassification;

    @Column(name = "seizure_ilae_classification")
    private int seizureIlaeClassification;

    @Column(name = "seizure_seizure_occurence")
    private int seizureSeizureOccurence;


    /* pharmacotherapy specific section */

    @Column(name = "pharmacotherapy_aed")
    private String pharmacotherapyAed;

    /* neurological finding specific section */
    @Column(name = "neurological_finding_hemisphere_dominance")
    private int neurologicalFindingHemisphereDominance;

    @Column(name = "neurological_finding_abnormal_neurological_finding")
    private int neurologicalFindingAbnormalNeurologicalFinding;

    @Column(name = "neurological_finding_hemiparesis")
    private int neurologicalFindingHemiparesis;

    @Column(name = "neurological_finding_visual_field_defects")
    private int neurologicalFindingVisualFieldDefects;

    /* diagnostic test scalp eeg */

    @Column(name = "diagnostic_test_scalp_eeg_basic_eeg_activity")
    private int diagnosticTestScalpEegBasicEegActivity;

    @Column(name = "diagnostic_test_scalp_eeg_eeg_slow")
    private int diagnosticTestScalpEegEegSlow;

    @Column(name = "diagnostic_test_scalp_eeg_interictal_eeg_spikes")
    private int diagnosticTestScalpEegInterictalEegSpikes;

    @Column(name = "diagnostic_test_scalp_eeg_eeg_status_epilepticus")
    private int diagnosticTestScalpEegEegStatusEpilepticus;

    @Column(name = "diagnostic_test_scalp_eeg_secondary_sided_synchrony")
    private int diagnosticTestScalpEegSecondarySidedSynchrony;

    @Column(name = "diagnostic_test_scalp_eeg_ictal_eeg_patterns")
    private int diagnosticTestScalpEegIctalEegPatterns;

    /* diagnostic test mri */

    @Column(name = "diagnostic_test_mri_mri_finding")
    private int diagnosticTestMriMriFinding;

    @Column(name = "diagnostic_test_mri_fdg_pet")
    private int diagnosticTestMriFdgPet;

    @Column(name = "diagnostic_test_mri_interictal_spect")
    private int diagnosticTestMriInterictalSpect;

    @Column(name = "diagnostic_test_mri_siscom")
    private int diagnosticTestMriSiscom;

    @Column(name = "diagnostic_test_mri_mrs_protocol")
    private int diagnosticTestMriMrsProtocol;

    @Column(name = "diagnostic_test_mri_mrs_finding")
    private int diagnosticTestMriMrsFinding;

    @Column(name = "diagnostic_test_mri_dti")
    private int diagnosticTestMriDti;

    @Column(name = "diagnostic_test_mri_fmri")
    private int diagnosticTestMriFmri;

    @Column(name = "diagnostic_test_mri_wada")
    private int diagnosticTestMriWada;

    /* invasive test eeg */

    @Column(name = "invasive_test_eeg_intracranial_electrodes")
    private int invasiveTestEegIntracranialElectrodes;

    @Column(name = "invasive_test_eeg_invasive_eeg_slow")
    private int invasiveTestEegInvasiveEegSlow;

    @Column(name = "invasive_test_eeg_invasive_eeg_interictal_spikes")
    private int invasiveTestEegInvasiveEegInterictalSpikes;

    @Column(name = "invasive_test_eeg_invasive_eeg_status_epilepticus")
    private int invasiveTestEegInvasiveEegStatusEpilepticus;

    @Column(name = "invasive_test_eeg_invasive_ictal_eeg_patterns")
    private int invasiveTestEegInvasiveIctalEegPatterns;

    /* invasive test ecog */

    @Column(name = "invasive_test_ecog_ecog_patterns")
    private int invasiveTestEcogEcogPatterns;

    @Column(name = "invasive_test_ecog_after_resection_ecog")
    private int invasiveTestEcogAfterResectionEcog;

    /* invasive test cortical mapping */

    /* operation */
    @Column(name = "operation_type_operation")
    private int operationTypeOperation;

    @Column(name = "operation_range_operation")
    private int operationRangeOperation;

    @Column(name = "operation_mst")
    private int operationMst;

    @Column(name = "operation_colostomy")
    private int operationColostomy;

    @Column(name = "operation_vns")
    private int operationVns;

    @Column(name = "operation_complete_resection")
    private int operationCompleteResection;

    /* histology */
    @Column(name = "histology_histopathology")
    private int histologyHistopathology;
    @Column(name = "histology_fcd_classification")
    private int histologyFcdClassification;

    /* complication */
    @Column(name = "complication_complication_type")
    private int complicationComplicationType;
    @Column(name = "complication_complication")
    private int complicationComplication;

    /* outcome */

    @Column(name = "outcome_seizure_outcome")
    private int outcomeSeizureOutcome;

    @Column(name = "outcome_eeg")
    private int outcomeEeg;

    @Column(name = "outcome_aed")
    private int outcomeAed;

    @Column(name = "outcome_mri")
    private int outcomeMri;

    @Column(name = "outcome_neuropsychology")
    private int outcomeNeuropsychology;

    @Column(name = "outcome_distance_filter")
    private String outcomeDistanceFilter;

    @Column(name = "outcome_distance")
    private int outcomeDistance;

    public int getOutcomeSeizureOutcome() {
        return outcomeSeizureOutcome;
    }

    public void setOutcomeSeizureOutcome(int outcomeSeizureOutcome) {
        this.outcomeSeizureOutcome = outcomeSeizureOutcome;
    }

    public int getOutcomeEeg() {
        return outcomeEeg;
    }

    public void setOutcomeEeg(int outcomeEeg) {
        this.outcomeEeg = outcomeEeg;
    }

    public int getOutcomeAed() {
        return outcomeAed;
    }

    public void setOutcomeAed(int outcomeAed) {
        this.outcomeAed = outcomeAed;
    }

    public int getOutcomeMri() {
        return outcomeMri;
    }

    public void setOutcomeMri(int outcomeMri) {
        this.outcomeMri = outcomeMri;
    }

    public int getOutcomeNeuropsychology() {
        return outcomeNeuropsychology;
    }

    public void setOutcomeNeuropsychology(int outcomeNeuropsychology) {
        this.outcomeNeuropsychology = outcomeNeuropsychology;
    }

    public String getOutcomeDistanceFilter() {
        return outcomeDistanceFilter;
    }

    public void setOutcomeDistanceFilter(String outcomeDistanceFilter) {
        this.outcomeDistanceFilter = outcomeDistanceFilter;
    }

    public int getOutcomeDistance() {
        return outcomeDistance;
    }

    public void setOutcomeDistance(int outcomeDistance) {
        this.outcomeDistance = outcomeDistance;
    }

    public int getOperationTypeOperation() {
        return operationTypeOperation;
    }

    public void setOperationTypeOperation(int operationTypeOperation) {
        this.operationTypeOperation = operationTypeOperation;
    }

    public int getOperationRangeOperation() {
        return operationRangeOperation;
    }

    public void setOperationRangeOperation(int operationRangeOperation) {
        this.operationRangeOperation = operationRangeOperation;
    }

    public int getOperationMst() {
        return operationMst;
    }

    public void setOperationMst(int operationMst) {
        this.operationMst = operationMst;
    }

    public int getOperationColostomy() {
        return operationColostomy;
    }

    public void setOperationColostomy(int operationColostomy) {
        this.operationColostomy = operationColostomy;
    }

    public int getOperationVns() {
        return operationVns;
    }

    public void setOperationVns(int operationVns) {
        this.operationVns = operationVns;
    }

    public int getOperationCompleteResection() {
        return operationCompleteResection;
    }

    public void setOperationCompleteResection(int operationCompleteResection) {
        this.operationCompleteResection = operationCompleteResection;
    }

    public int getHistologyHistopathology() {
        return histologyHistopathology;
    }

    public void setHistologyHistopathology(int histologyHistopathology) {
        this.histologyHistopathology = histologyHistopathology;
    }

    public int getHistologyFcdClassification() {
        return histologyFcdClassification;
    }

    public void setHistologyFcdClassification(int histologyFcdClassification) {
        this.histologyFcdClassification = histologyFcdClassification;
    }

    public int getComplicationComplicationType() {
        return complicationComplicationType;
    }

    public void setComplicationComplicationType(int complicationComplicationType) {
        this.complicationComplicationType = complicationComplicationType;
    }

    public int getComplicationComplication() {
        return complicationComplication;
    }

    public void setComplicationComplication(int complicationComplication) {
        this.complicationComplication = complicationComplication;
    }

    public int getInvasiveTestEegIntracranialElectrodes() {
        return invasiveTestEegIntracranialElectrodes;
    }

    public void setInvasiveTestEegIntracranialElectrodes(int invasiveTestEegIntracranialElectrodes) {
        this.invasiveTestEegIntracranialElectrodes = invasiveTestEegIntracranialElectrodes;
    }

    public int getInvasiveTestEegInvasiveEegSlow() {
        return invasiveTestEegInvasiveEegSlow;
    }

    public void setInvasiveTestEegInvasiveEegSlow(int invasiveTestEegInvasiveEegSlow) {
        this.invasiveTestEegInvasiveEegSlow = invasiveTestEegInvasiveEegSlow;
    }

    public int getInvasiveTestEegInvasiveEegInterictalSpikes() {
        return invasiveTestEegInvasiveEegInterictalSpikes;
    }

    public void setInvasiveTestEegInvasiveEegInterictalSpikes(int invasiveTestEegInvasiveEegInterictalSpikes) {
        this.invasiveTestEegInvasiveEegInterictalSpikes = invasiveTestEegInvasiveEegInterictalSpikes;
    }

    public int getInvasiveTestEegInvasiveEegStatusEpilepticus() {
        return invasiveTestEegInvasiveEegStatusEpilepticus;
    }

    public void setInvasiveTestEegInvasiveEegStatusEpilepticus(int invasiveTestEegInvasiveEegStatusEpilepticus) {
        this.invasiveTestEegInvasiveEegStatusEpilepticus = invasiveTestEegInvasiveEegStatusEpilepticus;
    }

    public int getInvasiveTestEegInvasiveIctalEegPatterns() {
        return invasiveTestEegInvasiveIctalEegPatterns;
    }

    public void setInvasiveTestEegInvasiveIctalEegPatterns(int invasiveTestEegInvasiveIctalEegPatterns) {
        this.invasiveTestEegInvasiveIctalEegPatterns = invasiveTestEegInvasiveIctalEegPatterns;
    }

    public int getInvasiveTestEcogEcogPatterns() {
        return invasiveTestEcogEcogPatterns;
    }

    public void setInvasiveTestEcogEcogPatterns(int invasiveTestEcogEcogPatterns) {
        this.invasiveTestEcogEcogPatterns = invasiveTestEcogEcogPatterns;
    }

    public int getInvasiveTestEcogAfterResectionEcog() {
        return invasiveTestEcogAfterResectionEcog;
    }

    public void setInvasiveTestEcogAfterResectionEcog(int invasiveTestEcogAfterResectionEcog) {
        this.invasiveTestEcogAfterResectionEcog = invasiveTestEcogAfterResectionEcog;
    }

    public int getDiagnosticTestMriMriFinding() {
        return diagnosticTestMriMriFinding;
    }

    public void setDiagnosticTestMriMriFinding(int diagnosticTestMriMriFinding) {
        this.diagnosticTestMriMriFinding = diagnosticTestMriMriFinding;
    }

    public int getDiagnosticTestMriFdgPet() {
        return diagnosticTestMriFdgPet;
    }

    public void setDiagnosticTestMriFdgPet(int diagnosticTestMriFdgPet) {
        this.diagnosticTestMriFdgPet = diagnosticTestMriFdgPet;
    }

    public int getDiagnosticTestMriInterictalSpect() {
        return diagnosticTestMriInterictalSpect;
    }

    public void setDiagnosticTestMriInterictalSpect(int diagnosticTestMriInterictalSpect) {
        this.diagnosticTestMriInterictalSpect = diagnosticTestMriInterictalSpect;
    }

    public int getDiagnosticTestMriSiscom() {
        return diagnosticTestMriSiscom;
    }

    public void setDiagnosticTestMriSiscom(int diagnosticTestMriSiscom) {
        this.diagnosticTestMriSiscom = diagnosticTestMriSiscom;
    }

    public int getDiagnosticTestMriMrsProtocol() {
        return diagnosticTestMriMrsProtocol;
    }

    public void setDiagnosticTestMriMrsProtocol(int diagnosticTestMriMrsProtocol) {
        this.diagnosticTestMriMrsProtocol = diagnosticTestMriMrsProtocol;
    }

    public int getDiagnosticTestMriMrsFinding() {
        return diagnosticTestMriMrsFinding;
    }

    public void setDiagnosticTestMriMrsFinding(int diagnosticTestMriMrsFinding) {
        this.diagnosticTestMriMrsFinding = diagnosticTestMriMrsFinding;
    }

    public int getDiagnosticTestMriDti() {
        return diagnosticTestMriDti;
    }

    public void setDiagnosticTestMriDti(int diagnosticTestMriDti) {
        this.diagnosticTestMriDti = diagnosticTestMriDti;
    }

    public int getDiagnosticTestMriFmri() {
        return diagnosticTestMriFmri;
    }

    public void setDiagnosticTestMriFmri(int diagnosticTestMriFmri) {
        this.diagnosticTestMriFmri = diagnosticTestMriFmri;
    }

    public int getDiagnosticTestMriWada() {
        return diagnosticTestMriWada;
    }

    public void setDiagnosticTestMriWada(int diagnosticTestMriWada) {
        this.diagnosticTestMriWada = diagnosticTestMriWada;
    }

    public int getDiagnosticTestScalpEegBasicEegActivity() {
        return diagnosticTestScalpEegBasicEegActivity;
    }

    public void setDiagnosticTestScalpEegBasicEegActivity(int diagnosticTestScalpEegBasicEegActivity) {
        this.diagnosticTestScalpEegBasicEegActivity = diagnosticTestScalpEegBasicEegActivity;
    }

    public int getDiagnosticTestScalpEegEegSlow() {
        return diagnosticTestScalpEegEegSlow;
    }

    public void setDiagnosticTestScalpEegEegSlow(int diagnosticTestScalpEegEegSlow) {
        this.diagnosticTestScalpEegEegSlow = diagnosticTestScalpEegEegSlow;
    }

    public int getDiagnosticTestScalpEegInterictalEegSpikes() {
        return diagnosticTestScalpEegInterictalEegSpikes;
    }

    public void setDiagnosticTestScalpEegInterictalEegSpikes(int diagnosticTestScalpEegInterictalEegSpikes) {
        this.diagnosticTestScalpEegInterictalEegSpikes = diagnosticTestScalpEegInterictalEegSpikes;
    }

    public int getDiagnosticTestScalpEegEegStatusEpilepticus() {
        return diagnosticTestScalpEegEegStatusEpilepticus;
    }

    public void setDiagnosticTestScalpEegEegStatusEpilepticus(int diagnosticTestScalpEegEegStatusEpilepticus) {
        this.diagnosticTestScalpEegEegStatusEpilepticus = diagnosticTestScalpEegEegStatusEpilepticus;
    }

    public int getDiagnosticTestScalpEegSecondarySidedSynchrony() {
        return diagnosticTestScalpEegSecondarySidedSynchrony;
    }

    public void setDiagnosticTestScalpEegSecondarySidedSynchrony(int diagnosticTestScalpEegSecondarySidedSynchrony) {
        this.diagnosticTestScalpEegSecondarySidedSynchrony = diagnosticTestScalpEegSecondarySidedSynchrony;
    }

    public int getDiagnosticTestScalpEegIctalEegPatterns() {
        return diagnosticTestScalpEegIctalEegPatterns;
    }

    public void setDiagnosticTestScalpEegIctalEegPatterns(int diagnosticTestScalpEegIctalEegPattern) {
        this.diagnosticTestScalpEegIctalEegPatterns = diagnosticTestScalpEegIctalEegPattern;
    }

    public int getNeurologicalFindingHemisphereDominance() {
        return neurologicalFindingHemisphereDominance;
    }

    public void setNeurologicalFindingHemisphereDominance(int neurologicalFindingHemisphereDominance) {
        this.neurologicalFindingHemisphereDominance = neurologicalFindingHemisphereDominance;
    }

    public int getNeurologicalFindingAbnormalNeurologicalFinding() {
        return neurologicalFindingAbnormalNeurologicalFinding;
    }

    public void setNeurologicalFindingAbnormalNeurologicalFinding(int neurologicalFindingAbnormalNeurologicalFinding) {
        this.neurologicalFindingAbnormalNeurologicalFinding = neurologicalFindingAbnormalNeurologicalFinding;
    }

    public int getNeurologicalFindingHemiparesis() {
        return neurologicalFindingHemiparesis;
    }

    public void setNeurologicalFindingHemiparesis(int neurologicalFindingHemiparesis) {
        this.neurologicalFindingHemiparesis = neurologicalFindingHemiparesis;
    }

    public int getNeurologicalFindingVisualFieldDefects() {
        return neurologicalFindingVisualFieldDefects;
    }

    public void setNeurologicalFindingVisualFieldDefects(int neurologicalFindingVisualFieldDefects) {
        this.neurologicalFindingVisualFieldDefects = neurologicalFindingVisualFieldDefects;
    }

    public String getPharmacotherapyAed() {
        return pharmacotherapyAed;
    }


    public void setPharmacotherapyAed(String pharmacotherapyAed) {
        this.pharmacotherapyAed = pharmacotherapyAed;
    }

    public int getSeizureSecondarilyGeneralizedSeizure() {
        return seizureSecondarilyGeneralizedSeizure;
    }

    public void setSeizureSecondarilyGeneralizedSeizure(int seizureSecondarilyGeneralizedSeizure) {
        this.seizureSecondarilyGeneralizedSeizure = seizureSecondarilyGeneralizedSeizure;
    }

    public int getSeizureSeizureOccurence() {
        return seizureSeizureOccurence;
    }

    public void setSeizureSeizureOccurence(int seizureSeizureOccurence) {
        this.seizureSeizureOccurence = seizureSeizureOccurence;
    }

    public int getSeizureSeizureFrequency() {
        return seizureSeizureFrequency;
    }

    public void setSeizureSeizureFrequency(int seizureSeizureFrequency) {
        this.seizureSeizureFrequency = seizureSeizureFrequency;
    }


    public int getSeizureStatusEpilepticus() {
        return seizureStatusEpilepticus;
    }

    public void setSeizureStatusEpilepticus(int seizureStatusEpilepticus) {
        this.seizureStatusEpilepticus = seizureStatusEpilepticus;
    }

    public int getSeizureSscClassification() {
        return seizureSscClassification;
    }

    public void setSeizureSscClassification(int seizureSscClassification) {
        this.seizureSscClassification = seizureSscClassification;
    }

    public int getSeizureIlaeClassification() {
        return seizureIlaeClassification;
    }

    public void setSeizureIlaeClassification(int seizureIlaeClassification) {
        this.seizureIlaeClassification = seizureIlaeClassification;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPatientFirstname() {
        return patientFirstname;
    }

    public void setPatientFirstname(String patientFirstname) {
        this.patientFirstname = patientFirstname;
    }

    public String getPatientLastname() {
        return patientLastname;
    }

    public void setPatientLastname(String patientLastname) {
        this.patientLastname = patientLastname;
    }

    public String getPatientNin() {
        return patientNin;
    }

    public void setPatientNin(String patientNin) {
        this.patientNin = patientNin;
    }

    public String getPatientCity() {
        return patientCity;
    }

    public void setPatientCity(String patientCity) {
        this.patientCity = patientCity;
    }

    public String getPatientCountry() {
        return patientCountry;
    }

    public void setPatientCountry(String patientCountry) {
        this.patientCountry = patientCountry;
    }

    public int getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(int patientGender) {
        this.patientGender = patientGender;
    }

    public String getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(String patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientAgeFilter() {
        return patientAgeFilter;
    }

    public void setPatientAgeFilter(String patientAgeFilter) {
        this.patientAgeFilter = patientAgeFilter;
    }

    public String getPatientAgeEpilepsy() {
        return patientAgeEpilepsy;
    }

    public void setPatientAgeEpilepsy(String patientAgeEpilepsy) {
        this.patientAgeEpilepsy = patientAgeEpilepsy;
    }

    public String getPatientAgeEpilepsyFilter() {
        return patientAgeEpilepsyFilter;
    }

    public void setPatientAgeEpilepsyFilter(String patientAgeEpilepsyFilter) {
        this.patientAgeEpilepsyFilter = patientAgeEpilepsyFilter;
    }

    public int getPatientDoctor() {
        return patientDoctor;
    }

    public void setPatientDoctor(int patientDoctor) {
        this.patientDoctor = patientDoctor;
    }

    public boolean isAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(boolean anamnesis) {
        this.anamnesis = anamnesis;
    }

    public boolean isSeizure() {
        return seizure;
    }

    public void setSeizure(boolean seizure) {
        this.seizure = seizure;
    }

    public boolean isPharmacotherapy() {
        return pharmacotherapy;
    }

    public void setPharmacotherapy(boolean pharmacotherapy) {
        this.pharmacotherapy = pharmacotherapy;
    }

    public boolean isNeurologicalFinding() {
        return neurologicalFinding;
    }

    public void setNeurologicalFinding(boolean neurologicalFinding) {
        this.neurologicalFinding = neurologicalFinding;
    }

    public boolean isNeuropsychology() {
        return neuropsychology;
    }

    public void setNeuropsychology(boolean neuropsychology) {
        this.neuropsychology = neuropsychology;
    }

    public boolean isDiagnosticTestScalpEeg() {
        return diagnosticTestScalpEeg;
    }

    public void setDiagnosticTestScalpEeg(boolean diagnosticTestScalpEeg) {
        this.diagnosticTestScalpEeg = diagnosticTestScalpEeg;
    }

    public boolean isDiagnosticTestMri() {
        return diagnosticTestMri;
    }

    public void setDiagnosticTestMri(boolean diagnosticTestMri) {
        this.diagnosticTestMri = diagnosticTestMri;
    }

    public boolean isInvasiveTestEeg() {
        return invasiveTestEeg;
    }

    public void setInvasiveTestEeg(boolean invasiveTestEeg) {
        this.invasiveTestEeg = invasiveTestEeg;
    }

    public boolean isInvasiveTestEcog() {
        return invasiveTestEcog;
    }

    public void setInvasiveTestEcog(boolean invasiveTestEcog) {
        this.invasiveTestEcog = invasiveTestEcog;
    }

    public boolean isOperation() {
        return operation;
    }

    public void setOperation(boolean operation) {
        this.operation = operation;
    }

    public boolean isHistology() {
        return histology;
    }

    public void setHistology(boolean histology) {
        this.histology = histology;
    }

    public boolean isComplication() {
        return complication;
    }

    public void setComplication(boolean complication) {
        this.complication = complication;
    }

    public boolean isOutcome() {
        return outcome;
    }

    public void setOutcome(boolean outcome) {
        this.outcome = outcome;
    }

    public int getAnamnesisEpilepsyInFamily() {
        return anamnesisEpilepsyInFamily;
    }

    public void setAnamnesisEpilepsyInFamily(int anamnesisEpilepsyInFamily) {
        this.anamnesisEpilepsyInFamily = anamnesisEpilepsyInFamily;
    }

    public int getAnamnesisPrenatalRisk() {
        return anamnesisPrenatalRisk;
    }

    public void setAnamnesisPrenatalRisk(int anamnesisPrenatalRisk) {
        this.anamnesisPrenatalRisk = anamnesisPrenatalRisk;
    }

    public int getAnamnesisFibrilConvulsions() {
        return anamnesisFibrilConvulsions;
    }

    public void setAnamnesisFibrilConvulsions(int anamnesisFibrilConvulsions) {
        this.anamnesisFibrilConvulsions = anamnesisFibrilConvulsions;
    }

    public int getAnamnesisInflammationCns() {
        return anamnesisInflammationCns;
    }

    public void setAnamnesisInflammationCns(int anamnesisInflammationCns) {
        this.anamnesisInflammationCns = anamnesisInflammationCns;
    }

    public int getAnamnesisOperationCns() {
        return anamnesisOperationCns;
    }

    public void setAnamnesisOperationCns(int anamnesisOperationCns) {
        this.anamnesisOperationCns = anamnesisOperationCns;
    }

    public int getAnamnesisInjuryCns() {
        return anamnesisInjuryCns;
    }

    public void setAnamnesisInjuryCns(int anamnesisInjuryCns) {
        this.anamnesisInjuryCns = anamnesisInjuryCns;
    }

    public int getAnamnesisEarlyPmdRetardation() {
        return anamnesisEarlyPmdRetardation;
    }

    public void setAnamnesisEarlyPmdRetardation(int anamnesisEarlyPmdRetardation) {
        this.anamnesisEarlyPmdRetardation = anamnesisEarlyPmdRetardation;
    }

    public int getAnamnesisFirstFever() {
        return anamnesisFirstFever;
    }

    public void setAnamnesisFirstFever(int anamnesisFirstFever) {
        this.anamnesisFirstFever = anamnesisFirstFever;
    }

    public int getAnamnesisInfantileSpasm() {
        return anamnesisInfantileSpasm;
    }

    public void setAnamnesisInfantileSpasm(int anamnesisInfantileSpasm) {
        this.anamnesisInfantileSpasm = anamnesisInfantileSpasm;
    }

    public int getAnamnesisSpecificSyndrome() {
        return anamnesisSpecificSyndrome;
    }

    public void setAnamnesisSpecificSyndrome(int anamnesisSpecificSyndrome) {
        this.anamnesisSpecificSyndrome = anamnesisSpecificSyndrome;
    }

    public boolean isInvasiveTestCorticalMapping() {
        return invasiveTestCorticalMapping;
    }

    public void setInvasiveTestCorticalMapping(boolean invasiveTestCorticalMapping) {
        this.invasiveTestCorticalMapping = invasiveTestCorticalMapping;
    }
}

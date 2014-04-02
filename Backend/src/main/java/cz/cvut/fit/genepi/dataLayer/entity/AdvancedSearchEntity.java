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
    @JoinColumn(name = "user_id")
    private UserEntity user;


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
    private boolean anamnesisPrenatalRisk;

    @Column(name = "anamnesis_fibril_convulsions")
    private boolean anamnesisFibrilConvulsions;

    @Column(name = "anamnesis_inflammation_cns")
    private boolean anamnesisInflammationCns;

    @Column(name = "anamnesis_operation_cns")
    private boolean anamnesisOperationCns;

    @Column(name = "anamnesis_injury_cns")
    private boolean anamnesisInjuryCns;

    @Column(name = "anamnesis_early_pmd_retardation")
    private boolean anamnesisEarlyPmdRetardation;

    @Column(name = "anamnesis_first_fever")
    private boolean anamnesisFirstFever;

    @Column(name = "anamnesis_infantile_spasm")
    private boolean anamnesisInfantileSpasm;

    @Column(name = "anamnesis_specific_syndrome")
    private boolean anamnesisSpecificSyndrome;


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

    /* General parameters - specific person get n set*/
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

    public void setPatientCity(String patientTown) {
        this.patientCity = patientTown;
    }

    public String getPatientCountry() {
        return patientCountry;
    }

    public void setPatientCountry(String patientCountry) {
        this.patientCountry = patientCountry;
    }

    /* General parameters get n set*/
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
    /* Include params from get n set */

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

    public boolean getComplication() {
        return complication;
    }

    public void setComplication(boolean complication) {
        this.complication = complication;
    }

    public boolean getOutcome() {
        return outcome;
    }

    public void setOutcome(boolean outcome) {
        this.outcome = outcome;
    }
    /* anamnesis specific  get n set*/

    public int getAnamnesisEpilepsyInFamily() {
        return anamnesisEpilepsyInFamily;
    }

    public void setAnamnesisEpilepsyInFamily(int anamnesisEpilepsyInFamily) {
        this.anamnesisEpilepsyInFamily = anamnesisEpilepsyInFamily;
    }


}

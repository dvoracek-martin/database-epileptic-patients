package cz.cvut.fit.genepi.businessLayer.VO.form;


import javax.persistence.Column;
import javax.validation.constraints.Size;
import java.util.Date;

public class AdvancedSearchVO {

    private int id;

    private Date added;

    private String name;

//    private boolean hidden;

    //    private UserEntity user;
    private int userId;

    @Size(max = 100)
    private String patientFirstname;

    private String patientLastname;

    private String patientNin;

    private String patientCity;

    private String patientCountry;

    /* General parameters */
    private int patientGender;

    private String patientAge;

    private String patientAgeFilter;

    private String patientAgeEpilepsy;

    private String patientAgeEpilepsyFilter;

    private int patientDoctor;

    private boolean anamnesis;

    private boolean seizure;

    private boolean pharmacotherapy;

    private boolean neurologicalFinding;

    private boolean neuropsychology;

    private boolean diagnosticTestScalpEeg;

    private boolean diagnosticTestMri;

    private boolean invasiveTestEeg;

    private boolean invasiveTestEcog;

    private boolean operation;

    private boolean histology;

    private boolean complication;

    private boolean outcome;

    /* anamnesis specific */

    private int anamnesisEpilepsyInFamily;

    private int anamnesisPrenatalRisk;

    private int anamnesisFibrilConvulsions;

    private int anamnesisInflammationCns;

    private int anamnesisOperationCns;

    private int anamnesisInjuryCns;

    private int anamnesisEarlyPmdRetardation;

    private int anamnesisFirstFever;

    private int anamnesisInfantileSpasm;

    private int anamnesisSpecificSyndrome;

    /* seizure specific */

    private int seizureSeizureFrequency;

    private int seizureSecondarilyGeneralizedSeizure;

    private int seizureStatusEpilepticus;

    private int seizureSscClassification;

    private int seizureIlaeClassification;

    private int seizureSeizureOccurence;

    /* pharmacotherapy specific section */

    private int[] pharmacotherapyAed;

    /* neurological finding specific section */

    private int neurologicalFindingHemisphereDominance;

    private int neurologicalFindingAbnormalNeurologicalFinding;

    private int neurologicalFindingHemiparesis;

    private int neurologicalFindingVisualFieldDefects;


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

    public int[] getPharmacotherapyAed() {
        return pharmacotherapyAed;
    }

    public void setPharmacotherapyAed(int[] pharmacotherapyAed) {
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
}

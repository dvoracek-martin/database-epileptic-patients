package cz.cvut.fit.genepi.businessLayer.VO.form;

/**
 * Created by Jan on 16.3.14.
 */
public class ExportParamsVO {

    private int id;


    private String name;


    private int userID;


    private boolean isGeneric;


    private boolean patient;


    private boolean anamnesis;


    private boolean complication;


    private boolean diagnosticTestEEG;


    private boolean diagnosticTestMRI;


    private boolean histology;


    private boolean invasiveTestECOG;


    private boolean invasiveTestEEG;


    private boolean neurologicalFinding;


    private boolean neuropsychology;


    private boolean neuropsychologyOld;


    private boolean invasiveTestCorticalMapping;


    private boolean operation;


    private boolean outcome;


    private boolean pharmacotherapy;


    private boolean seizure;


    private boolean anonymize;

    // Patient properties

    private boolean patientId;

    private boolean patientNin;

    private boolean patientBirthday;

    private boolean patientGender;

    private boolean patientDoctorId;

    private boolean patientChecked;

    private boolean patientContactId;

    private boolean patientAgeAtTheBeginningOfEpilepsy;

    // Contact properties

    private boolean contactId;

    private boolean contactFirstName;

    private boolean contactLastName;

    private boolean contactAddressStreet;

    private boolean contactAddressHn;

    private boolean contactAddressCity;

    private boolean contactPostalCode;

    private boolean contactCountry;

    private boolean contactPhoneNumber;

    private boolean contactEmail;

    // Anamnesis properties

    private boolean anamnesisId;

    private boolean anamnesisDate;

    private boolean anamnesisDoctorId;

    private boolean anamnesisAdded;

    private boolean anamnesisBeginningEpilepsy;

    private boolean anamnesisFirstFever;

    private boolean anamnesisInfantileSpasm;

    private boolean anamnesisSpecificSyndrome;

    private boolean anamnesisEpilepsyInFamily;

    private boolean anamnesisParentalRisk;

    private boolean anamnesisFibrilConvulsions;

    private boolean anamnesisInflammationCns;

    private boolean anamnesisInjuryCns;

    private boolean anamnesisOperationCns;

    private boolean anamnesisEarlyPmdRetardation;

    private boolean anamnesisNonCnsComorbidity;

    private boolean anamnesisComment;

    // Complication properties

    private boolean complicationId;

    private boolean complicationDate;

    private boolean complicationDoctorId;

    private boolean complicationAdded;

    private boolean complicationComment;

    private boolean complicationPatientId;

    private boolean complicationAddUserId;

    private boolean ComplicationWithCompication;

    private boolean ComplicationComplicationType;

    private boolean ComplicationComplication;

    // DiagnosticTestEEG properties

    private boolean diagnosticTestEEGId;

    private boolean diagnosticTestEEGDate;

    private boolean diagnosticTestEEGDone;

    private boolean diagnosticTestEEGDoctorId;

    private boolean diagnosticTestEEGAdded;

    private boolean diagnosticTestEEGBasicActivity;

    private boolean diagnosticTestEEGSlow;

    private boolean diagnosticTestEEGInterictalEEGSpikes;

    private boolean diagnosticTestEEGLocalizationInerictalEEGSpikes;

    private boolean diagnosticTestEEGStatusEpilepticus;

    private boolean diagnosticTestEEGSecondarySidedSynchrony;

    private boolean diagnosticTestEEGIctalEEGPatterns;

    private boolean diagnosticTestEEGLocalizationIctalEEGPattern;

    private boolean diagnosticTestEEGComment;

    private boolean diagnosticTestEEGAddUserId;

    private boolean diagnosticTestEEGPatientId;

    private boolean diagnosticTestEEGDescriptionVideoEEG;

    // DiagnosticTestMRI properties

    private boolean diagnosticTestMRIId;

    private boolean diagnosticTestMRIDone;

    private boolean diagnosticTestMRIDate;

    private boolean diagnosticTestMRIDoctorId;

    private boolean diagnosticTestMRIAdded;

    private boolean diagnosticTestMRIProtocol;

    private boolean diagnosticTestMRIFdgPet;

    private boolean diagnosticTestMRIInterictalSpect;

    private boolean diagnosticTestMRISiscom;

    private boolean diagnosticTestMRIMrsProtocol;

    private boolean diagnosticTestMRIMrsFinding;

    private boolean diagnosticTestMRIFinding;

    private boolean diagnosticTestMRIDescription;

    private boolean diagnosticTestMRIDescriptionPetHypometabolism;

    private boolean diagnosticTestMRIDescriptionSpectHypoperfuse;

    private boolean diagnosticTestMRIDescriptionMrsAbnormality;

    private boolean diagnosticTestMRIDescriptionSpectHyperperfuse;

    private boolean diagnosticTestMRIIctalSpect;

    private boolean diagnosticTestMRIDti;

    private boolean diagnosticTestMRIDtiDetailStudy;

    private boolean diagnosticTestMRIFmri;

    private boolean diagnosticTestMRIDetailsFmri;

    private boolean diagnosticTestMRIDetailsDtiStudy;

    private boolean diagnosticTestMRIWada;

    private boolean diagnosticTestMRIDetailsWada;

    private boolean diagnosticTestMRIDescribe;

    private boolean diagnosticTestMRILocalizationSpecHypoperfuse;

    private boolean diagnosticTestMRILocalizationMrsAbnormality;

    private boolean diagnosticTestMRILocalizationPetHypometabolism;

    private boolean diagnosticTestMRILocalizationSpecHyperperfuse;

    private boolean diagnosticTestMRIFmriProtocols;

    private boolean diagnosticTestMRIComment;

    private boolean diagnosticTestMRIPatientId;

    private boolean diagnosticTestMRIAddUserId;

    // Histology properties

    private boolean histologyId;

    private boolean histologyDate;

    private boolean histologyDoctorId;

    private boolean histologyAdded;

    private boolean histologyHistopathology;

    private boolean histologyFcdClassification;

    private boolean histologyComment;

    private boolean histologyPatientId;

    private boolean histologyAddUserId;

    // InvasiveTestECOG properties

    private boolean invasiveTestECOGId;

    private boolean invasiveTestECOGDate;

    private boolean invasiveTestECOGDone;

    private boolean invasiveTestECOGIntracranialElectrodes;

    private boolean invasiveTestECOGDoctorId;

    private boolean invasiveTestECOGAdded;

    private boolean invasiveTestECOGIntraOperativeEcog;

    private boolean invasiveTestECOGEcogPatterns;

    private boolean invasiveTestECOGEcogCover;

    private boolean invasiveTestECOGAfterResectionEcog;

    private boolean invasiveTestECOGAwakeCraniotomy;

    private boolean invasiveTestECOGComment;

    private boolean invasiveTestECOGAddUserId;

    private boolean invasiveTestECOGPatientId;

    // InvasiveTestEEG properties

    private boolean invasiveTestEEGId;

    private boolean invasiveTestEEGDate;

    private boolean invasiveTestEEGDone;

    private boolean invasiveTestEEGDoctorId;

    private boolean invasiveTestEEGAdded;

    private boolean invasiveTestEEGInvasiveMonitoring;

    private boolean invasiveTestEEGLocalizationIntracranialElectrodes;

    private boolean invasiveTestEEGIntracranialElectrodes;

    private boolean invasiveTestEEGInvasiveEEGSlow;

    private boolean invasiveTestEEGInvasiveEEGInterictalSpikes;

    private boolean invasiveTestEEGLocalizationInvasiveEEGInterictalSpikes;

    private boolean invasiveTestEEGStatusEpilepticus;

    private boolean invasiveTestEEGInvasiveIctalEEGPatterns;

    private boolean invasiveTestEEGLocalizationIctalEEGPatterns;

    private boolean invasiveTestEEGComment;

    private boolean invasiveTestEEGAddUserId;

    private boolean invasiveTestEEGPatientId;

    // Neurological finding property

    private boolean neurologicalFindingId;

    private boolean neurologicalFindingDate;

    private boolean neurologicalFindingDoctorId;

    private boolean neurologicalFindingAdded;

    private boolean neurologicalFindingHemisphereDominance;

    private boolean neurologicalFindingAbnormalNeurologicalFinding;

    private boolean neurologicalFindingHemiparesis;

    private boolean neurologicalFindingVisualFieldDefects;

    private boolean neurologicalFindingComment;

    private boolean neurologicalFindingAddUserId;

    private boolean neurologicalFindingPatientId;

    // Neuropsychology properties

    private boolean neuropsychologyId;

    private boolean neuropsychologyDate;

    private boolean neuropsychologyDoctorId;

    private boolean neuropsychologyAdded;

    private boolean neuropsychologyIntellect;

    private boolean neuropsychologyNeurodevelopmentalExamination;

    private boolean neuropsychologyNeurodevelopmentalExaminationAdaptability;

    private boolean neuropsychologyNeurodevelopmentalExaminationSpeechExpressively;

    private boolean neuropsychologyNeurodevelopmentalExaminationSpeechReceptively;

    private boolean neuropsychologyNeurodevelopmentalExaminationFineMotorSkills;

    private boolean neuropsychologyNeurodevelopmentalExaminationGrossMotorSkills;

    private boolean neuropsychologyNeurodevelopmentalExaminationSocialBehavior;

    private boolean neuropsychologyIntellectualPerformance;

    private boolean neuropsychologyIntellectualPerformanceVerbally;

    private boolean neuropsychologyIntellectualPerformanceNonverbalAbstraction;

    private boolean neuropsychologyIntellectualPerformanceNonverbalDesignCap;

    private boolean neuropsychologyNeuropsychologicalProfile;

    private boolean neuropsychologyNeuropsychologicalProfileAttention;

    private boolean neuropsychologyNeuropsychologicalProfileExecutiveFunction;

    private boolean neuropsychologyNeuropsychologicalProfileCognitiveSpeed;

    private boolean neuropsychologyNeuropsychologicalProfileSpeechExpressively;

    private boolean neuropsychologyNeuropsychologicalProfileSpeechUnderstanding;

    private boolean neuropsychologyNeuropsychologicalProfileMemoryOperating;

    private boolean neuropsychologyNeuropsychologicalProfileMemoryVerbal;

    private boolean neuropsychologyNeuropsychologicalProfileMemoryNonverbal;

    private boolean neuropsychologyNeuropsychologicalProfileMemoryLearning;

    private boolean neuropsychologyNeuropsychologicalProfilePerceptionSpeech;

    private boolean neuropsychologyNeuropsychologicalProfilePerceptionVisual;

    private boolean neuropsychologyNeuropsychologicalProfilePerceptionSpatial;

    private boolean neuropsychologyNeuropsychologicalProfileMotorSkillsDexterity;

    private boolean neuropsychologyNeuropsychologicalProfileMotorCoordination;

    private boolean neuropsychologyPresenceOfChanges;

    private boolean neuropsychologyPresenceOfChangesDetail;

    private boolean neuropsychologyEmotionalStatus;

    private boolean neuropsychologyComment;

    private boolean neuropsychologyAddUserId;

    private boolean neuropsychologyPatientId;

    private boolean neuropsychologyFindingDetail;

    // Operation properties

    private boolean operationId;

    private boolean operationDate;

    private boolean operationDateOperation;

    private boolean operationDoctorId;

    private boolean operationAdded;

    private boolean operationTypeOperation;

    private boolean operationRangeOperation;

    private boolean operationLocalizationOperation;

    private boolean operationMst;

    private boolean operationColostomy;

    private boolean operationVNS;

    private boolean operationVNsImplantationDate;

    private boolean operationOperationDetails;

    private boolean operationCompleteResection;

    private boolean operationComment;

    private boolean operationAddUserId;

    private boolean operationPatientId;

    // Outcome properties

    private boolean outcomeId;

    private boolean outcomeDate;

    private boolean outcomeDoctorId;

    private boolean outcomeAdded;

    private boolean outcomeFinallySeizures;

    private boolean outcomeEEG;

    private boolean outcomeAED;

    private boolean outcomeMRI;

    private boolean outcomeNeuropsychology;

    private boolean outcomeComment;

    private boolean outcomeAddUserId;

    private boolean outcomePatientId;

    private boolean outcomeSeizureOutcome;

    private boolean outcomeDistance;

    private boolean outcomeOperationId;

    // Pharmacotherapy properties

    private boolean pharmacotherapyId;

    private boolean pharmacotherapyDate;

    private boolean pharmacotherapyDoctorId;

    private boolean pharmacotherapyAdded;

    private boolean pharmacotherapyAED;

    private boolean pharmacotherapyEffective;

    private boolean pharmacotherapyDuringSurgery;

    private boolean pharmacotherapyComment;

    private boolean pharmacotherapyAddUserId;

    private boolean pharmacotherapyPatientId;

    // Seizure properties

    private boolean seizureId;

    private boolean seizureDate;

    private boolean seizureDoctorId;

    private boolean seizureAdded;

    private boolean seizureFrequency;

    private boolean seizureSecondarilyGeneralizedSeizure;

    private boolean seizureStatusEpilepticus;

    private boolean seizureSSCClassification;

    private boolean seizureILAEClassification;

    private boolean seizureSeizuresWhileAwakeEpi;

    private boolean seizureSeizuresWhileAwakeLatent;

    private boolean seizureSeizuresWhileAwakeNonEpi;

    private boolean seizureSeizuresWhileSleepEpi;

    private boolean seizureSeizuresWhileSleepLatent;

    private boolean seizureSeizuresWhileSleepNonEpi;

    private boolean seizureComment;

    private boolean seizureAddUserId;

    private boolean seizurePatientId;

    // SeizureDetail properties

    private boolean seizureDetailComment;

    // NeuropsychologyOld properties

    private boolean neuropsychologyOldId;

    private boolean neuropsychologyOldDate;

    private boolean neuropsychologyOldDoctorId;

    private boolean neuropsychologyOldAdded;

    private boolean neuropsychologyOldComment;

    private boolean neuropsychologyOldAddUserId;

    private boolean neuropsychologyOldPatientId;

    private boolean neuropsychologyOldNeuropsychologicalExamination;

    private boolean neuropsychologyOldIntelligenceLevel;

    private boolean neuropsychologyOldSpecificLearning;

    private boolean neuropsychologyOldDevelopmentalLanguageDisorders;

    private boolean neuropsychologyOldAdhdSyndrome;

    // InvasiveTestCorticalMapping properties

    private boolean invasiveTestCorticalMappingId;

    private boolean invasiveTestCorticalMappingDate;

    private boolean invasiveTestCorticalMappingDoctorId;

    private boolean invasiveTestCorticalMappingAdded;

    private boolean invasiveTestCorticalMappingComment;

    private boolean invasiveTestCorticalMappingAddUserId;

    private boolean invasiveTestCorticalMappingPatientId;

    private boolean invasiveTestCorticalMappingDone;

    private boolean invasiveTestCorticalMappingCorticalMapping;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public boolean isGeneric() {
        return isGeneric;
    }

    public void setGeneric(boolean isGeneric) {
        this.isGeneric = isGeneric;
    }

    public boolean isPatient() {
        return patient;
    }

    public void setPatient(boolean patient) {
        this.patient = patient;
    }

    public boolean isAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(boolean anamnesis) {
        this.anamnesis = anamnesis;
    }

    public boolean isComplication() {
        return complication;
    }

    public void setComplication(boolean complication) {
        this.complication = complication;
    }

    public boolean isDiagnosticTestEEG() {
        return diagnosticTestEEG;
    }

    public void setDiagnosticTestEEG(boolean diagnosticTestEEG) {
        this.diagnosticTestEEG = diagnosticTestEEG;
    }

    public boolean isDiagnosticTestMRI() {
        return diagnosticTestMRI;
    }

    public void setDiagnosticTestMRI(boolean diagnosticTestMRI) {
        this.diagnosticTestMRI = diagnosticTestMRI;
    }

    public boolean isHistology() {
        return histology;
    }

    public void setHistology(boolean histology) {
        this.histology = histology;
    }

    public boolean isInvasiveTestECOG() {
        return invasiveTestECOG;
    }

    public void setInvasiveTestECOG(boolean invasiveTestECOG) {
        this.invasiveTestECOG = invasiveTestECOG;
    }

    public boolean isInvasiveTestEEG() {
        return invasiveTestEEG;
    }

    public void setInvasiveTestEEG(boolean invasiveTestEEG) {
        this.invasiveTestEEG = invasiveTestEEG;
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

    public boolean isNeuropsychologyOld() {
        return neuropsychologyOld;
    }

    public void setNeuropsychologyOld(boolean neuropsychologyOld) {
        this.neuropsychologyOld = neuropsychologyOld;
    }

    public boolean isInvasiveTestCorticalMapping() {
        return invasiveTestCorticalMapping;
    }

    public void setInvasiveTestCorticalMapping(boolean invasiveTestCorticalMapping) {
        this.invasiveTestCorticalMapping = invasiveTestCorticalMapping;
    }

    public boolean isOperation() {
        return operation;
    }

    public void setOperation(boolean operation) {
        this.operation = operation;
    }

    public boolean isOutcome() {
        return outcome;
    }

    public void setOutcome(boolean outcome) {
        this.outcome = outcome;
    }

    public boolean isPharmacotherapy() {
        return pharmacotherapy;
    }

    public void setPharmacotherapy(boolean pharmacotherapy) {
        this.pharmacotherapy = pharmacotherapy;
    }

    public boolean isSeizure() {
        return seizure;
    }

    public void setSeizure(boolean seizure) {
        this.seizure = seizure;
    }

    public boolean isAnonymize() {
        return anonymize;
    }

    public void setAnonymize(boolean anonymize) {
        this.anonymize = anonymize;
    }

    public boolean isPatientId() {
        return patientId;
    }

    public void setPatientId(boolean patientId) {
        this.patientId = patientId;
    }

    public boolean isPatientNin() {
        return patientNin;
    }

    public void setPatientNin(boolean patientNin) {
        this.patientNin = patientNin;
    }

    public boolean isPatientBirthday() {
        return patientBirthday;
    }

    public void setPatientBirthday(boolean patientBirthday) {
        this.patientBirthday = patientBirthday;
    }

    public boolean isPatientGender() {
        return patientGender;
    }

    public void setPatientGender(boolean patientGender) {
        this.patientGender = patientGender;
    }

    public boolean isPatientDoctorId() {
        return patientDoctorId;
    }

    public void setPatientDoctorId(boolean patientDoctorId) {
        this.patientDoctorId = patientDoctorId;
    }

    public boolean isPatientChecked() {
        return patientChecked;
    }

    public void setPatientChecked(boolean patientChecked) {
        this.patientChecked = patientChecked;
    }

    public boolean isPatientContactId() {
        return patientContactId;
    }

    public void setPatientContactId(boolean patientContactId) {
        this.patientContactId = patientContactId;
    }

    public boolean isPatientAgeAtTheBeginningOfEpilepsy() {
        return patientAgeAtTheBeginningOfEpilepsy;
    }

    public void setPatientAgeAtTheBeginningOfEpilepsy(boolean patientAgeAtTheBeginningOfEpilepsy) {
        this.patientAgeAtTheBeginningOfEpilepsy = patientAgeAtTheBeginningOfEpilepsy;
    }

    public boolean isContactId() {
        return contactId;
    }

    public void setContactId(boolean contactId) {
        this.contactId = contactId;
    }

    public boolean isContactFirstName() {
        return contactFirstName;
    }

    public void setContactFirstName(boolean contactFirstName) {
        this.contactFirstName = contactFirstName;
    }

    public boolean isContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(boolean contactLastName) {
        this.contactLastName = contactLastName;
    }

    public boolean isContactAddressStreet() {
        return contactAddressStreet;
    }

    public void setContactAddressStreet(boolean contactAddressStreet) {
        this.contactAddressStreet = contactAddressStreet;
    }

    public boolean isContactAddressHn() {
        return contactAddressHn;
    }

    public void setContactAddressHn(boolean contactAddressHn) {
        this.contactAddressHn = contactAddressHn;
    }

    public boolean isContactAddressCity() {
        return contactAddressCity;
    }

    public void setContactAddressCity(boolean contactAddressCity) {
        this.contactAddressCity = contactAddressCity;
    }

    public boolean isContactPostalCode() {
        return contactPostalCode;
    }

    public void setContactPostalCode(boolean contactPostalCode) {
        this.contactPostalCode = contactPostalCode;
    }

    public boolean isContactCountry() {
        return contactCountry;
    }

    public void setContactCountry(boolean contactCountry) {
        this.contactCountry = contactCountry;
    }

    public boolean isContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(boolean contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public boolean isContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(boolean contactEmail) {
        this.contactEmail = contactEmail;
    }

    public boolean isAnamnesisId() {
        return anamnesisId;
    }

    public void setAnamnesisId(boolean anamnesisId) {
        this.anamnesisId = anamnesisId;
    }

    public boolean isAnamnesisDate() {
        return anamnesisDate;
    }

    public void setAnamnesisDate(boolean anamnesisDate) {
        this.anamnesisDate = anamnesisDate;
    }

    public boolean isAnamnesisDoctorId() {
        return anamnesisDoctorId;
    }

    public void setAnamnesisDoctorId(boolean anamnesisDoctorId) {
        this.anamnesisDoctorId = anamnesisDoctorId;
    }

    public boolean isAnamnesisAdded() {
        return anamnesisAdded;
    }

    public void setAnamnesisAdded(boolean anamnesisAdded) {
        this.anamnesisAdded = anamnesisAdded;
    }

    public boolean isAnamnesisBeginningEpilepsy() {
        return anamnesisBeginningEpilepsy;
    }

    public void setAnamnesisBeginningEpilepsy(boolean anamnesisBeginningEpilepsy) {
        this.anamnesisBeginningEpilepsy = anamnesisBeginningEpilepsy;
    }

    public boolean isAnamnesisFirstFever() {
        return anamnesisFirstFever;
    }

    public void setAnamnesisFirstFever(boolean anamnesisFirstFever) {
        this.anamnesisFirstFever = anamnesisFirstFever;
    }

    public boolean isAnamnesisInfantileSpasm() {
        return anamnesisInfantileSpasm;
    }

    public void setAnamnesisInfantileSpasm(boolean anamnesisInfantileSpasm) {
        this.anamnesisInfantileSpasm = anamnesisInfantileSpasm;
    }

    public boolean isAnamnesisSpecificSyndrome() {
        return anamnesisSpecificSyndrome;
    }

    public void setAnamnesisSpecificSyndrome(boolean anamnesisSpecificSyndrome) {
        this.anamnesisSpecificSyndrome = anamnesisSpecificSyndrome;
    }

    public boolean isAnamnesisEpilepsyInFamily() {
        return anamnesisEpilepsyInFamily;
    }

    public void setAnamnesisEpilepsyInFamily(boolean anamnesisEpilepsyInFamily) {
        this.anamnesisEpilepsyInFamily = anamnesisEpilepsyInFamily;
    }

    public boolean isAnamnesisParentalRisk() {
        return anamnesisParentalRisk;
    }

    public void setAnamnesisParentalRisk(boolean anamnesisParentalRisk) {
        this.anamnesisParentalRisk = anamnesisParentalRisk;
    }

    public boolean isAnamnesisFibrilConvulsions() {
        return anamnesisFibrilConvulsions;
    }

    public void setAnamnesisFibrilConvulsions(boolean anamnesisFibrilConvulsions) {
        this.anamnesisFibrilConvulsions = anamnesisFibrilConvulsions;
    }

    public boolean isAnamnesisInflammationCns() {
        return anamnesisInflammationCns;
    }

    public void setAnamnesisInflammationCns(boolean anamnesisInflammationCns) {
        this.anamnesisInflammationCns = anamnesisInflammationCns;
    }

    public boolean isAnamnesisInjuryCns() {
        return anamnesisInjuryCns;
    }

    public void setAnamnesisInjuryCns(boolean anamnesisInjuryCns) {
        this.anamnesisInjuryCns = anamnesisInjuryCns;
    }

    public boolean isAnamnesisOperationCns() {
        return anamnesisOperationCns;
    }

    public void setAnamnesisOperationCns(boolean anamnesisOperationCns) {
        this.anamnesisOperationCns = anamnesisOperationCns;
    }

    public boolean isAnamnesisEarlyPmdRetardation() {
        return anamnesisEarlyPmdRetardation;
    }

    public void setAnamnesisEarlyPmdRetardation(boolean anamnesisEarlyPmdRetardation) {
        this.anamnesisEarlyPmdRetardation = anamnesisEarlyPmdRetardation;
    }

    public boolean isAnamnesisNonCnsComorbidity() {
        return anamnesisNonCnsComorbidity;
    }

    public void setAnamnesisNonCnsComorbidity(boolean anamnesisNonCnsComorbidity) {
        this.anamnesisNonCnsComorbidity = anamnesisNonCnsComorbidity;
    }

    public boolean isAnamnesisComment() {
        return anamnesisComment;
    }

    public void setAnamnesisComment(boolean anamnesisComment) {
        this.anamnesisComment = anamnesisComment;
    }

    public boolean isComplicationId() {
        return complicationId;
    }

    public void setComplicationId(boolean complicationId) {
        this.complicationId = complicationId;
    }

    public boolean isComplicationDate() {
        return complicationDate;
    }

    public void setComplicationDate(boolean complicationDate) {
        this.complicationDate = complicationDate;
    }

    public boolean isComplicationDoctorId() {
        return complicationDoctorId;
    }

    public void setComplicationDoctorId(boolean complicationDoctorId) {
        this.complicationDoctorId = complicationDoctorId;
    }

    public boolean isComplicationAdded() {
        return complicationAdded;
    }

    public void setComplicationAdded(boolean complicationAdded) {
        this.complicationAdded = complicationAdded;
    }

    public boolean isComplicationComment() {
        return complicationComment;
    }

    public void setComplicationComment(boolean complicationComment) {
        this.complicationComment = complicationComment;
    }

    public boolean isComplicationPatientId() {
        return complicationPatientId;
    }

    public void setComplicationPatientId(boolean complicationPatientId) {
        this.complicationPatientId = complicationPatientId;
    }

    public boolean isComplicationAddUserId() {
        return complicationAddUserId;
    }

    public void setComplicationAddUserId(boolean complicationAddUserId) {
        this.complicationAddUserId = complicationAddUserId;
    }

    public boolean isComplicationWithCompication() {
        return ComplicationWithCompication;
    }

    public void setComplicationWithCompication(boolean complicationWithCompication) {
        ComplicationWithCompication = complicationWithCompication;
    }

    public boolean isComplicationComplicationType() {
        return ComplicationComplicationType;
    }

    public void setComplicationComplicationType(boolean complicationComplicationType) {
        ComplicationComplicationType = complicationComplicationType;
    }

    public boolean isComplicationComplication() {
        return ComplicationComplication;
    }

    public void setComplicationComplication(boolean complicationComplication) {
        ComplicationComplication = complicationComplication;
    }

    public boolean isDiagnosticTestEEGId() {
        return diagnosticTestEEGId;
    }

    public void setDiagnosticTestEEGId(boolean diagnosticTestEEGId) {
        this.diagnosticTestEEGId = diagnosticTestEEGId;
    }

    public boolean isDiagnosticTestEEGDate() {
        return diagnosticTestEEGDate;
    }

    public void setDiagnosticTestEEGDate(boolean diagnosticTestEEGDate) {
        this.diagnosticTestEEGDate = diagnosticTestEEGDate;
    }

    public boolean isDiagnosticTestEEGDone() {
        return diagnosticTestEEGDone;
    }

    public void setDiagnosticTestEEGDone(boolean diagnosticTestEEGDone) {
        this.diagnosticTestEEGDone = diagnosticTestEEGDone;
    }

    public boolean isDiagnosticTestEEGDoctorId() {
        return diagnosticTestEEGDoctorId;
    }

    public void setDiagnosticTestEEGDoctorId(boolean diagnosticTestEEGDoctorId) {
        this.diagnosticTestEEGDoctorId = diagnosticTestEEGDoctorId;
    }

    public boolean isDiagnosticTestEEGAdded() {
        return diagnosticTestEEGAdded;
    }

    public void setDiagnosticTestEEGAdded(boolean diagnosticTestEEGAdded) {
        this.diagnosticTestEEGAdded = diagnosticTestEEGAdded;
    }

    public boolean isDiagnosticTestEEGBasicActivity() {
        return diagnosticTestEEGBasicActivity;
    }

    public void setDiagnosticTestEEGBasicActivity(boolean diagnosticTestEEGBasicActivity) {
        this.diagnosticTestEEGBasicActivity = diagnosticTestEEGBasicActivity;
    }

    public boolean isDiagnosticTestEEGSlow() {
        return diagnosticTestEEGSlow;
    }

    public void setDiagnosticTestEEGSlow(boolean diagnosticTestEEGSlow) {
        this.diagnosticTestEEGSlow = diagnosticTestEEGSlow;
    }

    public boolean isDiagnosticTestEEGInterictalEEGSpikes() {
        return diagnosticTestEEGInterictalEEGSpikes;
    }

    public void setDiagnosticTestEEGInterictalEEGSpikes(boolean diagnosticTestEEGInterictalEEGSpikes) {
        this.diagnosticTestEEGInterictalEEGSpikes = diagnosticTestEEGInterictalEEGSpikes;
    }

    public boolean isDiagnosticTestEEGLocalizationInerictalEEGSpikes() {
        return diagnosticTestEEGLocalizationInerictalEEGSpikes;
    }

    public void setDiagnosticTestEEGLocalizationInerictalEEGSpikes(boolean diagnosticTestEEGLocalizationInerictalEEGSpikes) {
        this.diagnosticTestEEGLocalizationInerictalEEGSpikes = diagnosticTestEEGLocalizationInerictalEEGSpikes;
    }

    public boolean isDiagnosticTestEEGStatusEpilepticus() {
        return diagnosticTestEEGStatusEpilepticus;
    }

    public void setDiagnosticTestEEGStatusEpilepticus(boolean diagnosticTestEEGStatusEpilepticus) {
        this.diagnosticTestEEGStatusEpilepticus = diagnosticTestEEGStatusEpilepticus;
    }

    public boolean isDiagnosticTestEEGSecondarySidedSynchrony() {
        return diagnosticTestEEGSecondarySidedSynchrony;
    }

    public void setDiagnosticTestEEGSecondarySidedSynchrony(boolean diagnosticTestEEGSecondarySidedSynchrony) {
        this.diagnosticTestEEGSecondarySidedSynchrony = diagnosticTestEEGSecondarySidedSynchrony;
    }

    public boolean isDiagnosticTestEEGIctalEEGPatterns() {
        return diagnosticTestEEGIctalEEGPatterns;
    }

    public void setDiagnosticTestEEGIctalEEGPatterns(boolean diagnosticTestEEGIctalEEGPatterns) {
        this.diagnosticTestEEGIctalEEGPatterns = diagnosticTestEEGIctalEEGPatterns;
    }

    public boolean isDiagnosticTestEEGLocalizationIctalEEGPattern() {
        return diagnosticTestEEGLocalizationIctalEEGPattern;
    }

    public void setDiagnosticTestEEGLocalizationIctalEEGPattern(boolean diagnosticTestEEGLocalizationIctalEEGPattern) {
        this.diagnosticTestEEGLocalizationIctalEEGPattern = diagnosticTestEEGLocalizationIctalEEGPattern;
    }

    public boolean isDiagnosticTestEEGComment() {
        return diagnosticTestEEGComment;
    }

    public void setDiagnosticTestEEGComment(boolean diagnosticTestEEGComment) {
        this.diagnosticTestEEGComment = diagnosticTestEEGComment;
    }

    public boolean isDiagnosticTestEEGAddUserId() {
        return diagnosticTestEEGAddUserId;
    }

    public void setDiagnosticTestEEGAddUserId(boolean diagnosticTestEEGAddUserId) {
        this.diagnosticTestEEGAddUserId = diagnosticTestEEGAddUserId;
    }

    public boolean isDiagnosticTestEEGPatientId() {
        return diagnosticTestEEGPatientId;
    }

    public void setDiagnosticTestEEGPatientId(boolean diagnosticTestEEGPatientId) {
        this.diagnosticTestEEGPatientId = diagnosticTestEEGPatientId;
    }

    public boolean isDiagnosticTestEEGDescriptionVideoEEG() {
        return diagnosticTestEEGDescriptionVideoEEG;
    }

    public void setDiagnosticTestEEGDescriptionVideoEEG(boolean diagnosticTestEEGDescriptionVideoEEG) {
        this.diagnosticTestEEGDescriptionVideoEEG = diagnosticTestEEGDescriptionVideoEEG;
    }

    public boolean isDiagnosticTestMRIId() {
        return diagnosticTestMRIId;
    }

    public void setDiagnosticTestMRIId(boolean diagnosticTestMRIId) {
        this.diagnosticTestMRIId = diagnosticTestMRIId;
    }

    public boolean isDiagnosticTestMRIDone() {
        return diagnosticTestMRIDone;
    }

    public void setDiagnosticTestMRIDone(boolean diagnosticTestMRIDone) {
        this.diagnosticTestMRIDone = diagnosticTestMRIDone;
    }

    public boolean isDiagnosticTestMRIDate() {
        return diagnosticTestMRIDate;
    }

    public void setDiagnosticTestMRIDate(boolean diagnosticTestMRIDate) {
        this.diagnosticTestMRIDate = diagnosticTestMRIDate;
    }

    public boolean isDiagnosticTestMRIDoctorId() {
        return diagnosticTestMRIDoctorId;
    }

    public void setDiagnosticTestMRIDoctorId(boolean diagnosticTestMRIDoctorId) {
        this.diagnosticTestMRIDoctorId = diagnosticTestMRIDoctorId;
    }

    public boolean isDiagnosticTestMRIAdded() {
        return diagnosticTestMRIAdded;
    }

    public void setDiagnosticTestMRIAdded(boolean diagnosticTestMRIAdded) {
        this.diagnosticTestMRIAdded = diagnosticTestMRIAdded;
    }

    public boolean isDiagnosticTestMRIProtocol() {
        return diagnosticTestMRIProtocol;
    }

    public void setDiagnosticTestMRIProtocol(boolean diagnosticTestMRIProtocol) {
        this.diagnosticTestMRIProtocol = diagnosticTestMRIProtocol;
    }

    public boolean isDiagnosticTestMRIFdgPet() {
        return diagnosticTestMRIFdgPet;
    }

    public void setDiagnosticTestMRIFdgPet(boolean diagnosticTestMRIFdgPet) {
        this.diagnosticTestMRIFdgPet = diagnosticTestMRIFdgPet;
    }

    public boolean isDiagnosticTestMRIInterictalSpect() {
        return diagnosticTestMRIInterictalSpect;
    }

    public void setDiagnosticTestMRIInterictalSpect(boolean diagnosticTestMRIInterictalSpect) {
        this.diagnosticTestMRIInterictalSpect = diagnosticTestMRIInterictalSpect;
    }

    public boolean isDiagnosticTestMRISiscom() {
        return diagnosticTestMRISiscom;
    }

    public void setDiagnosticTestMRISiscom(boolean diagnosticTestMRISiscom) {
        this.diagnosticTestMRISiscom = diagnosticTestMRISiscom;
    }

    public boolean isDiagnosticTestMRIMrsProtocol() {
        return diagnosticTestMRIMrsProtocol;
    }

    public void setDiagnosticTestMRIMrsProtocol(boolean diagnosticTestMRIMrsProtocol) {
        this.diagnosticTestMRIMrsProtocol = diagnosticTestMRIMrsProtocol;
    }

    public boolean isDiagnosticTestMRIMrsFinding() {
        return diagnosticTestMRIMrsFinding;
    }

    public void setDiagnosticTestMRIMrsFinding(boolean diagnosticTestMRIMrsFinding) {
        this.diagnosticTestMRIMrsFinding = diagnosticTestMRIMrsFinding;
    }

    public boolean isDiagnosticTestMRIFinding() {
        return diagnosticTestMRIFinding;
    }

    public void setDiagnosticTestMRIFinding(boolean diagnosticTestMRIFinding) {
        this.diagnosticTestMRIFinding = diagnosticTestMRIFinding;
    }

    public boolean isDiagnosticTestMRIDescription() {
        return diagnosticTestMRIDescription;
    }

    public void setDiagnosticTestMRIDescription(boolean diagnosticTestMRIDescription) {
        this.diagnosticTestMRIDescription = diagnosticTestMRIDescription;
    }

    public boolean isDiagnosticTestMRIDescriptionPetHypometabolism() {
        return diagnosticTestMRIDescriptionPetHypometabolism;
    }

    public void setDiagnosticTestMRIDescriptionPetHypometabolism(boolean diagnosticTestMRIDescriptionPetHypometabolism) {
        this.diagnosticTestMRIDescriptionPetHypometabolism = diagnosticTestMRIDescriptionPetHypometabolism;
    }

    public boolean isDiagnosticTestMRIDescriptionSpectHypoperfuse() {
        return diagnosticTestMRIDescriptionSpectHypoperfuse;
    }

    public void setDiagnosticTestMRIDescriptionSpectHypoperfuse(boolean diagnosticTestMRIDescriptionSpectHypoperfuse) {
        this.diagnosticTestMRIDescriptionSpectHypoperfuse = diagnosticTestMRIDescriptionSpectHypoperfuse;
    }

    public boolean isDiagnosticTestMRIDescriptionMrsAbnormality() {
        return diagnosticTestMRIDescriptionMrsAbnormality;
    }

    public void setDiagnosticTestMRIDescriptionMrsAbnormality(boolean diagnosticTestMRIDescriptionMrsAbnormality) {
        this.diagnosticTestMRIDescriptionMrsAbnormality = diagnosticTestMRIDescriptionMrsAbnormality;
    }

    public boolean isDiagnosticTestMRIDescriptionSpectHyperperfuse() {
        return diagnosticTestMRIDescriptionSpectHyperperfuse;
    }

    public void setDiagnosticTestMRIDescriptionSpectHyperperfuse(boolean diagnosticTestMRIDescriptionSpectHyperperfuse) {
        this.diagnosticTestMRIDescriptionSpectHyperperfuse = diagnosticTestMRIDescriptionSpectHyperperfuse;
    }

    public boolean isDiagnosticTestMRIIctalSpect() {
        return diagnosticTestMRIIctalSpect;
    }

    public void setDiagnosticTestMRIIctalSpect(boolean diagnosticTestMRIIctalSpect) {
        this.diagnosticTestMRIIctalSpect = diagnosticTestMRIIctalSpect;
    }

    public boolean isDiagnosticTestMRIDti() {
        return diagnosticTestMRIDti;
    }

    public void setDiagnosticTestMRIDti(boolean diagnosticTestMRIDti) {
        this.diagnosticTestMRIDti = diagnosticTestMRIDti;
    }

    public boolean isDiagnosticTestMRIDtiDetailStudy() {
        return diagnosticTestMRIDtiDetailStudy;
    }

    public void setDiagnosticTestMRIDtiDetailStudy(boolean diagnosticTestMRIDtiDetailStudy) {
        this.diagnosticTestMRIDtiDetailStudy = diagnosticTestMRIDtiDetailStudy;
    }

    public boolean isDiagnosticTestMRIFmri() {
        return diagnosticTestMRIFmri;
    }

    public void setDiagnosticTestMRIFmri(boolean diagnosticTestMRIFmri) {
        this.diagnosticTestMRIFmri = diagnosticTestMRIFmri;
    }

    public boolean isDiagnosticTestMRIDetailsFmri() {
        return diagnosticTestMRIDetailsFmri;
    }

    public void setDiagnosticTestMRIDetailsFmri(boolean diagnosticTestMRIDetailsFmri) {
        this.diagnosticTestMRIDetailsFmri = diagnosticTestMRIDetailsFmri;
    }

    public boolean isDiagnosticTestMRIDetailsDtiStudy() {
        return diagnosticTestMRIDetailsDtiStudy;
    }

    public void setDiagnosticTestMRIDetailsDtiStudy(boolean diagnosticTestMRIDetailsDtiStudy) {
        this.diagnosticTestMRIDetailsDtiStudy = diagnosticTestMRIDetailsDtiStudy;
    }

    public boolean isDiagnosticTestMRIWada() {
        return diagnosticTestMRIWada;
    }

    public void setDiagnosticTestMRIWada(boolean diagnosticTestMRIWada) {
        this.diagnosticTestMRIWada = diagnosticTestMRIWada;
    }

    public boolean isDiagnosticTestMRIDetailsWada() {
        return diagnosticTestMRIDetailsWada;
    }

    public void setDiagnosticTestMRIDetailsWada(boolean diagnosticTestMRIDetailsWada) {
        this.diagnosticTestMRIDetailsWada = diagnosticTestMRIDetailsWada;
    }

    public boolean isDiagnosticTestMRIDescribe() {
        return diagnosticTestMRIDescribe;
    }

    public void setDiagnosticTestMRIDescribe(boolean diagnosticTestMRIDescribe) {
        this.diagnosticTestMRIDescribe = diagnosticTestMRIDescribe;
    }

    public boolean isDiagnosticTestMRILocalizationSpecHypoperfuse() {
        return diagnosticTestMRILocalizationSpecHypoperfuse;
    }

    public void setDiagnosticTestMRILocalizationSpecHypoperfuse(boolean diagnosticTestMRILocalizationSpecHypoperfuse) {
        this.diagnosticTestMRILocalizationSpecHypoperfuse = diagnosticTestMRILocalizationSpecHypoperfuse;
    }

    public boolean isDiagnosticTestMRILocalizationMrsAbnormality() {
        return diagnosticTestMRILocalizationMrsAbnormality;
    }

    public void setDiagnosticTestMRILocalizationMrsAbnormality(boolean diagnosticTestMRILocalizationMrsAbnormality) {
        this.diagnosticTestMRILocalizationMrsAbnormality = diagnosticTestMRILocalizationMrsAbnormality;
    }

    public boolean isDiagnosticTestMRILocalizationPetHypometabolism() {
        return diagnosticTestMRILocalizationPetHypometabolism;
    }

    public void setDiagnosticTestMRILocalizationPetHypometabolism(boolean diagnosticTestMRILocalizationPetHypometabolism) {
        this.diagnosticTestMRILocalizationPetHypometabolism = diagnosticTestMRILocalizationPetHypometabolism;
    }

    public boolean isDiagnosticTestMRILocalizationSpecHyperperfuse() {
        return diagnosticTestMRILocalizationSpecHyperperfuse;
    }

    public void setDiagnosticTestMRILocalizationSpecHyperperfuse(boolean diagnosticTestMRILocalizationSpecHyperperfuse) {
        this.diagnosticTestMRILocalizationSpecHyperperfuse = diagnosticTestMRILocalizationSpecHyperperfuse;
    }

    public boolean isDiagnosticTestMRIFmriProtocols() {
        return diagnosticTestMRIFmriProtocols;
    }

    public void setDiagnosticTestMRIFmriProtocols(boolean diagnosticTestMRIFmriProtocols) {
        this.diagnosticTestMRIFmriProtocols = diagnosticTestMRIFmriProtocols;
    }

    public boolean isDiagnosticTestMRIComment() {
        return diagnosticTestMRIComment;
    }

    public void setDiagnosticTestMRIComment(boolean diagnosticTestMRIComment) {
        this.diagnosticTestMRIComment = diagnosticTestMRIComment;
    }

    public boolean isDiagnosticTestMRIPatientId() {
        return diagnosticTestMRIPatientId;
    }

    public void setDiagnosticTestMRIPatientId(boolean diagnosticTestMRIPatientId) {
        this.diagnosticTestMRIPatientId = diagnosticTestMRIPatientId;
    }

    public boolean isDiagnosticTestMRIAddUserId() {
        return diagnosticTestMRIAddUserId;
    }

    public void setDiagnosticTestMRIAddUserId(boolean diagnosticTestMRIAddUserId) {
        this.diagnosticTestMRIAddUserId = diagnosticTestMRIAddUserId;
    }

    public boolean isHistologyId() {
        return histologyId;
    }

    public void setHistologyId(boolean histologyId) {
        this.histologyId = histologyId;
    }

    public boolean isHistologyDate() {
        return histologyDate;
    }

    public void setHistologyDate(boolean histologyDate) {
        this.histologyDate = histologyDate;
    }

    public boolean isHistologyDoctorId() {
        return histologyDoctorId;
    }

    public void setHistologyDoctorId(boolean histologyDoctorId) {
        this.histologyDoctorId = histologyDoctorId;
    }

    public boolean isHistologyAdded() {
        return histologyAdded;
    }

    public void setHistologyAdded(boolean histologyAdded) {
        this.histologyAdded = histologyAdded;
    }

    public boolean isHistologyHistopathology() {
        return histologyHistopathology;
    }

    public void setHistologyHistopathology(boolean histologyHistopathology) {
        this.histologyHistopathology = histologyHistopathology;
    }

    public boolean isHistologyFcdClassification() {
        return histologyFcdClassification;
    }

    public void setHistologyFcdClassification(boolean histologyFcdClassification) {
        this.histologyFcdClassification = histologyFcdClassification;
    }

    public boolean isHistologyComment() {
        return histologyComment;
    }

    public void setHistologyComment(boolean histologyComment) {
        this.histologyComment = histologyComment;
    }

    public boolean isHistologyPatientId() {
        return histologyPatientId;
    }

    public void setHistologyPatientId(boolean histologyPatientId) {
        this.histologyPatientId = histologyPatientId;
    }

    public boolean isHistologyAddUserId() {
        return histologyAddUserId;
    }

    public void setHistologyAddUserId(boolean histologyAddUserId) {
        this.histologyAddUserId = histologyAddUserId;
    }

    public boolean isInvasiveTestECOGId() {
        return invasiveTestECOGId;
    }

    public void setInvasiveTestECOGId(boolean invasiveTestECOGId) {
        this.invasiveTestECOGId = invasiveTestECOGId;
    }

    public boolean isInvasiveTestECOGDate() {
        return invasiveTestECOGDate;
    }

    public void setInvasiveTestECOGDate(boolean invasiveTestECOGDate) {
        this.invasiveTestECOGDate = invasiveTestECOGDate;
    }

    public boolean isInvasiveTestECOGDone() {
        return invasiveTestECOGDone;
    }

    public void setInvasiveTestECOGDone(boolean invasiveTestECOGDone) {
        this.invasiveTestECOGDone = invasiveTestECOGDone;
    }

    public boolean isInvasiveTestECOGIntracranialElectrodes() {
        return invasiveTestECOGIntracranialElectrodes;
    }

    public void setInvasiveTestECOGIntracranialElectrodes(boolean invasiveTestECOGIntracranialElectrodes) {
        this.invasiveTestECOGIntracranialElectrodes = invasiveTestECOGIntracranialElectrodes;
    }

    public boolean isInvasiveTestECOGDoctorId() {
        return invasiveTestECOGDoctorId;
    }

    public void setInvasiveTestECOGDoctorId(boolean invasiveTestECOGDoctorId) {
        this.invasiveTestECOGDoctorId = invasiveTestECOGDoctorId;
    }

    public boolean isInvasiveTestECOGAdded() {
        return invasiveTestECOGAdded;
    }

    public void setInvasiveTestECOGAdded(boolean invasiveTestECOGAdded) {
        this.invasiveTestECOGAdded = invasiveTestECOGAdded;
    }

    public boolean isInvasiveTestECOGIntraOperativeEcog() {
        return invasiveTestECOGIntraOperativeEcog;
    }

    public void setInvasiveTestECOGIntraOperativeEcog(boolean invasiveTestECOGIntraOperativeEcog) {
        this.invasiveTestECOGIntraOperativeEcog = invasiveTestECOGIntraOperativeEcog;
    }

    public boolean isInvasiveTestECOGEcogPatterns() {
        return invasiveTestECOGEcogPatterns;
    }

    public void setInvasiveTestECOGEcogPatterns(boolean invasiveTestECOGEcogPatterns) {
        this.invasiveTestECOGEcogPatterns = invasiveTestECOGEcogPatterns;
    }

    public boolean isInvasiveTestECOGEcogCover() {
        return invasiveTestECOGEcogCover;
    }

    public void setInvasiveTestECOGEcogCover(boolean invasiveTestECOGEcogCover) {
        this.invasiveTestECOGEcogCover = invasiveTestECOGEcogCover;
    }

    public boolean isInvasiveTestECOGAfterResectionEcog() {
        return invasiveTestECOGAfterResectionEcog;
    }

    public void setInvasiveTestECOGAfterResectionEcog(boolean invasiveTestECOGAfterResectionEcog) {
        this.invasiveTestECOGAfterResectionEcog = invasiveTestECOGAfterResectionEcog;
    }

    public boolean isInvasiveTestECOGAwakeCraniotomy() {
        return invasiveTestECOGAwakeCraniotomy;
    }

    public void setInvasiveTestECOGAwakeCraniotomy(boolean invasiveTestECOGAwakeCraniotomy) {
        this.invasiveTestECOGAwakeCraniotomy = invasiveTestECOGAwakeCraniotomy;
    }

    public boolean isInvasiveTestECOGComment() {
        return invasiveTestECOGComment;
    }

    public void setInvasiveTestECOGComment(boolean invasiveTestECOGComment) {
        this.invasiveTestECOGComment = invasiveTestECOGComment;
    }

    public boolean isInvasiveTestECOGAddUserId() {
        return invasiveTestECOGAddUserId;
    }

    public void setInvasiveTestECOGAddUserId(boolean invasiveTestECOGAddUserId) {
        this.invasiveTestECOGAddUserId = invasiveTestECOGAddUserId;
    }

    public boolean isInvasiveTestECOGPatientId() {
        return invasiveTestECOGPatientId;
    }

    public void setInvasiveTestECOGPatientId(boolean invasiveTestECOGPatientId) {
        this.invasiveTestECOGPatientId = invasiveTestECOGPatientId;
    }

    public boolean isInvasiveTestEEGId() {
        return invasiveTestEEGId;
    }

    public void setInvasiveTestEEGId(boolean invasiveTestEEGId) {
        this.invasiveTestEEGId = invasiveTestEEGId;
    }

    public boolean isInvasiveTestEEGDate() {
        return invasiveTestEEGDate;
    }

    public void setInvasiveTestEEGDate(boolean invasiveTestEEGDate) {
        this.invasiveTestEEGDate = invasiveTestEEGDate;
    }

    public boolean isInvasiveTestEEGDone() {
        return invasiveTestEEGDone;
    }

    public void setInvasiveTestEEGDone(boolean invasiveTestEEGDone) {
        this.invasiveTestEEGDone = invasiveTestEEGDone;
    }

    public boolean isInvasiveTestEEGDoctorId() {
        return invasiveTestEEGDoctorId;
    }

    public void setInvasiveTestEEGDoctorId(boolean invasiveTestEEGDoctorId) {
        this.invasiveTestEEGDoctorId = invasiveTestEEGDoctorId;
    }

    public boolean isInvasiveTestEEGAdded() {
        return invasiveTestEEGAdded;
    }

    public void setInvasiveTestEEGAdded(boolean invasiveTestEEGAdded) {
        this.invasiveTestEEGAdded = invasiveTestEEGAdded;
    }

    public boolean isInvasiveTestEEGInvasiveMonitoring() {
        return invasiveTestEEGInvasiveMonitoring;
    }

    public void setInvasiveTestEEGInvasiveMonitoring(boolean invasiveTestEEGInvasiveMonitoring) {
        this.invasiveTestEEGInvasiveMonitoring = invasiveTestEEGInvasiveMonitoring;
    }

    public boolean isInvasiveTestEEGLocalizationIntracranialElectrodes() {
        return invasiveTestEEGLocalizationIntracranialElectrodes;
    }

    public void setInvasiveTestEEGLocalizationIntracranialElectrodes(boolean invasiveTestEEGLocalizationIntracranialElectrodes) {
        this.invasiveTestEEGLocalizationIntracranialElectrodes = invasiveTestEEGLocalizationIntracranialElectrodes;
    }

    public boolean isInvasiveTestEEGIntracranialElectrodes() {
        return invasiveTestEEGIntracranialElectrodes;
    }

    public void setInvasiveTestEEGIntracranialElectrodes(boolean invasiveTestEEGIntracranialElectrodes) {
        this.invasiveTestEEGIntracranialElectrodes = invasiveTestEEGIntracranialElectrodes;
    }

    public boolean isInvasiveTestEEGInvasiveEEGSlow() {
        return invasiveTestEEGInvasiveEEGSlow;
    }

    public void setInvasiveTestEEGInvasiveEEGSlow(boolean invasiveTestEEGInvasiveEEGSlow) {
        this.invasiveTestEEGInvasiveEEGSlow = invasiveTestEEGInvasiveEEGSlow;
    }

    public boolean isInvasiveTestEEGInvasiveEEGInterictalSpikes() {
        return invasiveTestEEGInvasiveEEGInterictalSpikes;
    }

    public void setInvasiveTestEEGInvasiveEEGInterictalSpikes(boolean invasiveTestEEGInvasiveEEGInterictalSpikes) {
        this.invasiveTestEEGInvasiveEEGInterictalSpikes = invasiveTestEEGInvasiveEEGInterictalSpikes;
    }

    public boolean isInvasiveTestEEGLocalizationInvasiveEEGInterictalSpikes() {
        return invasiveTestEEGLocalizationInvasiveEEGInterictalSpikes;
    }

    public void setInvasiveTestEEGLocalizationInvasiveEEGInterictalSpikes(boolean invasiveTestEEGLocalizationInvasiveEEGInterictalSpikes) {
        this.invasiveTestEEGLocalizationInvasiveEEGInterictalSpikes = invasiveTestEEGLocalizationInvasiveEEGInterictalSpikes;
    }

    public boolean isInvasiveTestEEGStatusEpilepticus() {
        return invasiveTestEEGStatusEpilepticus;
    }

    public void setInvasiveTestEEGStatusEpilepticus(boolean invasiveTestEEGStatusEpilepticus) {
        this.invasiveTestEEGStatusEpilepticus = invasiveTestEEGStatusEpilepticus;
    }

    public boolean isInvasiveTestEEGInvasiveIctalEEGPatterns() {
        return invasiveTestEEGInvasiveIctalEEGPatterns;
    }

    public void setInvasiveTestEEGInvasiveIctalEEGPatterns(boolean invasiveTestEEGInvasiveIctalEEGPatterns) {
        this.invasiveTestEEGInvasiveIctalEEGPatterns = invasiveTestEEGInvasiveIctalEEGPatterns;
    }

    public boolean isInvasiveTestEEGLocalizationIctalEEGPatterns() {
        return invasiveTestEEGLocalizationIctalEEGPatterns;
    }

    public void setInvasiveTestEEGLocalizationIctalEEGPatterns(boolean invasiveTestEEGLocalizationIctalEEGPatterns) {
        this.invasiveTestEEGLocalizationIctalEEGPatterns = invasiveTestEEGLocalizationIctalEEGPatterns;
    }

    public boolean isInvasiveTestEEGComment() {
        return invasiveTestEEGComment;
    }

    public void setInvasiveTestEEGComment(boolean invasiveTestEEGComment) {
        this.invasiveTestEEGComment = invasiveTestEEGComment;
    }

    public boolean isInvasiveTestEEGAddUserId() {
        return invasiveTestEEGAddUserId;
    }

    public void setInvasiveTestEEGAddUserId(boolean invasiveTestEEGAddUserId) {
        this.invasiveTestEEGAddUserId = invasiveTestEEGAddUserId;
    }

    public boolean isInvasiveTestEEGPatientId() {
        return invasiveTestEEGPatientId;
    }

    public void setInvasiveTestEEGPatientId(boolean invasiveTestEEGPatientId) {
        this.invasiveTestEEGPatientId = invasiveTestEEGPatientId;
    }

    public boolean isNeurologicalFindingId() {
        return neurologicalFindingId;
    }

    public void setNeurologicalFindingId(boolean neurologicalFindingId) {
        this.neurologicalFindingId = neurologicalFindingId;
    }

    public boolean isNeurologicalFindingDate() {
        return neurologicalFindingDate;
    }

    public void setNeurologicalFindingDate(boolean neurologicalFindingDate) {
        this.neurologicalFindingDate = neurologicalFindingDate;
    }

    public boolean isNeurologicalFindingDoctorId() {
        return neurologicalFindingDoctorId;
    }

    public void setNeurologicalFindingDoctorId(boolean neurologicalFindingDoctorId) {
        this.neurologicalFindingDoctorId = neurologicalFindingDoctorId;
    }

    public boolean isNeurologicalFindingAdded() {
        return neurologicalFindingAdded;
    }

    public void setNeurologicalFindingAdded(boolean neurologicalFindingAdded) {
        this.neurologicalFindingAdded = neurologicalFindingAdded;
    }

    public boolean isNeurologicalFindingHemisphereDominance() {
        return neurologicalFindingHemisphereDominance;
    }

    public void setNeurologicalFindingHemisphereDominance(boolean neurologicalFindingHemisphereDominance) {
        this.neurologicalFindingHemisphereDominance = neurologicalFindingHemisphereDominance;
    }

    public boolean isNeurologicalFindingAbnormalNeurologicalFinding() {
        return neurologicalFindingAbnormalNeurologicalFinding;
    }

    public void setNeurologicalFindingAbnormalNeurologicalFinding(boolean neurologicalFindingAbnormalNeurologicalFinding) {
        this.neurologicalFindingAbnormalNeurologicalFinding = neurologicalFindingAbnormalNeurologicalFinding;
    }

    public boolean isNeurologicalFindingHemiparesis() {
        return neurologicalFindingHemiparesis;
    }

    public void setNeurologicalFindingHemiparesis(boolean neurologicalFindingHemiparesis) {
        this.neurologicalFindingHemiparesis = neurologicalFindingHemiparesis;
    }

    public boolean isNeurologicalFindingVisualFieldDefects() {
        return neurologicalFindingVisualFieldDefects;
    }

    public void setNeurologicalFindingVisualFieldDefects(boolean neurologicalFindingVisualFieldDefects) {
        this.neurologicalFindingVisualFieldDefects = neurologicalFindingVisualFieldDefects;
    }

    public boolean isNeurologicalFindingComment() {
        return neurologicalFindingComment;
    }

    public void setNeurologicalFindingComment(boolean neurologicalFindingComment) {
        this.neurologicalFindingComment = neurologicalFindingComment;
    }

    public boolean isNeurologicalFindingAddUserId() {
        return neurologicalFindingAddUserId;
    }

    public void setNeurologicalFindingAddUserId(boolean neurologicalFindingAddUserId) {
        this.neurologicalFindingAddUserId = neurologicalFindingAddUserId;
    }

    public boolean isNeurologicalFindingPatientId() {
        return neurologicalFindingPatientId;
    }

    public void setNeurologicalFindingPatientId(boolean neurologicalFindingPatientId) {
        this.neurologicalFindingPatientId = neurologicalFindingPatientId;
    }

    public boolean isNeuropsychologyId() {
        return neuropsychologyId;
    }

    public void setNeuropsychologyId(boolean neuropsychologyId) {
        this.neuropsychologyId = neuropsychologyId;
    }

    public boolean isNeuropsychologyDate() {
        return neuropsychologyDate;
    }

    public void setNeuropsychologyDate(boolean neuropsychologyDate) {
        this.neuropsychologyDate = neuropsychologyDate;
    }

    public boolean isNeuropsychologyDoctorId() {
        return neuropsychologyDoctorId;
    }

    public void setNeuropsychologyDoctorId(boolean neuropsychologyDoctorId) {
        this.neuropsychologyDoctorId = neuropsychologyDoctorId;
    }

    public boolean isNeuropsychologyAdded() {
        return neuropsychologyAdded;
    }

    public void setNeuropsychologyAdded(boolean neuropsychologyAdded) {
        this.neuropsychologyAdded = neuropsychologyAdded;
    }

    public boolean isNeuropsychologyIntellect() {
        return neuropsychologyIntellect;
    }

    public void setNeuropsychologyIntellect(boolean neuropsychologyIntellect) {
        this.neuropsychologyIntellect = neuropsychologyIntellect;
    }

    public boolean isNeuropsychologyNeurodevelopmentalExamination() {
        return neuropsychologyNeurodevelopmentalExamination;
    }

    public void setNeuropsychologyNeurodevelopmentalExamination(boolean neuropsychologyNeurodevelopmentalExamination) {
        this.neuropsychologyNeurodevelopmentalExamination = neuropsychologyNeurodevelopmentalExamination;
    }

    public boolean isNeuropsychologyNeurodevelopmentalExaminationAdaptability() {
        return neuropsychologyNeurodevelopmentalExaminationAdaptability;
    }

    public void setNeuropsychologyNeurodevelopmentalExaminationAdaptability(boolean neuropsychologyNeurodevelopmentalExaminationAdaptability) {
        this.neuropsychologyNeurodevelopmentalExaminationAdaptability = neuropsychologyNeurodevelopmentalExaminationAdaptability;
    }

    public boolean isNeuropsychologyNeurodevelopmentalExaminationSpeechExpressively() {
        return neuropsychologyNeurodevelopmentalExaminationSpeechExpressively;
    }

    public void setNeuropsychologyNeurodevelopmentalExaminationSpeechExpressively(boolean neuropsychologyNeurodevelopmentalExaminationSpeechExpressively) {
        this.neuropsychologyNeurodevelopmentalExaminationSpeechExpressively = neuropsychologyNeurodevelopmentalExaminationSpeechExpressively;
    }

    public boolean isNeuropsychologyNeurodevelopmentalExaminationSpeechReceptively() {
        return neuropsychologyNeurodevelopmentalExaminationSpeechReceptively;
    }

    public void setNeuropsychologyNeurodevelopmentalExaminationSpeechReceptively(boolean neuropsychologyNeurodevelopmentalExaminationSpeechReceptively) {
        this.neuropsychologyNeurodevelopmentalExaminationSpeechReceptively = neuropsychologyNeurodevelopmentalExaminationSpeechReceptively;
    }

    public boolean isNeuropsychologyNeurodevelopmentalExaminationFineMotorSkills() {
        return neuropsychologyNeurodevelopmentalExaminationFineMotorSkills;
    }

    public void setNeuropsychologyNeurodevelopmentalExaminationFineMotorSkills(boolean neuropsychologyNeurodevelopmentalExaminationFineMotorSkills) {
        this.neuropsychologyNeurodevelopmentalExaminationFineMotorSkills = neuropsychologyNeurodevelopmentalExaminationFineMotorSkills;
    }

    public boolean isNeuropsychologyNeurodevelopmentalExaminationGrossMotorSkills() {
        return neuropsychologyNeurodevelopmentalExaminationGrossMotorSkills;
    }

    public void setNeuropsychologyNeurodevelopmentalExaminationGrossMotorSkills(boolean neuropsychologyNeurodevelopmentalExaminationGrossMotorSkills) {
        this.neuropsychologyNeurodevelopmentalExaminationGrossMotorSkills = neuropsychologyNeurodevelopmentalExaminationGrossMotorSkills;
    }

    public boolean isNeuropsychologyNeurodevelopmentalExaminationSocialBehavior() {
        return neuropsychologyNeurodevelopmentalExaminationSocialBehavior;
    }

    public void setNeuropsychologyNeurodevelopmentalExaminationSocialBehavior(boolean neuropsychologyNeurodevelopmentalExaminationSocialBehavior) {
        this.neuropsychologyNeurodevelopmentalExaminationSocialBehavior = neuropsychologyNeurodevelopmentalExaminationSocialBehavior;
    }

    public boolean isNeuropsychologyIntellectualPerformance() {
        return neuropsychologyIntellectualPerformance;
    }

    public void setNeuropsychologyIntellectualPerformance(boolean neuropsychologyIntellectualPerformance) {
        this.neuropsychologyIntellectualPerformance = neuropsychologyIntellectualPerformance;
    }

    public boolean isNeuropsychologyIntellectualPerformanceVerbally() {
        return neuropsychologyIntellectualPerformanceVerbally;
    }

    public void setNeuropsychologyIntellectualPerformanceVerbally(boolean neuropsychologyIntellectualPerformanceVerbally) {
        this.neuropsychologyIntellectualPerformanceVerbally = neuropsychologyIntellectualPerformanceVerbally;
    }

    public boolean isNeuropsychologyIntellectualPerformanceNonverbalAbstraction() {
        return neuropsychologyIntellectualPerformanceNonverbalAbstraction;
    }

    public void setNeuropsychologyIntellectualPerformanceNonverbalAbstraction(boolean neuropsychologyIntellectualPerformanceNonverbalAbstraction) {
        this.neuropsychologyIntellectualPerformanceNonverbalAbstraction = neuropsychologyIntellectualPerformanceNonverbalAbstraction;
    }

    public boolean isNeuropsychologyIntellectualPerformanceNonverbalDesignCap() {
        return neuropsychologyIntellectualPerformanceNonverbalDesignCap;
    }

    public void setNeuropsychologyIntellectualPerformanceNonverbalDesignCap(boolean neuropsychologyIntellectualPerformanceNonverbalDesignCap) {
        this.neuropsychologyIntellectualPerformanceNonverbalDesignCap = neuropsychologyIntellectualPerformanceNonverbalDesignCap;
    }

    public boolean isNeuropsychologyNeuropsychologicalProfile() {
        return neuropsychologyNeuropsychologicalProfile;
    }

    public void setNeuropsychologyNeuropsychologicalProfile(boolean neuropsychologyNeuropsychologicalProfile) {
        this.neuropsychologyNeuropsychologicalProfile = neuropsychologyNeuropsychologicalProfile;
    }

    public boolean isNeuropsychologyNeuropsychologicalProfileAttention() {
        return neuropsychologyNeuropsychologicalProfileAttention;
    }

    public void setNeuropsychologyNeuropsychologicalProfileAttention(boolean neuropsychologyNeuropsychologicalProfileAttention) {
        this.neuropsychologyNeuropsychologicalProfileAttention = neuropsychologyNeuropsychologicalProfileAttention;
    }

    public boolean isNeuropsychologyNeuropsychologicalProfileExecutiveFunction() {
        return neuropsychologyNeuropsychologicalProfileExecutiveFunction;
    }

    public void setNeuropsychologyNeuropsychologicalProfileExecutiveFunction(boolean neuropsychologyNeuropsychologicalProfileExecutiveFunction) {
        this.neuropsychologyNeuropsychologicalProfileExecutiveFunction = neuropsychologyNeuropsychologicalProfileExecutiveFunction;
    }

    public boolean isNeuropsychologyNeuropsychologicalProfileCognitiveSpeed() {
        return neuropsychologyNeuropsychologicalProfileCognitiveSpeed;
    }

    public void setNeuropsychologyNeuropsychologicalProfileCognitiveSpeed(boolean neuropsychologyNeuropsychologicalProfileCognitiveSpeed) {
        this.neuropsychologyNeuropsychologicalProfileCognitiveSpeed = neuropsychologyNeuropsychologicalProfileCognitiveSpeed;
    }

    public boolean isNeuropsychologyNeuropsychologicalProfileSpeechExpressively() {
        return neuropsychologyNeuropsychologicalProfileSpeechExpressively;
    }

    public void setNeuropsychologyNeuropsychologicalProfileSpeechExpressively(boolean neuropsychologyNeuropsychologicalProfileSpeechExpressively) {
        this.neuropsychologyNeuropsychologicalProfileSpeechExpressively = neuropsychologyNeuropsychologicalProfileSpeechExpressively;
    }

    public boolean isNeuropsychologyNeuropsychologicalProfileSpeechUnderstanding() {
        return neuropsychologyNeuropsychologicalProfileSpeechUnderstanding;
    }

    public void setNeuropsychologyNeuropsychologicalProfileSpeechUnderstanding(boolean neuropsychologyNeuropsychologicalProfileSpeechUnderstanding) {
        this.neuropsychologyNeuropsychologicalProfileSpeechUnderstanding = neuropsychologyNeuropsychologicalProfileSpeechUnderstanding;
    }

    public boolean isNeuropsychologyNeuropsychologicalProfileMemoryOperating() {
        return neuropsychologyNeuropsychologicalProfileMemoryOperating;
    }

    public void setNeuropsychologyNeuropsychologicalProfileMemoryOperating(boolean neuropsychologyNeuropsychologicalProfileMemoryOperating) {
        this.neuropsychologyNeuropsychologicalProfileMemoryOperating = neuropsychologyNeuropsychologicalProfileMemoryOperating;
    }

    public boolean isNeuropsychologyNeuropsychologicalProfileMemoryVerbal() {
        return neuropsychologyNeuropsychologicalProfileMemoryVerbal;
    }

    public void setNeuropsychologyNeuropsychologicalProfileMemoryVerbal(boolean neuropsychologyNeuropsychologicalProfileMemoryVerbal) {
        this.neuropsychologyNeuropsychologicalProfileMemoryVerbal = neuropsychologyNeuropsychologicalProfileMemoryVerbal;
    }

    public boolean isNeuropsychologyNeuropsychologicalProfileMemoryNonverbal() {
        return neuropsychologyNeuropsychologicalProfileMemoryNonverbal;
    }

    public void setNeuropsychologyNeuropsychologicalProfileMemoryNonverbal(boolean neuropsychologyNeuropsychologicalProfileMemoryNonverbal) {
        this.neuropsychologyNeuropsychologicalProfileMemoryNonverbal = neuropsychologyNeuropsychologicalProfileMemoryNonverbal;
    }

    public boolean isNeuropsychologyNeuropsychologicalProfileMemoryLearning() {
        return neuropsychologyNeuropsychologicalProfileMemoryLearning;
    }

    public void setNeuropsychologyNeuropsychologicalProfileMemoryLearning(boolean neuropsychologyNeuropsychologicalProfileMemoryLearning) {
        this.neuropsychologyNeuropsychologicalProfileMemoryLearning = neuropsychologyNeuropsychologicalProfileMemoryLearning;
    }

    public boolean isNeuropsychologyNeuropsychologicalProfilePerceptionSpeech() {
        return neuropsychologyNeuropsychologicalProfilePerceptionSpeech;
    }

    public void setNeuropsychologyNeuropsychologicalProfilePerceptionSpeech(boolean neuropsychologyNeuropsychologicalProfilePerceptionSpeech) {
        this.neuropsychologyNeuropsychologicalProfilePerceptionSpeech = neuropsychologyNeuropsychologicalProfilePerceptionSpeech;
    }

    public boolean isNeuropsychologyNeuropsychologicalProfilePerceptionVisual() {
        return neuropsychologyNeuropsychologicalProfilePerceptionVisual;
    }

    public void setNeuropsychologyNeuropsychologicalProfilePerceptionVisual(boolean neuropsychologyNeuropsychologicalProfilePerceptionVisual) {
        this.neuropsychologyNeuropsychologicalProfilePerceptionVisual = neuropsychologyNeuropsychologicalProfilePerceptionVisual;
    }

    public boolean isNeuropsychologyNeuropsychologicalProfilePerceptionSpatial() {
        return neuropsychologyNeuropsychologicalProfilePerceptionSpatial;
    }

    public void setNeuropsychologyNeuropsychologicalProfilePerceptionSpatial(boolean neuropsychologyNeuropsychologicalProfilePerceptionSpatial) {
        this.neuropsychologyNeuropsychologicalProfilePerceptionSpatial = neuropsychologyNeuropsychologicalProfilePerceptionSpatial;
    }

    public boolean isNeuropsychologyNeuropsychologicalProfileMotorSkillsDexterity() {
        return neuropsychologyNeuropsychologicalProfileMotorSkillsDexterity;
    }

    public void setNeuropsychologyNeuropsychologicalProfileMotorSkillsDexterity(boolean neuropsychologyNeuropsychologicalProfileMotorSkillsDexterity) {
        this.neuropsychologyNeuropsychologicalProfileMotorSkillsDexterity = neuropsychologyNeuropsychologicalProfileMotorSkillsDexterity;
    }

    public boolean isNeuropsychologyNeuropsychologicalProfileMotorCoordination() {
        return neuropsychologyNeuropsychologicalProfileMotorCoordination;
    }

    public void setNeuropsychologyNeuropsychologicalProfileMotorCoordination(boolean neuropsychologyNeuropsychologicalProfileMotorCoordination) {
        this.neuropsychologyNeuropsychologicalProfileMotorCoordination = neuropsychologyNeuropsychologicalProfileMotorCoordination;
    }

    public boolean isNeuropsychologyPresenceOfChanges() {
        return neuropsychologyPresenceOfChanges;
    }

    public void setNeuropsychologyPresenceOfChanges(boolean neuropsychologyPresenceOfChanges) {
        this.neuropsychologyPresenceOfChanges = neuropsychologyPresenceOfChanges;
    }

    public boolean isNeuropsychologyPresenceOfChangesDetail() {
        return neuropsychologyPresenceOfChangesDetail;
    }

    public void setNeuropsychologyPresenceOfChangesDetail(boolean neuropsychologyPresenceOfChangesDetail) {
        this.neuropsychologyPresenceOfChangesDetail = neuropsychologyPresenceOfChangesDetail;
    }

    public boolean isNeuropsychologyEmotionalStatus() {
        return neuropsychologyEmotionalStatus;
    }

    public void setNeuropsychologyEmotionalStatus(boolean neuropsychologyEmotionalStatus) {
        this.neuropsychologyEmotionalStatus = neuropsychologyEmotionalStatus;
    }

    public boolean isNeuropsychologyComment() {
        return neuropsychologyComment;
    }

    public void setNeuropsychologyComment(boolean neuropsychologyComment) {
        this.neuropsychologyComment = neuropsychologyComment;
    }

    public boolean isNeuropsychologyAddUserId() {
        return neuropsychologyAddUserId;
    }

    public void setNeuropsychologyAddUserId(boolean neuropsychologyAddUserId) {
        this.neuropsychologyAddUserId = neuropsychologyAddUserId;
    }

    public boolean isNeuropsychologyPatientId() {
        return neuropsychologyPatientId;
    }

    public void setNeuropsychologyPatientId(boolean neuropsychologyPatientId) {
        this.neuropsychologyPatientId = neuropsychologyPatientId;
    }

    public boolean isNeuropsychologyFindingDetail() {
        return neuropsychologyFindingDetail;
    }

    public void setNeuropsychologyFindingDetail(boolean neuropsychologyFindingDetail) {
        this.neuropsychologyFindingDetail = neuropsychologyFindingDetail;
    }

    public boolean isOperationId() {
        return operationId;
    }

    public void setOperationId(boolean operationId) {
        this.operationId = operationId;
    }

    public boolean isOperationDate() {
        return operationDate;
    }

    public void setOperationDate(boolean operationDate) {
        this.operationDate = operationDate;
    }

    public boolean isOperationDateOperation() {
        return operationDateOperation;
    }

    public void setOperationDateOperation(boolean operationDateOperation) {
        this.operationDateOperation = operationDateOperation;
    }

    public boolean isOperationDoctorId() {
        return operationDoctorId;
    }

    public void setOperationDoctorId(boolean operationDoctorId) {
        this.operationDoctorId = operationDoctorId;
    }

    public boolean isOperationAdded() {
        return operationAdded;
    }

    public void setOperationAdded(boolean operationAdded) {
        this.operationAdded = operationAdded;
    }

    public boolean isOperationTypeOperation() {
        return operationTypeOperation;
    }

    public void setOperationTypeOperation(boolean operationTypeOperation) {
        this.operationTypeOperation = operationTypeOperation;
    }

    public boolean isOperationRangeOperation() {
        return operationRangeOperation;
    }

    public void setOperationRangeOperation(boolean operationRangeOperation) {
        this.operationRangeOperation = operationRangeOperation;
    }

    public boolean isOperationLocalizationOperation() {
        return operationLocalizationOperation;
    }

    public void setOperationLocalizationOperation(boolean operationLocalizationOperation) {
        this.operationLocalizationOperation = operationLocalizationOperation;
    }

    public boolean isOperationMst() {
        return operationMst;
    }

    public void setOperationMst(boolean operationMst) {
        this.operationMst = operationMst;
    }

    public boolean isOperationColostomy() {
        return operationColostomy;
    }

    public void setOperationColostomy(boolean operationColostomy) {
        this.operationColostomy = operationColostomy;
    }

    public boolean isOperationVNS() {
        return operationVNS;
    }

    public void setOperationVNS(boolean operationVNS) {
        this.operationVNS = operationVNS;
    }

    public boolean isOperationVNsImplantationDate() {
        return operationVNsImplantationDate;
    }

    public void setOperationVNsImplantationDate(boolean operationVNsImplantationDate) {
        this.operationVNsImplantationDate = operationVNsImplantationDate;
    }

    public boolean isOperationOperationDetails() {
        return operationOperationDetails;
    }

    public void setOperationOperationDetails(boolean operationOperationDetails) {
        this.operationOperationDetails = operationOperationDetails;
    }

    public boolean isOperationCompleteResection() {
        return operationCompleteResection;
    }

    public void setOperationCompleteResection(boolean operationCompleteResection) {
        this.operationCompleteResection = operationCompleteResection;
    }

    public boolean isOperationComment() {
        return operationComment;
    }

    public void setOperationComment(boolean operationComment) {
        this.operationComment = operationComment;
    }

    public boolean isOperationAddUserId() {
        return operationAddUserId;
    }

    public void setOperationAddUserId(boolean operationAddUserId) {
        this.operationAddUserId = operationAddUserId;
    }

    public boolean isOperationPatientId() {
        return operationPatientId;
    }

    public void setOperationPatientId(boolean operationPatientId) {
        this.operationPatientId = operationPatientId;
    }

    public boolean isOutcomeId() {
        return outcomeId;
    }

    public void setOutcomeId(boolean outcomeId) {
        this.outcomeId = outcomeId;
    }

    public boolean isOutcomeDate() {
        return outcomeDate;
    }

    public void setOutcomeDate(boolean outcomeDate) {
        this.outcomeDate = outcomeDate;
    }

    public boolean isOutcomeDoctorId() {
        return outcomeDoctorId;
    }

    public void setOutcomeDoctorId(boolean outcomeDoctorId) {
        this.outcomeDoctorId = outcomeDoctorId;
    }

    public boolean isOutcomeAdded() {
        return outcomeAdded;
    }

    public void setOutcomeAdded(boolean outcomeAdded) {
        this.outcomeAdded = outcomeAdded;
    }

    public boolean isOutcomeFinallySeizures() {
        return outcomeFinallySeizures;
    }

    public void setOutcomeFinallySeizures(boolean outcomeFinallySeizures) {
        this.outcomeFinallySeizures = outcomeFinallySeizures;
    }

    public boolean isOutcomeEEG() {
        return outcomeEEG;
    }

    public void setOutcomeEEG(boolean outcomeEEG) {
        this.outcomeEEG = outcomeEEG;
    }

    public boolean isOutcomeAED() {
        return outcomeAED;
    }

    public void setOutcomeAED(boolean outcomeAED) {
        this.outcomeAED = outcomeAED;
    }

    public boolean isOutcomeMRI() {
        return outcomeMRI;
    }

    public void setOutcomeMRI(boolean outcomeMRI) {
        this.outcomeMRI = outcomeMRI;
    }

    public boolean isOutcomeNeuropsychology() {
        return outcomeNeuropsychology;
    }

    public void setOutcomeNeuropsychology(boolean outcomeNeuropsychology) {
        this.outcomeNeuropsychology = outcomeNeuropsychology;
    }

    public boolean isOutcomeComment() {
        return outcomeComment;
    }

    public void setOutcomeComment(boolean outcomeComment) {
        this.outcomeComment = outcomeComment;
    }

    public boolean isOutcomeAddUserId() {
        return outcomeAddUserId;
    }

    public void setOutcomeAddUserId(boolean outcomeAddUserId) {
        this.outcomeAddUserId = outcomeAddUserId;
    }

    public boolean isOutcomePatientId() {
        return outcomePatientId;
    }

    public void setOutcomePatientId(boolean outcomePatientId) {
        this.outcomePatientId = outcomePatientId;
    }

    public boolean isOutcomeSeizureOutcome() {
        return outcomeSeizureOutcome;
    }

    public void setOutcomeSeizureOutcome(boolean outcomeSeizureOutcome) {
        this.outcomeSeizureOutcome = outcomeSeizureOutcome;
    }

    public boolean isOutcomeDistance() {
        return outcomeDistance;
    }

    public void setOutcomeDistance(boolean outcomeDistance) {
        this.outcomeDistance = outcomeDistance;
    }

    public boolean isOutcomeOperationId() {
        return outcomeOperationId;
    }

    public void setOutcomeOperationId(boolean outcomeOperationId) {
        this.outcomeOperationId = outcomeOperationId;
    }

    public boolean isPharmacotherapyId() {
        return pharmacotherapyId;
    }

    public void setPharmacotherapyId(boolean pharmacotherapyId) {
        this.pharmacotherapyId = pharmacotherapyId;
    }

    public boolean isPharmacotherapyDate() {
        return pharmacotherapyDate;
    }

    public void setPharmacotherapyDate(boolean pharmacotherapyDate) {
        this.pharmacotherapyDate = pharmacotherapyDate;
    }

    public boolean isPharmacotherapyDoctorId() {
        return pharmacotherapyDoctorId;
    }

    public void setPharmacotherapyDoctorId(boolean pharmacotherapyDoctorId) {
        this.pharmacotherapyDoctorId = pharmacotherapyDoctorId;
    }

    public boolean isPharmacotherapyAdded() {
        return pharmacotherapyAdded;
    }

    public void setPharmacotherapyAdded(boolean pharmacotherapyAdded) {
        this.pharmacotherapyAdded = pharmacotherapyAdded;
    }

    public boolean isPharmacotherapyAED() {
        return pharmacotherapyAED;
    }

    public void setPharmacotherapyAED(boolean pharmacotherapyAED) {
        this.pharmacotherapyAED = pharmacotherapyAED;
    }

    public boolean isPharmacotherapyEffective() {
        return pharmacotherapyEffective;
    }

    public void setPharmacotherapyEffective(boolean pharmacotherapyEffective) {
        this.pharmacotherapyEffective = pharmacotherapyEffective;
    }

    public boolean isPharmacotherapyDuringSurgery() {
        return pharmacotherapyDuringSurgery;
    }

    public void setPharmacotherapyDuringSurgery(boolean pharmacotherapyDuringSurgery) {
        this.pharmacotherapyDuringSurgery = pharmacotherapyDuringSurgery;
    }

    public boolean isPharmacotherapyComment() {
        return pharmacotherapyComment;
    }

    public void setPharmacotherapyComment(boolean pharmacotherapyComment) {
        this.pharmacotherapyComment = pharmacotherapyComment;
    }

    public boolean isPharmacotherapyAddUserId() {
        return pharmacotherapyAddUserId;
    }

    public void setPharmacotherapyAddUserId(boolean pharmacotherapyAddUserId) {
        this.pharmacotherapyAddUserId = pharmacotherapyAddUserId;
    }

    public boolean isPharmacotherapyPatientId() {
        return pharmacotherapyPatientId;
    }

    public void setPharmacotherapyPatientId(boolean pharmacotherapyPatientId) {
        this.pharmacotherapyPatientId = pharmacotherapyPatientId;
    }

    public boolean isSeizureId() {
        return seizureId;
    }

    public void setSeizureId(boolean seizureId) {
        this.seizureId = seizureId;
    }

    public boolean isSeizureDate() {
        return seizureDate;
    }

    public void setSeizureDate(boolean seizureDate) {
        this.seizureDate = seizureDate;
    }

    public boolean isSeizureDoctorId() {
        return seizureDoctorId;
    }

    public void setSeizureDoctorId(boolean seizureDoctorId) {
        this.seizureDoctorId = seizureDoctorId;
    }

    public boolean isSeizureAdded() {
        return seizureAdded;
    }

    public void setSeizureAdded(boolean seizureAdded) {
        this.seizureAdded = seizureAdded;
    }

    public boolean isSeizureFrequency() {
        return seizureFrequency;
    }

    public void setSeizureFrequency(boolean seizureFrequency) {
        this.seizureFrequency = seizureFrequency;
    }

    public boolean isSeizureSecondarilyGeneralizedSeizure() {
        return seizureSecondarilyGeneralizedSeizure;
    }

    public void setSeizureSecondarilyGeneralizedSeizure(boolean seizureSecondarilyGeneralizedSeizure) {
        this.seizureSecondarilyGeneralizedSeizure = seizureSecondarilyGeneralizedSeizure;
    }

    public boolean isSeizureStatusEpilepticus() {
        return seizureStatusEpilepticus;
    }

    public void setSeizureStatusEpilepticus(boolean seizureStatusEpilepticus) {
        this.seizureStatusEpilepticus = seizureStatusEpilepticus;
    }

    public boolean isSeizureSSCClassification() {
        return seizureSSCClassification;
    }

    public void setSeizureSSCClassification(boolean seizureSSCClassification) {
        this.seizureSSCClassification = seizureSSCClassification;
    }

    public boolean isSeizureILAEClassification() {
        return seizureILAEClassification;
    }

    public void setSeizureILAEClassification(boolean seizureILAEClassification) {
        this.seizureILAEClassification = seizureILAEClassification;
    }

    public boolean isSeizureSeizuresWhileAwakeEpi() {
        return seizureSeizuresWhileAwakeEpi;
    }

    public void setSeizureSeizuresWhileAwakeEpi(boolean seizureSeizuresWhileAwakeEpi) {
        this.seizureSeizuresWhileAwakeEpi = seizureSeizuresWhileAwakeEpi;
    }

    public boolean isSeizureSeizuresWhileAwakeLatent() {
        return seizureSeizuresWhileAwakeLatent;
    }

    public void setSeizureSeizuresWhileAwakeLatent(boolean seizureSeizuresWhileAwakeLatent) {
        this.seizureSeizuresWhileAwakeLatent = seizureSeizuresWhileAwakeLatent;
    }

    public boolean isSeizureSeizuresWhileAwakeNonEpi() {
        return seizureSeizuresWhileAwakeNonEpi;
    }

    public void setSeizureSeizuresWhileAwakeNonEpi(boolean seizureSeizuresWhileAwakeNonEpi) {
        this.seizureSeizuresWhileAwakeNonEpi = seizureSeizuresWhileAwakeNonEpi;
    }

    public boolean isSeizureSeizuresWhileSleepEpi() {
        return seizureSeizuresWhileSleepEpi;
    }

    public void setSeizureSeizuresWhileSleepEpi(boolean seizureSeizuresWhileSleepEpi) {
        this.seizureSeizuresWhileSleepEpi = seizureSeizuresWhileSleepEpi;
    }

    public boolean isSeizureSeizuresWhileSleepLatent() {
        return seizureSeizuresWhileSleepLatent;
    }

    public void setSeizureSeizuresWhileSleepLatent(boolean seizureSeizuresWhileSleepLatent) {
        this.seizureSeizuresWhileSleepLatent = seizureSeizuresWhileSleepLatent;
    }

    public boolean isSeizureSeizuresWhileSleepNonEpi() {
        return seizureSeizuresWhileSleepNonEpi;
    }

    public void setSeizureSeizuresWhileSleepNonEpi(boolean seizureSeizuresWhileSleepNonEpi) {
        this.seizureSeizuresWhileSleepNonEpi = seizureSeizuresWhileSleepNonEpi;
    }

    public boolean isSeizureComment() {
        return seizureComment;
    }

    public void setSeizureComment(boolean seizureComment) {
        this.seizureComment = seizureComment;
    }

    public boolean isSeizureAddUserId() {
        return seizureAddUserId;
    }

    public void setSeizureAddUserId(boolean seizureAddUserId) {
        this.seizureAddUserId = seizureAddUserId;
    }

    public boolean isSeizurePatientId() {
        return seizurePatientId;
    }

    public void setSeizurePatientId(boolean seizurePatientId) {
        this.seizurePatientId = seizurePatientId;
    }

    public boolean isSeizureDetailComment() {
        return seizureDetailComment;
    }

    public void setSeizureDetailComment(boolean seizureDetailComment) {
        this.seizureDetailComment = seizureDetailComment;
    }

    public boolean isNeuropsychologyOldId() {
        return neuropsychologyOldId;
    }

    public void setNeuropsychologyOldId(boolean neuropsychologyOldId) {
        this.neuropsychologyOldId = neuropsychologyOldId;
    }

    public boolean isNeuropsychologyOldDate() {
        return neuropsychologyOldDate;
    }

    public void setNeuropsychologyOldDate(boolean neuropsychologyOldDate) {
        this.neuropsychologyOldDate = neuropsychologyOldDate;
    }

    public boolean isNeuropsychologyOldDoctorId() {
        return neuropsychologyOldDoctorId;
    }

    public void setNeuropsychologyOldDoctorId(boolean neuropsychologyOldDoctorId) {
        this.neuropsychologyOldDoctorId = neuropsychologyOldDoctorId;
    }

    public boolean isNeuropsychologyOldAdded() {
        return neuropsychologyOldAdded;
    }

    public void setNeuropsychologyOldAdded(boolean neuropsychologyOldAdded) {
        this.neuropsychologyOldAdded = neuropsychologyOldAdded;
    }

    public boolean isNeuropsychologyOldComment() {
        return neuropsychologyOldComment;
    }

    public void setNeuropsychologyOldComment(boolean neuropsychologyOldComment) {
        this.neuropsychologyOldComment = neuropsychologyOldComment;
    }

    public boolean isNeuropsychologyOldAddUserId() {
        return neuropsychologyOldAddUserId;
    }

    public void setNeuropsychologyOldAddUserId(boolean neuropsychologyOldAddUserId) {
        this.neuropsychologyOldAddUserId = neuropsychologyOldAddUserId;
    }

    public boolean isNeuropsychologyOldPatientId() {
        return neuropsychologyOldPatientId;
    }

    public void setNeuropsychologyOldPatientId(boolean neuropsychologyOldPatientId) {
        this.neuropsychologyOldPatientId = neuropsychologyOldPatientId;
    }

    public boolean isNeuropsychologyOldNeuropsychologicalExamination() {
        return neuropsychologyOldNeuropsychologicalExamination;
    }

    public void setNeuropsychologyOldNeuropsychologicalExamination(boolean neuropsychologyOldNeuropsychologicalExamination) {
        this.neuropsychologyOldNeuropsychologicalExamination = neuropsychologyOldNeuropsychologicalExamination;
    }

    public boolean isNeuropsychologyOldIntelligenceLevel() {
        return neuropsychologyOldIntelligenceLevel;
    }

    public void setNeuropsychologyOldIntelligenceLevel(boolean neuropsychologyOldIntelligenceLevel) {
        this.neuropsychologyOldIntelligenceLevel = neuropsychologyOldIntelligenceLevel;
    }

    public boolean isNeuropsychologyOldSpecificLearning() {
        return neuropsychologyOldSpecificLearning;
    }

    public void setNeuropsychologyOldSpecificLearning(boolean neuropsychologyOldSpecificLearning) {
        this.neuropsychologyOldSpecificLearning = neuropsychologyOldSpecificLearning;
    }

    public boolean isNeuropsychologyOldDevelopmentalLanguageDisorders() {
        return neuropsychologyOldDevelopmentalLanguageDisorders;
    }

    public void setNeuropsychologyOldDevelopmentalLanguageDisorders(boolean neuropsychologyOldDevelopmentalLanguageDisorders) {
        this.neuropsychologyOldDevelopmentalLanguageDisorders = neuropsychologyOldDevelopmentalLanguageDisorders;
    }

    public boolean isNeuropsychologyOldAdhdSyndrome() {
        return neuropsychologyOldAdhdSyndrome;
    }

    public void setNeuropsychologyOldAdhdSyndrome(boolean neuropsychologyOldAdhdSyndrome) {
        this.neuropsychologyOldAdhdSyndrome = neuropsychologyOldAdhdSyndrome;
    }

    public boolean isInvasiveTestCorticalMappingId() {
        return invasiveTestCorticalMappingId;
    }

    public void setInvasiveTestCorticalMappingId(boolean invasiveTestCorticalMappingId) {
        this.invasiveTestCorticalMappingId = invasiveTestCorticalMappingId;
    }

    public boolean isInvasiveTestCorticalMappingDate() {
        return invasiveTestCorticalMappingDate;
    }

    public void setInvasiveTestCorticalMappingDate(boolean invasiveTestCorticalMappingDate) {
        this.invasiveTestCorticalMappingDate = invasiveTestCorticalMappingDate;
    }

    public boolean isInvasiveTestCorticalMappingDoctorId() {
        return invasiveTestCorticalMappingDoctorId;
    }

    public void setInvasiveTestCorticalMappingDoctorId(boolean invasiveTestCorticalMappingDoctorId) {
        this.invasiveTestCorticalMappingDoctorId = invasiveTestCorticalMappingDoctorId;
    }

    public boolean isInvasiveTestCorticalMappingAdded() {
        return invasiveTestCorticalMappingAdded;
    }

    public void setInvasiveTestCorticalMappingAdded(boolean invasiveTestCorticalMappingAdded) {
        this.invasiveTestCorticalMappingAdded = invasiveTestCorticalMappingAdded;
    }

    public boolean isInvasiveTestCorticalMappingComment() {
        return invasiveTestCorticalMappingComment;
    }

    public void setInvasiveTestCorticalMappingComment(boolean invasiveTestCorticalMappingComment) {
        this.invasiveTestCorticalMappingComment = invasiveTestCorticalMappingComment;
    }

    public boolean isInvasiveTestCorticalMappingAddUserId() {
        return invasiveTestCorticalMappingAddUserId;
    }

    public void setInvasiveTestCorticalMappingAddUserId(boolean invasiveTestCorticalMappingAddUserId) {
        this.invasiveTestCorticalMappingAddUserId = invasiveTestCorticalMappingAddUserId;
    }

    public boolean isInvasiveTestCorticalMappingPatientId() {
        return invasiveTestCorticalMappingPatientId;
    }

    public void setInvasiveTestCorticalMappingPatientId(boolean invasiveTestCorticalMappingPatientId) {
        this.invasiveTestCorticalMappingPatientId = invasiveTestCorticalMappingPatientId;
    }

    public boolean isInvasiveTestCorticalMappingDone() {
        return invasiveTestCorticalMappingDone;
    }

    public void setInvasiveTestCorticalMappingDone(boolean invasiveTestCorticalMappingDone) {
        this.invasiveTestCorticalMappingDone = invasiveTestCorticalMappingDone;
    }

    public boolean isInvasiveTestCorticalMappingCorticalMapping() {
        return invasiveTestCorticalMappingCorticalMapping;
    }

    public void setInvasiveTestCorticalMappingCorticalMapping(boolean invasiveTestCorticalMappingCorticalMapping) {
        this.invasiveTestCorticalMappingCorticalMapping = invasiveTestCorticalMappingCorticalMapping;
    }
}

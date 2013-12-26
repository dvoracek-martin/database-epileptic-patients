package cz.cvut.fit.genepi.dataLayer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EXPORT_PARAMS")
public class ExportParamsEntity {
	@Id
	@Column(name = "ID", precision = 6, scale = 0, nullable = false)
	@GeneratedValue
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "user_id")
	private int userID;

	@Column(name = "is_generic")
	private boolean isGeneric;

	@Column(name = "anamnesis")
	private boolean anamnesis;

	@Column(name = "complication")
	private boolean complication;

	@Column(name = "diagnosticTestEEG")
	private boolean diagnosticTestEEG;

	@Column(name = "diagnosticTestMRI")
	private boolean diagnosticTestMRI;

	@Column(name = "histology")
	private boolean histology;

	@Column(name = "invasiveTestECOG")
	private boolean invasiveTestECOG;

	@Column(name = "invasiveTestEEG")
	private boolean invasiveTestEEG;

	@Column(name = "neurologicalFinding")
	private boolean neurologicalFinding;

	@Column(name = "neuropsychology")
	private boolean neuropsychology;

	@Column(name = "neuropsychologyOld")
	private boolean neuropsychologyOld;

	@Column(name = "invasiveTestCorticalMapping")
	private boolean invasiveTestCorticalMapping;

	@Column(name = "operation")
	private boolean operation;

	@Column(name = "outcome")
	private boolean outcome;

	@Column(name = "pharmacotherapy")
	private boolean pharmacotherapy;

	@Column(name = "seizure")
	private boolean seizure;

	// Patient properties
	@Column(name = "patientId")
	private boolean patientId;
	@Column(name = "patientNin")
	private boolean patientNin;
	@Column(name = "patientBirthday")
	private boolean patientBirthday;
	@Column(name = "patientGender")
	private boolean patientGender;
	@Column(name = "patientDoctorId")
	private boolean patientDoctorId;
	@Column(name = "patientDeleted")
	private boolean patientDeleted;
	@Column(name = "patientChecked")
	private boolean patientChecked;
	@Column(name = "patientContactId")
	private boolean patientContactId;

	// Contact properties
	@Column(name = "contactId")
	private boolean contactId;
	@Column(name = "contactFirstName")
	private boolean contactFirstName;
	@Column(name = "contactLastName")
	private boolean contactLastName;
	@Column(name = "contactAddressStreet")
	private boolean contactAddressStreet;
	@Column(name = "contactAddressHn")
	private boolean contactAddressHn;
	@Column(name = "contactAddressCity")
	private boolean contactAddressCity;
	@Column(name = "contactPostalCode")
	private boolean contactPostalCode;
	@Column(name = "contactCountry")
	private boolean contactCountry;
	@Column(name = "contactPhoneNumber")
	private boolean contactPhoneNumber;
	@Column(name = "contactEmail")
	private boolean contactEmail;

	// Anamnesis properties
	@Column(name = "anamnesisId")
	private boolean anamnesisId;
	@Column(name = "anamnesisDate")
	private boolean anamnesisDate;
	@Column(name = "anamnesisDoctorId")
	private boolean anamnesisDoctorId;
	@Column(name = "anamnesisAdded")
	private boolean anamnesisAdded;
	@Column(name = "anamnesisBeginningEpilepsy")
	private boolean anamnesisBeginningEpilepsy;
	@Column(name = "anamnesisFirstFever")
	private boolean anamnesisFirstFever;
	@Column(name = "anamnesisInfantileSpasm")
	private boolean anamnesisInfantileSpasm;
	@Column(name = "anamnesisSpecificSyndrome")
	private boolean anamnesisSpecificSyndrome;
	@Column(name = "anamnesisEpilepsyInFamily")
	private boolean anamnesisEpilepsyInFamily;
	@Column(name = "anamnesisParentalRisk")
	private boolean anamnesisParentalRisk;
	@Column(name = "anamnesisFibrilConvulsions")
	private boolean anamnesisFibrilConvulsions;
	@Column(name = "anamnesisInflammationCns")
	private boolean anamnesisInflammationCns;
	@Column(name = "anamnesisInjuryCns")
	private boolean anamnesisInjuryCns;
	@Column(name = "anamnesisOperationCns")
	private boolean anamnesisOperationCns;
	@Column(name = "anamnesisEarlyPmdRetardation")
	private boolean anamnesisEarlyPmdRetardation;
	@Column(name = "anamnesisNonCnsComorbidity")
	private boolean anamnesisNonCnsComorbidity;
	@Column(name = "anamnesisComment")
	private boolean anamnesisComment;

	// Complication properties
	@Column(name = "complicationId")
	private boolean complicationId;
	@Column(name = "complicationDate")
	private boolean complicationDate;
	@Column(name = "complicationDoctorId")
	private boolean complicationDoctorId;
	@Column(name = "complicationAdded")
	private boolean complicationAdded;
	@Column(name = "complicationIdCom")
	private boolean complicationIdCom;
	@Column(name = "complicationComment")
	private boolean complicationComment;
	@Column(name = "complicationDeleted")
	private boolean complicationDeleted;
	@Column(name = "complicationPatientId")
	private boolean complicationPatientId;
	@Column(name = "complicationAddUserId")
	private boolean complicationAddUserId;
	@Column(name = "complicationStatus")
	private boolean complicationStatus;
	@Column(name = "ComplicationWithCompication")
	private boolean ComplicationWithCompication;
	@Column(name = "ComplicationComplicationType")
	private boolean ComplicationComplicationType;
	@Column(name = "ComplicationComplication")
	private boolean ComplicationComplication;

	// DiagnosticTestEEG properties
	@Column(name = "diagnosticTestEEGId")
	private boolean diagnosticTestEEGId;
	@Column(name = "diagnosticTestEEGDate")
	private boolean diagnosticTestEEGDate;
	@Column(name = "diagnosticTestEEGDone")
	private boolean diagnosticTestEEGDone;
	@Column(name = "diagnosticTestEEGDoctorId")
	private boolean diagnosticTestEEGDoctorId;
	@Column(name = "diagnosticTestEEGAdded")
	private boolean diagnosticTestEEGAdded;
	@Column(name = "diagnosticTestEEGBasicActivity")
	private boolean diagnosticTestEEGBasicActivity;
	@Column(name = "diagnosticTestEEGSlow")
	private boolean diagnosticTestEEGSlow;
	@Column(name = "diagnosticTestEEGInterictalEEGSpikes")
	private boolean diagnosticTestEEGInterictalEEGSpikes;
	@Column(name = "diagnosticTestEEGLocalizationInerictalEEGSpikes")
	private boolean diagnosticTestEEGLocalizationInerictalEEGSpikes;
	@Column(name = "diagnosticTestEEGStatusEpilepticus")
	private boolean diagnosticTestEEGStatusEpilepticus;
	@Column(name = "diagnosticTestEEGSecondarySidedSynchrony")
	private boolean diagnosticTestEEGSecondarySidedSynchrony;
	@Column(name = "diagnosticTestEEGIctalEEGPatterns")
	private boolean diagnosticTestEEGIctalEEGPatterns;
	@Column(name = "diagnosticTestEEGLocalizationIctalEEGPattern")
	private boolean diagnosticTestEEGLocalizationIctalEEGPattern;
	@Column(name = "diagnosticTestEEGComment")
	private boolean diagnosticTestEEGComment;
	@Column(name = "diagnosticTestEEGDeleted")
	private boolean diagnosticTestEEGDeleted;
	@Column(name = "diagnosticTestEEGAddUserId")
	private boolean diagnosticTestEEGAddUserId;
	@Column(name = "diagnosticTestEEGPatientId")
	private boolean diagnosticTestEEGPatientId;
	@Column(name = "diagnosticTestEEGStatus")
	private boolean diagnosticTestEEGStatus;
	@Column(name = "diagnosticTestEEGDescriptionVideoEEG")
	private boolean diagnosticTestEEGDescriptionVideoEEG;

	// DiagnosticTestMRI properties
	@Column(name = "diagnosticTestMRIId")
	private boolean diagnosticTestMRIId;
	@Column(name = "diagnosticTestMRIDone")
	private boolean diagnosticTestMRIDone;
	@Column(name = "diagnosticTestMRIate")
	private boolean diagnosticTestMRIate;
	@Column(name = "diagnosticTestMRIDoctorId")
	private boolean diagnosticTestMRIDoctorId;
	@Column(name = "diagnosticTestMRIAdded")
	private boolean diagnosticTestMRIAdded;
	@Column(name = "diagnosticTestMRIProtocol")
	private boolean diagnosticTestMRIProtocol;
	@Column(name = "diagnosticTestMRIFdgPet")
	private boolean diagnosticTestMRIFdgPet;
	@Column(name = "diagnosticTestMRIInterictalSpect")
	private boolean diagnosticTestMRIInterictalSpect;
	@Column(name = "diagnosticTestMRISiscom")
	private boolean diagnosticTestMRISiscom;
	@Column(name = "diagnosticTestMRIMrsProtocol")
	private boolean diagnosticTestMRIMrsProtocol;
	@Column(name = "diagnosticTestMRIMrsFinding")
	private boolean diagnosticTestMRIMrsFinding;
	@Column(name = "diagnosticTestMRIFinding")
	private boolean diagnosticTestMRIFinding;
	@Column(name = "diagnosticTestMRIDescription")
	private boolean diagnosticTestMRIDescription;
	@Column(name = "diagnosticTestMRIDescriptionPetHypometabolism")
	private boolean diagnosticTestMRIDescriptionPetHypometabolism;
	@Column(name = "diagnosticTestMRIDescriptionSpectHyperperfuse")
	private boolean diagnosticTestMRIDescriptionSpectHypoperfuse;
	@Column(name = "diagnosticTestMRIDescriptionSpectHypoperfuse")
	private boolean diagnosticTestMRIDescriptionMrsAbnormality;
	@Column(name = "diagnosticTestMRIDescriptionMrsAbnormality")
	private boolean diagnosticTestMRIDescriptionSpectHyperperfuse;
	@Column(name = "diagnosticTestMRIIctalSpect")
	private boolean diagnosticTestMRIIctalSpect;
	@Column(name = "diagnosticTestMRIDti")
	private boolean diagnosticTestMRIDti;
	@Column(name = "diagnosticTestMRIDtiDetailStudy")
	private boolean diagnosticTestMRIDtiDetailStudy;
	@Column(name = "diagnosticTestMRIFmri")
	private boolean diagnosticTestMRIFmri;
	@Column(name = "diagnosticTestMRIDetailsFmri")
	private boolean diagnosticTestMRIDetailsFmri;
	@Column(name = "diagnosticTestMRIDetailsDtiStudy")
	private boolean diagnosticTestMRIDetailsDtiStudy;
	@Column(name = "diagnosticTestMRIWada")
	private boolean diagnosticTestMRIWada;
	@Column(name = "diagnosticTestMRIDetailsWada")
	private boolean diagnosticTestMRIDetailsWada;
	@Column(name = "diagnosticTestMRIDescribe")
	private boolean diagnosticTestMRIDescribe;
	@Column(name = "diagnosticTestMRILocalizationSpecHypoperfuse")
	private boolean diagnosticTestMRILocalizationSpecHypoperfuse;
	@Column(name = "diagnosticTestMRILocalizationMrsAbnormality")
	private boolean diagnosticTestMRILocalizationMrsAbnormality;
	@Column(name = "diagnosticTestMRILocalizationPetHypometabolism")
	private boolean diagnosticTestMRILocalizationPetHypometabolism;
	@Column(name = "diagnosticTestMRILocalizationSpecHyperperfuse")
	private boolean diagnosticTestMRILocalizationSpecHyperperfuse;
	@Column(name = "diagnosticTestMRIFmriProtocols")
	private boolean diagnosticTestMRIFmriProtocols;
	@Column(name = "diagnosticTestMRIComment")
	private boolean diagnosticTestMRIComment;
	@Column(name = "diagnosticTestMRIDeleted")
	private boolean diagnosticTestMRIDeleted;
	@Column(name = "diagnosticTestMRIPatientId")
	private boolean diagnosticTestMRIPatientId;
	@Column(name = "diagnosticTestMRIAddUserId")
	private boolean diagnosticTestMRIAddUserId;
	@Column(name = "diagnosticTestMRIStatus")
	private boolean diagnosticTestMRIStatus;

	// Histology properties
	@Column(name = "histologyId")
	private boolean histologyId;
	@Column(name = "histologyDate")
	private boolean histologyDate;
	@Column(name = "histologyDoctorId")
	private boolean histologyDoctorId;
	@Column(name = "histologyAdded")
	private boolean histologyAdded;
	@Column(name = "histologyHistopathology")
	private boolean histologyHistopathology;
	@Column(name = "histologyFcdClassification")
	private boolean histologyFcdClassification;
	@Column(name = "histologyComment")
	private boolean histologyComment;
	@Column(name = "histologyDeleted")
	private boolean histologyDeleted;
	@Column(name = "histologyPatientId")
	private boolean histologyPatientId;
	@Column(name = "histologyAddUserId")
	private boolean histologyAddUserId;
	@Column(name = "histologyStatus")
	private boolean histologyStatus;

	// InvasiveTestECOG properties
	@Column(name = "invasiveTestECOGId")
	private boolean invasiveTestECOGId;
	@Column(name = "invasiveTestECOGDate")
	private boolean invasiveTestECOGDate;
	@Column(name = "invasiveTestECOGDone")
	private boolean invasiveTestECOGDone;
	@Column(name = "invasiveTestECOGIntracranialElectrodes")
	private boolean invasiveTestECOGIntracranialElectrodes;
	@Column(name = "invasiveTestECOGDoctorId")
	private boolean invasiveTestECOGDoctorId;
	@Column(name = "invasiveTestECOGAdded")
	private boolean invasiveTestECOGAdded;
	@Column(name = "invasiveTestECOGIntraOperativeEcog")
	private boolean invasiveTestECOGIntraOperativeEcog;
	@Column(name = "invasiveTestECOGEcogPatterns")
	private boolean invasiveTestECOGEcogPatterns;
	@Column(name = "invasiveTestECOGEcogCover")
	private boolean invasiveTestECOGEcogCover;
	@Column(name = "invasiveTestECOGAfterResectiomEcog")
	private boolean invasiveTestECOGAfterResectiomEcog;
	@Column(name = "invasiveTestECOGAwakeCraniotomy")
	private boolean invasiveTestECOGAwakeCraniotomy;
	@Column(name = "invasiveTestECOGComment")
	private boolean invasiveTestECOGComment;
	@Column(name = "invasiveTestECOGDeleted")
	private boolean invasiveTestECOGDeleted;
	@Column(name = "invasiveTestECOGAddUserId")
	private boolean invasiveTestECOGAddUserId;
	@Column(name = "invasiveTestECOGPatientId")
	private boolean invasiveTestECOGPatientId;
	@Column(name = "invasiveTestECOGStatus")
	private boolean invasiveTestECOGStatus;

	// InvasiveTestEEG properties
	@Column(name = "invasiveTestEEGId")
	private boolean invasiveTestEEGId;
	@Column(name = "invasiveTestEEGDate")
	private boolean invasiveTestEEGDate;
	@Column(name = "invasiveTestEEGDone")
	private boolean invasiveTestEEGDone;
	@Column(name = "invasiveTestEEGDoctorId")
	private boolean invasiveTestEEGDoctorId;
	@Column(name = "invasiveTestEEGAdded")
	private boolean invasiveTestEEGAdded;
	@Column(name = "invasiveTestEEGInvasiveMonitoring")
	private boolean invasiveTestEEGInvasiveMonitoring;
	@Column(name = "invasiveTestEEGLocalizationIntracranialElectrodes")
	private boolean invasiveTestEEGLocalizationIntracranialElectrodes;
	@Column(name = "invasiveTestEEGIntracranialElectrodes")
	private boolean invasiveTestEEGIntracranialElectrodes;
	@Column(name = "invasiveTestEEGInvasiveEEGSlow")
	private boolean invasiveTestEEGInvasiveEEGSlow;
	@Column(name = "invasiveTestEEGInvasiveEEGInterictalSpikes")
	private boolean invasiveTestEEGInvasiveEEGInterictalSpikes;
	@Column(name = "invasiveTestEEGLocalizationInvasiveEEGInterictalSpikes")
	private boolean invasiveTestEEGLocalizationInvasiveEEGInterictalSpikes;
	@Column(name = "invasiveTestEEGStatusEpilepticus")
	private boolean invasiveTestEEGStatusEpilepticus;
	@Column(name = "invasiveTestEEGInvasiveIctalEEGPatterns")
	private boolean invasiveTestEEGInvasiveIctalEEGPatterns;
	@Column(name = "invasiveTestEEGLocalizationIctalEEGPatterns")
	private boolean invasiveTestEEGLocalizationIctalEEGPatterns;
	@Column(name = "invasiveTestEEGComment")
	private boolean invasiveTestEEGComment;
	@Column(name = "invasiveTestEEGDeleted")
	private boolean invasiveTestEEGDeleted;
	@Column(name = "invasiveTestEEGAddUserId")
	private boolean invasiveTestEEGAddUserId;
	@Column(name = "invasiveTestEEGPatientId")
	private boolean invasiveTestEEGPatientId;
	@Column(name = "invasiveTestEEGStatus")
	private boolean invasiveTestEEGStatus;

	// Neurological finding property
	@Column(name = "neurologicalFindingId")
	private boolean neurologicalFindingId;
	@Column(name = "neurologicalFindingDate")
	private boolean neurologicalFindingDate;
	@Column(name = "neurologicalFindingDoctorId")
	private boolean neurologicalFindingDoctorId;
	@Column(name = "neurologicalFindingAdded")
	private boolean neurologicalFindingAdded;
	@Column(name = "neurologicalFindingHemisphereDominance")
	private boolean neurologicalFindingHemisphereDominance;
	@Column(name = "neurologicalFindingAbnormalNeurologicalFinding")
	private boolean neurologicalFindingAbnormalNeurologicalFinding;
	@Column(name = "neurologicalFindingHemiparesis")
	private boolean neurologicalFindingHemiparesis;
	@Column(name = "neurologicalFindingVisualFieldDefects")
	private boolean neurologicalFindingVisualFieldDefects;
	@Column(name = "neurologicalFindingComment")
	private boolean neurologicalFindingComment;
	@Column(name = "neurologicalFindingDeleted")
	private boolean neurologicalFindingDeleted;
	@Column(name = "neurologicalFindingAddUserId")
	private boolean neurologicalFindingAddUserId;
	@Column(name = "neurologicalFindingPatientId")
	private boolean neurologicalFindingPatientId;
	@Column(name = "neurologicalFindingStatus")
	private boolean neurologicalFindingStatus;

	// Neuropsychology properties
	@Column(name = "neuropsychologyId")
	private boolean neuropsychologyId;
	@Column(name = "neuropsychologyDate")
	private boolean neuropsychologyDate;
	@Column(name = "neuropsychologyDoctorId")
	private boolean neuropsychologyDoctorId;
	@Column(name = "neuropsychologyAdded")
	private boolean neuropsychologyAdded;
	@Column(name = "neuropsychologyIntellect")
	private boolean neuropsychologyIntellect;
	@Column(name = "neuropsychologyNeurodevelopmentalExamination")
	private boolean neuropsychologyNeurodevelopmentalExamination;
	@Column(name = "neuropsychologyNeurodevelopmentalExaminationAdaptability")
	private boolean neuropsychologyNeurodevelopmentalExaminationAdaptability;
	@Column(name = "neuropsychologyNeurodevelopmentalExaminationSpeechExpressively")
	private boolean neuropsychologyNeurodevelopmentalExaminationSpeechExpressively;
	@Column(name = "neuropsychologyNeurodevelopmentalExaminationSpeechReceptively")
	private boolean neuropsychologyNeurodevelopmentalExaminationSpeechReceptively;
	@Column(name = "neuropsychologyNeurodevelopmentalExaminationFineMotorSkills")
	private boolean neuropsychologyNeurodevelopmentalExaminationFineMotorSkills;
	@Column(name = "neuropsychologyNeurodevelopmentalExaminationGrossMotorSkills")
	private boolean neuropsychologyNeurodevelopmentalExaminationGrossMotorSkills;
	@Column(name = "neuropsychologyNeurodevelopmentalExaminationSocialBehavior")
	private boolean neuropsychologyNeurodevelopmentalExaminationSocialBehavior;
	@Column(name = "neuropsychologyIntellectualPerformance")
	private boolean neuropsychologyIntellectualPerformance;
	@Column(name = "neuropsychologyIntellectualPerformanceVerbally")
	private boolean neuropsychologyIntellectualPerformanceVerbally;
	@Column(name = "neuropsychologyIntellectualPerformanceNonverbalAbstraction")
	private boolean neuropsychologyIntellectualPerformanceNonverbalAbstraction;
	@Column(name = "neuropsychologyIntellectualPerformanceNonverbalDesignCap")
	private boolean neuropsychologyIntellectualPerformanceNonverbalDesignCap;
	@Column(name = "neuropsychologyNeuropsychologicalProfile")
	private boolean neuropsychologyNeuropsychologicalProfile;
	@Column(name = "neuropsychologyNeuropsychologicalProfileAttention")
	private boolean neuropsychologyNeuropsychologicalProfileAttention;
	@Column(name = "neuropsychologyNeuropsychologicalProfileExecutiveFunction")
	private boolean neuropsychologyNeuropsychologicalProfileExecutiveFunction;
	@Column(name = "neuropsychologyNeuropsychologicalProfileCognitiveSpeed")
	private boolean neuropsychologyNeuropsychologicalProfileCognitiveSpeed;
	@Column(name = "neuropsychologyNeuropsychologicalProfileSpeechExpressively")
	private boolean neuropsychologyNeuropsychologicalProfileSpeechExpressively;
	@Column(name = "neuropsychologyNeuropsychologicalProfileSpeechUnderstanding")
	private boolean neuropsychologyNeuropsychologicalProfileSpeechUnderstanding;
	@Column(name = "neuropsychologyNeuropsychologicalProfileMemoryOperating")
	private boolean neuropsychologyNeuropsychologicalProfileMemoryOperating;
	@Column(name = "neuropsychologyNeuropsychologicalProfileMemoryVerbal")
	private boolean neuropsychologyNeuropsychologicalProfileMemoryVerbal;
	@Column(name = "neuropsychologyNeuropsychologicalProfileMemoryNonverbal")
	private boolean neuropsychologyNeuropsychologicalProfileMemoryNonverbal;
	@Column(name = "neuropsychologyNeuropsychologicalProfileMemoryLearning")
	private boolean neuropsychologyNeuropsychologicalProfileMemoryLearning;
	@Column(name = "neuropsychologyNeuropsychologicalProfilePerceptionSpeech")
	private boolean neuropsychologyNeuropsychologicalProfilePerceptionSpeech;
	@Column(name = "neuropsychologyNeuropsychologicalProfilePerceptionVisual")
	private boolean neuropsychologyNeuropsychologicalProfilePerceptionVisual;
	@Column(name = "neuropsychologyNeuropsychologicalProfilePerceptionSpatial")
	private boolean neuropsychologyNeuropsychologicalProfilePerceptionSpatial;
	@Column(name = "neuropsychologyNeuropsychologicalProfileMotorSkillsDexterity")
	private boolean neuropsychologyNeuropsychologicalProfileMotorSkillsDexterity;
	@Column(name = "neuropsychologyNeuropsychologicalProfileMotorCoordination")
	private boolean neuropsychologyNeuropsychologicalProfileMotorCoordination;
	@Column(name = "neuropsychologyPresenceOfChanges")
	private boolean neuropsychologyPresenceOfChanges;
	@Column(name = "neuropsychologyPresenceOfChangesDetail")
	private boolean neuropsychologyPresenceOfChangesDetail;
	@Column(name = "neuropsychologyEmotionalStatus")
	private boolean neuropsychologyEmotionalStatus;
	@Column(name = "neuropsychologyComment")
	private boolean neuropsychologyComment;
	@Column(name = "neuropsychologyDeleted")
	private boolean neuropsychologyDeleted;
	@Column(name = "neuropsychologyAddUserId")
	private boolean neuropsychologyAddUserId;
	@Column(name = "neuropsychologyPatientId")
	private boolean neuropsychologyPatientId;
	@Column(name = "neuropsychologyStatus")
	private boolean neuropsychologyStatus;
	@Column(name = "neuropsychologyFindingDetail")
	private boolean neuropsychologyFindingDetail;

	// Operation properties
	@Column(name = "operationId")
	private boolean operationId;
	@Column(name = "operationDate")
	private boolean operationDate;
	@Column(name = "operationDateOperation")
	private boolean operationDateOperation;
	@Column(name = "operationDoctorId")
	private boolean operationDoctorId;
	@Column(name = "operationAdded")
	private boolean operationAdded;
	@Column(name = "operationTypeOperation")
	private boolean operationTypeOperation;
	@Column(name = "operationRangeOperation")
	private boolean operationRangeOperation;
	@Column(name = "operationLocalizationOperation")
	private boolean operationLocalizationOperation;
	@Column(name = "operationMst")
	private boolean operationMst;
	@Column(name = "operationColostomy")
	private boolean operationColostomy;
	@Column(name = "operationVNS")
	private boolean operationVNS;
	@Column(name = "operationVNsImplantationDate")
	private boolean operationVNsImplantationDate;
	@Column(name = "operationOperationDetails")
	private boolean operationOperationDetails;
	@Column(name = "operationCompleteResection")
	private boolean operationCompleteResection;
	@Column(name = "operationComment")
	private boolean operationComment;
	@Column(name = "operationDeleted")
	private boolean operationDeleted;
	@Column(name = "operationAddUserId")
	private boolean operationAddUserId;
	@Column(name = "operationPatientId")
	private boolean operationPatientId;
	@Column(name = "operationStatus")
	private boolean operationStatus;

	// Outcome properties
	@Column(name = "outcomeId")
	private boolean outcomeId;
	@Column(name = "outcomeDate")
	private boolean outcomeDate;
	@Column(name = "outcomeDoctorId")
	private boolean outcomeDoctorId;
	@Column(name = "outcomeAdded")
	private boolean outcomeAdded;
	@Column(name = "outcomeFinallySeizuresIdCom")
	private boolean outcomeFinallySeizuresIdCom;
	@Column(name = "outcomeEEG")
	private boolean outcomeEEG;
	@Column(name = "outcomeAED")
	private boolean outcomeAED;
	@Column(name = "outcomeMRI")
	private boolean outcomeMRI;
	@Column(name = "outcomeNeuropsychology")
	private boolean outcomeNeuropsychology;
	@Column(name = "outcomeComment")
	private boolean outcomeComment;
	@Column(name = "outcomeDeleted")
	private boolean outcomeDeleted;
	@Column(name = "outcomeAddUserId")
	private boolean outcomeAddUserId;
	@Column(name = "outcomePatientId")
	private boolean outcomePatientId;
	@Column(name = "outcomeStatus")
	private boolean outcomeStatus;
	@Column(name = "outcomeSeizureOutcome")
	private boolean outcomeSeizureOutcome;	
	@Column(name = "outcomeDistance")
	private boolean outcomeDistance;	
	@Column(name = "outcomeOperationId")
	private boolean outcomeOperationId;
	
	// Pharmacotherapy properties
	@Column(name = "pharmacotherapyId")
	private boolean pharmacotherapyId;
	@Column(name = "pharmacotherapyDate")
	private boolean pharmacotherapyDate;
	@Column(name = "pharmacotherapyDoctorId")
	private boolean pharmacotherapyDoctorId;
	@Column(name = "pharmacotherapyAdded")
	private boolean pharmacotherapyAdded;
	@Column(name = "pharmacotherapyAED")
	private boolean pharmacotherapyAED;
	@Column(name = "pharmacotherapyEffective")
	private boolean pharmacotherapyEffective;
	@Column(name = "pharmacotherapyDuringSurgery")
	private boolean pharmacotherapyDuringSurgery;
	@Column(name = "pharmacotherapyComment")
	private boolean pharmacotherapyComment;
	@Column(name = "pharmacotherapyDeleted")
	private boolean pharmacotherapyDeleted;
	@Column(name = "pharmacotherapyAddUserId")
	private boolean pharmacotherapyAddUserId;
	@Column(name = "pharmacotherapyPatientId")
	private boolean pharmacotherapyPatientId;
	@Column(name = "pharmacotherapyStatus")
	private boolean pharmacotherapyStatus;

	// Seizure properties
	@Column(name = "seizureId")
	private boolean seizureId;
	@Column(name = "seizureDate")
	private boolean seizureDate;
	@Column(name = "seizureDoctorId")
	private boolean seizureDoctorId;
	@Column(name = "seizureAdded")
	private boolean seizureAdded;
	@Column(name = "seizureFrequency")
	private boolean seizureFrequency;
	@Column(name = "seizureSecondarilyGeneralizedSeizure")
	private boolean seizureSecondarilyGeneralizedSeizure;
	@Column(name = "seizureStatusEpilepticus")
	private boolean seizureStatusEpilepticus;
	@Column(name = "seizureSSCClassification")
	private boolean seizureSSCClassification;
	@Column(name = "seizureILAEClassification")
	private boolean seizureILAEClassification;
	@Column(name = "seizureSeizuresWhileAwakeEpi")
	private boolean seizureSeizuresWhileAwakeEpi;
	@Column(name = "seizureSeizuresWhileAwakeLatent")
	private boolean seizureSeizuresWhileAwakeLatent;
	@Column(name = "seizureSeizuresWhileAwakeNonEpi")
	private boolean seizureSeizuresWhileAwakeNonEpi;
	@Column(name = "seizureSeizuresWhileSleepEpi")
	private boolean seizureSeizuresWhileSleepEpi;
	@Column(name = "seizureSeizuresWhileSleepLatent")
	private boolean seizureSeizuresWhileSleepLatent;
	@Column(name = "seizureSeizuresWhileSleepNonEpi")
	private boolean seizureSeizuresWhileSleepNonEpi;
	@Column(name = "seizureComment")
	private boolean seizureComment;
	@Column(name = "seizureDeleted")
	private boolean seizureDeleted;
	@Column(name = "seizureAddUserId")
	private boolean seizureAddUserId;
	@Column(name = "seizurePatientId")
	private boolean seizurePatientId;
	@Column(name = "seizureStatus")
	private boolean seizureStatus;

	// NeuropsychologyOld properties
	@Column(name = "neuropsychologyOldId")
	private boolean neuropsychologyOldId;
	@Column(name = "neuropsychologyOldDate")
	private boolean neuropsychologyOldDate;
	@Column(name = "neuropsychologyOldDoctorId")
	private boolean neuropsychologyOldDoctorId;
	@Column(name = "neuropsychologyOldAdded")
	private boolean neuropsychologyOldAdded;
	@Column(name = "neuropsychologyOldComment")
	private boolean neuropsychologyOldComment;
	@Column(name = "neuropsychologyOldDeleted")
	private boolean neuropsychologyOldDeleted;
	@Column(name = "neuropsychologyOldAddUserId")
	private boolean neuropsychologyOldAddUserId;
	@Column(name = "neuropsychologyOldPatientId")
	private boolean neuropsychologyOldPatientId;
	@Column(name = "neuropsychologyOldNeuropsychologicalExamination")
	private boolean neuropsychologyOldNeuropsychologicalExamination;
	@Column(name = "neuropsychologyOldIntelligenceLevel")
	private boolean neuropsychologyOldIntelligenceLevel;
	@Column(name = "neuropsychologyOldSpecificLearning")
	private boolean neuropsychologyOldSpecificLearning;
	@Column(name = "neuropsychologyOldDevelopmentalLanguageDisorders")
	private boolean neuropsychologyOldDevelopmentalLanguageDisorders;
	@Column(name = "neuropsychologyOldAdhdSyndrome")
	private boolean neuropsychologyOldAdhdSyndrome;

	// InvasiveTestCorticalMapping properties
	@Column(name = "invasiveTestCorticalMappingId")
	private boolean invasiveTestCorticalMappingId;
	@Column(name = "invasiveTestCorticalMappingDate")
	private boolean invasiveTestCorticalMappingDate;
	@Column(name = "invasiveTestCorticalMappingDoctorId")
	private boolean invasiveTestCorticalMappingDoctorId;
	@Column(name = "invasiveTestCorticalMappingAdded")
	private boolean invasiveTestCorticalMappingAdded;
	@Column(name = "invasiveTestCorticalMappingComment")
	private boolean invasiveTestCorticalMappingComment;
	@Column(name = "invasiveTestCorticalMappingDeleted")
	private boolean invasiveTestCorticalMappingDeleted;
	@Column(name = "invasiveTestCorticalMappingAddUserId")
	private boolean invasiveTestCorticalMappingAddUserId;
	@Column(name = "invasiveTestCorticalMappingPatientId")
	private boolean invasiveTestCorticalMappingPatientId;
	@Column(name = "invasiveTestCorticalMappingStatus")
	private boolean invasiveTestCorticalMappingStatus;
	@Column(name = "invasiveTestCorticalMappingDone")
	private boolean invasiveTestCorticalMappingDone;
	@Column(name = "invasiveTestCorticalMappingCorticalMapping")
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

	public boolean isDiagnosticTestMRILocalizationPetHypometabolism() {
		return diagnosticTestMRILocalizationPetHypometabolism;
	}

	public void setDiagnosticTestMRILocalizationPetHypometabolism(
			boolean diagnosticTestMRILocalizationPetHypometabolism) {
		this.diagnosticTestMRILocalizationPetHypometabolism = diagnosticTestMRILocalizationPetHypometabolism;
	}

	public boolean isNeuropsychologyFindingDetail() {
		return neuropsychologyFindingDetail;
	}

	public void setNeuropsychologyFindingDetail(
			boolean neuropsychologyFindingDetail) {
		this.neuropsychologyFindingDetail = neuropsychologyFindingDetail;
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

	public boolean isPatientDeleted() {
		return patientDeleted;
	}

	public void setPatientDeleted(boolean patientDeleted) {
		this.patientDeleted = patientDeleted;
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

	public void setAnamnesisEarlyPmdRetardation(
			boolean anamnesisEarlyPmdRetardation) {
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

	public boolean isComplicationIdCom() {
		return complicationIdCom;
	}

	public void setComplicationIdCom(boolean complicationIdCom) {
		this.complicationIdCom = complicationIdCom;
	}

	public boolean isComplicationComment() {
		return complicationComment;
	}

	public void setComplicationComment(boolean complicationComment) {
		this.complicationComment = complicationComment;
	}

	public boolean isComplicationDeleted() {
		return complicationDeleted;
	}

	public void setComplicationDeleted(boolean complicationDeleted) {
		this.complicationDeleted = complicationDeleted;
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

	public boolean isComplicationStatus() {
		return complicationStatus;
	}

	public void setComplicationStatus(boolean complicationStatus) {
		this.complicationStatus = complicationStatus;
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

	public void setDiagnosticTestEEGBasicActivity(
			boolean diagnosticTestEEGBasicActivity) {
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

	public void setDiagnosticTestEEGInterictalEEGSpikes(
			boolean diagnosticTestEEGInterictalEEGSpikes) {
		this.diagnosticTestEEGInterictalEEGSpikes = diagnosticTestEEGInterictalEEGSpikes;
	}

	public boolean isDiagnosticTestEEGLocalizationInerictalEEGSpikes() {
		return diagnosticTestEEGLocalizationInerictalEEGSpikes;
	}

	public void setDiagnosticTestEEGLocalizationInerictalEEGSpikes(
			boolean diagnosticTestEEGLocalizationInerictalEEGSpikes) {
		this.diagnosticTestEEGLocalizationInerictalEEGSpikes = diagnosticTestEEGLocalizationInerictalEEGSpikes;
	}

	public boolean isDiagnosticTestEEGStatusEpilepticus() {
		return diagnosticTestEEGStatusEpilepticus;
	}

	public void setDiagnosticTestEEGStatusEpilepticus(
			boolean diagnosticTestEEGStatusEpilepticus) {
		this.diagnosticTestEEGStatusEpilepticus = diagnosticTestEEGStatusEpilepticus;
	}

	public boolean isDiagnosticTestEEGSecondarySidedSynchrony() {
		return diagnosticTestEEGSecondarySidedSynchrony;
	}

	public void setDiagnosticTestEEGSecondarySidedSynchrony(
			boolean diagnosticTestEEGSecondarySidedSynchrony) {
		this.diagnosticTestEEGSecondarySidedSynchrony = diagnosticTestEEGSecondarySidedSynchrony;
	}

	public boolean isDiagnosticTestEEGIctalEEGPatterns() {
		return diagnosticTestEEGIctalEEGPatterns;
	}

	public void setDiagnosticTestEEGIctalEEGPatterns(
			boolean diagnosticTestEEGIctalEEGPatterns) {
		this.diagnosticTestEEGIctalEEGPatterns = diagnosticTestEEGIctalEEGPatterns;
	}

	public boolean isDiagnosticTestEEGLocalizationIctalEEGPattern() {
		return diagnosticTestEEGLocalizationIctalEEGPattern;
	}

	public void setDiagnosticTestEEGLocalizationIctalEEGPattern(
			boolean diagnosticTestEEGLocalizationIctalEEGPattern) {
		this.diagnosticTestEEGLocalizationIctalEEGPattern = diagnosticTestEEGLocalizationIctalEEGPattern;
	}

	public boolean isDiagnosticTestEEGComment() {
		return diagnosticTestEEGComment;
	}

	public void setDiagnosticTestEEGComment(boolean diagnosticTestEEGComment) {
		this.diagnosticTestEEGComment = diagnosticTestEEGComment;
	}

	public boolean isDiagnosticTestEEGDeleted() {
		return diagnosticTestEEGDeleted;
	}

	public void setDiagnosticTestEEGDeleted(boolean diagnosticTestEEGDeleted) {
		this.diagnosticTestEEGDeleted = diagnosticTestEEGDeleted;
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

	public boolean isDiagnosticTestEEGStatus() {
		return diagnosticTestEEGStatus;
	}

	public void setDiagnosticTestEEGStatus(boolean diagnosticTestEEGStatus) {
		this.diagnosticTestEEGStatus = diagnosticTestEEGStatus;
	}

	public boolean isDiagnosticTestMRIId() {
		return diagnosticTestMRIId;
	}

	public void setDiagnosticTestMRIId(boolean diagnosticTestMRIId) {
		this.diagnosticTestMRIId = diagnosticTestMRIId;
	}

	public boolean isDiagnosticTestMRIate() {
		return diagnosticTestMRIate;
	}

	public void setDiagnosticTestMRIate(boolean diagnosticTestMRIate) {
		this.diagnosticTestMRIate = diagnosticTestMRIate;
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

	public boolean isdiagnosticTestMRIInterictalSpect() {
		return diagnosticTestMRIInterictalSpect;
	}

	public void setdiagnosticTestMRIInterictalSpect(
			boolean diagnosticTestMRIInterictalSpect) {
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

	public void setDiagnosticTestMRIMrsProtocol(
			boolean diagnosticTestMRIMrsProtocol) {
		this.diagnosticTestMRIMrsProtocol = diagnosticTestMRIMrsProtocol;
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

	public void setDiagnosticTestMRIDtiDetailStudy(
			boolean diagnosticTestMRIDtiDetailStudy) {
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

	public void setDiagnosticTestMRIDetailsFmri(
			boolean diagnosticTestMRIDetailsFmri) {
		this.diagnosticTestMRIDetailsFmri = diagnosticTestMRIDetailsFmri;
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

	public void setDiagnosticTestMRIDetailsWada(
			boolean diagnosticTestMRIDetailsWada) {
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

	public void setDiagnosticTestMRILocalizationSpecHypoperfuse(
			boolean diagnosticTestMRILocalizationSpecHypoperfuse) {
		this.diagnosticTestMRILocalizationSpecHypoperfuse = diagnosticTestMRILocalizationSpecHypoperfuse;
	}

	public boolean isDiagnosticTestMRILocalizationMrsAbnormality() {
		return diagnosticTestMRILocalizationMrsAbnormality;
	}

	public void setDiagnosticTestMRILocalizationMrsAbnormality(
			boolean diagnosticTestMRILocalizationMrsAbnormality) {
		this.diagnosticTestMRILocalizationMrsAbnormality = diagnosticTestMRILocalizationMrsAbnormality;
	}

	public boolean isdiagnosticTestMRILocalizationPetHypometabolism() {
		return diagnosticTestMRILocalizationPetHypometabolism;
	}

	public void setdiagnosticTestMRILocalizationPetHypometabolism(
			boolean diagnosticTestMRILocalizationPetHypometabolism) {
		this.diagnosticTestMRILocalizationPetHypometabolism = diagnosticTestMRILocalizationPetHypometabolism;
	}

	public boolean isDiagnosticTestMRILocalizationSpecHyperperfuse() {
		return diagnosticTestMRILocalizationSpecHyperperfuse;
	}

	public void setDiagnosticTestMRILocalizationSpecHyperperfuse(
			boolean diagnosticTestMRILocalizationSpecHyperperfuse) {
		this.diagnosticTestMRILocalizationSpecHyperperfuse = diagnosticTestMRILocalizationSpecHyperperfuse;
	}

	public boolean isDiagnosticTestMRIFmriProtocols() {
		return diagnosticTestMRIFmriProtocols;
	}

	public void setDiagnosticTestMRIFmriProtocols(
			boolean diagnosticTestMRIFmriProtocols) {
		this.diagnosticTestMRIFmriProtocols = diagnosticTestMRIFmriProtocols;
	}

	public boolean isDiagnosticTestMRIComment() {
		return diagnosticTestMRIComment;
	}

	public void setDiagnosticTestMRIComment(boolean diagnosticTestMRIComment) {
		this.diagnosticTestMRIComment = diagnosticTestMRIComment;
	}

	public boolean isDiagnosticTestMRIDeleted() {
		return diagnosticTestMRIDeleted;
	}

	public void setDiagnosticTestMRIDeleted(boolean diagnosticTestMRIDeleted) {
		this.diagnosticTestMRIDeleted = diagnosticTestMRIDeleted;
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

	public boolean isDiagnosticTestMRIStatus() {
		return diagnosticTestMRIStatus;
	}

	public void setDiagnosticTestMRIStatus(boolean diagnosticTestMRIStatus) {
		this.diagnosticTestMRIStatus = diagnosticTestMRIStatus;
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

	public boolean isHistologyDeleted() {
		return histologyDeleted;
	}

	public void setHistologyDeleted(boolean histologyDeleted) {
		this.histologyDeleted = histologyDeleted;
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

	public boolean isHistologyStatus() {
		return histologyStatus;
	}

	public void setHistologyStatus(boolean histologyStatus) {
		this.histologyStatus = histologyStatus;
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

	public void setInvasiveTestECOGIntraOperativeEcog(
			boolean invasiveTestECOGIntraOperativeEcog) {
		this.invasiveTestECOGIntraOperativeEcog = invasiveTestECOGIntraOperativeEcog;
	}

	public boolean isInvasiveTestECOGEcogPatterns() {
		return invasiveTestECOGEcogPatterns;
	}

	public void setInvasiveTestECOGEcogPatterns(
			boolean invasiveTestECOGEcogPatterns) {
		this.invasiveTestECOGEcogPatterns = invasiveTestECOGEcogPatterns;
	}

	public boolean isInvasiveTestECOGEcogCover() {
		return invasiveTestECOGEcogCover;
	}

	public void setInvasiveTestECOGEcogCover(boolean invasiveTestECOGEcogCover) {
		this.invasiveTestECOGEcogCover = invasiveTestECOGEcogCover;
	}

	public boolean isInvasiveTestECOGAfterResectiomEcog() {
		return invasiveTestECOGAfterResectiomEcog;
	}

	public void setInvasiveTestECOGAfterResectiomEcog(
			boolean invasiveTestECOGAfterResectiomEcog) {
		this.invasiveTestECOGAfterResectiomEcog = invasiveTestECOGAfterResectiomEcog;
	}

	public boolean isInvasiveTestECOGAwakeCraniotomy() {
		return invasiveTestECOGAwakeCraniotomy;
	}

	public void setInvasiveTestECOGAwakeCraniotomy(
			boolean invasiveTestECOGAwakeCraniotomy) {
		this.invasiveTestECOGAwakeCraniotomy = invasiveTestECOGAwakeCraniotomy;
	}

	public boolean isInvasiveTestECOGComment() {
		return invasiveTestECOGComment;
	}

	public void setInvasiveTestECOGComment(boolean invasiveTestECOGComment) {
		this.invasiveTestECOGComment = invasiveTestECOGComment;
	}

	public boolean isInvasiveTestECOGDeleted() {
		return invasiveTestECOGDeleted;
	}

	public void setInvasiveTestECOGDeleted(boolean invasiveTestECOGDeleted) {
		this.invasiveTestECOGDeleted = invasiveTestECOGDeleted;
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

	public boolean isInvasiveTestECOGStatus() {
		return invasiveTestECOGStatus;
	}

	public void setInvasiveTestECOGStatus(boolean invasiveTestECOGStatus) {
		this.invasiveTestECOGStatus = invasiveTestECOGStatus;
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

	public void setInvasiveTestEEGInvasiveMonitoring(
			boolean invasiveTestEEGInvasiveMonitoring) {
		this.invasiveTestEEGInvasiveMonitoring = invasiveTestEEGInvasiveMonitoring;
	}

	public boolean isInvasiveTestEEGLocalizationIntracranialElectrodes() {
		return invasiveTestEEGLocalizationIntracranialElectrodes;
	}

	public void setInvasiveTestEEGLocalizationIntracranialElectrodes(
			boolean invasiveTestEEGLocalizationIntracranialElectrodes) {
		this.invasiveTestEEGLocalizationIntracranialElectrodes = invasiveTestEEGLocalizationIntracranialElectrodes;
	}

	public boolean isInvasiveTestEEGIntracranialElectrodes() {
		return invasiveTestEEGIntracranialElectrodes;
	}

	public void setInvasiveTestEEGIntracranialElectrodes(
			boolean invasiveTestEEGIntracranialElectrodes) {
		this.invasiveTestEEGIntracranialElectrodes = invasiveTestEEGIntracranialElectrodes;
	}

	public boolean isInvasiveTestEEGInvasiveEEGSlow() {
		return invasiveTestEEGInvasiveEEGSlow;
	}

	public void setInvasiveTestEEGInvasiveEEGSlow(
			boolean invasiveTestEEGInvasiveEEGSlow) {
		this.invasiveTestEEGInvasiveEEGSlow = invasiveTestEEGInvasiveEEGSlow;
	}

	public boolean isInvasiveTestEEGInvasiveEEGInterictalSpikes() {
		return invasiveTestEEGInvasiveEEGInterictalSpikes;
	}

	public void setInvasiveTestEEGInvasiveEEGInterictalSpikes(
			boolean invasiveTestEEGInvasiveEEGInterictalSpikes) {
		this.invasiveTestEEGInvasiveEEGInterictalSpikes = invasiveTestEEGInvasiveEEGInterictalSpikes;
	}

	public boolean isInvasiveTestEEGLocalizationInvasiveEEGInterictalSpikes() {
		return invasiveTestEEGLocalizationInvasiveEEGInterictalSpikes;
	}

	public void setInvasiveTestEEGLocalizationInvasiveEEGInterictalSpikes(
			boolean invasiveTestEEGLocalizationInvasiveEEGInterictalSpikes) {
		this.invasiveTestEEGLocalizationInvasiveEEGInterictalSpikes = invasiveTestEEGLocalizationInvasiveEEGInterictalSpikes;
	}

	public boolean isInvasiveTestEEGStatusEpilepticus() {
		return invasiveTestEEGStatusEpilepticus;
	}

	public void setInvasiveTestEEGStatusEpilepticus(
			boolean invasiveTestEEGStatusEpilepticus) {
		this.invasiveTestEEGStatusEpilepticus = invasiveTestEEGStatusEpilepticus;
	}

	public boolean isInvasiveTestEEGInvasiveIctalEEGPatterns() {
		return invasiveTestEEGInvasiveIctalEEGPatterns;
	}

	public void setInvasiveTestEEGInvasiveIctalEEGPatterns(
			boolean invasiveTestEEGInvasiveIctalEEGPatterns) {
		this.invasiveTestEEGInvasiveIctalEEGPatterns = invasiveTestEEGInvasiveIctalEEGPatterns;
	}

	public boolean isInvasiveTestEEGLocalizationIctalEEGPatterns() {
		return invasiveTestEEGLocalizationIctalEEGPatterns;
	}

	public void setInvasiveTestEEGLocalizationIctalEEGPatterns(
			boolean invasiveTestEEGLocalizationIctalEEGPatterns) {
		this.invasiveTestEEGLocalizationIctalEEGPatterns = invasiveTestEEGLocalizationIctalEEGPatterns;
	}

	public boolean isInvasiveTestEEGComment() {
		return invasiveTestEEGComment;
	}

	public void setInvasiveTestEEGComment(boolean invasiveTestEEGComment) {
		this.invasiveTestEEGComment = invasiveTestEEGComment;
	}

	public boolean isInvasiveTestEEGDeleted() {
		return invasiveTestEEGDeleted;
	}

	public void setInvasiveTestEEGDeleted(boolean invasiveTestEEGDeleted) {
		this.invasiveTestEEGDeleted = invasiveTestEEGDeleted;
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

	public boolean isInvasiveTestEEGStatus() {
		return invasiveTestEEGStatus;
	}

	public void setInvasiveTestEEGStatus(boolean invasiveTestEEGStatus) {
		this.invasiveTestEEGStatus = invasiveTestEEGStatus;
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

	public void setNeurologicalFindingDoctorId(
			boolean neurologicalFindingDoctorId) {
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

	public void setNeurologicalFindingHemisphereDominance(
			boolean neurologicalFindingHemisphereDominance) {
		this.neurologicalFindingHemisphereDominance = neurologicalFindingHemisphereDominance;
	}

	public boolean isNeurologicalFindingAbnormalNeurologicalFinding() {
		return neurologicalFindingAbnormalNeurologicalFinding;
	}

	public void setNeurologicalFindingAbnormalNeurologicalFinding(
			boolean neurologicalFindingAbnormalNeurologicalFinding) {
		this.neurologicalFindingAbnormalNeurologicalFinding = neurologicalFindingAbnormalNeurologicalFinding;
	}

	public boolean isNeurologicalFindingHemiparesis() {
		return neurologicalFindingHemiparesis;
	}

	public void setNeurologicalFindingHemiparesis(
			boolean neurologicalFindingHemiparesis) {
		this.neurologicalFindingHemiparesis = neurologicalFindingHemiparesis;
	}

	public boolean isNeurologicalFindingVisualFieldDefects() {
		return neurologicalFindingVisualFieldDefects;
	}

	public void setNeurologicalFindingVisualFieldDefects(
			boolean neurologicalFindingVisualFieldDefects) {
		this.neurologicalFindingVisualFieldDefects = neurologicalFindingVisualFieldDefects;
	}

	public boolean isNeurologicalFindingComment() {
		return neurologicalFindingComment;
	}

	public void setNeurologicalFindingComment(boolean neurologicalFindingComment) {
		this.neurologicalFindingComment = neurologicalFindingComment;
	}

	public boolean isNeurologicalFindingDeleted() {
		return neurologicalFindingDeleted;
	}

	public void setNeurologicalFindingDeleted(boolean neurologicalFindingDeleted) {
		this.neurologicalFindingDeleted = neurologicalFindingDeleted;
	}

	public boolean isNeurologicalFindingAddUserId() {
		return neurologicalFindingAddUserId;
	}

	public void setNeurologicalFindingAddUserId(
			boolean neurologicalFindingAddUserId) {
		this.neurologicalFindingAddUserId = neurologicalFindingAddUserId;
	}

	public boolean isNeurologicalFindingPatientId() {
		return neurologicalFindingPatientId;
	}

	public void setNeurologicalFindingPatientId(
			boolean neurologicalFindingPatientId) {
		this.neurologicalFindingPatientId = neurologicalFindingPatientId;
	}

	public boolean isNeurologicalFindingStatus() {
		return neurologicalFindingStatus;
	}

	public void setNeurologicalFindingStatus(boolean neurologicalFindingStatus) {
		this.neurologicalFindingStatus = neurologicalFindingStatus;
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

	public boolean isNeuropsychologyIntellect() {
		return neuropsychologyIntellect;
	}

	public void setNeuropsychologyIntellect(boolean neuropsychologyIntellect) {
		this.neuropsychologyIntellect = neuropsychologyIntellect;
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

	public boolean isNeuropsychologyNeurodevelopmentalExamination() {
		return neuropsychologyNeurodevelopmentalExamination;
	}

	public void setNeuropsychologyNeurodevelopmentalExamination(
			boolean neuropsychologyNeurodevelopmentalExamination) {
		this.neuropsychologyNeurodevelopmentalExamination = neuropsychologyNeurodevelopmentalExamination;
	}

	public boolean isNeuropsychologyNeurodevelopmentalExaminationAdaptability() {
		return neuropsychologyNeurodevelopmentalExaminationAdaptability;
	}

	public void setNeuropsychologyNeurodevelopmentalExaminationAdaptability(
			boolean neuropsychologyNeurodevelopmentalExaminationAdaptability) {
		this.neuropsychologyNeurodevelopmentalExaminationAdaptability = neuropsychologyNeurodevelopmentalExaminationAdaptability;
	}

	public boolean isNeuropsychologyNeurodevelopmentalExaminationSpeechExpressively() {
		return neuropsychologyNeurodevelopmentalExaminationSpeechExpressively;
	}

	public void setNeuropsychologyNeurodevelopmentalExaminationSpeechExpressively(
			boolean neuropsychologyNeurodevelopmentalExaminationSpeechExpressively) {
		this.neuropsychologyNeurodevelopmentalExaminationSpeechExpressively = neuropsychologyNeurodevelopmentalExaminationSpeechExpressively;
	}

	public boolean isNeuropsychologyNeurodevelopmentalExaminationSpeechReceptively() {
		return neuropsychologyNeurodevelopmentalExaminationSpeechReceptively;
	}

	public void setNeuropsychologyNeurodevelopmentalExaminationSpeechReceptively(
			boolean neuropsychologyNeurodevelopmentalExaminationSpeechReceptively) {
		this.neuropsychologyNeurodevelopmentalExaminationSpeechReceptively = neuropsychologyNeurodevelopmentalExaminationSpeechReceptively;
	}

	public boolean isNeuropsychologyNeurodevelopmentalExaminationFineMotorSkills() {
		return neuropsychologyNeurodevelopmentalExaminationFineMotorSkills;
	}

	public void setNeuropsychologyNeurodevelopmentalExaminationFineMotorSkills(
			boolean neuropsychologyNeurodevelopmentalExaminationFineMotorSkills) {
		this.neuropsychologyNeurodevelopmentalExaminationFineMotorSkills = neuropsychologyNeurodevelopmentalExaminationFineMotorSkills;
	}

	public boolean isNeuropsychologyNeurodevelopmentalExaminationGrossMotorSkills() {
		return neuropsychologyNeurodevelopmentalExaminationGrossMotorSkills;
	}

	public void setNeuropsychologyNeurodevelopmentalExaminationGrossMotorSkills(
			boolean neuropsychologyNeurodevelopmentalExaminationGrossMotorSkills) {
		this.neuropsychologyNeurodevelopmentalExaminationGrossMotorSkills = neuropsychologyNeurodevelopmentalExaminationGrossMotorSkills;
	}

	public boolean isNeuropsychologyNeurodevelopmentalExaminationSocialBehavior() {
		return neuropsychologyNeurodevelopmentalExaminationSocialBehavior;
	}

	public void setNeuropsychologyNeurodevelopmentalExaminationSocialBehavior(
			boolean neuropsychologyNeurodevelopmentalExaminationSocialBehavior) {
		this.neuropsychologyNeurodevelopmentalExaminationSocialBehavior = neuropsychologyNeurodevelopmentalExaminationSocialBehavior;
	}

	public boolean isNeuropsychologyIntellectualPerformance() {
		return neuropsychologyIntellectualPerformance;
	}

	public void setNeuropsychologyIntellectualPerformance(
			boolean neuropsychologyIntellectualPerformance) {
		this.neuropsychologyIntellectualPerformance = neuropsychologyIntellectualPerformance;
	}

	public boolean isNeuropsychologyIntellectualPerformanceVerbally() {
		return neuropsychologyIntellectualPerformanceVerbally;
	}

	public void setNeuropsychologyIntellectualPerformanceVerbally(
			boolean neuropsychologyIntellectualPerformanceVerbally) {
		this.neuropsychologyIntellectualPerformanceVerbally = neuropsychologyIntellectualPerformanceVerbally;
	}

	public boolean isNeuropsychologyIntellectualPerformanceNonverbalAbstraction() {
		return neuropsychologyIntellectualPerformanceNonverbalAbstraction;
	}

	public void setNeuropsychologyIntellectualPerformanceNonverbalAbstraction(
			boolean neuropsychologyIntellectualPerformanceNonverbalAbstraction) {
		this.neuropsychologyIntellectualPerformanceNonverbalAbstraction = neuropsychologyIntellectualPerformanceNonverbalAbstraction;
	}

	public boolean isneuropsychologyIntellectualPerformanceNonverbalDesignCap() {
		return neuropsychologyIntellectualPerformanceNonverbalDesignCap;
	}

	public void setneuropsychologyIntellectualPerformanceNonverbalDesignCap(
			boolean neuropsychologyIntellectualPerformanceNonverbalDesignCap) {
		this.neuropsychologyIntellectualPerformanceNonverbalDesignCap = neuropsychologyIntellectualPerformanceNonverbalDesignCap;
	}

	public boolean isNeuropsychologyNeuropsychologicalProfile() {
		return neuropsychologyNeuropsychologicalProfile;
	}

	public void setNeuropsychologyNeuropsychologicalProfile(
			boolean neuropsychologyNeuropsychologicalProfile) {
		this.neuropsychologyNeuropsychologicalProfile = neuropsychologyNeuropsychologicalProfile;
	}

	public boolean isNeuropsychologyNeuropsychologicalProfileAttention() {
		return neuropsychologyNeuropsychologicalProfileAttention;
	}

	public void setNeuropsychologyNeuropsychologicalProfileAttention(
			boolean neuropsychologyNeuropsychologicalProfileAttention) {
		this.neuropsychologyNeuropsychologicalProfileAttention = neuropsychologyNeuropsychologicalProfileAttention;
	}

	public boolean isNeuropsychologyNeuropsychologicalProfileExecutiveFunction() {
		return neuropsychologyNeuropsychologicalProfileExecutiveFunction;
	}

	public void setNeuropsychologyNeuropsychologicalProfileExecutiveFunction(
			boolean neuropsychologyNeuropsychologicalProfileExecutiveFunction) {
		this.neuropsychologyNeuropsychologicalProfileExecutiveFunction = neuropsychologyNeuropsychologicalProfileExecutiveFunction;
	}

	public boolean isNeuropsychologyNeuropsychologicalProfileCognitiveSpeed() {
		return neuropsychologyNeuropsychologicalProfileCognitiveSpeed;
	}

	public void setNeuropsychologyNeuropsychologicalProfileCognitiveSpeed(
			boolean neuropsychologyNeuropsychologicalProfileCognitiveSpeed) {
		this.neuropsychologyNeuropsychologicalProfileCognitiveSpeed = neuropsychologyNeuropsychologicalProfileCognitiveSpeed;
	}

	public boolean isNeuropsychologyNeuropsychologicalProfileSpeechExpressively() {
		return neuropsychologyNeuropsychologicalProfileSpeechExpressively;
	}

	public void setNeuropsychologyNeuropsychologicalProfileSpeechExpressively(
			boolean neuropsychologyNeuropsychologicalProfileSpeechExpressively) {
		this.neuropsychologyNeuropsychologicalProfileSpeechExpressively = neuropsychologyNeuropsychologicalProfileSpeechExpressively;
	}

	public boolean isNeuropsychologyNeuropsychologicalProfileSpeechUnderstanding() {
		return neuropsychologyNeuropsychologicalProfileSpeechUnderstanding;
	}

	public void setNeuropsychologyNeuropsychologicalProfileSpeechUnderstanding(
			boolean neuropsychologyNeuropsychologicalProfileSpeechUnderstanding) {
		this.neuropsychologyNeuropsychologicalProfileSpeechUnderstanding = neuropsychologyNeuropsychologicalProfileSpeechUnderstanding;
	}

	public boolean isNeuropsychologyNeuropsychologicalProfileMemoryOperating() {
		return neuropsychologyNeuropsychologicalProfileMemoryOperating;
	}

	public void setNeuropsychologyNeuropsychologicalProfileMemoryOperating(
			boolean neuropsychologyNeuropsychologicalProfileMemoryOperating) {
		this.neuropsychologyNeuropsychologicalProfileMemoryOperating = neuropsychologyNeuropsychologicalProfileMemoryOperating;
	}

	public boolean isNeuropsychologyNeuropsychologicalProfileMemoryVerbal() {
		return neuropsychologyNeuropsychologicalProfileMemoryVerbal;
	}

	public void setNeuropsychologyNeuropsychologicalProfileMemoryVerbal(
			boolean neuropsychologyNeuropsychologicalProfileMemoryVerbal) {
		this.neuropsychologyNeuropsychologicalProfileMemoryVerbal = neuropsychologyNeuropsychologicalProfileMemoryVerbal;
	}

	public boolean isNeuropsychologyNeuropsychologicalProfileMemoryNonverbal() {
		return neuropsychologyNeuropsychologicalProfileMemoryNonverbal;
	}

	public void setNeuropsychologyNeuropsychologicalProfileMemoryNonverbal(
			boolean neuropsychologyNeuropsychologicalProfileMemoryNonverbal) {
		this.neuropsychologyNeuropsychologicalProfileMemoryNonverbal = neuropsychologyNeuropsychologicalProfileMemoryNonverbal;
	}

	public boolean isNeuropsychologyNeuropsychologicalProfileMemoryLearning() {
		return neuropsychologyNeuropsychologicalProfileMemoryLearning;
	}

	public void setNeuropsychologyNeuropsychologicalProfileMemoryLearning(
			boolean neuropsychologyNeuropsychologicalProfileMemoryLearning) {
		this.neuropsychologyNeuropsychologicalProfileMemoryLearning = neuropsychologyNeuropsychologicalProfileMemoryLearning;
	}

	public boolean isNeuropsychologyNeuropsychologicalProfilePerceptionSpeech() {
		return neuropsychologyNeuropsychologicalProfilePerceptionSpeech;
	}

	public void setNeuropsychologyNeuropsychologicalProfilePerceptionSpeech(
			boolean neuropsychologyNeuropsychologicalProfilePerceptionSpeech) {
		this.neuropsychologyNeuropsychologicalProfilePerceptionSpeech = neuropsychologyNeuropsychologicalProfilePerceptionSpeech;
	}

	public boolean isNeuropsychologyNeuropsychologicalProfilePerceptionVisual() {
		return neuropsychologyNeuropsychologicalProfilePerceptionVisual;
	}

	public void setNeuropsychologyNeuropsychologicalProfilePerceptionVisual(
			boolean neuropsychologyNeuropsychologicalProfilePerceptionVisual) {
		this.neuropsychologyNeuropsychologicalProfilePerceptionVisual = neuropsychologyNeuropsychologicalProfilePerceptionVisual;
	}

	public boolean isNeuropsychologyNeuropsychologicalProfilePerceptionSpatial() {
		return neuropsychologyNeuropsychologicalProfilePerceptionSpatial;
	}

	public void setNeuropsychologyNeuropsychologicalProfilePerceptionSpatial(
			boolean neuropsychologyNeuropsychologicalProfilePerceptionSpatial) {
		this.neuropsychologyNeuropsychologicalProfilePerceptionSpatial = neuropsychologyNeuropsychologicalProfilePerceptionSpatial;
	}

	public boolean isNeuropsychologyNeuropsychologicalProfileMotorSkillsDexterity() {
		return neuropsychologyNeuropsychologicalProfileMotorSkillsDexterity;
	}

	public void setNeuropsychologyNeuropsychologicalProfileMotorSkillsDexterity(
			boolean neuropsychologyNeuropsychologicalProfileMotorSkillsDexterity) {
		this.neuropsychologyNeuropsychologicalProfileMotorSkillsDexterity = neuropsychologyNeuropsychologicalProfileMotorSkillsDexterity;
	}

	public boolean isNeuropsychologyNeuropsychologicalProfileMotorCoordination() {
		return neuropsychologyNeuropsychologicalProfileMotorCoordination;
	}

	public void setNeuropsychologyNeuropsychologicalProfileMotorCoordination(
			boolean neuropsychologyNeuropsychologicalProfileMotorCoordination) {
		this.neuropsychologyNeuropsychologicalProfileMotorCoordination = neuropsychologyNeuropsychologicalProfileMotorCoordination;
	}

	public boolean isNeuropsychologyPresenceOfChanges() {
		return neuropsychologyPresenceOfChanges;
	}

	public void setNeuropsychologyPresenceOfChanges(
			boolean neuropsychologyPresenceOfChanges) {
		this.neuropsychologyPresenceOfChanges = neuropsychologyPresenceOfChanges;
	}

	public boolean isNeuropsychologyPresenceOfChangesDetail() {
		return neuropsychologyPresenceOfChangesDetail;
	}

	public void setNeuropsychologyPresenceOfChangesDetail(
			boolean neuropsychologyPresenceOfChangesDetail) {
		this.neuropsychologyPresenceOfChangesDetail = neuropsychologyPresenceOfChangesDetail;
	}

	public boolean isNeuropsychologyEmotionalStatus() {
		return neuropsychologyEmotionalStatus;
	}

	public void setNeuropsychologyEmotionalStatus(
			boolean neuropsychologyEmotionalStatus) {
		this.neuropsychologyEmotionalStatus = neuropsychologyEmotionalStatus;
	}

	public boolean isNeuropsychologyComment() {
		return neuropsychologyComment;
	}

	public void setNeuropsychologyComment(boolean neuropsychologyComment) {
		this.neuropsychologyComment = neuropsychologyComment;
	}

	public boolean isNeuropsychologyDeleted() {
		return neuropsychologyDeleted;
	}

	public void setNeuropsychologyDeleted(boolean neuropsychologyDeleted) {
		this.neuropsychologyDeleted = neuropsychologyDeleted;
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

	public boolean isNeuropsychologyStatus() {
		return neuropsychologyStatus;
	}

	public void setNeuropsychologyStatus(boolean neuropsychologyStatus) {
		this.neuropsychologyStatus = neuropsychologyStatus;
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

	public void setOperationLocalizationOperation(
			boolean operationLocalizationOperation) {
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

	public void setOperationVNsImplantationDate(
			boolean operationVNsImplantationDate) {
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

	public boolean isOperationDeleted() {
		return operationDeleted;
	}

	public void setOperationDeleted(boolean operationDeleted) {
		this.operationDeleted = operationDeleted;
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

	public boolean isOperationStatus() {
		return operationStatus;
	}

	public void setOperationStatus(boolean operationStatus) {
		this.operationStatus = operationStatus;
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

	public boolean isOutcomeFinallySeizuresIdCom() {
		return outcomeFinallySeizuresIdCom;
	}

	public void setOutcomeFinallySeizuresIdCom(
			boolean outcomeFinallySeizuresIdCom) {
		this.outcomeFinallySeizuresIdCom = outcomeFinallySeizuresIdCom;
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

	public boolean isOutcomeDeleted() {
		return outcomeDeleted;
	}

	public void setOutcomeDeleted(boolean outcomeDeleted) {
		this.outcomeDeleted = outcomeDeleted;
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

	public boolean isOutcomeStatus() {
		return outcomeStatus;
	}

	public void setOutcomeStatus(boolean outcomeStatus) {
		this.outcomeStatus = outcomeStatus;
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

	public void setPharmacotherapyDuringSurgery(
			boolean pharmacotherapyDuringSurgery) {
		this.pharmacotherapyDuringSurgery = pharmacotherapyDuringSurgery;
	}

	public boolean isPharmacotherapyComment() {
		return pharmacotherapyComment;
	}

	public void setPharmacotherapyComment(boolean pharmacotherapyComment) {
		this.pharmacotherapyComment = pharmacotherapyComment;
	}

	public boolean isPharmacotherapyDeleted() {
		return pharmacotherapyDeleted;
	}

	public void setPharmacotherapyDeleted(boolean pharmacotherapyDeleted) {
		this.pharmacotherapyDeleted = pharmacotherapyDeleted;
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

	public boolean isPharmacotherapyStatus() {
		return pharmacotherapyStatus;
	}

	public void setPharmacotherapyStatus(boolean pharmacotherapyStatus) {
		this.pharmacotherapyStatus = pharmacotherapyStatus;
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

	public void setSeizureSecondarilyGeneralizedSeizure(
			boolean seizureSecondarilyGeneralizedSeizure) {
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

	public void setSeizureSeizuresWhileAwakeEpi(
			boolean seizureSeizuresWhileAwakeEpi) {
		this.seizureSeizuresWhileAwakeEpi = seizureSeizuresWhileAwakeEpi;
	}

	public boolean isSeizureSeizuresWhileAwakeLatent() {
		return seizureSeizuresWhileAwakeLatent;
	}

	public void setSeizureSeizuresWhileAwakeLatent(
			boolean seizureSeizuresWhileAwakeLatent) {
		this.seizureSeizuresWhileAwakeLatent = seizureSeizuresWhileAwakeLatent;
	}

	public boolean isSeizureSeizuresWhileAwakeNonEpi() {
		return seizureSeizuresWhileAwakeNonEpi;
	}

	public void setSeizureSeizuresWhileAwakeNonEpi(
			boolean seizureSeizuresWhileAwakeNonEpi) {
		this.seizureSeizuresWhileAwakeNonEpi = seizureSeizuresWhileAwakeNonEpi;
	}

	public boolean isSeizureSeizuresWhileSleepEpi() {
		return seizureSeizuresWhileSleepEpi;
	}

	public void setSeizureSeizuresWhileSleepEpi(
			boolean seizureSeizuresWhileSleepEpi) {
		this.seizureSeizuresWhileSleepEpi = seizureSeizuresWhileSleepEpi;
	}

	public boolean isSeizureSeizuresWhileSleepLatent() {
		return seizureSeizuresWhileSleepLatent;
	}

	public void setSeizureSeizuresWhileSleepLatent(
			boolean seizureSeizuresWhileSleepLatent) {
		this.seizureSeizuresWhileSleepLatent = seizureSeizuresWhileSleepLatent;
	}

	public boolean isSeizureSeizuresWhileSleepNonEpi() {
		return seizureSeizuresWhileSleepNonEpi;
	}

	public void setSeizureSeizuresWhileSleepNonEpi(
			boolean seizureSeizuresWhileSleepNonEpi) {
		this.seizureSeizuresWhileSleepNonEpi = seizureSeizuresWhileSleepNonEpi;
	}

	public boolean isSeizureComment() {
		return seizureComment;
	}

	public void setSeizureComment(boolean seizureComment) {
		this.seizureComment = seizureComment;
	}

	public boolean isSeizureDeleted() {
		return seizureDeleted;
	}

	public void setSeizureDeleted(boolean seizureDeleted) {
		this.seizureDeleted = seizureDeleted;
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

	public boolean isSeizureStatus() {
		return seizureStatus;
	}

	public void setSeizureStatus(boolean seizureStatus) {
		this.seizureStatus = seizureStatus;
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

	public void setInvasiveTestCorticalMapping(
			boolean invasiveTestCorticalMapping) {
		this.invasiveTestCorticalMapping = invasiveTestCorticalMapping;
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

	public boolean isNeuropsychologyOldDeleted() {
		return neuropsychologyOldDeleted;
	}

	public void setNeuropsychologyOldDeleted(boolean neuropsychologyOldDeleted) {
		this.neuropsychologyOldDeleted = neuropsychologyOldDeleted;
	}

	public boolean isNeuropsychologyOldAddUserId() {
		return neuropsychologyOldAddUserId;
	}

	public void setNeuropsychologyOldAddUserId(
			boolean neuropsychologyOldAddUserId) {
		this.neuropsychologyOldAddUserId = neuropsychologyOldAddUserId;
	}

	public boolean isNeuropsychologyOldPatientId() {
		return neuropsychologyOldPatientId;
	}

	public void setNeuropsychologyOldPatientId(
			boolean neuropsychologyOldPatientId) {
		this.neuropsychologyOldPatientId = neuropsychologyOldPatientId;
	}

	public boolean isNeuropsychologyOldNeuropsychologicalExamination() {
		return neuropsychologyOldNeuropsychologicalExamination;
	}

	public void setNeuropsychologyOldNeuropsychologicalExamination(
			boolean neuropsychologyOldNeuropsychologicalExamination) {
		this.neuropsychologyOldNeuropsychologicalExamination = neuropsychologyOldNeuropsychologicalExamination;
	}

	public boolean isNeuropsychologyOldIntelligenceLevel() {
		return neuropsychologyOldIntelligenceLevel;
	}

	public void setNeuropsychologyOldIntelligenceLevel(
			boolean neuropsychologyOldIntelligenceLevel) {
		this.neuropsychologyOldIntelligenceLevel = neuropsychologyOldIntelligenceLevel;
	}

	public boolean isNeuropsychologyOldSpecificLearning() {
		return neuropsychologyOldSpecificLearning;
	}

	public void setNeuropsychologyOldSpecificLearning(
			boolean neuropsychologyOldSpecificLearning) {
		this.neuropsychologyOldSpecificLearning = neuropsychologyOldSpecificLearning;
	}

	public boolean isNeuropsychologyOldDevelopmentalLanguageDisorders() {
		return neuropsychologyOldDevelopmentalLanguageDisorders;
	}

	public void setNeuropsychologyOldDevelopmentalLanguageDisorders(
			boolean neuropsychologyOldDevelopmentalLanguageDisorders) {
		this.neuropsychologyOldDevelopmentalLanguageDisorders = neuropsychologyOldDevelopmentalLanguageDisorders;
	}

	public boolean isNeuropsychologyOldAdhdSyndrome() {
		return neuropsychologyOldAdhdSyndrome;
	}

	public void setNeuropsychologyOldAdhdSyndrome(
			boolean neuropsychologyOldAdhdSyndrome) {
		this.neuropsychologyOldAdhdSyndrome = neuropsychologyOldAdhdSyndrome;
	}

	public boolean isInvasiveTestCorticalMappingId() {
		return invasiveTestCorticalMappingId;
	}

	public void setInvasiveTestCorticalMappingId(
			boolean invasiveTestCorticalMappingId) {
		this.invasiveTestCorticalMappingId = invasiveTestCorticalMappingId;
	}

	public boolean isInvasiveTestCorticalMappingDate() {
		return invasiveTestCorticalMappingDate;
	}

	public void setInvasiveTestCorticalMappingDate(
			boolean invasiveTestCorticalMappingDate) {
		this.invasiveTestCorticalMappingDate = invasiveTestCorticalMappingDate;
	}

	public boolean isInvasiveTestCorticalMappingDoctorId() {
		return invasiveTestCorticalMappingDoctorId;
	}

	public void setInvasiveTestCorticalMappingDoctorId(
			boolean invasiveTestCorticalMappingDoctorId) {
		this.invasiveTestCorticalMappingDoctorId = invasiveTestCorticalMappingDoctorId;
	}

	public boolean isInvasiveTestCorticalMappingAdded() {
		return invasiveTestCorticalMappingAdded;
	}

	public void setInvasiveTestCorticalMappingAdded(
			boolean invasiveTestCorticalMappingAdded) {
		this.invasiveTestCorticalMappingAdded = invasiveTestCorticalMappingAdded;
	}

	public boolean isInvasiveTestCorticalMappingComment() {
		return invasiveTestCorticalMappingComment;
	}

	public void setInvasiveTestCorticalMappingComment(
			boolean invasiveTestCorticalMappingComment) {
		this.invasiveTestCorticalMappingComment = invasiveTestCorticalMappingComment;
	}

	public boolean isInvasiveTestCorticalMappingDeleted() {
		return invasiveTestCorticalMappingDeleted;
	}

	public void setInvasiveTestCorticalMappingDeleted(
			boolean invasiveTestCorticalMappingDeleted) {
		this.invasiveTestCorticalMappingDeleted = invasiveTestCorticalMappingDeleted;
	}

	public boolean isInvasiveTestCorticalMappingAddUserId() {
		return invasiveTestCorticalMappingAddUserId;
	}

	public void setInvasiveTestCorticalMappingAddUserId(
			boolean invasiveTestCorticalMappingAddUserId) {
		this.invasiveTestCorticalMappingAddUserId = invasiveTestCorticalMappingAddUserId;
	}

	public boolean isInvasiveTestCorticalMappingPatientId() {
		return invasiveTestCorticalMappingPatientId;
	}

	public void setInvasiveTestCorticalMappingPatientId(
			boolean invasiveTestCorticalMappingPatientId) {
		this.invasiveTestCorticalMappingPatientId = invasiveTestCorticalMappingPatientId;
	}

	public boolean isInvasiveTestCorticalMappingStatus() {
		return invasiveTestCorticalMappingStatus;
	}

	public void setInvasiveTestCorticalMappingStatus(
			boolean invasiveTestCorticalMappingStatus) {
		this.invasiveTestCorticalMappingStatus = invasiveTestCorticalMappingStatus;
	}

	public boolean isInvasiveTestCorticalMappingDone() {
		return invasiveTestCorticalMappingDone;
	}

	public void setInvasiveTestCorticalMappingDone(
			boolean invasiveTestCorticalMappingDone) {
		this.invasiveTestCorticalMappingDone = invasiveTestCorticalMappingDone;
	}

	public boolean isInvasiveTestCorticalMappingCorticalMapping() {
		return invasiveTestCorticalMappingCorticalMapping;
	}

	public void setInvasiveTestCorticalMappingCorticalMapping(
			boolean invasiveTestCorticalMappingCorticalMapping) {
		this.invasiveTestCorticalMappingCorticalMapping = invasiveTestCorticalMappingCorticalMapping;
	}

	public boolean isDiagnosticTestEEGDone() {
		return diagnosticTestEEGDone;
	}

	public void setDiagnosticTestEEGDone(boolean diagnosticTestEEGDone) {
		this.diagnosticTestEEGDone = diagnosticTestEEGDone;
	}

	public boolean isDiagnosticTestEEGDescriptionVideoEEG() {
		return diagnosticTestEEGDescriptionVideoEEG;
	}

	public void setDiagnosticTestEEGDescriptionVideoEEG(
			boolean diagnosticTestEEGDescriptionVideoEEG) {
		this.diagnosticTestEEGDescriptionVideoEEG = diagnosticTestEEGDescriptionVideoEEG;
	}

	public boolean isDiagnosticTestMRIDone() {
		return diagnosticTestMRIDone;
	}

	public void setDiagnosticTestMRIDone(boolean diagnosticTestMRIDone) {
		this.diagnosticTestMRIDone = diagnosticTestMRIDone;
	}

	public boolean isDiagnosticTestMRIInterictalSpect() {
		return diagnosticTestMRIInterictalSpect;
	}

	public void setDiagnosticTestMRIInterictalSpect(
			boolean diagnosticTestMRIInterictalSpect) {
		this.diagnosticTestMRIInterictalSpect = diagnosticTestMRIInterictalSpect;
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

	public void setDiagnosticTestMRIDescription(
			boolean diagnosticTestMRIDescription) {
		this.diagnosticTestMRIDescription = diagnosticTestMRIDescription;
	}

	public boolean isNeuropsychologyIntellectualPerformanceNonverbalDesignCap() {
		return neuropsychologyIntellectualPerformanceNonverbalDesignCap;
	}

	public void setNeuropsychologyIntellectualPerformanceNonverbalDesignCap(
			boolean neuropsychologyIntellectualPerformanceNonverbalDesignCap) {
		this.neuropsychologyIntellectualPerformanceNonverbalDesignCap = neuropsychologyIntellectualPerformanceNonverbalDesignCap;
	}

	public boolean isDiagnosticTestMRIDescriptionPetHypometabolism() {
		return diagnosticTestMRIDescriptionPetHypometabolism;
	}

	public void setDiagnosticTestMRIDescriptionPetHypometabolism(
			boolean diagnosticTestMRIDescriptionPetHypometabolism) {
		this.diagnosticTestMRIDescriptionPetHypometabolism = diagnosticTestMRIDescriptionPetHypometabolism;
	}

	public boolean isDiagnosticTestMRIDescriptionSpectHypoperfuse() {
		return diagnosticTestMRIDescriptionSpectHypoperfuse;
	}

	public void setDiagnosticTestMRIDescriptionSpectHypoperfuse(
			boolean diagnosticTestMRIDescriptionSpectHypoperfuse) {
		this.diagnosticTestMRIDescriptionSpectHypoperfuse = diagnosticTestMRIDescriptionSpectHypoperfuse;
	}

	public boolean isDiagnosticTestMRIDescriptionSpectHyperperfuse() {
		return diagnosticTestMRIDescriptionSpectHyperperfuse;
	}

	public void setDiagnosticTestMRIDescriptionSpectHyperperfuse(
			boolean diagnosticTestMRIDescriptionSpectHyperperfuse) {
		this.diagnosticTestMRIDescriptionSpectHyperperfuse = diagnosticTestMRIDescriptionSpectHyperperfuse;
	}

	public boolean isDiagnosticTestMRIIctalSpect() {
		return diagnosticTestMRIIctalSpect;
	}

	public void setDiagnosticTestMRIIctalSpect(
			boolean diagnosticTestMRIIctalSpect) {
		this.diagnosticTestMRIIctalSpect = diagnosticTestMRIIctalSpect;
	}

	public boolean isDiagnosticTestMRIMrsFinding() {
		return diagnosticTestMRIMrsFinding;
	}

	public void setDiagnosticTestMRIMrsFinding(
			boolean diagnosticTestMRIMrsFinding) {
		this.diagnosticTestMRIMrsFinding = diagnosticTestMRIMrsFinding;
	}

	public boolean isDiagnosticTestMRIDescriptionMrsAbnormality() {
		return diagnosticTestMRIDescriptionMrsAbnormality;
	}

	public void setDiagnosticTestMRIDescriptionMrsAbnormality(
			boolean diagnosticTestMRIDescriptionMrsAbnormality) {
		this.diagnosticTestMRIDescriptionMrsAbnormality = diagnosticTestMRIDescriptionMrsAbnormality;
	}

	public boolean isDiagnosticTestMRIDetailsDtiStudy() {
		return diagnosticTestMRIDetailsDtiStudy;
	}

	public void setDiagnosticTestMRIDetailsDtiStudy(
			boolean diagnosticTestMRIDetailsDtiStudy) {
		this.diagnosticTestMRIDetailsDtiStudy = diagnosticTestMRIDetailsDtiStudy;
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

	public void setInvasiveTestECOGIntracranialElectrodes(
			boolean invasiveTestECOGIntracranialElectrodes) {
		this.invasiveTestECOGIntracranialElectrodes = invasiveTestECOGIntracranialElectrodes;
	}

	public boolean isInvasiveTestEEGDone() {
		return invasiveTestEEGDone;
	}

	public void setInvasiveTestEEGDone(boolean invasiveTestEEGDone) {
		this.invasiveTestEEGDone = invasiveTestEEGDone;
	}

	public boolean isOperationDateOperation() {
		return operationDateOperation;
	}

	public void setOperationDateOperation(boolean operationDateOperation) {
		this.operationDateOperation = operationDateOperation;
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

}

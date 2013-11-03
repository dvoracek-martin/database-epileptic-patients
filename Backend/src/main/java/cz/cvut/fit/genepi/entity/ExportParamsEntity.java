package cz.cvut.fit.genepi.entity;

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

	@Column(name = "histiology")
	private boolean histiology;

	@Column(name = "invasiveTestECOG")
	private boolean invasiveTestECOG;

	@Column(name = "invasiveTestEEG")
	private boolean invasiveTestEEG;

	@Column(name = "neurologicalFinding")
	private boolean neurologicalFinding;

	@Column(name = "neurolopsychology")
	private boolean neurolopsychology;

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

	// DiagnosticTestEEG properties
	@Column(name = "diagnosticTestEEGId")
	private boolean diagnosticTestEEGId;
	@Column(name = "diagnosticTestEEGDate")
	private boolean diagnosticTestEEGDate;
	@Column(name = "diagnosticTestEEGDoctorId")
	private boolean diagnosticTestEEGDoctorId;
	@Column(name = "diagnosticTestEEGAdded")
	private boolean diagnosticTestEEGAdded;
	@Column(name = "diagnosticTestEEGActivityIdCom")
	private boolean diagnosticTestEEGActivityIdCom;
	@Column(name = "diagnosticTestEEGSlowId")
	private boolean diagnosticTestEEGSlowId;
	@Column(name = "diagnosticTestEEGInterictalEEGSpikesComId")
	private boolean diagnosticTestEEGInterictalEEGSpikesComId;
	@Column(name = "diagnosticTestEEGLocalizationInerictalEEGSpikes")
	private boolean diagnosticTestEEGLocalizationInerictalEEGSpikes;
	@Column(name = "diagnosticTestEEGStatusEpilepticus")
	private boolean diagnosticTestEEGStatusEpilepticus;
	@Column(name = "diagnosticTestEEGSecondarySidedSynchrony")
	private boolean diagnosticTestEEGSecondarySidedSynchrony;
	@Column(name = "diagnosticTestEEGIctalEEGPatternsIdCom")
	private boolean diagnosticTestEEGIctalEEGPatternsIdCom;
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

	// DiagnosticTestMRI properties
	@Column(name = "diagnosticTestMRIId")
	private boolean diagnosticTestMRIId;
	@Column(name = "diagnosticTestMRIate")
	private boolean diagnosticTestMRIate;
	@Column(name = "diagnosticTestMRIDoctorId")
	private boolean diagnosticTestMRIDoctorId;
	@Column(name = "diagnosticTestMRIAdded")
	private boolean diagnosticTestMRIAdded;
	@Column(name = "diagnosticTestMRIProtocolIdCom")
	private boolean diagnosticTestMRIProtocolIdCom;
	@Column(name = "diagnosticTestMRIFindingIdCom")
	private boolean diagnosticTestMRIFindingIdCom;
	@Column(name = "diagnosticTestMRIFdgPetIdCom")
	private boolean diagnosticTestMRIFdgPetIdCom;
	@Column(name = "diagnosticTestMRIInterictalSpectIdCom")
	private boolean diagnosticTestMRIInterictalSpectIdCom;
	@Column(name = "diagnosticTestMRIIntaliSpectIdCom")
	private boolean diagnosticTestMRIIntaliSpectIdCom;
	@Column(name = "diagnosticTestMRISiscom")
	private boolean diagnosticTestMRISiscom;
	@Column(name = "diagnosticTestMRITimeAplicationRn")
	private boolean diagnosticTestMRITimeAplicationRn;
	@Column(name = "diagnosticTestMRITimingAplicationRnIdCom")
	private boolean diagnosticTestMRITimingAplicationRnIdCom;
	@Column(name = "diagnosticTestMRIMrsProtocolIdCom")
	private boolean diagnosticTestMRIMrsProtocolIdCom;
	@Column(name = "diagnosticTestMRIMrsFindingIdCom")
	private boolean diagnosticTestMRIMrsFindingIdCom;
	@Column(name = "diagnosticTestMRIDti")
	private boolean diagnosticTestMRIDti;
	@Column(name = "diagnosticTestMRIDtiDetailStudy")
	private boolean diagnosticTestMRIDtiDetailStudy;
	@Column(name = "diagnosticTestMRIFmri")
	private boolean diagnosticTestMRIFmri;
	@Column(name = "diagnosticTestMRIDetailsFmri")
	private boolean diagnosticTestMRIDetailsFmri;
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

	// Histiology properties
	@Column(name = "histiologyId")
	private boolean histiologyId;
	@Column(name = "histiologyDate")
	private boolean histiologyDate;
	@Column(name = "histiologyDoctorId")
	private boolean histiologyDoctorId;
	@Column(name = "histiologyAdded")
	private boolean histiologyAdded;
	@Column(name = "histiologyHistopathologyIdCom")
	private boolean histiologyHistopathologyIdCom;
	@Column(name = "histiologyClassificationIdCom")
	private boolean histiologyClassificationIdCom;
	@Column(name = "histiologyComment")
	private boolean histiologyComment;
	@Column(name = "histiologyDeleted")
	private boolean histiologyDeleted;
	@Column(name = "histiologyPatientId")
	private boolean histiologyPatientId;
	@Column(name = "histiologyAddUserId")
	private boolean histiologyAddUserId;
	@Column(name = "histiologyStatus")
	private boolean histiologyStatus;

	// InvasiveTestECOG properties
	@Column(name = "invasiveTestECOGId")
	private boolean invasiveTestECOGId;
	@Column(name = "invasiveTestECOGDate")
	private boolean invasiveTestECOGDate;
	@Column(name = "invasiveTestECOGDoctorId")
	private boolean invasiveTestECOGDoctorId;
	@Column(name = "invasiveTestECOGAdded")
	private boolean invasiveTestECOGAdded;
	@Column(name = "invasiveTestECOGIntraOperativeEcog")
	private boolean invasiveTestECOGIntraOperativeEcog;
	@Column(name = "invasiveTestECOGEcogPatternsIdCom")
	private boolean invasiveTestECOGEcogPatternsIdCom;
	@Column(name = "invasiveTestECOGEcogCover")
	private boolean invasiveTestECOGEcogCover;
	@Column(name = "invasiveTestECOGAfterResectiomEcogIdCom")
	private boolean invasiveTestECOGAfterResectiomEcogIdCom;
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
	@Column(name = "invasiveTestEEGDoctorId")
	private boolean invasiveTestEEGDoctorId;
	@Column(name = "invasiveTestEEGAdded")
	private boolean invasiveTestEEGAdded;
	@Column(name = "invasiveTestEEGInvasiveMonitoring")
	private boolean invasiveTestEEGInvasiveMonitoring;
	@Column(name = "invasiveTestEEGCoticalMappingIdCom")
	private boolean invasiveTestEEGCoticalMappingIdCom;
	@Column(name = "invasiveTestEEGLocalizationIntracranialElectrodes")
	private boolean invasiveTestEEGLocalizationIntracranialElectrodes;
	@Column(name = "invasiveTestEEGIntracranialElectrodesIdCom")
	private boolean invasiveTestEEGIntracranialElectrodesIdCom;
	@Column(name = "invasiveTestEEGInvasiveEEGSlowingIdCom")
	private boolean invasiveTestEEGInvasiveEEGSlowingIdCom;
	@Column(name = "invasiveTestEEGInvasiveEEGInterictalSpikesIdCom")
	private boolean invasiveTestEEGInvasiveEEGInterictalSpikesIdCom;
	@Column(name = "invasiveTestEEGLocalizationInvasiveEEGInterictalSpikes")
	private boolean invasiveTestEEGLocalizationInvasiveEEGInterictalSpikes;
	@Column(name = "invasiveTestEEGStatusEpilepticus")
	private boolean invasiveTestEEGStatusEpilepticus;
	@Column(name = "invasiveTestEEGInvasiveIctalEEGPatternsIdCom")
	private boolean invasiveTestEEGInvasiveIctalEEGPatternsIdCom;
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
	@Column(name = "neurologicalFindingHemisphereDominanceIdCom")
	private boolean neurologicalFindingHemisphereDominanceIdCom;
	@Column(name = "neurologicalFindingAbnormalNeurologicalFinding")
	private boolean neurologicalFindingAbnormalNeurologicalFinding;
	@Column(name = "neurologicalFindingHemiparesis")
	private boolean neurologicalFindingHemiparesis;
	@Column(name = "neurologicalFindingVisualCut")
	private boolean neurologicalFindingVisualCut;
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
	@Column(name = "neurolopsychologyId")
	private boolean neurolopsychologyId;
	@Column(name = "neurolopsychologyDate")
	private boolean neurolopsychologyDate;
	@Column(name = "neurolopsychologyDoctorId")
	private boolean neurolopsychologyDoctorId;
	@Column(name = "neurolopsychologyAdded")
	private boolean neurolopsychologyAdded;
	@Column(name = "neurolopsychologyNeuropsychologicalExamination")
	private boolean neurolopsychologyNeuropsychologicalExamination;
	@Column(name = "neurolopsychologyIntelligenceLevelIdCom")
	private boolean neurolopsychologyIntelligenceLevelIdCom;
	@Column(name = "neurolopsychologySpecificLearning")
	private boolean neurolopsychologySpecificLearning;
	@Column(name = "neurolopsychologyDevelopmentLanguageDisorders")
	private boolean neurolopsychologyDevelopmentLanguageDisorders;
	@Column(name = "neurolopsychologyAdhdSyndome")
	private boolean neurolopsychologyAdhdSyndome;
	@Column(name = "neurolopsychologyComment")
	private boolean neurolopsychologyComment;
	@Column(name = "neurolopsychologyDeleted")
	private boolean neurolopsychologyDeleted;
	@Column(name = "neurolopsychologyAddUserId")
	private boolean neurolopsychologyAddUserId;
	@Column(name = "neurolopsychologyPatientId")
	private boolean neurolopsychologyPatientId;
	@Column(name = "neurolopsychologyStatus")
	private boolean neurolopsychologyStatus;
	@Column(name = "neuropsychologyFindingDetail")
	private boolean neuropsychologyFindingDetail;

	// Operation properties
	@Column(name = "operationId")
	private boolean operationId;
	@Column(name = "operationDate")
	private boolean operationDate;
	@Column(name = "operationDoctorId")
	private boolean operationDoctorId;
	@Column(name = "operationAdded")
	private boolean operationAdded;
	@Column(name = "operationTypeOperationsIdCom")
	private boolean operationTypeOperationsIdCom;
	@Column(name = "operationRangeOpertationsIdCom")
	private boolean operationRangeOpertationsIdCom;
	@Column(name = "operationLocalizationsOperations")
	private boolean operationLocalizationsOperations;
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
	@Column(name = "outcomeEEGSpikes")
	private boolean outcomeEEGSpikes;
	@Column(name = "outcomeAEDPlanted")
	private boolean outcomeAEDPlanted;
	@Column(name = "outcomeMRIDone")
	private boolean outcomeMRIDone;
	@Column(name = "outcomeNeuroPsychology")
	private boolean outcomeNeuroPsychology;
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

	// Pharmacotherapy properties
	@Column(name = "pharmacotherapyId")
	private boolean pharmacotherapyId;
	@Column(name = "pharmacotherapyDate")
	private boolean pharmacotherapyDate;
	@Column(name = "pharmacotherapyDoctorId")
	private boolean pharmacotherapyDoctorId;
	@Column(name = "pharmacotherapyAdded")
	private boolean pharmacotherapyAdded;
	@Column(name = "pharmacotherapyAEDIdCom")
	private boolean pharmacotherapyAEDIdCom;
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
	@Column(name = "seizureSeizureFrequencyIdCom")
	private boolean seizureSeizureFrequencyIdCom;
	@Column(name = "seizureSecondarilyGeneralizedSeizure")
	private boolean seizureSecondarilyGeneralizedSeizure;
	@Column(name = "seizureStatusEpilepticus")
	private boolean seizureStatusEpilepticus;
	@Column(name = "seizureSSCClassificationIdCom")
	private boolean seizureSSCClassificationIdCom;
	@Column(name = "seizureILAEClassificationIdCom")
	private boolean seizureILAEClassificationIdCom;
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

	public boolean isHistiology() {
		return histiology;
	}

	public void setHistiology(boolean histiology) {
		this.histiology = histiology;
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

	public boolean isNeurolopsychology() {
		return neurolopsychology;
	}

	public void setNeurolopsychology(boolean neurolopsychology) {
		this.neurolopsychology = neurolopsychology;
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

	public boolean isDiagnosticTestEEGActivityIdCom() {
		return diagnosticTestEEGActivityIdCom;
	}

	public void setDiagnosticTestEEGActivityIdCom(
			boolean diagnosticTestEEGActivityIdCom) {
		this.diagnosticTestEEGActivityIdCom = diagnosticTestEEGActivityIdCom;
	}

	public boolean isDiagnosticTestEEGSlowId() {
		return diagnosticTestEEGSlowId;
	}

	public void setDiagnosticTestEEGSlowId(boolean diagnosticTestEEGSlowId) {
		this.diagnosticTestEEGSlowId = diagnosticTestEEGSlowId;
	}

	public boolean isDiagnosticTestEEGInterictalEEGSpikesComId() {
		return diagnosticTestEEGInterictalEEGSpikesComId;
	}

	public void setDiagnosticTestEEGInterictalEEGSpikesComId(
			boolean diagnosticTestEEGInterictalEEGSpikesComId) {
		this.diagnosticTestEEGInterictalEEGSpikesComId = diagnosticTestEEGInterictalEEGSpikesComId;
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

	public boolean isDiagnosticTestEEGIctalEEGPatternsIdCom() {
		return diagnosticTestEEGIctalEEGPatternsIdCom;
	}

	public void setDiagnosticTestEEGIctalEEGPatternsIdCom(
			boolean diagnosticTestEEGIctalEEGPatternsIdCom) {
		this.diagnosticTestEEGIctalEEGPatternsIdCom = diagnosticTestEEGIctalEEGPatternsIdCom;
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

	public boolean isDiagnosticTestMRIProtocolIdCom() {
		return diagnosticTestMRIProtocolIdCom;
	}

	public void setDiagnosticTestMRIProtocolIdCom(
			boolean diagnosticTestMRIProtocolIdCom) {
		this.diagnosticTestMRIProtocolIdCom = diagnosticTestMRIProtocolIdCom;
	}

	public boolean isDiagnosticTestMRIFindingIdCom() {
		return diagnosticTestMRIFindingIdCom;
	}

	public void setDiagnosticTestMRIFindingIdCom(
			boolean diagnosticTestMRIFindingIdCom) {
		this.diagnosticTestMRIFindingIdCom = diagnosticTestMRIFindingIdCom;
	}

	public boolean isDiagnosticTestMRIFdgPetIdCom() {
		return diagnosticTestMRIFdgPetIdCom;
	}

	public void setDiagnosticTestMRIFdgPetIdCom(
			boolean diagnosticTestMRIFdgPetIdCom) {
		this.diagnosticTestMRIFdgPetIdCom = diagnosticTestMRIFdgPetIdCom;
	}

	public boolean isDiagnosticTestMRIInterictalSpectIdCom() {
		return diagnosticTestMRIInterictalSpectIdCom;
	}

	public void setDiagnosticTestMRIInterictalSpectIdCom(
			boolean diagnosticTestMRIInterictalSpectIdCom) {
		this.diagnosticTestMRIInterictalSpectIdCom = diagnosticTestMRIInterictalSpectIdCom;
	}

	public boolean isDiagnosticTestMRIIntaliSpectIdCom() {
		return diagnosticTestMRIIntaliSpectIdCom;
	}

	public void setDiagnosticTestMRIIntaliSpectIdCom(
			boolean diagnosticTestMRIIntaliSpectIdCom) {
		this.diagnosticTestMRIIntaliSpectIdCom = diagnosticTestMRIIntaliSpectIdCom;
	}

	public boolean isDiagnosticTestMRISiscom() {
		return diagnosticTestMRISiscom;
	}

	public void setDiagnosticTestMRISiscom(boolean diagnosticTestMRISiscom) {
		this.diagnosticTestMRISiscom = diagnosticTestMRISiscom;
	}

	public boolean isDiagnosticTestMRITimeAplicationRn() {
		return diagnosticTestMRITimeAplicationRn;
	}

	public void setDiagnosticTestMRITimeAplicationRn(
			boolean diagnosticTestMRITimeAplicationRn) {
		this.diagnosticTestMRITimeAplicationRn = diagnosticTestMRITimeAplicationRn;
	}

	public boolean isDiagnosticTestMRITimingAplicationRnIdCom() {
		return diagnosticTestMRITimingAplicationRnIdCom;
	}

	public void setDiagnosticTestMRITimingAplicationRnIdCom(
			boolean diagnosticTestMRITimingAplicationRnIdCom) {
		this.diagnosticTestMRITimingAplicationRnIdCom = diagnosticTestMRITimingAplicationRnIdCom;
	}

	public boolean isDiagnosticTestMRIMrsProtocolIdCom() {
		return diagnosticTestMRIMrsProtocolIdCom;
	}

	public void setDiagnosticTestMRIMrsProtocolIdCom(
			boolean diagnosticTestMRIMrsProtocolIdCom) {
		this.diagnosticTestMRIMrsProtocolIdCom = diagnosticTestMRIMrsProtocolIdCom;
	}

	public boolean isDiagnosticTestMRIMrsFindingIdCom() {
		return diagnosticTestMRIMrsFindingIdCom;
	}

	public void setDiagnosticTestMRIMrsFindingIdCom(
			boolean diagnosticTestMRIMrsFindingIdCom) {
		this.diagnosticTestMRIMrsFindingIdCom = diagnosticTestMRIMrsFindingIdCom;
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

	public boolean isHistiologyId() {
		return histiologyId;
	}

	public void setHistiologyId(boolean histiologyId) {
		this.histiologyId = histiologyId;
	}

	public boolean isHistiologyDate() {
		return histiologyDate;
	}

	public void setHistiologyDate(boolean histiologyDate) {
		this.histiologyDate = histiologyDate;
	}

	public boolean isHistiologyDoctorId() {
		return histiologyDoctorId;
	}

	public void setHistiologyDoctorId(boolean histiologyDoctorId) {
		this.histiologyDoctorId = histiologyDoctorId;
	}

	public boolean isHistiologyAdded() {
		return histiologyAdded;
	}

	public void setHistiologyAdded(boolean histiologyAdded) {
		this.histiologyAdded = histiologyAdded;
	}

	public boolean isHistiologyHistopathologyIdCom() {
		return histiologyHistopathologyIdCom;
	}

	public void setHistiologyHistopathologyIdCom(
			boolean histiologyHistopathologyIdCom) {
		this.histiologyHistopathologyIdCom = histiologyHistopathologyIdCom;
	}

	public boolean isHistiologyClassificationIdCom() {
		return histiologyClassificationIdCom;
	}

	public void setHistiologyClassificationIdCom(
			boolean histiologyClassificationIdCom) {
		this.histiologyClassificationIdCom = histiologyClassificationIdCom;
	}

	public boolean isHistiologyComment() {
		return histiologyComment;
	}

	public void setHistiologyComment(boolean histiologyComment) {
		this.histiologyComment = histiologyComment;
	}

	public boolean isHistiologyDeleted() {
		return histiologyDeleted;
	}

	public void setHistiologyDeleted(boolean histiologyDeleted) {
		this.histiologyDeleted = histiologyDeleted;
	}

	public boolean isHistiologyPatientId() {
		return histiologyPatientId;
	}

	public void setHistiologyPatientId(boolean histiologyPatientId) {
		this.histiologyPatientId = histiologyPatientId;
	}

	public boolean isHistiologyAddUserId() {
		return histiologyAddUserId;
	}

	public void setHistiologyAddUserId(boolean histiologyAddUserId) {
		this.histiologyAddUserId = histiologyAddUserId;
	}

	public boolean isHistiologyStatus() {
		return histiologyStatus;
	}

	public void setHistiologyStatus(boolean histiologyStatus) {
		this.histiologyStatus = histiologyStatus;
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

	public boolean isInvasiveTestECOGEcogPatternsIdCom() {
		return invasiveTestECOGEcogPatternsIdCom;
	}

	public void setInvasiveTestECOGEcogPatternsIdCom(
			boolean invasiveTestECOGEcogPatternsIdCom) {
		this.invasiveTestECOGEcogPatternsIdCom = invasiveTestECOGEcogPatternsIdCom;
	}

	public boolean isInvasiveTestECOGEcogCover() {
		return invasiveTestECOGEcogCover;
	}

	public void setInvasiveTestECOGEcogCover(boolean invasiveTestECOGEcogCover) {
		this.invasiveTestECOGEcogCover = invasiveTestECOGEcogCover;
	}

	public boolean isInvasiveTestECOGAfterResectiomEcogIdCom() {
		return invasiveTestECOGAfterResectiomEcogIdCom;
	}

	public void setInvasiveTestECOGAfterResectiomEcogIdCom(
			boolean invasiveTestECOGAfterResectiomEcogIdCom) {
		this.invasiveTestECOGAfterResectiomEcogIdCom = invasiveTestECOGAfterResectiomEcogIdCom;
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

	public boolean isInvasiveTestEEGCoticalMappingIdCom() {
		return invasiveTestEEGCoticalMappingIdCom;
	}

	public void setInvasiveTestEEGCoticalMappingIdCom(
			boolean invasiveTestEEGCoticalMappingIdCom) {
		this.invasiveTestEEGCoticalMappingIdCom = invasiveTestEEGCoticalMappingIdCom;
	}

	public boolean isInvasiveTestEEGLocalizationIntracranialElectrodes() {
		return invasiveTestEEGLocalizationIntracranialElectrodes;
	}

	public void setInvasiveTestEEGLocalizationIntracranialElectrodes(
			boolean invasiveTestEEGLocalizationIntracranialElectrodes) {
		this.invasiveTestEEGLocalizationIntracranialElectrodes = invasiveTestEEGLocalizationIntracranialElectrodes;
	}

	public boolean isInvasiveTestEEGIntracranialElectrodesIdCom() {
		return invasiveTestEEGIntracranialElectrodesIdCom;
	}

	public void setInvasiveTestEEGIntracranialElectrodesIdCom(
			boolean invasiveTestEEGIntracranialElectrodesIdCom) {
		this.invasiveTestEEGIntracranialElectrodesIdCom = invasiveTestEEGIntracranialElectrodesIdCom;
	}

	public boolean isInvasiveTestEEGInvasiveEEGSlowingIdCom() {
		return invasiveTestEEGInvasiveEEGSlowingIdCom;
	}

	public void setInvasiveTestEEGInvasiveEEGSlowingIdCom(
			boolean invasiveTestEEGInvasiveEEGSlowingIdCom) {
		this.invasiveTestEEGInvasiveEEGSlowingIdCom = invasiveTestEEGInvasiveEEGSlowingIdCom;
	}

	public boolean isInvasiveTestEEGInvasiveEEGInterictalSpikesIdCom() {
		return invasiveTestEEGInvasiveEEGInterictalSpikesIdCom;
	}

	public void setInvasiveTestEEGInvasiveEEGInterictalSpikesIdCom(
			boolean invasiveTestEEGInvasiveEEGInterictalSpikesIdCom) {
		this.invasiveTestEEGInvasiveEEGInterictalSpikesIdCom = invasiveTestEEGInvasiveEEGInterictalSpikesIdCom;
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

	public boolean isInvasiveTestEEGInvasiveIctalEEGPatternsIdCom() {
		return invasiveTestEEGInvasiveIctalEEGPatternsIdCom;
	}

	public void setInvasiveTestEEGInvasiveIctalEEGPatternsIdCom(
			boolean invasiveTestEEGInvasiveIctalEEGPatternsIdCom) {
		this.invasiveTestEEGInvasiveIctalEEGPatternsIdCom = invasiveTestEEGInvasiveIctalEEGPatternsIdCom;
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

	public boolean isNeurologicalFindingHemisphereDominanceIdCom() {
		return neurologicalFindingHemisphereDominanceIdCom;
	}

	public void setNeurologicalFindingHemisphereDominanceIdCom(
			boolean neurologicalFindingHemisphereDominanceIdCom) {
		this.neurologicalFindingHemisphereDominanceIdCom = neurologicalFindingHemisphereDominanceIdCom;
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

	public boolean isNeurologicalFindingVisualCut() {
		return neurologicalFindingVisualCut;
	}

	public void setNeurologicalFindingVisualCut(
			boolean neurologicalFindingVisualCut) {
		this.neurologicalFindingVisualCut = neurologicalFindingVisualCut;
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

	public boolean isNeurolopsychologyId() {
		return neurolopsychologyId;
	}

	public void setNeurolopsychologyId(boolean neurolopsychologyId) {
		this.neurolopsychologyId = neurolopsychologyId;
	}

	public boolean isNeurolopsychologyDate() {
		return neurolopsychologyDate;
	}

	public void setNeurolopsychologyDate(boolean neurolopsychologyDate) {
		this.neurolopsychologyDate = neurolopsychologyDate;
	}

	public boolean isNeurolopsychologyDoctorId() {
		return neurolopsychologyDoctorId;
	}

	public void setNeurolopsychologyDoctorId(boolean neurolopsychologyDoctorId) {
		this.neurolopsychologyDoctorId = neurolopsychologyDoctorId;
	}

	public boolean isNeurolopsychologyAdded() {
		return neurolopsychologyAdded;
	}

	public void setNeurolopsychologyAdded(boolean neurolopsychologyAdded) {
		this.neurolopsychologyAdded = neurolopsychologyAdded;
	}

	public boolean isNeurolopsychologyNeuropsychologicalExamination() {
		return neurolopsychologyNeuropsychologicalExamination;
	}

	public void setNeurolopsychologyNeuropsychologicalExamination(
			boolean neurolopsychologyNeuropsychologicalExamination) {
		this.neurolopsychologyNeuropsychologicalExamination = neurolopsychologyNeuropsychologicalExamination;
	}

	public boolean isNeurolopsychologyIntelligenceLevelIdCom() {
		return neurolopsychologyIntelligenceLevelIdCom;
	}

	public void setNeurolopsychologyIntelligenceLevelIdCom(
			boolean neurolopsychologyIntelligenceLevelIdCom) {
		this.neurolopsychologyIntelligenceLevelIdCom = neurolopsychologyIntelligenceLevelIdCom;
	}

	public boolean isNeurolopsychologySpecificLearning() {
		return neurolopsychologySpecificLearning;
	}

	public void setNeurolopsychologySpecificLearning(
			boolean neurolopsychologySpecificLearning) {
		this.neurolopsychologySpecificLearning = neurolopsychologySpecificLearning;
	}

	public boolean isNeurolopsychologyDevelopmentLanguageDisorders() {
		return neurolopsychologyDevelopmentLanguageDisorders;
	}

	public void setNeurolopsychologyDevelopmentLanguageDisorders(
			boolean neurolopsychologyDevelopmentLanguageDisorders) {
		this.neurolopsychologyDevelopmentLanguageDisorders = neurolopsychologyDevelopmentLanguageDisorders;
	}

	public boolean isNeurolopsychologyAdhdSyndome() {
		return neurolopsychologyAdhdSyndome;
	}

	public void setNeurolopsychologyAdhdSyndome(
			boolean neurolopsychologyAdhdSyndome) {
		this.neurolopsychologyAdhdSyndome = neurolopsychologyAdhdSyndome;
	}

	public boolean isNeurolopsychologyComment() {
		return neurolopsychologyComment;
	}

	public void setNeurolopsychologyComment(boolean neurolopsychologyComment) {
		this.neurolopsychologyComment = neurolopsychologyComment;
	}

	public boolean isNeurolopsychologyDeleted() {
		return neurolopsychologyDeleted;
	}

	public void setNeurolopsychologyDeleted(boolean neurolopsychologyDeleted) {
		this.neurolopsychologyDeleted = neurolopsychologyDeleted;
	}

	public boolean isNeurolopsychologyAddUserId() {
		return neurolopsychologyAddUserId;
	}

	public void setNeurolopsychologyAddUserId(boolean neurolopsychologyAddUserId) {
		this.neurolopsychologyAddUserId = neurolopsychologyAddUserId;
	}

	public boolean isNeurolopsychologyPatientId() {
		return neurolopsychologyPatientId;
	}

	public void setNeurolopsychologyPatientId(boolean neurolopsychologyPatientId) {
		this.neurolopsychologyPatientId = neurolopsychologyPatientId;
	}

	public boolean isNeurolopsychologyStatus() {
		return neurolopsychologyStatus;
	}

	public void setNeurolopsychologyStatus(boolean neurolopsychologyStatus) {
		this.neurolopsychologyStatus = neurolopsychologyStatus;
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

	public boolean isOperationTypeOperationsIdCom() {
		return operationTypeOperationsIdCom;
	}

	public void setOperationTypeOperationsIdCom(
			boolean operationTypeOperationsIdCom) {
		this.operationTypeOperationsIdCom = operationTypeOperationsIdCom;
	}

	public boolean isOperationRangeOpertationsIdCom() {
		return operationRangeOpertationsIdCom;
	}

	public void setOperationRangeOpertationsIdCom(
			boolean operationRangeOpertationsIdCom) {
		this.operationRangeOpertationsIdCom = operationRangeOpertationsIdCom;
	}

	public boolean isOperationLocalizationsOperations() {
		return operationLocalizationsOperations;
	}

	public void setOperationLocalizationsOperations(
			boolean operationLocalizationsOperations) {
		this.operationLocalizationsOperations = operationLocalizationsOperations;
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

	public boolean isOutcomeEEGSpikes() {
		return outcomeEEGSpikes;
	}

	public void setOutcomeEEGSpikes(boolean outcomeEEGSpikes) {
		this.outcomeEEGSpikes = outcomeEEGSpikes;
	}

	public boolean isOutcomeAEDPlanted() {
		return outcomeAEDPlanted;
	}

	public void setOutcomeAEDPlanted(boolean outcomeAEDPlanted) {
		this.outcomeAEDPlanted = outcomeAEDPlanted;
	}

	public boolean isOutcomeMRIDone() {
		return outcomeMRIDone;
	}

	public void setOutcomeMRIDone(boolean outcomeMRIDone) {
		this.outcomeMRIDone = outcomeMRIDone;
	}

	public boolean isOutcomeNeuroPsychology() {
		return outcomeNeuroPsychology;
	}

	public void setOutcomeNeuroPsychology(boolean outcomeNeuroPsychology) {
		this.outcomeNeuroPsychology = outcomeNeuroPsychology;
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

	public boolean isPharmacotherapyAEDIdCom() {
		return pharmacotherapyAEDIdCom;
	}

	public void setPharmacotherapyAEDIdCom(boolean pharmacotherapyAEDIdCom) {
		this.pharmacotherapyAEDIdCom = pharmacotherapyAEDIdCom;
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

	public boolean isSeizureSeizureFrequencyIdCom() {
		return seizureSeizureFrequencyIdCom;
	}

	public void setSeizureSeizureFrequencyIdCom(
			boolean seizureSeizureFrequencyIdCom) {
		this.seizureSeizureFrequencyIdCom = seizureSeizureFrequencyIdCom;
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

	public boolean isSeizureSSCClassificationIdCom() {
		return seizureSSCClassificationIdCom;
	}

	public void setSeizureSSCClassificationIdCom(
			boolean seizureSSCClassificationIdCom) {
		this.seizureSSCClassificationIdCom = seizureSSCClassificationIdCom;
	}

	public boolean isSeizureILAEClassificationIdCom() {
		return seizureILAEClassificationIdCom;
	}

	public void setSeizureILAEClassificationIdCom(
			boolean seizureILAEClassificationIdCom) {
		this.seizureILAEClassificationIdCom = seizureILAEClassificationIdCom;
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
}

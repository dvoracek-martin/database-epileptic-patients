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
	
	@Column(name="name")
	private String name;
	
	@Column(name="params")
	private String params;
	
	@Column(name="user_id")
	private int userID;
	
	@Column(name="is_generic")
	private boolean isGeneric;
	/*
	 * TODO - add column annotation
	 
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
		@Column(name = "diagnosticTestMRITimingiAplicationRnIdCom")
		private boolean diagnosticTestMRITimingiAplicationRnIdCom ??? preklep ???
		@Column(name = "diagnosticTestMRIMrsProtocolIdCom")
		private boolean diagnosticTestMRIMrsProtocolIdCom;
		@Column(name = "diagnosticTestMRIMrsFindingIdCom")
		private boolean diagnosticTestMRIMrsFindingIdCom;
		@Column(name = "diagnosticTestMRIDti")
		private boolean diagnosticTestMRIDti;
		@Column(name = "diagnosticTestMRIDtiDetailStuide")
		private boolean diagnosticTestMRIDtiDetailStuide; ??? neni anglicky ???
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
		@Column(name = "diagnosticTestMRILocalizationPetHypometabolismu")
		private boolean diagnosticTestMRILocalizationPetHypometabolismu ???  neni anglicky ???
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
		@Column(name = "operationKalostomie")
		private boolean operationKalostomie ??? neni anglicky ???
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
		*/

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

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
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
}

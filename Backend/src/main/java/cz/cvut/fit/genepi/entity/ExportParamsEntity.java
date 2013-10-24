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
		private boolean patientId;
		private boolean patientNin;
		private boolean patientBirthday;
		private boolean patientGender;
		private boolean patientDoctorId;
		private boolean patientDeleted;
		private boolean patientChecked;
		private boolean patientContactId;


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
		private boolean complicationIdCom;
		private boolean complicationComment;
		private boolean complicationDeleted;
		private boolean complicationPatientId;
		private boolean complicationAddUserId;
		private boolean complicationStatus;
		
		// DiagnosticTestEEG properties
		private boolean diagnosticTestEEGId;
		private boolean diagnosticTestEEGDate;
		private boolean diagnosticTestEEGDoctorId;
		private boolean diagnosticTestEEGAdded;
		private boolean diagnosticTestEEGActivityIdCom;
		private boolean diagnosticTestEEGSlowId;
		private boolean diagnosticTestEEGInterictalEEGSpikesComId;
		private boolean diagnosticTestEEGLocalizationInerictalEEGSpikes;
		private boolean diagnosticTestEEGStatusEpilepticus;
		private boolean diagnosticTestEEGSecondarySidedSynchrony;
		private boolean diagnosticTestEEGIctalEEGPatternsIdCom;
		private boolean diagnosticTestEEGLocalizationIctalEEGPattern;
		private boolean diagnosticTestEEGComment;
		private boolean diagnosticTestEEGDeleted;
		private boolean diagnosticTestEEGAddUserId;
		private boolean diagnosticTestEEGPatientId;
		private boolean diagnosticTestEEGStatus;
		
		// DiagnosticTestMRI properties
		private boolean diagnosticTestMRIId;
		private boolean diagnosticTestMRIate;
		private boolean diagnosticTestMRIDoctorId;
		private boolean diagnosticTestMRIAdded;
		private boolean diagnosticTestMRIProtocolIdCom;
		private boolean diagnosticTestMRIFindingIdCom;
		private boolean diagnosticTestMRIFdgPetIdCom;
		private boolean diagnosticTestMRIInterictalSpectIdCom;
		private boolean diagnosticTestMRIIntaliSpectIdCom;
		private boolean diagnosticTestMRISiscom;
		private boolean diagnosticTestMRITimeAplicationRn;
		private boolean diagnosticTestMRITimingiAplicationRnIdCom ??? preklep ???
		private boolean diagnosticTestMRIMrsProtocolIdCom;
		private boolean diagnosticTestMRIMrsFindingIdCom;
		private boolean diagnosticTestMRIDti;
		private boolean diagnosticTestMRIDtiDetailStuide; ??? neni anglicky ???
		private boolean diagnosticTestMRIFmri;
		private boolean diagnosticTestMRIDetailsFmri;
		private boolean diagnosticTestMRIWada;
		private boolean diagnosticTestMRIDetailsWada;
		private boolean diagnosticTestMRIDescribe;
		private boolean diagnosticTestMRILocalizationSpecHypoperfuse;
		private boolean diagnosticTestMRILocalizationMrsAbnormality;
		private boolean diagnosticTestMRILocalizationPetHypometabolismu ???  neni anglicky ???
		private boolean diagnosticTestMRILocalizationSpecHyperperfuse;
		private boolean diagnosticTestMRIFmriProtocols;
		private boolean diagnosticTestMRIComment;
		private boolean diagnosticTestMRIDeleted;
		private boolean diagnosticTestMRIPatientId;
		private boolean diagnosticTestMRIAddUserId;
		private boolean diagnosticTestMRIStatus;
		
		// Histiology properties
		private boolean histiologyId;
		private boolean histiologyDate;
		private boolean histiologyDoctorId;
		private boolean histiologyAdded;
		private boolean histiologyHistopathologyIdCom;
		private boolean histiologyClassificationIdCom;
		private boolean histiologyComment;
		private boolean histiologyDeleted;
		private boolean histiologyPatientId;
		private boolean histiologyAddUserId;
		private boolean histiologyStatus;
		
		// InvasiveTestECOG properties
		private boolean invasiveTestECOGId;
		private boolean invasiveTestECOGDate;
		private boolean invasiveTestECOGDoctorId;
		private boolean invasiveTestECOGAdded;
		private boolean invasiveTestECOGIntraOperativeEcog;
		private boolean invasiveTestECOGEcogPatternsIdCom;
		private boolean invasiveTestECOGEcogCover;
		private boolean invasiveTestECOGAfterResectiomEcogIdCom;
		private boolean invasiveTestECOGAwakeCraniotomy;
		private boolean invasiveTestECOGComment;
		private boolean invasiveTestECOGDeleted;
		private boolean invasiveTestECOGAddUserId;
		private boolean invasiveTestECOGPatientId;
		private boolean invasiveTestECOGStatus;
		
		// InvasiveTestEEG properties
		private boolean invasiveTestEEGId;
		private boolean invasiveTestEEGDate;
		private boolean invasiveTestEEGDoctorId;
		private boolean invasiveTestEEGAdded;
		private boolean invasiveTestEEGInvasiveMonitoring;
		private boolean invasiveTestEEGCoticalMappingIdCom;
		private boolean invasiveTestEEGLocalizationIntracranialElectrodes;
		private boolean invasiveTestEEGIntracranialElectrodesIdCom;
		private boolean invasiveTestEEGInvasiveEEGSlowingIdCom;
		private boolean invasiveTestEEGInvasiveEEGInterictalSpikesIdCom;
		private boolean invasiveTestEEGLocalizationInvasiveEEGInterictalSpikes;
		private boolean invasiveTestEEGStatusEpilepticus;
		private boolean invasiveTestEEGInvasiveIctalEEGPatternsIdCom;
		private boolean invasiveTestEEGLocalizationIctalEEGPatterns;
		private boolean invasiveTestEEGComment;
		private boolean invasiveTestEEGDeleted;
		private boolean invasiveTestEEGAddUserId;
		private boolean invasiveTestEEGPatientId;
		private boolean invasiveTestEEGStatus;
		
		// Neurological finding property
		private boolean neurologicalFindingId;
		private boolean neurologicalFindingDate;
		private boolean neurologicalFindingDoctorId;
		private boolean neurologicalFindingAdded;
		private boolean neurologicalFindingHemisphereDominanceIdCom;
		private boolean neurologicalFindingAbnormalNeurologicalFinding;
		private boolean neurologicalFindingHemiparesis;
		private boolean neurologicalFindingVisualCut;
		private boolean neurologicalFindingComment;
		private boolean neurologicalFindingDeleted;
		private boolean neurologicalFindingAddUserId;
		private boolean neurologicalFindingPatientId;
		private boolean neurologicalFindingStatus;
		
		// Neuropsychology properties
		private boolean neurolopsychologyId;
		private boolean neurolopsychologyDate;
		private boolean neurolopsychologyDoctorId;
		private boolean neurolopsychologyAdded;
		private boolean neurolopsychologyNeuropsychologicalExamination;
		private boolean neurolopsychologyIntelligenceLevelIdCom;
		private boolean neurolopsychologySpecificLearning;
		private boolean neurolopsychologyDevelopmentLanguageDisorders;
		private boolean neurolopsychologyAdhdSyndome;
		private boolean neurolopsychologyComment;
		private boolean neurolopsychologyDeleted;
		private boolean neurolopsychologyAddUserId;
		private boolean neurolopsychologyPatientId;
		private boolean neurolopsychologyStatus;
		
		// Operation properties
		private boolean operationId;
		private boolean operationDate;
		private boolean operationDoctorId;
		private boolean operationAdded;
		private boolean operationTypeOperationsIdCom;
		private boolean operationRangeOpertationsIdCom;
		private boolean operationLocalizationsOperations;
		private boolean operationMst;
		private boolean operationKalostomie ??? neni anglicky ???
		private boolean operationVNS;
		private boolean operationVNsImplantationDate;
		private boolean operationOperationDetails;
		private boolean operationCompleteResection;
		private boolean operationComment;
		private boolean operationDeleted;
		private boolean operationAddUserId;
		private boolean operationPatientId;
		private boolean operationStatus;
		
		// Outcome properties
		private boolean outcomeId;
		private boolean outcomeDate;
		private boolean outcomeDoctorId;
		private boolean outcomeAdded;
		private boolean outcomeFinallySeizuresIdCom;
		private boolean outcomeEEGSpikes;
		private boolean outcomeAEDPlanted;
		private boolean outcomeMRIDone;
		private boolean outcomeNeuroPsychology;
		private boolean outcomeComment;
		private boolean outcomeDeleted;
		private boolean outcomeAddUserId;
		private boolean outcomePatientId;
		private boolean outcomeStatus;
		
		// Pharmacotherapy properties
		private boolean pharmacotherapyId;
		private boolean pharmacotherapyDate;
		private boolean pharmacotherapyDoctorId;
		private boolean pharmacotherapyAdded;
		private boolean pharmacotherapyAEDIdCom;
		private boolean pharmacotherapyEffective;
		private boolean pharmacotherapyDuringSurgery;
		private boolean pharmacotherapyComment;
		private boolean pharmacotherapyDeleted;
		private boolean pharmacotherapyAddUserId;
		private boolean pharmacotherapyPatientId;
		private boolean pharmacotherapyStatus;
		
		// Seizure properties
		private boolean seizureId;
		private boolean seizureDate;
		private boolean seizureDoctorId;
		private boolean seizureAdded;
		private boolean seizureSeizureFrequencyIdCom;
		private boolean seizureSecondarilyGeneralizedSeizure;
		private boolean seizureStatusEpilepticus;
		private boolean seizureSSCClassificationIdCom;
		private boolean seizureILAEClassificationIdCom;
		private boolean seizureSeizuresWhileAwakeEpi;
		private boolean seizureSeizuresWhileAwakeLatent;
		private boolean seizureSeizuresWhileAwakeNonEpi;
		private boolean seizureSeizuresWhileSleepEpi;
		private boolean seizureSeizuresWhileSleepLatent;
		private boolean seizureSeizuresWhileSleepNonEpi;
		private boolean seizureComment;
		private boolean seizureDeleted;
		private boolean seizureAddUserId;
		private boolean seizurePatientId;
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

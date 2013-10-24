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

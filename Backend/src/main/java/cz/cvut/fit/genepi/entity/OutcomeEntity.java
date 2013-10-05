package cz.cvut.fit.genepi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "OUTCOME")
public class OutcomeEntity {
	@Id
	@Column(name = "ID", precision = 6, scale = 0, nullable = false)
	@GeneratedValue
	private int id;

	/** The date. */
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past
	@NotNull
	@Column(name = "DATE", nullable = false)
	private Date date;

	/** The doctor id. */
	@Column(name = "DOCTOR_ID", length = 6, nullable = true)
	private int doctorId;

	/** The added. */
	@Column(name = "ADDED", nullable = false, insertable = false)
	private Date added;
	
	@Column(name="finally_seizures_idcom")
	private int finallySeizuresIdcom;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="eeg_spikes")
	private Boolean eegSpikes;
	
	@Column(name="aed planted")
	private Boolean aedPlanted;
	
	@Column(name="mri_done")
	private Boolean mriDone;
	
	@Column(name="neuropsychology")
	private Boolean neuropsychology;
	
	@Column(name="deleted")
	private Boolean deleted;
		
	/** The add user id. */
	@NotNull
	@Column(name = "ADD_USER_ID", precision = 6, scale = 0, nullable = false)
	private int addUserId;

	/*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public int getFinallySeizuresIdcom() {
		return finallySeizuresIdcom;
	}

	public void setFinallySeizuresIdcom(int finallySeizuresIdcom) {
		this.finallySeizuresIdcom = finallySeizuresIdcom;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Boolean getEegSpikes() {
		return eegSpikes;
	}

	public void setEegSpikes(Boolean eegSpikes) {
		this.eegSpikes = eegSpikes;
	}

	public Boolean getAedPlanted() {
		return aedPlanted;
	}

	public void setAedPlanted(Boolean aedPlanted) {
		this.aedPlanted = aedPlanted;
	}

	public Boolean getMriDone() {
		return mriDone;
	}

	public void setMriDone(Boolean mriDone) {
		this.mriDone = mriDone;
	}

	public Boolean getNeuropsychology() {
		return neuropsychology;
	}

	public void setNeuropsychology(Boolean neuropsychology) {
		this.neuropsychology = neuropsychology;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public int getAddUserId() {
		return addUserId;
	}

	public void setAddUserId(int addUserId) {
		this.addUserId = addUserId;
	}

	/*public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}*/
	
	
}

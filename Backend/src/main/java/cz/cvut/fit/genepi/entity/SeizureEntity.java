package cz.cvut.fit.genepi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SEIZURE")
public class SeizureEntity {

	@Id
	@Column(name = "ID", precision = 6, scale = 0, nullable = false)
	@GeneratedValue
	private int id;

	@Column(name = "DATE", length = 7, nullable = false)
	private Date date;

	@Column(name = "DOCTOR_ID", length = 6, nullable = true)
	private int doctorId;

	@Column(name = "ADDED", length = 7, nullable = false)
	private Date added;

	@Column(name = "seizure_frequency_idcom")
	private int seizureFrequencyIdcom;

	@Column(name = "secondarily_generalized_seizure")
	private int secondarilyGeneralizedSeizure;

	@Column(name = "status_epilepticus")
	private int statusEpilepticus;

	@Column(name = "ssc_classification_idcom")
	private int sscClassificationIdcom;

	@Column(name = "ilae_classification_idcom")
	private int ilaeClassificationIdcom;

	@Column(name = "seizures_while_awake_epi")
	private int seizuresWhileAwakeEpi;

	@Column(name = "seizures_while_awake_latent")
	private int seizuresWhileAwakeLatent;

	@Column(name = "seizures_while_awake_non_epi")
	private int seizuresWhileAwakeNonEpi;	

	@Column(name = "seizures_while_sleep_epi")
	private int seizuresWhileSleepEpi;

	@Column(name = "seizures_while_sleep_latent")
	private int seizuresWhileSleepLatent;

	@Column(name = "seizures_while_sleep_non_epi")
	private int seizuresWhileSleepNonEpi;

	@Column(name = "comment")
	private String comment;

	@Column(name = "deleted")
	private int deleted;

	@Column(name = "patient_id")
	private int patientId;

	@Column(name = "add_user_id")
	private int addUserId;

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

	public int getSeizureFrequencyIdcom() {
		return seizureFrequencyIdcom;
	}

	public void setSeizureFrequencyIdcom(int seizureFrequencyIdcom) {
		this.seizureFrequencyIdcom = seizureFrequencyIdcom;
	}

	public int getSecondarilyGeneralizedSeizure() {
		return secondarilyGeneralizedSeizure;
	}

	public void setSecondarilyGeneralizedSeizure(int secondarilyGeneralizedSeizure) {
		this.secondarilyGeneralizedSeizure = secondarilyGeneralizedSeizure;
	}

	public int getStatusEpilepticus() {
		return statusEpilepticus;
	}

	public void setStatusEpilepticus(int statusEpilepticus) {
		this.statusEpilepticus = statusEpilepticus;
	}

	public int getSscClassificationIdcom() {
		return sscClassificationIdcom;
	}

	public void setSscClassificationIdcom(int sscClassificationIdcom) {
		this.sscClassificationIdcom = sscClassificationIdcom;
	}

	public int getIlaeClassificationIdcom() {
		return ilaeClassificationIdcom;
	}

	public void setIlaeClassificationIdcom(int ilaeClassificationIdcom) {
		this.ilaeClassificationIdcom = ilaeClassificationIdcom;
	}

	public int getSeizuresWhileAwakeEpi() {
		return seizuresWhileAwakeEpi;
	}

	public void setSeizuresWhileAwakeEpi(int seizuresWhileAwakeEpi) {
		this.seizuresWhileAwakeEpi = seizuresWhileAwakeEpi;
	}

	public int getSeizuresWhileAwakeLatent() {
		return seizuresWhileAwakeLatent;
	}

	public void setSeizuresWhileAwakeLatent(int seizuresWhileAwakeLatent) {
		this.seizuresWhileAwakeLatent = seizuresWhileAwakeLatent;
	}

	public int getSeizuresWhileAwakeNonEpi() {
		return seizuresWhileAwakeNonEpi;
	}

	public void setSeizuresWhileAwakeNonEpi(int seizuresWhileAwakeNonEpi) {
		this.seizuresWhileAwakeNonEpi = seizuresWhileAwakeNonEpi;
	}

	public int getSeizuresWhileSleepEpi() {
		return seizuresWhileSleepEpi;
	}

	public void setSeizuresWhileSleepEpi(int seizuresWhileSleepEpi) {
		this.seizuresWhileSleepEpi = seizuresWhileSleepEpi;
	}

	public int getSeizuresWhileSleepLatent() {
		return seizuresWhileSleepLatent;
	}

	public void setSeizuresWhileSleepLatent(int seizuresWhileSleepLatent) {
		this.seizuresWhileSleepLatent = seizuresWhileSleepLatent;
	}

	public int getSeizuresWhileSleepNonEpi() {
		return seizuresWhileSleepNonEpi;
	}

	public void setSeizuresWhileSleepNonEpi(int seizuresWhileSleepNonEpi) {
		this.seizuresWhileSleepNonEpi = seizuresWhileSleepNonEpi;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getAddUserId() {
		return addUserId;
	}

	public void setAddUserId(int addUserId) {
		this.addUserId = addUserId;
	}

	
}

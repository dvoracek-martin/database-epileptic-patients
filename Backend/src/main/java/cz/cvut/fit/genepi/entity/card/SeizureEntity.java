package cz.cvut.fit.genepi.entity.card;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cz.cvut.fit.genepi.entity.PatientEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class SeizureEntity.
 */
@Entity
@Table(name = "SEIZURE")
public class SeizureEntity implements Comparable<SeizureEntity>{

	/** The id. */
	@Id
	@Column(name = "ID", precision = 6, scale = 0, nullable = false)
	@GeneratedValue
	private int id;

	/** The date. */
	@Column(name = "DATE", length = 7, nullable = false)
	private Date date;

	/** The doctor id. */
	@Column(name = "DOCTOR_ID", length = 6, nullable = true)
	private int doctorId;

	/** The added. */
	@Column(name = "ADDED", length = 7, nullable = false)
	private Date added;

	/** The seizure frequency idcom. */
	@Column(name = "seizure_frequency_idcom")
	private int seizureFrequencyIdcom;

	/** The secondarily generalized seizure. */
	@Column(name = "secondarily_generalized_seizure")
	private int secondarilyGeneralizedSeizure;

	/** The status epilepticus. */
	@Column(name = "status_epilepticus")
	private boolean statusEpilepticus;

	/** The ssc classification idcom. */
	@Column(name = "ssc_classification_idcom")
	private int sscClassificationIdcom;

	/** The ilae classification idcom. */
	@Column(name = "ilae_classification_idcom")
	private int ilaeClassificationIdcom;

	/** The seizures while awake epi. */
	@Column(name = "seizures_while_awake_epi")
	private int seizuresWhileAwakeEpi;

	/** The seizures while awake latent. */
	@Column(name = "seizures_while_awake_latent")
	private int seizuresWhileAwakeLatent;

	/** The seizures while awake non epi. */
	@Column(name = "seizures_while_awake_non_epi")
	private int seizuresWhileAwakeNonEpi;	

	/** The seizures while sleep epi. */
	@Column(name = "seizures_while_sleep_epi")
	private int seizuresWhileSleepEpi;

	/** The seizures while sleep latent. */
	@Column(name = "seizures_while_sleep_latent")
	private int seizuresWhileSleepLatent;

	/** The seizures while sleep non epi. */
	@Column(name = "seizures_while_sleep_non_epi")
	private int seizuresWhileSleepNonEpi;

	/** The comment. */
	@Column(name = "comment")
	private String comment;

	/** The deleted. */
	@Column(name = "deleted")
	private int deleted;

	/** The add user id. */
	@Column(name = "add_user_id")
	private int addUserId;
	
	@Column(name = "STATUS", nullable = false)
	private int status;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;
	
	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}


	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Gets the doctor id.
	 *
	 * @return the doctor id
	 */
	public int getDoctorId() {
		return doctorId;
	}

	/**
	 * Sets the doctor id.
	 *
	 * @param doctorId the new doctor id
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * Gets the added.
	 *
	 * @return the added
	 */
	public Date getAdded() {
		return added;
	}

	/**
	 * Sets the added.
	 *
	 * @param added the new added
	 */
	public void setAdded(Date added) {
		this.added = added;
	}

	/**
	 * Gets the seizure frequency idcom.
	 *
	 * @return the seizure frequency idcom
	 */
	public int getSeizureFrequencyIdcom() {
		return seizureFrequencyIdcom;
	}

	/**
	 * Sets the seizure frequency idcom.
	 *
	 * @param seizureFrequencyIdcom the new seizure frequency idcom
	 */
	public void setSeizureFrequencyIdcom(int seizureFrequencyIdcom) {
		this.seizureFrequencyIdcom = seizureFrequencyIdcom;
	}

	/**
	 * Gets the secondarily generalized seizure.
	 *
	 * @return the secondarily generalized seizure
	 */
	public int getSecondarilyGeneralizedSeizure() {
		return secondarilyGeneralizedSeizure;
	}

	/**
	 * Sets the secondarily generalized seizure.
	 *
	 * @param secondarilyGeneralizedSeizure the new secondarily generalized seizure
	 */
	public void setSecondarilyGeneralizedSeizure(int secondarilyGeneralizedSeizure) {
		this.secondarilyGeneralizedSeizure = secondarilyGeneralizedSeizure;
	}

	/**
	 * Gets the status epilepticus.
	 *
	 * @return the status epilepticus
	 */
	public boolean getStatusEpilepticus() {
		return statusEpilepticus;
	}

	/**
	 * Sets the status epilepticus.
	 *
	 * @param statusEpilepticus the new status epilepticus
	 */
	public void setStatusEpilepticus(boolean statusEpilepticus) {
		this.statusEpilepticus = statusEpilepticus;
	}

	/**
	 * Gets the ssc classification idcom.
	 *
	 * @return the ssc classification idcom
	 */
	public int getSscClassificationIdcom() {
		return sscClassificationIdcom;
	}

	/**
	 * Sets the ssc classification idcom.
	 *
	 * @param sscClassificationIdcom the new ssc classification idcom
	 */
	public void setSscClassificationIdcom(int sscClassificationIdcom) {
		this.sscClassificationIdcom = sscClassificationIdcom;
	}

	/**
	 * Gets the ilae classification idcom.
	 *
	 * @return the ilae classification idcom
	 */
	public int getIlaeClassificationIdcom() {
		return ilaeClassificationIdcom;
	}

	/**
	 * Sets the ilae classification idcom.
	 *
	 * @param ilaeClassificationIdcom the new ilae classification idcom
	 */
	public void setIlaeClassificationIdcom(int ilaeClassificationIdcom) {
		this.ilaeClassificationIdcom = ilaeClassificationIdcom;
	}

	/**
	 * Gets the seizures while awake epi.
	 *
	 * @return the seizures while awake epi
	 */
	public int getSeizuresWhileAwakeEpi() {
		return seizuresWhileAwakeEpi;
	}

	/**
	 * Sets the seizures while awake epi.
	 *
	 * @param seizuresWhileAwakeEpi the new seizures while awake epi
	 */
	public void setSeizuresWhileAwakeEpi(int seizuresWhileAwakeEpi) {
		this.seizuresWhileAwakeEpi = seizuresWhileAwakeEpi;
	}

	/**
	 * Gets the seizures while awake latent.
	 *
	 * @return the seizures while awake latent
	 */
	public int getSeizuresWhileAwakeLatent() {
		return seizuresWhileAwakeLatent;
	}

	/**
	 * Sets the seizures while awake latent.
	 *
	 * @param seizuresWhileAwakeLatent the new seizures while awake latent
	 */
	public void setSeizuresWhileAwakeLatent(int seizuresWhileAwakeLatent) {
		this.seizuresWhileAwakeLatent = seizuresWhileAwakeLatent;
	}

	/**
	 * Gets the seizures while awake non epi.
	 *
	 * @return the seizures while awake non epi
	 */
	public int getSeizuresWhileAwakeNonEpi() {
		return seizuresWhileAwakeNonEpi;
	}

	/**
	 * Sets the seizures while awake non epi.
	 *
	 * @param seizuresWhileAwakeNonEpi the new seizures while awake non epi
	 */
	public void setSeizuresWhileAwakeNonEpi(int seizuresWhileAwakeNonEpi) {
		this.seizuresWhileAwakeNonEpi = seizuresWhileAwakeNonEpi;
	}

	/**
	 * Gets the seizures while sleep epi.
	 *
	 * @return the seizures while sleep epi
	 */
	public int getSeizuresWhileSleepEpi() {
		return seizuresWhileSleepEpi;
	}

	/**
	 * Sets the seizures while sleep epi.
	 *
	 * @param seizuresWhileSleepEpi the new seizures while sleep epi
	 */
	public void setSeizuresWhileSleepEpi(int seizuresWhileSleepEpi) {
		this.seizuresWhileSleepEpi = seizuresWhileSleepEpi;
	}

	/**
	 * Gets the seizures while sleep latent.
	 *
	 * @return the seizures while sleep latent
	 */
	public int getSeizuresWhileSleepLatent() {
		return seizuresWhileSleepLatent;
	}

	/**
	 * Sets the seizures while sleep latent.
	 *
	 * @param seizuresWhileSleepLatent the new seizures while sleep latent
	 */
	public void setSeizuresWhileSleepLatent(int seizuresWhileSleepLatent) {
		this.seizuresWhileSleepLatent = seizuresWhileSleepLatent;
	}

	/**
	 * Gets the seizures while sleep non epi.
	 *
	 * @return the seizures while sleep non epi
	 */
	public int getSeizuresWhileSleepNonEpi() {
		return seizuresWhileSleepNonEpi;
	}

	/**
	 * Sets the seizures while sleep non epi.
	 *
	 * @param seizuresWhileSleepNonEpi the new seizures while sleep non epi
	 */
	public void setSeizuresWhileSleepNonEpi(int seizuresWhileSleepNonEpi) {
		this.seizuresWhileSleepNonEpi = seizuresWhileSleepNonEpi;
	}

	/**
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment the new comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Gets the deleted.
	 *
	 * @return the deleted
	 */
	public int getDeleted() {
		return deleted;
	}

	/**
	 * Sets the deleted.
	 *
	 * @param deleted the new deleted
	 */
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	/**
	 * Gets the adds the user id.
	 *
	 * @return the adds the user id
	 */
	public int getAddUserId() {
		return addUserId;
	}

	/**
	 * Sets the adds the user id.
	 *
	 * @param addUserId the new adds the user id
	 */
	public void setAddUserId(int addUserId) {
		this.addUserId = addUserId;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public int compareTo(SeizureEntity o) {
		int comparison = this.date.compareTo(o.getDate());
		if (comparison > 0) {
			return -1;
		} else if (comparison == 0) {
			return 0;
		} else {
			return 1;
		}
	}
	
}

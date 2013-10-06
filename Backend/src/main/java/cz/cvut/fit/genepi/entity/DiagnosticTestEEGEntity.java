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
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "DIAGNOSTICTESTEEG")
public class DiagnosticTestEEGEntity {
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

	@Column(name="basic_eeg_activity_idcom")
	private int basicEegActivityIdcom;
	
	@Column(name="eeg_slow_idcom")
	private int eegSlowIdcom;
	
	@Column(name="interictal_eeg_spikes_idcom")
	private int interictalEegSpikesIdcom;
	
	@Column(name="localization_interictal_EEG_ spikes")
	private String localizationInterictalEEGSpikes;
	
	@Column(name="eeg_status_epilepticus")
	private Boolean eegStatusEpilepticus;
	
	@Column(name="secondary_sided_ synchrony")
	private Boolean secondarySidedSynchrony;
	
	@Column(name="ictal_eeg_patterns_idcom")
	private int ictalEegPatternsIdcom;
	
	@Column(name="localization_ictal_eeg_pattern")
	private String localizationIctalEegPattern;
	
	
	/** The comment. */
	@Size(max = 400)
	@Column(name = "COMMENT", length = 400, nullable = true)
	private String comment;

	/** The deleted. */
	@Column(name = "DELETED", precision = 1, scale = 0, nullable = true)
	private Boolean deleted;

	@Column(name = "STATUS", nullable = false)
	private int status;
	
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

	public int getBasicEegActivityIdcom() {
		return basicEegActivityIdcom;
	}

	public void setBasicEegActivityIdcom(int basicEegActivityIdcom) {
		this.basicEegActivityIdcom = basicEegActivityIdcom;
	}

	public int getEegSlowIdcom() {
		return eegSlowIdcom;
	}

	public void setEegSlowIdcom(int eegSlowIdcom) {
		this.eegSlowIdcom = eegSlowIdcom;
	}

	public int getInterictalEegSpikesIdcom() {
		return interictalEegSpikesIdcom;
	}

	public void setInterictalEegSpikesIdcom(int interictalEegSpikesIdcom) {
		this.interictalEegSpikesIdcom = interictalEegSpikesIdcom;
	}

	public String getLocalizationInterictalEEGSpikes() {
		return localizationInterictalEEGSpikes;
	}

	public void setLocalizationInterictalEEGSpikes(
			String localizationInterictalEEGSpikes) {
		this.localizationInterictalEEGSpikes = localizationInterictalEEGSpikes;
	}

	public Boolean getEegStatusEpilepticus() {
		return eegStatusEpilepticus;
	}

	public void setEegStatusEpilepticus(Boolean eegStatusEpilepticus) {
		this.eegStatusEpilepticus = eegStatusEpilepticus;
	}

	public Boolean getSecondarySidedSynchrony() {
		return secondarySidedSynchrony;
	}

	public void setSecondarySidedSynchrony(Boolean secondarySidedSynchrony) {
		this.secondarySidedSynchrony = secondarySidedSynchrony;
	}

	public int getIctalEegPatternsIdcom() {
		return ictalEegPatternsIdcom;
	}

	public void setIctalEegPatternsIdcom(int ictalEegPatternsIdcom) {
		this.ictalEegPatternsIdcom = ictalEegPatternsIdcom;
	}

	public String getLocalizationIctalEegPattern() {
		return localizationIctalEegPattern;
	}

	public void setLocalizationIctalEegPattern(String localizationIctalEegPattern) {
		this.localizationIctalEegPattern = localizationIctalEegPattern;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	/*public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}*/
	
}

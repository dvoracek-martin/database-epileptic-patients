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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import cz.cvut.fit.genepi.entity.PatientEntity;

@Entity
@Table(name = "invasive_test_eeg")
public class InvasiveTestEEGEntity implements Comparable<InvasiveTestEEGEntity> {
	/** The id. */
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

	@Column(name = "invasive_monitoring")
	private Boolean invasiveMonitoring;

	@Column(name = "cortical_mapping_idcom")
	private int corticalMappingIdcoml;

	@Column(name = "localization_intracranial_electrodes")
	private String localizationIntracranialElectrodes;

	@Column(name = "intracranial_electrodes_idcom")
	private int intracranialElectrodesIdcom;

	@Column(name = "invasive_eeg_slowing_idcom")
	private int invasiveEegSlowingIdcom;

	@Column(name = "invasive_eeg_interictal_spikes_idcom")
	private int invasiveEegInterictalSpikesIdcom;

	@Column(name = "invasive_eeg_status_epilepticus")
	private Boolean invasiveEegStatusEpilepticus;

	@Column(name = "invasive_ictal_eeg_patterns_idcom")
	private int invasiveIctalEegPatternsIdcom;

	@Column(name = "localization_invasive_ictal_eeg_patterns")
	private String localizationInvasiveIctalEegPatterns;

	/** The comment. */
	@Size(max = 400)
	@Column(name = "COMMENT", length = 400, nullable = true)
	private String comment;

	/** The deleted. */
	@Column(name = "DELETED", precision = 1, scale = 0, nullable = true)
	private Boolean deleted;

	/** The add user id. */
	@NotNull
	@Column(name = "ADD_USER_ID", precision = 6, scale = 0, nullable = false)
	private int addUserId;

	@Column(name = "STATUS", nullable = false)
	private int status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;

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

	public Boolean getInvasiveMonitoring() {
		return invasiveMonitoring;
	}

	public void setInvasiveMonitoring(Boolean invasiveMonitoring) {
		this.invasiveMonitoring = invasiveMonitoring;
	}

	public int getCorticalMappingIdcoml() {
		return corticalMappingIdcoml;
	}

	public void setCorticalMappingIdcoml(int corticalMappingIdcoml) {
		this.corticalMappingIdcoml = corticalMappingIdcoml;
	}

	public String getLocalizationIntracranialElectrodes() {
		return localizationIntracranialElectrodes;
	}

	public void setLocalizationIntracranialElectrodes(
			String localizationIntracranialElectrodes) {
		this.localizationIntracranialElectrodes = localizationIntracranialElectrodes;
	}

	public int getIntracranialElectrodesIdcom() {
		return intracranialElectrodesIdcom;
	}

	public void setIntracranialElectrodesIdcom(int intracranialElectrodesIdcom) {
		this.intracranialElectrodesIdcom = intracranialElectrodesIdcom;
	}

	public int getInvasiveEegSlowingIdcom() {
		return invasiveEegSlowingIdcom;
	}

	public void setInvasiveEegSlowingIdcom(int invasiveEegSlowingIdcom) {
		this.invasiveEegSlowingIdcom = invasiveEegSlowingIdcom;
	}

	public int getInvasiveEegInterictalSpikesIdcom() {
		return invasiveEegInterictalSpikesIdcom;
	}

	public void setInvasiveEegInterictalSpikesIdcom(
			int invasiveEegInterictalSpikesIdcom) {
		this.invasiveEegInterictalSpikesIdcom = invasiveEegInterictalSpikesIdcom;
	}

	public Boolean getInvasiveEegStatusEpilepticus() {
		return invasiveEegStatusEpilepticus;
	}

	public void setInvasiveEegStatusEpilepticus(Boolean invasiveEegStatusEpilepticus) {
		this.invasiveEegStatusEpilepticus = invasiveEegStatusEpilepticus;
	}

	public int getInvasiveIctalEegPatternsIdcom() {
		return invasiveIctalEegPatternsIdcom;
	}

	public void setInvasiveIctalEegPatternsIdcom(int invasiveIctalEegPatternsIdcom) {
		this.invasiveIctalEegPatternsIdcom = invasiveIctalEegPatternsIdcom;
	}

	public String getLocalizationInvasiveIctalEegPatterns() {
		return localizationInvasiveIctalEegPatterns;
	}

	public void setLocalizationInvasiveIctalEegPatterns(
			String localizationInvasiveIctalEegPatterns) {
		this.localizationInvasiveIctalEegPatterns = localizationInvasiveIctalEegPatterns;
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
	
	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}	
	
	@Override
	public int compareTo(InvasiveTestEEGEntity o) {
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

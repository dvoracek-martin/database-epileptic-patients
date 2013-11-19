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

	/* Autofilled fields */

	/** The id. */
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private int id;

	/** The add user id. */
	@NotNull
	@Column(name = "add_user_id", nullable = false)
	private int addUserId;

	/** The added. */
	@Column(name = "added", nullable = false, insertable = false)
	private Date added;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;

	@Column(name = "status", nullable = false)
	private int status;

	/* Other fields */

	/** The date. */
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past
	@NotNull
	@Column(name = "date", nullable = false)
	private Date date;

	@Column(name = "done")
	private boolean done;

	@Column(name = "intracranial_electrodes")
	private int intracranialElectrodes;

	@Column(name = "localization_intracranial_electrodes")
	private String localizationIntracranialElectrodes;

	@Column(name = "invasive_eeg_slow")
	private int invasiveEegSlow;

	@Column(name = "invasive_eeg_interictal_spikes")
	private int invasiveEegInterictalSpikes;

	@Column(name = "localization_invasive_eeg_interictal_spikes")
	private String localizationInvasiveEegInterictalSpikes;

	@Column(name = "invasive_eeg_status_epilepticus")
	private boolean invasiveEegStatusEpilepticus;

	@Column(name = "invasive_ictal_eeg_patterns")
	private int invasiveIctalEegPatterns;

	@Column(name = "localization_invasive_ictal_eeg_patterns")
	private int localizationInvasiveIctalEegPatterns;

	/** The comment. */
	@Size(max = 800)
	@Column(name = "comment", length = 800, nullable = true)
	private String comment;

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

	/* Getters and Setters */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAddUserId() {
		return addUserId;
	}

	public void setAddUserId(int addUserId) {
		this.addUserId = addUserId;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public int getIntracranialElectrodes() {
		return intracranialElectrodes;
	}

	public void setIntracranialElectrodes(int intracranialElectrodes) {
		this.intracranialElectrodes = intracranialElectrodes;
	}

	public String getLocalizationIntracranialElectrodes() {
		return localizationIntracranialElectrodes;
	}

	public void setLocalizationIntracranialElectrodes(
			String localizationIntracranialElectrodes) {
		this.localizationIntracranialElectrodes = localizationIntracranialElectrodes;
	}

	public int getInvasiveEegSlow() {
		return invasiveEegSlow;
	}

	public void setInvasiveEegSlow(int invasiveEegSlow) {
		this.invasiveEegSlow = invasiveEegSlow;
	}

	public int getInvasiveEegInterictalSpikes() {
		return invasiveEegInterictalSpikes;
	}

	public void setInvasiveEegInterictalSpikes(int invasiveEegInterictalSpikes) {
		this.invasiveEegInterictalSpikes = invasiveEegInterictalSpikes;
	}

	public String getLocalizationInvasiveEegInterictalSpikes() {
		return localizationInvasiveEegInterictalSpikes;
	}

	public void setLocalizationInvasiveEegInterictalSpikes(
			String localizationInvasiveEegInterictalSpikes) {
		this.localizationInvasiveEegInterictalSpikes = localizationInvasiveEegInterictalSpikes;
	}

	public boolean isInvasiveEegStatusEpilepticus() {
		return invasiveEegStatusEpilepticus;
	}

	public void setInvasiveEegStatusEpilepticus(
			boolean invasiveEegStatusEpilepticus) {
		this.invasiveEegStatusEpilepticus = invasiveEegStatusEpilepticus;
	}

	public int getInvasiveIctalEegPatterns() {
		return invasiveIctalEegPatterns;
	}

	public void setInvasiveIctalEegPatterns(int invasiveIctalEegPatterns) {
		this.invasiveIctalEegPatterns = invasiveIctalEegPatterns;
	}

	public int getLocalizationInvasiveIctalEegPatterns() {
		return localizationInvasiveIctalEegPatterns;
	}

	public void setLocalizationInvasiveIctalEegPatterns(
			int localizationInvasiveIctalEegPatterns) {
		this.localizationInvasiveIctalEegPatterns = localizationInvasiveIctalEegPatterns;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}

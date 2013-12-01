package cz.cvut.fit.genepi.dataLayer.entity.card;

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

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

@Entity
@Table(name = "outcome")
public class OutcomeEntity implements Comparable<OutcomeEntity> {

	/* Autofilled fields */

	/** The id. */
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private int id;

	/** The add user id. */
	//@NotNull
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
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
//	@Past
//	@NotNull
	@Column(name = "date", nullable = false)
	private Date date;

	@Column(name = "seizure_outcome")
	private int seizureOutcome;

	@Column(name = "aed")
	private int aed;

	@Column(name = "eeg")
	private int eeg;

	@Column(name = "mri")
	private int mri;

	@Column(name = "neuropsychology")
	private int neuropsychology;

	@Column(name = "distance")
	private int distance;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "operation_id")
	private OperationEntity operation;
	
	/** The comment. */
//	@Size(max = 800)
	@Column(name = "comment", length = 800, nullable = true)
	private String comment;

	@Override
	public int compareTo(OutcomeEntity o) {
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

	public int getSeizureOutcome() {
		return seizureOutcome;
	}

	public void setSeizureOutcome(int seizureOutcome) {
		this.seizureOutcome = seizureOutcome;
	}

	public int getAed() {
		return aed;
	}

	public void setAed(int aed) {
		this.aed = aed;
	}

	public int getEeg() {
		return eeg;
	}

	public void setEeg(int eeg) {
		this.eeg = eeg;
	}

	public int getMri() {
		return mri;
	}

	public void setMri(int mri) {
		this.mri = mri;
	}

	public int getDistance() {
		return neuropsychology;
	}

	public void setDistancey(int distance) {
		this.distance = distance;
	}
	
	public int getNeuropsychology() {
		return neuropsychology;
	}

	public void setNeuropsychology(int neuropsychology) {
		this.neuropsychology = neuropsychology;
	}
	
	public OperationEntity getOperation() {
		return operation;
	}

	public void setOperation(OperationEntity operation) {
		this.operation = operation;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}

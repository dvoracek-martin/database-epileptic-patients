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
@Table(name = "pharmacotherapy")
public class PharmacotherapyEntity implements Comparable<PharmacotherapyEntity> {

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

	@Column(name = "aed")
	private int aed;

	@Column(name = "efficiency")
	private int efficiency;

	@Column(name = "during_surgery")
	private boolean duringSurgery;

	/** The comment. */
	@Size(max = 800)
	@Column(name = "comment", length = 800, nullable = true)
	private String comment;

	@Override
	public int compareTo(PharmacotherapyEntity o) {
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

	public int getAed() {
		return aed;
	}

	public void setAed(int aed) {
		this.aed = aed;
	}

	public int getEfficiency() {
		return efficiency;
	}

	public void setEfficiency(int efficiency) {
		this.efficiency = efficiency;
	}

	public boolean isDuringSurgery() {
		return duringSurgery;
	}

	public void setDuringSurgery(boolean duringSurgery) {
		this.duringSurgery = duringSurgery;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
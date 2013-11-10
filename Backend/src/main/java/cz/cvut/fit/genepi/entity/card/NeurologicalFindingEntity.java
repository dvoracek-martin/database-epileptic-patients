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
@Table(name = "neurological_finding")
public class NeurologicalFindingEntity implements
		Comparable<NeurologicalFindingEntity> {

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

	@Column(name = "hemisphere_dominance")
	private int hemisphereDominance;

	@Column(name = "abnormal_neurological_finding")
	private boolean abnormalNeurologicalFinding;

	@Column(name = "hemiparesis")
	private boolean hemiparesis;

	@Column(name = "visual_field_defects")
	private boolean visualFieldDefects;

	/** The comment. */
	@Size(max = 800)
	@Column(name = "comment", length = 800, nullable = true)
	private String comment;

	@Override
	public int compareTo(NeurologicalFindingEntity o) {
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

	public int getHemisphereDominance() {
		return hemisphereDominance;
	}

	public void setHemisphereDominance(int hemisphereDominance) {
		this.hemisphereDominance = hemisphereDominance;
	}

	public boolean isAbnormalNeurologicalFinding() {
		return abnormalNeurologicalFinding;
	}

	public void setAbnormalNeurologicalFinding(
			boolean abnormalNeurologicalFinding) {
		this.abnormalNeurologicalFinding = abnormalNeurologicalFinding;
	}

	public boolean isHemiparesis() {
		return hemiparesis;
	}

	public void setHemiparesis(boolean hemiparesis) {
		this.hemiparesis = hemiparesis;
	}

	public boolean isVisualFieldDefects() {
		return visualFieldDefects;
	}

	public void setVisualFieldDefects(boolean visualFieldDefects) {
		this.visualFieldDefects = visualFieldDefects;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}

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
@Table(name = "NEUROLOGICAL_FINDING")
public class NeurologicalFindingEntity {
	@Id
	@Column(name = "ID", precision = 6, scale = 0, nullable = false)
	@GeneratedValue
	private int id;
	
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
	
	@Column(name="hemisphere_dominance_idcom")
	private int hemisphereDominanceIdcom;
	
	@Column(name="abnormal_neurological_finding")
	private int abnormalNeurologicalFinding;
	
	@Column(name="hemiparesis")
	private int hemiparesis;
	
	@Column(name="visual_cut")
	private int visualCut;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="deleted")
	private Boolean deleted;
	
	@NotNull
	@Column(name = "ADD_USER_ID", precision = 6, scale = 0, nullable = false)
	private int addUserId;
	
	@Column(name = "STATUS", nullable = false)
	private int status;
		
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

	public int getHemisphereDominanceIdcom() {
		return hemisphereDominanceIdcom;
	}

	public void setHemisphereDominanceIdcom(int hemisphereDominanceIdcom) {
		this.hemisphereDominanceIdcom = hemisphereDominanceIdcom;
	}

	public int getAbnormalNeurologicalFinding() {
		return abnormalNeurologicalFinding;
	}

	public void setAbnormalNeurologicalFinding(int abnormalNeurologicalFinding) {
		this.abnormalNeurologicalFinding = abnormalNeurologicalFinding;
	}

	public int getHemiparesis() {
		return hemiparesis;
	}

	public void setHemiparesis(int hemiparesis) {
		this.hemiparesis = hemiparesis;
	}

	public int getVisualCut() {
		return visualCut;
	}

	public void setVisualCut(int visualCut) {
		this.visualCut = visualCut;
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

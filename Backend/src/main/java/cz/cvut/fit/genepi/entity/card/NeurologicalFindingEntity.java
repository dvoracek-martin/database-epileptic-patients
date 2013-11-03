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

import org.springframework.format.annotation.DateTimeFormat;

import cz.cvut.fit.genepi.entity.PatientEntity;

@Entity
@Table(name = "neurological_finding")
public class NeurologicalFindingEntity implements Comparable<NeurologicalFindingEntity>{
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
	private boolean abnormalNeurologicalFinding;

	@Column (name ="neurological_finding_detail", nullable=false)
	private String neurologicalFindingDetail;

	
	@Column(name="hemiparesis")
	private boolean hemiparesis;
	
	@Column(name="visual_cut")
	private boolean visualCut;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="deleted")
	private Boolean deleted;
	
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

	public int getHemisphereDominanceIdcom() {
		return hemisphereDominanceIdcom;
	}

	public void setHemisphereDominanceIdcom(int hemisphereDominanceIdcom) {
		this.hemisphereDominanceIdcom = hemisphereDominanceIdcom;
	}

	public boolean getAbnormalNeurologicalFinding() {
		return abnormalNeurologicalFinding;
	}

	public void setAbnormalNeurologicalFinding(boolean abnormalNeurologicalFinding) {
		this.abnormalNeurologicalFinding = abnormalNeurologicalFinding;
	}
	
	public String getNeurologicalFindingDetail() {
		return neurologicalFindingDetail;
	}

	public void setNeurologicalFindingDetail(String neurologicalFindingDetail) {
		this.neurologicalFindingDetail = neurologicalFindingDetail;
	}

	public boolean getHemiparesis() {
		return hemiparesis;
	}

	public void setHemiparesis(boolean hemiparesis) {
		this.hemiparesis = hemiparesis;
	}

	public boolean getVisualCut() {
		return visualCut;
	}

	public void setVisualCut(boolean visualCut) {
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
	
	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}	
	
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
}

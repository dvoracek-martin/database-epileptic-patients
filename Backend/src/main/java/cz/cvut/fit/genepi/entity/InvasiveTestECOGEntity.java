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
@Table(name = "INVASIVETESTECOG")
public class InvasiveTestECOGEntity {
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
	
	@Column(name="intraoperative_ecog")
	private Boolean intraoperativeEcog;
	
	@Column(name="ecog_patterns_idcom")
	private int ecogPatternsIdcom;
	
	@Column(name="ecog_cover")
	private String ecogCover;
	
	@Column(name="after_resection_ecog_idcom")
	private int afterResectionEcogIdcom;
	
	@Column(name="awake_craniotomy")
	private Boolean awakeCraniotomy;
	
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

	public Boolean getIntraoperativeEcog() {
		return intraoperativeEcog;
	}

	public void setIntraoperativeEcog(Boolean intraoperativeEcog) {
		this.intraoperativeEcog = intraoperativeEcog;
	}

	public int getEcogPatternsIdcom() {
		return ecogPatternsIdcom;
	}

	public void setEcogPatternsIdcom(int ecogPatternsIdcom) {
		this.ecogPatternsIdcom = ecogPatternsIdcom;
	}

	public String getEcogCover() {
		return ecogCover;
	}

	public void setEcogCover(String ecogCover) {
		this.ecogCover = ecogCover;
	}

	public int getAfterResectionEcogIdcom() {
		return afterResectionEcogIdcom;
	}

	public void setAfterResectionEcogIdcom(int afterResectionEcogIdcom) {
		this.afterResectionEcogIdcom = afterResectionEcogIdcom;
	}

	public Boolean getAwakeCraniotomy() {
		return awakeCraniotomy;
	}

	public void setAwakeCraniotomy(Boolean awakeCraniotomy) {
		this.awakeCraniotomy = awakeCraniotomy;
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

	/*public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}*/
	
}

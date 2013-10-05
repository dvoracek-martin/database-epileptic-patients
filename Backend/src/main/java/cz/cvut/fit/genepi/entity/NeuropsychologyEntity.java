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
@Table(name = "NEUROPSYCHOLOGY")
public class NeuropsychologyEntity {
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
	
	@Column(name="neuropsychological_examination")
	private Boolean neuropsychologicalExamination;
	
	@Column(name="intelligence_level_idcom")
	private int intelligenceLevelIdcom;
	
	@Column(name="specific_learning")
	private Boolean specificLearning;
	
	@Column(name="developmental_language_disorders")
	private Boolean developmentalLanguageDisorders;
	
	@Column(name="adhd_syndrome")
	private Boolean adhdSyndrome;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="deleted")
	private Boolean deleted;	
	
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

	public Boolean getNeuropsychologicalExamination() {
		return neuropsychologicalExamination;
	}

	public void setNeuropsychologicalExamination(
			Boolean neuropsychologicalExamination) {
		this.neuropsychologicalExamination = neuropsychologicalExamination;
	}

	public int getIntelligenceLevelIdcom() {
		return intelligenceLevelIdcom;
	}

	public void setIntelligenceLevelIdcom(int intelligenceLevelIdcom) {
		this.intelligenceLevelIdcom = intelligenceLevelIdcom;
	}

	public Boolean getSpecificLearning() {
		return specificLearning;
	}

	public void setSpecificLearning(Boolean specificLearning) {
		this.specificLearning = specificLearning;
	}

	public Boolean getDevelopmentalLanguageDisorders() {
		return developmentalLanguageDisorders;
	}

	public void setDevelopmentalLanguageDisorders(
			Boolean developmentalLanguageDisorders) {
		this.developmentalLanguageDisorders = developmentalLanguageDisorders;
	}

	public Boolean getAdhdSyndrome() {
		return adhdSyndrome;
	}

	public void setAdhdSyndrome(Boolean adhdSyndrome) {
		this.adhdSyndrome = adhdSyndrome;
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

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

//TODO: Merge with pszchology NEW??
@Entity
@Table(name = "neuropsychlogy")
public class NeuropsychologyOldEntity implements Comparable<NeuropsychologyOldEntity> {

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

	@Column(name = "intelligence_level")
	private int intelligenceLevel;
	
	@Column(name = "neuropsychological_examination")
	private boolean neuropsychologicalExamination;

	@Column(name = "specific_learning")
	private boolean specificLearning;

	@Column(name = "developmental_language_disorders")
	private boolean developmentalLanguageDisorders;

	@Column(name = "adhd_syndrome")
	private boolean adhdSyndrome;

	/** The comment. */
	@Size(max = 800)
	@Column(name = "comment", length = 800, nullable = true)
	private String comment;

	@Override
	public int compareTo(NeuropsychologyOldEntity o) {
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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public boolean isNeuropsychologicalExamination() {
		return neuropsychologicalExamination;
	}

	public void setNeuropsychologicalExamination(
			boolean neuropsychologicalExamination) {
		this.neuropsychologicalExamination = neuropsychologicalExamination;
	}

	public int getIntelligenceLevel() {
		return intelligenceLevel;
	}

	public void setIntelligenceLevel(int intelligenceLevel) {
		this.intelligenceLevel = intelligenceLevel;
	}

	public boolean isSpecificLearning() {
		return specificLearning;
	}

	public void setSpecificLearning(boolean specificLearning) {
		this.specificLearning = specificLearning;
	}

	public boolean isDevelopmentalLanguageDisorders() {
		return developmentalLanguageDisorders;
	}

	public void setDevelopmentalLanguageDisorders(
			boolean developmentalLanguageDisorders) {
		this.developmentalLanguageDisorders = developmentalLanguageDisorders;
	}

	public boolean isAdhdSyndrome() {
		return adhdSyndrome;
	}

	public void setAdhdSyndrome(boolean adhdSyndrome) {
		this.adhdSyndrome = adhdSyndrome;
	}
}

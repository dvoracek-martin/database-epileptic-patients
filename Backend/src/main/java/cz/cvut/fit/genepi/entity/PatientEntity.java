package cz.cvut.fit.genepi.entity;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import cz.cvut.fit.genepi.entity.card.AnamnesisEntity;
import cz.cvut.fit.genepi.entity.card.ComplicationEntity;
import cz.cvut.fit.genepi.entity.card.DiagnosticTestEEGEntity;
import cz.cvut.fit.genepi.entity.card.DiagnosticTestMRIEntity;
import cz.cvut.fit.genepi.entity.card.HistologyEntity;
import cz.cvut.fit.genepi.entity.card.InvasiveTestECOGEntity;
import cz.cvut.fit.genepi.entity.card.InvasiveTestEEGEntity;
import cz.cvut.fit.genepi.entity.card.NeurologicalFindingEntity;
import cz.cvut.fit.genepi.entity.card.NeuropsychologyEntity;
import cz.cvut.fit.genepi.entity.card.OperationEntity;
import cz.cvut.fit.genepi.entity.card.OutcomeEntity;
import cz.cvut.fit.genepi.entity.card.PharmacotherapyEntity;
import cz.cvut.fit.genepi.entity.card.SeizureEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientEntity.
 */
@Entity
@Table(name = "PATIENT")
public class PatientEntity {

	/** The id. */
	@Id
	@Column(name = "ID", precision = 6, scale = 0, nullable = false)
	@GeneratedValue
	private int id;

	/** The nin. */
	@Pattern(regexp = "[0-9]*")
	@Size(max = 10)
	@Column(name = "NIN", length = 10, nullable = true)
	private String nin;

	/** The birthday. */
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past
	@NotNull
	@Column(name = "BIRTHDAY", nullable = false)
	private Date birthday;

	/** The gender. */
	@NotBlank
	// @NotNull
	@Size(max = 10)
	@Column(name = "GENDER", length = 10, nullable = false)
	private String gender;

	/** The doctor id. */
	@Column(name = "DOCTOR_ID", precision = 6, scale = 0, nullable = true)
	private int doctorId;

	/** The deleted. */
	@Column(name = "DELETED", precision = 1, scale = 0, nullable = true)
	private Boolean deleted;

	/** The checked. */
	@Column(name = "CHECKED", precision = 1, scale = 0, nullable = true)
	private Boolean checked;

	/** The contact id. */
	@Column(name = "CONTACT_ID", precision = 6, scale = 0, nullable = true, insertable = false, updatable = false)
	private int contactId;

	/** The comment id. */
	/*
	 * @Column(name = "COMMENT_ID", precision = 6, scale = 0, nullable = true)
	 * private int commentId;
	 */

	/** The contact. */
	@Valid
	@OneToOne
	@Cascade({ CascadeType.SAVE_UPDATE })
	private ContactEntity contact;

	/* AnamnesisList */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private List<AnamnesisEntity> anamnesisList;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private List<NeurologicalFindingEntity> neurologicalFindingList;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private List<PharmacotherapyEntity> pharmacotherapyList;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private List<ComplicationEntity> complicationList;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private List<SeizureEntity> seizureList;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private List<HistologyEntity> histologyList;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private List<NeuropsychologyEntity> neuropsychologyList;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private List<OutcomeEntity> outcomeList;
	
		@OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private List<InvasiveTestEEGEntity> invasiveTestEEGList;
	
		@OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private List<OperationEntity> operationList;
	
			@OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private List<DiagnosticTestMRIEntity> diagnosticTestMriList;
	
				@OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private List<DiagnosticTestEEGEntity> DiagnosticTestEEGList;
	
					@OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private List<InvasiveTestECOGEntity> InvasiveTestECOGList;

	
	public List<NeurologicalFindingEntity> getNeurologicalFindingList() {
		return neurologicalFindingList;
	}

	public void setNeurologicalFindingList(
			List<NeurologicalFindingEntity> neurologicalFindingList) {
		this.neurologicalFindingList = neurologicalFindingList;
	}

	public List<PharmacotherapyEntity> getPharmacotherapyList() {
		return pharmacotherapyList;
	}

	public void setPharmacotherapyList(
			List<PharmacotherapyEntity> pharmacotherapyList) {
		this.pharmacotherapyList = pharmacotherapyList;
	}

	public List<ComplicationEntity> getComplicationList() {
		return complicationList;
	}

	public void setComplicationList(List<ComplicationEntity> complicationList) {
		this.complicationList = complicationList;
	}

	public List<SeizureEntity> getSeizureList() {
		return seizureList;
	}

	public void setSeizureList(List<SeizureEntity> seizureList) {
		this.seizureList = seizureList;
	}

	public List<HistologyEntity> getHistologyList() {
		return histologyList;
	}

	public void setHistologyList(List<HistologyEntity> histologyList) {
		this.histologyList = histologyList;
	}

	public List<NeuropsychologyEntity> getNeuropsychologyList() {
		return neuropsychologyList;
	}

	public void setNeuropsychologyList(
			List<NeuropsychologyEntity> neuropsychologyList) {
		this.neuropsychologyList = neuropsychologyList;
	}

	public List<OutcomeEntity> getOutcomeList() {
		return outcomeList;
	}

	public void setOutcomeList(List<OutcomeEntity> outcomeList) {
		this.outcomeList = outcomeList;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the nin.
	 * 
	 * @return the nin
	 */
	public String getNin() {
		return nin;
	}

	/**
	 * Sets the nin.
	 * 
	 * @param nin
	 *            the new nin
	 */
	public void setNin(String nin) {
		this.nin = nin;
	}

	/**
	 * Gets the birthday.
	 * 
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * Sets the birthday.
	 * 
	 * @param birthday
	 *            the new birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * Gets the gender.
	 * 
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 * 
	 * @param gender
	 *            the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the doctor id.
	 * 
	 * @return the doctor id
	 */
	public int getDoctorId() {
		return doctorId;
	}

	/**
	 * Sets the doctor id.
	 * 
	 * @param doctorId
	 *            the new doctor id
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * Gets the deleted.
	 * 
	 * @return the deleted
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * Sets the deleted.
	 * 
	 * @param deleted
	 *            the new deleted
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * Gets the checked.
	 * 
	 * @return the checked
	 */
	public Boolean getChecked() {
		return checked;
	}

	/**
	 * Sets the checked.
	 * 
	 * @param checked
	 *            the new checked
	 */
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	/**
	 * Gets the contact id.
	 * 
	 * @return the contact id
	 */
	public int getContactId() {
		return contactId;
	}

	/**
	 * Sets the contact id.
	 * 
	 * @param contactId
	 *            the new contact id
	 */
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	/**
	 * Gets the comment id.
	 * 
	 * @return the comment id
	 */
	/*
	 * public int getCommentId() { return commentId; }
	 */
	/**
	 * Sets the comment id.
	 * 
	 * @param commentId
	 *            the new comment id
	 */
	/*
	 * public void setCommentId(int commentId) { this.commentId = commentId; }
	 */

	/**
	 * Gets the contact.
	 * 
	 * @return the contact
	 */
	public ContactEntity getContact() {
		return contact;
	}

	/**
	 * Sets the contact.
	 * 
	 * @param contact
	 *            the new contact
	 */
	public void setContact(ContactEntity contact) {
		this.contact = contact;
	}

	public List<AnamnesisEntity> getAnamnesisList() {
		Collections.reverse(this.anamnesisList);
		return anamnesisList;
	}

	public void setAnamnesisList(List<AnamnesisEntity> anamnesisList) {

		this.anamnesisList = anamnesisList;
	}
}

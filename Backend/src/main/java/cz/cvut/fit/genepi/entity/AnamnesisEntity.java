package cz.cvut.fit.genepi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

// TODO: Auto-generated Javadoc
/**
 * The Class AnamnesisEntity.
 */
@Entity
@Table(name = "ANAMNESIS")
public class AnamnesisEntity {

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

	/** The beginning epilepsy. */
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past
	@NotNull
	@Column(name = "BEGINNING_EPILEPSY", length = 7, nullable = true)
	private Date beginningEpilepsy;

	/** The first fever. */
	@Column(name = "FIRST_FEVER", precision = 1, scale = 0, nullable = true)
	private Boolean firstFever;

	/** The infantile spasm. */
	@Column(name = "INFANTILE_SPASM", precision = 1, scale = 0, nullable = true)
	private Boolean infantileSpasm;

	/** The specific syndrome idcom. */
	@Column(name = "SPECIFIC_SYNDROME_IDCOM", precision = 6, scale = 0, nullable = true)
	private int specificSyndromeIdcom;

	/** The epilepsy in family. */
	@Column(name = "EPILEPSY_IN_FAMILY", precision = 1, scale = 0, nullable = true)
	private Boolean epilepsyInFamily;

	/** The prenatal risk. */
	@Column(name = "PRENATAL_RISK", precision = 1, scale = 0, nullable = true)
	private Boolean prenatalRisk;

	/** The fibril convulsions. */
	@Column(name = "FIBRIL_CONVULSIONS", precision = 1, scale = 0, nullable = true)
	private Boolean fibrilConvulsions;

	/** The inflammation cns. */
	@Column(name = "INFLAMMATION_CNS", precision = 1, scale = 0, nullable = true)
	private Boolean inflammationCns;

	/** The injury cns. */
	@Column(name = "INJURY_CNS", precision = 1, scale = 0, nullable = true)
	private Boolean injuryCns;

	/** The operation cns. */
	@Column(name = "OPERATION_CNS", precision = 1, scale = 0, nullable = true)
	private Boolean operationCns;

	/** The early pmd retardation. */
	@Column(name = "EARLY_PMD_RETARDATION", precision = 1, scale = 0, nullable = true)
	private Boolean earlyPmdRetardation;

	/** The non cns comorbidity. */
	@Size(max = 400)
	@Column(name = "NON_CNS_COMORBIDITY", length = 400, nullable = true)
	private String nonCnsComorbidity;

	/** The comment. */
	@Size(max = 400)
	@Column(name = "COMMENT", length = 400, nullable = true)
	private String comment;

	/** The deleted. */
	@Column(name = "DELETED", precision = 1, scale = 0, nullable = true)
	private Boolean deleted;

	/** The patient id. */
	@NotNull
	@Column(name = "PATIENT_ID", precision = 6, scale = 0, nullable = false)
	private int patientId;

	/** The add user id. */
	@NotNull
	@Column(name = "ADD_USER_ID", precision = 6, scale = 0, nullable = false)
	private int addUserId;

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
	 * Gets the date.
	 * 
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 * 
	 * @param date
	 *            the new date
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * Gets the added.
	 * 
	 * @return the added
	 */
	public Date getAdded() {
		return added;
	}

	/**
	 * Sets the added.
	 * 
	 * @param added
	 *            the new added
	 */
	public void setAdded(Date added) {
		this.added = added;
	}

	/**
	 * Gets the beginning epilepsy.
	 * 
	 * @return the beginning epilepsy
	 */
	public Date getBeginningEpilepsy() {
		return beginningEpilepsy;
	}

	/**
	 * Sets the beginning epilepsy.
	 * 
	 * @param beginningEpilepsy
	 *            the new beginning epilepsy
	 */
	public void setBeginningEpilepsy(Date beginningEpilepsy) {
		this.beginningEpilepsy = beginningEpilepsy;
	}

	/**
	 * Gets the first fever.
	 * 
	 * @return the first fever
	 */
	public Boolean getFirstFever() {
		return firstFever;
	}

	/**
	 * Sets the first fever.
	 * 
	 * @param firstFever
	 *            the new first fever
	 */
	public void setFirstFever(Boolean firstFever) {
		this.firstFever = firstFever;
	}

	/**
	 * Gets the infantile spasm.
	 * 
	 * @return the infantile spasm
	 */
	public Boolean getInfantileSpasm() {
		return infantileSpasm;
	}

	/**
	 * Sets the infantile spasm.
	 * 
	 * @param infantileSpasm
	 *            the new infantile spasm
	 */
	public void setInfantileSpasm(Boolean infantileSpasm) {
		this.infantileSpasm = infantileSpasm;
	}

	/**
	 * Gets the specific syndrome idcom.
	 * 
	 * @return the specific syndrome idcom
	 */
	public int getSpecificSyndromeIdcom() {
		return specificSyndromeIdcom;
	}

	/**
	 * Sets the specific syndrome idcom.
	 * 
	 * @param specificSyndromeIdcom
	 *            the new specific syndrome idcom
	 */
	public void setSpecificSyndromeIdcom(int specificSyndromeIdcom) {
		this.specificSyndromeIdcom = specificSyndromeIdcom;
	}

	/**
	 * Gets the epilepsy in family.
	 * 
	 * @return the epilepsy in family
	 */
	public Boolean getEpilepsyInFamily() {
		return epilepsyInFamily;
	}

	/**
	 * Sets the epilepsy in family.
	 * 
	 * @param epilepsyInFamily
	 *            the new epilepsy in family
	 */
	public void setEpilepsyInFamily(Boolean epilepsyInFamily) {
		this.epilepsyInFamily = epilepsyInFamily;
	}

	/**
	 * Gets the prenatal risk.
	 * 
	 * @return the prenatal risk
	 */
	public Boolean getPrenatalRisk() {
		return prenatalRisk;
	}

	/**
	 * Sets the prenatal risk.
	 * 
	 * @param prenatalRisk
	 *            the new prenatal risk
	 */
	public void setPrenatalRisk(Boolean prenatalRisk) {
		this.prenatalRisk = prenatalRisk;
	}

	/**
	 * Gets the fibril convulsions.
	 * 
	 * @return the fibril convulsions
	 */
	public Boolean getFibrilConvulsions() {
		return fibrilConvulsions;
	}

	/**
	 * Sets the fibril convulsions.
	 * 
	 * @param fibrilConvulsions
	 *            the new fibril convulsions
	 */
	public void setFibrilConvulsions(Boolean fibrilConvulsions) {
		this.fibrilConvulsions = fibrilConvulsions;
	}

	/**
	 * Gets the inflammation cns.
	 * 
	 * @return the inflammation cns
	 */
	public Boolean getInflammationCns() {
		return inflammationCns;
	}

	/**
	 * Sets the inflammation cns.
	 * 
	 * @param inflammationCns
	 *            the new inflammation cns
	 */
	public void setInflammationCns(Boolean inflammationCns) {
		this.inflammationCns = inflammationCns;
	}

	/**
	 * Gets the injury cns.
	 * 
	 * @return the injury cns
	 */
	public Boolean getInjuryCns() {
		return injuryCns;
	}

	/**
	 * Sets the injury cns.
	 * 
	 * @param injuryCns
	 *            the new injury cns
	 */
	public void setInjuryCns(Boolean injuryCns) {
		this.injuryCns = injuryCns;
	}

	/**
	 * Gets the operation cns.
	 * 
	 * @return the operation cns
	 */
	public Boolean getOperationCns() {
		return operationCns;
	}

	/**
	 * Sets the operation cns.
	 * 
	 * @param operationCns
	 *            the new operation cns
	 */
	public void setOperationCns(Boolean operationCns) {
		this.operationCns = operationCns;
	}

	/**
	 * Gets the early pmd retardation.
	 * 
	 * @return the early pmd retardation
	 */
	public Boolean getEarlyPmdRetardation() {
		return earlyPmdRetardation;
	}

	/**
	 * Sets the early pmd retardation.
	 * 
	 * @param earlyPmdRetardation
	 *            the new early pmd retardation
	 */
	public void setEarlyPmdRetardation(Boolean earlyPmdRetardation) {
		this.earlyPmdRetardation = earlyPmdRetardation;
	}

	/**
	 * Gets the non cns comorbidity.
	 * 
	 * @return the non cns comorbidity
	 */
	public String getNonCnsComorbidity() {
		return nonCnsComorbidity;
	}

	/**
	 * Sets the non cns comorbidity.
	 * 
	 * @param nonCnsComorbidity
	 *            the new non cns comorbidity
	 */
	public void setNonCnsComorbidity(String nonCnsComorbidity) {
		this.nonCnsComorbidity = nonCnsComorbidity;
	}

	/**
	 * Gets the comment.
	 * 
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Sets the comment.
	 * 
	 * @param comment
	 *            the new comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
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
	 * Gets the patient id.
	 * 
	 * @return the patient id
	 */
	public int getpatientId() {
		return patientId;
	}

	/**
	 * Sets the patient id.
	 * 
	 * @param patientId
	 *            the new patient id
	 */
	public void setpatientId(int patientId) {
		this.patientId = patientId;
	}

	/**
	 * Gets the adds the user id.
	 * 
	 * @return the adds the user id
	 */
	public int getAddUserId() {
		return addUserId;
	}

	/**
	 * Sets the adds the user id.
	 * 
	 * @param addUserId
	 *            the new adds the user id
	 */
	public void setAddUserId(int addUserId) {
		this.addUserId = addUserId;
	}
}

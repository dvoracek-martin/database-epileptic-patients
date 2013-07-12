package cz.cvut.fit.genepi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ANAMNESIS")
public class AnamnesisEntity {

	@Id
	@Column(name = "ID", precision = 6, scale = 0, nullable = false)
	@GeneratedValue
	private int id;

	@Column(name = "DATE", length = 7, nullable = false)
	private Date date;

	@Column(name = "DOCTOR_ID", length = 6, nullable = true)
	private int doctorId;

	@Column(name = "ADDED", length = 7, nullable = false)
	private Date added;

	@Column(name = "BEGINNING_EPILEPSY", length = 7, nullable = true)
	private Date beginningEpilepsy;

	@Column(name = "FIRST_FEVER", precision = 1, scale = 0, nullable = true)
	private int firstFever;

	@Column(name = "INFANTILE_SPASM", precision = 1, scale = 0, nullable = true)
	private int infantileSpasm;

	@Column(name = "SPECIFIC_SYNDROME_IDCOM", precision = 6, scale = 0, nullable = true)
	private int specificSyndromeIdcom;

	@Column(name = "EPILEPSY_IN_FAMILY", precision = 1, scale = 0, nullable = true)
	private int epilepsyInFamily;

	@Column(name = "PRENATAL_RISK", precision = 1, scale = 0, nullable = true)
	private int prenatalRisk;

	@Column(name = "FIBRIL_CONVULSIONS", precision = 1, scale = 0, nullable = true)
	private int fibrilConvulsions;

	@Column(name = "INFLAMMATION_CNS", precision = 1, scale = 0, nullable = true)
	private int inflammationCns;

	@Column(name = "INJURY_CNS", precision = 1, scale = 0, nullable = true)
	private int injuryCns;

	@Column(name = "OPERATION_CNS", precision = 1, scale = 0, nullable = true)
	private int operationCns;

	@Column(name = "EARLY_PMD_RETARDATION", precision = 1, scale = 0, nullable = true)
	private int earlyPmdRetardation;

	@Column(name = "NON_CNS_COMORBIDITY", length = 400, nullable = true)
	private String nonCnsComorbidity;

	@Column(name = "COMMENT", length = 400, nullable = true)
	private String comment;

	@Column(name = "DELETED", precision = 4, scale = 0, nullable = true)
	private int deleted;

	@Column(name = "PATIENT_ID", precision = 6, scale = 0, nullable = true)
	private int patientId;

	@Column(name = "ADD_USER_ID", precision = 6, scale = 0, nullable = true)
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
	public int getFirstFever() {
		return firstFever;
	}

	/**
	 * Sets the first fever.
	 * 
	 * @param firstFever
	 *            the new first fever
	 */
	public void setFirstFever(int firstFever) {
		this.firstFever = firstFever;
	}

	/**
	 * Gets the infantile spasm.
	 * 
	 * @return the infantile spasm
	 */
	public int getInfantileSpasm() {
		return infantileSpasm;
	}

	/**
	 * Sets the infantile spasm.
	 * 
	 * @param infantileSpasm
	 *            the new infantile spasm
	 */
	public void setInfantileSpasm(int infantileSpasm) {
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
	public int getEpilepsyInFamily() {
		return epilepsyInFamily;
	}

	/**
	 * Sets the epilepsy in family.
	 * 
	 * @param epilepsyInFamily
	 *            the new epilepsy in family
	 */
	public void setEpilepsyInFamily(int epilepsyInFamily) {
		this.epilepsyInFamily = epilepsyInFamily;
	}

	/**
	 * Gets the prenatal risk.
	 * 
	 * @return the prenatal risk
	 */
	public int getPrenatalRisk() {
		return prenatalRisk;
	}

	/**
	 * Sets the prenatal risk.
	 * 
	 * @param prenatalRisk
	 *            the new prenatal risk
	 */
	public void setPrenatalRisk(int prenatalRisk) {
		this.prenatalRisk = prenatalRisk;
	}

	/**
	 * Gets the fibril convulsions.
	 * 
	 * @return the fibril convulsions
	 */
	public int getFibrilConvulsions() {
		return fibrilConvulsions;
	}

	/**
	 * Sets the fibril convulsions.
	 * 
	 * @param fibrilConvulsions
	 *            the new fibril convulsions
	 */
	public void setFibrilConvulsions(int fibrilConvulsions) {
		this.fibrilConvulsions = fibrilConvulsions;
	}

	/**
	 * Gets the inflammation cns.
	 * 
	 * @return the inflammation cns
	 */
	public int getInflammationCns() {
		return inflammationCns;
	}

	/**
	 * Sets the inflammation cns.
	 * 
	 * @param inflammationCns
	 *            the new inflammation cns
	 */
	public void setInflammationCns(int inflammationCns) {
		this.inflammationCns = inflammationCns;
	}

	/**
	 * Gets the injury cns.
	 * 
	 * @return the injury cns
	 */
	public int getInjuryCns() {
		return injuryCns;
	}

	/**
	 * Sets the injury cns.
	 * 
	 * @param injuryCns
	 *            the new injury cns
	 */
	public void setInjuryCns(int injuryCns) {
		this.injuryCns = injuryCns;
	}

	/**
	 * Gets the operation cns.
	 * 
	 * @return the operation cns
	 */
	public int getOperationCns() {
		return operationCns;
	}

	/**
	 * Sets the operation cns.
	 * 
	 * @param operationCns
	 *            the new operation cns
	 */
	public void setOperationCns(int operationCns) {
		this.operationCns = operationCns;
	}

	/**
	 * Gets the early pmd retardation.
	 * 
	 * @return the early pmd retardation
	 */
	public int getEarlyPmdRetardation() {
		return earlyPmdRetardation;
	}

	/**
	 * Sets the early pmd retardation.
	 * 
	 * @param earlyPmdRetardation
	 *            the new early pmd retardation
	 */
	public void setEarlyPmdRetardation(int earlyPmdRetardation) {
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
	public int getDeleted() {
		return deleted;
	}

	/**
	 * Sets the deleted.
	 * 
	 * @param deleted
	 *            the new deleted
	 */
	public void setDeleted(int deleted) {
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

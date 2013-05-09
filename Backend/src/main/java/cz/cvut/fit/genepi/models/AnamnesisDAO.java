package cz.cvut.fit.genepi.models;

import java.util.Date;

public class AnamnesisDAO implements java.io.Serializable {

	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = -1173307981642255468L;

	private int id;
	private Date date;
	private int doctorId;
	private int added;
	private Date beginningEpilepsy;
	private int firstFever;
	private int infantileSpasm;
	private int specificSyndromeIdcom;
	private int epilepsyInFamily;
	private int prenatalRisk;
	private int fibrilConvulsions;
	private int inflammationCns;
	private int injuryCns;
	private int operationCns;
	private int earlyPmdRetardation;
	private String nonCnsComorbidity;
	private String comment;
	private int deleted;
	private int patientId;
	private int addUserId;

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

	public int getAdded() {
		return added;
	}

	public void setAdded(int added) {
		this.added = added;
	}

	public Date getBeginningEpilepsy() {
		return beginningEpilepsy;
	}

	public void setBeginningEpilepsy(Date beginningEpilepsy) {
		this.beginningEpilepsy = beginningEpilepsy;
	}

	public int getFirstFever() {
		return firstFever;
	}

	public void setFirstFever(int firstFever) {
		this.firstFever = firstFever;
	}

	public int getInfantileSpasm() {
		return infantileSpasm;
	}

	public void setInfantileSpasm(int infantileSpasm) {
		this.infantileSpasm = infantileSpasm;
	}

	public int getSpecificSyndromeIdcom() {
		return specificSyndromeIdcom;
	}

	public void setSpecificSyndromeIdcom(int specificSyndromeIdcom) {
		this.specificSyndromeIdcom = specificSyndromeIdcom;
	}

	public int getEpilepsyInFamily() {
		return epilepsyInFamily;
	}

	public void setEpilepsyInFamily(int epilepsyInFamily) {
		this.epilepsyInFamily = epilepsyInFamily;
	}

	public int getPrenatalRisk() {
		return prenatalRisk;
	}

	public void setPrenatalRisk(int prenatalRisk) {
		this.prenatalRisk = prenatalRisk;
	}

	public int getFibrilConvulsions() {
		return fibrilConvulsions;
	}

	public void setFibrilConvulsions(int fibrilConvulsions) {
		this.fibrilConvulsions = fibrilConvulsions;
	}

	public int getInflammationCns() {
		return inflammationCns;
	}

	public void setInflammationCns(int inflammationCns) {
		this.inflammationCns = inflammationCns;
	}

	public int getInjuryCns() {
		return injuryCns;
	}

	public void setInjuryCns(int injuryCns) {
		this.injuryCns = injuryCns;
	}

	public int getOperationCns() {
		return operationCns;
	}

	public void setOperationCns(int operationCns) {
		this.operationCns = operationCns;
	}

	public int getEarlyPmdRetardation() {
		return earlyPmdRetardation;
	}

	public void setEarlyPmdRetardation(int earlyPmdRetardation) {
		this.earlyPmdRetardation = earlyPmdRetardation;
	}

	public String getNonCnsComorbidity() {
		return nonCnsComorbidity;
	}

	public void setNonCnsComorbidity(String nonCnsComorbidity) {
		this.nonCnsComorbidity = nonCnsComorbidity;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public int getpatientId() {
		return patientId;
	}

	public void setpatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getAddUserId() {
		return addUserId;
	}

	public void setAddUserId(int addUserId) {
		this.addUserId = addUserId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public AnamnesisDAO() {
	}

	public AnamnesisDAO(int id, Date date, int doctorId, int added,
			Date beginningEpilepsy, int firstFever, int infantileSpasm,
			int specificSyndromeIdcom, int epilepsyInFamily, int prenatalRisk,
			int fibrilConvulsions, int inflammationCns, int injuryCns,
			int operationCns, int earlyPmdRetardation,
			String nonCnsComorbidity, String comment, int deleted,
			int patientId, int addUserId) {

		this.id = id;
		this.date = date;
		this.doctorId = doctorId;
		this.added = added;
		this.beginningEpilepsy = beginningEpilepsy;
		this.firstFever = firstFever;
		this.infantileSpasm = infantileSpasm;
		this.specificSyndromeIdcom = specificSyndromeIdcom;
		this.epilepsyInFamily = epilepsyInFamily;
		this.prenatalRisk = prenatalRisk;
		this.fibrilConvulsions = fibrilConvulsions;
		this.inflammationCns = inflammationCns;
		this.injuryCns = injuryCns;
		this.operationCns = operationCns;
		this.earlyPmdRetardation = earlyPmdRetardation;
		this.nonCnsComorbidity = nonCnsComorbidity;
		this.comment = comment;
		this.deleted = deleted;
		this.patientId = patientId;
		this.addUserId = addUserId;
	}

}
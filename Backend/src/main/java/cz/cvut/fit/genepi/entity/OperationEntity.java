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
@Table(name = "OPERATION")
public class OperationEntity {
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
	
	@Column(name="type_operations_idcom")
	private int typeOperationsIdcom;
	
	@Column(name="range_operations_idcom")
	private int rangeOperationsIdcom;
	
	@Column(name="localization_operations")
	private String localizationOperations;
	
	@Column(name="mst")
	private Boolean mst;
	
	@Column(name="kalostomie")
	private Boolean kalostomie;
	
	@Column(name="vns")
	private Boolean vns;
	
	@Column(name="VNS_implantation_date")
	private Date VNSImplantationDate;
	
	@Column(name="operation_details")
	private String operationDetails;
	
	@Column(name="complete resection")
	private Boolean completeResection;
	
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

	public int getTypeOperationsIdcom() {
		return typeOperationsIdcom;
	}

	public void setTypeOperationsIdcom(int typeOperationsIdcom) {
		this.typeOperationsIdcom = typeOperationsIdcom;
	}

	public int getRangeOperationsIdcom() {
		return rangeOperationsIdcom;
	}

	public void setRangeOperationsIdcom(int rangeOperationsIdcom) {
		this.rangeOperationsIdcom = rangeOperationsIdcom;
	}

	public String getLocalizationOperations() {
		return localizationOperations;
	}

	public void setLocalizationOperations(String localizationOperations) {
		this.localizationOperations = localizationOperations;
	}

	public Boolean getMst() {
		return mst;
	}

	public void setMst(Boolean mst) {
		this.mst = mst;
	}

	public Boolean getKalostomie() {
		return kalostomie;
	}

	public void setKalostomie(Boolean kalostomie) {
		this.kalostomie = kalostomie;
	}

	public Boolean getVns() {
		return vns;
	}

	public void setVns(Boolean vns) {
		this.vns = vns;
	}

	public Date getVNSImplantationDate() {
		return VNSImplantationDate;
	}

	public void setVNSImplantationDate(Date vNSImplantationDate) {
		VNSImplantationDate = vNSImplantationDate;
	}

	public String getOperationDetails() {
		return operationDetails;
	}

	public void setOperationDetails(String operationDetails) {
		this.operationDetails = operationDetails;
	}

	public Boolean getCompleteResection() {
		return completeResection;
	}

	public void setCompleteResection(Boolean completeResection) {
		this.completeResection = completeResection;
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

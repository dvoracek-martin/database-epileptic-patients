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

@Entity
@Table(name = "operation")
public class OperationEntity implements Comparable<OperationEntity> {

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

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past
	@NotNull
	@Column(name = "date_operation", nullable = false)
	private Date dateOperation;

	@Column(name = "type_operation")
	private int typeOperation;

	@Column(name = "range_operation")
	private int rangeOperation;

	@Size(max = 800)
	@Column(name = "localization_operation", length = 800)
	private String localizationOperation;

	@Column(name = "mst")
	private boolean mst;

	@Column(name = "colostomy")
	private boolean colostomy;

	@Column(name = "vns")
	private boolean vns;

	@Column(name = "vns_implantation_date")
	private Date VNSImplantationDate;

	@Size(max = 800)
	@Column(name = "operation_details", length = 800)
	private String operationDetails;

	@Column(name = "complete_resection")
	private boolean completeResection;

	/** The comment. */
	@Size(max = 800)
	@Column(name = "comment", length = 800, nullable = true)
	private String comment;

	@Override
	public int compareTo(OperationEntity o) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public int getTypeOperation() {
		return typeOperation;
	}

	public void setTypeOperation(int typeOperation) {
		this.typeOperation = typeOperation;
	}

	public int getRangeOperation() {
		return rangeOperation;
	}

	public void setRangeOperation(int rangeOperation) {
		this.rangeOperation = rangeOperation;
	}

	public String getLocalizationOperation() {
		return localizationOperation;
	}

	public void setLocalizationOperation(String localizationOperation) {
		this.localizationOperation = localizationOperation;
	}

	public boolean isMst() {
		return mst;
	}

	public void setMst(boolean mst) {
		this.mst = mst;
	}

	public boolean isColostomy() {
		return colostomy;
	}

	public void setColostomy(boolean colostomy) {
		this.colostomy = colostomy;
	}

	public boolean isVns() {
		return vns;
	}

	public void setVns(boolean vns) {
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

	public boolean isCompleteResection() {
		return completeResection;
	}

	public void setCompleteResection(boolean completeResection) {
		this.completeResection = completeResection;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}

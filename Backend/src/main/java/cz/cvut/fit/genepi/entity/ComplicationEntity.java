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
@Table(name = "COMPLICATION")
public class ComplicationEntity {
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

	@Column(name = "complication_idcom")
	private int complicationIdcom;
	
	@Column(name = "comment")
	private String comment;
	
	@Column(name = "deleted")
	private Boolean deleted;
	
	@NotNull
	@Column(name = "ADD_USER_ID", precision = 6, scale = 0, nullable = false)
	private int addUserId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;
}

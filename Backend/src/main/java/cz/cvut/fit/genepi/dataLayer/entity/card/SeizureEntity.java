package cz.cvut.fit.genepi.dataLayer.entity.card;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class SeizureEntity.
 */
@Entity
@Table(name = "seizure")
public class SeizureEntity implements Comparable<SeizureEntity> {

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

	/** The seizure frequency idcom. */
	@Column(name = "seizure_frequency")
	private int seizureFrequency;

	/** The secondarily generalized seizure. */
	@Column(name = "secondarily_generalized_seizure")
	private boolean secondarilyGeneralizedSeizure;

	/** The status epilepticus. */
	@Column(name = "status_epilepticus")
	private boolean statusEpilepticus;

	/** The status epilepticus. */
	@Column(name = "nonepileptic_seizures")
	private boolean nonepilepticSeizures;

	/** The seizures while awake epi. */
	@Column(name = "seizures_while_awake")
	private int seizuresWhileAwake;

	/** The seizures while sleep epi. */
	@Column(name = "seizures_while_sleep")
	private int seizuresWhileSleep;

	/** The seizures while sleep epi. */
	@Column(name = "seizures_while_both")
	private int seizuresWhileBoth;

	/** The comment. */
	@Size(max = 800)
	@Column(name = "comment", length = 800, nullable = true)
	private String comment;

	/* Relations */

	@OneToMany(fetch = FetchType.EAGER)
	private List<SeizureDetailEntity> seizureDetailList;

	@Override
	public int compareTo(SeizureEntity o) {
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

	public int getSeizureFrequency() {
		return seizureFrequency;
	}

	public void setSeizureFrequency(int seizureFrequency) {
		this.seizureFrequency = seizureFrequency;
	}

	public boolean isSecondarilyGeneralizedSeizure() {
		return secondarilyGeneralizedSeizure;
	}

	public void setSecondarilyGeneralizedSeizure(
			boolean secondarilyGeneralizedSeizure) {
		this.secondarilyGeneralizedSeizure = secondarilyGeneralizedSeizure;
	}

	public boolean isStatusEpilepticus() {
		return statusEpilepticus;
	}

	public void setStatusEpilepticus(boolean statusEpilepticus) {
		this.statusEpilepticus = statusEpilepticus;
	}

	public boolean isNonepilepticSeizures() {
		return nonepilepticSeizures;
	}

	public void setNonepilepticSeizures(boolean nonepilepticSeizures) {
		this.nonepilepticSeizures = nonepilepticSeizures;
	}

	public int getSeizuresWhileAwake() {
		return seizuresWhileAwake;
	}

	public void setSeizuresWhileAwake(int seizuresWhileAwake) {
		this.seizuresWhileAwake = seizuresWhileAwake;
	}

	public int getSeizuresWhileSleep() {
		return seizuresWhileSleep;
	}

	public void setSeizuresWhileSleep(int seizuresWhileSleep) {
		this.seizuresWhileSleep = seizuresWhileSleep;
	}

	public int getSeizuresWhileBoth() {
		return seizuresWhileBoth;
	}

	public void setSeizuresWhileBoth(int seizuresWhileBoth) {
		this.seizuresWhileBoth = seizuresWhileBoth;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<SeizureDetailEntity> getSeizureDetailList() {
		return seizureDetailList;
	}

	public void setSeizureDetailList(List<SeizureDetailEntity> seizureDetailList) {
		this.seizureDetailList = seizureDetailList;
	}
}

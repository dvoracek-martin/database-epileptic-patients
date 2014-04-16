package cz.cvut.fit.genepi.dataLayer.entity.card;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The Class SeizureEntity.
 */
@Entity
@Table(name = "seizure")
public class SeizureEntity implements Comparable<SeizureEntity> {

	/* Autofilled fields */

    /**
     * The id.
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private int id;

    /**
     * The add user id.
     */
    @Column(name = "add_user_id", nullable = false)
    private int addUserId;

    /**
     * The added.
     */
    @Column(name = "added", nullable = false, insertable = false)
    private Date added;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    private PatientEntity patient;

    @Column(name = "patient_id", nullable = false)
    private int patientId;

    @Column(name = "history", nullable = false)
    private boolean history;

    @Column(name = "hidden", nullable = false)
    private boolean hidden;

	/* Other fields */

    /**
     * The date.
     */
    @Column(name = "date", nullable = false)
    private Date date;

    /**
     * The seizure frequency idcom.
     */
    @Column(name = "seizure_frequency")
    private int seizureFrequency;

    /**
     * The secondarily generalized seizure.
     */
    @Column(name = "secondarily_generalized_seizure")
    private boolean secondarilyGeneralizedSeizure;

    /**
     * The status epilepticus.
     */
    @Column(name = "status_epilepticus")
    private boolean statusEpilepticus;

    /**
     * The status epilepticus.
     */
    @Column(name = "nonepileptic_seizures")
    private boolean nonepilepticSeizures;

    /** The seizures while awake epi. */
//	@Column(name = "seizures_while_awake")
//	private int seizuresWhileAwake;

    /** The seizures while sleep epi. */
//	@Column(name = "seizures_while_sleep")
//	private int seizuresWhileSleep;

    /**
     * The seizures while sleep epi.
     */
//	@Column(name = "seizures_while_both")
//	private int seizuresWhileBoth;

    @Column(name = "seizure_occurrence")
    private int seizureOccurrence;

    /**
     * The comment.
     */
    @Column(name = "comment", length = 800, nullable = true)
    private String comment;

	/* Relations */

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "seizure")
    private List<SeizureDetailEntity> seizureDetailList;

    @Override
    public int compareTo(SeizureEntity o) {
        int dateComparison = this.date.compareTo(o.getDate());
        int idComparison = this.id - o.getId();
        if (dateComparison > 0) {
            return -1;
        } else if (dateComparison == 0) {
            if (idComparison < 0) {
                return 1;
            } else {
                return -1;
            }
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

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public boolean isHistory() {
        return history;
    }

    public void setHistory(boolean history) {
        this.history = history;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean status) {
        this.hidden = status;
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

    public int getSeizureOccurrence() {
        return seizureOccurrence;
    }

    public void setSeizureOccurrence(int seizureOccurrence) {
        this.seizureOccurrence = seizureOccurrence;
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
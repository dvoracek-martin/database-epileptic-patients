package cz.cvut.fit.genepi.dataLayer.entity.card;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "seizure_detail")
public class SeizureDetailEntity implements Comparable<SeizureDetailEntity> {

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seizure_id", insertable = false, updatable = false)
    private SeizureEntity seizure;

    @Column(name = "seizure_id", nullable = false)
    private int seizureId;

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

    @Column(name = "ssc_classification", nullable = true)
    private int sscClassification;

    @Column(name = "ilae_classification", nullable = true)
    private int ilaeClassification;

    /**
     * The comment.
     */
    @Column(name = "comment", length = 800, nullable = true)
    private String comment;

    @Override
    public int compareTo(SeizureDetailEntity o) {
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

    public int getSscClassification() {
        return sscClassification;
    }

    public void setSscClassification(int sscClassification) {
        this.sscClassification = sscClassification;
    }

    public int getIlaeClassification() {
        return ilaeClassification;
    }

    public void setIlaeClassification(int ilaeClassification) {
        this.ilaeClassification = ilaeClassification;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public SeizureEntity getSeizure() {
        return seizure;
    }

    public void setSeizure(SeizureEntity seizure) {
        this.seizure = seizure;
    }

    public int getSeizureId() {
        return seizureId;
    }

    public void setSeizureId(int seizureId) {
        this.seizureId = seizureId;
    }
}

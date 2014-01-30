package cz.cvut.fit.genepi.dataLayer.entity.card;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "histology")
public class HistologyEntity implements Comparable<HistologyEntity> {

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

    @Column(name = "status", nullable = false)
    private int status;

	/* Other fields */

    /**
     * The date.
     */
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "histopathology")
    private int histopathology;

    @Column(name = "fcd_classification")
    private int fcdClassification;

    /**
     * The comment.
     */
    @Column(name = "comment", length = 800, nullable = true)
    private String comment;

    @Override
    public int compareTo(HistologyEntity o) {
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

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getFcdClassification() {
        return fcdClassification;
    }

    public void setFcdClassification(int fcdClassification) {
        this.fcdClassification = fcdClassification;
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

    public int getHistopathology() {
        return histopathology;
    }

    public void setHistopathology(int histopathology) {
        this.histopathology = histopathology;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

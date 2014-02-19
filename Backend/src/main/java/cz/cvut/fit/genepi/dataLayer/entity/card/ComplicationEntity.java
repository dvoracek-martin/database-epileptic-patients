package cz.cvut.fit.genepi.dataLayer.entity.card;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "complication")
public class ComplicationEntity implements Comparable<ComplicationEntity> {

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

    @Column(name = "with_complication", nullable = false)
    private int withComplication;

    @Column(name = "complication_type")
    private int complicationType;

    @Column(name = "complication")
    private int complication;

    /**
     * The comment.
     */
    @Column(name = "comment")
    private String comment;

    @Override
    public int compareTo(ComplicationEntity o) {
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

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getWithComplication() {
        return withComplication;
    }

    public void setWithComplication(int withComplication) {
        this.withComplication = withComplication;
    }

    public int getComplicationType() {
        return complicationType;
    }

    public void setComplicationType(int complicationType) {
        this.complicationType = complicationType;
    }

    public int getComplication() {
        return complication;
    }

    public void setComplication(int complication) {
        this.complication = complication;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

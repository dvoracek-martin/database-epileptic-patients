package cz.cvut.fit.genepi.dataLayer.entity.card;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "invasive_test_ecog")
public class InvasiveTestECOGEntity implements
        Comparable<InvasiveTestECOGEntity> {

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
    @NotNull
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
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Past
    @NotNull
    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "done")
    private boolean done;

    @Size(max = 800)
    @Column(name = "ecog_cover", length = 800)
    private String ecogCover;

    @Column(name = "ecog_patterns")
    private int ecogPatterns;

    @Column(name = "after_resection_ecog")
    private int afterResectionEcog;

    /**
     * The comment.
     */
    @Size(max = 800)
    @Column(name = "comment", length = 800, nullable = true)
    private String comment;

    @Override
    public int compareTo(InvasiveTestECOGEntity o) {
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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getEcogCover() {
        return ecogCover;
    }

    public void setEcogCover(String ecogCover) {
        this.ecogCover = ecogCover;
    }

    public int getEcogPatterns() {
        return ecogPatterns;
    }

    public void setEcogPatterns(int ecogPatterns) {
        this.ecogPatterns = ecogPatterns;
    }

    public int getAfterResectionEcog() {
        return afterResectionEcog;
    }

    public void setAfterResectionEcog(int afterResectionEcog) {
        this.afterResectionEcog = afterResectionEcog;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

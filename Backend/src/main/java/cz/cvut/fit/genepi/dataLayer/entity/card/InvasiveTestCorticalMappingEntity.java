package cz.cvut.fit.genepi.dataLayer.entity.card;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "invasive_test_cortical_mapping")
public class InvasiveTestCorticalMappingEntity implements
        Comparable<InvasiveTestCorticalMappingEntity> {

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

    @Column(name = "done")
    private int done;

    @Column(name = "cortical_mapping")
    private int corticalMapping;

    /**
     * The comment.
     */
    @Column(name = "comment", length = 800, nullable = true)
    private String comment;

    @Override
    public int compareTo(InvasiveTestCorticalMappingEntity o) {
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

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public int getCorticalMapping() {
        return corticalMapping;
    }

    public void setCorticalMapping(int corticalMapping) {
        this.corticalMapping = corticalMapping;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

package cz.cvut.fit.genepi.dataLayer.entity.card;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "neurological_finding")
public class NeurologicalFindingEntity
        implements Comparable<NeurologicalFindingEntity> {

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

    @Column(name = "hemisphere_dominance")
    private int hemisphereDominance;

    @Column(name = "abnormal_neurological_finding")
    private boolean abnormalNeurologicalFinding;

    @Column(name = "hemiparesis")
    private boolean hemiparesis;

    @Column(name = "visual_field_defects")
    private boolean visualFieldDefects;

    /**
     * The comment.
     */

    @Column(name = "comment", nullable = true)
    private String comment;

    @Override
    public int compareTo(NeurologicalFindingEntity o) {
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

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean isHistory() {
        return history;
    }

    public void setHistory(boolean history) {
        this.history = history;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getHemisphereDominance() {
        return hemisphereDominance;
    }

    public void setHemisphereDominance(int hemisphereDominance) {
        this.hemisphereDominance = hemisphereDominance;
    }

    public boolean isAbnormalNeurologicalFinding() {
        return abnormalNeurologicalFinding;
    }

    public void setAbnormalNeurologicalFinding(boolean abnormalNeurologicalFinding) {
        this.abnormalNeurologicalFinding = abnormalNeurologicalFinding;
    }

    public boolean isHemiparesis() {
        return hemiparesis;
    }

    public void setHemiparesis(boolean hemiparesis) {
        this.hemiparesis = hemiparesis;
    }

    public boolean isVisualFieldDefects() {
        return visualFieldDefects;
    }

    public void setVisualFieldDefects(boolean visualFieldDefects) {
        this.visualFieldDefects = visualFieldDefects;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

package cz.cvut.fit.genepi.dataLayer.entity.card;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

import javax.persistence.*;
import java.util.Date;

//TODO: Merge with pszchology NEW??
@Entity
@Table(name = "neuropsychology_old")
public class NeuropsychologyOldEntity implements Comparable<NeuropsychologyOldEntity> {

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

    @Column(name = "intelligence_level")
    private int intelligenceLevel;

    @Column(name = "neuropsychological_examination")
    private boolean neuropsychologicalExamination;

    @Column(name = "specific_learning")
    private boolean specificLearning;

    @Column(name = "developmental_language_disorders")
    private boolean developmentalLanguageDisorders;

    @Column(name = "adhd_syndrome")
    private boolean adhdSyndrome;

    /**
     * The comment.
     */
    @Column(name = "comment", length = 800, nullable = true)
    private String comment;

    @Override
    public int compareTo(NeuropsychologyOldEntity o) {
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public boolean isNeuropsychologicalExamination() {
        return neuropsychologicalExamination;
    }

    public void setNeuropsychologicalExamination(
            boolean neuropsychologicalExamination) {
        this.neuropsychologicalExamination = neuropsychologicalExamination;
    }

    public int getIntelligenceLevel() {
        return intelligenceLevel;
    }

    public void setIntelligenceLevel(int intelligenceLevel) {
        this.intelligenceLevel = intelligenceLevel;
    }

    public boolean isSpecificLearning() {
        return specificLearning;
    }

    public void setSpecificLearning(boolean specificLearning) {
        this.specificLearning = specificLearning;
    }

    public boolean isDevelopmentalLanguageDisorders() {
        return developmentalLanguageDisorders;
    }

    public void setDevelopmentalLanguageDisorders(
            boolean developmentalLanguageDisorders) {
        this.developmentalLanguageDisorders = developmentalLanguageDisorders;
    }

    public boolean isAdhdSyndrome() {
        return adhdSyndrome;
    }

    public void setAdhdSyndrome(boolean adhdSyndrome) {
        this.adhdSyndrome = adhdSyndrome;
    }
}

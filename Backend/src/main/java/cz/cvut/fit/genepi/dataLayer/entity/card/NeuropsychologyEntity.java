package cz.cvut.fit.genepi.dataLayer.entity.card;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "neuropsychology")
public class NeuropsychologyEntity implements Comparable<NeuropsychologyEntity> {

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

    @Column(name = "intellect", nullable = false)
    private int intellect;

    @Column(name = "neurodevelopmental_examination", nullable = false)
    private int neurodevelopmentalExamination;

    @Column(name = "neurodevelopmental_examination_adaptability", nullable = false)
    private int neurodevelopmentalExaminationAdaptability;

    @Column(name = "neurodevelopmental_examination_speech_expressively", nullable = false)
    private int neurodevelopmentalExaminationSpeechExpressively;

    @Column(name = "neurodevelopmental_examination_speech_receptively", nullable = false)
    private int neurodevelopmentalExaminationSpeechReceptively;

    @Column(name = "neurodevelopmental_examination_fine_motor_skills", nullable = false)
    private int neurodevelopmentalExaminationFineMotorSkills;

    @Column(name = "neurodevelopmental_examination_gross_motor_skills", nullable = false)
    private int neurodevelopmentalExaminationGrossMotorSkills;

    @Column(name = "neurodevelopmental_examination_social_behavior", nullable = false)
    private int neurodevelopmentalExaminationSocialBehavior;

    @Column(name = "intellectual_performance", nullable = false)
    private int intellectualPerformance;

    @Column(name = "intellectual_performance_verbally", nullable = false)
    private int intellectualPerformanceVerbally;

    @Column(name = "intellectual_performance_nonverbal_abstraction", nullable = false)
    private int intellectualPerformanceNonverbalAbstraction;

    @Column(name = "intellectual_performance_nonverbal_design_capabilities", nullable = false)
    private int intellectualPerformanceNonverbalDesignCapabilities;

    @Column(name = "neuropsychological_profile", nullable = false)
    private int neuropsychologicalProfile;

    @Column(name = "neuropsychological_profile_attention", nullable = false)
    private int neuropsychologicalProfileAttention;

    @Column(name = "neuropsychological_profile_executive_function", nullable = false)
    private int neuropsychologicalProfileExecutiveFunction;

    @Column(name = "neuropsychological_profile_cognitive_speed", nullable = false)
    private int neuropsychologicalProfileCognitiveSpeed;

    @Column(name = "neuropsychological_profile_speech_expressively", nullable = false)
    private int neuropsychologicalProfileSpeechExpressively;

    @Column(name = "neuropsychological_profile_speech_understanding", nullable = false)
    private int neuropsychologicalProfileSpeechUnderstanding;

    @Column(name = "neuropsychological_profile_memory_operating", nullable = false)
    private int neuropsychologicalProfileMemoryOperating;

    @Column(name = "neuropsychological_profile_memory_verbal", nullable = false)
    private int neuropsychologicalProfileMemoryVerbal;

    @Column(name = "neuropsychological_profile_memory_nonverbal", nullable = false)
    private int neuropsychologicalProfileMemoryNonverbal;

    @Column(name = "neuropsychological_profile_memory_learning", nullable = false)
    private int neuropsychologicalProfileMemoryLearning;

    @Column(name = "neuropsychological_profile_perception_speech", nullable = false)
    private int neuropsychologicalProfilePerceptionSpeech;

    @Column(name = "neuropsychological_profile_perception_visual", nullable = false)
    private int neuropsychologicalProfilePerceptionVisual;

    @Column(name = "neuropsychological_profile_perception_spatial", nullable = false)
    private int neuropsychologicalProfilePerceptionSpatial;

    @Column(name = "neuropsychological_profile_motor_skills_dexterity", nullable = false)
    private int neuropsychologicalProfileMotorSkillsDexterity;

    @Column(name = "neuropsychological_profile_motor_coordination", nullable = false)
    private int neuropsychologicalProfileMotorCoordination;

    @Column(name = "presence_of_changes", nullable = false)
    private int presenceOfChanges;

    @Column(name = "presence_of_changes_detail", nullable = false)
    private String presenceOfChangesDetail;

    @Column(name = "emotional_status", nullable = false)
    private int emotionalStatus;

    @Column(name = "comment", nullable = false)
    private String comment;

    @Override
    public int compareTo(NeuropsychologyEntity o) {
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

    public int getIntellect() {
        return intellect;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public int getNeurodevelopmentalExamination() {
        return neurodevelopmentalExamination;
    }

    public void setNeurodevelopmentalExamination(int neurodevelopmentalExamination) {
        this.neurodevelopmentalExamination = neurodevelopmentalExamination;
    }

    public int getNeurodevelopmentalExaminationAdaptability() {
        return neurodevelopmentalExaminationAdaptability;
    }

    public void setNeurodevelopmentalExaminationAdaptability(
            int neurodevelopmentalExaminationAdaptability) {
        this.neurodevelopmentalExaminationAdaptability = neurodevelopmentalExaminationAdaptability;
    }

    public int getNeurodevelopmentalExaminationSpeechExpressively() {
        return neurodevelopmentalExaminationSpeechExpressively;
    }

    public void setNeurodevelopmentalExaminationSpeechExpressively(
            int neurodevelopmentalExaminationSpeechExpressively) {
        this.neurodevelopmentalExaminationSpeechExpressively = neurodevelopmentalExaminationSpeechExpressively;
    }

    public int getNeurodevelopmentalExaminationSpeechReceptively() {
        return neurodevelopmentalExaminationSpeechReceptively;
    }

    public void setNeurodevelopmentalExaminationSpeechReceptively(
            int neurodevelopmentalExaminationSpeechReceptively) {
        this.neurodevelopmentalExaminationSpeechReceptively = neurodevelopmentalExaminationSpeechReceptively;
    }

    public int getNeurodevelopmentalExaminationFineMotorSkills() {
        return neurodevelopmentalExaminationFineMotorSkills;
    }

    public void setNeurodevelopmentalExaminationFineMotorSkills(
            int neurodevelopmentalExaminationFineMotorSkills) {
        this.neurodevelopmentalExaminationFineMotorSkills = neurodevelopmentalExaminationFineMotorSkills;
    }

    public int getNeurodevelopmentalExaminationGrossMotorSkills() {
        return neurodevelopmentalExaminationGrossMotorSkills;
    }

    public void setNeurodevelopmentalExaminationGrossMotorSkills(
            int neurodevelopmentalExaminationGrossMotorSkills) {
        this.neurodevelopmentalExaminationGrossMotorSkills = neurodevelopmentalExaminationGrossMotorSkills;
    }

    public int getNeurodevelopmentalExaminationSocialBehavior() {
        return neurodevelopmentalExaminationSocialBehavior;
    }

    public void setNeurodevelopmentalExaminationSocialBehavior(
            int neurodevelopmentalExaminationSocialBehavior) {
        this.neurodevelopmentalExaminationSocialBehavior = neurodevelopmentalExaminationSocialBehavior;
    }

    public int getIntellectualPerformance() {
        return intellectualPerformance;
    }

    public void setIntellectualPerformance(int intellectualPerformance) {
        this.intellectualPerformance = intellectualPerformance;
    }

    public int getIntellectualPerformanceVerbally() {
        return intellectualPerformanceVerbally;
    }

    public void setIntellectualPerformanceVerbally(
            int intellectualPerformanceVerbally) {
        this.intellectualPerformanceVerbally = intellectualPerformanceVerbally;
    }

    public int getIntellectualPerformanceNonverbalAbstraction() {
        return intellectualPerformanceNonverbalAbstraction;
    }

    public void setIntellectualPerformanceNonverbalAbstraction(
            int intellectualPerformanceNonverbalAbstraction) {
        this.intellectualPerformanceNonverbalAbstraction = intellectualPerformanceNonverbalAbstraction;
    }

    public int getIntellectualPerformanceNonverbalDesignCapabilities() {
        return intellectualPerformanceNonverbalDesignCapabilities;
    }

    public void setIntellectualPerformanceNonverbalDesignCapabilities(
            int intellectualPerformanceNonverbalDesignCapabilities) {
        this.intellectualPerformanceNonverbalDesignCapabilities = intellectualPerformanceNonverbalDesignCapabilities;
    }

    public int getNeuropsychologicalProfile() {
        return neuropsychologicalProfile;
    }

    public void setNeuropsychologicalProfile(int neuropsychologicalProfile) {
        this.neuropsychologicalProfile = neuropsychologicalProfile;
    }

    public int getNeuropsychologicalProfileAttention() {
        return neuropsychologicalProfileAttention;
    }

    public void setNeuropsychologicalProfileAttention(
            int neuropsychologicalProfileAttention) {
        this.neuropsychologicalProfileAttention = neuropsychologicalProfileAttention;
    }

    public int getNeuropsychologicalProfileExecutiveFunction() {
        return neuropsychologicalProfileExecutiveFunction;
    }

    public void setNeuropsychologicalProfileExecutiveFunction(
            int neuropsychologicalProfileExecutiveFunction) {
        this.neuropsychologicalProfileExecutiveFunction = neuropsychologicalProfileExecutiveFunction;
    }

    public int getNeuropsychologicalProfileCognitiveSpeed() {
        return neuropsychologicalProfileCognitiveSpeed;
    }

    public void setNeuropsychologicalProfileCognitiveSpeed(
            int neuropsychologicalProfileCognitiveSpeed) {
        this.neuropsychologicalProfileCognitiveSpeed = neuropsychologicalProfileCognitiveSpeed;
    }

    public int getNeuropsychologicalProfileSpeechExpressively() {
        return neuropsychologicalProfileSpeechExpressively;
    }

    public void setNeuropsychologicalProfileSpeechExpressively(
            int neuropsychologicalProfileSpeechExpressively) {
        this.neuropsychologicalProfileSpeechExpressively = neuropsychologicalProfileSpeechExpressively;
    }

    public int getNeuropsychologicalProfileSpeechUnderstanding() {
        return neuropsychologicalProfileSpeechUnderstanding;
    }

    public void setNeuropsychologicalProfileSpeechUnderstanding(
            int neuropsychologicalProfileSpeechUnderstanding) {
        this.neuropsychologicalProfileSpeechUnderstanding = neuropsychologicalProfileSpeechUnderstanding;
    }

    public int getNeuropsychologicalProfileMemoryOperating() {
        return neuropsychologicalProfileMemoryOperating;
    }

    public void setNeuropsychologicalProfileMemoryOperating(
            int neuropsychologicalProfileMemoryOperating) {
        this.neuropsychologicalProfileMemoryOperating = neuropsychologicalProfileMemoryOperating;
    }

    public int getNeuropsychologicalProfileMemoryVerbal() {
        return neuropsychologicalProfileMemoryVerbal;
    }

    public void setNeuropsychologicalProfileMemoryVerbal(
            int neuropsychologicalProfileMemoryVerbal) {
        this.neuropsychologicalProfileMemoryVerbal = neuropsychologicalProfileMemoryVerbal;
    }

    public int getNeuropsychologicalProfileMemoryNonverbal() {
        return neuropsychologicalProfileMemoryNonverbal;
    }

    public void setNeuropsychologicalProfileMemoryNonverbal(
            int neuropsychologicalProfileMemoryNonverbal) {
        this.neuropsychologicalProfileMemoryNonverbal = neuropsychologicalProfileMemoryNonverbal;
    }

    public int getNeuropsychologicalProfileMemoryLearning() {
        return neuropsychologicalProfileMemoryLearning;
    }

    public void setNeuropsychologicalProfileMemoryLearning(
            int neuropsychologicalProfileMemoryLearning) {
        this.neuropsychologicalProfileMemoryLearning = neuropsychologicalProfileMemoryLearning;
    }

    public int getNeuropsychologicalProfilePerceptionSpeech() {
        return neuropsychologicalProfilePerceptionSpeech;
    }

    public void setNeuropsychologicalProfilePerceptionSpeech(
            int neuropsychologicalProfilePerceptionSpeech) {
        this.neuropsychologicalProfilePerceptionSpeech = neuropsychologicalProfilePerceptionSpeech;
    }

    public int getNeuropsychologicalProfilePerceptionVisual() {
        return neuropsychologicalProfilePerceptionVisual;
    }

    public void setNeuropsychologicalProfilePerceptionVisual(
            int neuropsychologicalProfilePerceptionVisual) {
        this.neuropsychologicalProfilePerceptionVisual = neuropsychologicalProfilePerceptionVisual;
    }

    public int getNeuropsychologicalProfilePerceptionSpatial() {
        return neuropsychologicalProfilePerceptionSpatial;
    }

    public void setNeuropsychologicalProfilePerceptionSpatial(
            int neuropsychologicalProfilePerceptionSpatial) {
        this.neuropsychologicalProfilePerceptionSpatial = neuropsychologicalProfilePerceptionSpatial;
    }

    public int getNeuropsychologicalProfileMotorSkillsDexterity() {
        return neuropsychologicalProfileMotorSkillsDexterity;
    }

    public void setNeuropsychologicalProfileMotorSkillsDexterity(
            int neuropsychologicalProfileMotorSkillsDexterity) {
        this.neuropsychologicalProfileMotorSkillsDexterity = neuropsychologicalProfileMotorSkillsDexterity;
    }

    public int getNeuropsychologicalProfileMotorCoordination() {
        return neuropsychologicalProfileMotorCoordination;
    }

    public void setNeuropsychologicalProfileMotorCoordination(
            int neuropsychologicalProfileMotorCoordination) {
        this.neuropsychologicalProfileMotorCoordination = neuropsychologicalProfileMotorCoordination;
    }

    public int getPresenceOfChanges() {
        return presenceOfChanges;
    }

    public void setPresenceOfChanges(int presenceOfChanges) {
        this.presenceOfChanges = presenceOfChanges;
    }

    public String getPresenceOfChangesDetail() {
        return presenceOfChangesDetail;
    }

    public void setPresenceOfChangesDetail(String presenceOfChangesDetail) {
        this.presenceOfChangesDetail = presenceOfChangesDetail;
    }

    public int getEmotionalStatus() {
        return emotionalStatus;
    }

    public void setEmotionalStatus(int emotionalStatus) {
        this.emotionalStatus = emotionalStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
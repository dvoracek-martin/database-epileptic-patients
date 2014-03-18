package cz.cvut.fit.genepi.businessLayer.VO.form.card;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

public class NeuropsychologyVO {

    private int id;

    private int patientId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @NotNull
    private Date date;

    private int intellect;

    private int neurodevelopmentalExamination;

    private int neurodevelopmentalExaminationAdaptability;

    private int neurodevelopmentalExaminationSpeechExpressively;

    private int neurodevelopmentalExaminationSpeechReceptively;

    private int neurodevelopmentalExaminationFineMotorSkills;

    private int neurodevelopmentalExaminationGrossMotorSkills;

    private int neurodevelopmentalExaminationSocialBehavior;

    private int intellectualPerformance;

    private int intellectualPerformanceVerbally;

    private int intellectualPerformanceNonverbalAbstraction;

    private int intellectualPerformanceNonverbalDesignCapabilities;

    private int neuropsychologicalProfile;

    private int neuropsychologicalProfileAttention;

    private int neuropsychologicalProfileExecutiveFunction;

    private int neuropsychologicalProfileCognitiveSpeed;

    private int neuropsychologicalProfileSpeechExpressively;

    private int neuropsychologicalProfileSpeechUnderstanding;

    private int neuropsychologicalProfileMemoryOperating;

    private int neuropsychologicalProfileMemoryVerbal;

    private int neuropsychologicalProfileMemoryNonverbal;

    private int neuropsychologicalProfileMemoryLearning;

    private int neuropsychologicalProfilePerceptionSpeech;

    private int neuropsychologicalProfilePerceptionVisual;

    private int neuropsychologicalProfilePerceptionSpatial;

    private int neuropsychologicalProfileMotorSkillsDexterity;

    private int neuropsychologicalProfileMotorCoordination;

    @Min(1)
    private int presenceOfChanges;

    private int[] presenceOfChangesDetail;

    @Min(1)
    private int emotionalStatus;

    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
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

    public void setNeurodevelopmentalExaminationAdaptability(int neurodevelopmentalExaminationAdaptability) {
        this.neurodevelopmentalExaminationAdaptability = neurodevelopmentalExaminationAdaptability;
    }

    public int getNeurodevelopmentalExaminationSpeechExpressively() {
        return neurodevelopmentalExaminationSpeechExpressively;
    }

    public void setNeurodevelopmentalExaminationSpeechExpressively(int neurodevelopmentalExaminationSpeechExpressively) {
        this.neurodevelopmentalExaminationSpeechExpressively = neurodevelopmentalExaminationSpeechExpressively;
    }

    public int getNeurodevelopmentalExaminationSpeechReceptively() {
        return neurodevelopmentalExaminationSpeechReceptively;
    }

    public void setNeurodevelopmentalExaminationSpeechReceptively(int neurodevelopmentalExaminationSpeechReceptively) {
        this.neurodevelopmentalExaminationSpeechReceptively = neurodevelopmentalExaminationSpeechReceptively;
    }

    public int getNeurodevelopmentalExaminationFineMotorSkills() {
        return neurodevelopmentalExaminationFineMotorSkills;
    }

    public void setNeurodevelopmentalExaminationFineMotorSkills(int neurodevelopmentalExaminationFineMotorSkills) {
        this.neurodevelopmentalExaminationFineMotorSkills = neurodevelopmentalExaminationFineMotorSkills;
    }

    public int getNeurodevelopmentalExaminationGrossMotorSkills() {
        return neurodevelopmentalExaminationGrossMotorSkills;
    }

    public void setNeurodevelopmentalExaminationGrossMotorSkills(int neurodevelopmentalExaminationGrossMotorSkills) {
        this.neurodevelopmentalExaminationGrossMotorSkills = neurodevelopmentalExaminationGrossMotorSkills;
    }

    public int getNeurodevelopmentalExaminationSocialBehavior() {
        return neurodevelopmentalExaminationSocialBehavior;
    }

    public void setNeurodevelopmentalExaminationSocialBehavior(int neurodevelopmentalExaminationSocialBehavior) {
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

    public void setIntellectualPerformanceVerbally(int intellectualPerformanceVerbally) {
        this.intellectualPerformanceVerbally = intellectualPerformanceVerbally;
    }

    public int getIntellectualPerformanceNonverbalAbstraction() {
        return intellectualPerformanceNonverbalAbstraction;
    }

    public void setIntellectualPerformanceNonverbalAbstraction(int intellectualPerformanceNonverbalAbstraction) {
        this.intellectualPerformanceNonverbalAbstraction = intellectualPerformanceNonverbalAbstraction;
    }

    public int getIntellectualPerformanceNonverbalDesignCapabilities() {
        return intellectualPerformanceNonverbalDesignCapabilities;
    }

    public void setIntellectualPerformanceNonverbalDesignCapabilities(int intellectualPerformanceNonverbalDesignCapabilities) {
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

    public void setNeuropsychologicalProfileAttention(int neuropsychologicalProfileAttention) {
        this.neuropsychologicalProfileAttention = neuropsychologicalProfileAttention;
    }

    public int getNeuropsychologicalProfileExecutiveFunction() {
        return neuropsychologicalProfileExecutiveFunction;
    }

    public void setNeuropsychologicalProfileExecutiveFunction(int neuropsychologicalProfileExecutiveFunction) {
        this.neuropsychologicalProfileExecutiveFunction = neuropsychologicalProfileExecutiveFunction;
    }

    public int getNeuropsychologicalProfileCognitiveSpeed() {
        return neuropsychologicalProfileCognitiveSpeed;
    }

    public void setNeuropsychologicalProfileCognitiveSpeed(int neuropsychologicalProfileCognitiveSpeed) {
        this.neuropsychologicalProfileCognitiveSpeed = neuropsychologicalProfileCognitiveSpeed;
    }

    public int getNeuropsychologicalProfileSpeechExpressively() {
        return neuropsychologicalProfileSpeechExpressively;
    }

    public void setNeuropsychologicalProfileSpeechExpressively(int neuropsychologicalProfileSpeechExpressively) {
        this.neuropsychologicalProfileSpeechExpressively = neuropsychologicalProfileSpeechExpressively;
    }

    public int getNeuropsychologicalProfileSpeechUnderstanding() {
        return neuropsychologicalProfileSpeechUnderstanding;
    }

    public void setNeuropsychologicalProfileSpeechUnderstanding(int neuropsychologicalProfileSpeechUnderstanding) {
        this.neuropsychologicalProfileSpeechUnderstanding = neuropsychologicalProfileSpeechUnderstanding;
    }

    public int getNeuropsychologicalProfileMemoryOperating() {
        return neuropsychologicalProfileMemoryOperating;
    }

    public void setNeuropsychologicalProfileMemoryOperating(int neuropsychologicalProfileMemoryOperating) {
        this.neuropsychologicalProfileMemoryOperating = neuropsychologicalProfileMemoryOperating;
    }

    public int getNeuropsychologicalProfileMemoryVerbal() {
        return neuropsychologicalProfileMemoryVerbal;
    }

    public void setNeuropsychologicalProfileMemoryVerbal(int neuropsychologicalProfileMemoryVerbal) {
        this.neuropsychologicalProfileMemoryVerbal = neuropsychologicalProfileMemoryVerbal;
    }

    public int getNeuropsychologicalProfileMemoryNonverbal() {
        return neuropsychologicalProfileMemoryNonverbal;
    }

    public void setNeuropsychologicalProfileMemoryNonverbal(int neuropsychologicalProfileMemoryNonverbal) {
        this.neuropsychologicalProfileMemoryNonverbal = neuropsychologicalProfileMemoryNonverbal;
    }

    public int getNeuropsychologicalProfileMemoryLearning() {
        return neuropsychologicalProfileMemoryLearning;
    }

    public void setNeuropsychologicalProfileMemoryLearning(int neuropsychologicalProfileMemoryLearning) {
        this.neuropsychologicalProfileMemoryLearning = neuropsychologicalProfileMemoryLearning;
    }

    public int getNeuropsychologicalProfilePerceptionSpeech() {
        return neuropsychologicalProfilePerceptionSpeech;
    }

    public void setNeuropsychologicalProfilePerceptionSpeech(int neuropsychologicalProfilePerceptionSpeech) {
        this.neuropsychologicalProfilePerceptionSpeech = neuropsychologicalProfilePerceptionSpeech;
    }

    public int getNeuropsychologicalProfilePerceptionVisual() {
        return neuropsychologicalProfilePerceptionVisual;
    }

    public void setNeuropsychologicalProfilePerceptionVisual(int neuropsychologicalProfilePerceptionVisual) {
        this.neuropsychologicalProfilePerceptionVisual = neuropsychologicalProfilePerceptionVisual;
    }

    public int getNeuropsychologicalProfilePerceptionSpatial() {
        return neuropsychologicalProfilePerceptionSpatial;
    }

    public void setNeuropsychologicalProfilePerceptionSpatial(int neuropsychologicalProfilePerceptionSpatial) {
        this.neuropsychologicalProfilePerceptionSpatial = neuropsychologicalProfilePerceptionSpatial;
    }

    public int getNeuropsychologicalProfileMotorSkillsDexterity() {
        return neuropsychologicalProfileMotorSkillsDexterity;
    }

    public void setNeuropsychologicalProfileMotorSkillsDexterity(int neuropsychologicalProfileMotorSkillsDexterity) {
        this.neuropsychologicalProfileMotorSkillsDexterity = neuropsychologicalProfileMotorSkillsDexterity;
    }

    public int getNeuropsychologicalProfileMotorCoordination() {
        return neuropsychologicalProfileMotorCoordination;
    }

    public void setNeuropsychologicalProfileMotorCoordination(int neuropsychologicalProfileMotorCoordination) {
        this.neuropsychologicalProfileMotorCoordination = neuropsychologicalProfileMotorCoordination;
    }

    public int getPresenceOfChanges() {
        return presenceOfChanges;
    }

    public void setPresenceOfChanges(int presenceOfChanges) {
        this.presenceOfChanges = presenceOfChanges;
    }

    public int[] getPresenceOfChangesDetail() {
        return presenceOfChangesDetail;
    }

    public void setPresenceOfChangesDetail(int[] presenceOfChangesDetail) {
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
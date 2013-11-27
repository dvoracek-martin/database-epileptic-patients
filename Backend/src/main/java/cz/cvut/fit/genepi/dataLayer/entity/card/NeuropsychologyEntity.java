package cz.cvut.fit.genepi.dataLayer.entity.card;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

@Entity
@Table(name = "neuropsychology")
public class NeuropsychologyEntity implements Comparable<NeuropsychologyEntity>{

	/* Autofilled fields */

	/** The id. */
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private int id;

	/** The add user id. */
	@NotNull
	@Column(name = "add_user_id", nullable = false)
	private int addUserId;

	/** The added. */
	@Column(name = "added", nullable = false, insertable = false)
	private Date added;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;

	@Column(name = "status", nullable = false)
	private int status;

	/* Other fields */
	/** The date. */
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past
	@NotNull
	@Column(name = "date", nullable = false)
	private Date date;
	
	@Column(name = "intellect", nullable = false)
	private int intellect;
	
	@Column(name = "neurodevelopmental_examination", nullable = false)
	private int neurodevelopmental_examination;
	
	@Column(name = "neurodevelopmental_examination_adaptability", nullable = false)
	private int neurodevelopmental_examination_adaptability;
	
	@Column(name = "neurodevelopmentalexamination_speech_expressively", nullable = false)
	private int neurodevelopmental_examination_speech_expressively;
	
	@Column(name = "neurodevelopmental_examination_speech_receptively", nullable = false)
	private int neurodevelopmental_examination_speech_receptively;
	
	@Column(name = "neurodevelopmental_examination_fine_motor_skills", nullable = false)
	private int neurodevelopmental_examination_fine_motor_skills;
	
	@Column(name = "neurodevelopmental_examination_gross_motor_skills", nullable = false)
	private int neurodevelopmental_examination_gross_motor_skills;
	
	@Column(name = "neurodevelopmental_examination_social_behavior", nullable = false)
	private int neurodevelopmental_examination_social_behavior;
	
	@Column(name = "intellectual_performance", nullable = false)
	private int intellectual_performance;
	
	@Column(name = "intellectual_performance_verbally", nullable = false)
	private int intellectual_performance_verbally;
	
	@Column(name = "intellectual_performance_nonverbal_abstraction", nullable = false)
	private int intellectual_performance_nonverbal_abstraction;
	
	@Column(name = "intellectual_performance_nonverbal_design_capabilities", nullable = false)
	private int intellectual_performance_nonverbal_design_capabilities;
	
	@Column(name = "neuropsychological_profile", nullable = false)
	private int neuropsychological_profile;
	
	@Column(name = "neuropsychological_profile_attention", nullable = false)
	private int neuropsychological_profile_attention;
	
	@Column(name = "neuropsychological_profile_executive_function", nullable = false)
	private int neuropsychological_profile_executive_function;
	
	@Column(name = "neuropsychological_profile_cognitive_speed", nullable = false)
	private int neuropsychological_profile_cognitive_speed;
	
	@Column(name = "neuropsychological_profile_speech_expressively", nullable = false)
	private int neuropsychological_profile_speech_expressively;
	
	@Column(name = "neuropsychological_profile_speech_understanding", nullable = false)
	private int neuropsychological_profile_speech_understanding;
	
	@Column(name = "neuropsychological_profile_memory_operating", nullable = false)
	private int neuropsychological_profile_memory_operating;
	
	@Column(name = "neuropsychological_profile_memory_verbal", nullable = false)
	private int neuropsychological_profile_memory_verbal;
	
	@Column(name = "neuropsychological_profile_memory_nonverbal", nullable = false)
	private int neuropsychological_profile_memory_nonverbal;
	
	@Column(name = "neuropsychological_profile_memory_learning", nullable = false)
	private int neuropsychological_profile_memory_learning;
	
	@Column(name = "neuropsychological_profile_perception_speech", nullable = false)
	private int neuropsychological_profile_perception_speech;
	
	@Column(name = "neuropsychological_profile_perception_visual", nullable = false)
	private int neuropsychological_profile_perception_visual;
	
	@Column(name = "neuropsychological_profile_perception_spatial", nullable = false)
	private int neuropsychological_profile_perception_spatial;
	
	@Column(name = "neuropsychological_profile_motor_skills_dexterity", nullable = false)
	private int neuropsychological_profile_motor_skills_dexterity;
	
	@Column(name = "neuropsychological_profile_motor_coordination", nullable = false)
	private int neuropsychological_profile_motor_coordination;
	
	@Column(name = "presence_of_changes", nullable = false)
	private int presence_of_changes;
	
	@Column(name = "presence_of_changes_detail", nullable = false)
	private int presence_of_changes_detail;
	
	@Column(name = "emotional_status", nullable = false)
	private int emotional_status;
	
	@Column(name = "comment", nullable = false)
	private int comment;
	
	@Override
	public int compareTo(NeuropsychologyEntity o) {
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

	public int getIntellect() {
		return intellect;
	}

	public void setIntellect(int intellect) {
		this.intellect = intellect;
	}

	public int getNeurodevelopmental_examination() {
		return neurodevelopmental_examination;
	}

	public void setNeurodevelopmental_examination(int neurodevelopmental_examination) {
		this.neurodevelopmental_examination = neurodevelopmental_examination;
	}

	public int getNeurodevelopmental_examination_adaptability() {
		return neurodevelopmental_examination_adaptability;
	}

	public void setNeurodevelopmental_examination_adaptability(
			int neurodevelopmental_examination_adaptability) {
		this.neurodevelopmental_examination_adaptability = neurodevelopmental_examination_adaptability;
	}

	public int getNeurodevelopmental_examination_speech_expressively() {
		return neurodevelopmental_examination_speech_expressively;
	}

	public void setNeurodevelopmental_examination_speech_expressively(
			int neurodevelopmental_examination_speech_expressively) {
		this.neurodevelopmental_examination_speech_expressively = neurodevelopmental_examination_speech_expressively;
	}

	public int getNeurodevelopmental_examination_speech_receptively() {
		return neurodevelopmental_examination_speech_receptively;
	}

	public void setNeurodevelopmental_examination_speech_receptively(
			int neurodevelopmental_examination_speech_receptively) {
		this.neurodevelopmental_examination_speech_receptively = neurodevelopmental_examination_speech_receptively;
	}

	public int getNeurodevelopmental_examination_fine_motor_skills() {
		return neurodevelopmental_examination_fine_motor_skills;
	}

	public void setNeurodevelopmental_examination_fine_motor_skills(
			int neurodevelopmental_examination_fine_motor_skills) {
		this.neurodevelopmental_examination_fine_motor_skills = neurodevelopmental_examination_fine_motor_skills;
	}

	public int getNeurodevelopmental_examination_gross_motor_skills() {
		return neurodevelopmental_examination_gross_motor_skills;
	}

	public void setNeurodevelopmental_examination_gross_motor_skills(
			int neurodevelopmental_examination_gross_motor_skills) {
		this.neurodevelopmental_examination_gross_motor_skills = neurodevelopmental_examination_gross_motor_skills;
	}

	public int getNeurodevelopmental_examination_social_behavior() {
		return neurodevelopmental_examination_social_behavior;
	}

	public void setNeurodevelopmental_examination_social_behavior(
			int neurodevelopmental_examination_social_behavior) {
		this.neurodevelopmental_examination_social_behavior = neurodevelopmental_examination_social_behavior;
	}

	public int getIntellectual_performance() {
		return intellectual_performance;
	}

	public void setIntellectual_performance(int intellectual_performance) {
		this.intellectual_performance = intellectual_performance;
	}

	public int getIntellectual_performance_verbally() {
		return intellectual_performance_verbally;
	}

	public void setIntellectual_performance_verbally(
			int intellectual_performance_verbally) {
		this.intellectual_performance_verbally = intellectual_performance_verbally;
	}

	public int getIntellectual_performance_nonverbal_abstraction() {
		return intellectual_performance_nonverbal_abstraction;
	}

	public void setIntellectual_performance_nonverbal_abstraction(
			int intellectual_performance_nonverbal_abstraction) {
		this.intellectual_performance_nonverbal_abstraction = intellectual_performance_nonverbal_abstraction;
	}

	public int getIntellectual_performance_nonverbal_design_capabilities() {
		return intellectual_performance_nonverbal_design_capabilities;
	}

	public void setIntellectual_performance_nonverbal_design_capabilities(
			int intellectual_performance_nonverbal_design_capabilities) {
		this.intellectual_performance_nonverbal_design_capabilities = intellectual_performance_nonverbal_design_capabilities;
	}

	public int getNeuropsychological_profile() {
		return neuropsychological_profile;
	}

	public void setNeuropsychological_profile(int neuropsychological_profile) {
		this.neuropsychological_profile = neuropsychological_profile;
	}

	public int getNeuropsychological_profile_attention() {
		return neuropsychological_profile_attention;
	}

	public void setNeuropsychological_profile_attention(
			int neuropsychological_profile_attention) {
		this.neuropsychological_profile_attention = neuropsychological_profile_attention;
	}

	public int getNeuropsychological_profile_executive_function() {
		return neuropsychological_profile_executive_function;
	}

	public void setNeuropsychological_profile_executive_function(
			int neuropsychological_profile_executive_function) {
		this.neuropsychological_profile_executive_function = neuropsychological_profile_executive_function;
	}

	public int getNeuropsychological_profile_cognitive_speed() {
		return neuropsychological_profile_cognitive_speed;
	}

	public void setNeuropsychological_profile_cognitive_speed(
			int neuropsychological_profile_cognitive_speed) {
		this.neuropsychological_profile_cognitive_speed = neuropsychological_profile_cognitive_speed;
	}

	public int getNeuropsychological_profile_speech_expressively() {
		return neuropsychological_profile_speech_expressively;
	}

	public void setNeuropsychological_profile_speech_expressively(
			int neuropsychological_profile_speech_expressively) {
		this.neuropsychological_profile_speech_expressively = neuropsychological_profile_speech_expressively;
	}

	public int getNeuropsychological_profile_speech_understanding() {
		return neuropsychological_profile_speech_understanding;
	}

	public void setNeuropsychological_profile_speech_understanding(
			int neuropsychological_profile_speech_understanding) {
		this.neuropsychological_profile_speech_understanding = neuropsychological_profile_speech_understanding;
	}

	public int getNeuropsychological_profile_memory_operating() {
		return neuropsychological_profile_memory_operating;
	}

	public void setNeuropsychological_profile_memory_operating(
			int neuropsychological_profile_memory_operating) {
		this.neuropsychological_profile_memory_operating = neuropsychological_profile_memory_operating;
	}

	public int getNeuropsychological_profile_memory_verbal() {
		return neuropsychological_profile_memory_verbal;
	}

	public void setNeuropsychological_profile_memory_verbal(
			int neuropsychological_profile_memory_verbal) {
		this.neuropsychological_profile_memory_verbal = neuropsychological_profile_memory_verbal;
	}

	public int getNeuropsychological_profile_memory_nonverbal() {
		return neuropsychological_profile_memory_nonverbal;
	}

	public void setNeuropsychological_profile_memory_nonverbal(
			int neuropsychological_profile_memory_nonverbal) {
		this.neuropsychological_profile_memory_nonverbal = neuropsychological_profile_memory_nonverbal;
	}

	public int getNeuropsychological_profile_memory_learning() {
		return neuropsychological_profile_memory_learning;
	}

	public void setNeuropsychological_profile_memory_learning(
			int neuropsychological_profile_memory_learning) {
		this.neuropsychological_profile_memory_learning = neuropsychological_profile_memory_learning;
	}

	public int getNeuropsychological_profile_perception_speech() {
		return neuropsychological_profile_perception_speech;
	}

	public void setNeuropsychological_profile_perception_speech(
			int neuropsychological_profile_perception_speech) {
		this.neuropsychological_profile_perception_speech = neuropsychological_profile_perception_speech;
	}

	public int getNeuropsychological_profile_perception_visual() {
		return neuropsychological_profile_perception_visual;
	}

	public void setNeuropsychological_profile_perception_visual(
			int neuropsychological_profile_perception_visual) {
		this.neuropsychological_profile_perception_visual = neuropsychological_profile_perception_visual;
	}

	public int getNeuropsychological_profile_perception_spatial() {
		return neuropsychological_profile_perception_spatial;
	}

	public void setNeuropsychological_profile_perception_spatial(
			int neuropsychological_profile_perception_spatial) {
		this.neuropsychological_profile_perception_spatial = neuropsychological_profile_perception_spatial;
	}

	public int getNeuropsychological_profile_motor_skills_dexterity() {
		return neuropsychological_profile_motor_skills_dexterity;
	}

	public void setNeuropsychological_profile_motor_skills_dexterity(
			int neuropsychological_profile_motor_skills_dexterity) {
		this.neuropsychological_profile_motor_skills_dexterity = neuropsychological_profile_motor_skills_dexterity;
	}

	public int getNeuropsychological_profile_motor_coordination() {
		return neuropsychological_profile_motor_coordination;
	}

	public void setNeuropsychological_profile_motor_coordination(
			int neuropsychological_profile_motor_coordination) {
		this.neuropsychological_profile_motor_coordination = neuropsychological_profile_motor_coordination;
	}

	public int getPresence_of_changes() {
		return presence_of_changes;
	}

	public void setPresence_of_changes(int presence_of_changes) {
		this.presence_of_changes = presence_of_changes;
	}

	public int getPresence_of_changes_detail() {
		return presence_of_changes_detail;
	}

	public void setPresence_of_changes_detail(int presence_of_changes_detail) {
		this.presence_of_changes_detail = presence_of_changes_detail;
	}

	public int getEmotional_status() {
		return emotional_status;
	}

	public void setEmotional_status(int emotional_status) {
		this.emotional_status = emotional_status;
	}

	public int getComment() {
		return comment;
	}

	public void setComment(int comment) {
		this.comment = comment;
	}

}

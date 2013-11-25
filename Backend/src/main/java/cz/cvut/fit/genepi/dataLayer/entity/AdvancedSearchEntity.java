package cz.cvut.fit.genepi.dataLayer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "advanced_search")
public class AdvancedSearchEntity {

	@Id
	@Column(name = "id", precision = 6, scale = 0, nullable = false)
	@GeneratedValue
	private int id;

	@Column(name = "added")
	private Date added;

	@Column(name = "name")
	private String name;

	@Column(name = "hidden")
	private boolean hidden;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private UserEntity user;

	@Column(name = "patient_firstname")
	private String patientFirstname;

	@Column(name = "patient_lastname")
	private String patientLastname;

	@Column(name = "patient_nin")
	private String patientNin;

	@Column(name = "patient_town")
	private String patientTown;

	@Column(name = "patient_country")
	private String patientCountry;

	@Column(name = "patient_gender")
	private String patientGender;

	@Column(name = "patient_age")
	private String patientAge;

	@Column(name = "patient_age_filter")
	private String patientAgeFilter;

	@Column(name = "patient_age_epilepsy")
	private String patientAgeEpilepsy;

	@Column(name = "patient_age_epilepsy_filter")
	private String patientAgeEpilepsyFilter;

	@Column(name = "patient_doctor")
	private int patientDoctor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAdded() {
		return added;
	}

	public void setAdded(Date added) {
		this.added = added;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getPatientFirstname() {
		return patientFirstname;
	}

	public void setPatientFirstname(String patientFirstname) {
		this.patientFirstname =patientFirstname;
	}

	public String getPatientLastname() {
		return patientLastname;
	}

	public void setPatientLastname(String patientLastname) {
		this.patientLastname = patientLastname;
	}

	public String getPatientNin() {
		return patientNin;
	}

	public void setPatientNin(String patientNin) {
		this.patientNin = patientNin;
	}

	public String getPatientTown() {
		return patientTown;
	}

	public void setPatientTown(String patientTown) {
		this.patientTown = patientTown;
	}

	public String getPatientCountry() {
		return patientCountry;
	}

	public void setPatientCountry(String patientCountry) {
		this.patientCountry = patientCountry;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public String getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(String patientAge) {
		this.patientAge = patientAge;
	}

	public String getPatientAgeFilter() {
		return patientAgeFilter;
	}

	public void setPatientAgeFilter(String patientAgeFilter) {
		this.patientAgeFilter = patientAgeFilter;
	}

	public String getPatientAgeEpilepsy() {
		return patientAgeEpilepsy;
	}

	public void setPatientAgeEpilepsy(String patientAgeEpilepsy) {
		this.patientAgeEpilepsy = patientAgeEpilepsy;
	}

	public String getPatientAgeEpilepsyFilter() {
		return patientAgeEpilepsyFilter;
	}

	public void setPatientAgeEpilepsyFilter(String patientAgeEpilepsyFilter) {
		this.patientAgeEpilepsyFilter = patientAgeEpilepsyFilter;
	}

	public int getPatientDoctor() {
		return patientDoctor;
	}

	public void setPatientDoctor(int patientDoctor) {
		this.patientDoctor = patientDoctor;
	}
	
	

}

package cz.cvut.fit.genepi.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import cz.cvut.fit.genepi.entity.card.AnamnesisEntity;
import cz.cvut.fit.genepi.entity.card.ComplicationEntity;
import cz.cvut.fit.genepi.entity.card.DiagnosticTestScalpEEGEntity;
import cz.cvut.fit.genepi.entity.card.DiagnosticTestMRIEntity;
import cz.cvut.fit.genepi.entity.card.HistologyEntity;
import cz.cvut.fit.genepi.entity.card.InvasiveTestCorticalMappingEntity;
import cz.cvut.fit.genepi.entity.card.InvasiveTestECOGEntity;
import cz.cvut.fit.genepi.entity.card.InvasiveTestEEGEntity;
import cz.cvut.fit.genepi.entity.card.NeurologicalFindingEntity;
import cz.cvut.fit.genepi.entity.card.NeuropsychologyEntity;
import cz.cvut.fit.genepi.entity.card.OperationEntity;
import cz.cvut.fit.genepi.entity.card.OutcomeEntity;
import cz.cvut.fit.genepi.entity.card.PharmacotherapyEntity;
import cz.cvut.fit.genepi.entity.card.SeizureEntity;
import cz.cvut.fit.genepi.util.CollectionConverter;
import cz.cvut.fit.genepi.util.Sorter;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientEntity.
 */
@Entity
@Table(name = "patient")
public class PatientEntity {

	/** The id. */
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private int id;

	/** The nin. */
	@Pattern(regexp = "[0-9]*")
	@Size(max = 10)
	@Column(name = "nin", length = 10, nullable = true)
	private String nin;

	/** The birthday. */
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past
	@NotNull
	@Column(name = "birthday", nullable = false)
	private Date birthday;

	/** The gender. */
	@NotBlank
	// @NotNull
	@Size(max = 10)
	@Column(name = "gender", length = 10, nullable = false)
	private String gender;

	/** The deleted. */
	@Column(name = "status", precision = 1, scale = 0, nullable = true)
	private int status;

	/** The checked. */
	@Column(name = "checked", precision = 1, scale = 0, nullable = true)
	private boolean checked;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id")
	private UserEntity doctor;

	/* Relations */

	/** The contact. */
	@Valid
	@OneToOne
	@Cascade({ CascadeType.SAVE_UPDATE })
	private ContactEntity contact;

	/* AnamnesisList */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private Set<AnamnesisEntity> anamnesisList;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private Set<ComplicationEntity> complicationList;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private Set<DiagnosticTestScalpEEGEntity> diagnosticTestScalpEEGList;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private Set<DiagnosticTestMRIEntity> diagnosticTestMRIList;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private Set<HistologyEntity> histologyList;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private Set<InvasiveTestCorticalMappingEntity> invasiveTestCorticalMappingList;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private Set<InvasiveTestECOGEntity> invasiveTestECOGList;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private Set<InvasiveTestEEGEntity> invasiveTestEEGList;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private Set<NeurologicalFindingEntity> neurologicalFindingList;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private Set<NeuropsychologyEntity> neuropsychologyList;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private Set<OperationEntity> operationList;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private Set<OutcomeEntity> outcomeList;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private Set<PharmacotherapyEntity> pharmacotherapyList;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	@Cascade({ CascadeType.ALL })
	private Set<SeizureEntity> seizureList;

	public List<AnamnesisEntity> getAnamnesisList() {
		CollectionConverter<AnamnesisEntity> converter = new CollectionConverter<>();
		Sorter<AnamnesisEntity> sorter = new Sorter<>();
		return sorter.sortByDate(converter.toList(this.anamnesisList));
	}

	public void setAnamnesisList(List<AnamnesisEntity> anamnesisList) {
		CollectionConverter<AnamnesisEntity> converter = new CollectionConverter<>();
		this.anamnesisList = converter.toSet(anamnesisList);
	}

	public List<NeurologicalFindingEntity> getNeurologicalFindingList() {
		CollectionConverter<NeurologicalFindingEntity> converter = new CollectionConverter<>();
		Sorter<NeurologicalFindingEntity> sorter = new Sorter<>();
		return sorter
				.sortByDate(converter.toList(this.neurologicalFindingList));
	}

	public void setNeurologicalFindingList(
			List<NeurologicalFindingEntity> neurologicalFindingList) {
		CollectionConverter<NeurologicalFindingEntity> converter = new CollectionConverter<>();
		this.neurologicalFindingList = converter.toSet(neurologicalFindingList);
	}

	public List<PharmacotherapyEntity> getPharmacotherapyList() {
		CollectionConverter<PharmacotherapyEntity> converter = new CollectionConverter<>();
		Sorter<PharmacotherapyEntity> sorter = new Sorter<>();
		return sorter.sortByDate(converter.toList(this.pharmacotherapyList));
	}

	public void setPharmacotherapyList(
			List<PharmacotherapyEntity> pharmacotherapyList) {
		CollectionConverter<PharmacotherapyEntity> converter = new CollectionConverter<>();
		this.pharmacotherapyList = converter.toSet(pharmacotherapyList);
	}

	public List<ComplicationEntity> getComplicationList() {
		CollectionConverter<ComplicationEntity> converter = new CollectionConverter<>();
		Sorter<ComplicationEntity> sorter = new Sorter<>();
		return sorter.sortByDate(converter.toList(this.complicationList));
	}

	public void setComplicationList(List<ComplicationEntity> complicationList) {
		CollectionConverter<ComplicationEntity> converter = new CollectionConverter<>();
		this.complicationList = converter.toSet(complicationList);
	}

	public List<SeizureEntity> getSeizureList() {
		CollectionConverter<SeizureEntity> converter = new CollectionConverter<>();
		Sorter<SeizureEntity> sorter = new Sorter<>();
		return sorter.sortByDate(converter.toList(this.seizureList));
	}

	public void setSeizureList(List<SeizureEntity> seizureList) {
		CollectionConverter<SeizureEntity> converter = new CollectionConverter<>();
		this.seizureList = converter.toSet(seizureList);
	}

	public List<HistologyEntity> getHistologyList() {
		CollectionConverter<HistologyEntity> converter = new CollectionConverter<>();
		Sorter<HistologyEntity> sorter = new Sorter<>();
		return sorter.sortByDate(converter.toList(this.histologyList));
	}

	public void setHistologyList(List<HistologyEntity> histologyList) {
		CollectionConverter<HistologyEntity> converter = new CollectionConverter<>();
		this.histologyList = converter.toSet(histologyList);
	}

	public List<NeuropsychologyEntity> getNeuropsychologyList() {
		CollectionConverter<NeuropsychologyEntity> converter = new CollectionConverter<>();
		Sorter<NeuropsychologyEntity> sorter = new Sorter<>();
		return sorter.sortByDate(converter.toList(this.neuropsychologyList));
	}

	public void setNeuropsychologyList(
			List<NeuropsychologyEntity> neuropsychologyList) {
		CollectionConverter<NeuropsychologyEntity> converter = new CollectionConverter<>();
		this.neuropsychologyList = converter.toSet(neuropsychologyList);
	}

	public List<OutcomeEntity> getOutcomeList() {
		CollectionConverter<OutcomeEntity> converter = new CollectionConverter<>();
		Sorter<OutcomeEntity> sorter = new Sorter<>();
		return sorter.sortByDate(converter.toList(this.outcomeList));
	}

	public void setOutcomeList(List<OutcomeEntity> outcomeList) {
		CollectionConverter<OutcomeEntity> converter = new CollectionConverter<>();
		this.outcomeList = converter.toSet(outcomeList);
	}

	public List<InvasiveTestEEGEntity> getInvasiveTestEEGList() {
		CollectionConverter<InvasiveTestEEGEntity> converter = new CollectionConverter<>();
		Sorter<InvasiveTestEEGEntity> sorter = new Sorter<>();
		return sorter.sortByDate(converter.toList(this.invasiveTestEEGList));
	}

	public void setInvasiveTestEEGList(
			List<InvasiveTestEEGEntity> invasiveTestEEGList) {
		CollectionConverter<InvasiveTestEEGEntity> converter = new CollectionConverter<>();
		this.invasiveTestEEGList = converter.toSet(invasiveTestEEGList);
	}

	public List<OperationEntity> getOperationList() {
		CollectionConverter<OperationEntity> converter = new CollectionConverter<>();
		Sorter<OperationEntity> sorter = new Sorter<>();
		return sorter.sortByDate(converter.toList(this.operationList));
	}

	public void setOperationList(List<OperationEntity> operationList) {
		CollectionConverter<OperationEntity> converter = new CollectionConverter<>();
		this.operationList = converter.toSet(operationList);
	}

	public List<DiagnosticTestMRIEntity> getDiagnosticTestMRIList() {
		CollectionConverter<DiagnosticTestMRIEntity> converter = new CollectionConverter<>();
		Sorter<DiagnosticTestMRIEntity> sorter = new Sorter<>();
		return sorter.sortByDate(converter.toList(this.diagnosticTestMRIList));
	}

	public void setDiagnosticTestMRIList(
			List<DiagnosticTestMRIEntity> diagnosticTestMRIList) {
		CollectionConverter<DiagnosticTestMRIEntity> converter = new CollectionConverter<>();
		this.diagnosticTestMRIList = converter.toSet(diagnosticTestMRIList);
	}

	public List<DiagnosticTestScalpEEGEntity> getDiagnosticTestEEGList() {
		CollectionConverter<DiagnosticTestScalpEEGEntity> converter = new CollectionConverter<>();
		Sorter<DiagnosticTestScalpEEGEntity> sorter = new Sorter<>();
		return sorter.sortByDate(converter
				.toList(this.diagnosticTestScalpEEGList));
	}

	public void setDiagnosticTestEEGList(
			List<DiagnosticTestScalpEEGEntity> diagnosticTestEEGList) {
		CollectionConverter<DiagnosticTestScalpEEGEntity> converter = new CollectionConverter<>();
		this.diagnosticTestScalpEEGList = converter
				.toSet(diagnosticTestEEGList);
	}

	public List<InvasiveTestECOGEntity> getInvasiveTestECOGList() {
		CollectionConverter<InvasiveTestECOGEntity> converter = new CollectionConverter<>();
		Sorter<InvasiveTestECOGEntity> sorter = new Sorter<>();
		return sorter.sortByDate(converter.toList(this.invasiveTestECOGList));

	}

	public void setInvasiveTestECOGList(
			List<InvasiveTestECOGEntity> invasiveTestECOGList) {
		CollectionConverter<InvasiveTestECOGEntity> converter = new CollectionConverter<>();
		this.invasiveTestECOGList = converter.toSet(invasiveTestECOGList);

	}

	public List<InvasiveTestCorticalMappingEntity> getInvasiveTestCorticalMappingList() {
		CollectionConverter<InvasiveTestCorticalMappingEntity> converter = new CollectionConverter<>();
		Sorter<InvasiveTestCorticalMappingEntity> sorter = new Sorter<>();
		return sorter.sortByDate(converter
				.toList(this.invasiveTestCorticalMappingList));

	}

	public void setInvasiveTestCorticalMappingList(
			List<InvasiveTestCorticalMappingEntity> InvasiveTestCorticalMappingList) {
		CollectionConverter<InvasiveTestCorticalMappingEntity> converter = new CollectionConverter<>();
		this.invasiveTestCorticalMappingList = converter
				.toSet(InvasiveTestCorticalMappingList);

	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the nin.
	 * 
	 * @return the nin
	 */
	public String getNin() {
		return nin;
	}

	/**
	 * Sets the nin.
	 * 
	 * @param nin
	 *            the new nin
	 */
	public void setNin(String nin) {
		this.nin = nin;
	}

	/**
	 * Gets the birthday.
	 * 
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * Sets the birthday.
	 * 
	 * @param birthday
	 *            the new birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * Gets the gender.
	 * 
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 * 
	 * @param gender
	 *            the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the checked.
	 * 
	 * @return the checked
	 */
	public boolean getChecked() {
		return checked;
	}

	/**
	 * Sets the checked.
	 * 
	 * @param checked
	 *            the new checked
	 */
	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	/**
	 * Gets the contact.
	 * 
	 * @return the contact
	 */
	public ContactEntity getContact() {
		return contact;
	}

	/**
	 * Sets the contact.
	 * 
	 * @param contact
	 *            the new contact
	 */
	public void setContact(ContactEntity contact) {
		this.contact = contact;
	}

	public UserEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(UserEntity doctor) {
		this.doctor = doctor;
	}

}

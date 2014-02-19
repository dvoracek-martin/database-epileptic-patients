package cz.cvut.fit.genepi.dataLayer.entity;

import cz.cvut.fit.genepi.dataLayer.entity.card.*;
import cz.cvut.fit.genepi.util.CollectionConverter;
import cz.cvut.fit.genepi.util.Sorter;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Set;

// TODO: Auto-generated Javadoc

/**
 * The Class PatientEntity.
 */
@Entity
@Table(name = "patient")
/*@FilterDefs({@FilterDef(name = "neurologicalFindingListNoHidden"),
        @FilterDef(name = "neurologicalFindingListNoHistory")
})*/
public class PatientEntity {

    /**
     * The id.
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private int id;

    /**
     * The nin.
     */
    @Pattern(regexp = "[0-9]*")
    @Size(max = 10)
    @Column(name = "nin", length = 10)
    private String nin;

    /**
     * The birthday.
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @NotNull
    @Column(name = "birthday", nullable = false)
    private Date birthday;

    /**
     * The gender.
     */
    @NotBlank
    // @NotNull
    @Size(max = 10)
    @Column(name = "gender", length = 10, nullable = false)
    private String gender;

    @Column(name = "doctor_id", precision = 1, scale = 0)
    private int doctorId;

    /**
     * The deleted.
     */
    @Column(name = "status", precision = 1, scale = 0)
    private int status;

    /**
     * The checked.
     */
    @Column(name = "verified", precision = 1, scale = 0)
    private boolean verified;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", insertable = false, updatable = false)
    private UserEntity doctor;

	/* Relations */

    /**
     * The contact.
     */
    @Valid
    @OneToOne
    @Cascade({CascadeType.SAVE_UPDATE})
    private ContactEntity contact;

    /* AnamnesisList */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    @Cascade({CascadeType.ALL})
    private Set<AnamnesisEntity> anamnesisList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    @Cascade({CascadeType.ALL})
    private Set<ComplicationEntity> complicationList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    @Cascade({CascadeType.ALL})
    private Set<DiagnosticTestScalpEegEntity> diagnosticTestScalpEegList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    @Cascade({CascadeType.ALL})
    private Set<DiagnosticTestMriEntity> diagnosticTestMRIList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    @Cascade({CascadeType.ALL})
    private Set<HistologyEntity> histologyList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    @Cascade({CascadeType.ALL})
    private Set<InvasiveTestCorticalMappingEntity> invasiveTestCorticalMappingList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    @Cascade({CascadeType.ALL})
    private Set<InvasiveTestEcogEntity> invasiveTestECOGList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    @Cascade({CascadeType.ALL})
    private Set<InvasiveTestEegEntity> invasiveTestEEGList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    @Cascade({CascadeType.ALL})
   /* @Filters({
            @Filter(name = "neurologicalFindingListNoHistory", condition = "history = 0"),
            @Filter(name = "neurologicalFindingListNoHidden", condition = "hidden = 0")})*/
    private Set<NeurologicalFindingEntity> neurologicalFindingList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    @Cascade({CascadeType.ALL})
    private Set<NeuropsychologyEntity> neuropsychologyList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    @Cascade({CascadeType.ALL})
    private Set<NeuropsychologyOldEntity> neuropsychologyOldList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    @Cascade({CascadeType.ALL})
    private Set<OperationEntity> operationList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    @Cascade({CascadeType.ALL})
    private Set<OutcomeEntity> outcomeList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    @Cascade({CascadeType.ALL})
    private Set<PharmacotherapyEntity> pharmacotherapyList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
    @Cascade({CascadeType.ALL})
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

    public List<NeuropsychologyOldEntity> getNeuropsychologyOldList() {
        CollectionConverter<NeuropsychologyOldEntity> converter = new CollectionConverter<>();
        Sorter<NeuropsychologyOldEntity> sorter = new Sorter<>();
        return sorter.sortByDate(converter.toList(this.neuropsychologyOldList));
    }

    public void setNeuropsychologyOldList(
            List<NeuropsychologyOldEntity> neuropsychologyOldList) {
        CollectionConverter<NeuropsychologyOldEntity> converter = new CollectionConverter<>();
        this.neuropsychologyOldList = converter.toSet(neuropsychologyOldList);
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

    public List<InvasiveTestEegEntity> getInvasiveTestEEGList() {
        CollectionConverter<InvasiveTestEegEntity> converter = new CollectionConverter<>();
        Sorter<InvasiveTestEegEntity> sorter = new Sorter<>();
        return sorter.sortByDate(converter.toList(this.invasiveTestEEGList));
    }

    public void setInvasiveTestEEGList(
            List<InvasiveTestEegEntity> invasiveTestEEGList) {
        CollectionConverter<InvasiveTestEegEntity> converter = new CollectionConverter<>();
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

    public List<DiagnosticTestMriEntity> getDiagnosticTestMRIList() {
        CollectionConverter<DiagnosticTestMriEntity> converter = new CollectionConverter<>();
        Sorter<DiagnosticTestMriEntity> sorter = new Sorter<>();
        return sorter.sortByDate(converter.toList(this.diagnosticTestMRIList));
    }

    public void setDiagnosticTestMRIList(
            List<DiagnosticTestMriEntity> diagnosticTestMRIList) {
        CollectionConverter<DiagnosticTestMriEntity> converter = new CollectionConverter<>();
        this.diagnosticTestMRIList = converter.toSet(diagnosticTestMRIList);
    }

    public List<DiagnosticTestScalpEegEntity> getDiagnosticTestScalpEegList() {
        CollectionConverter<DiagnosticTestScalpEegEntity> converter = new CollectionConverter<>();
        Sorter<DiagnosticTestScalpEegEntity> sorter = new Sorter<>();
        return sorter.sortByDate(converter
                .toList(this.diagnosticTestScalpEegList));
    }

    public void setDiagnosticTestScalpEegList(
            List<DiagnosticTestScalpEegEntity> diagnosticTestEegList) {
        CollectionConverter<DiagnosticTestScalpEegEntity> converter = new CollectionConverter<>();
        this.diagnosticTestScalpEegList = converter
                .toSet(diagnosticTestEegList);
    }

    public List<InvasiveTestEcogEntity> getInvasiveTestECOGList() {
        CollectionConverter<InvasiveTestEcogEntity> converter = new CollectionConverter<>();
        Sorter<InvasiveTestEcogEntity> sorter = new Sorter<>();
        return sorter.sortByDate(converter.toList(this.invasiveTestECOGList));

    }

    public void setInvasiveTestECOGList(
            List<InvasiveTestEcogEntity> invasiveTestECOGList) {
        CollectionConverter<InvasiveTestEcogEntity> converter = new CollectionConverter<>();
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
     * @param id the new id
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
     * @param nin the new nin
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
     * @param birthday the new birthday
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
     * @param gender the new gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    /**
     * Gets the checked.
     *
     * @return the checked
     */
    public boolean getChecked() {
        return verified;
    }

    /**
     * Sets the checked.
     *
     * @param checked the new checked
     */
    public void setChecked(boolean checked) {
        this.verified = checked;
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
     * @param contact the new contact
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

package cz.cvut.fit.genepi.dataLayer.entity.card;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

// TODO: Auto-generated Javadoc

/**
 * The Class AnamnesisEntity.
 */
@Entity
@Table(name = "anamnesis")
public class AnamnesisEntity implements Comparable<AnamnesisEntity> {

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
    //@NotNull
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @NotNull
    @Column(name = "date", nullable = false)
    private Date date;

    /**
     * The epilepsy in family.
     */
    @Column(name = "epilepsy_in_family")
    private boolean epilepsyInFamily;

    /**
     * The prenatal risk.
     */
    @Column(name = "prenatal_risk")
    private boolean prenatalRisk;

    /**
     * The fibril convulsions.
     */
    @Column(name = "fibril_convulsions")
    private boolean fibrilConvulsions;

    /**
     * The inflammation cns.
     */
    @Column(name = "inflammation_cns")
    private boolean inflammationCns;

    /**
     * The injury cns.
     */
    @Column(name = "injury_cns")
    private boolean injuryCns;

    /**
     * The operation cns.
     */
    @Column(name = "operation_cns")
    private boolean operationCns;

    /**
     * The early pmd retardation.
     */
    @Column(name = "early_pmd_retardation")
    private boolean earlyPmdRetardation;

    /**
     * The beginning epilepsy.
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @NotNull
    @Column(name = "beginning_epilepsy", length = 7)
    private Date beginningEpilepsy;

    /**
     * The first fever.
     */
    @Column(name = "first_fever")
    private boolean firstFever;

    /**
     * The infantile spasm.
     */
    @Column(name = "infantile_spasm")
    private boolean infantileSpasm;

    /**
     * The specific syndrome idcom.
     */
    @Column(name = "specific_syndrome")
    private int specificSyndrome;

    /**
     * The non cns comorbidity.
     */
    @Size(max = 800)
    @Column(name = "non_cns_comorbidity", length = 800)
    private String nonCnsComorbidity;

    /**
     * The comment.
     */
    @Size(max = 800)
    @Column(name = "comment", length = 800)
    private String comment;

    @Override
    public int compareTo(AnamnesisEntity o) {
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

    public boolean isEpilepsyInFamily() {
        return epilepsyInFamily;
    }

    public void setEpilepsyInFamily(boolean epilepsyInFamily) {
        this.epilepsyInFamily = epilepsyInFamily;
    }

    public boolean isPrenatalRisk() {
        return prenatalRisk;
    }

    public void setPrenatalRisk(boolean prenatalRisk) {
        this.prenatalRisk = prenatalRisk;
    }

    public boolean isFibrilConvulsions() {
        return fibrilConvulsions;
    }

    public void setFibrilConvulsions(boolean fibrilConvulsions) {
        this.fibrilConvulsions = fibrilConvulsions;
    }

    public boolean isInflammationCns() {
        return inflammationCns;
    }

    public void setInflammationCns(boolean inflammationCns) {
        this.inflammationCns = inflammationCns;
    }

    public boolean isInjuryCns() {
        return injuryCns;
    }

    public void setInjuryCns(boolean injuryCns) {
        this.injuryCns = injuryCns;
    }

    public boolean isOperationCns() {
        return operationCns;
    }

    public void setOperationCns(boolean operationCns) {
        this.operationCns = operationCns;
    }

    public boolean isEarlyPmdRetardation() {
        return earlyPmdRetardation;
    }

    public void setEarlyPmdRetardation(boolean earlyPmdRetardation) {
        this.earlyPmdRetardation = earlyPmdRetardation;
    }

    public Date getBeginningEpilepsy() {
        return beginningEpilepsy;
    }

    public void setBeginningEpilepsy(Date beginningEpilepsy) {
        this.beginningEpilepsy = beginningEpilepsy;
    }

    public boolean isFirstFever() {
        return firstFever;
    }

    public void setFirstFever(boolean firstFever) {
        this.firstFever = firstFever;
    }

    public boolean isInfantileSpasm() {
        return infantileSpasm;
    }

    public void setInfantileSpasm(boolean infantileSpasm) {
        this.infantileSpasm = infantileSpasm;
    }

    public int getSpecificSyndrome() {
        return specificSyndrome;
    }

    public void setSpecificSyndrome(int specificSyndrome) {
        this.specificSyndrome = specificSyndrome;
    }

    public String getNonCnsComorbidity() {
        return nonCnsComorbidity;
    }

    public void setNonCnsComorbidity(String nonCnsComorbidity) {
        this.nonCnsComorbidity = nonCnsComorbidity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

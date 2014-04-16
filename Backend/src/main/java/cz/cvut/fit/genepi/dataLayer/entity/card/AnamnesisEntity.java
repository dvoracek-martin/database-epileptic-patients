package cz.cvut.fit.genepi.dataLayer.entity.card;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * The Class AnamnesisEntity.
 */
@Entity
@Table(name = "anamnesis")
public class AnamnesisEntity implements Comparable<AnamnesisEntity> {

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

    @Column(name = "history", nullable = false)
    private boolean history;

	/* Other fields */

    /**
     * The date.
     */
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
    @Column(name = "non_cns_comorbidity")
    private String nonCnsComorbidity;

    /**
     * The comment.
     */
    @Column(name = "comment")
    private String comment;

    @Override
    public int compareTo(AnamnesisEntity o) {
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

package cz.cvut.fit.genepi.dataLayer.entity.card;

import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "operation")
public class OperationEntity implements Comparable<OperationEntity> {

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

    @Column(name = "date_operation", nullable = false)
    private Date dateOperation;

    @Column(name = "type_operation")
    private int typeOperation;

    @Column(name = "range_operation")
    private int rangeOperation;

    @Column(name = "localization_operation", length = 800)
    private String localizationOperation;

    @Column(name = "mst")
    private boolean mst;

    @Column(name = "colostomy")
    private boolean colostomy;

    @Column(name = "vns")
    private boolean vns;

    @Column(name = "vns_implantation_date")
    private Date vnsImplantationDate;

    @Column(name = "operation_details", length = 800)
    private String operationDetails;

    @Column(name = "complete_resection")
    private boolean completeResection;

    /**
     * The comment.
     */
    @Column(name = "comment", length = 800, nullable = true)
    private String comment;

	/* Relations */

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "operation")
    private List<OutcomeEntity> outcomeList;

    @Override
    public int compareTo(OperationEntity o) {
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

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public int getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(int typeOperation) {
        this.typeOperation = typeOperation;
    }

    public int getRangeOperation() {
        return rangeOperation;
    }

    public void setRangeOperation(int rangeOperation) {
        this.rangeOperation = rangeOperation;
    }

    public String getLocalizationOperation() {
        return localizationOperation;
    }

    public void setLocalizationOperation(String localizationOperation) {
        this.localizationOperation = localizationOperation;
    }

    public boolean isMst() {
        return mst;
    }

    public void setMst(boolean mst) {
        this.mst = mst;
    }

    public boolean isColostomy() {
        return colostomy;
    }

    public void setColostomy(boolean colostomy) {
        this.colostomy = colostomy;
    }

    public boolean isVns() {
        return vns;
    }

    public void setVns(boolean vns) {
        this.vns = vns;
    }

    public Date getVnsImplantationDate() {
        return vnsImplantationDate;
    }

    public void setVnsImplantationDate(Date vNSImplantationDate) {
        vnsImplantationDate = vNSImplantationDate;
    }

    public String getOperationDetails() {
        return operationDetails;
    }

    public void setOperationDetails(String operationDetails) {
        this.operationDetails = operationDetails;
    }

    public boolean isCompleteResection() {
        return completeResection;
    }

    public void setCompleteResection(boolean completeResection) {
        this.completeResection = completeResection;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    public List<OutcomeEntity> getOutcomeList() {
        return outcomeList;
    }

    public void setOutcomeList(List<OutcomeEntity> outcomeList) {
        this.outcomeList = outcomeList;
    }
}

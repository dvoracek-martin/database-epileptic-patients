package cz.cvut.fit.genepi.businessLayer.VO.form.card;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by Jan on 25.1.14.
 */
public class OperationVO {

    private int id;

    private int patientId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @NotNull
    private Date date;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @NotNull
    private Date dateOperation;

    private int typeOperation;

    private int rangeOperation;

    private String localizationOperation;

    private boolean mst;

    private boolean colostomy;

    private boolean vns;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private Date vnsImplantationDate;

    private String operationDetails;

    private boolean completeResection;

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

    public void setVnsImplantationDate(Date vnsImplantationDate) {
        this.vnsImplantationDate = vnsImplantationDate;
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
}

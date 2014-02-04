package cz.cvut.fit.genepi.businessLayer.VO.form;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Jan on 25.1.14.
 */
public class OutcomeVO {

    private int id;

    private int patientId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @NotNull
    private Date date;

    private int seizureOutcome;

    private int aed;

    private int eeg;

    private int mri;

    private int neuropsychology;

    private int distance;

    private int operationId;

    @Size(max = 800)
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

    public int getSeizureOutcome() {
        return seizureOutcome;
    }

    public void setSeizureOutcome(int seizureOutcome) {
        this.seizureOutcome = seizureOutcome;
    }

    public int getAed() {
        return aed;
    }

    public void setAed(int aed) {
        this.aed = aed;
    }

    public int getEeg() {
        return eeg;
    }

    public void setEeg(int eeg) {
        this.eeg = eeg;
    }

    public int getMri() {
        return mri;
    }

    public void setMri(int mri) {
        this.mri = mri;
    }

    public int getNeuropsychology() {
        return neuropsychology;
    }

    public void setNeuropsychology(int neuropsychology) {
        this.neuropsychology = neuropsychology;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
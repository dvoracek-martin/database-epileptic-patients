package cz.cvut.fit.genepi.businessLayer.VO.form;

import cz.cvut.fit.genepi.dataLayer.entity.card.OperationEntity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by Jan on 25.1.14.
 */
public class OutcomeVO {

    private int id;

    private int patientId;

    private int seizureOutcome;

    private int aed;

    private int eeg;

    private int mri;

    private int neuropsychology;

    private int distance;

    private int operationId;

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
}
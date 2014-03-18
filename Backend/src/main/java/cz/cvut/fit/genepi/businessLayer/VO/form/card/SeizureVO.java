package cz.cvut.fit.genepi.businessLayer.VO.form.card;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

public class SeizureVO {

    private int id;

    private int patientId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @NotNull
    private Date date;

    @Min(1)
    private int seizureFrequency;

    private boolean secondarilyGeneralizedSeizure;

    private boolean statusEpilepticus;

    private boolean nonepilepticSeizures;

    private int seizureOccurrence;

    private String comment;

    private List<SeizureDetailVO> seizureDetailList;

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

    public int getSeizureFrequency() {
        return seizureFrequency;
    }

    public void setSeizureFrequency(int seizureFrequency) {
        this.seizureFrequency = seizureFrequency;
    }

    public boolean isSecondarilyGeneralizedSeizure() {
        return secondarilyGeneralizedSeizure;
    }

    public void setSecondarilyGeneralizedSeizure(boolean secondarilyGeneralizedSeizure) {
        this.secondarilyGeneralizedSeizure = secondarilyGeneralizedSeizure;
    }

    public boolean isStatusEpilepticus() {
        return statusEpilepticus;
    }

    public void setStatusEpilepticus(boolean statusEpilepticus) {
        this.statusEpilepticus = statusEpilepticus;
    }

    public boolean isNonepilepticSeizures() {
        return nonepilepticSeizures;
    }

    public void setNonepilepticSeizures(boolean nonepilepticSeizures) {
        this.nonepilepticSeizures = nonepilepticSeizures;
    }

    public int getSeizureOccurrence() {
        return seizureOccurrence;
    }

    public void setSeizureOccurrence(int seizureOccurrence) {
        this.seizureOccurrence = seizureOccurrence;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<SeizureDetailVO> getSeizureDetailList() {
        return seizureDetailList;
    }

    public void setSeizureDetailList(List<SeizureDetailVO> seizureDetailList) {
        this.seizureDetailList = seizureDetailList;
    }
}

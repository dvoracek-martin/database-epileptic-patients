package cz.cvut.fit.genepi.businessLayer.VO.form.card;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Jan on 21.1.14.
 */
public class SeizureDetailVO {

    private int id;

    private int patientId;

    private int seizureId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @NotNull
    private Date date;

    private int sscClassification;

    private int ilaeClassification;

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

    public int getSeizureId() {
        return seizureId;
    }

    public void setSeizureId(int seizureId) {
        this.seizureId = seizureId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSscClassification() {
        return sscClassification;
    }

    public void setSscClassification(int sscClassification) {
        this.sscClassification = sscClassification;
    }

    public int getIlaeClassification() {
        return ilaeClassification;
    }

    public void setIlaeClassification(int ilaeClassification) {
        this.ilaeClassification = ilaeClassification;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

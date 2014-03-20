package cz.cvut.fit.genepi.businessLayer.VO.form.card;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by Jan on 25.1.14.
 */
public class ComplicationVO {

    private int id;

    private int patientId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @NotNull
    private Date date;

    private int withComplication;

    private int complicationType;

    private int complication;

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

    public int getWithComplication() {
        return withComplication;
    }

    public void setWithComplication(int withComplication) {
        this.withComplication = withComplication;
    }

    public int getComplicationType() {
        return complicationType;
    }

    public void setComplicationType(int complicationType) {
        this.complicationType = complicationType;
    }

    public int getComplication() {
        return complication;
    }

    public void setComplication(int complication) {
        this.complication = complication;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

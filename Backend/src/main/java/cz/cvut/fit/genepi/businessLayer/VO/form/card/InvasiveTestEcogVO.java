package cz.cvut.fit.genepi.businessLayer.VO.form.card;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Jan on 25.1.14.
 */
public class InvasiveTestEcogVO {

    private int id;

    private int patientId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @NotNull
    private Date date;

    private int done;

    @Size(max = 800)
    private String ecogCover;

    private int ecogPatterns;

    private int afterResectionEcog;

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

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public String getEcogCover() {
        return ecogCover;
    }

    public void setEcogCover(String ecogCover) {
        this.ecogCover = ecogCover;
    }

    public int getEcogPatterns() {
        return ecogPatterns;
    }

    public void setEcogPatterns(int ecogPatterns) {
        this.ecogPatterns = ecogPatterns;
    }

    public int getAfterResectionEcog() {
        return afterResectionEcog;
    }

    public void setAfterResectionEcog(int afterResectionEcog) {
        this.afterResectionEcog = afterResectionEcog;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

package cz.cvut.fit.genepi.businessLayer.VO.form;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Jan on 25.1.14.
 */
public class DiagnosticTestScalpEegVO {

    private int id;

    private int patientId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @NotNull
    private Date date;

    private int done;

    private int basicEegActivity;

    private int eegSlow;

    private int interictalEegSpikes;

    @Size(max = 800)
    private String localizationInterictalEegSpikes;

    private boolean eegStatusEpilepticus;

    private boolean secondarySidedSynchrony;

    private int ictalEegPatterns;

    @Size(max = 800)
    private String localizationIctalEegPattern;

    @Size(max = 800)
    private String descriptionVideoEeg;

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

    public int getBasicEegActivity() {
        return basicEegActivity;
    }

    public void setBasicEegActivity(int basicEegActivity) {
        this.basicEegActivity = basicEegActivity;
    }

    public int getEegSlow() {
        return eegSlow;
    }

    public void setEegSlow(int eegSlow) {
        this.eegSlow = eegSlow;
    }

    public int getInterictalEegSpikes() {
        return interictalEegSpikes;
    }

    public void setInterictalEegSpikes(int interictalEegSpikes) {
        this.interictalEegSpikes = interictalEegSpikes;
    }

    public String getLocalizationInterictalEegSpikes() {
        return localizationInterictalEegSpikes;
    }

    public void setLocalizationInterictalEegSpikes(String localizationInterictalEegSpikes) {
        this.localizationInterictalEegSpikes = localizationInterictalEegSpikes;
    }

    public boolean isEegStatusEpilepticus() {
        return eegStatusEpilepticus;
    }

    public void setEegStatusEpilepticus(boolean eegStatusEpilepticus) {
        this.eegStatusEpilepticus = eegStatusEpilepticus;
    }

    public boolean isSecondarySidedSynchrony() {
        return secondarySidedSynchrony;
    }

    public void setSecondarySidedSynchrony(boolean secondarySidedSynchrony) {
        this.secondarySidedSynchrony = secondarySidedSynchrony;
    }

    public int getIctalEegPatterns() {
        return ictalEegPatterns;
    }

    public void setIctalEegPatterns(int ictalEegPatterns) {
        this.ictalEegPatterns = ictalEegPatterns;
    }

    public String getLocalizationIctalEegPattern() {
        return localizationIctalEegPattern;
    }

    public void setLocalizationIctalEegPattern(String localizationIctalEegPattern) {
        this.localizationIctalEegPattern = localizationIctalEegPattern;
    }

    public String getDescriptionVideoEeg() {
        return descriptionVideoEeg;
    }

    public void setDescriptionVideoEeg(String descriptionVideoEeg) {
        this.descriptionVideoEeg = descriptionVideoEeg;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

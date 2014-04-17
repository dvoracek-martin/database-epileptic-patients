package cz.cvut.fit.genepi.businessLayer.VO.form.card;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

public class InvasiveTestEegVO {

    private int id;

    private int patientId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @NotNull
    private Date date;

    private int done;

    private int intracranialElectrodes;

    private String localizationIntracranialElectrodes;

    private int invasiveEegSlow;

    private int invasiveEegInterictalSpikes;

    private String localizationInvasiveEegInterictalSpikes;

    private boolean invasiveEegStatusEpilepticus;

    private int invasiveIctalEegPatterns;

    private String localizationInvasiveIctalEegPatterns;

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

    public int getIntracranialElectrodes() {
        return intracranialElectrodes;
    }

    public void setIntracranialElectrodes(int intracranialElectrodes) {
        this.intracranialElectrodes = intracranialElectrodes;
    }

    public String getLocalizationIntracranialElectrodes() {
        return localizationIntracranialElectrodes;
    }

    public void setLocalizationIntracranialElectrodes(String localizationIntracranialElectrodes) {
        this.localizationIntracranialElectrodes = localizationIntracranialElectrodes;
    }

    public int getInvasiveEegSlow() {
        return invasiveEegSlow;
    }

    public void setInvasiveEegSlow(int invasiveEegSlow) {
        this.invasiveEegSlow = invasiveEegSlow;
    }

    public int getInvasiveEegInterictalSpikes() {
        return invasiveEegInterictalSpikes;
    }

    public void setInvasiveEegInterictalSpikes(int invasiveEegInterictalSpikes) {
        this.invasiveEegInterictalSpikes = invasiveEegInterictalSpikes;
    }

    public String getLocalizationInvasiveEegInterictalSpikes() {
        return localizationInvasiveEegInterictalSpikes;
    }

    public void setLocalizationInvasiveEegInterictalSpikes(String localizationInvasiveEegInterictalSpikes) {
        this.localizationInvasiveEegInterictalSpikes = localizationInvasiveEegInterictalSpikes;
    }

    public boolean isInvasiveEegStatusEpilepticus() {
        return invasiveEegStatusEpilepticus;
    }

    public void setInvasiveEegStatusEpilepticus(boolean invasiveEegStatusEpilepticus) {
        this.invasiveEegStatusEpilepticus = invasiveEegStatusEpilepticus;
    }

    public int getInvasiveIctalEegPatterns() {
        return invasiveIctalEegPatterns;
    }

    public void setInvasiveIctalEegPatterns(int invasiveIctalEegPatterns) {
        this.invasiveIctalEegPatterns = invasiveIctalEegPatterns;
    }

    public String getLocalizationInvasiveIctalEegPatterns() {
        return localizationInvasiveIctalEegPatterns;
    }

    public void setLocalizationInvasiveIctalEegPatterns(String localizationInvasiveIctalEegPatterns) {
        this.localizationInvasiveIctalEegPatterns = localizationInvasiveIctalEegPatterns;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

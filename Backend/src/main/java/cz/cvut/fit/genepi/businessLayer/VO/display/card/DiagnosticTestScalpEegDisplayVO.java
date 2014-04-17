package cz.cvut.fit.genepi.businessLayer.VO.display.card;

public class DiagnosticTestScalpEegDisplayVO {

    private int id;

    private String date;

    private int done;

    private int basicEegActivity;

    private int eegSlow;

    private int interictalEegSpikes;

    private String localizationInterictalEegSpikes;

    private boolean eegStatusEpilepticus;

    private boolean secondarySidedSynchrony;

    private int ictalEegPatterns;

    private String localizationIctalEegPattern;

    private String descriptionVideoEeg;

    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

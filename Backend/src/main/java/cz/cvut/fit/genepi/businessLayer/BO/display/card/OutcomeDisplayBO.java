package cz.cvut.fit.genepi.businessLayer.BO.display.card;

public class OutcomeDisplayBO {

    private int id;

    private int seizureOutcome;

    private int aed;

    private int eeg;

    private int mri;

    private int neuropsychology;

    private int distance;

    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

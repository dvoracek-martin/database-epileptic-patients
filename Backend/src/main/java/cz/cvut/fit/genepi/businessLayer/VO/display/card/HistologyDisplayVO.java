package cz.cvut.fit.genepi.businessLayer.VO.display.card;

public class HistologyDisplayVO {

    private int id;

    private String date;

    private int histopathology;

    private int fcdClassification;

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

    public int getHistopathology() {
        return histopathology;
    }

    public void setHistopathology(int histopathology) {
        this.histopathology = histopathology;
    }

    public int getFcdClassification() {
        return fcdClassification;
    }

    public void setFcdClassification(int fcdClassification) {
        this.fcdClassification = fcdClassification;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

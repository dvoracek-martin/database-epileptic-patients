package cz.cvut.fit.genepi.businessLayer.VO.display.card;

/**
 * Created by Jan on 21.1.14.
 */
public class SeizureDetailDisplayVO {

    private int id;

    private String date;

    private int sscClassification;

    private int ilaeClassification;

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
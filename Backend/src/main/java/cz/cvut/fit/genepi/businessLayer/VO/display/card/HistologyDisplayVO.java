package cz.cvut.fit.genepi.businessLayer.VO.display.card;

/**
 * Created by Jan on 25.1.14.
 */
public class HistologyDisplayVO {

    private int id;

    private String date;

    private int histopathology;

    private int fcdClasification;

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

    public int getFcdClasification() {
        return fcdClasification;
    }

    public void setFcdClasification(int fcdClasification) {
        this.fcdClasification = fcdClasification;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

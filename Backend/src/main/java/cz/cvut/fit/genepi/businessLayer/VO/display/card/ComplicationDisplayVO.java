package cz.cvut.fit.genepi.businessLayer.VO.display.card;

/**
 * Created by Jan on 25.1.14.
 */
public class ComplicationDisplayVO {

    private int id;

    private String date;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

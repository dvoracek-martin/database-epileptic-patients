package cz.cvut.fit.genepi.businessLayer.VO.display.card;

/**
 * Created by Jan on 25.1.14.
 */
public class InvasiveTestEcogDisplayVO {

    private int id;

    private String date;

    private boolean done;

    private String ecogCover;

    private int ecogPatterns;

    private int afterResectionEcog;

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

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
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
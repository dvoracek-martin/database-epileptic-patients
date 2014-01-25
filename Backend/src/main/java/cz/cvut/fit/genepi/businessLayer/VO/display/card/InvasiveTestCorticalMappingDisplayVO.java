package cz.cvut.fit.genepi.businessLayer.VO.display.card;

/**
 * Created by Jan on 25.1.14.
 */
public class InvasiveTestCorticalMappingDisplayVO {

    private int id;

    private String date;

    private boolean done;

    private int corticalMapping;

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

    public int getCorticalMapping() {
        return corticalMapping;
    }

    public void setCorticalMapping(int corticalMapping) {
        this.corticalMapping = corticalMapping;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

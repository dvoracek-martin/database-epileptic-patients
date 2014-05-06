package cz.cvut.fit.genepi.businessLayer.BO.display.card;

public class InvasiveTestCorticalMappingDisplayBO {

    private int id;

    private String date;

    private int done;

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

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
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

package cz.cvut.fit.genepi.businessLayer.VO.display.card;

/**
 * Created by Jan on 20.1.14.
 */
public class NeurologicalFindingDisplayVO {

    private int id;

    private String date;

    private int hemisphereDominance;

    private boolean abnormalNeurologicalFinding;

    private boolean hemiparesis;

    private boolean visualFieldDefects;

    private String comment;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHemisphereDominance() {
        return hemisphereDominance;
    }

    public void setHemisphereDominance(int hemisphereDominance) {
        this.hemisphereDominance = hemisphereDominance;
    }

    public boolean isAbnormalNeurologicalFinding() {
        return abnormalNeurologicalFinding;
    }

    public void setAbnormalNeurologicalFinding(boolean abnormalNeurologicalFinding) {
        this.abnormalNeurologicalFinding = abnormalNeurologicalFinding;
    }

    public boolean isHemiparesis() {
        return hemiparesis;
    }

    public void setHemiparesis(boolean hemiparesis) {
        this.hemiparesis = hemiparesis;
    }

    public boolean isVisualFieldDefects() {
        return visualFieldDefects;
    }

    public void setVisualFieldDefects(boolean visualFieldDefects) {
        this.visualFieldDefects = visualFieldDefects;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

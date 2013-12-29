package cz.cvut.fit.genepi.businessLayer.BO;

import java.util.Date;

/**
 * Created by Jan on 29.12.13.
 */
public class NeurologicalFindingBO {

    private int id;

    private int addUserId;

    private Date added;

    //private PatientEntity patient;

    private int status;

	/* Other fields */

    private String date;

    private String hemisphereDominance;

    private boolean abnormalNeurologicalFinding;

    private boolean hemiparesis;

    private boolean visualFieldDefects;

    private String comment;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(int addUserId) {
        this.addUserId = addUserId;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHemisphereDominance() {
        return hemisphereDominance;
    }

    public void setHemisphereDominance(String hemisphereDominance) {
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

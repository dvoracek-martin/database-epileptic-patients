package cz.cvut.fit.genepi.businessLayer.VO.display.card;

/**
 * Created by Jan on 22.1.14.
 */
public class PharmacotherapyDisplayVO {


    private int id;

    private String date;

    private int aed;

    private int efficiency;

    private boolean duringSurgery;

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

    public int getAed() {
        return aed;
    }

    public void setAed(int aed) {
        this.aed = aed;
    }

    public int getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(int efficiency) {
        this.efficiency = efficiency;
    }

    public boolean isDuringSurgery() {
        return duringSurgery;
    }

    public void setDuringSurgery(boolean duringSurgery) {
        this.duringSurgery = duringSurgery;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

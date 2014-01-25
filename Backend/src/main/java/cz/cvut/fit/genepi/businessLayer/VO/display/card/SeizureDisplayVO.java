package cz.cvut.fit.genepi.businessLayer.VO.display.card;

import java.util.List;

/**
 * Created by Jan on 21.1.14.
 */
public class SeizureDisplayVO {

    private int id;

    private String date;

    private int seizureFrequency;

    private boolean secondarilyGeneralizedSeizure;

    private boolean statusEpilepticus;

    private boolean nonepilepticSeizures;

    private int seizureOccurrence;

    private String comment;

    private List<SeizureDetailDisplayVO> seizureDetailList;

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

    public int getSeizureFrequency() {
        return seizureFrequency;
    }

    public void setSeizureFrequency(int seizureFrequency) {
        this.seizureFrequency = seizureFrequency;
    }

    public boolean isSecondarilyGeneralizedSeizure() {
        return secondarilyGeneralizedSeizure;
    }

    public void setSecondarilyGeneralizedSeizure(boolean secondarilyGeneralizedSeizure) {
        this.secondarilyGeneralizedSeizure = secondarilyGeneralizedSeizure;
    }

    public boolean isStatusEpilepticus() {
        return statusEpilepticus;
    }

    public void setStatusEpilepticus(boolean statusEpilepticus) {
        this.statusEpilepticus = statusEpilepticus;
    }

    public boolean isNonepilepticSeizures() {
        return nonepilepticSeizures;
    }

    public void setNonepilepticSeizures(boolean nonepilepticSeizures) {
        this.nonepilepticSeizures = nonepilepticSeizures;
    }

    public int getSeizureOccurrence() {
        return seizureOccurrence;
    }

    public void setSeizureOccurrence(int seizureOccurrence) {
        this.seizureOccurrence = seizureOccurrence;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<SeizureDetailDisplayVO> getSeizureDetailList() {
        return seizureDetailList;
    }

    public void setSeizureDetailList(List<SeizureDetailDisplayVO> seizureDetailList) {
        this.seizureDetailList = seizureDetailList;
    }
}

package cz.cvut.fit.genepi.businessLayer.VO.display.card;

/**
 * Created by Jan on 25.1.14.
 */
public class NeuropsychologyOldDisplayVO {

    private int id;

    private String date;

    private int intelligenceLevel;

    private boolean neuropsychologicalExamination;

    private boolean specificLearning;

    private boolean developmentalLanguageDisorders;

    private boolean adhdSyndrome;

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

    public int getIntelligenceLevel() {
        return intelligenceLevel;
    }

    public void setIntelligenceLevel(int intelligenceLevel) {
        this.intelligenceLevel = intelligenceLevel;
    }

    public boolean isNeuropsychologicalExamination() {
        return neuropsychologicalExamination;
    }

    public void setNeuropsychologicalExamination(boolean neuropsychologicalExamination) {
        this.neuropsychologicalExamination = neuropsychologicalExamination;
    }

    public boolean isSpecificLearning() {
        return specificLearning;
    }

    public void setSpecificLearning(boolean specificLearning) {
        this.specificLearning = specificLearning;
    }

    public boolean isDevelopmentalLanguageDisorders() {
        return developmentalLanguageDisorders;
    }

    public void setDevelopmentalLanguageDisorders(boolean developmentalLanguageDisorders) {
        this.developmentalLanguageDisorders = developmentalLanguageDisorders;
    }

    public boolean isAdhdSyndrome() {
        return adhdSyndrome;
    }

    public void setAdhdSyndrome(boolean adhdSyndrome) {
        this.adhdSyndrome = adhdSyndrome;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

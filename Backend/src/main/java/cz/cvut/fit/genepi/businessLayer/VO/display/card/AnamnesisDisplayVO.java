package cz.cvut.fit.genepi.businessLayer.VO.display.card;

/**
 * Created by Jan on 25.1.14.
 */
public class AnamnesisDisplayVO {

    private int id;

    private String date;

    private boolean epilepsyInFamily;

    private boolean prenatalRisk;

    private boolean fibrilConvulsions;

    private boolean inflammationCns;

    private boolean injuryCns;

    private boolean operationCns;

    private boolean earlyPmdRetardation;

    private boolean firstFever;

    private boolean infantileSpasm;

    private int specificSyndrome;

    private String nonCnsComorbidity;

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

    public boolean isEpilepsyInFamily() {
        return epilepsyInFamily;
    }

    public void setEpilepsyInFamily(boolean epilepsyInFamily) {
        this.epilepsyInFamily = epilepsyInFamily;
    }

    public boolean isPrenatalRisk() {
        return prenatalRisk;
    }

    public void setPrenatalRisk(boolean prenatalRisk) {
        this.prenatalRisk = prenatalRisk;
    }

    public boolean isFibrilConvulsions() {
        return fibrilConvulsions;
    }

    public void setFibrilConvulsions(boolean fibrilConvulsions) {
        this.fibrilConvulsions = fibrilConvulsions;
    }

    public boolean isInflammationCns() {
        return inflammationCns;
    }

    public void setInflammationCns(boolean inflammationCns) {
        this.inflammationCns = inflammationCns;
    }

    public boolean isInjuryCns() {
        return injuryCns;
    }

    public void setInjuryCns(boolean injuryCns) {
        this.injuryCns = injuryCns;
    }

    public boolean isOperationCns() {
        return operationCns;
    }

    public void setOperationCns(boolean operationCns) {
        this.operationCns = operationCns;
    }

    public boolean isEarlyPmdRetardation() {
        return earlyPmdRetardation;
    }

    public void setEarlyPmdRetardation(boolean earlyPmdRetardation) {
        this.earlyPmdRetardation = earlyPmdRetardation;
    }

    public boolean isFirstFever() {
        return firstFever;
    }

    public void setFirstFever(boolean firstFever) {
        this.firstFever = firstFever;
    }

    public boolean isInfantileSpasm() {
        return infantileSpasm;
    }

    public void setInfantileSpasm(boolean infantileSpasm) {
        this.infantileSpasm = infantileSpasm;
    }

    public int getSpecificSyndrome() {
        return specificSyndrome;
    }

    public void setSpecificSyndrome(int specificSyndrome) {
        this.specificSyndrome = specificSyndrome;
    }

    public String getNonCnsComorbidity() {
        return nonCnsComorbidity;
    }

    public void setNonCnsComorbidity(String nonCnsComorbidity) {
        this.nonCnsComorbidity = nonCnsComorbidity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

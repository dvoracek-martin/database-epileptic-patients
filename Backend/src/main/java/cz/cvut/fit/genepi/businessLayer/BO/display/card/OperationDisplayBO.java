package cz.cvut.fit.genepi.businessLayer.BO.display.card;

public class OperationDisplayBO {

    private int id;

    private String date;

    private String dateOperation;

    private int typeOperation;

    private int rangeOperation;

    private String localizationOperation;

    private boolean mst;

    private boolean colostomy;

    private boolean vns;

    private String vnsImplantationDate;

    private String operationDetails;

    private boolean completeResection;

    private String comment;

    private int ageAtOperation;

    private int epilepsyLastAtOperation;

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

    public String getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(String dateOperation) {
        this.dateOperation = dateOperation;
    }

    public int getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(int typeOperation) {
        this.typeOperation = typeOperation;
    }

    public int getRangeOperation() {
        return rangeOperation;
    }

    public void setRangeOperation(int rangeOperation) {
        this.rangeOperation = rangeOperation;
    }

    public String getLocalizationOperation() {
        return localizationOperation;
    }

    public void setLocalizationOperation(String localizationOperation) {
        this.localizationOperation = localizationOperation;
    }

    public boolean isMst() {
        return mst;
    }

    public void setMst(boolean mst) {
        this.mst = mst;
    }

    public boolean isColostomy() {
        return colostomy;
    }

    public void setColostomy(boolean colostomy) {
        this.colostomy = colostomy;
    }

    public boolean isVns() {
        return vns;
    }

    public void setVns(boolean vns) {
        this.vns = vns;
    }

    public String getVnsImplantationDate() {
        return vnsImplantationDate;
    }

    public void setVnsImplantationDate(String vnsImplantationDate) {
        this.vnsImplantationDate = vnsImplantationDate;
    }

    public String getOperationDetails() {
        return operationDetails;
    }

    public void setOperationDetails(String operationDetails) {
        this.operationDetails = operationDetails;
    }

    public boolean isCompleteResection() {
        return completeResection;
    }

    public void setCompleteResection(boolean completeResection) {
        this.completeResection = completeResection;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getAgeAtOperation() {
        return ageAtOperation;
    }

    public void setAgeAtOperation(int ageAtOperation) {
        this.ageAtOperation = ageAtOperation;
    }

    public int getEpilepsyLastAtOperation() {
        return epilepsyLastAtOperation;
    }

    public void setEpilepsyLastAtOperation(int epilepsyLastAtOperation) {
        this.epilepsyLastAtOperation = epilepsyLastAtOperation;
    }
}

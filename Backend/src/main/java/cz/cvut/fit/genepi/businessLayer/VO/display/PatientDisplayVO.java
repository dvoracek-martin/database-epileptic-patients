package cz.cvut.fit.genepi.businessLayer.VO.display;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.AnamnesisDisplayVO;

import java.util.List;


public class PatientDisplayVO {

    private int id;

    private String nin;

    private String birthday;

    private int age;

    private int ageAtTheBeginningOfEpilepsy;

    private String gender;

    //private int doctorId;

    //private int status;

    private boolean verified;

    private UserDisplayVO doctor;

    private ContactDisplayVO contact;

//    private List<AnamnesisDisplayVO> anamnesisList;
/*
    private List<SeizureDisplayVO> seizureList;

    private List<PharmacotherapyDisplayVO> pharmacotherapyList;

    private List<NeurologicalFindingDisplayVO> neurologicalFindingList;

    private List<NeuropsychologyDisplayVO> neuropsychologyList;

    private List<NeuropsychologyOldDisplayVO> neuropsychologyOldList;

    private List<DiagnosticTestScalpEegDisplayVO> diagnosticTestScalpEegList;

    private List<DiagnosticTestMriDisplayVO> diagnosticTestMriList;

    private List<InvasiveTestEcogDisplayVO> invasiveTestEcogList;

    private List<InvasiveTestEegDisplayVO> invasiveTestEegList;

    private List<InvasiveTestCorticalMappingDisplayVO> invasiveTestCorticalMappingList;

    private List<OperationDisplayVO> operationList;

    private List<HistologyDisplayVO> histologyList;

    private List<ComplicationDisplayVO> complicationList;

    private List<OutcomeDisplayVO> outcomeList;*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public UserDisplayVO getDoctor() {
        return doctor;
    }

    public void setDoctor(UserDisplayVO doctor) {
        this.doctor = doctor;
    }

    public ContactDisplayVO getContact() {
        return contact;
    }

    public void setContact(ContactDisplayVO contact) {
        this.contact = contact;
    }

/*    public List<AnamnesisDisplayVO> getAnamnesisList() {
        return anamnesisList;
    }

    public void setAnamnesisList(List<AnamnesisDisplayVO> anamnesisList) {
        this.anamnesisList = anamnesisList;
    }*/

    /*
        public List<SeizureDisplayVO> getSeizureList() {
            return seizureList;
        }

        public void setSeizureList(List<SeizureDisplayVO> seizureList) {
            this.seizureList = seizureList;
        }

        public List<PharmacotherapyDisplayVO> getPharmacotherapyList() {
            return pharmacotherapyList;
        }

        public void setPharmacotherapyList(List<PharmacotherapyDisplayVO> pharmacotherapyList) {
            this.pharmacotherapyList = pharmacotherapyList;
        }

        public List<NeurologicalFindingDisplayVO> getNeurologicalFindingList() {
            return neurologicalFindingList;
        }

        public void setNeurologicalFindingList(List<NeurologicalFindingDisplayVO> neurologicalFindingList) {
            this.neurologicalFindingList = neurologicalFindingList;
        }

        public List<NeuropsychologyDisplayVO> getNeuropsychologyList() {
            return neuropsychologyList;
        }

        public void setNeuropsychologyList(List<NeuropsychologyDisplayVO> neuropsychologyList) {
            this.neuropsychologyList = neuropsychologyList;
        }

        public List<NeuropsychologyOldDisplayVO> getNeuropsychologyOldList() {
            return neuropsychologyOldList;
        }

        public void setNeuropsychologyOldList(List<NeuropsychologyOldDisplayVO> neuropsychologyOldList) {
            this.neuropsychologyOldList = neuropsychologyOldList;
        }

        public List<DiagnosticTestScalpEegDisplayVO> getDiagnosticTestScalpEegList() {
            return diagnosticTestScalpEegList;
        }

        public void setDiagnosticTestScalpEegList(List<DiagnosticTestScalpEegDisplayVO> diagnosticTestScalpEegList) {
            this.diagnosticTestScalpEegList = diagnosticTestScalpEegList;
        }

        public List<DiagnosticTestMriDisplayVO> getDiagnosticTestMriList() {
            return diagnosticTestMriList;
        }

        public void setDiagnosticTestMriList(List<DiagnosticTestMriDisplayVO> diagnosticTestMriList) {
            this.diagnosticTestMriList = diagnosticTestMriList;
        }

        public List<InvasiveTestEcogDisplayVO> getInvasiveTestEcogList() {
            return invasiveTestEcogList;
        }

        public void setInvasiveTestEcogList(List<InvasiveTestEcogDisplayVO> invasiveTestEcogList) {
            this.invasiveTestEcogList = invasiveTestEcogList;
        }

        public List<InvasiveTestEegDisplayVO> getInvasiveTestEegList() {
            return invasiveTestEegList;
        }

        public void setInvasiveTestEegList(List<InvasiveTestEegDisplayVO> invasiveTestEegList) {
            this.invasiveTestEegList = invasiveTestEegList;
        }

        public List<InvasiveTestCorticalMappingDisplayVO> getInvasiveTestCorticalMappingList() {
            return invasiveTestCorticalMappingList;
        }

        public void setInvasiveTestCorticalMappingList(List<InvasiveTestCorticalMappingDisplayVO> invasiveTestCorticalMappingList) {
            this.invasiveTestCorticalMappingList = invasiveTestCorticalMappingList;
        }

        public List<OperationDisplayVO> getOperationList() {
            return operationList;
        }

        public void setOperationList(List<OperationDisplayVO> operationList) {
            this.operationList = operationList;
        }

        public List<HistologyDisplayVO> getHistologyList() {
            return histologyList;
        }

        public void setHistologyList(List<HistologyDisplayVO> histologyList) {
            this.histologyList = histologyList;
        }

        public List<ComplicationDisplayVO> getComplicationList() {
            return complicationList;
        }

        public void setComplicationList(List<ComplicationDisplayVO> complicationList) {
            this.complicationList = complicationList;
        }

        public List<OutcomeDisplayVO> getOutcomeList() {
            return outcomeList;
        }

        public void setOutcomeList(List<OutcomeDisplayVO> outcomeList) {
            this.outcomeList = outcomeList;
        }
    */
    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public int getAgeAtTheBeginningOfEpilepsy() {
        return ageAtTheBeginningOfEpilepsy;
    }

    public void setAgeAtTheBeginningOfEpilepsy(int ageAtTheBeginningOfEpilepsy) {
        this.ageAtTheBeginningOfEpilepsy = ageAtTheBeginningOfEpilepsy;
    }
}

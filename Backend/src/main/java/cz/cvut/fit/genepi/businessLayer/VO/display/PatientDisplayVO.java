package cz.cvut.fit.genepi.businessLayer.VO.display;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.*;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyEntity;

import java.util.List;

/**
 * Created by Jan on 20.1.14.
 */
public class PatientDisplayVO {

    private int id;

    private String nin;

    private String birthday;

    private int age;

    private String gender;

    //private int doctorId;

    //private int status;

    //private boolean verified;

    private UserDisplayVO doctor;

    private ContactDisplayVO contact;

    private List<AnamnesisDisplayVO> anamnesisList;

    private List<NeurologicalFindingDisplayVO> neurologicalFindingList;

    private List<NeuropsychologyDisplayVO> neuropsychologyList;

    private List<SeizureDisplayVO> seizureList;

    private List<PharmacotherapyDisplayVO> pharmacotherapyList;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

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

    public List<AnamnesisDisplayVO> getAnamnesisList() {
        return anamnesisList;
    }

    public void setAnamnesisList(List<AnamnesisDisplayVO> anamnesisList) {
        this.anamnesisList = anamnesisList;
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
}

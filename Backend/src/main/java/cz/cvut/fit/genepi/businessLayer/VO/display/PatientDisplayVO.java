package cz.cvut.fit.genepi.businessLayer.VO.display;

import cz.cvut.fit.genepi.businessLayer.VO.display.card.NeurologicalFindingDisplayVO;

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

    private List<NeurologicalFindingDisplayVO> neurologicalFindingList;

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

    public List<NeurologicalFindingDisplayVO> getNeurologicalFindingList() {
        return neurologicalFindingList;
    }

    public void setNeurologicalFindingList(List<NeurologicalFindingDisplayVO> neurologicalFindingList) {
        this.neurologicalFindingList = neurologicalFindingList;
    }
}

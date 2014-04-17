package cz.cvut.fit.genepi.businessLayer.VO.display;

public class PatientDisplayVO {

    private int id;

    private String nin;

    private String birthday;

    private int age;

    private String ageAtTheBeginningOfEpilepsy;

    private String gender;

    private boolean verified;

    private UserDisplayVO doctor;

    private ContactDisplayVO contact;

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

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getAgeAtTheBeginningOfEpilepsy() {
        return ageAtTheBeginningOfEpilepsy;
    }

    public void setAgeAtTheBeginningOfEpilepsy(String ageAtTheBeginningOfEpilepsy) {
        this.ageAtTheBeginningOfEpilepsy = ageAtTheBeginningOfEpilepsy;
    }
}

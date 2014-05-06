package cz.cvut.fit.genepi.businessLayer.BO.display;

public class PatientDisplayBO {

    private int id;

    private String nin;

    private String birthday;

    private int age;

    private String ageAtTheBeginningOfEpilepsy;

    private String gender;

    private boolean verified;

    private UserDisplayBO doctor;

    private ContactDisplayBO contact;

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

    public UserDisplayBO getDoctor() {
        return doctor;
    }

    public void setDoctor(UserDisplayBO doctor) {
        this.doctor = doctor;
    }

    public ContactDisplayBO getContact() {
        return contact;
    }

    public void setContact(ContactDisplayBO contact) {
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

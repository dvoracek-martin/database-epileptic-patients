package cz.cvut.fit.genepi.businessLayer.VO.form;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

public class PatientVO {

    private int id;

    /**
     * The nin.
     */
    //can contain chars as well   @Pattern(regexp = "[0-9]*")
    @Size(max = 10)
    private String nin;

    /**
     * The birthday.
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    @NotNull
    private Date birthday;

    /**
     * The gender.
     */
    @NotNull
    private int gender;

    @Min(1)
    private int doctorId;

    private int contactId;

    @Valid
    private ContactVO contact;

    /**
     * The deleted.
     */
    private int status;

    /**
     * The checked.
     */
    private boolean verified;

    private String indicatingDoctor;

    /* getters and setters */

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public String getIndicatingDoctor() {
        return indicatingDoctor;
    }

    public void setIndicatingDoctor(String indicatingDoctor) {
        this.indicatingDoctor = indicatingDoctor;
    }

    public ContactVO getContact() {
        return contact;
    }

    public void setContact(ContactVO contact) {
        this.contact = contact;
    }
}

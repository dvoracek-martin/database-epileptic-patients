package cz.cvut.fit.genepi.businessLayer.BO.form;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserContactFormBO {

    private int id;

    /**
     * The first name.
     */
    @Size(min = 1, max = 100)
    private String firstName;

    /**
     * The last name.
     */
    @Size(min = 1, max = 100)
    private String lastName;

    /**
     * The address street.
     */
    @Size(max = 100)
    private String addressStreet;

    /**
     * The address hn.
     */
    @Pattern(regexp = "[0-9]*")
    @Size(max = 10)
    private String addressHn;

    /**
     * The address city.
     */
    @Size(max = 100)
    private String addressCity;

    /**
     * The address postalcode.
     */
    // add blank option   @Pattern(regexp = "[1-9]+[0-9]*")
    @Size(max = 20)
    private String addressPostalcode;

    /**
     * The address country.
     */
    @Size(max = 100)
    private String addressCountry;

    /**
     * The phone number.
     */
    // add blank option   @Pattern(regexp = "[0-9]+[0-9]*")
    @Size(max = 20)
    private String phoneNumber;

    /**
     * The email.
     */
    @Email
    @Size(max = 100)
    @NotBlank
    private String email;

    /* getters and setters */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressHn() {
        return addressHn;
    }

    public void setAddressHn(String addressHn) {
        this.addressHn = addressHn;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressPostalcode() {
        return addressPostalcode;
    }

    public void setAddressPostalcode(String addressPostalcode) {
        this.addressPostalcode = addressPostalcode;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

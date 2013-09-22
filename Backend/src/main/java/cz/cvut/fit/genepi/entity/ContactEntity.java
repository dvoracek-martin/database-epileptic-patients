package cz.cvut.fit.genepi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactEntity.
 */
@Entity
@Table(name = "CONTACT")
public class ContactEntity {

	/** The id. */
	@Id
	@Column(name = "ID", precision = 6, scale = 0, nullable = false)
	@GeneratedValue
	private int id;

	/** The first name. */
	@Pattern(regexp="[A-Za-z ]*")
	//@NotNull
	//@NotBlank
	@Size(min=1, max=20)
	@Column(name = "FIRST_NAME", length = 20, nullable = false)
	private String firstName;

	/** The last name. */
	@Pattern(regexp="[A-Za-z ]*")
	//@NotNull
	//@NotBlank
	@Size(min=1, max=20)
	@Column(name = "LAST_NAME", length = 20, nullable = false)
	private String lastName;

	/** The address street. */	
	//@Pattern(regexp="[A-Za-z]*")
	//@NotNull
	//@NotBlank
	@Size(min=1, max=50)
	@Column(name = "ADDRESS_STREET", length = 50, nullable = true)
	private String addressStreet;

	/** The address hn. */
	@Pattern(regexp="[0-9]*")
	//@NotNull
	//@NotBlank
	@Size(min=1, max=10)
	@Column(name = "ADDRESS_HN", length = 10, nullable = true)
	private String addressHn;

	/** The address city. */
	@Pattern(regexp="[A-Za-z ]*")
	//@NotNull
	//@NotBlank
	@Size(min=1, max=30)
	@Column(name = "ADDRESS_CITY", length = 30, nullable = true)
	private String addressCity;

	/** The address postalcode. */
	@Pattern(regexp="[0-9]*")
	//@NotNull
	//@NotBlank
	@Size(min=1, max=10)
	@Column(name = "ADDRESS_POSTALCODE", length = 10, nullable = true)
	private String addressPostalcode;

	/** The address country. */
	@Pattern(regexp="[A-Za-z ]*")
	//@NotNull
	//@NotBlank
	@Size(min=1, max=20)
	@Column(name = "ADDRESS_COUNTRY", length = 20, nullable = true)
	private String addressCountry;

	/** The phone number. */
	@Pattern(regexp="[0-9+][0-9]*")
	@Size(max=20)
	@Column(name = "PHONE_NUMBER", length = 20, nullable = true)
	private String phoneNumber;

	/** The email. */
	@Email
	//@NotNull
	@NotBlank
	@Size(min=1, max=50)
	@Column(name = "EMAIL", length = 50, nullable = true)
	private String email;

	/**
	 * Gets the first name.
	 * 
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 * 
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 * 
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 * 
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the address street.
	 * 
	 * @return the address street
	 */
	public String getAddressStreet() {
		return addressStreet;
	}

	/**
	 * Sets the address street.
	 * 
	 * @param addressStreet
	 *            the new address street
	 */
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	/**
	 * Gets the address hn.
	 * 
	 * @return the address hn
	 */
	public String getAddressHn() {
		return addressHn;
	}

	/**
	 * Sets the address hn.
	 * 
	 * @param addressHn
	 *            the new address hn
	 */
	public void setAddressHn(String addressHn) {
		this.addressHn = addressHn;
	}

	/**
	 * Gets the address city.
	 * 
	 * @return the address city
	 */
	public String getAddressCity() {
		return addressCity;
	}

	/**
	 * Sets the address city.
	 * 
	 * @param addressCity
	 *            the new address city
	 */
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	/**
	 * Gets the address postalcode.
	 * 
	 * @return the address postalcode
	 */
	public String getAddressPostalcode() {
		return addressPostalcode;
	}

	/**
	 * Sets the address postalcode.
	 * 
	 * @param addressPostalcode
	 *            the new address postalcode
	 */
	public void setAddressPostalcode(String addressPostalcode) {
		this.addressPostalcode = addressPostalcode;
	}

	/**
	 * Gets the address country.
	 * 
	 * @return the address country
	 */
	public String getAddressCountry() {
		return addressCountry;
	}

	/**
	 * Sets the address country.
	 * 
	 * @param addressCountry
	 *            the new address country
	 */
	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	/**
	 * Gets the phone number.
	 * 
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 * 
	 * @param phoneNumber
	 *            the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}
}

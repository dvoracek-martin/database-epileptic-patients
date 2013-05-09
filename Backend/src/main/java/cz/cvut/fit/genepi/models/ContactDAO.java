package cz.cvut.fit.genepi.models;


public class ContactDAO implements java.io.Serializable {

	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = -31691933899856215L;

	private int id;
	private String firstName;
	private String lastName;
	private String addressStreet;
	private String addressHn;
	private String addressCity;
	private String addressPostalcode;
	private String addressCountry;
	private String phoneNumber;
	private String email;

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

	public int getId() {
		return id;
	}

	public ContactDAO() {
	}
	

	public void setId(int id) {
		this.id=id;
	}

	public ContactDAO(int id, String firstName, String lastName,
			String addressStreet, String addressHn, String addressCity,
			String addressPostalcode, String addressCountry,
			String phoneNumber, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addressStreet = addressStreet;
		this.addressCity = addressCity;
		this.addressPostalcode = addressPostalcode;
		this.addressCountry = addressCountry;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
}
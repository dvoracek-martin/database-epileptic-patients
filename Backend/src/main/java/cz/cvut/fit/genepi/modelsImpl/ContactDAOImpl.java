package cz.cvut.fit.genepi.modelsImpl;

import java.io.Serializable;

import cz.cvut.fit.genepi.models.ContactDAO;

public class ContactDAOImpl  extends GenericDAOImpl<ContactDAO, Serializable>{
	public ContactDAO contact;

	public ContactDAOImpl() {
		contact = new ContactDAO();
	}

	public void createContact(String firstName, String lastName,
			String addressStreet, String addressHn, String addressCity,
			String addressPostalcode, String addressCountry,
			String phoneNumber, String email) {
	
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setAddressCity(addressCity);
		contact.setAddressHn(addressHn);
		contact.setAddressCity(addressCity);
		contact.setAddressPostalcode(addressPostalcode);
		contact.setAddressCountry(addressCountry);
		contact.setPhoneNumber(phoneNumber);
		contact.setEmail(email);
		
	}

	public void createUser(ContactDAO contact) {
		this.contact = contact;
	}
}

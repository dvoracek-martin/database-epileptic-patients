package cz.cvut.fit.genepi.managers;

import cz.cvut.fit.genepi.entities.ContactEntity;
import cz.cvut.fit.genepi.modelsImpl.ContactDAOImpl;

public class ContactManager extends ContactDAOImpl {

	public ContactEntity contact;

	public ContactEntity createContact(String firstName, String lastName,
			String addressStreet, String addressHn, String addressCity,
			String addressPostalcode, String addressCountry,
			String phoneNumber, String email) {
		contact = new ContactEntity();
		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setAddressCity(addressCity);
		contact.setAddressHn(addressHn);
		contact.setAddressCity(addressCity);
		contact.setAddressPostalcode(addressPostalcode);
		contact.setAddressCountry(addressCountry);
		contact.setPhoneNumber(phoneNumber);
		contact.setEmail(email);
		return contact;
	}
	
	public void createUser(ContactEntity contact) {
		this.contact = contact;
	}
	
	public ContactEntity findByID(int id){
		return (this.findByID(ContactEntity.class, id));
	}
}

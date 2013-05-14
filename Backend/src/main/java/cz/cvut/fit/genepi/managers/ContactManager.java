package cz.cvut.fit.genepi.managers;

import cz.cvut.fit.genepi.entities.ContactEntity;
import cz.cvut.fit.genepi.modelsImpl.ContactDAOImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactManager.
 */
public class ContactManager extends ContactDAOImpl {

	/** The contact. */
	public ContactEntity contact;

	/**
	 * Creates the contact.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param addressStreet the address street
	 * @param addressHn the address hn
	 * @param addressCity the address city
	 * @param addressPostalcode the address postalcode
	 * @param addressCountry the address country
	 * @param phoneNumber the phone number
	 * @param email the email
	 * @return the contact entity
	 */
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
	
	/**
	 * Creates the user.
	 *
	 * @param contact the contact
	 */
	public void createUser(ContactEntity contact) {
		this.contact = contact;
	}
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the contact entity
	 */
	public ContactEntity findByID(int id){
		return (this.findByID(ContactEntity.class, id));
	}
}

package cz.cvut.fit.genepi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.DAO.ContactDAO;
import cz.cvut.fit.genepi.entity.ContactEntity;
import cz.cvut.fit.genepi.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO cntactDAO;
	
	/** The contact. */
	public ContactEntity contact;

	@Transactional
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
	
	@Transactional
	public void createContact(ContactEntity contact) {
		this.contact = contact;
	}
	
	@Transactional
	public ContactEntity findByID(int id){
		return (cntactDAO.findByID(ContactEntity.class, id));
	}
}

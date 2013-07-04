package cz.cvut.fit.genepi.controllers;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.serviceImpl.ContactServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class CreatedPatientController.
 */
@Controller
public class CreatedPatientController {
	
	/**
	 * selects the profile view to render by returning its name.
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
	 */
	
	// create new Contact	
	public void createNewContact( String firstName, String lastName,
			String addressStreet, String addressHn, String addressCity,
			String addressPostalcode, String addressCountry,
			String phoneNumber, String email){
		ContactServiceImpl contactImpl = new ContactServiceImpl();
		contactImpl.createContact(firstName, lastName, addressStreet, addressHn, addressCity, addressPostalcode, addressCountry, phoneNumber, email);
		contactImpl.save(contactImpl.contact);
	}
	
	
	/**
	 * Created patient post.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/createdPatient", method = RequestMethod.POST)
	public String createdPatientPOST(Locale locale, Model model) {	
		return "createdPatientView";
	}
	
	/**
	 * Created patient get.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/createdPatient", method = RequestMethod.GET)
	public String createdPatientGET(Locale locale, Model model) {	
		return "createdPatientView";
	}

}
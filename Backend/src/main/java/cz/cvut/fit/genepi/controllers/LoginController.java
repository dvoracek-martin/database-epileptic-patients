package cz.cvut.fit.genepi.controllers;

import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.models.PatientDAO;
import cz.cvut.fit.genepi.modelsImpl.PatientDAOImpl;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(AdminController.class);

	/**
	 * Simply selects the admin view to render by returning its name.
	 */

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPOST(Locale locale, Model model) {
		logger.info("LOGIN! The client locale is {}.", locale);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGET(Locale locale, Model model) {
		logger.info("LOGIN! The client locale is {}.", locale);

		// NEW WAY, HOW TO USE HIBERNATE IN OUR APP, PLS GET FAMILIAR WITH THIS
		PatientDAOImpl userImpl = new PatientDAOImpl();
		 userImpl.createPatient("zvzfsdfsdfasfas",new Date(), "male",
					5487, 1, 0, 56421, 4567);

		 userImpl.save(userImpl.patient);

		PatientDAO p= (PatientDAO)userImpl.findByID(PatientDAO.class, 10);
		// System.out.println(u.getCreatedBy());

		// DEPRECATED
		// create new object according to its model and call save method then

		/*
		 * SAMPLE CODE OF THE USAGE OF HIBERNATE AND DAOIMPL CLASS
		 * 
		 * 
		 * 
		 * UserDAOImpl userImpl = new UserDAOImpl(); userImpl.createUser(12230,
		 * "username3", "createdBy3"); userImpl.saveUser();
		 * 
		 * userImpl.createUser(12234, "username2", "createdBy2");
		 * userImpl.saveUser();
		 * 
		 * userImpl.findUserById(12230);
		 * System.out.println("USER "+userImpl.user.getCreatedBy());
		 */
//
	//	PatientDAOImpl userImpl = new PatientDAOImpl();
		//userImpl.findByID(PatientDAO.class, (12));
		System.out.println("USER " + p.getId());
		System.out.println("USER " + p.getNin());
		System.out.println("USER " + p.getChecked() );
		System.out.println("USER " + p.getContactId());
		return "login";
	}
}
package cz.cvut.fit.genepi.presentationLayer.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cz.cvut.fit.genepi.businessLayer.service.ContactService;
import cz.cvut.fit.genepi.businessLayer.service.MailService;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.RoleService;
import cz.cvut.fit.genepi.businessLayer.service.UserRoleService;
import cz.cvut.fit.genepi.businessLayer.service.UserService;
import cz.cvut.fit.genepi.businessLayer.service.card.AnamnesisService;
import cz.cvut.fit.genepi.dataLayer.entity.ContactEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import cz.cvut.fit.genepi.util.LoggingService;

/**
 * This class is a controller class which handles requests connected with a
 * user.
 */
@Controller
public class HiddenController {

	/** The user service. */
	private PatientService patientService;

	/** The contact service. */
	private ContactService contactService;
	
	/** The anamnesis service. */
	private AnamnesisService anamnesisService;

	/**
	 * Constructor which serves to autowire services.
	 * 
	 * 
	 * @param patientService
	 *            the patientService to be autowired.
	 * @param anamnesisService
	 *            the anamnesisService to be autowired.
	 */
	@Autowired
	public HiddenController(PatientService patientService,
			AnamnesisService anamnesisService, ContactService contactService) {
		this.patientService = patientService;
		this.anamnesisService = anamnesisService;
		this.contactService = contactService;
	}

	/** The Constant logger. */
	private LoggingService s = new LoggingService();

	/**
	 * Handles the request to access list of hidden records.
	 * 
	 * @param locale
	 *            the user's locale.
	 * @param model
	 *            the model to be filled for view.
	 * 
	 * @return the string of a view to be rendered.
	 */
	@RequestMapping(value = "/hidden", method = RequestMethod.GET)
	public String userListGET(Locale locale, Model model) {
		model.addAttribute("patientList", patientService.findAllHidden(PatientEntity.class));
		model.addAttribute("anamnesisList", anamnesisService.findAllHidden(AnamnesisEntity.class));
		return "hiddenView";
	}
	
}
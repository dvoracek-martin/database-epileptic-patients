package cz.cvut.fit.genepi.presentationLayer.controller.card;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.InvasiveTestCorticalMappingService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestCorticalMappingEntity;

@Controller
public class InvasiveTestCorticalMappingController {

	/** The patient service. */
	private PatientService patientService;

	/** The anamnesis service. */
	private InvasiveTestCorticalMappingService invasiveTestCorticalMappingService;

	/**
	 * Constructor which serves to autowire services.
	 * 
	 * 
	 * @param patientService
	 *            the patientService to be autowired.
	 * @param invasiveTestCorticalMappingService
	 *            the invasiveTestCorticalMappingService to be autowired.
	 */
	@Autowired
	public InvasiveTestCorticalMappingController(
			PatientService patientService,
			InvasiveTestCorticalMappingService invasiveTestCorticalMappingService) {
		this.patientService = patientService;
		this.invasiveTestCorticalMappingService = invasiveTestCorticalMappingService;
	}

	/**
	 * Handles the GET request to access page for creating new
	 * invasiveTestCorticalMapping.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an
	 *            invasiveTestCorticalMapping.
	 * 
	 * @param locale
	 *            the user's locale.
	 * 
	 * @param model
	 *            the model to be filled for view.
	 * 
	 * @return the name of a view to be rendered.
	 */
	@RequestMapping(value = "/patient/{patientId}/invasiveTestCorticalMapping/create", method = RequestMethod.GET)
	public String invasiveTestCorticalMappingCreateGET(
			@PathVariable("patientId") Integer patientId, Locale locale,
			Model model) {

		model.addAttribute("patient",
				patientService.findByID(PatientEntity.class, patientId));
		model.addAttribute("invasiveTestCorticalMapping",
				new InvasiveTestCorticalMappingEntity());
		return "patient/invasiveTestCorticalMapping/createView";
	}

	/**
	 * Handles the POST request to create new invasiveTestCorticalMapping.
	 * 
	 * @param anamnesis
	 *            the invasiveTestCorticalMapping which was filled in form at
	 *            front-end. It is grabbed from POST string and validated.
	 * 
	 * @param result
	 *            the result of binding form from front-end to an
	 *            AnamnesisEntity. It is used to determine if there were some
	 *            errors during binding.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an
	 *            invasiveTestCorticalMapping.
	 * 
	 * @param locale
	 *            the user's locale.
	 * 
	 * @param model
	 *            the model to be filled for view.
	 * 
	 * @return the name of a view to be rendered if the binding has errors
	 *         otherwise, the address to which the user will be redirected.
	 */
	@RequestMapping(value = "/patient/{patientId}/invasiveTestCorticalMapping/create", method = RequestMethod.POST)
	public String invasiveTestCorticalMappingCreatePOST(
			@ModelAttribute("invasiveTestCorticalMapping") @Valid InvasiveTestCorticalMappingEntity invasiveTestCorticalMapping,
			BindingResult result, @PathVariable("patientId") Integer patientId,
			Locale locale, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("patient",
					patientService.findByID(PatientEntity.class, patientId));
			return "patient/invasiveTestCorticalMapping/createView";
		} else {
			invasiveTestCorticalMapping.setPatient(patientService.findByID(
					PatientEntity.class, patientId));
			invasiveTestCorticalMappingService
					.save(invasiveTestCorticalMapping);
			return "redirect:/patient/" + patientId
					+ "/invasiveTestCorticalMapping/list";
		}
	}

	/**
	 * Handles the GET request to access page for editing
	 * invasiveTestCorticalMapping.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are editing an
	 *            invasiveTestCorticalMapping.
	 * 
	 * @param locale
	 *            the user's locale.
	 * 
	 * @param model
	 *            the model to be filled for view.
	 * 
	 * @return the name of a view to be rendered.
	 */
	@RequestMapping(value = "/patient/{patientId}/invasiveTestCorticalMapping/{invasiveTestCorticalMappingId}/edit", method = RequestMethod.GET)
	public String invasiveTestCorticalMappingEditGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("invasiveTestCorticalMappingId") Integer invasiveTestCorticalMappingId,
			Locale locale, Model model) {

		model.addAttribute("patient",
				patientService.findByID(PatientEntity.class, patientId));
		model.addAttribute("invasiveTestCorticalMapping",
				invasiveTestCorticalMappingService.findByID(
						InvasiveTestCorticalMappingEntity.class,
						invasiveTestCorticalMappingId));
		return "patient/invasiveTestCorticalMapping/editView";
	}

	/**
	 * Handles the POST request to edit invasiveTestCorticalMapping.
	 * 
	 * @param anamnesis
	 *            the anamnesis which was filled in form at front-end. It is
	 *            grabbed from POST string and validated.
	 * 
	 * @param result
	 *            the result of binding form from front-end to an
	 *            AnamnesisEntity. It is used to determine if there were some
	 *            errors during binding.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an
	 *            invasiveTestCorticalMapping.
	 * 
	 * @param locale
	 *            the user's locale.
	 * 
	 * @param model
	 *            the model to be filled for view.
	 * 
	 * @return the name of a view to be rendered if the binding has errors
	 *         otherwise, the address to which the user will be redirected.
	 */
	@RequestMapping(value = "/patient/{patientId}/invasiveTestCorticalMapping/{invasiveTestCorticalMappingId}/edit", method = RequestMethod.POST)
	public String invasiveTestCorticalMappingEditPOST(
			@ModelAttribute("invasiveTestCorticalMapping") @Valid InvasiveTestCorticalMappingEntity invasiveTestCorticalMapping,
			BindingResult result, @PathVariable("patientId") Integer patientId,
			Locale locale, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("patient",
					patientService.findByID(PatientEntity.class, patientId));
			return "patient/invasiveTestCorticalMapping/editView";
		} else {
			invasiveTestCorticalMapping.setPatient(patientService.findByID(
					PatientEntity.class, patientId));
			invasiveTestCorticalMappingService
					.save(invasiveTestCorticalMapping);
			return "redirect:/patient/" + patientId
					+ "/invasiveTestCorticalMapping/list";
		}
	}

	/**
	 * Handles the GET request to hide invasiveTestCorticalMapping.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an
	 *            invasiveTestCorticalMapping.
	 * @param anamnesisId
	 * 
	 * 
	 * @param locale
	 *            the user's locale.
	 * 
	 * @param model
	 *            the model to be filled for view.
	 * 
	 * @return the address to which the user will be redirected.
	 */
	@RequestMapping(value = "/patient/{patientId}/invasiveTestCorticalMapping/{invasiveTestCorticalMappingId}/hide", method = RequestMethod.GET)
	public String invasiveTestCorticalMappingHideGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("invasiveTestCorticalMappingId") Integer invasiveTestCorticalMappingId,
			Locale locale, Model model) {

		invasiveTestCorticalMappingService
				.hide(invasiveTestCorticalMappingService.findByID(
						InvasiveTestCorticalMappingEntity.class,
						invasiveTestCorticalMappingId));
		return "redirect:/patient/" + patientId
				+ "/invasiveTestCorticalMapping/list";
	}

	/**
	 * Handles the GET request to unhide invasiveTestCorticalMapping.
	 * 
	 * @param patientId
	 *            the id of a patient whom we are creating an
	 *            invasiveTestCorticalMapping.
	 * @param anamnesisId
	 * 
	 * 
	 * @param locale
	 *            the user's locale.
	 * 
	 * @param model
	 *            the model to be filled for view.
	 * 
	 * @return the address to which the user will be redirected.
	 */
	@RequestMapping(value = "/patient/{patientId}/invasiveTestCorticalMapping/{invasiveTestCorticalMappingId}/unhide", method = RequestMethod.GET)
	public String invasiveTestCorticalMappingUnhideGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("invasiveTestCorticalMappingId") Integer invasiveTestCorticalMappingId) {

		invasiveTestCorticalMappingService
				.unhide(invasiveTestCorticalMappingService.findByID(
						InvasiveTestCorticalMappingEntity.class,
						invasiveTestCorticalMappingId));
		// TODO: address to get back to admin module where is list od hidden
		// records.
		return "redirect:/patient/" + patientId
				+ "/invasiveTestCorticalMapping/list";
	}

	// TODO: not used now, is not present in original App
	/*
	 * @RequestMapping(value =
	 * "/patient/{patientID}/anamnesis/{anamnesisID}/export", method =
	 * RequestMethod.GET) public String anamnesisExportGET(Locale locale, Model
	 * model,
	 * 
	 * @PathVariable("patientID") Integer patientID,
	 * 
	 * @PathVariable("anamnesisID") Integer anamnesisID) { return
	 * "redirect:/patient/" + patientID + "/anamnesis/list"; }
	 */

	/**
	 * Handles the GET request to access page for listing anamnesis.
	 * 
	 * @param patientId
	 *            the id of a patient whose anamnesis we are listing.
	 * 
	 * @param locale
	 *            the user's locale.
	 * 
	 * @param model
	 *            the model to be filled for view.
	 * 
	 * @return the name of a view to be rendered.
	 */
	@RequestMapping(value = "/patient/{patientId}/invasiveTestCorticalMapping/list", method = RequestMethod.GET)
	public String invasiveTestCorticalMappingListGET(
			@PathVariable("patientId") Integer patientId, Locale locale,
			Model model) {
		model.addAttribute("patient", patientService
				.getPatientByIdWithInvasiveTestCorticalMappingList(patientId));
		return "patient/invasiveTestCorticalMapping/listView";
	}
}

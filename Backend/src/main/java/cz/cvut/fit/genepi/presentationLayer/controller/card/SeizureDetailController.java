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
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureDetailService;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureDetailEntity;

@Controller
public class SeizureDetailController {

	private PatientService patientService;

	private SeizureDetailService seizureDetailService;
	
	@Autowired
	public SeizureDetailController(PatientService patientService,
			SeizureDetailService seizureDetailService) {
		this.patientService = patientService;
		this.seizureDetailService = seizureDetailService;
	}
	
	@RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/create", method = RequestMethod.GET)
	public String anamnesisCreateGET(
			@PathVariable("patientId") Integer patientId, Locale locale,
			Model model) {

		model.addAttribute("patient",
				patientService.findByID(PatientEntity.class, patientId));
		model.addAttribute("seizureDetail", new SeizureDetailEntity());
		return "patient/anamnesis/createView";
	}


	@RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/create", method = RequestMethod.POST)
	public String anamnesisCreatePOST(
			@ModelAttribute("seizureDetail") @Valid SeizureDetailEntity seizureDetail,
			BindingResult result, @PathVariable("patientId") Integer patientId,
			Locale locale, Model model) {

		if (result.hasErrors()) {		
			model.addAttribute("patient",
					patientService.findByID(PatientEntity.class, patientId));
			return "patient/seizure/detail/createView";
		} else {
			seizureDetail.setPatient(patientService.findByID(PatientEntity.class,
					patientId));
			seizureDetailService.save(seizureDetail);
			return "redirect:/patient/" + patientId + "/seizure/list";
		}
	}

	
	@RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/{seizureDetailId}/edit", method = RequestMethod.GET)
	public String anamnesisEditGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("seizureId") Integer seizureId, Locale locale,
			Model model) {

		model.addAttribute("patient",
				patientService.findByID(PatientEntity.class, patientId));
		model.addAttribute("seizureDetail",
				seizureDetailService.findByID(SeizureDetailEntity.class, seizureId));
		return "patient/seizure/detail/editView";
	}

	
	@RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/{seizureDetailId}/edit", method = RequestMethod.POST)
	public String anamnesisEditPOST(
			@ModelAttribute("seizureDetail") @Valid SeizureDetailEntity seizureDetail,
			BindingResult result, @PathVariable("patientId") Integer patientId,
			Locale locale, Model model) {

		if (result.hasErrors()) {
			model.addAttribute("patient",
					patientService.findByID(PatientEntity.class, patientId));
			return "patient/seizure/detail/editView";
		} else {
			seizureDetail.setPatient(patientService.findByID(PatientEntity.class,
					patientId));
			seizureDetailService.save(seizureDetail);
			return "redirect:/patient/" + patientId + "/seizure/list";
		}
	}

	
	@RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/{seizureDetailId}/hide", method = RequestMethod.GET)
	public String anamnesisHideGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("seizureId") Integer seizureId, Locale locale,
			Model model) {

		seizureDetailService.hide(seizureDetailService.findByID(
				SeizureDetailEntity.class, seizureId));
		return "redirect:/patient/" + patientId + "/seizure/list";
	}
	

	@RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/seizure-detail/{seizureDetailId}/unhide", method = RequestMethod.GET)
	public String anamnesisUnhideGET(
			@PathVariable("patientId") Integer patientId,
			@PathVariable("seizureId") Integer seizureId, Locale locale,
			Model model) {

		seizureDetailService.unhide(seizureDetailService.findByID(
				SeizureDetailEntity.class, seizureId));
		//TODO: address to get back to admin module where is list of hidden records.
		return "redirect:/patient/" + patientId + "/seizure/list";
	}
}
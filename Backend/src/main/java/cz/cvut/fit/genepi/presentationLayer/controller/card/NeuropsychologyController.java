package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.form.NeuropsychologyVO;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.NeuropsychologyService;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Locale;

@Controller
public class NeuropsychologyController {

    private PatientService patientService;

    private NeuropsychologyService neuropsychologyService;

    @Autowired
    public NeuropsychologyController(PatientService patientService,
                                     NeuropsychologyService neuropsychologyService) {

        this.patientService = patientService;
        this.neuropsychologyService = neuropsychologyService;
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/create", method = RequestMethod.GET)
    public String neuropsychologyCreateGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("neuropsychology", new NeuropsychologyVO());
        return "patient/neuropsychology/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/{neuropsychologyId}/edit", method = RequestMethod.GET)
    public String neuropsychologyEditGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("neuropsychologyId") Integer neuropsychologyId,
            Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("neuropsychology", neuropsychologyService.getById(NeuropsychologyVO.class, NeuropsychologyEntity.class, neuropsychologyId));
        return "patient/neuropsychology/formView";
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/sae", method = RequestMethod.POST)
    public String neuropsychologySavePOST(
            @ModelAttribute("neuropsychology") @Valid NeuropsychologyVO neuropsychology,
            BindingResult result, @PathVariable("patientId") Integer patientId,
            Locale locale, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            return "patient/neuropsychology/formView";
        } else {
            neuropsychology.setPatientId(patientId);
            neuropsychologyService.save(NeuropsychologyEntity.class,neuropsychology);
            return "redirect:/patient/" + patientId + "/neuropsychology/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/{neuropsychologyId}/delete", method = RequestMethod.GET)
    public String neuropsychologyDeleteGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("neuropsychologyId") Integer neuropsychologyId,
            Locale locale, Model model) {

        neuropsychologyService.delete(NeuropsychologyEntity.class,neuropsychologyId);
        return "redirect:/patient/" + patientId + "/neuropsychology/list";
    }

    /**
     * Handles the GET request to hide neuropsychology.
     *
     * @param patientId   the id of a patient whom we are creating an neuropsychology.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/neuropsychology/{anamnesisId}/hide", method = RequestMethod.GET)
    public String neuropsychologyHideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("neuropsychologyId") Integer neuropsychologyId,
            Locale locale, Model model) {

        neuropsychologyService.hide(neuropsychologyId);
        return "redirect:/patient/" + patientId + "/neuropsychology/list";
    }

    /**
     * Handles the GET request to unhide neuropsychology.
     *
     * @param patientId   the id of a patient whom we are creating an neuropsychology.
     * @param anamnesisId
     * @param locale      the user's locale.
     * @param model       the model to be filled for view.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/neuropsychology/{neuropsychologyId}/unhide", method = RequestMethod.GET)
    public String neuropsychologyUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("neuropsychologyId") Integer neuropsychologyId,
            Locale locale, Model model) {

        neuropsychologyService.unhide(neuropsychologyId);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/neuropsychology/list";
    }

    /*@RequestMapping(value = "/patient/{patientID}/neuropsychology/{neuropsychologyID}/export", method = RequestMethod.GET)
    public String neuropsychologyExportGET(Locale locale, Model model,
                                           @PathVariable("patientID") Integer patientID,
                                           @PathVariable("neuropsychologyID") Integer neuropsychologyID) {
        return "redirect:/patient/" + patientID + "/neuropsychology/list";
    }*/

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/list", method = RequestMethod.GET)
    public String neuropsychologyListGET(
            @PathVariable("patientId") Integer patientId, Locale locale, Model model) {

        model.addAttribute("patient", patientService.getPatientDisplayByIdWithNeuropsychologyList(patientId));
        return "patient/neuropsychology/listView";
    }
}
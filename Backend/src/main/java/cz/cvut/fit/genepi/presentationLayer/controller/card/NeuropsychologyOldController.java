package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.BO.display.PatientDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.display.card.NeuropsychologyOldDisplayBO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.NeuropsychologyOldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@SessionAttributes({"neuropsychologyOld"})
public class NeuropsychologyOldController {

    private final AuthorizationChecker authorizationChecker;

    private final PatientService patientService;

    private final NeuropsychologyOldService neuropsychologyOldService;

    @Autowired
    public NeuropsychologyOldController(AuthorizationChecker authorizationChecker,
                                        PatientService patientService,
                                        NeuropsychologyOldService neuropsychologyOldService) {

        this.authorizationChecker = authorizationChecker;
        this.patientService = patientService;
        this.neuropsychologyOldService = neuropsychologyOldService;
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology-old/{neuropsychologyOldId}/delete", method = RequestMethod.GET)
    public String neuropsychologyOldDeleteGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("neuropsychologyOldId") int neuropsychologyOldId, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        neuropsychologyOldService.delete(neuropsychologyOldId);
        return "redirect:/patient/" + patientId + "/neuropsychology-old/list";
    }

    /**
     * Handles the GET request to hide neuropsychology.
     *
     * @param patientId the id of a patient whom we are creating an neuropsychology.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/neuropsychology-old/{neuropsychologyOldId}/hide", method = RequestMethod.GET)
    public String neuropsychologyHideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("neuropsychologyOldId") int neuropsychologyOldId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        neuropsychologyOldService.hide(neuropsychologyOldId);
        return "redirect:/patient/" + patientId + "/neuropsychology-old/list";
    }

    /**
     * Handles the GET request to unhide neuropsychology.
     *
     * @param patientId the id of a patient whom we are creating an neuropsychology.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/neuropsychology-old/{neuropsychologyOldId}/unhide", method = RequestMethod.GET)
    public String neuropsychologyUnhideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("neuropsychologyOldId") int neuropsychologyId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        neuropsychologyOldService.unhide(neuropsychologyId);
        return "redirect:/patient/" + patientId + "/neuropsychology-old/list";
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology-old/list", method = RequestMethod.GET)
    public String neuropsychologyListGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayBO patient = patientService.getPatientDisplayByIdWithDoctor(patientId);
        List<NeuropsychologyOldDisplayBO> neuropsychologyOldDisplayBOList = neuropsychologyOldService.getRecordsByPatientId(patientId);
        model.addAttribute("neuropsychologyOldDisplayBOList", neuropsychologyOldDisplayBOList);
        model.addAttribute("patient", patient);
        return "patient/neuropsychologyOld/listView";
    }
}

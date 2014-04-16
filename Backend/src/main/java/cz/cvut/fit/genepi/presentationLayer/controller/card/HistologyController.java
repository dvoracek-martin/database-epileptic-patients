package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.card.HistologyDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.HistologyVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.GenericCardService;
import cz.cvut.fit.genepi.dataLayer.entity.card.HistologyEntity;
import cz.cvut.fit.genepi.util.TimeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes({"histology", "patient"})
public class HistologyController {

    private final AuthorizationChecker authorizationChecker;

    private final PatientService patientService;

    private final GenericCardService<HistologyDisplayVO, HistologyVO, HistologyEntity> genericCardService;

    @Autowired
    public HistologyController(AuthorizationChecker authorizationChecker,
                               PatientService patientService,
                               @Qualifier("genericCardServiceImpl")
                               GenericCardService<HistologyDisplayVO, HistologyVO, HistologyEntity> genericCardService) {

        this.authorizationChecker = authorizationChecker;
        this.patientService = patientService;
        this.genericCardService = genericCardService;
    }

    @RequestMapping(value = "/patient/{patientId}/histology/create", method = RequestMethod.GET)
    public String histologyCreateGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("histology", new HistologyVO());
        return "patient/histology/createView";
    }

    @RequestMapping(value = "/patient/{patientId}/histology/create", method = RequestMethod.POST)
    public String histologyCreatePOST(
            @ModelAttribute("histology") @Valid HistologyVO histology, BindingResult result,
            @ModelAttribute("patient") PatientDisplayVO patientDisplayVo,
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayVo.getBirthday(), histology.getDate());
            if (result.hasErrors() || dateNotOk) {
                model.addAttribute("dateBeforeBirth", dateNotOk);
                return "patient/histology/createView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.save(histology, HistologyEntity.class);
                return "redirect:/patient/" + patientId + "/histology/list";
            }
        }
    }

    @RequestMapping(value = "/patient/{patientId}/histology/{histologyId}/edit", method = RequestMethod.GET)
    public String complicationEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("histologyId") int histologyId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("histology", genericCardService.getById(histologyId, HistologyVO.class, HistologyEntity.class));
        return "patient/histology/editView";
    }

    @RequestMapping(value = "/patient/{patientId}/histology/{histologyId}/edit", method = RequestMethod.POST)
    public String histologySavePOST(
            @ModelAttribute("histology") @Valid HistologyVO histology, BindingResult result,
            @ModelAttribute("patient") PatientDisplayVO patientDisplayVo,
            @PathVariable("patientId") int patientId,
            @PathVariable("histologyId") int histologyId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayVo.getBirthday(), histology.getDate());
            if (result.hasErrors() || dateNotOk) {
                model.addAttribute("dateBeforeBirth", dateNotOk);
                return "patient/histology/editView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.makeHistory(histologyId, HistologyEntity.class);
                histology.setId(0);
                genericCardService.save(histology, HistologyEntity.class);
                return "redirect:/patient/" + patientId + "/histology/list";
            }
        }
    }

    @RequestMapping(value = "/patient/{patientId}/histology/{histologyId}/delete", method = RequestMethod.GET)
    public String histologyDeleteGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("histologyId") int histologyId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.delete(histologyId, HistologyEntity.class);
        return "redirect:/patient/" + patientId + "/histology/list";
    }

    /**
     * Handles the GET request to hide histology.
     *
     * @param patientId the id of a patient whom we are creating an histology.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/histology/{histologyId}/hide", method = RequestMethod.GET)
    public String histologyHideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("histologyId") int histologyId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.hide(histologyId, HistologyEntity.class);
        return "redirect:/patient/" + patientId + "/histology/list";
    }

    /**
     * Handles the GET request to unhide histology.
     *
     * @param patientId the id of a patient whom we are creating an histology.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/histology/{histologyId}/unhide", method = RequestMethod.GET)
    public String histologyUnhideGET(
            @PathVariable("patientId") Integer patientId,
            @PathVariable("histologyId") Integer histologyId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.unhide(histologyId, HistologyEntity.class);
        return "redirect:/patient/" + patientId + "/histology/list";
    }

    @RequestMapping(value = "/patient/{patientId}/histology/list", method = RequestMethod.GET)
    public String histologyListGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithDoctor(patientId);
        List<HistologyDisplayVO> histologyDisplayVoList = genericCardService.getRecordsByPatientId(patientId, HistologyDisplayVO.class, HistologyEntity.class);
        model.addAttribute("histologyDisplayVoList", histologyDisplayVoList);
        model.addAttribute("patient", patient);
        return "patient/histology/listView";
    }
}

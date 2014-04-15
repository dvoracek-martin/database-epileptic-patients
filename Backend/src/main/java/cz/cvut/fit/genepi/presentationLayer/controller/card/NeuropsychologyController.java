package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.card.NeuropsychologyDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.NeuropsychologyVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.GenericCardService;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyEntity;
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
@SessionAttributes({"neuropsychology", "patient"})
public class NeuropsychologyController {

    private AuthorizationChecker authorizationChecker;

    private PatientService patientService;

    private GenericCardService<NeuropsychologyDisplayVO, NeuropsychologyVO, NeuropsychologyEntity> genericCardService;

    @Autowired
    public NeuropsychologyController(AuthorizationChecker authorizationChecker,
                                     PatientService patientService,
                                     @Qualifier("genericCardServiceImpl")
                                     GenericCardService<NeuropsychologyDisplayVO, NeuropsychologyVO, NeuropsychologyEntity> genericCardService) {

        this.authorizationChecker = authorizationChecker;
        this.patientService = patientService;
        this.genericCardService = genericCardService;
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/create", method = RequestMethod.GET)
    public String neuropsychologyCreateGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("neuropsychology", new NeuropsychologyVO());
        return "patient/neuropsychology/createView";
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/create", method = RequestMethod.POST)
    public String neuropsychologyCreatePOST(
            @ModelAttribute("neuropsychology") @Valid NeuropsychologyVO neuropsychology, BindingResult result,
            @ModelAttribute("patient") PatientDisplayVO patientDisplayVo,
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayVo.getBirthday(), neuropsychology.getDate());
            if (result.hasErrors() || dateNotOk) {
                model.addAttribute("dateBeforeBirth", dateNotOk);
                return "patient/neuropsychology/createView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.save(neuropsychology, NeuropsychologyEntity.class);
                return "redirect:/patient/" + patientId + "/neuropsychology/list";
            }
        }
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/{neuropsychologyId}/edit", method = RequestMethod.GET)
    public String neuropsychologyEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("neuropsychologyId") int neuropsychologyId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("neuropsychology", genericCardService.getById(neuropsychologyId, NeuropsychologyVO.class, NeuropsychologyEntity.class));
        return "patient/neuropsychology/editView";
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/{neuropsychologyId}/edit", method = RequestMethod.POST)
    public String neuropsychologySavePOST(
            @ModelAttribute("neuropsychology") @Valid NeuropsychologyVO neuropsychology, BindingResult result,
            @ModelAttribute("patient") PatientDisplayVO patientDisplayVo,
            @PathVariable("patientId") int patientId,
            @PathVariable("neuropsychologyId") int neuropsychologyId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayVo.getBirthday(), neuropsychology.getDate());
            if (result.hasErrors() || dateNotOk) {
                model.addAttribute("dateBeforeBirth", dateNotOk);
                return "patient/neuropsychology/editView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.makeHistory(neuropsychologyId, NeuropsychologyEntity.class);
                neuropsychology.setId(0);
                genericCardService.save(neuropsychology, NeuropsychologyEntity.class);
                return "redirect:/patient/" + patientId + "/neuropsychology/list";
            }
        }
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/{neuropsychologyId}/delete", method = RequestMethod.GET)
    public String neuropsychologyDeleteGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("neuropsychologyId") int neuropsychologyId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.delete(neuropsychologyId, NeuropsychologyEntity.class);
        return "redirect:/patient/" + patientId + "/neuropsychology/list";
    }

    /**
     * Handles the GET request to hide neuropsychology.
     *
     * @param patientId the id of a patient whom we are creating an neuropsychology.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/neuropsychology/{neuropsychologyId}/hide", method = RequestMethod.GET)
    public String neuropsychologyHideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("neuropsychologyId") int neuropsychologyId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.hide(neuropsychologyId, NeuropsychologyEntity.class);
        return "redirect:/patient/" + patientId + "/neuropsychology/list";
    }

    /**
     * Handles the GET request to unhide neuropsychology.
     *
     * @param patientId the id of a patient whom we are creating an neuropsychology.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/neuropsychology/{neuropsychologyId}/unhide", method = RequestMethod.GET)
    public String neuropsychologyUnhideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("neuropsychologyId") int neuropsychologyId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.unhide(neuropsychologyId, NeuropsychologyEntity.class);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/neuropsychology/list";
    }

    @RequestMapping(value = "/patient/{patientId}/neuropsychology/list", method = RequestMethod.GET)
    public String neuropsychologyListGET(
            @PathVariable("patientId") Integer patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithDoctor(patientId);
        List<NeuropsychologyDisplayVO> neuropsychologyDisplayVoList = genericCardService.getRecordsByPatientId(patientId, NeuropsychologyDisplayVO.class, NeuropsychologyEntity.class);
        model.addAttribute("neuropsychologyDisplayVoList", neuropsychologyDisplayVoList);
//        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("patient", patient);
        return "patient/neuropsychology/listView";
    }
}
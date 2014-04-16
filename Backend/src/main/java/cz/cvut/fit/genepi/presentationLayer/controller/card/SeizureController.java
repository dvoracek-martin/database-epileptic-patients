package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.card.SeizureDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.SeizureVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.GenericCardService;
import cz.cvut.fit.genepi.businessLayer.service.card.SeizureService;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureEntity;
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
@SessionAttributes({"seizure", "patient"})
public class SeizureController {

    private final AuthorizationChecker authorizationChecker;

    private final PatientService patientService;

    private final GenericCardService<SeizureDisplayVO, SeizureVO, SeizureEntity> genericCardService;

    private final SeizureService seizureService;

    @Autowired
    public SeizureController(AuthorizationChecker authorizationChecker,
                             PatientService patientService,
                             @Qualifier("genericCardServiceImpl")
                             GenericCardService<SeizureDisplayVO, SeizureVO, SeizureEntity> genericCardService,
                             SeizureService seizureService) {

        this.authorizationChecker = authorizationChecker;
        this.patientService = patientService;
        this.genericCardService = genericCardService;
        this.seizureService = seizureService;
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/create", method = RequestMethod.GET)
    public String seizureCreateGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("dateBeforeEpiBeginning", false);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("seizure", new SeizureVO());
        return "patient/seizure/createView";
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/create", method = RequestMethod.POST)
    public String seizureCreatePOST(
            @ModelAttribute("seizure") @Valid SeizureVO seizure, BindingResult result,
            @ModelAttribute("patient") PatientDisplayVO patientDisplayVo,
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else if (patientDisplayVo.getAgeAtTheBeginningOfEpilepsy().equals("NA")) {
            return "patient/seizure/createView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayVo.getBirthday(), seizure.getDate());
            boolean dateBeforeEpiBeginning = TimeConverter.beforeDatePlusYears(patientDisplayVo.getBirthday(), patientDisplayVo.getAgeAtTheBeginningOfEpilepsy(), seizure.getDate());
            if (result.hasErrors() || dateNotOk || dateBeforeEpiBeginning) {

                model.addAttribute("dateBeforeBirth", dateNotOk);
                model.addAttribute("dateBeforeEpiBeginning", dateBeforeEpiBeginning);

                return "patient/seizure/createView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.save(seizure, SeizureEntity.class);
                return "redirect:/patient/" + patientId + "/seizure/list";
            }
        }
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/edit", method = RequestMethod.GET)
    public String seizureEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("seizureId") int seizureId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("dateBeforeEpiBeginning", false);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("seizure", genericCardService.getById(seizureId, SeizureVO.class, SeizureEntity.class));

        return "patient/seizure/editView";
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/edit", method = RequestMethod.POST)
    public String seizureSavePOST(
            @ModelAttribute("seizure") @Valid SeizureVO seizure, BindingResult result,
            @ModelAttribute("patient") PatientDisplayVO patientDisplayVo,
            @PathVariable("patientId") int patientId,
            @PathVariable("seizureId") int seizureId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayVo.getBirthday(), seizure.getDate());
            boolean dateBeforeEpiBeginning = TimeConverter.beforeDatePlusYears(patientDisplayVo.getBirthday(), patientDisplayVo.getAgeAtTheBeginningOfEpilepsy(), seizure.getDate());
            if (result.hasErrors() || dateNotOk || dateBeforeEpiBeginning) {

                model.addAttribute("dateBeforeBirth", dateNotOk);
                model.addAttribute("dateBeforeEpiBeginning", dateBeforeEpiBeginning);

                return "patient/seizure/editView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.makeHistory(seizureId, SeizureEntity.class);
                seizure.setId(0);
                seizureService.save(seizure);
                return "redirect:/patient/" + patientId + "/seizure/list";
            }
        }


    }

    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/delete", method = RequestMethod.GET)
    public String seizureDeleteGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("seizureId") int seizureId, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.delete(seizureId, SeizureEntity.class);
        return "redirect:/patient/" + patientId + "/seizure/list";
    }

    /**
     * Handles the GET request to hide seizure.
     *
     * @param patientId the id of a patient whom we are creating an seizure.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/hide", method = RequestMethod.GET)
    public String seizureHideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("seizureId") int seizureId, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.hide(seizureId, SeizureEntity.class);
        return "redirect:/patient/" + patientId + "/seizure/list";
    }

    /**
     * Handles the GET request to unhide seizure.
     *
     * @param patientId the id of a patient whom we are creating an seizure.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/seizure/{seizureId}/unhide", method = RequestMethod.GET)
    public String seizureUnhideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("seizureId") int seizureId, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.unhide(seizureId, SeizureEntity.class);
        return "redirect:/patient/" + patientId + "/seizure/list";
    }

    @RequestMapping(value = "/patient/{patientId}/seizure/list", method = RequestMethod.GET)
    public String seizureListGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithDoctor(patientId);
        List<SeizureDisplayVO> SeizureDisplayVoList = seizureService.getRecordsByPatientId(patientId);

        model.addAttribute("patient", patient);
        model.addAttribute("seizureDisplayVoList", SeizureDisplayVoList);
        return "patient/seizure/listView";
    }
}

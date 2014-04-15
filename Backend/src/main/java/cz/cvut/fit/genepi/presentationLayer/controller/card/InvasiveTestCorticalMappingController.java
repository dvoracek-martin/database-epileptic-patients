package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.card.InvasiveTestCorticalMappingDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.InvasiveTestCorticalMappingVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.GenericCardService;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestCorticalMappingEntity;
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
@SessionAttributes({"invasiveTestCorticalMapping", "patient"})
public class InvasiveTestCorticalMappingController {

    private AuthorizationChecker authorizationChecker;

    private PatientService patientService;

    private GenericCardService<InvasiveTestCorticalMappingDisplayVO, InvasiveTestCorticalMappingVO, InvasiveTestCorticalMappingEntity> genericCardService;

    /**
     * Constructor which serves to autowire services.
     *
     * @param patientService the patientService to be autowired.
     */
    @Autowired
    public InvasiveTestCorticalMappingController(AuthorizationChecker authorizationChecker,
                                                 PatientService patientService,
                                                 @Qualifier("genericCardServiceImpl")
                                                 GenericCardService<InvasiveTestCorticalMappingDisplayVO, InvasiveTestCorticalMappingVO, InvasiveTestCorticalMappingEntity> genericCardService) {

        this.authorizationChecker = authorizationChecker;
        this.patientService = patientService;
        this.genericCardService = genericCardService;
    }

    /**
     * Handles the GET request to access page for creating new
     * invasiveTestCorticalMapping.
     *
     * @param patientId the id of a patient whom we are creating an
     *                  invasiveTestCorticalMapping.
     * @param model     the model to be filled for view.
     * @return the name of a view to be rendered.
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-cortical-mapping/create", method = RequestMethod.GET)
    public String invasiveTestCorticalMappingCreateGET(
            @PathVariable("patientId") int patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("invasiveTestCorticalMapping", new InvasiveTestCorticalMappingVO());
        return "patient/invasiveTestCorticalMapping/createView";
    }

    @RequestMapping(value = "/patient/{patientId}/invasive-test-cortical-mapping/create", method = RequestMethod.POST)
    public String invasiveTestCorticalMappingCreatePOST(
            @ModelAttribute("invasiveTestCorticalMapping") @Valid InvasiveTestCorticalMappingVO invasiveTestCorticalMapping, BindingResult result,
            @ModelAttribute("patient") PatientDisplayVO patientDisplayVo,
            @PathVariable("patientId") int patientId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayVo.getBirthday(), invasiveTestCorticalMapping.getDate());
            if (result.hasErrors() || dateNotOk) {
                model.addAttribute("dateBeforeBirth", dateNotOk);
                return "patient/invasiveTestCorticalMapping/createView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.save(invasiveTestCorticalMapping, InvasiveTestCorticalMappingEntity.class);
                return "redirect:/patient/" + patientId + "/invasive-test-cortical-mapping/list";
            }
        }
    }

    /**
     * Handles the GET request to access page for editing
     * invasiveTestCorticalMapping.
     *
     * @param patientId the id of a patient whom we are editing an
     *                  invasiveTestCorticalMapping.
     * @param model     the model to be filled for view.
     * @return the name of a view to be rendered.
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-cortical-mapping/{invasiveTestCorticalMappingId}/edit", method = RequestMethod.GET)
    public String invasiveTestCorticalMappingEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("invasiveTestCorticalMappingId") int invasiveTestCorticalMappingId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("dateBeforeBirth", false);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("invasiveTestCorticalMapping", genericCardService.getById(invasiveTestCorticalMappingId, InvasiveTestCorticalMappingVO.class, InvasiveTestCorticalMappingEntity.class));
        return "patient/invasiveTestCorticalMapping/editView";
    }

    @RequestMapping(value = "/patient/{patientId}/invasive-test-cortical-mapping/{invasiveTestCorticalMappingId}/edit", method = RequestMethod.POST)
    public String invasiveTestCorticalMappingSavePOST(
            @ModelAttribute("invasiveTestCorticalMapping") @Valid InvasiveTestCorticalMappingVO invasiveTestCorticalMapping, BindingResult result,
            @ModelAttribute("patient") PatientDisplayVO patientDisplayVo,
            @PathVariable("patientId") int patientId,
            @PathVariable("invasiveTestCorticalMappingId") int invasiveTestCorticalMappingId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        } else {
            boolean dateNotOk = TimeConverter.compareDates(patientDisplayVo.getBirthday(), invasiveTestCorticalMapping.getDate());
            if (result.hasErrors() || dateNotOk) {
                model.addAttribute("dateBeforeBirth", dateNotOk);
                return "patient/invasiveTestCorticalMapping/editView";
            } else {
                if (!authorizationChecker.isSuperDoctor()) {
                    patientService.voidVerifyPatient(patientId);
                }
                genericCardService.makeHistory(invasiveTestCorticalMappingId, InvasiveTestCorticalMappingEntity.class);
                invasiveTestCorticalMapping.setId(0);
                genericCardService.save(invasiveTestCorticalMapping, InvasiveTestCorticalMappingEntity.class);
                return "redirect:/patient/" + patientId + "/invasive-test-cortical-mapping/list";
            }
        }
    }

    /**
     * Handles the GET request to hide invasiveTestCorticalMapping.
     *
     * @param patientId the id of a patient whom we are creating an
     *                  invasiveTestCorticalMapping.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-cortical-mapping/{invasiveTestCorticalMappingId}/hide", method = RequestMethod.GET)
    public String invasiveTestCorticalMappingHideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("invasiveTestCorticalMappingId") int invasiveTestCorticalMappingId,
            HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.hide(invasiveTestCorticalMappingId, InvasiveTestCorticalMappingEntity.class);
        return "redirect:/patient/" + patientId + "/invasive-test-cortical-mapping/list";
    }

    /**
     * Handles the GET request to unhide invasiveTestCorticalMapping.
     *
     * @param patientId the id of a patient whom we are creating an
     *                  invasiveTestCorticalMapping.
     * @return the address to which the user will be redirected.
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-cortical-mapping/{invasiveTestCorticalMappingId}/unhide", method = RequestMethod.GET)
    public String invasiveTestCorticalMappingUnhideGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("invasiveTestCorticalMappingId") int invasiveTestCorticalMappingId, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        genericCardService.unhide(invasiveTestCorticalMappingId, InvasiveTestCorticalMappingEntity.class);
        // TODO: address to get back to admin module where is list od hidden
        // records.
        return "redirect:/patient/" + patientId + "/invasive-test-cortical-mapping/list";
    }

    /**
     * Handles the GET request to access page for listing anamnesis.
     *
     * @param patientId the id of a patient whose anamnesis we are listing.
     * @param model     the model to be filled for view.
     * @return the name of a view to be rendered.
     */
    @RequestMapping(value = "/patient/{patientId}/invasive-test-cortical-mapping/list", method = RequestMethod.GET)
    public String invasiveTestCorticalMappingListGET(
            @PathVariable("patientId") Integer patientId, Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithDoctor(patientId);
        List<InvasiveTestCorticalMappingDisplayVO> corticalMappingDisplayVoList = genericCardService.getRecordsByPatientId(patientId, InvasiveTestCorticalMappingDisplayVO.class, InvasiveTestCorticalMappingEntity.class);
        model.addAttribute("invasiveTestCorticalMappingDisplayVoList", corticalMappingDisplayVoList);
//        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("patient", patient);
        return "patient/invasiveTestCorticalMapping/listView";
    }
}
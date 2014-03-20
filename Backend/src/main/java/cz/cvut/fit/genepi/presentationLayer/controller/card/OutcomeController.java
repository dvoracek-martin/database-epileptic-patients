package cz.cvut.fit.genepi.presentationLayer.controller.card;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.card.OperationWithOutcomesDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.display.card.OutcomeDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.card.OutcomeVO;
import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import cz.cvut.fit.genepi.businessLayer.service.card.GenericCardService;
import cz.cvut.fit.genepi.businessLayer.service.card.OperationService;
import cz.cvut.fit.genepi.dataLayer.entity.card.OutcomeEntity;
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
@SessionAttributes({"outcome", "operation"})
public class OutcomeController {

    private AuthorizationChecker authorizationChecker;

    private PatientService patientService;

    private OperationService operationService;

    private GenericCardService<OutcomeDisplayVO, OutcomeVO, OutcomeEntity> genericCardService;

    @Autowired
    public OutcomeController(AuthorizationChecker authorizationChecker,
                             PatientService patientService,
                             OperationService operationService,
                             @Qualifier("genericCardServiceImpl")
                             GenericCardService<OutcomeDisplayVO, OutcomeVO, OutcomeEntity> genericCardService) {

        this.authorizationChecker = authorizationChecker;
        this.patientService = patientService;
        this.operationService = operationService;
        this.genericCardService = genericCardService;
    }

    @RequestMapping(value = "/patient/{patientId}/outcome/create", method = RequestMethod.GET)
    public String outcomeCreateGET(
            @PathVariable("patientId") int patientId,
            @RequestParam("distance") int distance,
            @RequestParam("operation") int operation,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("distance", distance);
        model.addAttribute("operation", operation);
        model.addAttribute("outcome", new OutcomeVO());
        return "patient/outcome/createView";
    }

    @RequestMapping(value = "/patient/{patientId}/outcome/create", method = RequestMethod.POST)
    public String outcomeCreatePOST(
            @ModelAttribute("outcome") @Valid OutcomeVO outcome, BindingResult result,
            @PathVariable("patientId") int patientId,
            @RequestParam("distance") int distance,
            @RequestParam("operationId") int operationId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), outcome.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            model.addAttribute("distance", distance);
            return "patient/outcome/createView";
        } else {
            if (!authorizationChecker.isSuperDoctor()) {
                patientService.voidVerifyPatient(patientId);
            }
            outcome.setDistance(distance);
            outcome.setPatientId(patientId);
            genericCardService.save(outcome, OutcomeEntity.class);
            return "redirect:/patient/" + patientId + "/outcome/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/outcome/{outcomeId}/edit", method = RequestMethod.GET)
    public String outcomeEditGET(
            @PathVariable("patientId") int patientId,
            @PathVariable("outcomeId") int outcomeId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        OutcomeVO outcomeVO = genericCardService.getById(outcomeId, OutcomeVO.class, OutcomeEntity.class);
        model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
        model.addAttribute("outcome", outcomeVO);
        model.addAttribute("distance", outcomeVO.getDistance());
        model.addAttribute("operation", outcomeVO.getOperationId());
        return "patient/outcome/editView";
    }

    @RequestMapping(value = "/patient/{patientId}/outcome/{outcomeId}/edit", method = RequestMethod.POST)
    public String outcomeSavePOST(
            @ModelAttribute("outcome") @Valid OutcomeVO outcome, BindingResult result,
            @PathVariable("patientId") int patientId,
            @RequestParam("distance") int distance,
            @RequestParam("operationId") int operationId,
            @PathVariable("outcomeId") int outcomeId,
            Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        if (result.hasErrors() || TimeConverter.compareDates(patientService.getPatientByIdWithDoctor(patientId).getBirthday(), outcome.getDate())) {
            model.addAttribute("patient", patientService.getPatientDisplayByIdWithDoctor(patientId));
            model.addAttribute("distance", distance);
            return "patient/outcome/formView";
        } else {
            if (!authorizationChecker.isSuperDoctor()) {
                patientService.voidVerifyPatient(patientId);
            }
            genericCardService.makeHistory(outcomeId, OutcomeEntity.class);
            outcome.setId(0);
            outcome.setDistance(distance);
            outcome.setPatientId(patientId);
            genericCardService.save(outcome, OutcomeEntity.class);
            return "redirect:/patient/" + patientId + "/outcome/list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}/outcome/list", method = RequestMethod.GET)
    public String outcomeListGET(
            @PathVariable("patientId") Integer patientId, Model model, HttpServletRequest request) {
        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }
        PatientDisplayVO patient = patientService.getPatientDisplayByIdWithDoctor(patientId);
        List<OperationWithOutcomesDisplayVO> operationWithOutcomesDisplayVoList = operationService.getOperationWithOutcomeList(patientId);
        model.addAttribute("operationWithOutcomesDisplayVoList", operationWithOutcomesDisplayVoList);
        model.addAttribute("beginningEpilepsy", TimeConverter.getAgeAtTheBeginningOfEpilepsy(patient));
        model.addAttribute("patient", patient);

        return "patient/outcome/listView";
    }
}
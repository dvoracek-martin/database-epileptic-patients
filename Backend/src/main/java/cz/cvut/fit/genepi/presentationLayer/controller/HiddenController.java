package cz.cvut.fit.genepi.presentationLayer.controller;

import cz.cvut.fit.genepi.businessLayer.service.AuthorizationChecker;
import cz.cvut.fit.genepi.businessLayer.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * This class is a controller class which handles requests connected with a
 * user.
 */
@Controller
public class HiddenController {

    @Autowired
    AuthorizationChecker authorizationChecker;

    /**
     * The user service.
     */
    private final PatientService patientService;

    /**
     * Constructor which serves to autowire services.
     *
     * @param patientService the patientService to be autowired.
     */
    @Autowired
    public HiddenController(PatientService patientService) {
        this.patientService = patientService;

    }

    /**
     * Handles the request to access list of hidden records.
     *
     * @param model the model to be filled for view.
     * @return the string of a view to be rendered.
     */
    @RequestMapping(value = "/hidden", method = RequestMethod.GET)
    public String userListGET(Model model, HttpServletRequest request) {

        if (!authorizationChecker.checkAuthoritaion(request)) {
            return "deniedView";
        }

        model.addAttribute("hiddenPatientList", patientService.findAllHidden());

        model.addAttribute("patientsWithHiddenRecordsList", patientService.findAllWithHiddenRecords());
        return "hiddenView";
    }

}

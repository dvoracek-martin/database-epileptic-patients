package cz.cvut.fit.genepi.controllers;

import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.cvut.fit.genepi.managers.AnamnesisManager;


@Controller
public class CreateAnamnesisController {

	private static final Logger logger = LoggerFactory
			.getLogger(CreateAnamnesisController.class);

	// create new Anamnesis
	public void createNewAnamnesis(Date date, int doctorId, int added,
			Date beginningEpilepsy, int firstFever, int infantileSpasm,
			int specificSyndromeIdcom, int epilepsyInFamily, int prenatalRisk,
			int fibrilConvulsions, int inflammationCns, int injuryCns,
			int operationCns, int earlyPmdRetardation,
			String nonCnsComorbidity, String comment, int deleted,
			int patientId, int addUserId) {
		AnamnesisManager anamnesisImpl = new AnamnesisManager();
		anamnesisImpl.createAnamnesis(date, doctorId, added, beginningEpilepsy,
				firstFever, infantileSpasm, specificSyndromeIdcom,
				epilepsyInFamily, prenatalRisk, fibrilConvulsions,
				inflammationCns, injuryCns, operationCns, earlyPmdRetardation,
				nonCnsComorbidity, comment, deleted, patientId, addUserId);
		anamnesisImpl.save();
	}

	@RequestMapping(value = "/createAnamnesis", method = RequestMethod.POST)
	public String CreateAnamnesisPOST(Locale locale, Model model) {
		return "createAnamnesisView";
	}

	@RequestMapping(value = "/createAnamnesis", method = RequestMethod.GET)
	public String CreateAnamnesisGET(Locale locale, Model model) {
		return "createAnamnesisView";
	}
}
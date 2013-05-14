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


// TODO: Auto-generated Javadoc
/**
 * The Class CreateAnamnesisController.
 */
@Controller
public class CreateAnamnesisController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(CreateAnamnesisController.class);

	/**
	 * Creates the new anamnesis.
	 *
	 * @param date the date
	 * @param doctorId the doctor id
	 * @param added the added
	 * @param beginningEpilepsy the beginning epilepsy
	 * @param firstFever the first fever
	 * @param infantileSpasm the infantile spasm
	 * @param specificSyndromeIdcom the specific syndrome idcom
	 * @param epilepsyInFamily the epilepsy in family
	 * @param prenatalRisk the prenatal risk
	 * @param fibrilConvulsions the fibril convulsions
	 * @param inflammationCns the inflammation cns
	 * @param injuryCns the injury cns
	 * @param operationCns the operation cns
	 * @param earlyPmdRetardation the early pmd retardation
	 * @param nonCnsComorbidity the non cns comorbidity
	 * @param comment the comment
	 * @param deleted the deleted
	 * @param patientId the patient id
	 * @param addUserId the add user id
	 */
	public void createNewAnamnesis(Date date, int doctorId, Date added,
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
		logger.info("Created new anamnesis for patient id: "+patientId);
	}

	/**
	 * Creates the anamnesis post.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/createAnamnesis", method = RequestMethod.POST)
	public String CreateAnamnesisPOST(Locale locale, Model model) {
		return "createAnamnesisView";
	}

	/**
	 * Creates the anamnesis get.
	 *
	 * @param locale the locale
	 * @param model the model
	 * @return the string
	 */
	@RequestMapping(value = "/createAnamnesis", method = RequestMethod.GET)
	public String CreateAnamnesisGET(Locale locale, Model model) {
		return "createAnamnesisView";
	}
}
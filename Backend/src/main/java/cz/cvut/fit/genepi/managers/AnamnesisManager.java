package cz.cvut.fit.genepi.managers;

import java.util.Date;
import java.util.List;

import cz.cvut.fit.genepi.entities.AnamnesisEntity;
import cz.cvut.fit.genepi.modelsImpl.AnamnesisDAOImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class AnamnesisManager.
 */
public class AnamnesisManager extends AnamnesisDAOImpl {
	
	/** The anamnesis. */
	AnamnesisEntity anamnesis;
	
	/**
	 * Creates the anamnesis.
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
	 * @return the anamnesis entity
	 */
	public AnamnesisEntity createAnamnesis(Date date, int doctorId, Date added,
			Date beginningEpilepsy, int firstFever, int infantileSpasm,
			int specificSyndromeIdcom, int epilepsyInFamily, int prenatalRisk,
			int fibrilConvulsions, int inflammationCns, int injuryCns,
			int operationCns, int earlyPmdRetardation,
			String nonCnsComorbidity, String comment, int deleted,
			int patientId, int addUserId) {
		
		anamnesis = new AnamnesisEntity();
		anamnesis.setDate(date);
		anamnesis.setDoctorId(doctorId);
		anamnesis.setAdded(added);
		anamnesis.setBeginningEpilepsy(beginningEpilepsy);
		anamnesis.setFirstFever(firstFever);
		anamnesis.setInfantileSpasm(infantileSpasm);
		anamnesis.setSpecificSyndromeIdcom(specificSyndromeIdcom);
		anamnesis.setEpilepsyInFamily(epilepsyInFamily);
		anamnesis.setPrenatalRisk(prenatalRisk);
		anamnesis.setFibrilConvulsions(fibrilConvulsions);
		anamnesis.setInflammationCns(inflammationCns);
		anamnesis.setInjuryCns(injuryCns);
		anamnesis.setOperationCns(operationCns);
		anamnesis.setEarlyPmdRetardation(earlyPmdRetardation);
		anamnesis.setNonCnsComorbidity(nonCnsComorbidity);
		anamnesis.setComment(comment);
		anamnesis.setDeleted(deleted);
		anamnesis.setpatientId(patientId);
		anamnesis.setAddUserId(addUserId);
		return anamnesis;
	}
	
	/**
	 * Creates the user.
	 *
	 * @param anamnesis the anamnesis
	 */
	public void createAnamnesis(AnamnesisEntity anamnesis) {
		this.anamnesis = anamnesis;
	}
	
	/**
	 * Save.
	 */
	public void save(){
		this.save(anamnesis);
	}
	
	public List<AnamnesisEntity> findAnamnesisByPatientID(int patient_id){		
		return super.findAnamnesisByPatientID(patient_id);
	}
}

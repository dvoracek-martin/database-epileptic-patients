package cz.cvut.fit.genepi.modelsImpl;

import java.io.Serializable;
import java.util.Date;

import cz.cvut.fit.genepi.models.AnamnesisDAO;

public class AnamnesisDAOImpl extends
		GenericDAOImpl<AnamnesisDAO, Serializable> {

	public AnamnesisDAO anamnesis;

	public AnamnesisDAOImpl() {
		anamnesis = new AnamnesisDAO();
	}

	public void createUser(AnamnesisDAO anamnesis) {
		this.anamnesis = anamnesis;
	}
	
	public void createAnamnesis(Date date, int doctorId, int added,
			Date beginningEpilepsy, int firstFever, int infantileSpasm,
			int specificSyndromeIdcom, int epilepsyInFamily, int prenatalRisk,
			int fibrilConvulsions, int inflammationCns, int injuryCns,
			int operationCns, int earlyPmdRetardation,
			String nonCnsComorbidity, String comment, int deleted,
			int patientId, int addUserId) {
		
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
	}
}
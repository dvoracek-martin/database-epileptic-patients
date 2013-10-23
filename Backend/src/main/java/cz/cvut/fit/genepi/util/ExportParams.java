package cz.cvut.fit.genepi.util;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.DAO.ExportParamsDAO;
import cz.cvut.fit.genepi.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.service.ExportParamsService;
import cz.cvut.fit.genepi.serviceImpl.GenericServiceImpl;

@Service
public class ExportParams extends
		GenericServiceImpl<ExportParamsEntity, Serializable> implements
		ExportParamsService {
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ExportParamsDAO exportParamsDAO;

	@Transactional
	public List<ExportParamsEntity> findExportParamsEntityByUserID(int userID) {
		return exportParamsDAO.findExportParamsByUserID(userID);
	}

	// Patient properties
	private boolean patientId;
	private boolean patientNin;
	private boolean patientBirthday;
	private boolean patientGender;
	private boolean patientDoctorId;
	private boolean patientDeleted;
	private boolean patientChecked;
	private boolean patientContactId;


	// Contact properties	
	private boolean contactId;
	private boolean contactFirstName;
	private boolean contactLastName;
	private boolean contactAddressStreet;
	private boolean contactAddressHn;
	private boolean contactAddressCity;
	private boolean contactPostalCode;
	private boolean contactCountry;
	private boolean contactPhoneNumber;
	private boolean contactEmail;
	

	// Anamnesis properties
	private boolean anamnesisId;
	private boolean anamnesisDate;
	private boolean anamnesisDoctorId;
	private boolean anamnesisAdded;
	private boolean anamnesisBeginningEpilepsy;
	private boolean anamnesisInfantileSpasm;
	private boolean anamnesisSpecificSyndrome;
	private boolean anamnesisEpilepsyInFamily;
	private boolean anamnesisParentalRisk;
	private boolean anamnesisFibrilConvulsions;
	private boolean anamnesisInflammationCns;
	private boolean anamnesisInjuryCns;
	private boolean anamnesisOperationCns;
	private boolean anamnesisEarlyPmdRetardation;
	private boolean anamnesisNonCnsComorbidity;
	private boolean anamnesisComment;

	
	// Complication properties
	private boolean complicationId;
	private boolean complicationDate;
	private boolean complicationDoctorId;
	private boolean complicationAdded;
	private boolean complicationIdCom;
	private boolean complicationComment;
	private boolean complicationDeleted;
	private boolean complicationPatientId;
	private boolean complicationAddUserId;
	private boolean complicationStatus;
	
	
	

	public String changerToString(int ID, Locale locale) {
		if (ID == 0) {
			return messageSource.getMessage("label.anamnesis", null, locale);
		} else if (ID == 1) {
			return "Farmakoloterapie";
			// return messageSource.getMessage("label.anamnesis", null, locale);
		} else if (ID == 2) {
			return "Zachvaty";
			// return messageSource.getMessage("label.anamnesis", null, locale);
		} else if (ID == 3) {
			return "Farmakoloterapie";
			// return messageSource.getMessage("label.anamnesis", null, locale);
		} else if (ID == 4) {
			return "Neurologicke nalezy";
			// return messageSource.getMessage("label.anamnesis", null, locale);
		} else if (ID == 5) {
			return "Neuropsychologie";
			// return messageSource.getMessage("label.anamnesis", null, locale);
		} else if (ID == 6) {
			return "Diagnosticke EEG testy";
			// return messageSource.getMessage("label.anamnesis", null, locale);
		} else if (ID == 7) {
			return "Diagnosticke MRI testy";
			// return messageSource.getMessage("label.anamnesis", null, locale);
		} else if (ID == 8) {
			return "Invazivni EEG testy";
			// return messageSource.getMessage("label.anamnesis", null, locale);
		} else if (ID == 9) {
			return "Invazivni ECoG testy";
			// return messageSource.getMessage("label.anamnesis", null, locale);
		} else if (ID == 10) {
			return "Operace";
			// return messageSource.getMessage("label.anamnesis", null, locale);
		} else if (ID == 11) {
			return "Histologie";
			// return messageSource.getMessage("label.anamnesis", null, locale);
		} else if (ID == 12) {
			return "Komplikace";
			// return messageSource.getMessage("label.anamnesis", null, locale);
		} else if (ID == 13) {
			return "Outcome";
			// return messageSource.getMessage("label.anamnesis", null, locale);
		} else {
			return "Unkonown ID of the card";
		}
	}
}

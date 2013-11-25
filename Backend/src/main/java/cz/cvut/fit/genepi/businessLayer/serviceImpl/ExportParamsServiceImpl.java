package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.businessLayer.service.ExportParamsService;
import cz.cvut.fit.genepi.dataLayer.DAO.ExportParamsDAO;
import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;

@Service
public class ExportParamsServiceImpl extends
		GenericServiceImpl<ExportParamsEntity> implements
		ExportParamsService {
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ExportParamsDAO exportParamsDAO;

	@Transactional
	public List<ExportParamsEntity> findExportParamsEntityByUserID(int userID) {
		return exportParamsDAO.findExportParamsByUserID(userID);
	}

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

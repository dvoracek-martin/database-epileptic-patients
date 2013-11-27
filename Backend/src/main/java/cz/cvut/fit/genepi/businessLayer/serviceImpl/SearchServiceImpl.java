package cz.cvut.fit.genepi.businessLayer.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.businessLayer.service.SearchService;
import cz.cvut.fit.genepi.dataLayer.DAO.PatientDAO;
import cz.cvut.fit.genepi.dataLayer.entity.AdvancedSearchEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private PatientDAO patientDAO;

	@Override
	@Transactional
	public List<PatientEntity> performAdvancedSearch(
			AdvancedSearchEntity advancedSearch) {
		return patientDAO.performSearch(advancedSearch);
	}
}
package cz.cvut.fit.genepi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.DAO.PatientDAO;
import cz.cvut.fit.genepi.entity.AdvancedSearchEntity;
import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.service.SearchService;

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

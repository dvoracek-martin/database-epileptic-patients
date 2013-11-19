package cz.cvut.fit.genepi.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.entity.AdvancedSearchEntity;
import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.service.SearchService;

public class SearchServiceImpl implements SearchService {

	@Override
	@Transactional
	public List<PatientEntity> performAdvancedSearch(AdvancedSearchEntity advancedSearch){
		return null;
	}
}

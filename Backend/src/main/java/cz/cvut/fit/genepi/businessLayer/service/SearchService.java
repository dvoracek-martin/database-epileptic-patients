package cz.cvut.fit.genepi.businessLayer.service;

import java.util.List;

import cz.cvut.fit.genepi.dataLayer.entity.AdvancedSearchEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

public interface SearchService {

	public List<PatientEntity> performAdvancedSearch(AdvancedSearchEntity advancedSearch);
}

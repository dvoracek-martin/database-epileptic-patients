package cz.cvut.fit.genepi.service;

import java.util.List;

import cz.cvut.fit.genepi.entity.AdvancedSearchEntity;
import cz.cvut.fit.genepi.entity.PatientEntity;

public interface SearchService {

	public List<PatientEntity> performAdvancedSearch(AdvancedSearchEntity advancedSearch);
}

package cz.cvut.fit.genepi.businessLayer.service;

import java.util.List;

import cz.cvut.fit.genepi.dataLayer.entity.AdvancedSearchEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

/**
 * The Interface SearchService extends GenericService
 */
public interface SearchService {
	
	/**
	 * Searches patients according to the conditions user chose
	 * @params advancedSearch as AdvancedSearchEntyt
	 * @return List of PatientEntity
	 */
	public List<PatientEntity> performAdvancedSearch(AdvancedSearchEntity advancedSearch);
}

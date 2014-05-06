package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.businessLayer.BO.display.AdvancedSearchDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.display.PatientDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.AdvancedSearchFormBO;

import java.util.List;

/**
 * The Interface SearchService extends GenericService
 */
public interface SearchService {

    /**
     * Searches patients according to the conditions user chose
     *
     * @return List of PatientEntity
     * @params advancedSearch as AdvancedSearchEntyt
     */
    public List<List<PatientDisplayBO>> performAdvancedSearch(AdvancedSearchFormBO advancedSearch);

    public void save(AdvancedSearchFormBO advancedSearch);

    public List<AdvancedSearchDisplayBO> loadAll();
}

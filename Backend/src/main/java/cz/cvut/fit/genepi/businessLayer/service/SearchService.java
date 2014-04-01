package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.businessLayer.VO.display.PatientDisplayVO;
import cz.cvut.fit.genepi.businessLayer.VO.form.AdvancedSearchVO;
import cz.cvut.fit.genepi.dataLayer.entity.AdvancedSearchEntity;
import cz.cvut.fit.genepi.dataLayer.entity.PatientEntity;

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
    public List<PatientDisplayVO> performAdvancedSearch(AdvancedSearchVO advancedSearch);
}

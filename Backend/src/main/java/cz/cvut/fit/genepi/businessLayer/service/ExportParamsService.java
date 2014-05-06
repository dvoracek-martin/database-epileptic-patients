package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.businessLayer.BO.display.ExportParamsDisplayBO;
import cz.cvut.fit.genepi.businessLayer.BO.form.ExportParamsFormBO;
import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;

import java.util.List;

/**
 * The Interface ExportToCsvService extends GenericService
 */
public interface ExportParamsService extends GenericService<ExportParamsFormBO, ExportParamsEntity> {

    /**
     * Find export configurations according to user's ID
     *
     * @param userID as int
     * @return List of ExportParans Entity
     */
    public List<ExportParamsEntity> findExportParamsEntityByUserID(int userID);

    public List<ExportParamsDisplayBO> getGenericConfigurations();

    public List<ExportParamsDisplayBO> getConfigurationsByUsername(String username);
}

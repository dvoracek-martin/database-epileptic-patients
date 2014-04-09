package cz.cvut.fit.genepi.dataLayer.DAO;

import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;

import java.util.List;

/**
 * ExportParamsDAO interface
 */
public interface ExportParamsDAO extends GenericDAO<ExportParamsEntity> {

    /**
     * Finds list of all export parameters for chosen user
     *
     * @param userID the ID of the user
     * @return List of ExportParamsEntity
     */
    public List<ExportParamsEntity> findExportParamsByUserID(int userID);

    public List<ExportParamsEntity> getGenericConfigurations();

    public List<ExportParamsEntity> getConfigurationsByUsername(int userId);
}

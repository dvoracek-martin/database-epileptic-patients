package cz.cvut.fit.genepi.dataLayer.DAO;

import java.util.List;

import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;

/**
 * ExportParamsDAO interface
 */
public interface ExportParamsDAO extends GenericDAO<ExportParamsEntity> {
	
	/**
	 * Finds list of all export parameters for chosen user
	 * @param userID the ID of the user
	 * @return List of ExportParamsEntity
	 */
	public List<ExportParamsEntity> findExportParamsByUserID(int userID);
}

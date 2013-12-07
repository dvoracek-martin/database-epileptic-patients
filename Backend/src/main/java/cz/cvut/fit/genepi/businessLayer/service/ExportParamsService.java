package cz.cvut.fit.genepi.businessLayer.service;

import java.util.List;
import java.util.Locale;

import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;

/**
 * The Interface ExportToCsvService extends GenericService
 */
public interface ExportParamsService extends
		GenericService<ExportParamsEntity> {

	/**
	 * Find export configurations according to user's ID
	 * 
	 * @param userID as int
	 * @return List of ExportParans Entity
	 */
	public List<ExportParamsEntity> findExportParamsEntityByUserID(int userID);
	
	/**
	 * Changes id of the configs to chained values in string
	 * @param userID as int, locale as Locale
	 * @return String
	 * @deprecated
	 */
	@Deprecated
	public String changerToString(int ID, Locale locale);
}

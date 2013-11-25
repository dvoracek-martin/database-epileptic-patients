package cz.cvut.fit.genepi.businessLayer.service;

import java.util.List;
import java.util.Locale;

import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;

public interface ExportParamsService extends
		GenericService<ExportParamsEntity> {

	public List<ExportParamsEntity> findExportParamsEntityByUserID(int userID);
	
	public String changerToString(int ID, Locale locale);
}

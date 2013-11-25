package cz.cvut.fit.genepi.dataLayer.DAO;

import java.util.List;

import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;

public interface ExportParamsDAO extends GenericDAO<ExportParamsEntity> {
	public List<ExportParamsEntity> findExportParamsByUserID(int userID);
}

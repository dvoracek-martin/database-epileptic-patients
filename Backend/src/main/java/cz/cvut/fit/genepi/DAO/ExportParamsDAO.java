package cz.cvut.fit.genepi.DAO;

import java.util.List;

import cz.cvut.fit.genepi.entity.ExportParamsEntity;

public interface ExportParamsDAO extends GenericDAO<ExportParamsEntity> {
	public List<ExportParamsEntity> findExportParamsByUserID(int userID);
}

package cz.cvut.fit.genepi.service;

import java.io.Serializable;
import java.util.List;

import cz.cvut.fit.genepi.entity.ExportParamsEntity;

public interface ExportParamsService extends
		GenericService<ExportParamsEntity, Serializable> {

	public List<ExportParamsEntity> findExportParamsEntityByUserID(int userID);
}

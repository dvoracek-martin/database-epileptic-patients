package cz.cvut.fit.genepi.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.DAO.ExportParamsDAO;
import cz.cvut.fit.genepi.entity.ExportParamsEntity;
import cz.cvut.fit.genepi.service.ExportParamsService;

@Service
public class ExportParamsServiceImpl extends GenericServiceImpl<ExportParamsEntity, Serializable>
		implements ExportParamsService {
	@Autowired
	private ExportParamsDAO exportParamsDAO;
	
	@Transactional
	public List<ExportParamsEntity> findExportParamsEntityByUserID(int userID) {
		return exportParamsDAO.findExportParamsByUserID(userID);
	}
}

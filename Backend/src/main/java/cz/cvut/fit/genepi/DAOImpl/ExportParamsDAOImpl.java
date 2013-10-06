package cz.cvut.fit.genepi.DAOImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.ExportParamsDAO;
import cz.cvut.fit.genepi.entity.ExportParamsEntity;

@Repository
public class ExportParamsDAOImpl extends GenericDAOImpl<ExportParamsEntity, Serializable> implements
		ExportParamsDAO {
	@Override
	public List<ExportParamsEntity> findExportParamsByUserID(int userID) {
		List<ExportParamsEntity> exportParamsEntities = new ArrayList<ExportParamsEntity>();
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from ExportParamsEntity where user_ID = :user_ID");
		query.setParameter("user_ID", userID);		
		exportParamsEntities = findMany(query);
		
		return exportParamsEntities;
	}
}

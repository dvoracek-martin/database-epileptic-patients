package cz.cvut.fit.genepi.dataLayer.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.dataLayer.DAO.ExportParamsDAO;
import cz.cvut.fit.genepi.dataLayer.entity.ExportParamsEntity;

@Repository
public class ExportParamsDAOImpl extends GenericDAOImpl<ExportParamsEntity> implements
		ExportParamsDAO {
	@Override
	public List<ExportParamsEntity> findExportParamsByUserID(int userID) {
		List<ExportParamsEntity> exportParamsEntities = new ArrayList<ExportParamsEntity>();
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from ExportParamsEntity where userID = :user_id");
		query.setParameter("user_id", userID);		
		exportParamsEntities = findMany(query);
		
		return exportParamsEntities;
	}
}

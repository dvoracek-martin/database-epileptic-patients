package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.dataLayer.DAO.card.AnamnesisDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.AnamnesisEntity;

/**
 * Implementation of AnamnesisFindingDAO Extending implementation of GenericDAO
 */
@Repository
public class AnamnesisDAOImpl extends GenericDAOImpl<AnamnesisEntity> implements
		AnamnesisDAO {

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<AnamnesisEntity> findAllHidden() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from AnamnesisEntity where status = 1");

		return query.list();
	}

}
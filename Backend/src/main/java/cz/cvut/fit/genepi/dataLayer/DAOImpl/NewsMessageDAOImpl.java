package cz.cvut.fit.genepi.dataLayer.DAOImpl;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.dataLayer.DAO.NewsMessageDAO;
import cz.cvut.fit.genepi.dataLayer.entity.NewsMessageEntity;

/*
 * Implementation of NewsMessageFindingDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class NewsMessageDAOImpl extends GenericDAOImpl<NewsMessageEntity>
		implements NewsMessageDAO {
}

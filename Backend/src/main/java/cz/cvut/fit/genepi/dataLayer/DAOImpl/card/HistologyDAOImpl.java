package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.dataLayer.DAO.card.HistologyDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.HistologyEntity;

/**
 * Implementation of HistologyDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class HistologyDAOImpl extends GenericDAOImpl<HistologyEntity> implements
		HistologyDAO {

}

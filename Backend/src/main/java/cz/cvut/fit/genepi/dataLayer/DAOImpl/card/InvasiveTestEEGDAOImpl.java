package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestEegEntity;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.dataLayer.DAO.card.InvasiveTestEEGDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;

/**
 * Implementation of InvasiveTEestEEGDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class InvasiveTestEEGDAOImpl extends GenericDAOImpl<InvasiveTestEegEntity> implements
		InvasiveTestEEGDAO {

}

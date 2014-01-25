package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestEcogEntity;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.dataLayer.DAO.card.InvasiveTestECOGDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;

/**
 * Implementation of InvasiveTestECOGDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class InvasiveTestECOGDAOImpl  extends
GenericDAOImpl<InvasiveTestEcogEntity> implements InvasiveTestECOGDAO{

}

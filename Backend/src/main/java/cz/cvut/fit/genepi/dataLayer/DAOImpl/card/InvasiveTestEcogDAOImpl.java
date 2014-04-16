package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import cz.cvut.fit.genepi.dataLayer.DAO.card.InvasiveTestEcogDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestEcogEntity;
import org.springframework.stereotype.Repository;

/**
 * Implementation of InvasiveTestEcogDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class InvasiveTestEcogDAOImpl
        extends GenericDAOImpl<InvasiveTestEcogEntity>
        implements InvasiveTestEcogDAO {

}

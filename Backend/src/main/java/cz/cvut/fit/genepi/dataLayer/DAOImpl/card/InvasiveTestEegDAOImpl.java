package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import cz.cvut.fit.genepi.dataLayer.DAO.card.InvasiveTestEegDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.InvasiveTestEegEntity;
import org.springframework.stereotype.Repository;

/**
 * Implementation of InvasiveTEestEEGDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class InvasiveTestEegDAOImpl
        extends GenericDAOImpl<InvasiveTestEegEntity>
        implements InvasiveTestEegDAO {

}

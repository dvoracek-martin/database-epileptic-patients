package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import cz.cvut.fit.genepi.dataLayer.DAO.card.OutcomeDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.OutcomeEntity;
import org.springframework.stereotype.Repository;

/**
 * Implementation of OutcomeDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class OutcomeDAOImpl
        extends GenericDAOImpl<OutcomeEntity>
        implements OutcomeDAO {

}

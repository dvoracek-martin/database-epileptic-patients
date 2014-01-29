package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import cz.cvut.fit.genepi.dataLayer.DAO.card.ComplicationDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.ComplicationEntity;
import org.springframework.stereotype.Repository;

/**
 * Implementation of ComplicationDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class ComplicationDAOImpl extends GenericDAOImpl<ComplicationEntity>
        implements ComplicationDAO {

}

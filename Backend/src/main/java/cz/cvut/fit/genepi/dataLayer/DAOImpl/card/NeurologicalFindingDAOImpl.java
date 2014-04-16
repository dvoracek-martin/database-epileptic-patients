package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import cz.cvut.fit.genepi.dataLayer.DAO.card.NeurologicalFindingDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeurologicalFindingEntity;
import org.springframework.stereotype.Repository;


/**
 * Implementation of NeurologicalFindingDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class NeurologicalFindingDAOImpl
        extends GenericDAOImpl<NeurologicalFindingEntity>
        implements NeurologicalFindingDAO {

}

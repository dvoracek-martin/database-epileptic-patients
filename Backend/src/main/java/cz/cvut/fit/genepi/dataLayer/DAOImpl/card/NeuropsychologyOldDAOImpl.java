package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import cz.cvut.fit.genepi.dataLayer.DAO.card.NeuropsychologyOldDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.NeuropsychologyOldEntity;
import org.springframework.stereotype.Repository;

/**
 * Implementation of NeuropsychologyOldDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class NeuropsychologyOldDAOImpl
        extends GenericDAOImpl<NeuropsychologyOldEntity>
        implements NeuropsychologyOldDAO {

}

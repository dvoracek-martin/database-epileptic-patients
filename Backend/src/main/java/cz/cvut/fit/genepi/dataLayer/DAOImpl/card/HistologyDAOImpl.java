package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import cz.cvut.fit.genepi.dataLayer.DAO.card.HistologyDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.HistologyEntity;
import org.springframework.stereotype.Repository;

/**
 * Implementation of HistologyDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class HistologyDAOImpl extends GenericDAOImpl<HistologyEntity> implements
        HistologyDAO {

}

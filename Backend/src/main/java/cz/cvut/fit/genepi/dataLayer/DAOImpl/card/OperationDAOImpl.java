package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import cz.cvut.fit.genepi.dataLayer.DAO.card.OperationDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.OperationEntity;
import org.springframework.stereotype.Repository;

/**
 * Implementation of OperationDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class OperationDAOImpl extends GenericDAOImpl<OperationEntity> implements
        OperationDAO {
}

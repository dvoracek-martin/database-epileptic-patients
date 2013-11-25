package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.dataLayer.DAO.card.OperationDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.OperationEntity;

@Repository
public class OperationDAOImpl  extends
GenericDAOImpl<OperationEntity> implements
 OperationDAO  {
}

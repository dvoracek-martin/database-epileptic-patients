package cz.cvut.fit.genepi.DAOImpl.card;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.card.OperationDAO;
import cz.cvut.fit.genepi.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.entity.card.OperationEntity;

@Repository
public class OperationDAOImpl  extends
GenericDAOImpl<OperationEntity> implements
 OperationDAO  {
}

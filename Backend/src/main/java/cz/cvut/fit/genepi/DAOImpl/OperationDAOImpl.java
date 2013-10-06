package cz.cvut.fit.genepi.DAOImpl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.OperationDAO;
import cz.cvut.fit.genepi.entity.OperationEntity;

@Repository
public class OperationDAOImpl  extends
GenericDAOImpl<OperationEntity, Serializable> implements
 OperationDAO  {
}

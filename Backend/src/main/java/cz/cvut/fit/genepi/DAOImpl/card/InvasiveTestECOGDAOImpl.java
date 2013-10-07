package cz.cvut.fit.genepi.DAOImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.card.InvasiveTestECOGDAO;
import cz.cvut.fit.genepi.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.entity.card.InvasiveTestECOGEntity;

@Repository
public class InvasiveTestECOGDAOImpl  extends
GenericDAOImpl<InvasiveTestECOGEntity, Serializable> implements InvasiveTestECOGDAO{

}

package cz.cvut.fit.genepi.DAOImpl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.InvasiveTestECOGDAO;
import cz.cvut.fit.genepi.entity.InvasiveTestECOGEntity;

@Repository
public class InvasiveTestECOGDAOImpl  extends
GenericDAOImpl<InvasiveTestECOGEntity, Serializable> implements InvasiveTestECOGDAO{

}

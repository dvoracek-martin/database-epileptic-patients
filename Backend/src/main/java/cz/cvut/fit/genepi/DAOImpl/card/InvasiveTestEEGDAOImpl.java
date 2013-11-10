package cz.cvut.fit.genepi.DAOImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.card.InvasiveTestEEGDAO;
import cz.cvut.fit.genepi.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.entity.card.InvasiveTestEEGEntity;

@Repository
public class InvasiveTestEEGDAOImpl extends GenericDAOImpl<InvasiveTestEEGEntity, Serializable> implements
		InvasiveTestEEGDAO {

}

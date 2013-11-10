package cz.cvut.fit.genepi.DAOImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.card.HistologyDAO;
import cz.cvut.fit.genepi.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.entity.card.HistologyEntity;

@Repository
public class HistologyDAOImpl extends GenericDAOImpl<HistologyEntity, Serializable> implements
		HistologyDAO {

}

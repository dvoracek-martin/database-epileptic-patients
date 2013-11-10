package cz.cvut.fit.genepi.DAOImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.card.OutcomeDAO;
import cz.cvut.fit.genepi.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.entity.card.OutcomeEntity;

@Repository
public class OutcomeDAOImpl extends GenericDAOImpl<OutcomeEntity, Serializable> implements OutcomeDAO {

}

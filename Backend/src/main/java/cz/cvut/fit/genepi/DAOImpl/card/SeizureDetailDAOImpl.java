package cz.cvut.fit.genepi.DAOImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.card.SeizureDetailDAO;
import cz.cvut.fit.genepi.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.entity.card.SeizureDetailEntity;

@Repository
public class SeizureDetailDAOImpl extends
		GenericDAOImpl<SeizureDetailEntity, Serializable> implements
		SeizureDetailDAO {

}
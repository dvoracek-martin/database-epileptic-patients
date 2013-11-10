package cz.cvut.fit.genepi.DAOImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.card.NeuropsychologyDAO;
import cz.cvut.fit.genepi.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.entity.card.NeuropsychologyEntity;

@Repository
public class NeuropsychologyDAOImpl extends GenericDAOImpl<NeuropsychologyEntity, Serializable> implements
		NeuropsychologyDAO {

}

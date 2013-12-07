package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.dataLayer.DAO.card.AnamnesisDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.AnamnesisEntity;

/**
 * Implementation of AnamnesisFindingDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class AnamnesisDAOImpl extends GenericDAOImpl<AnamnesisEntity> implements
		AnamnesisDAO {

}
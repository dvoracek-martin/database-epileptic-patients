package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.dataLayer.DAO.card.PharmacotherapyDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.PharmacotherapyEntity;

/**
 * Implementation of PharmacoatherapyDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class PharmacotherapyDAOImpl extends GenericDAOImpl<PharmacotherapyEntity> implements
		PharmacotherapyDAO {

}

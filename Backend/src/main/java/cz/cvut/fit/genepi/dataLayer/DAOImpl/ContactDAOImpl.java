package cz.cvut.fit.genepi.dataLayer.DAOImpl;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.dataLayer.DAO.ContactDAO;
import cz.cvut.fit.genepi.dataLayer.entity.ContactEntity;

/**
 * The Class ContactDAOImpl.
 */
@Repository
public class ContactDAOImpl  extends GenericDAOImpl<ContactEntity> implements ContactDAO{

}

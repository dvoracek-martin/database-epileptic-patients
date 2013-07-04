package cz.cvut.fit.genepi.DAOImpl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.ContactDAO;
import cz.cvut.fit.genepi.entities.ContactEntity;

/**
 * The Class ContactDAOImpl.
 */
@Repository
public class ContactDAOImpl  extends GenericDAOImpl<ContactEntity, Serializable> implements ContactDAO{

}

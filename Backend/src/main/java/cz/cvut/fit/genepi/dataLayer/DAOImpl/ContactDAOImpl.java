package cz.cvut.fit.genepi.dataLayer.DAOImpl;

import cz.cvut.fit.genepi.dataLayer.DAO.ContactDAO;
import cz.cvut.fit.genepi.dataLayer.entity.ContactEntity;
import org.springframework.stereotype.Repository;

/**
 * Implementation of ContactDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class ContactDAOImpl
        extends GenericDAOImpl<ContactEntity>
        implements ContactDAO {

}

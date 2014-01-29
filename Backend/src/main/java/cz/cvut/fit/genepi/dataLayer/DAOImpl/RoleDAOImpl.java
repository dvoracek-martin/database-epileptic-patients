package cz.cvut.fit.genepi.dataLayer.DAOImpl;

import cz.cvut.fit.genepi.dataLayer.DAO.RoleDAO;
import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;
import org.springframework.stereotype.Repository;

/**
 * Implementation of RoleDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class RoleDAOImpl extends GenericDAOImpl<RoleEntity> implements RoleDAO {
}

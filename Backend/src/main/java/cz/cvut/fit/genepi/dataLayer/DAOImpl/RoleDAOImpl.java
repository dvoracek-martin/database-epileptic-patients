package cz.cvut.fit.genepi.dataLayer.DAOImpl;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.dataLayer.DAO.RoleDAO;
import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;

/*
 * Implementation of RoleDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class RoleDAOImpl extends GenericDAOImpl<RoleEntity> implements RoleDAO {
}

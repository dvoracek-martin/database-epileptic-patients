package cz.cvut.fit.genepi.DAOImpl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.RoleDAO;
import cz.cvut.fit.genepi.entity.RoleEntity;

/**
 * The Class RoleDAOImpl.
 */
@Repository
public class RoleDAOImpl extends GenericDAOImpl<RoleEntity, Serializable>
		implements RoleDAO {

}

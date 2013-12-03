package cz.cvut.fit.genepi.dataLayer.DAOImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.dataLayer.DAO.RoleDAO;
import cz.cvut.fit.genepi.dataLayer.entity.RoleEntity;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;

/**
 * The Class RoleDAOImpl.
 */
@Repository
public class RoleDAOImpl extends GenericDAOImpl<RoleEntity>
		implements RoleDAO {
}

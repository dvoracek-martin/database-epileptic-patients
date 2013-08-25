package cz.cvut.fit.genepi.DAOImpl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.UserRoleDAO;
import cz.cvut.fit.genepi.entity.UserRoleEntity;

@Repository
public class UserRoleDAOImpl  extends GenericDAOImpl<UserRoleEntity, Serializable>
implements UserRoleDAO {
}

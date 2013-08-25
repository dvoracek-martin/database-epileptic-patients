package cz.cvut.fit.genepi.DAO;

import java.io.Serializable;

import cz.cvut.fit.genepi.entity.UserEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserDAO.
 */
public interface UserDAO extends GenericDAO<UserEntity, Serializable> {

	UserEntity findUserByUsername(String username); 
}

package cz.cvut.fit.genepi.DAO;

import java.io.Serializable;

import cz.cvut.fit.genepi.entity.UserEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserDAO.
 */
public interface UserDAO extends GenericDAO<UserEntity, Serializable> {

	/**
	 * Find user by id.
	 *
	 * @param userID the user id
	 * @return the user entity
	 */
	UserEntity findUserByID(Integer userID);
}

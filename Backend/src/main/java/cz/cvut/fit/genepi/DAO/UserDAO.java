package cz.cvut.fit.genepi.DAO;

import java.io.Serializable;

import java.util.List;
import cz.cvut.fit.genepi.entity.UserEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserDAO.
 */
public interface UserDAO extends GenericDAO<UserEntity, Serializable> {

	/**
	 * Find user by username.
	 *
	 * @param username the username
	 * @return the user entity
	 */
	UserEntity findUserByUsername(String username);

	/**
	 * Gets the doctors.
	 *
	 * @return the doctors
	 */
	List<UserEntity> getDoctors(); 
}

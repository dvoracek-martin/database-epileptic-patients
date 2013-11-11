package cz.cvut.fit.genepi.DAO;

import java.util.List;

import cz.cvut.fit.genepi.entity.UserEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserDAO.
 */
public interface UserDAO extends GenericDAO<UserEntity> {

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

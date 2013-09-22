package cz.cvut.fit.genepi.service;

import java.io.Serializable;

import java.util.List;
import cz.cvut.fit.genepi.entity.UserEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserService.
 */
public interface UserService extends GenericService<UserEntity, Serializable> {

	/**
	 * Find user by username.
	 *
	 * @param username the username
	 * @return the user entity
	 */
	public UserEntity findUserByUsername(String username);

	/**
	 * Gets the doctors.
	 *
	 * @return the doctors
	 */
	public List<UserEntity> getDoctors();
}

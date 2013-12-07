package cz.cvut.fit.genepi.businessLayer.service;

import java.util.List;
import java.util.Locale;

import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;

/**
 * The Interface UserService extends GenericService
 */
public interface UserService extends GenericService<UserEntity> {

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

	/** creates new user with his locale
	 * 
	 * @param user as UserEntity
	 * @param locale as Locale
	 */
	public void create(UserEntity user, Locale locale);
}

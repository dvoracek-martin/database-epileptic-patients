package cz.cvut.fit.genepi.service;

import java.util.List;

import cz.cvut.fit.genepi.entity.UserEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserService.
 */
public interface UserService {
	
	/**
	 * Save.
	 *
	 * @param user the user
	 */
	public void save(UserEntity user);

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the user entity
	 */
	public UserEntity findByID(int id);

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<UserEntity> findAll();

	/**
	 * Find user by username.
	 *
	 * @param username the username
	 * @return the user entity
	 */
	public UserEntity findUserByUsername(String username);
	
	public void merge(UserEntity user);
}

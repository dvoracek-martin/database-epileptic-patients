package cz.cvut.fit.genepi.service;

import java.util.List;

import cz.cvut.fit.genepi.entity.UserRoleEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserRoleService.
 */
public interface UserRoleService  {
	
	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<UserRoleEntity> findAll();
	
	/**
	 * Find by id.
	 *
	 * @param userRoleID the user role id
	 * @return the user role entity
	 */
	public UserRoleEntity findByID(int userRoleID);
	
	/**
	 * Find all user roles by user id.
	 *
	 * @param userID the user id
	 * @return the list
	 */
	public List<UserRoleEntity> findAllUserRolesByUserID(int userID);
	
	/**
	 * Find all user roles by role id.
	 *
	 * @param roleID the role id
	 * @return the list
	 */
	public List<UserRoleEntity> findAllUserRolesByRoleID(int roleID);
}

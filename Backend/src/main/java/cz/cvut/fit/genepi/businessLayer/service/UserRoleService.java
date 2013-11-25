package cz.cvut.fit.genepi.businessLayer.service;

import java.util.List;

import cz.cvut.fit.genepi.dataLayer.entity.UserRoleEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserRoleService.
 */
public interface UserRoleService extends GenericService<UserRoleEntity>   {
	
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

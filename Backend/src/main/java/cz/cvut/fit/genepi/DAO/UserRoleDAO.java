package cz.cvut.fit.genepi.DAO;

import java.io.Serializable;
import java.util.List;

import cz.cvut.fit.genepi.entity.UserRoleEntity;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserRoleDAO.
 */
public interface UserRoleDAO extends GenericDAO<UserRoleEntity, Serializable> { 
	
	/**
	 * Find all user roles by user id.
	 *
	 * @param userID the user id
	 * @return the list
	 */
	List<UserRoleEntity> findAllUserRolesByUserID(int userID);
	
	/**
	 * Find all user roles by role id.
	 *
	 * @param roleID the role id
	 * @return the list
	 */
	List<UserRoleEntity> findAllUserRolesByRoleID(int roleID);
}

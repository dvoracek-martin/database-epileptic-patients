package cz.cvut.fit.genepi.dataLayer.DAO;

import cz.cvut.fit.genepi.dataLayer.entity.UserRoleEntity;

import java.util.List;

/**
 * UserRoleDAO interface
 */
public interface UserRoleDAO extends GenericDAO<UserRoleEntity> {

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

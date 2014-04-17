package cz.cvut.fit.genepi.businessLayer.service;

import cz.cvut.fit.genepi.dataLayer.entity.UserRoleEntity;

import java.util.List;

/**
 * The Interface UserRoleService extends GenericService
 */
public interface UserRoleService {

    /**
     * Find all user roles by user id.
     *
     * @param userID the user id
     * @return the list
     */
    public List<UserRoleEntity> findAllUserRolesByUserID(int userID);

}

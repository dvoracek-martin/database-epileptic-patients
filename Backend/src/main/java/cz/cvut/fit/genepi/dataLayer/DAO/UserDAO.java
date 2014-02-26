package cz.cvut.fit.genepi.dataLayer.DAO;

import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;

import java.util.List;

/**
 * UserDAO interface
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
     * Gets the list of all doctors.
     *
     * @return the doctors
     */
    List<UserEntity> getDoctors();

    List<UserEntity> findAllUsersWithPagination(int maxResults,int pageNumber);

    UserEntity findUserByEmail(String email);
}

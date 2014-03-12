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
    public UserEntity findUserByUsername(String username);

    /**
     * Gets the list of all doctors.
     *
     * @return the doctors
     */
    public List<UserEntity> getDoctors();

    public List findAllUsersWithPagination(int maxResults, int pageNumber);

    public UserEntity findUserByEmail(String email);

    public int saveUser(UserEntity userEntity);

    public List<UserEntity> findAllNonHidden();
}
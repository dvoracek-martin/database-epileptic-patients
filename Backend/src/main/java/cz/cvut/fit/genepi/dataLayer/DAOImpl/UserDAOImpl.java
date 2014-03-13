package cz.cvut.fit.genepi.dataLayer.DAOImpl;

import cz.cvut.fit.genepi.dataLayer.DAO.UserDAO;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of UserDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class UserDAOImpl extends GenericDAOImpl<UserEntity> implements UserDAO {

    /* (non-Javadoc)
     * @see cz.cvut.fit.genepi.DAO.UserDAO#findUserByUsername(java.lang.String)
     */
    @Override
    public UserEntity findUserByUsername(String username) {

        Query query = sessionFactory
                .getCurrentSession()
                .createQuery("from UserEntity where username = :user_name")
                .setParameter("user_name", username);

        return findOne(query);
    }

    @SuppressWarnings("unchecked")
    public List<UserEntity> findAllUsersWithPagination(int maxResults, int pageNumber) {

        Query query = sessionFactory
                .getCurrentSession()
                .createQuery("from " + UserEntity.class.getName() + "" +
                        " WHERE hidden=0 ORDER BY contact.lastName,contact.firstName")
                .setFirstResult(maxResults * (pageNumber - 1))
                .setMaxResults(maxResults);

        return query.list();
    }

    /* (non-Javadoc)
     * @see cz.cvut.fit.genepi.DAO.UserDAO#getDoctors()
     */
    //TODO really strange method!!!
    @Override
    public List<UserEntity> getDoctors() {

        Query query = sessionFactory
                .getCurrentSession()
                .createQuery("from UserEntity where username = :user_name");

        return findMany(query);
    }

    @Override
    public UserEntity findUserByEmail(String email) {

        Query query = sessionFactory
                .getCurrentSession()
                .createQuery("from UserEntity where contact.email = :email")
                .setParameter("email", email);

        return findOne(query);
    }

    @Override
    public int saveUser(UserEntity userEntity) {

        sessionFactory.getCurrentSession().saveOrUpdate(userEntity);

        return userEntity.getId();
    }

    @Override
    public List<UserEntity> findAllNonHidden() {

        Query query = sessionFactory
                .getCurrentSession()
                .createQuery("from UserEntity where hidden = false ORDER BY username");

        return findMany(query);
    }
}
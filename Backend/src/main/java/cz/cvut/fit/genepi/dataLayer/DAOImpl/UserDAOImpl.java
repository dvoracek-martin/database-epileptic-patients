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
     * @see cz.cvut.fit.genepi.DAO.UserDAO#getUserByUsername(java.lang.String)
     */
    @Override
    public UserEntity findUserByUsername(String username) {

        Query query = sessionFactory
                .getCurrentSession()
                .createQuery("from UserEntity u left join fetch u.roles where u.username = :user_name")
                .setParameter("user_name", username);

        return (UserEntity) query.uniqueResult();
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
    @SuppressWarnings("unchecked")
    public List<UserEntity> getDoctors() {

        Query query = sessionFactory
                .getCurrentSession()
                .createQuery("from UserEntity where username = :user_name");

        return (List<UserEntity>) query.list();
    }

    @Override
    public UserEntity findUserByEmail(String email) {

        Query query = sessionFactory
                .getCurrentSession()
                .createQuery("from UserEntity where contact.email = :email")
                .setParameter("email", email);

        return (UserEntity) query.uniqueResult();
    }

    @Override
    public int saveUser(UserEntity userEntity) {

        sessionFactory.getCurrentSession().saveOrUpdate(userEntity);

        return userEntity.getId();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UserEntity> findAllNonHidden() {

        Query query = sessionFactory
                .getCurrentSession()
                .createQuery("from UserEntity where hidden = false ORDER BY username");

        return (List<UserEntity>) query.list();
    }

    @Override
    public void hide(int userId) {
        Query query = sessionFactory
                .getCurrentSession()
                .createQuery("UPDATE UserEntity SET hidden = true WHERE id = :userId");
        query.setParameter("userId", userId);
        query.executeUpdate();
    }
}

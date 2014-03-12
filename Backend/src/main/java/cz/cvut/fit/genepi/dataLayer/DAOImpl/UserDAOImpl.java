package cz.cvut.fit.genepi.dataLayer.DAOImpl;

import cz.cvut.fit.genepi.dataLayer.DAO.UserDAO;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of UserDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class UserDAOImpl extends GenericDAOImpl<UserEntity>
        implements UserDAO {

    /* (non-Javadoc)
     * @see cz.cvut.fit.genepi.DAO.UserDAO#findUserByUsername(java.lang.String)
     */
    @Override
    public UserEntity findUserByUsername(String username) {
        UserEntity userEntity;
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from UserEntity where username = :user_name");
        query.setParameter("user_name", username);
        userEntity = findOne(query);
        return userEntity;
    }

    public List<UserEntity> findAllUsersWithPagination(int maxResults, int pageNumber) {
        List<UserEntity> users = null;
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from " + UserEntity.class.getName() + " WHERE hidden=0 ORDER BY contact.lastName,contact.firstName");

        query.setFirstResult(maxResults * (pageNumber - 1));
        query.setMaxResults(maxResults);

        users = query.list();
        return users;
    }

    /* (non-Javadoc)
     * @see cz.cvut.fit.genepi.DAO.UserDAO#getDoctors()
     */
    @Override
    public List<UserEntity> getDoctors() {
        List<UserEntity> doctors = new ArrayList<UserEntity>();
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from UserEntity where username = :user_name");

        doctors = findMany(query);
        return doctors;
    }


    @Override
    public UserEntity findUserByEmail(String email) {
        UserEntity userEntity;
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from UserEntity where contact.email = :e_mail");
        query.setParameter("e_mail", email);
        userEntity = findOne(query);
        return userEntity;
    }

    @Override
    public int saveUser(UserEntity userEntity) {
        sessionFactory.getCurrentSession().saveOrUpdate(userEntity);
        return userEntity.getId();
    }
}

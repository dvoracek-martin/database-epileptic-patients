package cz.cvut.fit.genepi.dataLayer.DAOImpl;

import cz.cvut.fit.genepi.dataLayer.DAO.UserRoleDAO;
import cz.cvut.fit.genepi.dataLayer.entity.UserRoleEntity;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of UserRoleDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class UserRoleDAOImpl
        extends GenericDAOImpl<UserRoleEntity>
        implements UserRoleDAO {

    /* (non-Javadoc)
     * @see cz.cvut.fit.genepi.DAO.UserRoleDAO#findAllUserRolesByUserID(int)
     */

    @SuppressWarnings("unchecked")
    @Override
    public List<UserRoleEntity> findAllUserRolesByUserID(int user_id) {
        List<UserRoleEntity> userRoleEntities;
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from UserRoleEntity where userId = :userID");
        query.setParameter("userID", user_id);
        userRoleEntities = (List<UserRoleEntity>) query.list();
        return userRoleEntities;
    }

    /* (non-Javadoc)
     * @see cz.cvut.fit.genepi.DAO.UserRoleDAO#findAllUserRolesByRoleID(int)
     */

    @SuppressWarnings("unchecked")
    @Override
    public List<UserRoleEntity> findAllUserRolesByRoleID(int role_id) {
        List<UserRoleEntity> userRoleEntities;
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from UserRoleEntity where roleId = :roleID");
        query.setParameter("roleID", role_id);
        userRoleEntities = (List<UserRoleEntity>) query.list();
        return userRoleEntities;
    }
}

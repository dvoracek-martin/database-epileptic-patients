package cz.cvut.fit.genepi.dataLayer.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.dataLayer.DAO.UserRoleDAO;
import cz.cvut.fit.genepi.dataLayer.entity.UserRoleEntity;

/*
 * Implementation of UserRoleDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class UserRoleDAOImpl  extends GenericDAOImpl<UserRoleEntity>
implements UserRoleDAO {
	
	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.DAO.UserRoleDAO#findAllUserRolesByUserID(int)
	 */
	@Override
	public List<UserRoleEntity> findAllUserRolesByUserID(int user_id){
		List<UserRoleEntity> userRoleEntities;
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from UserRoleEntity where user_id = :userID");
		query.setParameter("userID", user_id);
		userRoleEntities = findMany(query);
		return userRoleEntities;
	}
	
	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.DAO.UserRoleDAO#findAllUserRolesByRoleID(int)
	 */
	@Override
	public List<UserRoleEntity> findAllUserRolesByRoleID(int role_id){
		List<UserRoleEntity> userRoleEntities;
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from UserRoleEntity where role_id = :roleID");
		query.setParameter("roleID", role_id);
		userRoleEntities = findMany(query);
		return userRoleEntities;
	}
}

package cz.cvut.fit.genepi.DAOImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.UserRoleDAO;
import cz.cvut.fit.genepi.entity.UserRoleEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class UserRoleDAOImpl.
 */
@Repository
public class UserRoleDAOImpl  extends GenericDAOImpl<UserRoleEntity, Serializable>
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

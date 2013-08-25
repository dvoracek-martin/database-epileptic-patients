package cz.cvut.fit.genepi.DAOImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.UserRoleDAO;
import cz.cvut.fit.genepi.entity.UserRoleEntity;

@Repository
public class UserRoleDAOImpl  extends GenericDAOImpl<UserRoleEntity, Serializable>
implements UserRoleDAO {
	
	@Override
	public List<UserRoleEntity> findAllUserRolesByUserID(int user_id){
		List<UserRoleEntity> userRoleEntities;
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from UserRoleEntity where user_id = :userID");
		query.setParameter("userID", user_id);
		userRoleEntities = findMany(query);
		return userRoleEntities;
	}
}

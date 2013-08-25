package cz.cvut.fit.genepi.DAOImpl;

import java.io.Serializable;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.UserDAO;
import cz.cvut.fit.genepi.entity.UserEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDAOImpl.
 */
@Repository
public class UserDAOImpl extends GenericDAOImpl<UserEntity, Serializable>
		implements UserDAO {
	@Override
	public UserEntity findUserByUsername(String username){
		UserEntity userEntity;
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from UserEntity where username = :user_name");
		query.setParameter("user_name", username);
		userEntity = findOne(query);
		return userEntity;
	}
}

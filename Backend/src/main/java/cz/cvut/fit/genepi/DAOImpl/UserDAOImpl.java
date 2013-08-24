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

	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.DAO.UserDAO#findUserByID(java.lang.Integer)
	 */
	@Override
	public UserEntity findUserByID(Integer userID) {
		UserEntity userEntity;
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from UserEntity where id = :user_id");
		query.setParameter("user_id", userID);
		userEntity = findOne(query);
		return userEntity;
	}
}

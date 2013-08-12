package cz.cvut.fit.genepi.DAOImpl;

import java.io.Serializable;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.UserDAO;
import cz.cvut.fit.genepi.entity.UserEntity;

@Repository
public class UserDAOImpl extends GenericDAOImpl<UserEntity, Serializable>
		implements UserDAO {

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

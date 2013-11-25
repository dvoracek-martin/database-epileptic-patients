package cz.cvut.fit.genepi.dataLayer.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.dataLayer.DAO.UserDAO;
import cz.cvut.fit.genepi.dataLayer.entity.UserEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDAOImpl.
 */
@Repository
public class UserDAOImpl extends GenericDAOImpl<UserEntity>
		implements UserDAO {
	
	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.DAO.UserDAO#findUserByUsername(java.lang.String)
	 */
	@Override
	public UserEntity findUserByUsername(String username){
		UserEntity userEntity;
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from UserEntity where username = :user_name");
		query.setParameter("user_name", username);
		userEntity = findOne(query);
		return userEntity;
	}

	/* (non-Javadoc)
	 * @see cz.cvut.fit.genepi.DAO.UserDAO#getDoctors()
	 */
	@Override
	public List<UserEntity> getDoctors() {
		List<UserEntity> doctors = new ArrayList<UserEntity>();
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from UserEntity where username = :user_name");
		
		doctors=findMany(query);
		return doctors;
	}
}

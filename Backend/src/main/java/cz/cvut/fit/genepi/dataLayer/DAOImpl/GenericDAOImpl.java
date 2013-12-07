package cz.cvut.fit.genepi.dataLayer.DAOImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;


/***
 * Implements GenericDAO.
 *
 * @param <T> the generic type
 */
@Repository
public class GenericDAOImpl<T> implements
		GenericDAO<T> {

	/** The session factory. */
	@Autowired
	protected SessionFactory sessionFactory;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.cvut.fit.genepi.models.GenericDAO#save(java.lang.Object)
	 */
	public void save(T entity) {
		/* sessionFactory.getCurrentSession().beginTransaction(); */
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
		/*
		 * sessionFactory.getCurrentSession().getTransaction().commit();
		 * sessionFactory.getCurrentSession().disconnect();
		 */
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.cvut.fit.genepi.models.GenericDAO#merge(java.lang.Object)
	 */
	public void merge(T entity) {
		sessionFactory.getCurrentSession().merge(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.cvut.fit.genepi.models.GenericDAO#delete(java.lang.Object)
	 */
	public void delete(T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.cvut.fit.genepi.models.GenericDAO#findMany(org.hibernate.Query)
	 */
	@SuppressWarnings("unchecked")
	public List<T> findMany(Query query) {
		List<T> t;
		t = (List<T>) query.list();
		return t;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.cvut.fit.genepi.models.GenericDAO#findOne(org.hibernate.Query)
	 */
	@SuppressWarnings("unchecked")
	public T findOne(Query query) {
		T t;
		t = (T) query.uniqueResult();
		return t;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.cvut.fit.genepi.models.GenericDAO#findByID(java.lang.Class, int)
	 */
	@SuppressWarnings("unchecked")
	public T findByID(Class<T> myClass, int id) {
		T t = null;
		t = (T) sessionFactory.getCurrentSession().get(myClass, id);
		return t;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cz.cvut.fit.genepi.models.GenericDAO#findAll(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> myClass) {
		List<T> T = null;
		Query query = sessionFactory.getCurrentSession().createQuery(
				"from " + myClass.getName());
		T = query.list();
		return T;
	}
}
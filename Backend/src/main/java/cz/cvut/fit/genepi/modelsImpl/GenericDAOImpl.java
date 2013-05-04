package cz.cvut.fit.genepi.modelsImpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import cz.cvut.fit.genepi.models.GenericDAO;
import cz.cvut.fit.genepi.utils.HibernateUtil;

public abstract class GenericDAOImpl<T, ID extends Serializable> implements
		GenericDAO<T, ID> {

	protected Session getSession() {
		return (Session) HibernateUtil.getSessionFactory().openSession();
	}

	public void save(T entity) {
		Session hibernateSession = this.getSession();
		hibernateSession.beginTransaction();
		hibernateSession.saveOrUpdate(entity);
		hibernateSession.getTransaction().commit();
		hibernateSession.disconnect();
	}

	public void merge(T entity) {
		Session hibernateSession = this.getSession();
		hibernateSession.beginTransaction();
		hibernateSession.merge(entity);
		hibernateSession.getTransaction().commit();
		hibernateSession.disconnect();
	}

	public void delete(T entity) {
		Session hibernateSession = this.getSession();
		hibernateSession.beginTransaction();
		hibernateSession.delete(entity);
		hibernateSession.getTransaction().commit();
		hibernateSession.disconnect();
	}

	@SuppressWarnings("unchecked")
	public List<T> findMany(Query query) {
		List<T> t;
		t = (List<T>) query.list();
		return t;
	}

	@SuppressWarnings("unchecked")
	public T findOne(Query query) {
		T t;
		t = (T) query.uniqueResult();
		return t;
	}

	@SuppressWarnings("unchecked")
	public T findByID(Class<T> myClass, int id) {
		Session hibernateSession = this.getSession();
		T t = null;
		t = (T) hibernateSession.get(myClass, id);
		return t;
	}
	@SuppressWarnings("unchecked")
	public List<T> findAll(Class<T> myClass) {
		Session hibernateSession = this.getSession();
		List<T> T = null;
		Query query = hibernateSession.createQuery("from " + myClass.getName());
		T = query.list();
		return T;
	}
}
package cz.cvut.fit.genepi.models;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

public interface GenericDAO<T, ID extends Serializable> {

	public void save(T entity);

	public void merge(T entity);

	public void delete(T entity);

	public List<T> findMany(Query query);

	public T findOne(Query query);

	public List<T> findAll(Class<T> myClass);

	public T findByID(Class<T> myClass, int id);
}

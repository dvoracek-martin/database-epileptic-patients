package cz.cvut.fit.genepi.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

// TODO: Auto-generated Javadoc
/**
 * The Interface GenericService.
 *
 * @param <T> the generic type
 * @param <ID> the generic type
 */
public interface GenericService<T, ID extends Serializable> {
	
	/**
	 * Save.
	 * 
	 * @param entity
	 *            the entity
	 */
	public void save(T entity);

	/**
	 * Merge.
	 * 
	 * @param entity
	 *            the entity
	 */
	public void merge(T entity);

	/**
	 * Delete.
	 * 
	 * @param entity
	 *            the entity
	 */
	public void delete(T entity);

	/**
	 * Find many.
	 * 
	 * @param query
	 *            the query
	 * @return the list
	 */
	public List<T> findMany(Query query);

	/**
	 * Find one.
	 * 
	 * @param query
	 *            the query
	 * @return the t
	 */
	public T findOne(Query query);

	/**
	 * Find all.
	 * 
	 * @param myClass
	 *            the my class
	 * @return the list
	 */
	public List<T> findAll(Class<T> myClass);

	/**
	 * Find by id.
	 * 
	 * @param myClass
	 *            the my class
	 * @param id
	 *            the id
	 * @return the t
	 */
	public T findByID(Class<T> myClass, int id);
}

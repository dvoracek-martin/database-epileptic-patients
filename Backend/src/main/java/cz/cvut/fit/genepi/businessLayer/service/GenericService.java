package cz.cvut.fit.genepi.businessLayer.service;

import org.hibernate.Query;

import java.util.List;

/**
 * The Interface GenericService.
 *
 * @param <T>  the generic type
 * @param <ID> the generic type
 */
public interface GenericService<T> {

    /**
     * Save.
     *
     * @param entity the entity
     */
    public void save(T entity);

    /**
     * Merge.
     *
     * @param entity the entity
     */
    public void merge(T entity);

    /**
     * Delete.
     *
     * @param entity the entity
     */
    public void delete(T entity);

    /**
     * Find many.
     *
     * @param query the query
     * @return the list
     */
    public List<T> findMany(Query query);

    /**
     * Find one.
     *
     * @param query the query
     * @return the t
     */
    public T findOne(Query query);

    /**
     * Find all.
     *
     * @param myClass the my class
     * @return the list
     */
    public List<T> findAll(Class<T> myClass);

    /**
     * The same as findAll(Class<T> myClass), but this method can paginate the
     * results
     *
     * @param myClass the my class
     * @return the list
     */
    public List<T> findAllWithPagination(Class<T> myClass, int maxResults,
                                         int pageNumber);

    /**
     * Find by id.
     *
     * @param myClass the my class
     * @param id      the id
     * @return the t
     */
    public T findByID(Class<T> myClass, int id);

    /**
     * Get count.
     *
     * @param myClass the my class
     * @return int
     */

    public int getCount(Class<T> myClass);

    /**
     * Get count of unhidden
     *
     * @param myClass the my class
     * @return int
     */
    public int getCountOfUnhidden(Class<T> myClass, String searchString);

    /**
     * Get list according to string pattern - for quick search
     *
     * @param myClass the my class
     * @return List<T>
     */
    public List<T> findByNameWithPagination(Class<T> myClass, int maxResults,
                                            int pageNumber, List<String> parameters, String name);
}

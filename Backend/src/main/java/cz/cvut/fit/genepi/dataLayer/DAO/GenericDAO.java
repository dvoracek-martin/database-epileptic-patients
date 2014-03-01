package cz.cvut.fit.genepi.dataLayer.DAO;

import org.hibernate.Query;

import java.util.List;

// TODO: Auto-generated Javadoc

/**
 * The Interface GenericDAO.
 *
 * @param <T>  the generic type
 */
public interface GenericDAO<T> {

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
     * get count
     *
     * @param myClass the my class
     * @return int
     */
    public int getCount(Class<T> myClass);

    /**
     * get count of unhidden
     *
     * @param myClass the my class
     * @return int
     */
    public int getCountOfUnhidden(Class<T> myClass, String searchString);

    /**
     * Find all.
     *
     * @param myClass the my class
     * @return the list
     */
    public List<T> findAll(Class<T> myClass);

    /**
     * Find by id.
     *
     * @param myClass the my class
     * @param id      the id
     * @return the t
     */
    public T findByID(Class<T> myClass, int id);

    /**
     * The same as findAll(Class<T> myClass), but this method can paginate the
     * results
     *
     * @param myClass the my class
     * @return the list
     */
    public List<T> findAllWithPagination(Class<T> myClass, int maxResults,
                                         int pageNumber);

    public List<T> findByNameWithPagination(Class<T> myClass, int maxResults,
                                            int pageNumber, List<String> parameters, String name);
}

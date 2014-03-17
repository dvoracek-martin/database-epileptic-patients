package cz.cvut.fit.genepi.dataLayer.DAO;

import java.util.List;

/**
 * The Interface GenericDAO.
 *
 * @param <Entity> the generic type
 */
public interface GenericDAO<Entity> {

    /**
     * Save.
     *
     * @param entity the entity
     */
    public int save(Entity entity);

    public Entity getById(int id, Class<Entity> entityClass);

    /**
     * update.
     *
     * @param entity the entity
     */
    public void update(Entity entity);

    /**
     * Delete.
     *
     * @param entity the entity
     */
    public void delete(Entity entity);

    /**
     * Find all.
     *
     * @param myClass the my class
     * @return the list
     */
    public List<Entity> findAll(Class<Entity> myClass);

    /**
     * Find by id.
     *
     * @param myClass the my class
     * @param id      the id
     * @return the t
     */
    public Entity findByID(Class<Entity> myClass, int id);

    /**
     * The same as findAll(Class<Entity> myClass), but this method can paginate the
     * results
     *
     * @param myClass the my class
     * @return the list
     */
    public List<Entity> findAllWithPagination(Class<Entity> myClass, int maxResults,
                                              int pageNumber);

}
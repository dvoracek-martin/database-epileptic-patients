package cz.cvut.fit.genepi.dataLayer.DAOImpl;

import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implements GenericDAO.
 *
 * @param <Entity> the generic type
 */
@Repository
public class GenericDAOImpl<Entity> implements GenericDAO<Entity> {

    /**
     * The session factory.
     */
    @Autowired
    protected SessionFactory sessionFactory;

    public int save(Entity entity) {

        return (int) sessionFactory.getCurrentSession().save(entity);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public Entity getById(int id, Class<Entity> entityCass) {
        return (Entity) sessionFactory.getCurrentSession().get(entityCass, id);
    }

    public void update(Entity entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    public void delete(Entity entity) {

        sessionFactory.getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<Entity> findAll(Class<Entity> myClass) {

        Query query = sessionFactory
                .getCurrentSession()
                .createQuery("from " + myClass.getName());

        return (List<Entity>) query.list();
    }

    public int getCount(Class<Entity> myClass) {

        Long count = ((Long) sessionFactory
                .getCurrentSession()
                .createQuery("select count(*) from " + myClass.getName() + " WHERE status = 0")
                .uniqueResult());

        return count.intValue();
    }

    @SuppressWarnings("unchecked")
    public Entity findByID(Class<Entity> myClass, int id) {

        return (Entity) sessionFactory
                .getCurrentSession()
                .get(myClass, id);
    }


    /*
     * (non-Javadoc)
     *
     * @see
     * cz.cvut.fit.genepi.models.GenericDAO#findAllWithPagination(java.lang.
     * Class)
     */
    @SuppressWarnings("unchecked")
    public List<Entity> findAllWithPagination(Class<Entity> myClass, int maxResults, int pageNumber) {

        Query query = sessionFactory
                .getCurrentSession()
                .createQuery("from " + myClass.getName() +
                        " WHERE status = 0 ORDER BY contact.lastName, contact.firstName")
                .setFirstResult(maxResults * (pageNumber - 1))
                .setMaxResults(maxResults);

        return (List<Entity>) query.list();
    }
}
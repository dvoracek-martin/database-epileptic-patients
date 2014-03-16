package cz.cvut.fit.genepi.dataLayer.DAOImpl;

import cz.cvut.fit.genepi.dataLayer.DAO.GenericDAO;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    /*
     * (non-Javadoc)
     *
     * @see
     * cz.cvut.fit.genepi.models.GenericDAO#getCountOfUnhidden(java.lang.Class)
     */
    public int getCountOfUnhidden(Class<Entity> myClass, String searchString) {

        Long count = ((Long) sessionFactory
                .getCurrentSession()
                .createQuery("select count(id) " +
                        "from " + myClass.getName() +
                        " where status=0 AND (contact.firstName like '" + searchString + "%'" +
                        " OR contact.lastName like '" + searchString + "%'" +
                        " OR nin like '" + searchString + "%')")
                .uniqueResult());

        return count.intValue();
    }

    /*
     * (non-Javadoc)
     *
     * @see cz.cvut.fit.genepi.models.GenericDAO#findByID(java.lang.Class, int)
     */
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

    @SuppressWarnings("unchecked")
    public List<Entity> findByNameWithPagination(Class<Entity> myClass, int maxResults,
                                                 int pageNumber, List<String> parameters, String name) {

        String q = "from " + myClass.getName() + " where status=0 AND (";
        for (int i = 0; i != parameters.size(); i++) {
            q += parameters.get(i) + " like '" + name + "%'";
            if (i != parameters.size() - 1) {
                q += " or ";
            }
        }
        q += ") ORDER BY contact.lastName,contact.firstName";

        Query query = sessionFactory
                .getCurrentSession()
                .createQuery(q)
                .setFirstResult(maxResults * (pageNumber - 1))
                .setMaxResults(maxResults);

        return (List<Entity>) query.list();
    }
}

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
 * @param <T> the generic type
 */
@Repository
public class GenericDAOImpl<T> implements GenericDAO<T> {

    /**
     * The session factory.
     */
    @Autowired
    protected SessionFactory sessionFactory;

    /*
     * (non-Javadoc)
     *
     * @see cz.cvut.fit.genepi.models.GenericDAO#save(java.lang.Object)
     */
    public void save(T entity) {

        sessionFactory.getCurrentSession().saveOrUpdate(entity);
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

        return (List<T>) query.list();
    }

    /*
     * (non-Javadoc)
     *
     * @see cz.cvut.fit.genepi.models.GenericDAO#findOne(org.hibernate.Query)
     */
    @SuppressWarnings("unchecked")
    public T findOne(Query query) {

        return (T) query.uniqueResult();
    }

    /*
     * (non-Javadoc)
     *
     * @see cz.cvut.fit.genepi.models.GenericDAO#getCount(java.lang.Class)
     */
    public int getCount(Class<T> myClass) {

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
    public int getCountOfUnhidden(Class<T> myClass, String searchString) {

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
    public T findByID(Class<T> myClass, int id) {

        return (T) sessionFactory
                .getCurrentSession()
                .get(myClass, id);
    }

    /*
     * (non-Javadoc)
     *
     * @see cz.cvut.fit.genepi.models.GenericDAO#findAll(java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    public List<T> findAll(Class<T> myClass) {

        Query query = sessionFactory
                .getCurrentSession()
                .createQuery("from " + myClass.getName());

        return (List<T>) query.list();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * cz.cvut.fit.genepi.models.GenericDAO#findAllWithPagination(java.lang.
     * Class)
     */
    @SuppressWarnings("unchecked")
    public List<T> findAllWithPagination(Class<T> myClass, int maxResults, int pageNumber) {

        Query query = sessionFactory
                .getCurrentSession()
                .createQuery("from " + myClass.getName() +
                        " WHERE status = 0 ORDER BY contact.lastName, contact.firstName")
                .setFirstResult(maxResults * (pageNumber - 1))
                .setMaxResults(maxResults);

        return (List<T>) query.list();
    }

    @SuppressWarnings("unchecked")
    public List<T> findByNameWithPagination(Class<T> myClass, int maxResults,
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

        return (List<T>) query.list();
    }
}
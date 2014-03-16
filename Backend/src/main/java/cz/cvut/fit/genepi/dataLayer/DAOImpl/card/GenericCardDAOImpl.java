package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import cz.cvut.fit.genepi.dataLayer.DAO.card.GenericCardDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenericCardDAOImpl<CardEntity>
        extends GenericDAOImpl<CardEntity>
        implements GenericCardDAO<CardEntity> {

    public void hide(int id, Class<CardEntity> entityClass) {
        Query query = sessionFactory
                .getCurrentSession()
                .createQuery("UPDATE " + entityClass.getName() + " SET hidden = 1 WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void unhide(int id, Class<CardEntity> entityClass) {
        Query query = sessionFactory
                .getCurrentSession()
                .createQuery("UPDATE " + entityClass.getName() + " SET hidden = 0 WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void makeHistory(int id, Class<CardEntity> entityClass) {
        Query query = sessionFactory
                .getCurrentSession()
                .createQuery("UPDATE " + entityClass.getName() + " SET history = 1 WHERE id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CardEntity> getRecordsByPatientId(int patientId, Class<CardEntity> entityClass) {
        Criteria criteria = sessionFactory
                .getCurrentSession()
                .createCriteria(entityClass)
                .add(Restrictions.eq("patientId", patientId))
                .add(Restrictions.eq("hidden", false))
                .add(Restrictions.eq("history", false))
                .addOrder(Order.desc("date"))
                .addOrder(Order.desc("id"));

        return (List<CardEntity>) criteria.list();
    }
}

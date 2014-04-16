package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import cz.cvut.fit.genepi.dataLayer.DAO.card.OperationDAO;
import cz.cvut.fit.genepi.dataLayer.entity.card.OperationEntity;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Implementation of OperationDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class OperationDAOImpl implements OperationDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<OperationEntity> getOperationWithOutcomeList(int patientId) {

        Criteria criteria = sessionFactory
                .getCurrentSession()
                .createCriteria(OperationEntity.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .add(Restrictions.eq("patientId", patientId))
                .add(Restrictions.eq("hidden", false))
                .add(Restrictions.eq("history", false))
                .addOrder(Order.desc("date"))
                .addOrder(Order.desc("id"))
                .createCriteria("outcomeList", JoinType.LEFT_OUTER_JOIN);

        return (List<OperationEntity>) criteria.list();
    }
}

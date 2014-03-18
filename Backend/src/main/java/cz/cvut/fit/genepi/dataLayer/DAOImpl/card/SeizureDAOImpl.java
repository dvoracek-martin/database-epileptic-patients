package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import cz.cvut.fit.genepi.dataLayer.DAO.card.SeizureDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/*
 * Implementation of SeizureDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class SeizureDAOImpl extends GenericDAOImpl<SeizureEntity>
        implements SeizureDAO {

    /* (non-Javadoc)
     * @see cz.cvut.fit.genepi.DAO.SeizureDAO#findAnamnesisByPatientID(int)
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<SeizureEntity> findAnamnesisByPatientID(int patientId) {
        List<SeizureEntity> seizureEntities = new ArrayList<SeizureEntity>();
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from SeizureEntity where patientId = :patient_id");
        query.setParameter("patient_id", patientId);
        seizureEntities = (List<SeizureEntity>) query.list();

        return seizureEntities;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<SeizureEntity> getRecordsByPatientId(int patientId) {
      /*  Criteria criteria = sessionFactory
                .getCurrentSession()
                .createCriteria(SeizureEntity.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                .add(Restrictions.eq("patientId", patientId))
                .add(Restrictions.eq("hidden", false))
                .add(Restrictions.eq("history", false))
                .addOrder(Order.desc("date"))
                .addOrder(Order.desc("id"))
                .createCriteria("seizureDetailList")
                .addOrder(Order.desc("date"));

        return (List<SeizureEntity>) criteria.list();
        */
        Query query = sessionFactory
                .getCurrentSession().createQuery("select distinct se from SeizureEntity se left join fetch se.seizureDetailList sd where se.patientId = :patientId order by se.date, se.id, sd.date");
        query.setParameter("patientId",patientId);

        return (List<SeizureEntity>) query.list();
    }
}
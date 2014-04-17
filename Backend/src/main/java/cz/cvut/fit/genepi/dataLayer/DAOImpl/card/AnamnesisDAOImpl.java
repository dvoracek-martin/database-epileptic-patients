package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import cz.cvut.fit.genepi.dataLayer.DAO.card.AnamnesisDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.AnamnesisEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Implementation of AnamnesisFindingDAO Extending implementation of GenericDAO
 */
@Repository
public class AnamnesisDAOImpl
        extends GenericDAOImpl<AnamnesisEntity>
        implements AnamnesisDAO {

    @Override
    public AnamnesisEntity getRecordsByPatientId(int patientId) {
        Criteria criteria = sessionFactory
                .getCurrentSession()
                .createCriteria(AnamnesisEntity.class)
                .add(Restrictions.eq("patientId", patientId))
                .add(Restrictions.eq("history", false));

        return (AnamnesisEntity) criteria.uniqueResult();
    }
}

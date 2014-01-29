package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import cz.cvut.fit.genepi.dataLayer.DAO.card.SeizureDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureEntity;
import org.hibernate.Query;
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
    public List<SeizureEntity> findAnamnesisByPatientID(int patientId) {
        List<SeizureEntity> seizureEntities = new ArrayList<SeizureEntity>();
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from SeizureEntity where patientId = :patient_id");
        query.setParameter("patient_id", patientId);
        seizureEntities = findMany(query);

        return seizureEntities;
    }

}

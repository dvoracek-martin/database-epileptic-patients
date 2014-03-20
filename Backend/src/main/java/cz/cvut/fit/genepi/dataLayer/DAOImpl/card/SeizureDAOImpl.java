package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import cz.cvut.fit.genepi.dataLayer.DAO.card.SeizureDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.SeizureEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
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


}
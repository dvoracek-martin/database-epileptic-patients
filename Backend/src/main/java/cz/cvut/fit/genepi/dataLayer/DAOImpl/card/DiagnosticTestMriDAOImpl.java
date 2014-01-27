package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestMriEntity;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.dataLayer.DAO.card.DiagnosticTestMriDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;

/**
 * Implementation of DiagnosticTestMriDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class DiagnosticTestMriDAOImpl extends
		GenericDAOImpl<DiagnosticTestMriEntity> implements DiagnosticTestMriDAO {

}

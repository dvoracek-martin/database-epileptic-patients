package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestMriEntity;
import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.dataLayer.DAO.card.DiagnosticTestMRIDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;

/**
 * Implementation of DiagnosticTestMRIDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class DiagnosticTestMRIDAOImpl extends
		GenericDAOImpl<DiagnosticTestMriEntity> implements DiagnosticTestMRIDAO {

}

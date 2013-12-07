package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.dataLayer.DAO.card.DiagnosticTestMRIDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestMRIEntity;

/**
 * Implementation of DiagnosticTestMRIDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class DiagnosticTestMRIDAOImpl extends
		GenericDAOImpl<DiagnosticTestMRIEntity> implements DiagnosticTestMRIDAO {

}

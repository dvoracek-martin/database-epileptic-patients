package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.dataLayer.DAO.card.DiagnosticTestScalpEEGDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestScalpEegEntity;

/**
 * Implementation of DiagnosticTestScalpEEGDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class DiagnosticTestScalpEEGDAOImpl extends
		GenericDAOImpl<DiagnosticTestScalpEegEntity> implements
		DiagnosticTestScalpEEGDAO {

}

package cz.cvut.fit.genepi.dataLayer.DAOImpl.card;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.dataLayer.DAO.card.DiagnosticTestScalpEegDAO;
import cz.cvut.fit.genepi.dataLayer.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.dataLayer.entity.card.DiagnosticTestScalpEegEntity;

/**
 * Implementation of DiagnosticTestScalpEegDAO
 * Extending implementation of GenericDAO
 */
@Repository
public class DiagnosticTestScalpEegDAOImpl extends
		GenericDAOImpl<DiagnosticTestScalpEegEntity> implements
        DiagnosticTestScalpEegDAO {

}

package cz.cvut.fit.genepi.DAOImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.card.DiagnosticTestScalpEEGDAO;
import cz.cvut.fit.genepi.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.entity.card.DiagnosticTestScalpEEGEntity;


@Repository
public class DiagnosticTestScalpEEGDAOImpl extends
		GenericDAOImpl<DiagnosticTestScalpEEGEntity, Serializable> implements
		DiagnosticTestScalpEEGDAO {

}

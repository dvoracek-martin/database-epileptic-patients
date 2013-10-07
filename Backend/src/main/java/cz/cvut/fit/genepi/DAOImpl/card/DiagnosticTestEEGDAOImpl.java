package cz.cvut.fit.genepi.DAOImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.card.DiagnosticTestEEGDAO;
import cz.cvut.fit.genepi.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.entity.card.DiagnosticTestEEGEntity;


@Repository
public class DiagnosticTestEEGDAOImpl extends
		GenericDAOImpl<DiagnosticTestEEGEntity, Serializable> implements
		DiagnosticTestEEGDAO {

}

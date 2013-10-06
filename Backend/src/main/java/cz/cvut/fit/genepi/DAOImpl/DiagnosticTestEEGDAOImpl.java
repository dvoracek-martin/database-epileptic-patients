package cz.cvut.fit.genepi.DAOImpl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.DiagnosticTestEEGDAO;
import cz.cvut.fit.genepi.entity.DiagnosticTestEEGEntity;


@Repository
public class DiagnosticTestEEGDAOImpl extends
		GenericDAOImpl<DiagnosticTestEEGEntity, Serializable> implements
		DiagnosticTestEEGDAO {

}

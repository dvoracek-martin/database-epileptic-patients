package cz.cvut.fit.genepi.DAOImpl;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.DiagnosticTestMRIDAO;
import cz.cvut.fit.genepi.entity.DiagnosticTestMRIEntity;

@Repository
public class DiagnostiCestMRIDAOImpl  extends
GenericDAOImpl<DiagnosticTestMRIEntity, Serializable> implements
DiagnosticTestMRIDAO  {

}

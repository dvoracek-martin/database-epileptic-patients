package cz.cvut.fit.genepi.DAOImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.card.DiagnosticTestMRIDAO;
import cz.cvut.fit.genepi.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.entity.card.DiagnosticTestMRIEntity;

@Repository
public class DiagnostiCestMRIDAOImpl  extends
GenericDAOImpl<DiagnosticTestMRIEntity, Serializable> implements
DiagnosticTestMRIDAO  {

}
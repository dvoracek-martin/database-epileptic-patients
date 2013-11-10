package cz.cvut.fit.genepi.DAOImpl.card;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import cz.cvut.fit.genepi.DAO.card.InvasiveTestCorticalMappingDAO;
import cz.cvut.fit.genepi.DAOImpl.GenericDAOImpl;
import cz.cvut.fit.genepi.entity.card.InvasiveTestCorticalMappingEntity;

@Repository
public class InvasiveTestCorticalMappingDAOImpl extends
		GenericDAOImpl<InvasiveTestCorticalMappingEntity, Serializable>
		implements InvasiveTestCorticalMappingDAO {

}

package cz.cvut.fit.genepi.DAO;

import java.io.Serializable;
import java.util.List;

import cz.cvut.fit.genepi.entity.SeizureEntity;

public interface SeizureDAO extends GenericDAO<SeizureEntity, Serializable> {

	List<SeizureEntity> findAnamnesisByPatientID(int patientId);

}

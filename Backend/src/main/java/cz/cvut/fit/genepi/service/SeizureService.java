package cz.cvut.fit.genepi.service;

import java.util.List;

import cz.cvut.fit.genepi.entity.SeizureEntity;

public interface SeizureService {
	public List<SeizureEntity> findSeizureByPatientID(int patientId);
}

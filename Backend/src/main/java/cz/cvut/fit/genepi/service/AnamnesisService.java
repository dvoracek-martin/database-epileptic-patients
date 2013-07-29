package cz.cvut.fit.genepi.service;

import java.util.List;

import cz.cvut.fit.genepi.entity.AnamnesisEntity;

public interface AnamnesisService {
	public List<AnamnesisEntity> findAnamnesisByPatientID(int patientId);
}

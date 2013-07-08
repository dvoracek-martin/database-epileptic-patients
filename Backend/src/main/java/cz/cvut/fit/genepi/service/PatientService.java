package cz.cvut.fit.genepi.service;

import java.util.List;

import cz.cvut.fit.genepi.entity.PatientEntity;

public interface PatientService {
	public List<PatientEntity> findAll();

	public void save(PatientEntity patient);
}

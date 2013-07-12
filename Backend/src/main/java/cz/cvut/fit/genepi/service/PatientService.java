package cz.cvut.fit.genepi.service;

import java.util.List;

import cz.cvut.fit.genepi.entity.PatientEntity;

public interface PatientService {

	public void save(PatientEntity patient);

	public PatientEntity findByID(int id);

	public List<PatientEntity> findAll();
}

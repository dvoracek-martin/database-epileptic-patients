package cz.cvut.fit.genepi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.cvut.fit.genepi.DAO.PatientDAO;
import cz.cvut.fit.genepi.entity.PatientEntity;
import cz.cvut.fit.genepi.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientDAO patientDAO;

	@Override
	@Transactional
	public void save(PatientEntity patient) {
		patientDAO.save(patient);
	}

	@Override
	@Transactional
	public PatientEntity findByID(int id) {
		return (patientDAO.findByID(PatientEntity.class, id));
	}

	@Override
	@Transactional
	public List<PatientEntity> findAll() {
		return patientDAO.findAll(PatientEntity.class);
	}

	@Override
	@Transactional
	public PatientEntity findPatientByID(Integer patientID) {
		return patientDAO.findPatientByID(patientID);
	}
}

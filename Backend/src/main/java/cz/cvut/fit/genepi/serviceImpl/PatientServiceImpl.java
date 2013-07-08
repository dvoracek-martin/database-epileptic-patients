package cz.cvut.fit.genepi.serviceImpl;

import java.util.Date;
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

	/** The patient. */
	PatientEntity patient;

	@Transactional
	public PatientEntity createPatient(String nin, Date birthday,
			String gender, int doctorId, int deleted, int checked,
			int contactId, int commentId) {
		patient = new PatientEntity();
		patient.setNin(nin);
		patient.setBirthday(birthday);
		patient.setGender(gender);
		patient.setDoctorId(doctorId);
		patient.setDeleted(deleted);
		patient.setChecked(checked);
		patient.setContactId(contactId);
		patient.setCommentId(commentId);
		return patient;
	}

	@Transactional
	public void createPatient(PatientEntity patient) {
		this.patient = patient;
	}

	@Transactional
	public void save(PatientEntity patient) {
		patientDAO.save(patient);
	}

	@Transactional
	public PatientEntity findByID(int id) {
		return (patientDAO.findByID(PatientEntity.class, id));
	}

	@Transactional
	public List<PatientEntity> findAll() {
		return patientDAO.findAll(PatientEntity.class);
	}
}

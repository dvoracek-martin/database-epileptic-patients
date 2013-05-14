package cz.cvut.fit.genepi.managers;

import java.util.Date;
import java.util.List;

import cz.cvut.fit.genepi.entities.PatientEntity;
import cz.cvut.fit.genepi.modelsImpl.PatientDAOImpl;

public class PatientManagers extends PatientDAOImpl {

	PatientEntity patient;

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

	public void save() {
		this.save(patient);
	}

	public PatientEntity findByID(int i) {
		return (this.findByID(PatientEntity.class, i));
	}

	public List<PatientEntity> findAll() {
		return this.findAll(PatientEntity.class);
	}
}

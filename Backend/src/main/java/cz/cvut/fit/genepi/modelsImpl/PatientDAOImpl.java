package cz.cvut.fit.genepi.modelsImpl;

import java.io.Serializable;
import java.util.Date;

import cz.cvut.fit.genepi.models.PatientDAO;

public class PatientDAOImpl extends GenericDAOImpl<PatientDAO, Serializable>{

	public PatientDAO patient;

	public PatientDAOImpl() {
		patient = new PatientDAO();
	}

	public void createPatient(int id, long nin, Date birthday, String gender,
			int doctorId, int deleted, int checked, int contactId, int commentId) {
	
		patient.setId(id);
		patient.setNin(nin);
		patient.setBirthday(birthday);
		patient.setGender(gender);
		patient.setDoctorId(doctorId);
		patient.setDeleted(deleted);
		patient.setChecked(checked);
		patient.setContactId(contactId);
		patient.setCommentId(commentId);
	}

	public void createUser(PatientDAO patient) {
		this.patient = patient;
	}
}
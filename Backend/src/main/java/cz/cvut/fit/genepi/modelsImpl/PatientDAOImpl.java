package cz.cvut.fit.genepi.modelsImpl;

import java.io.Serializable;
import java.util.Date;

import cz.cvut.fit.genepi.models.PatientDAO;

public class PatientDAOImpl extends GenericDAOImpl<PatientDAO, Serializable> {

	public PatientDAO patient;

	public PatientDAOImpl() {
		patient = new PatientDAO();
	}

	public void createPatient(int id, long nin, Date birthday, int doctor_id,
			byte deleted, byte contact_id, byte comment_id) {
		patient.setId(id);
		patient.set_nin(nin);
		patient.set_birthday(birthday);
		patient.set_doctor_id(doctor_id);
		patient.set_contact_id(contact_id);
		patient.set_comment_id(comment_id);
	}

	public void createUser(PatientDAO patient) {
		this.patient = patient;
	}
}
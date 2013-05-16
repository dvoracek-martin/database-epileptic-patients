package cz.cvut.fit.genepi.managers;

import java.util.Date;
import java.util.List;

import cz.cvut.fit.genepi.entities.AnamnesisEntity;
import cz.cvut.fit.genepi.entities.PatientEntity;
import cz.cvut.fit.genepi.modelsImpl.PatientDAOImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientManager.
 */
public class PatientManager extends PatientDAOImpl {

	/** The patient. */
	PatientEntity patient;

	/**
	 * Creates the patient.
	 *
	 * @param nin the nin
	 * @param birthday the birthday
	 * @param gender the gender
	 * @param doctorId the doctor id
	 * @param deleted the deleted
	 * @param checked the checked
	 * @param contactId the contact id
	 * @param commentId the comment id
	 * @return the patient entity
	 */
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
	
	public void createPatient(PatientEntity patient) {
		this.patient = patient;
	}
	

	/**
	 * Save.
	 */
	public void save() {
		this.save(patient);
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the patient entity
	 */
	public PatientEntity findByID(int id) {
		return (this.findByID(PatientEntity.class, id));
	}

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<PatientEntity> findAll() {
		return this.findAll(PatientEntity.class);
	}
		
}

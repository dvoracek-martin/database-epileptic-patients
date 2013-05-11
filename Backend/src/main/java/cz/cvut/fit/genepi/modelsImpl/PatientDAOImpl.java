package cz.cvut.fit.genepi.modelsImpl;

import java.io.Serializable;
import java.util.Date;

import cz.cvut.fit.genepi.models.PatientDAO;

public class PatientDAOImpl extends GenericDAOImpl<PatientDAOImpl, Serializable>
		implements PatientDAO {

	public PatientDAOImpl() {
	}

	public void createPatient(String nin, Date birthday, String gender,
			int doctorId, int deleted, int checked, int contactId, int commentId) {
		this.setNin(nin);
		this.setBirthday(birthday);
		this.setGender(gender);
		this.setDoctorId(doctorId);
		this.setDeleted(deleted);
		this.setChecked(checked);
		this.setContactId(contactId);
		this.setCommentId(commentId);
	}

	private int id;
	private String nin;
	private Date birthday;
	private String gender;
	private int doctorId;
	private int deleted;
	private int checked;
	private int contactId;
	private int commentId;

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getNin() {
		return nin;
	}

	@Override
	public void setNin(String nin) {
		this.nin = nin;
	}

	@Override
	public Date getBirthday() {
		return birthday;
	}

	@Override
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String getGender() {
		return gender;
	}

	@Override
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int getDoctorId() {
		return doctorId;
	}

	@Override
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	@Override
	public int getDeleted() {
		return deleted;
	}

	@Override
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	@Override
	public int getChecked() {
		return checked;
	}

	@Override
	public void setChecked(int checked) {
		this.checked = checked;
	}

	@Override
	public int getContactId() {
		return contactId;
	}

	@Override
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	@Override
	public int getCommentId() {
		return commentId;
	}

	@Override
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
}
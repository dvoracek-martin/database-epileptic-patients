package cz.cvut.fit.genepi.modelsImpl;

import java.io.Serializable;
import java.util.Date;

import cz.cvut.fit.genepi.models.PatientDAO;
import cz.cvut.fit.genepi.entities.PatientEntity;

public class PatientDAOImpl extends GenericDAOImpl</*PatientDAOImpl*/PatientEntity, Serializable>
		implements PatientDAO {

	public PatientDAOImpl() {
	}

	/*
	 * Tato metoda bude v tom PatientManager. musi naplnit PatientEntity a ta se pak akorat preda PatientDAOImpl.save(PatientEntity);
	 * a vypadala by asi nejak jako 
	 * 
	 * nova metoda
	 *  public void createPatient(String nin, Date birthday, String gender,
			int doctorId, int deleted, int checked, int contactId, int commentId) {
			PatinetEntity mmm = new ...;
		this.setNin(nin);
		this.setBirthday(birthday);
		this.setGender(gender);
		this.setDoctorId(doctorId);
		this.setDeleted(deleted);
		this.setChecked(checked);
		this.setContactId(contactId);
		this.setCommentId(commentId);
		
		this.InstancePatinetDAO.save(mmm); //jak jsi mluvil o tom HIBERNATE mapovani.
		tak na DB tabulku by !ASI! mela byt namapovana ta ENTITA a ne DAO. aby se tam mohla pomoci toho SAVE ukladat. Prave jak je ted namapovany to DAO,
		tak slouzi jako entita a to neni dobry.
	}
	 * puvodni metoda
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
	}*/

	/*
	 * toto patri entite
	 * 
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
	}*/
}
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

	
}
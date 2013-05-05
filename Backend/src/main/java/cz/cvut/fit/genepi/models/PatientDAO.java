package cz.cvut.fit.genepi.models;

import java.util.Date;

public class PatientDAO implements java.io.Serializable {

	/**
	 * generated serialVersionUID
	 */
	private static final long serialVersionUID = -8172690860460945951L;
	
	

	private int _id;
	private long _nin;
	private Date _birthday;
	private int _doctor_id;
	private byte _deleted;
	private byte _contact_id;
	private byte _comment_id;

	public PatientDAO() {
	}

	public PatientDAO(int id, long nin, Date birthday, int doctor_id, byte deleted, byte contact_id, byte comment_id) {
		this._id = id;
		this._nin = nin;
		this._birthday = birthday;
		this._doctor_id = doctor_id;
		this._deleted=deleted;
		this._contact_id=contact_id;
		this._comment_id=comment_id;
	}

	public int getId() {
		return this._id;
	}

	public void setId(int id) {
		this._id = id;
	}

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public long get_nin() {
		return _nin;
	}

	public void set_nin(long _nin) {
		this._nin = _nin;
	}

	public Date get_birthday() {
		return _birthday;
	}

	public void set_birthday(Date _birthday) {
		this._birthday = _birthday;
	}

	public int get_doctor_id() {
		return _doctor_id;
	}

	public void set_doctor_id(int _doctor_id) {
		this._doctor_id = _doctor_id;
	}

	public byte get_deleted() {
		return _deleted;
	}

	public void set_deleted(byte _deleted) {
		this._deleted = _deleted;
	}

	public byte get_contact_id() {
		return _contact_id;
	}

	public void set_contact_id(byte _contact_id) {
		this._contact_id = _contact_id;
	}

	public byte get_comment_id() {
		return _comment_id;
	}

	public void set_comment_id(byte _comment_id) {
		this._comment_id = _comment_id;
	}
}
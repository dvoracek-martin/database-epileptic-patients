package cz.cvut.fit.genepi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

// TODO: Auto-generated Javadoc
/**
 * The Class PatientEntity.
 */
@Entity
@Table(name = "PATIENT")
public class PatientEntity {

	/** The id. */
	@Id
	@Column(name = "ID", precision = 6, scale = 0, nullable = false)
	@GeneratedValue
	private int id;

	/** The nin. */
	@Pattern(regexp="[0-9]*")
	@Size(max=10)
	@Column(name = "NIN", length = 10, nullable = true)
	private String nin;

	/** The birthday. */
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past
	@NotNull
	@Column(name = "BIRTHDAY", nullable = false)
	private Date birthday;

	/** The gender. */
	@NotBlank
	@NotNull
	@Size(max=10)
	@Column(name = "GENDER", length = 10, nullable = false)
	private String gender;

	/** The doctor id. */
	@Size(max=6)
	@Column(name = "DOCTOR_ID", precision = 6, scale = 0, nullable = true)
	private int doctorId;

	/** The deleted. */
	@Column(name = "DELETED", precision = 1, scale = 0, nullable = true)
	private Boolean deleted;

	/** The checked. */
	@Column(name = "CHECKED", precision = 1, scale = 0, nullable = true)
	private Boolean checked;

	/** The contact id. */
	@Size(max=6)
	@Column(name = "CONTACT_ID", precision = 6, scale = 0, nullable = true, insertable = false, updatable = false)
	private int contactId;

	/** The comment id. */
	/*@Column(name = "COMMENT_ID", precision = 6, scale = 0, nullable = true)
	private int commentId;*/

	
	/** The contact. */
	@Valid
	@OneToOne
	@Cascade({ CascadeType.SAVE_UPDATE })
	private ContactEntity contact;

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the nin.
	 * 
	 * @return the nin
	 */
	public String getNin() {
		return nin;
	}

	/**
	 * Sets the nin.
	 * 
	 * @param nin
	 *            the new nin
	 */
	public void setNin(String nin) {
		this.nin = nin;
	}

	/**
	 * Gets the birthday.
	 * 
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * Sets the birthday.
	 * 
	 * @param birthday
	 *            the new birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * Gets the gender.
	 * 
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 * 
	 * @param gender
	 *            the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the doctor id.
	 * 
	 * @return the doctor id
	 */
	public int getDoctorId() {
		return doctorId;
	}

	/**
	 * Sets the doctor id.
	 * 
	 * @param doctorId
	 *            the new doctor id
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	/**
	 * Gets the deleted.
	 * 
	 * @return the deleted
	 */
	public Boolean getDeleted() {
		return deleted;
	}

	/**
	 * Sets the deleted.
	 * 
	 * @param deleted
	 *            the new deleted
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	/**
	 * Gets the checked.
	 * 
	 * @return the checked
	 */
	public Boolean getChecked() {
		return checked;
	}

	/**
	 * Sets the checked.
	 * 
	 * @param checked
	 *            the new checked
	 */
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	/**
	 * Gets the contact id.
	 * 
	 * @return the contact id
	 */
	public int getContactId() {
		return contactId;
	}

	/**
	 * Sets the contact id.
	 * 
	 * @param contactId
	 *            the new contact id
	 */
	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	/**
	 * Gets the comment id.
	 * 
	 * @return the comment id
	 */
	/*public int getCommentId() {
		return commentId;
	}
*/
	/**
	 * Sets the comment id.
	 * 
	 * @param commentId
	 *            the new comment id
	 */
	/*public void setCommentId(int commentId) {
		this.commentId = commentId;
	}*/

	/**
	 * Gets the contact.
	 *
	 * @return the contact
	 */
	public ContactEntity getContact() {
		return contact;
	}

	/**
	 * Sets the contact.
	 *
	 * @param contact the new contact
	 */
	public void setContact(ContactEntity contact) {
		this.contact = contact;
	}
}

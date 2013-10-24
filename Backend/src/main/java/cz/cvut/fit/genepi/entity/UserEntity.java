package cz.cvut.fit.genepi.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

// TODO: Auto-generated Javadoc
/**
 * The Class UserEntity.
 */
@Entity
@Table(name = "USER")
public class UserEntity {

	/** The id. */
	@Id
	@Column(name = "ID", precision = 6, scale = 0, nullable = false)
	@GeneratedValue
	private int id;

	/** The username. */
	@Pattern(regexp = "[A-Za-z0-9]*")
	// @NotBlank
	// @NotNull
	@Size(min = 1, max = 10)
	@Column(name = "USERNAME", length = 10, nullable = false)
	private String username;

	/** The password. */
	// @NotBlank
	// @NotNull
	@Size(min = 8, max = 128)
	@Column(name = "PASSWORD", precision = 128, scale = 0, nullable = true)
	private String password;

	/** The contact. */
	@Valid
	@OneToOne
	@Cascade({ CascadeType.ALL })
	private ContactEntity contact;

	@ManyToMany(fetch = FetchType.EAGER)
	@Cascade({ CascadeType.ALL })
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "role_ID", nullable = false, updatable = false) })
	private List<RoleEntity> roles;
	

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
	 * Gets the username.
	 * 
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 * 
	 * @param username
	 *            the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

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
	 * @param contact
	 *            the new contact
	 */
	public void setContact(ContactEntity contact) {
		this.contact = contact;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
}

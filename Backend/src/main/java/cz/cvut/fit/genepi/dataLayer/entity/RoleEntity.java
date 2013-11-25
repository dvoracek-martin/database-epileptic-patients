package cz.cvut.fit.genepi.dataLayer.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleEntity.
 */
@Entity
@Table(name = "ROLE")
public class RoleEntity {

	/** The id. */
	@Id
	@Column(name = "ID", precision = 6, scale = 0, nullable = false)
	@GeneratedValue
	private int id;

	/** The authority. */
	@Column(name = "AUTHORITY", nullable = false)
	private String authority;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
	private List<UserEntity> users;

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
	 * Gets the authority.
	 * 
	 * @return the authority
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * Sets the authority.
	 * 
	 * @param authority
	 *            the new authority
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
}

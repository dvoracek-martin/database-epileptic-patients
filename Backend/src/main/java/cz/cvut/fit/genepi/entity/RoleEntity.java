package cz.cvut.fit.genepi.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.FetchType;

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
	private Set<UserEntity> users;

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

	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}
}

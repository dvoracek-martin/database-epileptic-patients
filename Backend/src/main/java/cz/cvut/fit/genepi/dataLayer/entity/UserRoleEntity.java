package cz.cvut.fit.genepi.dataLayer.entity;

import javax.persistence.*;

// TODO: Auto-generated Javadoc

/**
 * The Class UserRoleEntity.
 */
@Entity
@Table(name = "USER_ROLE")
public class UserRoleEntity {

    /**
     * The id.
     */
    @Id
    @Column(name = "ID", precision = 6, scale = 0, nullable = false)
    @GeneratedValue
    private int id;

    /**
     * The role_id.
     */
    @Column(name = "ROLE_ID", nullable = false)
    private int role_id;

    /**
     * The user_id.
     */
    @Column(name = "USER_ID", nullable = false)
    private int user_id;

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
     * @param id the new id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the role_id.
     *
     * @return the role_id
     */
    public int getRole_id() {
        return role_id;
    }

    /**
     * Sets the role_id.
     *
     * @param role_id the new role_id
     */
    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    /**
     * Gets the user_id.
     *
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * Sets the user_id.
     *
     * @param user_id the new user_id
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}

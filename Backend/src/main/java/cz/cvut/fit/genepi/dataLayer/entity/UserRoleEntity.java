package cz.cvut.fit.genepi.dataLayer.entity;

import javax.persistence.*;

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
    private int roleId;

    /**
     * The user_id.
     */
    @Column(name = "USER_ID", nullable = false)
    private int userId;

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
    public int getRoleId() {
        return roleId;
    }

    /**
     * Sets the role_id.
     *
     * @param role_id the new role_id
     */
    public void setRoleId(int role_id) {
        this.roleId = role_id;
    }

    /**
     * Gets the user_id.
     *
     * @return the user_id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets the user_id.
     *
     * @param user_id the new user_id
     */
    public void setUserId(int user_id) {
        this.userId = user_id;
    }
}

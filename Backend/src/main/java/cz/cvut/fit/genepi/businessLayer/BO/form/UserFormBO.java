package cz.cvut.fit.genepi.businessLayer.BO.form;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;

public class UserFormBO {

    private int id;

    /**
     * The username.
     */
    @Size(min = 1, max = 20)
    private String username;

    /**
     * The password.
     */
    @Size(min = 8, max = 128)
    private String password;

    private boolean hidden;

    /**
     * The contact.
     */
    @Valid
    private UserContactFormBO contact;

    private List<RoleFormBO> roles;

    /* getters and setters */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public UserContactFormBO getContact() {
        return contact;
    }

    public void setContact(UserContactFormBO contact) {
        this.contact = contact;
    }

    public List<RoleFormBO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleFormBO> roles) {
        this.roles = roles;
    }
}

package cz.cvut.fit.genepi.businessLayer.VO.form;

import javax.validation.Valid;
import javax.validation.constraints.Size;

public class UserVO {

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
    private UserContactVO contact;

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

    public UserContactVO getContact() {
        return contact;
    }

    public void setContact(UserContactVO contact) {
        this.contact = contact;
    }
}

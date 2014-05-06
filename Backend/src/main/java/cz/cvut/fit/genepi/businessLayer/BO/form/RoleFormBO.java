package cz.cvut.fit.genepi.businessLayer.BO.form;

public class RoleFormBO {

    private int id;

    private UserFormBO users;

    /**
     * The authority.
     */
    private String authority;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserFormBO getUsers() {
        return users;
    }

    public void setUsers(UserFormBO users) {
        this.users = users;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}

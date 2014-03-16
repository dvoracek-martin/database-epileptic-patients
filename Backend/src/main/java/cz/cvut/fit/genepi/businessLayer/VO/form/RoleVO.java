package cz.cvut.fit.genepi.businessLayer.VO.form;

/**
 * Created by Jan on 15.3.14.
 */
public class RoleVO {

    private int id;

    private UserVO users;

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

    public UserVO getUsers() {
        return users;
    }

    public void setUsers(UserVO users) {
        this.users = users;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}

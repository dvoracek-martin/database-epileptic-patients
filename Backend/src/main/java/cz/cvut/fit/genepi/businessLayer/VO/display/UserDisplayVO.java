package cz.cvut.fit.genepi.businessLayer.VO.display;

public class UserDisplayVO {

    private int id;

    private String username;

    private ContactDisplayVO contact;

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

    public ContactDisplayVO getContact() {
        return contact;
    }

    public void setContact(ContactDisplayVO contact) {
        this.contact = contact;
    }
}
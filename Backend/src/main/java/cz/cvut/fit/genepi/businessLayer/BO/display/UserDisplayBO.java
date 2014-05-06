package cz.cvut.fit.genepi.businessLayer.BO.display;

public class UserDisplayBO {

    private int id;

    private String username;

    private ContactDisplayBO contact;

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

    public ContactDisplayBO getContact() {
        return contact;
    }

    public void setContact(ContactDisplayBO contact) {
        this.contact = contact;
    }
}

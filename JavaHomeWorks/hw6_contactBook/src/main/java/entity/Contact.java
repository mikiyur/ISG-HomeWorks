package hw6_contactBook.src.main.java.entity;



import java.io.Serializable;


public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private ContactType contactType;
    private String contact;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "\n" + contactType.toString().toLowerCase() + "  " + contact;
    }
}


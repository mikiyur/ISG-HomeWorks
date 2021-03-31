package hw6_contactBook.src.main.java.entity;



import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String name;
    private String lastName;
    private final Set<Contact> contacts = new HashSet<>();

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                " " + contacts;
    }
}

package hw6_contactBook;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String name;
    private String lastname;
    private final Set<Contact> contacts = new HashSet<>();
}

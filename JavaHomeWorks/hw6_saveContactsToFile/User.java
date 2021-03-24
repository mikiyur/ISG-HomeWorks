package hw6_saveContactsToFile;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String login;
    private String password;
    private final Set <Person> contactBook = new HashSet<Person>();
}

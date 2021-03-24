package hw6_contactBook;

import java.io.Serializable;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private ContactType contactType;
    private String contact;
}


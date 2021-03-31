package hw6_contactBook.src.main.java.service.impl;

import hw6_contactBook.src.main.java.app.App;
import hw6_contactBook.src.main.java.app.Tools;
import hw6_contactBook.src.main.java.entity.*;
import hw6_contactBook.src.main.java.repository.UserRepository;
import hw6_contactBook.src.main.java.repository.impl.UserRepositoryFile;
import hw6_contactBook.src.main.java.service.ContactBookService;

import java.util.ArrayList;
import java.util.List;

public class ContactBookServiceImpl implements ContactBookService {
    private static final UserRepository USER_REPOSITORY = new UserRepositoryFile();
    @Override
    public void showContactBook() {
        App.currentUser.getContactBook().forEach(System.out::println);
    }

    @Override
    public void addNewPerson() {
        Person person = new Person();
        System.out.println("enter name");
        person.setName(Tools.readConsole());

        System.out.println("enter last name");
        person.setLastName(Tools.readConsole());

        String answer;
        do {
            System.out.println("do you want to add new contact to the person\n 1. Yes\n 2. No");
            answer = Tools.readConsole();
            System.out.println("enter type of a contact you want to add");
            for (int i = 0; i < ContactType.values().length; i++) {
                System.out.println(i + ". " + ContactType.values()[i]);
            }
            Contact contact = new Contact();
            contact.setContactType(ContactType.values()[Integer.parseInt(Tools.readConsole())]);

            System.out.println("enter the contact");
            contact.setContact(Tools.readConsole());

            person.getContacts().add(contact);
        }while (answer.equals("1"));
        List<User> users = USER_REPOSITORY.getAllUsers();
        App.currentUser = getCurrentUser(users);
        App.currentUser.getContactBook().add(person);
        USER_REPOSITORY.saveUsers(users);
    }

    @Override
    public void deletePerson() {
        System.out.println("enter id of the person");
        int id = Integer.parseInt(Tools.readConsole());
        List<User> users = USER_REPOSITORY.getAllUsers();
        App.currentUser = getCurrentUser(users);
        App.currentUser.getContactBook()
                .stream()
                .filter(person1 -> person1.getId() == id)
                .findFirst()
                .ifPresent(person1 ->  App.currentUser.getContactBook().remove(person1));
        USER_REPOSITORY.saveUsers(users);
    }

    @Override
    public void clearContactBook() {
        List<User> users = USER_REPOSITORY.getAllUsers();
        App.currentUser = getCurrentUser(users);
        App.currentUser.getContactBook().clear();
        USER_REPOSITORY.saveUsers(users);
    }

    @Override
    public void editPerson() {
        //TODO
    }

    private User getCurrentUser(List<User> users){
        return users.stream()
                .filter(user -> user.getLogin().equals( App.currentUser.getLogin()))
                .findFirst().get();
    }
}

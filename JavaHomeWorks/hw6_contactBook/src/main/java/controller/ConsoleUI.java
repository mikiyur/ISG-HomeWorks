package hw6_contactBook.src.main.java.controller;

import hw6_contactBook.src.main.java.app.Tools;
import hw6_contactBook.src.main.java.service.*;
import hw6_contactBook.src.main.java.service.UserService;
import hw6_contactBook.src.main.java.service.impl.ContactBookServiceImpl;
import hw6_contactBook.src.main.java.service.impl.UserServiceImpl;

public class ConsoleUI {
    private static final UserService USER_SERVICE = new UserServiceImpl();
    private static final ContactBookService CONTACT_BOOK_SERVICE = new ContactBookServiceImpl();

    private static final String LOGIN_OR_REGISTRATION =
            "enter 1 - to log in \n" +
                    "enter 2 - to register \n" +
                    "enter 0 - to exit";

    private static final String MENU =
            "enter 1 - to show contactBook \n" +
                    "enter 2 - to add a new person \n" +
                    "enter 3 - to delete person \n" +
                    "enter 4 - to edit person \n" +
                    "enter 5 - to clear contactBook \n" +
                    "enter 6 - to change login or password \n" +
                    "enter 7 - to logout \n" +
                    "enter 0 - to exit";

    public boolean loginOrRegistration() {
        System.out.println(LOGIN_OR_REGISTRATION);
            switch (Tools.readConsole()) {
                case "1":
                    USER_SERVICE.doLogin();
                    return false;
                case "2":
                    USER_SERVICE.doRegister();
                    return false;
                case "0":
                    return true;
                default:
                    System.out.println("please try again");
                    return loginOrRegistration();
            }
    }

    public boolean menu() {
        System.out.println(MENU);
        switch (Tools.readConsole()) {
            case "1":
                CONTACT_BOOK_SERVICE.showContactBook();
                return false;
            case "2":
                CONTACT_BOOK_SERVICE.addNewPerson();
                return false;
            case "3":
                CONTACT_BOOK_SERVICE.deletePerson();
                return false;
            case "4":
                CONTACT_BOOK_SERVICE.editPerson();
                return false;
            case "5":
                CONTACT_BOOK_SERVICE.clearContactBook();
                return false;
            case "6":
                USER_SERVICE.changeLoginOrPassword();
                return false;
            case "7":
                USER_SERVICE.doLogout();
                return false;
            case "9":
                printAllUsers();
                return false;
            case "0":
                return true;
            default:
                System.out.println("please try again");
                return loginOrRegistration();
        }
    }

    public void printAllUsers(){
        System.out.println(USER_SERVICE.getAllUsers());
    }
}

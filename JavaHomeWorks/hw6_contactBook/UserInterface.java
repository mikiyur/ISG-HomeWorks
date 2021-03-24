package hw6_contactBook;

import java.io.BufferedReader;

public class UserInterface {
    private static final String LOGIN_OR_REGISTRATION =
            "enter 1 - to log in \n" +
                    "enter 2 - to register \n" +
                    "enter 0 - to exit";

    private static final String MENU =
            "enter 1 - to show contactBook \n" +
                    "enter 2 - to add a new person \n" +
                    "enter 3 - to choose a person \n" +
                    "enter 4 - to clear contactBook \n" +
                    "enter 5 - to change login or password \n" +
                    "enter 6 - to logout \n" +
                    "enter 0 - to exit";

    public boolean loginOrRegistration(User currentUser, BufferedReader bufferedReader) {
        System.out.println(LOGIN_OR_REGISTRATION);
        return true;
    }

    public boolean menu(User currentUser, BufferedReader bufferedReader) {
        System.out.println(MENU);
        return true;
    }
}

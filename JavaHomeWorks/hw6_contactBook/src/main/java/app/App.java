package hw6_contactBook.src.main.java.app;

import hw6_contactBook.src.main.java.controller.ConsoleUI;
import hw6_contactBook.src.main.java.entity.User;
import hw6_contactBook.src.main.java.repository.impl.UserRepositoryMySQL;


public class App {

    public static User currentUser = null;
    private static final ConsoleUI CONSOLE_UI = new ConsoleUI();
    private static final UserRepositoryMySQL USER_REPOSITORY2 = new UserRepositoryMySQL();

    public static void main(String[] args) {
        USER_REPOSITORY2.init();
        boolean exit = false;
        do {
            if (currentUser == null) {
                exit = CONSOLE_UI.loginOrRegistration();
            } else {
                exit = CONSOLE_UI.menu();
            }
        } while (!exit);

        Tools.closeConsole();
    }
}

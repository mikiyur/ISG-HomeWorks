package hw6_contactBook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static User currentUser = null;
    private static final UserInterface USER_INTERFACE = new UserInterface();
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        boolean exit = false;
        do {
            if (currentUser == null){
                exit = USER_INTERFACE.loginOrRegistration(currentUser,bufferedReader);
            }else {
                exit = USER_INTERFACE.menu(currentUser,bufferedReader);
            }
        }while (!exit);

        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

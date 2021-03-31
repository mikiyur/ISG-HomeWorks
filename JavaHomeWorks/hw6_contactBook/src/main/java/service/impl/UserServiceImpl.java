package hw6_contactBook.src.main.java.service.impl;

import hw6_contactBook.src.main.java.app.App;
import hw6_contactBook.src.main.java.app.Tools;
import hw6_contactBook.src.main.java.entity.User;
import hw6_contactBook.src.main.java.repository.UserRepository;
import hw6_contactBook.src.main.java.repository.impl.UserRepositoryFile;
import hw6_contactBook.src.main.java.service.UserService;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    private static final UserRepository USER_REPOSITORY = new UserRepositoryFile();

    @Override
    public void doLogin() {
        System.out.println("Enter user login");
        String login = Tools.readConsole();
        Optional <User> optionalUser = USER_REPOSITORY.getUserByLogin(login);
        if (!optionalUser.isPresent()){
            System.out.println("User with the login isn't present");
            return;
        }
        for (int i = 4; i > 0 ; i++) {
            System.out.println("Enter password");
            String password = Tools.readConsole();
            if (optionalUser.get().getPassword().equals(password)){
                hw6_contactBook.src.main.java.app.App.currentUser = optionalUser.get();
                return;
            }
            System.out.println("the password isn't equals, try again! (you have "+i+" tries)");
        }
        return;
    }

    @Override
    public void doLogout() {
        hw6_contactBook.src.main.java.app.App.currentUser = null;
    }

    @Override
    public void doRegister() {
        User user = new User();
        String login;
        String password;
        System.out.println("Enter user login");
        do {
            login = Tools.readConsole();
        } while (login == null || login.equals(""));

        System.out.println("Enter password");
        do {
            password = Tools.readConsole();
        } while (password == null || password.equals(""));

        user.setLogin(login);
        user.setPassword(password);
        USER_REPOSITORY.saveNewUser(user);
        hw6_contactBook.src.main.java.app.App.currentUser = user;
    }

    @Override
    public List<User> getAllUsers() {
        return USER_REPOSITORY.getAllUsers();
    }

    @Override
    public void changeLoginOrPassword() {
        System.out.println("Enter new user-login");
        String login;
        String password;
        do {
            login = Tools.readConsole();
        } while (login == null || login.equals(""));

        System.out.println("Enter new password");
        do {
            password = Tools.readConsole();
        } while (password == null || password.equals(""));
        List<User> users = USER_REPOSITORY.getAllUsers();
        App.currentUser = users.stream()
                .filter(user -> user.getLogin().equals(App.currentUser.getLogin()))
                .findFirst().get();
        App.currentUser.setLogin(login);
        App.currentUser.setPassword(password);
        USER_REPOSITORY.saveUsers(users);
    }
}

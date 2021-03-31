package hw6_contactBook.src.main.java.service;

import hw6_contactBook.src.main.java.entity.User;

import java.util.List;

public interface UserService {
    void doRegister();
    void doLogin();
    void doLogout();
    List<User> getAllUsers();
    void changeLoginOrPassword();

}

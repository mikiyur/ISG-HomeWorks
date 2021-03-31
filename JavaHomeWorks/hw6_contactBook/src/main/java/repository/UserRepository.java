package hw6_contactBook.src.main.java.repository;

import hw6_contactBook.src.main.java.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> getAllUsers();
    Optional<User> getUserByLogin(String login);
    void saveNewUser(User user);
    void saveUsers(List<User> users);
}

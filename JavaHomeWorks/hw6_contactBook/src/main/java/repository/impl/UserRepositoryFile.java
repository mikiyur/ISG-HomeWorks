package hw6_contactBook.src.main.java.repository.impl;

import hw6_contactBook.src.main.java.entity.User;
import hw6_contactBook.src.main.java.repository.UserRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryFile implements UserRepository {
    private static final String PATH = "C:\\git\\hw6_contactBook\\src\\main\\resources\\data\\data.ser";
    private static ObjectOutputStream objectOutputStream;
    private static ObjectInputStream objectInputStream;

    @Override
    public void saveNewUser(User user) {
        ArrayList<User> users = getAllUsers();
        if (!getUserByLogin(user.getLogin()).isPresent())
            users.add(user);
        saveUsers(users);
    }

    public ArrayList<User> getAllUsers() {
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(PATH));
            ArrayList<User> users = (ArrayList<User>) objectInputStream.readObject();
            objectInputStream.close();
            return users;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public Optional<User> getUserByLogin(String login) {
        ArrayList<User> users = getAllUsers();
        return users.stream().filter(user -> user.getLogin().equals(login)).findFirst();
    }

    @Override
    public void saveUsers(List<User> users) {
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(PATH));
            objectOutputStream.writeObject(users);
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

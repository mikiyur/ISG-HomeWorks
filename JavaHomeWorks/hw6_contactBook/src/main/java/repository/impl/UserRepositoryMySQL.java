package hw6_contactBook.src.main.java.repository.impl;

import hw6_contactBook.src.main.java.entity.User;
import hw6_contactBook.src.main.java.repository.UserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryMySQL implements UserRepository {
    private static final String url = "jdbc:mysql://localhost:3306/?serverTimezone=UTC";
    private static final String userName = "root";
    private static final String userPassword = "mikiyur87";
    private static final String schemaName = "contacts";

    private final static String INSERT_USER_SQL = "INSERT INTO users(login, password) VALUES(?,?);";
    private final static String SELECT_USER_BY_LOGIN_SQL = "SELECT * FROM users WHERE users.login = ?;";
    private final static String SELECT_ALL_USERS_SQL = "SELECT * FROM users;";

    private Connection connection;
    private Statement statement;

    public void init() {
        connection = getConnection();
        statement = getStatement(connection);
        createAndUseSchema();
        createTableUsers();
        createTablePersons();
        createTableContacts();
    }

    private void createAndUseSchema() {
        try {
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS " + UserRepositoryMySQL.schemaName);
            statement.executeUpdate("USE " + UserRepositoryMySQL.schemaName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableUsers() {
        try {
            statement.executeUpdate("" +
                    "CREATE TABLE IF NOT EXISTS users( " +
                    "id BIGINT NOT NULL AUTO_INCREMENT, " +
                    "login VARCHAR(255) UNIQUE NOT NULL, " +
                    "password VARCHAR(255) NOT NULL, " +
                    "PRIMARY KEY (id));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTablePersons() {
        try {
            statement.executeUpdate("" +
                    "CREATE TABLE IF NOT EXISTS persons( " +
                    "id BIGINT NOT NULL AUTO_INCREMENT, " +
                    "name VARCHAR(255) NOT NULL, " +
                    "lastName VARCHAR(255) NOT NULL, " +
                    "userId BIGINT, " +
                    "PRIMARY KEY (id), " +
                    "FOREIGN KEY (userId) REFERENCES users(id));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableContacts() {
        try {
            statement.executeUpdate("" +
                    "CREATE TABLE IF NOT EXISTS contacts( " +
                    "id BIGINT NOT NULL AUTO_INCREMENT, " +
                    "ContactType VARCHAR(255) NOT NULL, " +
                    "contact VARCHAR(255) NOT NULL, " +
                    "personId BIGINT, " +
                    "PRIMARY KEY (id), " +
                    "FOREIGN KEY (personId) REFERENCES persons(id));");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<User> getAllUsers() {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_USERS_SQL);
            return collectToList(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        try {
            PreparedStatement selectByLoginStatement = prepareSelectByLoginStatement(login);
            ResultSet resultSet = selectByLoginStatement.executeQuery();
            resultSet.next();
            return Optional.of(parseRowUser(resultSet));
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Cannot find Account by id = %d", login), e);
        }
    }

    private PreparedStatement prepareSelectByLoginStatement(String login) {
        try {
            PreparedStatement selectByLoginStatement = connection.prepareStatement(SELECT_USER_BY_LOGIN_SQL);
            selectByLoginStatement.setString(1, login);
            return selectByLoginStatement;
        } catch (SQLException e) {
            throw new RuntimeException("Cannot prepare statement to select account by id", e);
        }
    }

    @Override
    public void saveNewUser(User user) {
        try {
            PreparedStatement insertStatement = prepareInsertStatement(user);
            executeUpdate(insertStatement, "User was not created");
            Long id = fetchGeneratedId(insertStatement);
            user.setId(id);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    private void executeUpdate(PreparedStatement insertStatement, String errorMessage) throws SQLException {
        int rowsAffected = insertStatement.executeUpdate();
        if (rowsAffected == 0) {
            throw new RuntimeException(errorMessage);
        }
    }

    private Long fetchGeneratedId(PreparedStatement insertStatement) throws SQLException {
        ResultSet generatedKeys = insertStatement.getGeneratedKeys();

        if (generatedKeys.next()) {
            return generatedKeys.getLong(1);
        } else {
            throw new RuntimeException("Can not obtain an account ID");
        }
    }

    @Override
    public void saveUsers(List<User> users) { }

    private List<User> collectToList(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            User user = parseRowUser(rs);
            users.add(user);
        }
        return users;
    }
    private User parseRowUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getLong(1));
        user.setLogin(rs.getString(2));
        user.setPassword(rs.getString(3));
        return user;
    }

    private PreparedStatement prepareInsertStatement(User user) {
        try {
            PreparedStatement insertStatement = connection.prepareStatement(INSERT_USER_SQL);
            return fillStatementWithUserData(insertStatement, user);
        } catch (SQLException e) {
            throw new RuntimeException("Cannot prepare statement to insert account");
        }
    }

    private PreparedStatement fillStatementWithUserData(PreparedStatement insertStatement, User user)
            throws SQLException {
        insertStatement.setString(1, user.getLogin());
        insertStatement.setString(2, user.getPassword());
        return insertStatement;
    }

    private Connection getConnection() {
        try {
            connection = DriverManager.getConnection(url, userName, userPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private Statement getStatement(Connection connection) {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }
}

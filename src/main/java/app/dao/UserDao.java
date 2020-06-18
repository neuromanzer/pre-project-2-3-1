package app.dao;

import app.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUserById(Long id);

    User getUserByLogin(String login);

    boolean validateUser(String login);

    void addUser(User user);

    void editUser(User user);

    void deleteUser(Long id);

}

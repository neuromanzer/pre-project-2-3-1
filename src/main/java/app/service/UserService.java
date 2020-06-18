package app.service;

import app.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long userId);

    boolean validateUser(String login);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}

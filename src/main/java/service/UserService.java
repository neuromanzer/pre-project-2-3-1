package service;

import model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(Long userId);

    void add(User user);

    void update(User user);

    void delete(Long id);
}
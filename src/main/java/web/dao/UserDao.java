package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();

    User getById(Long id);

    void add(User user);

    void edit(User user);

    void delete(Long id);

}

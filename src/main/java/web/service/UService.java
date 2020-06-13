package web.service;

import web.model.User;

import java.util.ArrayList;
import java.util.List;

public class UService {

    public static List<User> getUsers() {
        final List<User> users = new ArrayList<>();

        users.add(new User(1L,"user_1", "user_1", "user_1"));

        return users;
    }


}

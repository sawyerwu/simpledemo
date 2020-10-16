package com.swu.ace.service.impl;

import com.swu.ace.model.User;
import com.swu.ace.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    private static List<User> users = new ArrayList<>();

    static {
        User user1 = new User("user1", 11);
        User user2 = new User("user2", 22);
        users.add(user1);
        users.add(user2);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUserByName(String name) {
        Optional<User> first = users.stream().filter(user -> name.equals(user.getName())).findFirst();
        return first.orElse(null);
    }

    @Override
    public boolean createUser(String name, int age) {
        return users.add(new User(name, age));
    }

    @Override
    public boolean deleteUserByName(String name) {
        User user = getUserByName(name);
        return users.remove(user);
    }
}

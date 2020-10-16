package com.swu.ace.service;

import com.swu.ace.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();

    User getUserByName(String name);

    boolean createUser(String name, int age);

    boolean deleteUserByName(String name);

}

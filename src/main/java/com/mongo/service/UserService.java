package com.mongo.service;

import com.mongo.domain.User;

import java.util.List;

/**
 * Created by Bipin on 3/6/16.
 */
public interface UserService {
    List<User> findAllUser();

    void createUser(User user);

    User findUserByFirstName(String firstName);

    void updateUser(String id, User user);

    void deleteUser(String id);

    User findUserById(String id);
}

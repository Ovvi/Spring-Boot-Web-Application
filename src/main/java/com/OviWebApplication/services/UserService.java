package com.OviWebApplication.services;

import com.OviWebApplication.domain.User;

import java.util.List;

/**
 * Created by Ovi on 11/21/2016.
 */
public interface UserService {

    Iterable<User> listAllUsers();

    User getUserById(Integer id);

    User saveUser(User user);

    void deleteUser(Integer id);

    List<User> searchByFirstName(String firstName);


}

package com.OviWebApplication.services;

import com.OviWebApplication.domain.User;

import java.util.List;

/**
 * In this interface i set all the methods that UserServiceImpl needs to CRUD the repository.
 */
public interface UserService {

    Iterable<User> listAllUsers();

    User getUserById(Integer id);

    User saveUser(User user);

    void deleteUser(Integer id);

    List<User> searchByFirstName(String firstName);


}

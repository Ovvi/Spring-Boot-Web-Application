package com.OviWebApplication.services;

import com.OviWebApplication.domain.User;
import com.OviWebApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This class represent the implementation of CRUD operations on User data.
 */

@Service
public class UserServiceImp implements UserService{

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /**
     * This method query the database for all users and then return the users.
     * @return all the users.
     */
    @Override
    public Iterable<User> listAllUsers() {
        return userRepository.findAll();
    }

    /**
     * This method find one User base on the given id.
     * @param id the id inserted.
     * @return the User with that id.
     */
    @Override
    public User getUserById(Integer id) {
        return userRepository.findOne(id);
    }

    /**
     * This method save the new User in the database.
     * @param user the created.
     * @return the new user.
     */
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * This method delete a user base on the given id.
     * @param id the id inserted.
     */
    @Override
    public void deleteUser(Integer id) {
        userRepository.delete(id);
    }

    /**
     * This method search in the database for the users with a specific first name.
     * @param firstName the first name inserted.
     * @return all users that finds.
     */
    @Override
    public List<User> searchByFirstName(String firstName) {
        return userRepository.findAllByFirstName(firstName);
    }
}

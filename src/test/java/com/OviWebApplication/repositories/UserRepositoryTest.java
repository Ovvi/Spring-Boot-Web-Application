package com.OviWebApplication.repositories;

import com.OviWebApplication.configuration.RepositoryConfiguration;
import com.OviWebApplication.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Ovi on 11/20/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RepositoryConfiguration.class})
public class UserRepositoryTest {


    @Autowired
    private UserRepository userRepository;


     public void setUserRepository(UserRepository userRepository){
         this.userRepository = userRepository;
     }

    @Test
    public void testSaveProduct() {

        //Setup User
        User user = new User();
        user.setFirstName("Booom");
        user.setLastName("Bemmm");
        user.setHobby("Tenis");

        //save user, verify ID value after save
        assertNull(user.getId()); // null before save
        userRepository.save(user);
        assertNotNull(user.getId()); // not null after save

        //fetch from DB
        User fetchedUser = userRepository.findOne(user.getId());

        //should not be null
        assertNotNull(fetchedUser);

        //should be equal
        assertEquals(user.getId(), fetchedUser.getId());
        assertEquals(user.getFirstName(), fetchedUser.getFirstName());

        //update description and save
        fetchedUser.setFirstName("Bob");
        userRepository.save(fetchedUser);

        //get data from DB , should be updated
        User fetchedUpdatedUser = userRepository.findOne(fetchedUser.getId());
        assertEquals(fetchedUser.getFirstName(), fetchedUpdatedUser.getFirstName());

        //verify count of users in DB
        long userCount = userRepository.count();
        assertEquals(userCount, 1);

        //get all users, should be just one in the list
        Iterable<User> users = userRepository.findAll();

        int count = 0;
        for (User u : users) {
            count++;
        }

        assertEquals(count, 1);

    }
}













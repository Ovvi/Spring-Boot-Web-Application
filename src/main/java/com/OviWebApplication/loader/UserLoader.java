package com.OviWebApplication.loader;

import com.OviWebApplication.domain.User;
import com.OviWebApplication.repositories.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.*;


/**
 * Created by Ovi on 11/20/2016.
 */
@Component
public class UserLoader implements CommandLineRunner {

    private UserRepository userRepository;
    private Logger log = Logger.getLogger(UserLoader.class);

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        List<User> users = new ArrayList<>();

        users.add(new User("Dan","Thomson","Tennis"));
        users.add(new User("Ben","Jackson","Football"));
        users.add(new User("Jack","Homes","Golf"));
        users.add(new User("Jennifer","Aniston","Volleyball"));

        userRepository.save(users);
    }
}

package com.OviWebApplication.repositories;

import com.OviWebApplication.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Ovi on 11/20/2016.
 */

public interface UserRepository extends CrudRepository<User, Integer>{

    List<User> findAllByFirstName(String firstName);


}

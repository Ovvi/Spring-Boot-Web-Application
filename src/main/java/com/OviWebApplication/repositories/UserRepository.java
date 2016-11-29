package com.OviWebApplication.repositories;

import com.OviWebApplication.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * This interface extends CrudRepository and set the User as object.
 */

public interface UserRepository extends CrudRepository<User, Integer>{

    List<User> findAllByFirstName(String firstName);


}

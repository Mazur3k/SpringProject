package org.edu.mazurek.edu.repository;

import org.edu.mazurek.edu.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLastnameIgnoreCase(String lastname);
    List<User> findByFirstnameIgnoreCase(String firstname);
    List<User> findByEmailContainingIgnoreCase(String email);
    List<User> findByBirthdateContainingIgnoreCase(String birthdate);

}

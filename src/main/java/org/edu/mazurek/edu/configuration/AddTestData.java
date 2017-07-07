package org.edu.mazurek.edu.configuration;

import org.edu.mazurek.edu.model.User;
import org.edu.mazurek.edu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AddTestData {

    private final UserRepository userRepository;

    @Autowired
    public AddTestData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void addTestData() {

        List<User> users = new ArrayList<>();
        users.add(new User(0l, "Adam", "Mazurkiewicz", "adam.mazurkiewicz92@gmail.com", "09-07-1992","123"));
        users.add(new User(0l, "Jan", "Kowalski", "jan.kowalski@gmail.com", "09-07-1993","123"));
        users.add(new User(0l, "Stefan", "Niesiolowski", "stefan.niesiolowski@gmail.com", "09-07-1994","123"));
        users.add(new User(0l, "Eugeniusz", "Smolarek", "eugeniusz.smolarek@gmail.com", "09-07-1995","123"));

        userRepository.save(users);

    }


}

package com.explanatory.webservices.restfulwebservices.user;


import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int userCount = 1;

    static {
        users.add(new User(userCount++, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(userCount++, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(userCount++, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().get();
    }

    public User save(User user) {
        user.setId(userCount++);
        users.add(user);
        return user;
    }

}

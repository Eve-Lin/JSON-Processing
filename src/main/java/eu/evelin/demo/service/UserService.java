package eu.evelin.demo.service;

import eu.evelin.demo.model.User;


import java.util.Collection;

public interface UserService {

    Collection<User> getUsers();

    User getUserByName(String userName);
    User getUserById(Long id);
    User addUser(User user);
    User updateUsers(User user);
    User deleteUsers(Long id);
    long getUserCount();
}

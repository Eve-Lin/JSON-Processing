package eu.evelin.demo.service.impl;

import eu.evelin.demo.dao.PostRepository;
import eu.evelin.demo.dao.UserRepository;
import eu.evelin.demo.exception.InvalidEntityException;
import eu.evelin.demo.model.Post;
import eu.evelin.demo.model.User;
import eu.evelin.demo.service.PostService;
import eu.evelin.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepo;

    @Override
    public Collection<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserByName(String userName) {
        return userRepo.findByUsername(userName).orElseThrow(
                () -> new EntityNotFoundException("User with that name not found")
        );
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User with that id not found")
        );

    }

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUsers(User user) {
        return null;
    }

    @Override
    public User deleteUsers(Long id) {
        return null;
    }

    @Override
    public long getUserCount() {
        return 0;
    }
}

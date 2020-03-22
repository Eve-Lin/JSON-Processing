package eu.evelin.demo.init;

import eu.evelin.demo.model.Post;
import eu.evelin.demo.model.User;
import eu.evelin.demo.service.PostService;
import eu.evelin.demo.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Log4j2
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    public static final List<Post> SAMPLE_POSTS = List.of(
            new Post("Welcome to String", "Just keep coding"),
            new Post("Welcome to String Data", "Keep learning"),
            new Post("Welcome to Golang", "Yep, coding with it as well.")
    );

    public static final List<User> SAMPLE_USERS = List.of(
            new User("Evelin","Di","admin", "password"),
            new User("John","Doe","user", "password1")
    );

    @Override
    public void run(String... args) throws Exception {

        SAMPLE_USERS.forEach(user ->userService.addUser(user));
        log.info("Created users: ()", userService.getUsers());
        SAMPLE_POSTS.forEach(post -> {
                    post.setAuthor(userService.getUserById(1L));
                    postService.addPosts(post);
                });
        log.info("Created posts: ()", postService.getPosts());
    }
}

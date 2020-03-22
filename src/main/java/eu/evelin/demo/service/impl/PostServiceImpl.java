package eu.evelin.demo.service.impl;

import eu.evelin.demo.dao.PostRepository;
import eu.evelin.demo.dao.UserRepository;
import eu.evelin.demo.exception.InvalidEntityException;
import eu.evelin.demo.exception.InvalidEntityException;
import eu.evelin.demo.model.Post;
import eu.evelin.demo.model.User;
import eu.evelin.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Date;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public Collection<Post> getPosts() {
        return postRepo.findAll();
    }

    @Override
    public Post addPosts(Post post) {
        Long authorId;
        if(post.getAuthor()!= null && post.getAuthor().getId() != null){
            authorId = post.getAuthor().getId();
        }else{
            authorId = post.getAuthorId();
        }
        if(authorId != null){
            User author = userRepo.findById(authorId)
                    .orElseThrow(() -> new InvalidEntityException("Author with id= " + authorId + "does not exist!"));
       post.getAuthor();
        }
        if(post.getCreated() ==null){
            post.setCreated(new Date());
        }
        post.setModified(post.getCreated());
        return postRepo.save(post);
    }

    @Override
    public Post updatePosts(Post post) {
        return null;
    }

    @Override
    public Post deletePosts(Long id) {
        return null;
    }

    @Override
    public long getPostCount() {
        return 0;
    }
}

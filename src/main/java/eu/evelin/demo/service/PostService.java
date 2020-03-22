package eu.evelin.demo.service;

import eu.evelin.demo.model.Post;

import java.util.Collection;

public interface PostService {

    Collection<Post> getPosts();
    Post addPosts(Post post);
    Post updatePosts(Post post);
    Post deletePosts(Long id);
    long getPostCount();
}

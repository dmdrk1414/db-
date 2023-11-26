package org.example.service;

import org.example.domain.Post;
import org.example.repository.PostRepository;

import java.util.List;

public class PostService {
    private final PostRepository postRepository;

    public PostService() {
        this.postRepository = new PostRepository();
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }
}

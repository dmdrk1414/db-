package org.example.service;

import org.example.dto.request.SavePostRequest;
import org.example.entity.Post;
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

    public boolean save(SavePostRequest savePostRequest) {
        return postRepository.save(savePostRequest);
    }
}

package org.example.back.service;

import org.example.back.dto.request.SavePostRequest;
import org.example.back.entity.Post;
import org.example.back.repository.PostRepository;

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

    public boolean deleteByPostId(Integer postId) {
        return postRepository.deleteByPostId(postId);
    }
}

package org.example.controller;

import org.example.dto.request.SavePostRequest;
import org.example.service.PostService;

public class PostController {
    private final PostService postService;

    public PostController() {
        this.postService = new PostService();
    }

    public Boolean savePost(SavePostRequest savePostRequest) {

        if (postService.save(savePostRequest)) {
            return true;
        }
        return false;
    }
}

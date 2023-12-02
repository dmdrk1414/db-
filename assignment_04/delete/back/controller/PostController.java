package org.example.delete.back.controller;

import org.example.delete.back.dto.request.DeletePostRequest;
import org.example.delete.back.dto.request.SavePostRequest;
import org.example.delete.back.service.PostService;

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

    public Boolean deletePostByPostId(DeletePostRequest deletePostRequest) {
        Integer postId = deletePostRequest.getPostId();

        if (postService.deleteByPostId(postId)) {
            return true;
        }
        return false;
    }
}

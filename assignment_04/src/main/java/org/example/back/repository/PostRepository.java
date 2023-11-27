package org.example.back.repository;

import org.example.back.entity.Post;
import org.example.back.database.Database;
import org.example.back.dto.request.SavePostRequest;

import java.util.List;

public class PostRepository {
    private final Database database;

    public PostRepository() {
        this.database = new Database();
    }

    public List<Post> findAll() {
        return database.findAllPost();
    }

    public boolean save(SavePostRequest savePostRequest) {
        return database.savePost(savePostRequest);
    }

    public boolean deleteByPostId(Integer postId) {
        return database.deleteByPostId(postId);
    }
}

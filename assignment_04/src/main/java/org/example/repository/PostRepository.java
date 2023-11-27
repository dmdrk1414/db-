package org.example.repository;

import org.example.database.Database;
import org.example.dto.request.SavePostRequest;
import org.example.entity.Post;

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

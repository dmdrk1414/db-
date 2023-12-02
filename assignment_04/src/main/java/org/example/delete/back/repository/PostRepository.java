package org.example.delete.back.repository;

import org.example.delete.back.entity.Post;
import org.example.delete.back.database.Database;
import org.example.delete.back.dto.request.SavePostRequest;

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

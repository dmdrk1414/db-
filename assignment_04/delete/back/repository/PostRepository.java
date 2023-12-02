package org.example.delete.back.repository;

import org.example.delete.back.database.DatabaseDelete;
import org.example.delete.back.dto.request.SavePostRequest;
import org.example.delete.back.entity.Post;

import java.util.List;

public class PostRepository {
    private final DatabaseDelete database;

    public PostRepository() {
        this.database = new DatabaseDelete();
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

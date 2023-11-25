package org.example.repository;

import org.example.database.Database;
import org.example.domain.Member;
import org.example.domain.Post;

import java.util.List;

public class PostRepository {
    private final Database database;

    public PostRepository() {
        this.database = new Database();
    }

    public List<Post> findAll() {
        return database.findAllPost();
    }
}

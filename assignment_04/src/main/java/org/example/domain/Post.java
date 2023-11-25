package org.example.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Post {
    private final Integer id;
    private final String title;
    private final String content;
    private final String postDate;

    public Post(Integer id, String title, String content, String postDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.postDate = postDate;
    }
}

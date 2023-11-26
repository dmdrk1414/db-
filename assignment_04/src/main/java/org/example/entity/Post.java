package org.example.entity;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString

public class Post {
    private final Integer id;
    private final String title;
    private final String content;
    private final String postDate;
    private final Integer memberId;
}

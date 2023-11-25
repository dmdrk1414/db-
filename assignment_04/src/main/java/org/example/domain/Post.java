package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class Post {
    private final Integer id;
    private final String title;
    private final String content;
    private final String postDate;
    private final Integer memberId;
}

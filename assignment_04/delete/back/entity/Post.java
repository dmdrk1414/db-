package org.example.delete.back.entity;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString

public class Post {
    private static final Integer SIZE_COUNT = 5;

    private final Integer id;
    private final String title;
    private final String content;
    private final String postDate;
    private final Integer memberId;

    public String[] ofArray() {
        String[] array = new String[SIZE_COUNT];

        array[0] = String.valueOf(this.id);
        array[1] = this.title;
        array[2] = this.content;
        array[3] = this.postDate;
        array[4] = String.valueOf(this.memberId);

        return array;
    }
}

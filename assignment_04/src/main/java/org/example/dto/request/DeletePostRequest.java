package org.example.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class DeletePostRequest {
    private final Integer postId;
}

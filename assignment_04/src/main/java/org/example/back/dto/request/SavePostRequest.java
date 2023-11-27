package org.example.back.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class SavePostRequest {
    private final String title;
    private final String content;
    private final Integer memberId;
}

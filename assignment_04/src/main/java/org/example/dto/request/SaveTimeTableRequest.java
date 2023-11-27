package org.example.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class SaveTimeTableRequest {
    private final Integer id;
    private final String image;
}

package org.example.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class DeleteTimeTableRequest {
    private final Integer tableId;
}

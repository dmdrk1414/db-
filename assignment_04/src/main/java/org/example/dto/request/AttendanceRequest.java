package org.example.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class AttendanceRequest {
    private final String attendenceNumber;
    private final Integer id;
}

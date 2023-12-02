package org.example.delete.back.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class AttendanceRequest {
    private final String attendenceNumber;
    private final Integer memberId;
}

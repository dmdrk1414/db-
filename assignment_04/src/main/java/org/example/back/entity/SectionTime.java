package org.example.back.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class SectionTime {
    private final String id;
    private final String time;
    private final String sectionId;
}

package org.example.back.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Section {
    private final String id;
    private final String devisionNumber;
    private final String month;
    private final String year;
    private final String day;
    private final String instructorId;
    private final String courseCode;
    private final String courseName;
    private final String roomNumber;
    private final String building;
}

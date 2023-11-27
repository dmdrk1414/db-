package org.example.back.entity;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString

public class MemberPortfolio {
    private final Integer id;
    private final String motivationApplication;
    private final String gpa;
    private final String dream;
    private final Integer memberId;
}

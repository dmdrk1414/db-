package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class MemberPortfolio {
    private final Integer id;
    private final String motivationApplication;
    private final String gpa;
    private final String dream;
}

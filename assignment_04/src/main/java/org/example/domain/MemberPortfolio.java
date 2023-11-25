package org.example.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class MemberPortfolio {
    private final Integer id;
    private final String motivationApplication;
    private final String gpa;
    private final String dream;

    public MemberPortfolio(Integer id, String motivationApplication, String gpa, String dream) {
        this.id = id;
        this.motivationApplication = motivationApplication;
        this.gpa = gpa;
        this.dream = dream;
    }
}

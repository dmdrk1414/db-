package org.example.back.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class College {
    private final String name;
    private final String office;

    public String[] ofArray() {

        String[] array = new String[20];
        array[0] = this.name;
        array[1] = this.office;

        return array;
    }
}

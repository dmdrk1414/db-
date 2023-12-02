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

    public String[] ofArray() {

        String[] array = new String[20];
        array[0] = this.id;
        array[1] = this.time;
        array[2] = this.sectionId;

        return array;
    }
}

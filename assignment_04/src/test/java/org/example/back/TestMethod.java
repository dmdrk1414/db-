package org.example.back;

import java.util.List;

public class TestMethod {

    public static <T> void printFindAll(List<T> list) {
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " : " + list.get(i));
        }
        System.out.println();
    }
}

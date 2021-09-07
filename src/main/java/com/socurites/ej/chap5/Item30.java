package com.socurites.ej.chap5;

import java.util.HashSet;
import java.util.Set;

/**
 * 30. 이왕이면 제네릭 메서드로 만들라
 */
public class Item30 {
    // Non-generic method
    public static Set union(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }

    // Generic method
    public static <E> Set genericUnion(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }
}

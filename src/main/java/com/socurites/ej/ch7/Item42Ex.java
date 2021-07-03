package com.socurites.ej.ch7;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 익명 클래스보다는 람다를 사용하라
 */
public class Item42Ex {
  public static void main(String[] args) {
    comparingStringListEx();


  }

  // 문자열 리스트 정렬
  // 정렬 기준: 문자 길이
  private static void comparingStringListEx() {
    List<String> words = List.of("a", "bb", "ccc", "x", "yy", "zzz", "wwww");

    // Old Style
    Collections.sort(words, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
      }
    });

    // Lambda
    Collections.sort(words,
      (o1, o2) -> Integer.compare(o1.length(), o2.length()));

    // Method reference
    Collections.sort(words, Comparator.comparingInt(String::length));

    // Even more
    words.sort(Comparator.comparingInt(String::length));
  }

}

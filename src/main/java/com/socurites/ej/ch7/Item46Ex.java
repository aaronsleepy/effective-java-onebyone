package com.socurites.ej.ch7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 스트림에서는 부작용 없는 ㅎ마수를 사용하라
 */
public class Item46Ex {
  public static void main(String[] args) throws FileNotFoundException {
    countingWordsBadCase(new File("test.txt"));
    countingWordsGoodCase(new File("test.txt"));

    extractingMostFrequentWords(new File("test.txt"));
  }

  private static void extractingMostFrequentWords(File file) throws FileNotFoundException {
    Map<String, Long> freq = countingWordsGoodCase(file);

    List<String> topTen = freq.keySet().stream()
      .sorted(Comparator.comparing(freq::get).reversed())
      .limit(10)
      .collect(Collectors.toList());
  }

  private static Map<String, Long> countingWordsGoodCase(File file) throws FileNotFoundException {
    Map<String, Long> freq;
    try(Stream<String> words = new Scanner(file).tokens()) {
      freq = words
        .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
    }

    return freq;
  }

  private static Map<String, Long> countingWordsBadCase(File file) throws FileNotFoundException {
    // Don't
    Map<String, Long> freq = new HashMap<>();
    try(Stream<String> words = new Scanner(file).tokens()) {
      words.forEach(word ->
        freq.merge(word.toLowerCase(), 1L, Long::sum));
    }

    return freq;
  }
}

package com.socurites.ej.ch7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 스트림은 주의해서 사용하라
 */
public class Item45Ex {
  public static void main(String[] args) throws IOException {
    // Anagrams
//    loadAnagramsFromDictOldStyle(args[0], Integer.parseInt(args[1]));

//    loadAnagramsFromDicStreamStyle(args[0], Integer.parseInt(args[1]));

    // Mersenne Prime
//    findMersennePrimes();


    // 데카르트 프로덕트
    List<String> suits = List.of("A", "B", "C");
    List<Integer> ranks = List.of(1, 2, 3);

    // Old Style
    List<String> decks = new ArrayList<>();
    for (String suit : suits) {
      for (Integer rank : ranks) {
        decks.add(String.format("%s-%d", suit, rank));
      }
    }

    // Stream Style (flatMap)
//    List<String> newDecks = new ArrayList<>();
//    Stream<Stream<String>> streamStream = suits.stream()
//      .map(suit -> ranks.stream()
//        .map(rank -> String.format("%s-%d", suit, rank))
//      );

//    Stream<String> stringStream = suits.stream()
//      .flatMap(suit -> ranks.stream()
//        .map(rank -> String.format("%s-%d", suit, rank))
//      );

    List<String> newDecks = suits.stream()
      .flatMap(suit -> ranks.stream()
        .map(rank -> String.format("%s-%d", suit, rank))
      ).collect(Collectors.toList());

  }

  private static void findMersennePrimes() {
    primes().map(p -> BigInteger.TWO.pow(p.intValueExact()).subtract(BigInteger.ONE))
      .filter(mersenne -> mersenne.isProbablePrime(50))
      .limit(20)
      .forEach(System.out::println);

  }

  private static Stream<BigInteger> primes() {
    return Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime);
  }

  private static void loadAnagramsFromDicStreamStyle(String dictFilePath, int minGroupSize) throws IOException {
    try(Stream<String> words = Files.lines(Paths.get(dictFilePath))) {
      words.collect(Collectors.groupingBy(word -> alphabetize(word)))
        .values().stream()
        .filter(group -> group.size() >= minGroupSize)
        .forEach(group -> System.out.println(group.size() + ": " + group));
    }
  }

  private static void loadAnagramsFromDictOldStyle(String dictFilePath, int minGroupSize) throws FileNotFoundException {
    Map<String, Set<String>> groups = new HashMap<>();
    try (Scanner s = new Scanner(new File(dictFilePath))) {
      while (s.hasNext()) {
        String word = s.next();
        groups.computeIfAbsent(alphabetize(word), (unused) -> new TreeSet<>()).add(word);
      }
    }

    for (Set<String> group : groups.values()) {
      if (group.size() >= minGroupSize) {
        System.out.println(group.size() + ": " + group);
      }
    }
  }

  private static String alphabetize(String s) {
    char[] a = s.toCharArray();
    Arrays.sort(a);
    return new String(a);
  }
}

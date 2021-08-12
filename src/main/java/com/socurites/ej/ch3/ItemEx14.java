package com.socurites.ej.ch3;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 14. Comparable을 구현할지 고려하라
 */
public class ItemEx14 {
  public static void main(String[] args) {
    BigDecimal one = new BigDecimal("1.0");
    BigDecimal onedot = new BigDecimal("1.00");

    Set hashSet = new HashSet();
    hashSet.add(one);
    hashSet.add(onedot);

    Set treeSet = new TreeSet();
    treeSet.add(one);
    treeSet.add(onedot);

    // HashSet use equals for equality
    System.out.println(hashSet.size());

    // TreeSet use comparTo for equality
    System.out.println(treeSet.size());
  }
}

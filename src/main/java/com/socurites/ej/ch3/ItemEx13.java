package com.socurites.ej.ch3;

/**
 * 13. clone 재정의는 주의해서 진행하라
 */
public class ItemEx13 {
  public static void main(String[] args) {
    PhoneNumber phoneNumber = new PhoneNumber(333, 123, 123);
    PhoneNumber cloned = phoneNumber.clone();

    System.out.println(phoneNumber == cloned);
    System.out.println(phoneNumber.areaCode);
    System.out.println(cloned.areaCode);
  }

  public static final class PhoneNumber implements Cloneable {
    private final short areaCode;
    private final short prefix;
    private final short lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
      this.areaCode = rangeCheck(areaCode, 999, "areaCode");
      this.prefix = rangeCheck(prefix, 999, "prefix");
      this.lineNum = rangeCheck(lineNum, 999, "lineNum");
    }

    private static short rangeCheck(int val, int max, String arg) {
      if (val < 0 || val > max) {
        throw new IllegalArgumentException(arg + ": " + val);
      }
      return (short) val;
    }

    @Override
    public PhoneNumber clone() {
      try {
        return (PhoneNumber) super.clone();
      } catch (CloneNotSupportedException e) {
        throw new AssertionError(); // never called;
      }
    }
  }
}

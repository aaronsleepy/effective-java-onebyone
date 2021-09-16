package com.socurites.ej.ch8.method;

/**
 * 53. 가변인수는 신중히 사용하라
 */
public class ItemEx53 {
    public static void main(String[] args) {
        printfEx();

        enumSetEx();
    }

    /**
     * Ref: Guide to EnumSet
     *      - https://www.baeldung.com/java-enumset
     */
    private static void enumSetEx() {
    }

    /**
     * Ref: Formatting Output with printf() in Java
     *      - https://www.baeldung.com/java-printstream-printf
     */
    private static void printfEx() {
        System.out.printf("Hello %s!%n", "World");
    }
}

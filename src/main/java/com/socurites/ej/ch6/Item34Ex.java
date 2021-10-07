package com.socurites.ej.ch6;

import javax.swing.text.html.Option;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 34. int 상수 대신 열거 타입을 사용하라
 */
public class Item34Ex {
    public static void main(String[] args) {
        double mass = 65;
        printSurfaceWeightsOf(mass);

        double x = 5.0;
        double y = 2.0;
        printOperationBy(x, y);
    }

    private static void printOperationBy(double x, double y) {
        for(Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    private static void printSurfaceWeightsOf(double mass) {
        for (Planet p : Planet.values()) {
            System.out.printf("%s에서의 무게는 %f이다.%n",
                    p, p.surfaceWeight(mass));
        }
    }

    static enum OperationBad {
        PLUS, MINUS, TIMES, DIVDE;

        public double apply(double x, double y) {
            switch (this) {
                case PLUS: return x + y;
                case MINUS: return x - y;
                case TIMES: return x * y;
                case DIVDE: return x / y;
            }
            throw new AssertionError(String.format("Ops not defiend : %s", this));
        }
    }

    // 1. Don't use switch
    // 2. toString을 재정의한다면, toString이 반환하는 문자열을 해당 열거 타입 상수로 변환해주는 fromString 메서드도 제공하라
    static enum Operation {
        PLUS("+") {
            public double apply(double x, double y) { return x + y;}
        },
        MINUS("-") {
            public double apply(double x, double y) { return x - y;}
        },
        TIMES("*") {
            public double apply(double x, double y) { return x * y;}
        },
        DIVIDE("/") {
            public double apply(double x, double y) { return x / y;}
        }
        ;

        private final String symboml;

        public abstract double apply(double x, double y);

        Operation(String symboml) { this.symboml = symboml; }


        @Override
        public String toString() {
            return symboml;
        }

        private static final Map<String, Operation> stringToEnum = Stream.of(values())
                .collect(Collectors.toMap(Object::toString, e-> e));

        public static Optional<Operation> fromString(String symboml) {
            return Optional.ofNullable(stringToEnum.get(symboml));
        }
    }

    static enum Planet {
        MERCURY(3.302e+23, 2.439e6),
        VENUS  (4.869e+24, 6.052e6),
        EARTH  (5.975e+24, 6.378e6),
        MARS   (6.419e+23, 3.393e6),
        JUPITER(1.899e+27, 7.149e7),
        SATURN (5.685e+26, 6.027e7),
        URANUS (8.683e+25, 2.556e7),
        NEPTUNE(1.024e+26, 2.477e7)
        ;

        private final double mass;
        private final double radius;
        private final double surfaceGravity;

        private static final double G = 6.67300E-11;


        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
            surfaceGravity = G * mass / (radius * radius);
        }

        public double mass() { return mass; };
        public double radius() { return radius; }

        public double surfaceWeight(double mass) {
            return mass * surfaceGravity;
        }
    }
}

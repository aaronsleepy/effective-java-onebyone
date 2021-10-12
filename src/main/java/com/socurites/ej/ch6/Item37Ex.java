package com.socurites.ej.ch6;

/**
 * 37. ordinal 인덱싱 대신 EnumMap을 사용하라
 */
public class Item37Ex {
    public static void main(String[] args) {
        System.out.println(PhaseBad.Transition.from(PhaseBad.SOLID, PhaseBad.LIQUID));
    }

    enum PhaseBad {
        SOLID, LIQUID, GAS;

        public enum Transition {
            MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

            private static final Transition[][] TRANSITIONS = {
                { null, MELT, SUBLIME },
                { FREEZE, null, BOIL},
                { DEPOSIT, CONDENSE, null}
            };

            public static Transition from(PhaseBad from, PhaseBad to) {
                return TRANSITIONS[from.ordinal()][to.ordinal()];
            }
        }
    }
}

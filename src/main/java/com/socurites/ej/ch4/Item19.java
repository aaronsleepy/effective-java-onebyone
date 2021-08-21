package com.socurites.ej.ch4;

import java.time.Instant;

/**
 * 19. 상속을 고려해 설계하고 문서화하라. 그러지 않았다면 상속을 금지하라
 */
public class Item19 {
    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();;
    }

    public static class Super {
        public Super() {
            System.out.println("Super.new");
            overrideMe();
        }

        protected void overrideMe() {
            System.out.println("Super.overrideMe");
        }
    }

    public static final class Sub extends Super {
        private final Instant instant;

        Sub() {
            System.out.println("Sub.new");
            instant = Instant.now();
        }

        @Override
        protected void overrideMe() {
            System.out.println("Sub.overrideMe");
            System.out.println(instant);
        }
    }

}

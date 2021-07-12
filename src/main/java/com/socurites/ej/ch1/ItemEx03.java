package com.socurites.ej.ch1;

import org.springframework.expression.spel.ast.Elvis;

/**
 * private 생성자나 열거타입으로 싱글턴임을 보증하라
 */
public class ItemEx03 {

}

// 싱글턴 생성 방식 #1: public static 멤버 필드
class ElvisOne {
  public static final ElvisOne INSTANCE = new ElvisOne();
  private ElvisOne() {}
}

// 싱글턴 생성방식 #2: public static factory 메서드
class ElvisTwo {
  private static final ElvisTwo INSTANCE = new ElvisTwo();
  private ElvisTwo() {}
  public static ElvisTwo getInstance() {return INSTANCE;}
}

// 싱글턴 생성방식 #3: enum
enum ElvisThree {
  INSTANCE;
}
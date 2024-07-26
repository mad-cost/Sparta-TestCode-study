package com.sparta.junit5practice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionTest {

  Calculator calculator;

  @BeforeEach
  void setUp() {
    // Calculator 객체 초기화
    calculator = new Calculator();
  }

  @Test
  @DisplayName("assertEquals")
  void test1() {
    Double result = calculator.operate(5, "/", 2);
    assertEquals(2.5, result); // assertEquals: import static method
  }

  @Test
  @Disabled // 비활성화
  @DisplayName("assertEquals - Supplier") //Supplier: 에러 메세지를 전달이 가능하다
  void test1_1() {
    Double result = calculator.operate(5, "/", 0);
    // 테스트 실패 시 메시지 출력 (new Supplier<String>())
    assertEquals(2.5, result, () -> "연산자 혹은 분모가 0이 아닌지 확인해보세요!");
  }

  @Test
  @DisplayName("assertNotEquals")
  void test1_2() {
    Double result = calculator.operate(5, "/", 0);
    assertNotEquals(2.5, result);
  }

  @Test
  @DisplayName("assertTrue 와 assertFalse")
  void test2() {
    assertTrue(calculator.validateNum(9));
    assertFalse(calculator.validateNum(0));
  }

  @Test
  @DisplayName("assertNotNull 과 assertNull")
  void test3() {
    Double result1 = calculator.operate(5, "/", 2);
    assertNotNull(result1);
    Double result2 = calculator.operate(5, "/", 0);
    assertNull(result2);
  }

  // Throw exception
  @Test
  @DisplayName("assertThrows")
  void test4() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
            calculator.operate(5, "?", 2));
    // 추가로 메세지 에러 확인도 가능하다
    assertEquals("잘못된 연산자입니다.", exception.getMessage());
  }



}

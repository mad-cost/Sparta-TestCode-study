package com.sparta.junit5practice;

import org.junit.jupiter.api.*;

public class BeforeAfterTest {

  // Alt + Insert -> SetUp Method
  @BeforeEach // 테스트 메서드 단위 별로 제일 먼저 실행
  void setUp() {
    System.out.println("각각의 테스트 코드가 실행되기 전에 수행");
  }

  // TearDown Method
  @AfterEach // 테스트 메서드 단위 별로 제일 마지막에 실행
  void tearDown() {
    System.out.println("각각의 테스트 코드가 실행된 후에 수행\n");
  }

  // BeforeClass Method
  @BeforeAll // 전체 실행시 제일 먼저 실행
  static void beforeAll() {
    System.out.println("모든 테스트 코드가 실행되기 전에 최초로 수행\n");
  }

  // AfterClass method
  @AfterAll // 전체 실행시 제일 마지막에 실행
  static void afterAll() {
    System.out.println("모든 테스트 코드가 실행된 후 마지막으로 수행\n");
  }

  @Test
  void test1(){
    System.out.println("테스트 코드 작성 1");
  }

  @Test
  void test2(){
    System.out.println("테스트 코드 작성 2");
  }

}

package ch.hslu.SW06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
  @Test
  void TestAdd() {
    Calculator c = new Calculator();
    assertEquals(4, c.Add(2, 2));
  }  

  @Test
  void TestSub() {
    Calculator c = new Calculator();
    assertEquals(0, c.Sub(2, 2));
  }

  @Test
  void TestMult() {
    Calculator c = new Calculator();
    assertEquals(4, c.Mult(2, 2));
  }

  @Test 
  void TestDiv() {
    Calculator c = new Calculator();
    assertEquals(1, c.Div(2, 2));
  }

  @Test 
  void TestDivByZero() {
    Calculator c = new Calculator();
    assertEquals(0, c.Div(2, 0));
  }

}

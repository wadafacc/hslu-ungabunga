package ch.hslu.SW03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MinMaxTest {
  @Test
  void TestMin() {
    final MinMax mm = new MinMax();
    assertEquals(5, mm.min(5, 10));
  }

  @Test
  void TestMax() {
    final MinMax mm = new MinMax();
    assertEquals(10, mm.max(5, 10));
  }

  @Test
  void TestMin3Args() {
    final MinMax mm = new MinMax();
    assertEquals(5, mm.min(5, 10, 7));
  }

  @Test
  void TestMax3Args() {
    final MinMax mm = new MinMax();
    assertEquals(10, mm.max(5, 10, 7));
  }
}

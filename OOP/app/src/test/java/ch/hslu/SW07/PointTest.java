package ch.hslu.SW07;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PointTest {

  Point point1;
  Point point2;
  Point point3;

  @BeforeEach
  void setup() {
    this.point1 = new Point(1, 1);
    this.point2 = new Point(123, -23);
    this.point3 = new Point(123, -23);
  }

  @Test
  void smallerTest() {
    assertEquals(point1.compareTo(point2), -1);
  }

  @Test
  void biggerTest() {
    assertEquals(point2.compareTo(point1), 1);
  }

  @Test
  void equalsTest() {
    assertEquals(point2.compareTo(point3), 0);
  }
}

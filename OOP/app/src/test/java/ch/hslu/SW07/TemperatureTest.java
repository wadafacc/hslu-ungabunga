package ch.hslu.SW07;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ch.hslu.SW02.TempUnit;

public class TemperatureTest {
  Temperature t1;
  Temperature t2;
  Temperature t3;

  @BeforeEach
  void setup() {
    this.t1 = new Temperature();
    this.t2 = new Temperature(20, TempUnit.CELSIUS);
    this.t3 = new Temperature(39033, TempUnit.FAHRENHEIT);
  }

  @Test
  void smallerTest() {
    assertEquals(t2.compareTo(t3), -1);
  }
  
  @Test
  void biggerTest() {
    assertEquals(t3.compareTo(t2), 1);
  }
  
  @Test
  void equalsTest() {
    assertEquals(t2.compareTo(t1), 0);
  }
}

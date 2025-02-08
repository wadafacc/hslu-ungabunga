package ch.hslu.oop.mep24hs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ShimmsTest {

  @Test
  void testValidRegNum() {
    int validRegNum = 123456;
    Shimms s1 = new Shimms(validRegNum, 0);
    assertEquals(s1.getRegistrationNumber(), validRegNum);
  }

  @Test
  void testInvalidRegNum() {
    int invalidRegNum = 1234567;
    assertThrows(InvalidParameterException.class,() -> new Shimms(invalidRegNum, 0));
  }

  @Test
  void testValidPayload() {
    float validPayload = 23456;
    Shimms s1 = new Shimms(0, validPayload);
    assertEquals(s1.getPayload(), validPayload);
  }


  @Test
  void testToString() {
    int regNum = 12345;
    String s = new Shimms(regNum, 0).toString();

    assertTrue(s.contains(String.valueOf(regNum)));
  }

  @Test
  void testInvalidPayload() {
    float invalidPayload = 234568;
    assertThrows(InvalidParameterException.class,() -> new Shimms(0, invalidPayload));
  }

  @Disabled
  void testMaxBruttoWeight() {
    float maxWeight = Shimms.EmptyWeight + Shimms.MaxPayload;
    Shimms s = new Shimms(0, Shimms.MaxPayload);
    assertEquals(s.getBruttoWeightInTons(), String.format("%.2f Tons", maxWeight / 1000));
  }
}

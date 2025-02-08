package ch.hslu.oop.mep24hs;

import java.security.InvalidParameterException;

public final class Shimms extends GueterWagen {
  static float EmptyWeight = 22900;  // kg
  static float MaxPayload = 57200;  // kg
  static int LengthTotal = 12030; // mm
  
  public Shimms(int registrationNumber, float payload) throws InvalidParameterException {
    super(registrationNumber, EmptyWeight, LengthTotal, payload, MaxPayload);
  }
}

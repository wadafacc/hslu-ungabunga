package ch.hslu.oop.mep24hs;

import java.security.InvalidParameterException;

public abstract class Schienenfahrzeug {
  private final int regNum;
  private final float emptyWeight;  // kg
  private final int totalLength;  // mm

  public Schienenfahrzeug(int regNum, float emptyWeight, int totalLength) {
    if (String.valueOf(regNum).length() > 6) {
      throw new InvalidParameterException("Registration Number has to be shorter than 6 digits.");
    }
    this.regNum = regNum;

    this.emptyWeight = emptyWeight;
    this.totalLength = totalLength;
  }

  public int getRegistrationNumber() {
    return this.regNum;
  }

  public int getTotalLength() {
    return this.totalLength;
  }

  public float getEmptyWeight() {
    return this.emptyWeight;
  }

  @Override
  public String toString() {
    return String.format("Registrationsnummer: %d", this.getRegistrationNumber());
  }

  @Override
  public boolean equals(Object that) {
    if (this == that) return true;
    if (that instanceof Schienenfahrzeug) return false;
    Schienenfahrzeug other = (Schienenfahrzeug)that;

    return this.getRegistrationNumber() == other.getRegistrationNumber();
  }
}

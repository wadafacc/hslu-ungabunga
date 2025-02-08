package ch.hslu.oop.mep24hs;

import java.security.InvalidParameterException;

public abstract class GueterWagen extends Schienenfahrzeug {
  private final float maxPayload;

  private float payload = 0.0f; // tons

  public GueterWagen(int regNum, float emptyWeight, int totalLength, float payload, float maxPayload) {
    super(regNum,emptyWeight,totalLength);

    this.maxPayload = maxPayload;
    this.setPayload(payload);
  }

  public float getPayload() {
    return this.payload;
  }
  
  public float getBruttoWeightInTons() {
    return (this.getPayload() + Shimms.EmptyWeight) / 1000;
  }

  public void setPayload(float payload) {
    if ((payload) > maxPayload) {
      throw new InvalidParameterException("Max Payload can't be above 57.2t.");
    }
    this.payload = payload;
  }
}

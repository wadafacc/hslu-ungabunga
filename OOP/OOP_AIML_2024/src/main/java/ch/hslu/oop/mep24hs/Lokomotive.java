package ch.hslu.oop.mep24hs;

public abstract class Lokomotive extends Schienenfahrzeug {
  private final float maxPullLoad;
  private final PropulsionType propulsionType;

  public Lokomotive(int regNum, float emptyWeight, int totalLength, float maxPullLoad, PropulsionType propType) {
    super(regNum, emptyWeight, totalLength);

    this.maxPullLoad = maxPullLoad;
    this.propulsionType = propType;
  }

  public PropulsionType getPropType() {
    return this.propulsionType;
  }

  public float getMaxPullLoad() {
    return this.maxPullLoad;
  }
}

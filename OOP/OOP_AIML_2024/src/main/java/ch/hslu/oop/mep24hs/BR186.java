package ch.hslu.oop.mep24hs;

public class BR186 extends Lokomotive {
  private static float MaxPullLoad = 2170000;
  private static int Length = 18950;
  private static PropulsionType PropType = PropulsionType.ELECTRIC;

  public BR186(int regNum, float emptyWeight) {
    super(regNum, emptyWeight, BR186.Length, BR186.MaxPullLoad, BR186.PropType);
  }


  @Override
  public String toString() {
    return String.format("Registrationsnummer: %d; Typ: %s; Länge: %d; Antriebstyp: %s; Maximale Zugkraft: %f;", 
    this.getRegistrationNumber(), BR186.class, this.getTotalLength(), this.getPropType(), this.getMaxPullLoad());
  }
}

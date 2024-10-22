package ch.hslu.SW04;

public class Motor implements ISwitchable {
  private boolean state = false;
  private int maxRpm;


  public Motor(boolean state, int maxRpm) {
    this.state = state;
    this.maxRpm = maxRpm;
  }

  @Override
  public void SwitchOn() {
    this.state = true;
  }

  @Override
  public void SwitchOff() {
    this.state = false;
  }

  @Override
  public boolean isOn() {
    return this.state == true;
  }
  
  public int getRpm() {
    if (this.state) {
      return (int)(Math.random() * maxRpm);
    }
    return 0;
  }

  @Override
  public boolean isOff() {
    return !this.state;
  }

}

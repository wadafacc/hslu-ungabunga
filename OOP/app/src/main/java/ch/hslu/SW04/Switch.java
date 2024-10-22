package ch.hslu.SW04;

public class Switch implements ISwitchable {
  private boolean state = false;


  @Override
  public void SwitchOn() {
    this.state = true;
  }

  @Override
  public void SwitchOff() {
    this.state = false;
  }

  @Override
  public boolean isOff() {
    // return this.state == true;
    return !this.state;
  }

  @Override
  public boolean isOn() {
    return this.state;
  }
  

  public void breakFuse() {
    
  }
}

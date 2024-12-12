package ch.hslu.SW10;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Car implements PropertyChangeListener {
  Motor motor;

  public Car() {
    motor = new Motor("OFF", 1600);

    motor.addPropertyChangeListener(this);
  }


  public void toggle() {
    this.motor.toggle();
  }


  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    System.out.println("PROPERTY CHANGED " + evt);
  }


}

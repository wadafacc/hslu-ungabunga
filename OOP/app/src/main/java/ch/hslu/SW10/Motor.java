package ch.hslu.SW10;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Motor{
  private String state = "OFF";
  private int maxRpm;
  PropertyChangeSupport pcs;


  public Motor(String state, int maxRpm) {
    this.state = state;
    this.maxRpm = maxRpm;
    pcs = new PropertyChangeSupport(this);
  }

  public void toggle() {
    String state = this.state == "OFF" ? this.state = "ON" : "OFF";
    this.state = state;

    pcs.firePropertyChange(state, this.state, state);
  }

  public String getState() {
    return this.state;
  }
  
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    if (listener == null) {
      throw new IllegalArgumentException("Listener darf nicht null sein.");
    }
    pcs.addPropertyChangeListener(listener);
  }

  public int getRpm() {
    if (this.state == "ON") {
      return (int)(Math.random() * maxRpm);
    }
    return 0;
  }
  
}

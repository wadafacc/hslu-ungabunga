package ch.hslu.SW08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import ch.hslu.SW02.TempUnit;

public class TemperatureList implements ITemperatureList {
  private ArrayList<Temperature> templist;

  public TemperatureList() {
    this.templist = new ArrayList<Temperature>();
  }

  public float getAvg() {
    Iterator<Temperature> it = this.templist.iterator();
    float avg = 0;
    while (it.hasNext()) {
      avg += it.next().getTemp(TempUnit.CELSIUS);
    }

    return avg / (float)this.templist.size();
  }

  public Temperature getMax() {
    if (this.templist.isEmpty()) {
      return null;
    }

    return Collections.max(this.templist);
  }

  @Override
  public void add(Temperature t) {
    this.templist.add(t);
  }

  @Override
  public void remove(int idx) {
    if (idx <= this.templist.size());
    this.templist.remove(idx);
  }

  @Override
  public void clear() {
    this.templist.clear();
  }

  @Override
  public int count() {
    return this.templist.size();
  }
  
}

package ch.hslu.oop.mep24hs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Gueterzug {
  private final Lokomotive locomotive;
  private ArrayList<GueterWagen> wagons = new ArrayList<GueterWagen>();


  public Gueterzug(Lokomotive locomotive) {
    this.locomotive = locomotive;
  }

  // returns true if added, false if not
  public boolean addWagon(GueterWagen w) {
    if (this.wagons.contains(w)) {
      return false;
    }
    return  this.wagons.add(w);
  }

  public float getTotalPullWeight() {
    float result = 0;
    Iterator<GueterWagen> it = this.wagons.iterator();

    while (it.hasNext()) {
      result += it.next().getBruttoWeightInTons();
    }
    return result;
  }
  
  public float getTotalLength() {
    float result = 0;
    Iterator<GueterWagen> it = this.wagons.iterator();

    while (it.hasNext()) {
      result += it.next().getTotalLength();
    }
    return result / 1000; // in m
  }

}

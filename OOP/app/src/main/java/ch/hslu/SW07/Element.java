package ch.hslu.SW07;

import java.util.Objects;

public class Element implements Comparable<Element> {
  private String name;
  private double solid;
  private double liquid;
  private double gas;

  /**
   * Creates a Person Object. 
   * @param n (Element name)
   * @param s (solid point (°C))
   * @param l (liquid point (°C))
   * @param g (gas point (°C))
  */
  public Element(String n, double s, double l, double g) {
    this.name = n;
    this.solid = s;
    this.liquid = l;
    this.gas = g;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(this.name, this.solid, this.liquid, this.gas);
  }

  @Override
  public int compareTo(Element other) {
    return Integer.compare(this.hashCode(), other.hashCode());
  }
}

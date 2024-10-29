package ch.hslu.SW07;

import java.util.Objects;

public class Point implements Comparable<Point>{
  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }
  public int getY() {
    return y;
  }

  public void setX(int n) {
    this.x = n;
  }

  public void setY(int n) {
    this.y = n;
  }

  @Override
  public final boolean equals(Object that) {
    if (this == that) {
      return true;
    }

    return that instanceof Point other && x == other.x && y == other.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.x, this.y);
  }

  @Override
  public int compareTo(Point other) {
    int xComp = Integer.compare(this.x, other.x);
    
    if (xComp != 0) {
      return xComp;
    }

    return Integer.compare(this.y, other.y);
  }
}

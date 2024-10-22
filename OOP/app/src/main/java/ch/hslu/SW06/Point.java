package ch.hslu.SW06;

public class Point {
  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  public Point(Point p) {
    this.x = p.x;
    this.y = p.y;
  } 

  public void moveRelative(int x, int y) {
    this.x += x;
    this.y += y;
  }

  public void moveRelative(Point p) {
    this.x += p.x;
    this.y += p.y;
  }

  public void moveRelative(double angle, double r) {
    this.x += r * Math.cos(angle);
    this.y += r * Math.sin(angle);
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
}

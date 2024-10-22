package ch.hslu.SW05;

public abstract class Shape {
  private int x;
  private int y;

  protected Shape(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void move(int newX, int newY) {
    this.x = newX;
    this.y = newY;
  }

  public abstract double getPerimeter();

  public abstract double getArea();

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }
  
}

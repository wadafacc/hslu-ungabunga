package ch.hslu.SW05;

public class Circle extends Shape{
  private int radius;

  protected Circle(int x, int y, int r) {
    super(x, y);
    radius = r;
  }

  @Override
  public double getPerimeter() {
    return (this.radius * 2) * Math.PI;
  }

  public int getDiameter() {
    return this.radius * 2;
  }

  @Override
  public double getArea() {
    return Math.pow(radius, 2) * Math.PI;
  }
  
}

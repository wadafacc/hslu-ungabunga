package ch.hslu.SW05;

// same as square, since they have the same "functionality"
public class Rect extends Shape {
  private int width;
  private int height;

  protected Rect(int x, int y, int w, int h) {
    super(x, y);

    this.width = w;
    this.height = h;
  }

  @Override
  public double getPerimeter() {
    return (double)((this.width * 2) + (this.height * 2));
  }

  @Override
  public double getArea() {
    return (double)(this.width * this.height);
  }
  
  public void changeDimensions(int w, int h) {
    this.width = w;
    this.height = h;
  } 

  public boolean isSquare() {
    return this.width == this.height;
  }

  public int getHeight() {
    return this.height;
  }

  public int getWidth() {
    return this.width;
  }
}

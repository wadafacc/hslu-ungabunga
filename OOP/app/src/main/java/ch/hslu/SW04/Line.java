package ch.hslu.SW04;

public class Line {
  private Point pointA;
  private Point pointB;

  public Line(Point a, Point b) {
    this.pointA = a;
    this.pointB = b;
  }

  
  public Point getStart() {
    return pointA;
  }

  public Point getEnd() {
    return pointB;
  }



  public void setStart(Point n) {
    this.pointA = n;
  }

  public void setEnd(Point n) {
    this.pointB = n;
  }
}

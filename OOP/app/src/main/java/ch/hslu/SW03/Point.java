package ch.hslu.SW03;

public class Point {
  private int x,y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getQuadrant() {
    float xSign = Math.signum(x);
    float ySign = Math.signum(y);

    if (xSign == 0 && ySign == 0) {
      return 0;
    }

    if (xSign > 0) {
      return ySign > 0 ? 1 : 4; 
    }
    else {
      return ySign > 0 ? 2 : 3;
    }
  }
}

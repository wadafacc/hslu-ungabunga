package ch.hslu.SW03;

public class MinMax {
  public int min(int a, int b) {
    return a >= b ? b : a;
  }

  public int max(int a, int b) {
    return a >= b ? a : b;
  }

  public int min(int a, int b, int c) {
    int ab = min(a,b);
    return min(ab,c);
  }

  public int max(int a, int b, int c) {
    int ab = max(a,b);
    return max(ab, c);
  } 
}

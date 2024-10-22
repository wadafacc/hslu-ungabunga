package ch.hslu.SW06;

public class Calculator implements ICalculator {

  @Override
  public int Add(int a, int b) {
    return a + b;
  }

  @Override
  public int Sub(int a, int b) {
    return a - b;
  }

  @Override
  public int Mult(int a, int b) {
    return a * b;
  }

  @Override
  public double Div(int a, int b) {
    return b != 0 ? (double)(a/b) : 0;
  }
}

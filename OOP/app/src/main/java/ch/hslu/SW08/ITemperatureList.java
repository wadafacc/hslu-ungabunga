package ch.hslu.SW08;

public interface ITemperatureList {
  public void add(Temperature t);
  public void remove(int idx);
  public void clear();
  public int count();
}

package ch.hslu;

import ch.hslu.SW02.*;
import ch.hslu.SW06.Point;

public class App {

  public static void main(String[] args) {
    SW06();


    int i = 3;
    System.out.println(6 / i + 1.3f);
  }

  public static void SW06() {
    Point p = new Point(2, 2);
    Point x = new Point(p);

    x.moveRelative(p);
    System.err.println(x.getX());
    System.err.println(x.getY());
  }

  public static void SW02() {
    Temperature temp = new Temperature(20f, TempUnit.CELSIUS);
    Temperature defaults = new Temperature();

    System.out.println("set vals: " + temp.getTemp());
    System.out.println("default: " + defaults.getTemp());
    System.out.println("set vals (F): " + temp.getTemp(TempUnit.FAHRENHEIT));
    
    Integer maxInt = Integer.MAX_VALUE;
    System.out.println("Int MAX" + maxInt);

    Float maxFloat = Float.MAX_VALUE + 1.0f;
    System.out.println("Float MAX + 1f" + maxFloat);

    Float test = Float.MAX_VALUE + 0.101e32f;
    System.out.println("Float MAX overflow" + test);
  }
}
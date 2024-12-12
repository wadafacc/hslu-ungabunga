package ch.hslu;

import java.util.Scanner;

import ch.hslu.SW02.*;
import ch.hslu.SW06.Point;
import ch.hslu.SW11.FileHandler;

public class App {

  public static void main(String[] args) {
    SW11();
  }

  public static void SW11() {
    var f = new FileHandler();

    f.Write();
    
    f.Read();
  }

  public static void SW09() {
    String input;
    Scanner scanner = new Scanner(System.in);
    do {
    System.out.println("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
    input = scanner.next();
    try {
      float value = Float.valueOf(input);
    } catch (Exception e) {
      System.err.println("Invalid Value!");
    }

    } while (!"exit".equals(input));
    System.out.println("Programm beendet.");
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
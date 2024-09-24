package org.main;

public class App {

  public static void main(String[] args) {
    Temperature temp = new Temperature(12f, Unit.CELSIUS);
    Temperature defaults = new Temperature();

    System.out.println("set vals: " + temp.getTemp());
    System.out.println("default: " + defaults.getTemp());

    Integer maxInt = Integer.MAX_VALUE;
    System.out.println(maxInt);

    Float maxFloat = Float.MAX_VALUE + 1.0f;
    System.out.println(maxFloat);

    Float test = Float.MAX_VALUE + 0.102e32f;
    System.out.println(test);
  }
}

package org.main;

public class App {

  public static void main(String[] args) {
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

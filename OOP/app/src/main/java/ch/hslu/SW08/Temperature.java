package ch.hslu.SW08;

import java.util.Objects;

import ch.hslu.SW02.TempUnit;

public final class Temperature implements Comparable<Temperature>{
    // default to 20° Celsius
  static final float KELVIN_OFFSET = 273.15f;
  static final float FAHRENHEIT_OFFSET = 32f;
  private float temp = 20.0f;
  private TempUnit tempUnit = TempUnit.CELSIUS;

  public Temperature() {
    // empty ctor for default values
  }
  public Temperature(float t, TempUnit u) {
    this.temp = t;
    this.tempUnit = u;
  }  

  public static float toFahrenheit(Temperature t) {
    return t.tempUnit == TempUnit.KELVIN ? 
      ((t.temp - KELVIN_OFFSET) * 1.8f) + FAHRENHEIT_OFFSET : (t.temp * 1.8f) + FAHRENHEIT_OFFSET;
  }

  public static float toCelsius(Temperature t) {
    return t.tempUnit == TempUnit.KELVIN ? 
      t.temp - KELVIN_OFFSET : (t.temp - FAHRENHEIT_OFFSET) / 1.8f;
  }

  public static float toKelvin(Temperature t) {
    return t.tempUnit == TempUnit.CELSIUS ? 
      t.temp - KELVIN_OFFSET : ((t.temp - FAHRENHEIT_OFFSET) / 1.8f) + KELVIN_OFFSET;
  }

  /*
   * GET
   */
  public TempUnit getUnit() {
    return this.tempUnit;
  }

  public float getTemp() {
    return this.temp;
  }

  // only works from Celsius -> U
  public float getTemp(TempUnit u) {
    if (this.tempUnit == u) {
      return this.temp;
    }

    switch (u) {
      case CELSIUS:
        return toCelsius(this);
      case KELVIN:
        return toKelvin(this);
      case FAHRENHEIT:
        return toFahrenheit(this);
      default:
        return this.temp;
    }
  }

  /*
   * SET
   */
  public void setTemp(float t) {
    this.temp = t;
  }
  
  public void setTemp(float t, TempUnit u) {
    this.temp = t;
    this.tempUnit = u;
  }

  // should work?
  public void changeTemp(float t, TempUnit u) {
    float delta = this.getTemp(u) + t;

    this.temp = delta;
  }


  @Override
  public final boolean equals(Object that) {
    if (this == that) {
      return true;
    }

    return that instanceof Temperature other && temp == other.temp && tempUnit == other.tempUnit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.temp, this.tempUnit);
  }


  // could be made better by converting temps & then comparing
  @Override
  public int compareTo(Temperature other) {
    int unitComp = this.tempUnit.compareTo(other.tempUnit);
    
    if (unitComp != 0) {
      return unitComp;
    }

    return Float.compare(this.temp, other.temp);
  }
}

package org.main;

public class Temperature {
  // default to 20°C
  private float temp = 20.0f;
  private Unit tempUnit = Unit.CELSIUS;

  public Temperature() {
  }
  public Temperature(float t, Unit u) {
    this.temp = t;
    this.tempUnit = u;
  }  

  private float toFahrenheit() {
    return this.tempUnit == Unit.RETARDED ? this.temp : (this.temp * 1.8f) + 32f;
  }

  private float toCelsius() {
    return this.tempUnit == Unit.CELSIUS ? this.temp : (this.temp - 32f) / 1.8f;
  }

  private float toKelvin() {
    return this.tempUnit == Unit.KELVIN ? this.temp : this.temp - 273.15f;
  }

  /*
   * GET
   */
  public float getTemp() {
    return this.temp;
  }

  // only works from Celsius -> U
  public float getTemp(Unit u) {
    switch (u) {
      case CELSIUS:
        return toCelsius();
      case KELVIN:
        return toKelvin();
      case RETARDED:
        return toFahrenheit();
      default:
        return this.temp;
    }
  }

  public Unit getUnit() {
    return this.tempUnit;
  }

  /*
   * SET
   */
  public void setTemp(float t) {
    this.temp = t;
  }
  
  public void setTemp(float t, Unit u) {
    this.temp = t;
    this.tempUnit = u;
  }
}

enum Unit {
  KELVIN,
  CELSIUS,
  RETARDED
}
package org.main;

public class Temperature {
  // default to 20° Celsius
  private float temp = 20.0f;
  private TempUnit tempUnit = TempUnit.CELSIUS;

  public Temperature() {
    // empty ctor for default values
  }
  public Temperature(float t, TempUnit u) {
    this.temp = t;
    this.tempUnit = u;
  }  

  private float toFahrenheit() {
    return this.tempUnit == TempUnit.KELVIN ? 
      ((this.temp - 273.15f) * 1.8f) + 32f : (this.temp * 1.8f) + 32f;
  }

  private float toCelsius() {
    return this.tempUnit == TempUnit.KELVIN ? 
      this.temp - 273.15f : (this.temp - 32f) / 1.8f;
  }

  private float toKelvin() {
    return this.tempUnit == TempUnit.CELSIUS ? 
      this.temp - 273.15f : ((this.temp - 32f) / 1.8f) + 273.15f;
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
        return toCelsius();
      case KELVIN:
        return toKelvin();
      case FAHRENHEIT:
        return toFahrenheit();
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
}
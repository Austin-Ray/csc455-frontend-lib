package com.csc.model;

public class Zipcode {
  private int zip;
  private String cityName;

  public Zipcode(int zip, String cityName) {
    this.zip = zip;
    this.cityName = cityName;
  }

  public int getZip() {
    return zip;
  }

  public String getCityName() {
    return cityName;
  }
}

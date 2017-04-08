package com.csc.model;

public class Vehicle {
  private int vid;
  private String type;
  private int mileage;

  public Vehicle(int vid, String type, int mileage) {
    this.vid = vid;
    this.type = type;
    this.mileage = mileage;
  }

  public int getVid() {
    return vid;
  }

  public String getType() {
    return type;
  }

  public int getMileage() {
    return mileage;
  }
}

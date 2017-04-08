package com.csc.model;

public class Parcel {
  private int pid;
  private float weight;
  private  String size;
  private float price;
  private int quantity;
  private int oid;

  public Parcel(int pid, float weight, String size, float price, int quantity, int oid) {
    this.pid = pid;
    this.weight = weight;
    this.size = size;
    this.price = price;
    this.quantity = quantity;
    this.oid = oid;
  }

  public int getPid() {
    return pid;
  }

  public float getWeight() {
    return weight;
  }

  public String getSize() {
    return size;
  }

  public float getPrice() {
    return price;
  }

  public int getQuantity() {
    return quantity;
  }

  public int getOid() {
    return oid;
  }
}

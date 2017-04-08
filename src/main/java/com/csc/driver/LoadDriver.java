package com.csc.driver;

public class LoadDriver {
  public static void load() {
    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();
    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}

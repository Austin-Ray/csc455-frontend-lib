package com.csc.model;

public class EmployeeRole {
  private int rid;
  private String description;

  public EmployeeRole(int rid, String description) {
    this.rid = rid;
    this.description = description;
  }

  public int getRid() {
    return rid;
  }

  public String getDescription() {
    return description;
  }
}

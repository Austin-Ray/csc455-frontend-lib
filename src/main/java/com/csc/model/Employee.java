package com.csc.model;

public class Employee extends User {
  private int roleid;
  private String vehicleType;
  private int eid;

  public Employee(String firstName, String lastName, String email, String password, int roleid,
                  String vehicleType) {
    this(firstName, lastName, email, password, -1, roleid, vehicleType, -1);
  }

  public Employee(String firstName, String lastName, String email, String password, int uid,
                  int roleid, String vehicleType, int eid) {
    super(uid, firstName, lastName, email, password);
    this.roleid = roleid;
    this.vehicleType = vehicleType;
    this.eid = eid;
  }

  public int getRoleid() {
    return roleid;
  }

  public String getVehicleType() {
    return vehicleType;
  }

  public int getEid() {
    return eid;
  }
}

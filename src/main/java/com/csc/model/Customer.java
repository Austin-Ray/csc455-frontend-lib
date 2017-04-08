package com.csc.model;

public class Customer extends User {
  private int cid;
  private String address;
  private int zipcode;
  private String phone;

  public Customer(String firstName, String lastName, String email, String password, String address,
                  int zipcode, String phone) {
    // Pass all the necessary information to the other constructors. Send -1 for uid and cid because
    // the customer will not have those yet. Those are from the database.
    this(firstName, lastName, email, password, -1, -1, address, zipcode, phone);
  }

  public Customer(String firstName, String lastName, String email, String password, int uid,
                  int cid, String address, int zipcode, String phone) {
    super(uid, firstName, lastName, email, password);
    this.cid = cid;
    this.address = address;
    this.zipcode = zipcode;
    this.phone = phone;
  }

  public int getCid() {
    return cid;
  }

  public String getAddress() {
    return address;
  }

  public int getZipcode() {
    return zipcode;
  }

  public String getPhone() {
    return phone;
  }

  @Override
  public String toString() {
    return "Customer{" +
        "firstName='" + firstName + '\'' +
        ", cid=" + cid +
        ", uid=" + uid +
        ", lastName='" + lastName + '\'' +
        ", address='" + address + '\'' +
        ", zipcode=" + zipcode +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}

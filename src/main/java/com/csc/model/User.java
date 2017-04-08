package com.csc.model;

public class User {

  protected int uid;

  protected String firstName;
  protected String lastName;
  protected String email;
  protected String password;

  public User(int uid, String firstName, String lastName, String email, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.uid = uid;
  }

  public int getUid() {
    return uid;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }
}

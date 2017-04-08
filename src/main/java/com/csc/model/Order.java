package com.csc.model;

import java.sql.Date;

public class Order {
  private int oid;
  private int cid;
  private int eid;
  private int originZip;
  private int actualZip;
  private int destinationZip;
  private String status;
  Date receiveDate;
  Date shippedDate;

  public Order(int oid, int cid, int eid, int originZip, int actualZip, int destinationZip,
               String status, Date receiveDate, Date shippedDate) {
    this.oid = oid;
    this.cid = cid;
    this.eid = eid;
    this.originZip = originZip;
    this.actualZip = actualZip;
    this.destinationZip = destinationZip;
    this.status = status;
    this.receiveDate = receiveDate;
    this.shippedDate = shippedDate;
  }

  public int getOid() {
    return oid;
  }

  public int getCid() {
    return cid;
  }

  public int getEid() {
    return eid;
  }

  public int getOriginZip() {
    return originZip;
  }

  public int getActualZip() {
    return actualZip;
  }

  public int getDestinationZip() {
    return destinationZip;
  }

  public String getStatus() {
    return status;
  }

  public Date getReceiveDate() {
    return receiveDate;
  }

  public Date getShippedDate() {
    return shippedDate;
  }
}

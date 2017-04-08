package com.csc.model;

public class Location {
  private int lid;
  private int oid;
  private int eid;
  private int vid;

  private int actualZip;

  public Location(int lid, int oid, int eid, int vid, int actualZip) {
    this.lid = lid;
    this.oid = oid;
    this.eid = eid;
    this.vid = vid;
    this.actualZip = actualZip;
  }

  public int getLid() {
    return lid;
  }

  public int getOid() {
    return oid;
  }

  public int getEid() {
    return eid;
  }

  public int getVid() {
    return vid;
  }

  public int getActualZip() {
    return actualZip;
  }
}

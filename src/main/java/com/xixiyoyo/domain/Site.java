package com.xixiyoyo.domain;

import java.util.List;

public class Site {

  private int sid;
  private String sname;
  private String simag;
  private int sstatus;
  private int isdel;

  private int num;

  private List<Reserved> reserveds;

  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }

  public List<Reserved> getReserveds() {
    return reserveds;
  }

  public void setReserveds(List<Reserved> reserveds) {
    this.reserveds = reserveds;
  }

  public int getSid() {
    return sid;
  }

  public void setSid(int sid) {
    this.sid = sid;
  }

  public String getSname() {
    return sname;
  }

  public void setSname(String sname) {
    this.sname = sname;
  }

  public String getSimag() {
    return simag;
  }

  public void setSimag(String simag) {
    this.simag = simag;
  }

  public int getSstatus() {
    return sstatus;
  }

  public void setSstatus(int sstatus) {
    this.sstatus = sstatus;
  }

  public int getIsdel() {
    return isdel;
  }

  public void setIsdel(int isdel) {
    this.isdel = isdel;
  }

  @Override
  public String toString() {
    return "Site{" +
            "sid=" + sid +
            ", sname='" + sname + '\'' +
            ", simag='" + simag + '\'' +
            ", sstatus=" + sstatus +
            ", isdel=" + isdel +
            ", num=" + num +
            ", reserveds=" + reserveds +
            '}';
  }
}

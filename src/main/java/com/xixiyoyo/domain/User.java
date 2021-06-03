package com.xixiyoyo.domain;

import java.util.List;

public class User {

  private int uid;
  private int rid;
  private String uname;
  private String password;
  private String phoneNum;
  private String uimag;
  private String address;
  private int ustatus;

  private Role role;
  private List<Reserved> reserveds;

  public List<Reserved> getReserveds() {
    return reserveds;
  }

  public void setReserveds(List<Reserved> reserveds) {
    this.reserveds = reserveds;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  public int getRid() {
    return rid;
  }

  public void setRid(int rid) {
    this.rid = rid;
  }

  public String getUname() {
    return uname;
  }

  public void setUname(String uname) {
    this.uname = uname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhoneNum() {
    return phoneNum;
  }

  public void setPhoneNum(String phoneNum) {
    this.phoneNum = phoneNum;
  }

  public String getUimag() {
    return uimag;
  }

  public void setUimag(String uimag) {
    this.uimag = uimag;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getUstatus() {
    return ustatus;
  }

  public void setUstatus(int ustatus) {
    this.ustatus = ustatus;
  }

  @Override
  public String toString() {
    return "User{" +
            "uid=" + uid +
            ", rid=" + rid +
            ", uname='" + uname + '\'' +
            ", password='" + password + '\'' +
            ", phoneNum='" + phoneNum + '\'' +
            ", uimag='" + uimag + '\'' +
            ", address='" + address + '\'' +
            ", ustatus=" + ustatus +
            '}';
  }
}

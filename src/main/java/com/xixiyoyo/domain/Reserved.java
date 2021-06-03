package com.xixiyoyo.domain;

import java.time.LocalDateTime;
import java.util.Date;

public class Reserved {
  private int reid;
  private int uid;
  private int sid;
  private Date stime;
  private Date etime;
  private int rstatus;
  private int isdel;

  private User user;
  private Site site;


  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Site getSite() {
    return site;
  }

  public void setSite(Site site) {
    this.site = site;
  }

  public int getUid() {
    return uid;
  }

  public void setUid(int uid) {
    this.uid = uid;
  }

  public int getSid() {
    return sid;
  }

  public void setSid(int sid) {
    this.sid = sid;
  }

  public int getReid() {
    return reid;
  }

  public void setReid(int reid) {
    this.reid = reid;
  }

  public Date getStime() {
    return stime;
  }

  public void setStime(Date stime) {
    this.stime = stime;
  }

  public Date getEtime() {
    return etime;
  }

  public void setEtime(Date etime) {
    this.etime = etime;
  }

  public int getRstatus() {
    return rstatus;
  }

  public void setRstatus(int rstatus) {
    this.rstatus = rstatus;
  }

  public int getIsdel() {
    return isdel;
  }

  public void setIsdel(int isdel) {
    this.isdel = isdel;
  }

  @Override
  public String toString() {
    return "Reserved{" +
            "reid=" + reid +
            ", uid=" + uid +
            ", sid=" + sid +
            ", stime=" + stime +
            ", etime=" + etime +
            ", rstatus=" + rstatus +
            ", isdel=" + isdel +
            ", user=" + user +
            ", site=" + site +
            '}';
  }
}

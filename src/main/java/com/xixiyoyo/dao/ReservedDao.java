package com.xixiyoyo.dao;


import com.xixiyoyo.domain.Reserved;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservedDao {

    @Select("select * from reserved where sid=#{sid}")
    @Results(id = "Re-us",value = {
            @Result(id = true,property = "reid",column = "reid"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "sid",column = "sid"),
            @Result(property = "stime",column = "stime"),
            @Result(property = "etime",column = "etime"),
            @Result(property = "rstatus",column = "rstatus"),
            @Result(property = "isdel",column = "isdel"),
            @Result(property = "user",column = "uid",one = @One(select = "com.xixiyoyo.dao.UserDao.findUserByUid"))
    })
    public List<Reserved> findAllReserveById(int sid);

    @Select("select * from reserved where sid=#{sid} and isdel=0")
    @Results(id = "Re-usL",value = {
            @Result(id = true,property = "reid",column = "reid"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "sid",column = "sid"),
            @Result(property = "stime",column = "stime"),
            @Result(property = "etime",column = "etime"),
            @Result(property = "rstatus",column = "rstatus"),
            @Result(property = "isdel",column = "isdel"),
            @Result(property = "user",column = "uid",one = @One(select = "com.xixiyoyo.dao.UserDao.findUserByUid"))
    })
    public List<Reserved> findAllReserveByIdL(int sid);

    @Select("select count(*) from reserved where sid=#{sid} and isdel=0")
    public int findRow(int sid);

    @Insert("insert into reserved (uid,sid,stime,etime) value(#{uid},#{sid},#{stime},#{etime})")
    public void addReserved(Reserved reserved);

    @Select("select * from reserved where isdel=0")
    @Results(id="re-s",value = {
            @Result(id = true,property = "reid",column = "reid"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "sid",column = "sid"),
            @Result(property = "stime",column = "stime"),
            @Result(property = "etime",column = "etime"),
            @Result(property = "rstatus",column = "rstatus"),
            @Result(property = "isdel",column = "isdel"),
            @Result(property = "site",column = "sid",one = @One(select = "com.xixiyoyo.dao.SiteDao.findSiteBySid")),
            @Result(property = "user",column = "uid",one = @One(select = "com.xixiyoyo.dao.UserDao.findUserByUid"))
    })
    public List<Reserved> findAll();

    @Update("update reserved set sid=#{sid},stime=#{stime},etime=#{etime},rstatus=#{rstatus},isdel=#{isdel} where reid=#{reid}")
    public void modityre(Reserved reserved);

    @Select("select * from reserved where reid=#{reid}")
    @Results(id="re-si",value = {
            @Result(id = true, property = "reid", column = "reid"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "sid", column = "sid"),
            @Result(property = "stime", column = "stime"),
            @Result(property = "etime", column = "etime"),
            @Result(property = "rstatus", column = "rstatus"),
            @Result(property = "isdel", column = "isdel"),
            @Result(property = "user", column = "uid", one = @One(select = "com.xixiyoyo.dao.UserDao.findUserByUid"))
    })
    public Reserved getReById(int reid);

    @Select("select * from reserved where uid=#{uid} and isdel=0")
    @Results(id="re-u",value = {
            @Result(id = true,property = "reid",column = "reid"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "sid",column = "sid"),
            @Result(property = "stime",column = "stime"),
            @Result(property = "etime",column = "etime"),
            @Result(property = "rstatus",column = "rstatus"),
            @Result(property = "isdel",column = "isdel"),
            @Result(property = "site",column = "sid",one = @One(select = "com.xixiyoyo.dao.SiteDao.findSiteBySid"))
    })
    public List<Reserved> getReByUid(int uid);


}

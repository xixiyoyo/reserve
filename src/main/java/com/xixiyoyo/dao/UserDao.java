package com.xixiyoyo.dao;


import com.xixiyoyo.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

  @Select("select * from user where ustatus=0")
  @Results(id = "us_r",value = {

          @Result(id = true,property = "uid",column = "uid"),
          @Result(property = "rid",column = "rid"),
          @Result(property = "uname",column = "uname"),
          @Result(property = "password",column = "password"),
          @Result(property = "phoneNum",column = "phoneNum"),
          @Result(property = "uimag",column = "uimag"),
          @Result(property = "address",column = "address"),
          @Result(property = "ustatus",column = "ustatus"),
          @Result(property = "role",column = "rid",one = @One(select = "com.xixiyoyo.dao.RoleDao.findRoleByRid"))
  })
  public List<User> findAllUser();

  @Select("select * from user where uname=#{uname} and password=#{password} and ustatus=0")
  public User login(User user);

  @Insert("insert into user(rid,uname,password,phoneNum,uimag,address) value(#{rid},#{uname},#{password},#{phoneNum},'../images/shawn.jpg',#{address})")
  public void addUser(User user);

  @Select("select * from user where uid=#{uid} and ustatus=0")
  @Results(id = "u_r",value = {

          @Result(id = true,property = "uid",column = "uid"),
          @Result(property = "rid",column = "rid"),
          @Result(property = "uname",column = "uname"),
          @Result(property = "password",column = "password"),
          @Result(property = "phoneNum",column = "phoneNum"),
          @Result(property = "uimag",column = "uimag"),
          @Result(property = "address",column = "address"),
          @Result(property = "ustatus",column = "ustatus"),
          @Result(property = "role",column = "rid",one = @One(select = "com.xixiyoyo.dao.RoleDao.findRoleByRid"))
  })
  public User findUserByUid(int uid);

  @Update("update user set uname=#{uname},password=#{password},phoneNum=#{phoneNum} where uid=#{uid}")
  public void updateUser(User user);

  @Select("select * from user where uid=#{uid} and ustatus=0")
  @Results(id = "u_re",value = {
          @Result(id = true,property = "uid",column = "uid"),
          @Result(property = "rid",column = "rid"),
          @Result(property = "uname",column = "uname"),
          @Result(property = "password",column = "password"),
          @Result(property = "phoneNum",column = "phoneNum"),
          @Result(property = "uimag",column = "uimag"),
          @Result(property = "address",column = "address"),
          @Result(property = "ustatus",column = "ustatus"),
          @Result(property = "reserveds",column = "uid",many = @Many(select = "com.xixiyoyo.dao.ReservedDao.getReByUid"))

  })
  public User findReByUser(int uid);




}

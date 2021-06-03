package com.xixiyoyo.controller;


import com.xixiyoyo.domain.User;
import com.xixiyoyo.service.SiteService;
import com.xixiyoyo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
@Transactional()
public class UserController {

  @Autowired
  private UserService userService;


  @RequestMapping("/findAll")
  public String findAll(Model model){
    List<User> allUser = userService.findAllUser();
    model.addAttribute("userList",allUser);
    return "userList";
  }
  @RequestMapping("/login")
  public String login(User user, HttpSession session){
//    System.out.println("213");
    User user1 = userService.login(user);
    if(user1 != null){
      session.setAttribute("user",user1);
      return "redirect:/site/findAllSite";
    }
    return "login";
  }
  @RequestMapping("/save")
  public String adduser(User user){
    userService.save(user);
    return "redirect:/site/findAllSite";
  }

  @RequestMapping("/findInfo")
  public String findInfo(HttpSession session,Model model){
    User user = (User) session.getAttribute("user");
    User info = userService.findInfo(user.getUid());
    //System.out.println(info);
    model.addAttribute("user",info);
    return "personal";
  }

  @RequestMapping("/quit")
  public String quit(HttpSession session){
    session.setAttribute("user",null);
    return "login";
  }

  @RequestMapping("/updateUser")
  @ResponseBody
  public String updateUser(User user,String oldpwd){
    User info = userService.findInfo(user.getUid());
    if(oldpwd.equals(info.getPassword())){
      info.setUname(user.getUname());
      info.setPassword(user.getPassword());
      info.setPhoneNum(user.getPhoneNum());
      userService.changeInfo(info);
      return "true";
    }else {
      return "false";
    }

  }

  @RequestMapping("/carbu")
  public String checkAllReByUser(HttpSession session,Model model){
    User user = (User) session.getAttribute("user");
    User allReByUser = userService.findAllReByUser(user.getUid());
    model.addAttribute("allRe",allReByUser);
    return "reserveListByUser";
  }

  @RequestMapping("/register")
  public String register(){
    return "register";
  }

  @RequestMapping("/addUser")
  public String addUser(User user,Model model){
    System.out.println(user);
    userService.save(user);
    model.addAttribute("uname",user.getUname());
    return "login";
  }


}

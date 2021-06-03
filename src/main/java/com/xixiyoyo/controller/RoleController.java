package com.xixiyoyo.controller;

import com.xixiyoyo.dao.RoleDao;
import com.xixiyoyo.domain.Role;
import com.xixiyoyo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("")
    public String getRole(Model model){
        List<Role> allRole = roleService.getAllRole();
        model.addAttribute("allRole",allRole);
        return "register";
    }

}

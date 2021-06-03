package com.xixiyoyo.controller;

import com.xixiyoyo.domain.Reserved;
import com.xixiyoyo.domain.Site;
import com.xixiyoyo.domain.User;
import com.xixiyoyo.service.ReservedService;
import com.xixiyoyo.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/reserved")
@Transactional
public class ReservedController {

    @Autowired
    private SiteService siteService;

    @Autowired
    private ReservedService reservedService;

    @RequestMapping("/addReLog")
    public String addReserved(int sid, Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        Site site = siteService.querySiteBySid(sid);
        model.addAttribute("user",user);
        model.addAttribute("site",site);

        return "reserveAdd";
    }

    @RequestMapping("/addRe")
    @ResponseBody
    public String addReservedFin(Reserved reserved,HttpSession session){
        User user = (User) session.getAttribute("user");
        reserved.setUid(user.getUid());
        reservedService.addReserved(reserved);
        return "ok";
    }

    @RequestMapping("/showAll")
    public String showAll(Model model){
        List<Reserved> reservedList = reservedService.findAll();
        model.addAttribute("reservedList",reservedList);

        return "allRelist";
    }

    @RequestMapping("/delRe")
    @ResponseBody
    public void delRe(int reid){
        Reserved reserved = reservedService.getReById(reid);
        reserved.setIsdel(2);
        reservedService.updateRe(reserved);
    }

    @RequestMapping("/updateRe")
    public String updateRe(int reid,Model model){
        Reserved reserved = reservedService.getReById(reid);
        List<Site> sites = siteService.queryAllSite();
        model.addAttribute("reserved",reserved);
        model.addAttribute("allSite",sites);
        return "updateReserved";
    }

    @RequestMapping("/updateReF")
    @ResponseBody
    public String updateReF(Reserved reserved){
        Reserved reById = reservedService.getReById(reserved.getReid());
        reById.setSid(reserved.getSid());
        reById.setStime(reserved.getStime());
        reById.setEtime(reserved.getEtime());
        reservedService.updateRe(reById);
        return "ok";
    }






}

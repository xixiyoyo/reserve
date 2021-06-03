package com.xixiyoyo.controller;


import com.xixiyoyo.domain.Reserved;
import com.xixiyoyo.domain.Site;
import com.xixiyoyo.service.ReservedService;
import com.xixiyoyo.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/site")
@Transactional
public class SiteController {

    @Autowired
    private SiteService siteService;
    @Autowired
    private ReservedService reservedService;

    @RequestMapping("/findAllSite")
    public String findAllSite(){
//        List<Site> siteList = siteService.queryAllSite();
//        session.setAttribute("siteList",siteList);
        return "index";
    }

    @RequestMapping("/findAllReBySi")
    public String findAllReBySite(int sid,Model model){
        Site site = siteService.queryAllReBySite(sid);
        //site.getReserveds().forEach(list-> System.out.println("list = " + list));
        model.addAttribute("site",site);
        return "reserveList";
    }

    @RequestMapping("/checkTime")
    @ResponseBody
    public String checkDate(Reserved reserved){
        System.out.println(reserved);
        String msg = "0";
        Site site = siteService.queryAllReBySite(reserved.getSid());
        if(reserved.getReid() != 0){
            Reserved reById = reservedService.getReById(reserved.getReid());
            reById.setStime(new Date());
            reById.setEtime(new Date());
            reservedService.updateRe(reById);
        }
        if(reserved.getStime().before(new Date())||reserved.getEtime().before(new Date())){
            msg = "3";
        }else if(reserved.getStime().after(reserved.getEtime())||reserved.getEtime().before(reserved.getStime())){
                    msg = "2";
                }else {
                    if(site.getReserveds().size() == 0){
                        msg = "0";
                    }else {
                        for (Reserved siteReserved : site.getReserveds()) {
                            if(reserved.getStime() == siteReserved.getStime()||reserved.getStime() == siteReserved.getEtime()){
                                msg = "1";
                            }else if(reserved.getEtime() == siteReserved.getStime()||reserved.getEtime() == siteReserved.getEtime()){
                                msg =  "1";
                            }else {
                                if(siteReserved.getStime().after(reserved.getStime())&&siteReserved.getStime().before(reserved.getEtime())||siteReserved.getEtime().after(reserved.getStime())&&siteReserved.getEtime().before(reserved.getEtime())||reserved.getStime().after(siteReserved.getStime())&&reserved.getStime().before(siteReserved.getEtime())||reserved.getEtime().after(siteReserved.getStime())&&reserved.getEtime().before(siteReserved.getEtime())){
                                    msg =  "1";
                                }else {
                                    msg =  "0";
                                }
                            }
                        }

                    }

                }

        return msg;
    }

    @RequestMapping("/getRow")
    public String getReRow(Model model){
        List<Site> sites = siteService.queryAllSite();
        model.addAttribute("sites",sites);
        return "welcome";
    }

    @RequestMapping("/allSite")
    public String getAllSite(Model model){
        List<Site> sites = siteService.queryAllSite();
        model.addAttribute("allSite",sites);
        return "reserveAdd2";
    }

    @RequestMapping("/locateSite")
    public String AllSite(Model model){
        List<Site> siteList = siteService.queryAllSiteF();
        model.addAttribute("siteList",siteList);
        //System.out.println(siteList);
        return "siteList";
    }

    @RequestMapping("/changeStatus")
    @ResponseBody
    public String changeStatus(int sid){
        Site site = siteService.querySiteBySidF(sid);
        //System.out.println(site.getIsdel());
        if(site.getIsdel() == 0){
            site.setIsdel(1);
            siteService.updateSite(site);
        }else if(site.getIsdel() == 1) {
            site.setIsdel(0);
            siteService.updateSite(site);
        }
        //System.out.println(site.getIsdel());
        return "ok";
    }

    @RequestMapping("/updateSite")
    public String updateSiteInfo(int sid,Model model){
        Site site = siteService.querySiteBySidF(sid);
        model.addAttribute("site",site);
        return "updateSiteInfo";
    }

    @RequestMapping("/updatePhone")
    public String updatePhoto(Site site, MultipartFile file) throws IOException {
        System.out.println(file.toString());
        String s = siteService.setPhoto(file, site);
        if(s.equals("true")){
            return "success";
        }else if(s.equals("false")){
            return "error";
        }
        return "error";
    }


}

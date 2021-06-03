package com.xixiyoyo.interceptor;

import com.xixiyoyo.domain.Reserved;
import com.xixiyoyo.domain.Site;
import com.xixiyoyo.service.ReservedService;
import com.xixiyoyo.service.SiteService;
import com.xixiyoyo.service.impl.ReservedServiceimpl;
import com.xixiyoyo.service.impl.SiteServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

public class Timeinterceptor implements HandlerInterceptor {

    @Autowired
    private ReservedService reservedService;
    @Autowired
    private SiteService siteService;



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //List<Reserved> reservedList = reservedService.findAll();
        List<Site> allSiteAndRe = siteService.findAllSiteAndRe();
        int num = 0;
        Date nowTime = new Date();
        System.out.println(nowTime);
        for (Site site : allSiteAndRe) {
            if(site.getReserveds().size() == 0){
                site.setSstatus(0);
                siteService.updateSite(site);
            }else {
                for (Reserved reserved : site.getReserveds()) {
                    if(reserved.getIsdel() != 2){
                        if(nowTime.after(reserved.getStime())&&nowTime.before(reserved.getEtime())){
                            reserved.setRstatus(1);
                            reservedService.updateRe(reserved);
                            //System.out.println(reserved);
//                        site.setSstatus(1);
//                        siteService.updateSite(site);
                            //System.out.println(site);
                        }else if(nowTime.after(reserved.getEtime())){
                            reserved.setRstatus(0);
                            reserved.setIsdel(1);
                            reservedService.updateRe(reserved);
//                        site.setSstatus(0);
//                        siteService.updateSite(site);
                            //System.out.println(reserved);
                        }else if(nowTime.before(reserved.getStime())){
                            reserved.setRstatus(0);
                            reserved.setIsdel(0);
                            reservedService.updateRe(reserved);
                        }
                    }

                }
            }
        }
        for (Site site : allSiteAndRe) {
            for (Reserved reserved : site.getReserveds()) {
                if(reserved.getRstatus() == 1){
                    site.setSstatus(1);
                    siteService.updateSite(site);
                    break;
                }
                num++;
            }
            if(num == site.getReserveds().size()){
                site.setSstatus(0);
                siteService.updateSite(site);
                num = 0;
            }
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

package com.xixiyoyo.service.impl;


import com.xixiyoyo.dao.SiteDao;
import com.xixiyoyo.domain.Site;
import com.xixiyoyo.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;

@Service
public class SiteServiceimpl implements SiteService {
    @Autowired
    private SiteDao siteDao;

    @Override
    public List<Site> queryAllSite() {
        return siteDao.findAllSite();
    }

    @Override
    public List<Site> queryAllSiteF() {
        return siteDao.findAllSiteF();
    }

    @Override
    public Site queryAllReBySite(int id) {
        return siteDao.findSiteAllReById(id);
    }

    @Override
    public Site querySiteBySid(int sid) {
        return siteDao.findSiteBySid(sid);
    }

    @Override
    public Site querySiteBySidF(int sid) {
        return siteDao.findSiteByIdF(sid);
    }

    @Override
    public void updateSite(Site site) {
        siteDao.moditySite(site);
    }

    @Override
    public List<Site> findAllSiteAndRe() {
        return siteDao.findAllsiteAndRe();
    }

    @Override
    public String setPhoto(MultipartFile file, Site site) throws IOException {
        String filePath = "E:/ssm球馆项目/reserve/src/main/webapp/images/";
        if(!file.isEmpty()){
            Site site1 = siteDao.findSiteByIdF(site.getSid());
            //String simagPath = site1.getSimag();
            long l = System.currentTimeMillis();

            //String newPath = filePath+l+file.getOriginalFilename();

            //String newPath1 = "../images/"+l+file.getOriginalFilename();

            String newPath = filePath+file.getOriginalFilename();

            String newPath1 = "../images/"+file.getOriginalFilename();

            site1.setSname(site.getSname());
            site1.setSimag(newPath1);
            siteDao.moditySite(site1);
            File file1 = new File(filePath);
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newPath));
            bos.write(file.getBytes());
            bos.flush();
            return "true";

        }else {
            return "false";
        }

    }
}

package com.xixiyoyo.service;

import com.xixiyoyo.domain.Site;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface SiteService {

    public List<Site> queryAllSite();

    public List<Site> queryAllSiteF();

    public Site queryAllReBySite(int id);

    public Site querySiteBySid(int sid);
    public Site querySiteBySidF(int sid);

    public void updateSite(Site site);

    public List<Site> findAllSiteAndRe();

    public String setPhoto(MultipartFile file,Site site) throws IOException;
}

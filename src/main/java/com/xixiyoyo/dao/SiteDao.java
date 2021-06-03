package com.xixiyoyo.dao;


import com.xixiyoyo.domain.Site;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteDao {
    //包括isdel为1的
    @Select("select * from site")
    public List<Site> findAllSiteF();

    @Select("select * from site where isdel=0")
    @Results(id = "allRow",value = {
            @Result(id = true,property = "sid",column = "sid"),
            @Result(property = "sname",column = "sname"),
            @Result(property = "simag",column = "simag"),
            @Result(property = "sstatus",column = "sstatus"),
            @Result(property = "isdel",column = "isdel"),
            @Result(property = "num",column = "sid",one = @One(select = "com.xixiyoyo.dao.ReservedDao.findRow"))
    })
    public List<Site> findAllSite();

    @Select("select * from site where isdel=0")
    @Results(id = "allSiteAndRe",value = {
            @Result(id = true,property = "sid",column = "sid"),
            @Result(property = "sname",column = "sname"),
            @Result(property = "simag",column = "simag"),
            @Result(property = "sstatus",column = "sstatus"),
            @Result(property = "isdel",column = "isdel"),
            @Result(property = "reserveds",column = "sid",many = @Many(select = "com.xixiyoyo.dao.ReservedDao.findAllReserveById"))
    })
    public List<Site> findAllsiteAndRe();

    @Select("SELECT * FROM `site`where isdel=0 and sid=#{sid}")
    @Results(id = "checkAllRe",value = {
            @Result(id = true,property = "sid",column = "sid"),
            @Result(property = "sname",column = "sname"),
            @Result(property = "simag",column = "simag"),
            @Result(property = "sstatus",column = "sstatus"),
            @Result(property = "isdel",column = "isdel"),
            @Result(property = "reserveds",column = "sid",many = @Many(select = "com.xixiyoyo.dao.ReservedDao.findAllReserveByIdL"))
    })
    public Site findSiteAllReById(int sid);

    //能够查询isdel为1的site
    @Select("SELECT * FROM `site`where sid=#{sid}")
    public Site findSiteByIdF(int sid);

    @Select("select count(*) from site")
    public int findRow();

    @Select("SELECT * FROM `site`where isdel=0 and sid=#{sid}")
    public Site findSiteBySid(int sid);

    @Update("update site set simag=#{simag},sstatus=#{sstatus},isdel=#{isdel} where sid=#{sid}")
    public void moditySite(Site site);
}

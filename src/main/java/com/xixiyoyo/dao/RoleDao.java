package com.xixiyoyo.dao;


import com.xixiyoyo.domain.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {

    @Select("select * from role where rid=#{rid}")
    public Role findRoleByRid(int rid);

    @Select("select * from role")
    public List<Role> getAllRole();

}

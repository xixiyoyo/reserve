package com.xixiyoyo.service.impl;


import com.xixiyoyo.dao.RoleDao;
import com.xixiyoyo.domain.Role;
import com.xixiyoyo.domain.User;
import com.xixiyoyo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceimpl implements RoleService {

    @Autowired
    private RoleDao roleDao;


    @Override
    public List<Role> getAllRole() {
        return roleDao.getAllRole();
    }
}

package com.xixiyoyo.service;

import com.xixiyoyo.dao.RoleDao;
import com.xixiyoyo.domain.Role;
import com.xixiyoyo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface RoleService {

    public List<Role> getAllRole();


}

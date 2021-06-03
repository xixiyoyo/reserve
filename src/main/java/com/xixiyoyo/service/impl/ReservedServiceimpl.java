package com.xixiyoyo.service.impl;


import com.xixiyoyo.dao.ReservedDao;
import com.xixiyoyo.domain.Reserved;
import com.xixiyoyo.service.ReservedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservedServiceimpl implements ReservedService {

    @Autowired
    private ReservedDao reservedDao;

    @Override
    public void addReserved(Reserved reserved) {
        reservedDao.addReserved(reserved);
    }

    @Override
    public List<Reserved> findAll() {
        return reservedDao.findAll();
    }

    @Override
    public void updateRe(Reserved reserved) {
        reservedDao.modityre(reserved);
    }

    @Override
    public int findRow(int sid) {
        return reservedDao.findRow(sid);
    }

    @Override
    public Reserved getReById(int reid) {
        return reservedDao.getReById(reid);
    }


}

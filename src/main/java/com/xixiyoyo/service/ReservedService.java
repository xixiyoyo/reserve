package com.xixiyoyo.service;

import com.xixiyoyo.domain.Reserved;

import java.util.List;

public interface ReservedService {

    public void addReserved(Reserved reserved);
    public List<Reserved> findAll();
    public void updateRe(Reserved reserved);
    public int findRow(int sid);
    public Reserved getReById(int reid);

}

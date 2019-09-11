package com.yuhan.service.impl;

import com.yuhan.dao.VipDao;
import com.yuhan.entities.Vip;
import com.yuhan.service.VipService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VipServiceImpl implements VipService {

    @Autowired
    VipDao vipDao;


    @Override
    public int addVip(Vip vip) {
        return  vipDao.addVip(vip);
    }
}

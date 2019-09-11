package com.yuhan.service.impl;

import com.yuhan.dao.IntegralDao;
import com.yuhan.entities.Integral;
import com.yuhan.service.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class IntegralServiceImpl implements IntegralService {
    @Autowired
    IntegralDao integralDao;

    @Override
    public Integral findByMerchandiseId(int merchandiseId) {
        return integralDao.findByMerchandiseId(merchandiseId);
    }

    @Override
    public List<Integral> findBy(int first, int end) {
        return integralDao.findBy(first,end);
    }
}

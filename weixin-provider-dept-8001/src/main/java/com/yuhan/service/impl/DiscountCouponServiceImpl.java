package com.yuhan.service.impl;

import com.yuhan.dao.DiscountCouponDao;
import com.yuhan.entities.DiscountCoupon;
import com.yuhan.service.DiscountCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DiscountCouponServiceImpl implements DiscountCouponService {

    @Autowired
    DiscountCouponDao discountCouponDao;
    @Override
    public List<DiscountCoupon> list(int user_id) {
        return discountCouponDao.list(user_id);
    }

    @Override
    public int addDiscountCoupon(int user_id, int discountCoupon_id) {
        return discountCouponDao.addDiscountCoupon(user_id,discountCoupon_id);
    }

    @Override
    public List<DiscountCoupon> newDiscountCouponList(String type) {
        return discountCouponDao.newDiscountCouponList(type);
    }
}

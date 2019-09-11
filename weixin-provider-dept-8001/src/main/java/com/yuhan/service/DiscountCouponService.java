package com.yuhan.service;

import com.yuhan.entities.DiscountCoupon;

import java.util.List;

public interface DiscountCouponService {
    public List<DiscountCoupon> list(int user_id);
    public int addDiscountCoupon(int user_id,int discountCoupon_id);
    public List<DiscountCoupon> newDiscountCouponList(String type);
}

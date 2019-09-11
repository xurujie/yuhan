package com.yuhan.dao;

import com.yuhan.entities.DiscountCoupon;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface DiscountCouponDao {
    public List<DiscountCoupon> list(int user_id);
    public List<DiscountCoupon> newDiscountCouponList(String type);
    public int addDiscountCoupon(int user_id,int discountCoupon_id);
}

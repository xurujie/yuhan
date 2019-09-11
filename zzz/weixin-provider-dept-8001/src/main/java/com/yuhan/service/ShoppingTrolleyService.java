package com.yuhan.service;

import com.yuhan.entities.ShoppingTrolley;

import java.util.List;

public interface ShoppingTrolleyService {

    public List<ShoppingTrolley> findByUserId(int userId);
    public int addShoppingTrolley(ShoppingTrolley shoppingTrolley);
    public int deleteShoppingTrolley(int user_id,int merchandise_id);
    public int updateShoppingTrolley(int user_id,int merchandise_id,int merchandise_sum);
}

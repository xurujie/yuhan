package com.yuhan.dao;

import com.yuhan.entities.ShoppingTrolley;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShoppingTrolleyDao {
    public List<ShoppingTrolley> findByUserId(int userId);
   public int addShoppingTrolley(ShoppingTrolley shoppingTrolley);
   public int deleteShoppingTrolley(int user_id,int merchandise_id);
   public int updateShoppingTrolley(int user_id,int merchandise_id,int merchandise_sum);
}

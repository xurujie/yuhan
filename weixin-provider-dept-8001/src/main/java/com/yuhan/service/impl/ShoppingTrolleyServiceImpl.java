package com.yuhan.service.impl;

import com.yuhan.dao.ShoppingTrolleyDao;
import com.yuhan.entities.ShoppingTrolley;
import com.yuhan.service.ShoppingTrolleyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShoppingTrolleyServiceImpl implements ShoppingTrolleyService {

    @Autowired
    ShoppingTrolleyDao shoppingTrolleyDao;

    @Override
    public List<ShoppingTrolley> findByUserId(int userId) {
        return shoppingTrolleyDao.findByUserId(userId);
    }

    @Override
    public int addShoppingTrolley(ShoppingTrolley shoppingTrolley) {
        return shoppingTrolleyDao.addShoppingTrolley(shoppingTrolley);
    }

    @Override
    public int deleteShoppingTrolley(int user_id, int merchandise_id) {
        return shoppingTrolleyDao.deleteShoppingTrolley(user_id,merchandise_id);
    }

    @Override
    public int updateShoppingTrolley(int user_id, int merchandise_id,int merchandise_sum) {
        return shoppingTrolleyDao.updateShoppingTrolley(user_id,merchandise_id,merchandise_sum);
    }
}

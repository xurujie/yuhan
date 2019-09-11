package com.yuhan.dao;

import com.yuhan.entities.Vip;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface VipDao {
public  int addVip(Vip  vip);
    public  int deleteVip(Vip  vip);
    public  int updateVip(Vip  vip);
    public  Vip findByUserId(Vip  vip);

}

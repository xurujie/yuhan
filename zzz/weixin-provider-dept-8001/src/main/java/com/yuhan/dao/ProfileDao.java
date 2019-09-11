package com.yuhan.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yuhan.entities.Profile;

import java.util.List;

@Mapper
public interface ProfileDao {
public Profile findByOrderListId(int Order_id);
    public List<Profile>    findByUserId(int user_id);
}

package com.yuhan.dao;


import com.yuhan.entities.SignIn;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SignInDao {
    public SignIn findByUserId(int user_id);
    public void  updateDay(SignIn signIn);
}

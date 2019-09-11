package com.yuhan.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yuhan.entities.UserInformation;

@Mapper
public interface UserInformationDao {
	public void updateUser(UserInformation userInformation);
	public UserInformation findById(int id);
	public UserInformation findByUserPassWord(String user,String password);
	public void addUser(String user_name,String pass_word,String date,String tel);
}

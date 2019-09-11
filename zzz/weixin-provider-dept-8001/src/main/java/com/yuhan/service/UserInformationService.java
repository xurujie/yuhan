package com.yuhan.service;

import com.yuhan.entities.UserInformation;

public interface UserInformationService {
	public UserInformation findById(int id);
	public UserInformation findByUserPassWord(String user,String password);
	public void addUser(String user_name,String pass_word,String tel);
	public void   updateUser(UserInformation userInformation);
}

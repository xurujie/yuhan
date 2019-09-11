package com.yuhan.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuhan.dao.UserInformationDao;
import com.yuhan.entities.UserInformation;
import com.yuhan.service.UserInformationService;
import com.yuhan.util.DateUtil;



@Service
public class UserInformationServiceImpl implements UserInformationService{

	@Autowired
	private UserInformationDao userdao;
	
	@Override
	public UserInformation findById(int id) {	
		return userdao.findById(id);
	}

	@Override
	public UserInformation findByUserPassWord(String user, String password) {
		return userdao.findByUserPassWord(user, password);
	}

	@Override
	public void addUser(String user_name, String pass_word, String tel) {
		String date = DateUtil.formate(new Date(), "yyyy-MM-dd	HH:mm:ss");
		userdao.addUser(user_name, pass_word, date,tel);
	}

	@Override
	public void updateUser(UserInformation userInformation) {
		userdao.updateUser(userInformation);
	}

}

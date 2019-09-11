package com.yuhan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuhan.dao.ProfileDao;
import com.yuhan.entities.Profile;
import com.yuhan.service.ProfileService;

import java.util.List;


@Service
public class ProfileServiceImpl  implements ProfileService{
	@Autowired
	private ProfileDao profileDao;
	@Override
	public Profile findByOrderListId(int Order_id) {

		return profileDao.findByOrderListId(Order_id);
	}

	@Override
	public List<Profile> findByUserId(int user_id) {
		return profileDao.findByUserId(user_id);
	}

}

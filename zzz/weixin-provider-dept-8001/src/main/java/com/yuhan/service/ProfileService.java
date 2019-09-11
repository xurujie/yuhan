package com.yuhan.service;

import com.yuhan.entities.Profile;

import java.util.List;

public interface ProfileService {
	public Profile findByOrderListId(int Order_id);
	public List<Profile> findByUserId(int user_id);
}

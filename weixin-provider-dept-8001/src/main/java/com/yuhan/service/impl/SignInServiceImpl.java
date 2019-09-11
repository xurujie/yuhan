package com.yuhan.service.impl;

import com.yuhan.dao.SignInDao;
import com.yuhan.entities.SignIn;
import com.yuhan.entities.UserInformation;
import com.yuhan.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignInServiceImpl implements SignInService {
    @Autowired
    SignInDao signInDao;
    @Override
    public SignIn findByUserId(int user_id) {
        return signInDao.findByUserId(user_id);
    }

    @Override
    public void updateDay(SignIn signIn) {
        signInDao.updateDay(signIn);
    }


}

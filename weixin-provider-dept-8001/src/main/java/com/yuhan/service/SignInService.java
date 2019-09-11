package com.yuhan.service;

import com.yuhan.entities.SignIn;
import com.yuhan.entities.UserInformation;

public interface SignInService {
    public SignIn findByUserId(int user_id);
    public void updateDay(SignIn signIn);
}

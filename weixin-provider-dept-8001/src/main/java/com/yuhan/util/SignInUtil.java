package com.yuhan.util;

import com.yuhan.entities.SignIn;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class SignInUtil {

    public static SignIn signInAdd(SignIn signIn){
        signIn.setMonday("0");
        signIn.setTuesday("0");
        signIn.setWednesday("0");
        signIn.setThursday("0");
        signIn.setFriday("0");
        signIn.setSaturday("0");
        signIn.setSunday("0");
        signIn.setIntegral("0");
        System.out.println("全部更新方法运行了");
            signIn.setSign_time(new Timestamp(System.currentTimeMillis()));
        return signIn;
    }

    public static SignIn signInAddPart(SignIn signIn){
        signIn.setMonday("0");
        signIn.setTuesday("0");
        signIn.setWednesday("0");
        signIn.setThursday("0");
        signIn.setFriday("0");
        signIn.setSaturday("0");
        signIn.setSunday("0");
        System.out.println("日期更新方法运行了");
        signIn.setSign_time(new Timestamp(Date.parse(DateUtil.formate(new Date(),""))));
        return signIn;
    }

}
